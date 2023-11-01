package stratego.pieces;
import java.util.ArrayList;
import java.util.List;

import stratego.Game;
import stratego.Player;
import stratego.Square;
/**
 * A StepMover class extends a Piece class and has the characteristic methods for the StepMover pieces.
 * The StepMover object has a constraint of moving only one square at a time.
 * @author 220026989
 * @ version - 1.0
 */
public class StepMover extends Piece {
    /**
     * Constructor that invokes the constructor of parent class.
     * @param owner The player object that owns the given piece.
     * @param square The square object on which the piece is placed on.
     * @param rank The rank of the given piece.
     */
    public StepMover(Player owner, Square square, int rank) {
        super(owner, square, rank);
    }
    /**
     * Constructor that invokes the overloaded constructor of its parent class.(This does not hace rank attribute).
     * @param owner The player object that owns the given piece.
     * @param square The square object on which the given piece sits on.
     */
    public StepMover(Player owner, Square square) {
        super(owner, square);
    }

    @Override
    /**
     * Overriding a method from Piece class that finds and returns the squares that a specific piece object can attack.
     * @return The list of Square objects that the a given piece object can attack to
     */
    public List<Square> getLegalAttacks() {
        Game game = this.getSquare().getGame();
        List<Square> legalAttacks = new ArrayList<Square>();
        int row = this.getSquare().getRow();
        int col = this.getSquare().getCol();
        for (int j = -1; j <= 1; j = j + 2) {
            if ((row + j < 10 && row + j >= 0) && (game.getSquare(row + j, col).getPiece() != null)) {
                legalAttacks.add(game.getSquare(row + j, col));
            }
            if ((col + j < 10 || col + j >= 0) && (game.getSquare(row, col + j).getPiece() != null))  {
                legalAttacks.add(game.getSquare(row, col + j));
            }
            this.getSquare().getGame();
        }
            //checking if piece belongs to the same owner and removing it from the list if it is.
            for (Square i : legalAttacks) {
                if ((i.getPiece().getOwner()).equals(this.getOwner())) {
                    legalAttacks.remove(i);
                } else {
                    continue;
                }
            }
        return legalAttacks;
    }

    @Override
    /**
     * Overriding a method from the Piece class that finds and returns the squares that a specific piece object can move to.
     * @return The list of Square objects to which the given Piece object can move to.
     */
    public List<Square> getLegalMoves() {
        Game game = this.getSquare().getGame();
        List<Square> legalMoves = new ArrayList<Square>();
        int row = this.getSquare().getRow();
        int col = this.getSquare().getCol();
        //Keeping the column a constant and then checking the rows to see whether the conditions required for the piece object to move are satisfied.
        for (int j = -1; j <= 1; j = j + 2) {
            if ((row + j < 10 && row + j >= 0) && (game.getSquare(row + j, col).canBeEntered() && (game.getSquare(row + j, col).getPiece() == null))) {
                legalMoves.add(game.getSquare(row + j, col));
            } else {
                continue;
            }
        }
        //Keeping the row a constant and then checking the columns to see whether the conditions required for the piece object to move are satisfied.
        for (int j = -1; j <= 1; j = j + 2) {
            if (((col + j < 10 && col + j >= 0) && (game.getSquare(row, col + j).canBeEntered() && (game.getSquare(row, col + j).getPiece() == null))))  {
                legalMoves.add(game.getSquare(row, col + j));
            } else {
                continue;
            }
        }
        return legalMoves;
    }
}
