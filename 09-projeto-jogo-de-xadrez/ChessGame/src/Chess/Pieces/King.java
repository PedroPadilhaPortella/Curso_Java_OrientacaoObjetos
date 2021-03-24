package Chess.Pieces;

import Chess.ChessPiece;
import Chess.Enum.Color;
import BoardGame.Board;
import BoardGame.Position;

public class King extends ChessPiece {

    public King(Board board, Color color) {
        super(board, color);
    }
    
    @Override
    public String toString() {
        return "K";
    }

    private boolean canMove(Position position) {
        ChessPiece p = (ChessPiece) getBoard().piece(position);
        return p == null || p.getColor() != getColor();
    }
  
    @Override
    public boolean[][] possibleMoves() {
        boolean[][] table = new boolean[getBoard().getRows()][getBoard().getColumns()];

        Position p = new Position(0, 0);

        
        // North
        p.setValues(Position.getRow() - 1, Position.getColumn());
        if(getBoard().positionExists(p) && canMove(p)) {
            table[p.getRow()][p.getColumn()] = true;
        }
        
        //NW
        p.setValues(Position.getRow() - 1, Position.getColumn() - 1);
        if(getBoard().positionExists(p) && canMove(p)) {
            table[p.getRow()][p.getColumn()] = true;
        }

        // West
        p.setValues(Position.getRow(), Position.getColumn() - 1);
        if(getBoard().positionExists(p) && canMove(p)) {
            table[p.getRow()][p.getColumn()] = true;
        }
        
        // South
        p.setValues(Position.getRow() + 1, Position.getColumn());
        if(getBoard().positionExists(p) && canMove(p)) {
            table[p.getRow()][p.getColumn()] = true;
        }

        //SW
        p.setValues(Position.getRow() + 1, Position.getColumn() - 1);
        if(getBoard().positionExists(p) && canMove(p)) {
            table[p.getRow()][p.getColumn()] = true;
        }

        //SE
        p.setValues(Position.getRow() + 1, Position.getColumn() + 1);
        if(getBoard().positionExists(p) && canMove(p)) {
            table[p.getRow()][p.getColumn()] = true;
        }

        // East
        p.setValues(Position.getRow(), Position.getColumn() + 1);
        if(getBoard().positionExists(p) && canMove(p)) {
            table[p.getRow()][p.getColumn()] = true;
        }
        
        //NE
        p.setValues(Position.getRow() - 1, Position.getColumn() + 1);
        if(getBoard().positionExists(p) && canMove(p)) {
            table[p.getRow()][p.getColumn()] = true;
        }

        return table;
    }
}
