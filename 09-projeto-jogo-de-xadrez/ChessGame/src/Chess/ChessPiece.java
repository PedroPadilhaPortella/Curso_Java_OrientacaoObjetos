package Chess;

import BoardGame.Piece;
import BoardGame.Board;
import Chess.Enum.Color;

public abstract class ChessPiece extends Piece {
    
    public Color Color;
    
    public ChessPiece(Board board, Color color) {
        super(board);
        this.Color = color;
    }

    public Color getColor() {
        return this.Color;
    }
}
