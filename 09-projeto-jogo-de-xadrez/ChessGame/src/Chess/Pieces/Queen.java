package Chess.Pieces;

import Chess.ChessPiece;
import BoardGame.Position;

public class Queen extends ChessPiece {

    public Queen(BoardGame.Board board, Chess.Enum.Color color) {
        super(board, color);
    }

    @Override
    public String toString() {
        return "Q";
    }

    @Override
    public boolean[][] possibleMoves()
    {    
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
