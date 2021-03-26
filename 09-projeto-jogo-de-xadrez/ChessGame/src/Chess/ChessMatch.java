package Chess;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import BoardGame.Board;
import BoardGame.Piece;
import BoardGame.Position;
import Chess.Enum.Color;
import Chess.Pieces.Bishop;
import Chess.Pieces.King;
import Chess.Pieces.Knight;
import Chess.Pieces.Pawn;
import Chess.Pieces.Queen;
import Chess.Pieces.Rook;

public class ChessMatch {

    private BoardGame.Board Board;
    private Color CurrentPlayer;
    private int Turn;
    private boolean Check;
    private boolean CheckMate;

    private List<Piece> piecesOnTheBoard = new ArrayList<>();
    private List<Piece> capturedPieces = new ArrayList<>();

    public ChessMatch() {
        this.Board = new Board(8, 8);
        this.Turn = 1;
        this.CurrentPlayer = Color.WHITE;
        initialSetup();
    }

    public int getTurn() {
        return this.Turn;
    }

    public Color getCurrentPlayer() {
        return this.CurrentPlayer;
    }

    public boolean getCheck() {
        return this.Check;
    }

    public boolean getCheckMate() {
        return this.CheckMate;
    }

    public ChessPiece[][] getPieces() {
        ChessPiece[][] matriz = new ChessPiece[Board.getRows()][Board.getColumns()];
        for (int i = 0; i < Board.getRows(); i++) {
            for (int j = 0; j < Board.getRows(); j++) {
                matriz[i][j] = (ChessPiece) Board.piece(i, j);
            }
        }
        return matriz;
    }

    public boolean[][] possibleMoves(ChessPosition sourcePosition) {
        Position position = sourcePosition.toPosition();
        validateSourcePosition(position);
        return Board.piece(position).possibleMoves();
    }

    public ChessPiece performChessMove(ChessPosition sourcePosition, ChessPosition targetPosition) {
        Position source = sourcePosition.toPosition();
        Position target = targetPosition.toPosition();
        validateSourcePosition(source);
        validateTargetPosition(source, target);
        Piece capturedPiece = makeMove(source, target);

        if (testCheck(CurrentPlayer)) {
            undoMove(source, target, capturedPiece);
            throw new ChessException("You can't put yourself in check.");
        }

        Check = testCheck(opponent(CurrentPlayer)) ? true : false;

        if (testCheckMate(opponent(CurrentPlayer))) {
            CheckMate = true;
        } else {
            nextTurn();
        }

        return (ChessPiece) capturedPiece;
    }

    private void validateSourcePosition(Position position) {
        if (!Board.thereIsAPiece(position))
            throw new ChessException("There is a piece on source position.");

        if (CurrentPlayer != ((ChessPiece) Board.piece(position)).getColor())
            throw new ChessException("The chosen piece is not yours.");

        if (!Board.piece(position).isThereAnyPossibleMove())
            throw new ChessException("There is no possible moves for the chosen piece.");
    }

    private void validateTargetPosition(Position source, Position target) {
        if (!Board.piece(source).possibleMove(target)) {
            throw new ChessException("The chosen piece can't be moved to target position.");
        }
    }

    private void nextTurn() {
        this.Turn++;
        CurrentPlayer = (CurrentPlayer == Color.WHITE) ? Color.BLACK : Color.WHITE;
    }

    private Piece makeMove(Position source, Position target) {
        ChessPiece p = (ChessPiece) Board.removePiece(source);
        p.increaseMoveCount();
        Piece capturedPiece = Board.removePiece(target);
        Board.placePiece(p, target);
        
        if (capturedPiece != null) {
            piecesOnTheBoard.remove(capturedPiece);
            capturedPieces.add(capturedPiece);
        }

        //castling kingside rook
        if(p instanceof King && target.getColumn() == source.getColumn() + 2) {
            Position sourceRook = new Position(source.getRow(), source.getColumn() + 3);
            Position targetRook = new Position(source.getRow(), source.getColumn() + 1);
            ChessPiece rook = (ChessPiece)Board.removePiece(sourceRook);
            Board.placePiece(rook, targetRook);
            rook.increaseMoveCount();
        }
        
        //castling queenside rook
        if(p instanceof King && target.getColumn() == source.getColumn() - 2) {
            Position sourceRook = new Position(source.getRow(), source.getColumn() - 4);
            Position targetRook = new Position(source.getRow(), source.getColumn() - 1);
            ChessPiece rook = (ChessPiece)Board.removePiece(sourceRook);
            Board.placePiece(rook, targetRook);
            rook.increaseMoveCount();
        }

        return capturedPiece;
    }

