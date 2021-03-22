package BoardGame;

public class Board {
    
    private int Rows;
    private int Columns;
    private Piece[][] Pieces;


    public Board(int rows, int columns) {
        if(rows < 1 || columns < 1) 
            throw new BoardException("Error creating board: there must  be at least 1 row and 1 column.");
        
        this.Rows = rows;
        this.Columns = columns;
        this.Pieces = new Piece[rows][columns];
    }

    public int getRows() {
        return this.Rows;
    }

    public int getColumns() {
        return this.Columns;
    }

    public Piece piece(int row, int column) {
        if(!positionExists(row, column))
            throw new BoardException("Position not on the board.");

        return Pieces[row][column];
    }    
    
    public Piece piece(Position position) {
        if(!positionExists(position.getRow(), position.getColumn()))
            throw new BoardException("Position not on the board.");
        
        return Pieces[position.getRow()][position.getColumn()];
    }

    public void placePiece(Piece piece, Position position) {
        if(thereIsAPiece(position))
            throw new BoardException("There is already a piece on position " + position);
        
        this.Pieces[position.getRow()][position.getColumn()] = piece;
        piece.Position = position;
    }

    public Piece removePiece(Position position) {
        if(!positionExists(position))
            throw new BoardException("Position not on the board.");

        if(piece(position) == null) return null;

        Piece aux = piece(position);
        aux.Position = null;
        Pieces[position.getRow()][position.getColumn()] = null;
        return aux;
    }

    public boolean positionExists(Position position) {
        return positionExists(position.getRow(), position.getColumn());
    }

    private boolean positionExists(int row, int column) {
        return row >= 0 && row < this.Rows && column >= 0 && column < this.Columns;
    }

    public boolean thereIsAPiece(Position position) {
        if(!positionExists(position.getRow(), position.getColumn()))
            throw new BoardException("Position not on the board.");
        
        return piece(position) != null;
    }
}
