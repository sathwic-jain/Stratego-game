package stratego.pieces;

import stratego.Player;
import stratego.Square;
/**
 * A flag class is the most crucial piece in the game and inherits the ImmobilePiece class.
 * The characteristics of the flag Piece is defined in this class.
 * @author 220026989
 * @ version - 1.0
 */
public class Flag extends ImmobilePiece {
    /**
     * A constructor method that calls the constructor of its parent class.
     * @param owner The player object to which the flag object belongs.
     * @param square The square object to which the flag piece will be placed.
     */
    public Flag(Player owner, Square square) {
        super(owner, square);
    }

    @Override
    /**
     * An overridden method that not only removes the square, sets the square to null and also sets the lose value.
     * of the player object to true.
     */
    public void beCaptured() {
        this.getSquare().removePiece();
        this.setSquareToNull();
        this.getOwner().loseGame();
    }
}