    public void undoMove(Position source, Position target, Piece capturedPiece) {
        ChessPiece p = (ChessPiece) Board.removePiece(target);
        p.decreaseMoveCount();
        Board.placePiece(p, source);

        if (capturedPiece != null) {
            Board.placePiece(capturedPiece, target);
            capturedPieces.remove(capturedPiece);
            piecesOnTheBoard.add(capturedPiece);
        }

        // undo castling kingside rook
        if(p instanceof King && target.getColumn() == source.getColumn() + 2) {
            Position sourceRook = new Position(source.getRow(), source.getColumn() + 3);
            Position targetRook = new Position(source.getRow(), source.getColumn() + 1);
            ChessPiece rook = (ChessPiece)Board.removePiece(targetRook);
            Board.placePiece(rook, sourceRook);
            rook.decreaseMoveCount();
        }
        
        // undo castling queenside rook
        if(p instanceof King && target.getColumn() == source.getColumn() - 2) {
            Position sourceRook = new Position(source.getRow(), source.getColumn() - 4);
            Position targetRook = new Position(source.getRow(), source.getColumn() - 1);
            ChessPiece rook = (ChessPiece)Board.removePiece(targetRook);
            Board.placePiece(rook, sourceRook);
            rook.decreaseMoveCount();
        }
    }

    private Color opponent(Color color) {
        return (color == Color.WHITE) ? Color.BLACK : Color.WHITE;
    }

    private ChessPiece king(Color color) {
        List<Piece> list = piecesOnTheBoard.stream().filter(piece -> ((ChessPiece) piece).getColor() == color)
                .collect(Collectors.toList());
        for (Piece p : list) {
            if (p instanceof King) {
                return (ChessPiece) p;
            }
        }
        throw new IllegalStateException("There is no " + color + " king on the board.");
    }

    private boolean testCheck(Color color) {
        Position kingPosition = king(color).getChessPosition().toPosition();
        List<Piece> opponentPieces = piecesOnTheBoard.stream()
                .filter(piece -> ((ChessPiece) piece).getColor() == opponent(color)).collect(Collectors.toList());
        for (Piece p : opponentPieces) {
            boolean[][] mat = p.possibleMoves();
            if (mat[kingPosition.getRow()][kingPosition.getColumn()]) {
                return true;
            }
        }
        return false;
    }

    private boolean testCheckMate(Color color) {
        if (!testCheck(color))
            return false;

        List<Piece> pieces = piecesOnTheBoard.stream().filter(piece -> ((ChessPiece) piece).getColor() == color)
                .collect(Collectors.toList());
        for (Piece p : pieces) {
            boolean[][] mat = p.possibleMoves();
            for (int i = 0; i < Board.getRows(); i++) {
                for (int j = 0; j < Board.getColumns(); j++) {
                    if (mat[i][j]) {
                        Position source = ((ChessPiece) p).getChessPosition().toPosition();
                        Position target = new Position(i, j);
                        Piece capturedPiece = makeMove(source, target);
                        boolean testCheck = testCheck(color);
                        undoMove(source, target, capturedPiece);
                        if (!testCheck) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    private void placeNewPiece(char column, int row, ChessPiece piece) {
        Board.placePiece(piece, new ChessPosition(column, row).toPosition());
        piecesOnTheBoard.add(piece);
    }

    private void initialSetup() {
        placeNewPiece('a', 1, new Rook(Board, Color.WHITE));
        placeNewPiece('b', 1, new Knight(Board, Color.WHITE));
        placeNewPiece('c', 1, new Bishop(Board, Color.WHITE));
        placeNewPiece('d', 1, new Queen(Board, Color.WHITE));
        placeNewPiece('e', 1, new King(Board, Color.WHITE, this));
        placeNewPiece('f', 1, new Bishop(Board, Color.WHITE));
        placeNewPiece('g', 1, new Knight(Board, Color.WHITE));
        placeNewPiece('h', 1, new Rook(Board, Color.WHITE));
        placeNewPiece('a', 2, new Pawn(Board, Color.WHITE));
        placeNewPiece('b', 2, new Pawn(Board, Color.WHITE));
        placeNewPiece('c', 2, new Pawn(Board, Color.WHITE));
        placeNewPiece('d', 2, new Pawn(Board, Color.WHITE));
        placeNewPiece('e', 2, new Pawn(Board, Color.WHITE));
        placeNewPiece('f', 2, new Pawn(Board, Color.WHITE));
        placeNewPiece('g', 2, new Pawn(Board, Color.WHITE));
        placeNewPiece('h', 2, new Pawn(Board, Color.WHITE));
        
        placeNewPiece('a', 8, new Rook(Board, Color.BLACK));
        placeNewPiece('b', 8, new Knight(Board, Color.BLACK));
        placeNewPiece('c', 8, new Bishop(Board, Color.BLACK));
        placeNewPiece('d', 8, new Queen(Board, Color.BLACK));
        placeNewPiece('e', 8, new King(Board, Color.BLACK, this));
        placeNewPiece('f', 8, new Bishop(Board, Color.BLACK));
        placeNewPiece('g', 8, new Knight(Board, Color.BLACK));
        placeNewPiece('h', 8, new Rook(Board, Color.BLACK));
        placeNewPiece('a', 7, new Pawn(Board, Color.BLACK));
        placeNewPiece('b', 7, new Pawn(Board, Color.BLACK));
        placeNewPiece('c', 7, new Pawn(Board, Color.BLACK));
        placeNewPiece('d', 7, new Pawn(Board, Color.BLACK));
        placeNewPiece('e', 7, new Pawn(Board, Color.BLACK));
        placeNewPiece('f', 7, new Pawn(Board, Color.BLACK));
        placeNewPiece('g', 7, new Pawn(Board, Color.BLACK));
        placeNewPiece('h', 7, new Pawn(Board, Color.BLACK));
    }
}