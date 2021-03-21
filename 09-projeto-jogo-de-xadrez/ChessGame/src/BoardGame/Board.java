package BoardGame;

public class Board {
    
    private int Rows;
    private int Columns;
    private Piece[][] Pieces;


    public Board(int rows, int columns) {
        this.Rows = rows;
        this.Columns = columns;
        this.Pieces = new Piece[rows][columns];
    }

    public int getRows() {
        return this.Rows;
    }

    public void setRows(int Rows) {
        this.Rows = Rows;
    }

    public int getColumns() {
        return this.Columns;
    }

    public void setColumns(int Columns) {
        this.Columns = Columns;
    }

    public Piece piece(int row, int column) {
        return Pieces[row][column];
    }    

    public Piece piece(Position position) {
        return Pieces[position.getRow()][position.getColumn()];
    }
}
