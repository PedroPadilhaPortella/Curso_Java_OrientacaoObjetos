package Chess;

import BoardGame.Position;

public class ChessPosition
{
    private char Column;    
    private int Row;    

    public ChessPosition(char column, int row) {
        if(column < 'a' || column > 'h' || row < 1 || row > 8)
            throw new ChessException("Error instantiating ChessPosition. Valid values are from A1 to H8.");

        this.Column = column;
        this.Row = row;
    }

    public char getColumn() {
        return this.Column;
    }

    public int getRow() {
        return this.Row;
    }

    public Position toPosition() {
        return new Position(8 - Row, Column - 'a');
    }

    protected static ChessPosition fromPosition(Position position) {
        return new ChessPosition((char)('a' - position.getColumn()), 8 - position.getRow());
    }

    @Override
    public String toString() {
        return "" + Column + Row;
    }
}