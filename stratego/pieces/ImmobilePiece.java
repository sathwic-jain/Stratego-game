package stratego.pieces;
import java.util.List;
import java.util.ArrayList;

import stratego.Player;
import stratego.Square;
/**
 * An ImmobilePiece class inherits from the Piece class and has characteristics of a piece that cannot move.
 * The crucial characteristics of ImmobilePieces are defined in this class.
 * @author 220026989
 * @ version - 1.0
 */
public abstract class ImmobilePiece extends Piece {
    /**
     * A constructor method that invokes the constructor of it's parent.
     * @param owner The player object to which the immobile piece belongs to.
     * @param square The square object to which the immobile piece belongs to.
     * @param rank The rank of the immobile piece
     */
    public ImmobilePiece(Player owner, Square square, int rank) {
        super(owner, square, rank);
    }
    /**
     * Overloading the constructor to incorporate the immobile piece objects that does not have a rank.
     * @param owner The player object to which the immobile piece belongs to.
     * @param square The square object to which the immobile piece belongs to.
     */
    public ImmobilePiece(Player owner, Square square) {
        super(owner, square);
    }
    @Override
    /**
     * Overriding the getLegalAttacks method according to the characteristics of the immobile piece.
     * @return List of squares that contains the squares that can be attacked by the given piece.
     */
    public List<Square> getLegalAttacks() {
        List<Square> legalAttacks = new ArrayList<>();
        return legalAttacks;
    }
    @Override
    /**
     * Overriding the getLegalMoves method according to the characteristics of the immobile piece.
     * @return List of squares that contains the squares to which the given piece can move to.
     */
    public List<Square> getLegalMoves() {
        List<Square> legalMoves = new ArrayList<>();
        return legalMoves;
    }
}
