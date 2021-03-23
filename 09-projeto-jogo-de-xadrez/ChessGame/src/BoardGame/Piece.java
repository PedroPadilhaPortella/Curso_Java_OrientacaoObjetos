package BoardGame;

public abstract class Piece {

    protected Position Position;
    private Board Board;

    public Piece(Board board) {
        this.Position = null;
        this.Board = board;
    }

    protected Board getBoard() {
        return this.Board;
    }

    public abstract boolean[][] possibleMoves();

    //Hook Method, faz um gancho na subclasse por meio de um metodo abstrato.
    public boolean possibleMove(Position position) {
        return possibleMoves()[position.getRow()][position.getColumn()]; 
    }

    public boolean isThereAnyPossibleMove() {
        boolean[][] table = possibleMoves();
        
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[i].length; j++) {
                if(table[i][j]) {
                    return true;
                }
            }
        }
        return false;
    }
}