package stratego.pieces;

import stratego.CombatResult;
import stratego.Player;
import stratego.Square;
/**
 * The Spy class is one of the subclasses of StepMover which inturn inherits from Piece.
 * Since the Spy class is a special piece compared to others, it has an overriden method from the Piece class.
 * @author 220026989
 * @ version - 1.0
 */
public class Spy extends StepMover {
    /**
     * Constructor method that invokes the constructor(Overloaded) of the player class.
     * @param owner The player object to which the given piece belongs to.
     * @param square THe square object on which the gievn piece sits on.
     */
    public Spy(Player owner, Square square) {
        super(owner, square);
    }
    @Override
    /**
     * Overriding a method from Piece class as the subclass Spy has a different attacking system.
     * @return CombatResult is the result of what happens when the Spy object attacks another piece object
     */
    public CombatResult resultWhenAttacking(Piece targetPiece) {
        if (targetPiece.getRank() == MARSHAL_RANK || (this.getRank() > targetPiece.getRank())) {
            return CombatResult.WIN;
        } else if (this.getRank() == (targetPiece.getRank())) {
            return CombatResult.DRAW;
        } else if (this.getRank() < targetPiece.getRank()) {
            return CombatResult.LOSE;
        }
        return null;
    }
}
