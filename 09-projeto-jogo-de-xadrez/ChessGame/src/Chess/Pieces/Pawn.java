package Chess.Pieces;

import Chess.ChessPiece;
import BoardGame.Position;
import Chess.Enum.Color;

public class Pawn extends ChessPiece
{

    public Pawn(BoardGame.Board board, Color color) {
        super(board, color);
    }

    @Override
    public String toString() {
        return "P";
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] table = new boolean[getBoard().getRows()][getBoard().getColumns()];
        Position p = new Position(0, 0);

        if(getColor() == Chess.Enum.Color.WHITE)
        {
            p.setValues(Position.getRow() - 1, Position.getColumn());
            if(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
                table[p.getRow()][p.getColumn()] = true;
            }

            p.setValues(Position.getRow() - 2, Position.getColumn());
            Position p2 = new Position(Position.getRow() - 1, Position.getColumn());
            if(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p) && getMoveCount() == 0
                && getBoard().positionExists(p2) && !getBoard().thereIsAPiece(p2)) {
                table[p.getRow()][p.getColumn()] = true;
            }

            p.setValues(Position.getRow() - 1, Position.getColumn() - 1);
            if(getBoard().positionExists(p) && isThereOpponentPiece(p)) {
                table[p.getRow()][p.getColumn()] = true;
            }

            p.setValues(Position.getRow() - 1, Position.getColumn() + 1);
            if(getBoard().positionExists(p) && isThereOpponentPiece(p)) {
                table[p.getRow()][p.getColumn()] = true;
            }
        } else {
            p.setValues(Position.getRow() + 1, Position.getColumn());
            if(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
                table[p.getRow()][p.getColumn()] = true;
            }

            p.setValues(Position.getRow() + 2, Position.getColumn());
            Position p2 = new Position(Position.getRow() + 1, Position.getColumn());
            if(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p) && getMoveCount() == 0
                && getBoard().positionExists(p2) && !getBoard().thereIsAPiece(p2)) {
                table[p.getRow()][p.getColumn()] = true;
            }

            p.setValues(Position.getRow() + 1, Position.getColumn() - 1);
            if(getBoard().positionExists(p) && isThereOpponentPiece(p)) {
                table[p.getRow()][p.getColumn()] = true;
            }

            p.setValues(Position.getRow() + 1, Position.getColumn() + 1);
            if(getBoard().positionExists(p) && isThereOpponentPiece(p)) {
                table[p.getRow()][p.getColumn()] = true;
            }
        }

        return table;
    }
}