package stratego.pieces;

import stratego.CombatResult;
import stratego.Player;
import stratego.Square;
/**
 * A Miner class belongs to the StepMover class.
 * The Miner class has special characteristics that has been defined in this class.
 * @author 220026989
 * @ version - 1.0
 */
public class Miner extends StepMover {
    /**
     * Constructor method of miner class that invokes the constructor of its parent method.
     * @param owner The player object to which the Miner object is assigned to.
     * @param square The square on which the Miner piece sits on.
     */
    public Miner(Player owner, Square square) {
        super(owner, square, 3);
    }

    @Override
    /**
     * An overriding of the resultWhenAttacking method of the parent class that is defined according to the Miner class characteristics
     * @param targetPiece The piece object that is being attacked by the Miner object
     * @return The CombatResult from Miner attacking the targetPiece
     */
    public CombatResult resultWhenAttacking(Piece targetPiece) {
        if (targetPiece instanceof Bomb || (this.getRank() > targetPiece.getRank())) {
            return CombatResult.WIN;
        } else if (this.getRank() == (targetPiece.getRank())) {
            return CombatResult.DRAW;
        } else if (this.getRank() < targetPiece.getRank()) {
            return CombatResult.LOSE;
        }
        return null;
    }
}
