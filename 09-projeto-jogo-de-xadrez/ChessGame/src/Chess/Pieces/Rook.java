package Chess.Pieces;

import Chess.ChessPiece;
import Chess.Enum.Color;
import BoardGame.Board;

public class Rook extends ChessPiece {

    public Rook(Board board, Color color) {
        super(board, color);
    }
    
    @Override
    public String toString() {
        return "R";
    }
}
