package Chess.Pieces;

import Chess.ChessMatch;
import Chess.ChessPiece;
import Chess.Enum.Color;
import BoardGame.Board;
import BoardGame.Position;

public class King extends ChessPiece {

    private ChessMatch chessMatch;

    public King(Board board, Color color, ChessMatch chessMatch) {
        super(board, color);
        this.chessMatch = chessMatch;
    }
    
    @Override
    public String toString() {
        return "K";
    }

    private boolean canMove(Position position) {
        ChessPiece p = (ChessPiece) getBoard().piece(position);
        return p == null || p.getColor() != getColor();
    }

    private boolean testRookCastling(Position position) {
        ChessPiece p = (ChessPiece) getBoard().piece(position);
        return p != null && p instanceof Rook && p.getColor() == getColor() && p.getMoveCount() == 0;
    }
  
    @Override
    public boolean[][] possibleMoves() {
        boolean[][] table = new boolean[getBoard().getRows()][getBoard().getColumns()];

        Position p = new Position(0, 0);

        
        // North
        p.setValues(Position.getRow() - 1, Position.getColumn());
        if(getBoard().positionExists(p) && canMove(p)) {
            table[p.getRow()][p.getColumn()] = true;
        }
        
        //NW
        p.setValues(Position.getRow() - 1, Position.getColumn() - 1);
        if(getBoard().positionExists(p) && canMove(p)) {
            table[p.getRow()][p.getColumn()] = true;
        }

        // West
        p.setValues(Position.getRow(), Position.getColumn() - 1);
        if(getBoard().positionExists(p) && canMove(p)) {
            table[p.getRow()][p.getColumn()] = true;
        }
        
        // South
        p.setValues(Position.getRow() + 1, Position.getColumn());
        if(getBoard().positionExists(p) && canMove(p)) {
            table[p.getRow()][p.getColumn()] = true;
        }

        //SW
        p.setValues(Position.getRow() + 1, Position.getColumn() - 1);
        if(getBoard().positionExists(p) && canMove(p)) {
            table[p.getRow()][p.getColumn()] = true;
        }

        //SE
        p.setValues(Position.getRow() + 1, Position.getColumn() + 1);
        if(getBoard().positionExists(p) && canMove(p)) {
            table[p.getRow()][p.getColumn()] = true;
        }

        // East
        p.setValues(Position.getRow(), Position.getColumn() + 1);
        if(getBoard().positionExists(p) && canMove(p)) {
            table[p.getRow()][p.getColumn()] = true;
        }
        
        //NE
        p.setValues(Position.getRow() - 1, Position.getColumn() + 1);
        if(getBoard().positionExists(p) && canMove(p)) {
            table[p.getRow()][p.getColumn()] = true;
        }

        //Castling
        if(getMoveCount() == 0 && !chessMatch.getCheck()) {
            //Little Rokkie Kingside
            Position posT1 = new Position(Position.getRow(), Position.getColumn() + 3);
            if(testRookCastling(posT1)) {
                Position p1 = new Position(Position.getRow(), Position.getColumn() + 1);
                Position p2 = new Position(Position.getRow(), Position.getColumn() + 2);
                if(getBoard().piece(p1) == null && getBoard().piece(p2) == null) {
                    table[Position.getRow()][Position.getColumn() + 2] = true;
                }
            }
        }

        if(getMoveCount() == 0 && !chessMatch.getCheck()) {
            //Big Rokkie Queenside
            Position posT2 = new Position(Position.getRow(), Position.getColumn() - 4);
            if(testRookCastling(posT2)) {
                Position p1 = new Position(Position.getRow(), Position.getColumn() - 1);
                Position p2 = new Position(Position.getRow(), Position.getColumn() - 2);
                Position p3 = new Position(Position.getRow(), Position.getColumn() - 3);
                if(getBoard().piece(p1) == null && getBoard().piece(p2) == null && getBoard().piece(p3) == null) {
                    table[Position.getRow()][Position.getColumn() - 2] = true;
                }
            }
        }

        return table;
    }
}
