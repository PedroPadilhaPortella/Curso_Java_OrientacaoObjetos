package Chess;

import BoardGame.Piece;
import BoardGame.Board;
import BoardGame.Position;
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

    protected boolean isThereOpponentPiece(Position position) {
        ChessPiece p = (ChessPiece) getBoard().piece(position);
        return p != null && p.getColor() != Color;
    }
}
