package Chess;

import BoardGame.Piece;
import BoardGame.Board;
import BoardGame.Position;
import Chess.Enum.Color;

public abstract class ChessPiece extends Piece {
    
    public Color Color;
    private int MoveCount;
    
    public ChessPiece(Board board, Color color) {
        super(board);
        this.Color = color;
    }

    public Color getColor() {
        return this.Color;
    }

    public int getMoveCount() {
        return this.MoveCount;
    }
    
    public void increaseMoveCount() {
        this.MoveCount++;
    }

    public void decreaseMoveCount() {
        this.MoveCount--;
    }

    public ChessPosition getChessPosition() {
        return ChessPosition.fromPosition(Position);
    }

    protected boolean isThereOpponentPiece(Position position) {
        ChessPiece p = (ChessPiece) getBoard().piece(position);
        return p != null && p.getColor() != Color;
    }

}
