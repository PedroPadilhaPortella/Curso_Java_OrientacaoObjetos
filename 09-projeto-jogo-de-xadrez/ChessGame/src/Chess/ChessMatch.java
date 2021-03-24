package Chess;

import java.util.ArrayList;
import java.util.List;

import BoardGame.Board;
import BoardGame.Piece;
import BoardGame.Position;
import Chess.Enum.Color;
import Chess.Pieces.King;
import Chess.Pieces.Rook;

public class ChessMatch {
    
    private BoardGame.Board Board;
    private Color CurrentPlayer;
    private int Turn;

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

    public ChessPiece[][] getPieces() {
        ChessPiece[][] matriz = new ChessPiece[Board.getRows()][Board.getColumns()];
        for (int i=0; i < Board.getRows(); i++) {
            for (int j=0; j < Board.getRows(); j++) {
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
        nextTurn();
        return (ChessPiece) capturedPiece;
    }

    private void validateSourcePosition(Position position) {
        if(!Board.thereIsAPiece(position))
            throw new ChessException("There is a piece on source position.");
            
        if(CurrentPlayer != ((ChessPiece) Board.piece(position)).getColor())
            throw new ChessException("The chosen piece is not yours.");

        if(!Board.piece(position).isThereAnyPossibleMove())
            throw new ChessException("There is no possible moves for the chosen piece.");
    }

    private void validateTargetPosition(Position source, Position target) {
        if(!Board.piece(source).possibleMove(target)) {
            throw new ChessException("The chosen piece can't be moved to target position.");
        }
    }

    private void nextTurn() {
        this.Turn++;
        CurrentPlayer = (CurrentPlayer == Color.WHITE)? Color.BLACK : Color.WHITE; 
    }

    private Piece makeMove(Position source, Position target) {
        Piece p = Board.removePiece(source);
        Piece capturedPiece = Board.removePiece(target);
        Board.placePiece(p, target);
        if (capturedPiece != null) {
            piecesOnTheBoard.remove(capturedPiece);
            capturedPieces.add(capturedPiece);
        }
        return capturedPiece;
    }

    private void placeNewPiece(char column, int row, ChessPiece piece) {
        Board.placePiece(piece, new ChessPosition(column, row).toPosition());
        piecesOnTheBoard.add(piece);
    }

    private void initialSetup() {
        placeNewPiece('c', 1, new Rook(Board, Color.WHITE));
        placeNewPiece('c', 2, new Rook(Board, Color.WHITE));
        placeNewPiece('d', 2, new Rook(Board, Color.WHITE));
        placeNewPiece('e', 2, new Rook(Board, Color.WHITE));
        placeNewPiece('e', 1, new Rook(Board, Color.WHITE));
        placeNewPiece('d', 1, new King(Board, Color.WHITE));

        placeNewPiece('c', 7, new Rook(Board, Color.BLACK));
        placeNewPiece('c', 8, new Rook(Board, Color.BLACK));
        placeNewPiece('d', 7, new Rook(Board, Color.BLACK));
        placeNewPiece('e', 7, new Rook(Board, Color.BLACK));
        placeNewPiece('e', 8, new Rook(Board, Color.BLACK));
        placeNewPiece('d', 8, new King(Board, Color.BLACK));
    }

}
