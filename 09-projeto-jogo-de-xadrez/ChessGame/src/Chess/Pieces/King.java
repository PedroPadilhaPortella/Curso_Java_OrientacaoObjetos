package Chess.Pieces;

import Chess.ChessPiece;
import Chess.Enum.Color;
import BoardGame.Board;

public class King extends ChessPiece {

    public King(Board board, Color color) {
        super(board, color);
    }
    
    @Override
    public String toString() {
        return "K";
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] table = new boolean[getBoard().getRows()][getBoard().getColumns()];
        return table;
    }
}
