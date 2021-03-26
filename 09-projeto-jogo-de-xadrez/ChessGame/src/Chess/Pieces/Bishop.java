package Chess.Pieces;

import Chess.ChessPiece;
import BoardGame.Position;

public class Bishop extends ChessPiece
{
    public Bishop(BoardGame.Board board, Chess.Enum.Color color) {
        super(board, color);
    }

    @Override
    public String toString() {
        return "B";
    }

    @Override
    public boolean[][] possibleMoves()
    {
        boolean[][] table = new boolean[getBoard().getRows()][getBoard().getColumns()];

        Position p = new Position(0, 0);

        // NW
        p.setValues(Position.getRow() - 1, Position.getColumn() - 1);
        while(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
            table[p.getRow()][p.getColumn()] = true;
            p.setValues(p.getRow() - 1, p.getColumn() - 1);
        }
        if(getBoard().positionExists(p) && isThereOpponentPiece(p)) {
            table[p.getRow()][p.getColumn()] = true;
        }
        
        // NO
        p.setValues(Position.getRow() - 1, Position.getColumn() + 1);
        while(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
            table[p.getRow()][p.getColumn()] = true;
            p.setValues(p.getRow() - 1, p.getColumn() + 1);
        }
        if(getBoard().positionExists(p) && isThereOpponentPiece(p)) {
            table[p.getRow()][p.getColumn()] = true;
        }
        
        // SW
        p.setValues(Position.getRow() + 1, Position.getColumn() + 1);
        while(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
            table[p.getRow()][p.getColumn()] = true;
            p.setValues(p.getRow() + 1, p.getColumn() + 1);
        }
        if(getBoard().positionExists(p) && isThereOpponentPiece(p)) {
            table[p.getRow()][p.getColumn()] = true;
        }
        
        // SO
        p.setValues(Position.getRow() + 1, Position.getColumn() - 1);
        while(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
            table[p.getRow()][p.getColumn()] = true;
            p.setValues(p.getRow() + 1, p.getColumn() - 1);
        }
        if(getBoard().positionExists(p) && isThereOpponentPiece(p)) {
            table[p.getRow()][p.getColumn()] = true;
        }

        return table;
    }   
}