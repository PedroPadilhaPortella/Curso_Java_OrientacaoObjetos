package Chess.Pieces;

import Chess.ChessMatch;
import Chess.ChessPiece;
import BoardGame.Position;
import Chess.Enum.Color;

public class Pawn extends ChessPiece {
    private ChessMatch chessMatch;

    public Pawn(BoardGame.Board board, Color color, ChessMatch chessMatch) {
        super(board, color);
        this.chessMatch = chessMatch;
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

            //EnPassant White
            if(Position.getRow() == 3) {
                Position left = new Position(Position.getRow(), Position.getColumn() - 1);
                if(getBoard().positionExists(left) && isThereOpponentPiece(left) && getBoard().piece(left) == chessMatch.getEnPassantVulnerable()) {
                    table[left.getRow() - 1][left.getColumn()] = true;
                }
                Position right = new Position(Position.getRow(), Position.getColumn() + 1);
                if(getBoard().positionExists(right) && isThereOpponentPiece(right) && getBoard().piece(right) == chessMatch.getEnPassantVulnerable()) {
                    table[right.getRow() - 1][right.getColumn()] = true;
                }
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

            //EnPassant Black
            if(Position.getRow() == 4) {
                Position left = new Position(Position.getRow(), Position.getColumn() - 1);
                if(getBoard().positionExists(left) && isThereOpponentPiece(left) && getBoard().piece(left) == chessMatch.getEnPassantVulnerable()) {
                    table[left.getRow() + 1][left.getColumn()] = true;
                }
                Position right = new Position(Position.getRow(), Position.getColumn() + 1);
                if(getBoard().positionExists(right) && isThereOpponentPiece(right) && getBoard().piece(right) == chessMatch.getEnPassantVulnerable()) {
                    table[right.getRow() + 1][right.getColumn()] = true;
                }
            }
        }

        return table;
    }
}