package BoardGame;

public class Piece {

    protected Position Position;
    private Board Board;

    public Piece(Board board) {
        this.Position = null;
        this.Board = board;
    }

    protected Board getBoard() {
        return this.Board;
    }
}