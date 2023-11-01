package stratego.pieces;

import stratego.Player;
import stratego.Square;
/**
 * A Bomb is one of the pieces that inherits from the ImmobilePieces class.
 * @author 220026989
 * @ version - 1.0
 */
public class Bomb extends ImmobilePiece {
    /**
    * A constructor for the Bomb class that calls the constructor of it's parent class.
    * @param owner The player object to which the Bomb object is assigned to.
    * @param square The square on which the Bomb piece sits on.
    */
    public Bomb(Player owner, Square square) {
        super(owner, square);
        }
}
