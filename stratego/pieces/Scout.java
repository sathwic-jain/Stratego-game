package stratego.pieces;

import java.util.ArrayList;
import java.util.List;

import stratego.Game;
import stratego.Player;
import stratego.Square;
/**
 * A Scout class extends a Piece class and has the characteristic methods for the Scout.
 * The Scout object can move any number of squares(except diagonally) until it meets a square with a piece of water.
 * @author 220026989
 * @ version - 1.0
 */
public class Scout extends Piece {
    private static final int SCOUT_RANK = 2;
    /**
     * Constructor method that invokes the constructor of its parent class(Piece).
     * @param owner The player object to which the the given piece belongs to.
     * @param square The square on which the given piece sits on.
     */
    public Scout(Player owner, Square square) {
        super(owner, square, SCOUT_RANK);
    }

    @Override
    /**
     * Overriding a method from Piece class that finds and returns the squares that a specific piece object can move to.
     * @return The list of Square objects that the a given piece object can move to.
     */
    public List<Square> getLegalMoves() {
        Game game = this.getSquare().getGame();
        List<Square> legalMoves = new ArrayList<>();
        int row = this.getSquare().getRow();
        int col = this.getSquare().getCol();
        for (int i = row - 1; i >= 0; i--) {
            if (game.getSquare(i, col).canBeEntered()) {
                legalMoves.add(game.getSquare(i, col));
            } else {
                break;
            }
        }
        for (int j = col - 1; col >= 0; j--) {
            if (game.getSquare(row, j).canBeEntered()) {
                legalMoves.add(game.getSquare(row, j));
            } else {
                break;
            }
        }

        for (int i = row + 1; i < 10; i++) {
            if (game.getSquare(i, col).canBeEntered()) {
                legalMoves.add(game.getSquare(i, col));
            } else {
                break;
            }
        }
        for (int j = col + 1; col < 10; j++) {
            if (game.getSquare(row, j).canBeEntered()) {
                legalMoves.add(game.getSquare(row, j));
            } else {
                break;
            }
        }
        return legalMoves;
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
            //checking if the squares that can be attacked have any piece(s) of the same owner as the attacker and removing it from the list.
            for (Square i : legalAttacks) {
                if ((i.getPiece().getOwner()).equals(this.getOwner())) {
                    legalAttacks.remove(i);
                } else {
                    continue;
                }
            }
        return legalAttacks;
    }
}

