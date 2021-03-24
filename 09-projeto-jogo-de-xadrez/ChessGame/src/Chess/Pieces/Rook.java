package Chess.Pieces;

import Chess.ChessPiece;
import Chess.Enum.Color;
import BoardGame.Board;
import BoardGame.Position;

public class Rook extends ChessPiece {

    public Rook(Board board, Color color) {
        super(board, color);
    }
    
    @Override
    public String toString() {
        return "R";
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] table = new boolean[getBoard().getRows()][getBoard().getColumns()];

        Position p = new Position(0, 0);

        // above
        p.setValues(Position.getRow() - 1, Position.getColumn());
        while(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
            table[p.getRow()][p.getColumn()] = true;
            p.setRow(p.getRow() - 1);
        }
        if(getBoard().positionExists(p) && isThereOpponentPiece(p)) {
            table[p.getRow()][p.getColumn()] = true;
        }
        
        // left
        p.setValues(Position.getRow(), Position.getColumn() - 1);
        while(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
            table[p.getRow()][p.getColumn()] = true;
            p.setColumn(p.getColumn() - 1);
        }
        if(getBoard().positionExists(p) && isThereOpponentPiece(p)) {
            table[p.getRow()][p.getColumn()] = true;
        }
        
        // right
        p.setValues(Position.getRow(), Position.getColumn() + 1);
        while(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
            table[p.getRow()][p.getColumn()] = true;
            p.setColumn(p.getColumn() + 1);
        }
        if(getBoard().positionExists(p) && isThereOpponentPiece(p)) {
            table[p.getRow()][p.getColumn()] = true;
        }
        
        // below
        p.setValues(Position.getRow() + 1, Position.getColumn());
        while(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
            table[p.getRow()][p.getColumn()] = true;
            p.setRow(p.getRow() + 1);
        }
        if(getBoard().positionExists(p) && isThereOpponentPiece(p)) {
            table[p.getRow()][p.getColumn()] = true;
        }

        return table;
    }
}
