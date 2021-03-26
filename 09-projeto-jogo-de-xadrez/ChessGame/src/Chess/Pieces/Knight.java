package Chess.Pieces;

import Chess.ChessPiece;
import BoardGame.Position;

public class Knight extends ChessPiece 
{

    public Knight(BoardGame.Board board, Chess.Enum.Color color) {
        super(board, color);
    }

    @Override
    public String toString() {
        return "N";
    }

    private boolean canMove(Position position) {
        ChessPiece p = (ChessPiece) getBoard().piece(position);
        return p == null || p.getColor() != getColor();
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] table = new boolean[getBoard().getRows()][getBoard().getColumns()];

        Position p = new Position(0, 0);

        p.setValues(Position.getRow() - 1, Position.getColumn() - 2);
        if(getBoard().positionExists(p) && canMove(p)) {
            table[p.getRow()][p.getColumn()] = true;
        }
        
        p.setValues(Position.getRow() - 2, Position.getColumn() - 1);
        if(getBoard().positionExists(p) && canMove(p)) {
            table[p.getRow()][p.getColumn()] = true;
        }

        p.setValues(Position.getRow() - 2, Position.getColumn() + 1);
        if(getBoard().positionExists(p) && canMove(p)) {
            table[p.getRow()][p.getColumn()] = true;
        }
        
        p.setValues(Position.getRow() - 1, Position.getColumn() + 2);
        if(getBoard().positionExists(p) && canMove(p)) {
            table[p.getRow()][p.getColumn()] = true;
        }

        p.setValues(Position.getRow() + 1, Position.getColumn() + 2);
        if(getBoard().positionExists(p) && canMove(p)) {
            table[p.getRow()][p.getColumn()] = true;
        }

        p.setValues(Position.getRow() + 2, Position.getColumn() + 1);
        if(getBoard().positionExists(p) && canMove(p)) {
            table[p.getRow()][p.getColumn()] = true;
        }

        p.setValues(Position.getRow() + 2, Position.getColumn() - 1);
        if(getBoard().positionExists(p) && canMove(p)) {
            table[p.getRow()][p.getColumn()] = true;
        }
        
        p.setValues(Position.getRow() + 1, Position.getColumn() - 2);
        if(getBoard().positionExists(p) && canMove(p)) {
            table[p.getRow()][p.getColumn()] = true;
        }

        return table;
    }
    
}
