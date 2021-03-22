package Chess;

import BoardGame.Board;
import BoardGame.Piece;
import BoardGame.Position;
import Chess.Enum.Color;
import Chess.Pieces.King;
import Chess.Pieces.Rook;

public class ChessMatch {
    
    private BoardGame.Board Board;


    public ChessMatch() {
        this.Board = new Board(8, 8);
        initialSetup();
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

    public ChessPiece performChessMove(ChessPosition sourcePosition, ChessPosition targetPosition) {
        Position source = sourcePosition.toPosition();
        Position target = targetPosition.toPosition();
        validateSourcePosition(source);
        Piece capturedPiece = makeMove(source, target);
        return (ChessPiece)capturedPiece;
    }

    private void validateSourcePosition(Position position) {
        if(!Board.thereIsAPiece(position))
            throw new ChessException("There is a piece on source position.");
    }

    private Piece makeMove(Position source, Position target) {
        Piece p = Board.removePiece(source);
        Piece capturedPiece = Board.removePiece(target);
        Board.placePiece(p, target);
        return capturedPiece;
    }

    private void placeNewPiece(char column, int row, ChessPiece piece) {
        Board.placePiece(piece, new ChessPosition(column, row).toPosition());
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
