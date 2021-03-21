package Chess;

import BoardGame.Board;

public class ChessMatch {
    
    // private int Turn;
    private BoardGame.Board Board;


    public ChessMatch() {
        this.Board = new Board(8, 8);
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

}
