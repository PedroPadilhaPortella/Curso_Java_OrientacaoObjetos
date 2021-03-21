package BoardGame;

public class Position {
 
    private int Row;
    private int Column;

    public Position(int row, int column) {
        this.Row = row;
        this.Column = column;
    }

    public int getRow() {
        return this.Row;
    }

    public void setRow(int Row) {
        this.Row = Row;
    }

    public int getColumn() {
        return this.Column;
    }

    public void setColumn(int Column) {
        this.Column = Column;
    }

    @Override
    public String toString() {
        return Row + ", " + Column;
    }
}