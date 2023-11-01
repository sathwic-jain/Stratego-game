package stratego.pieces;
import java.util.List;

import stratego.CombatResult;
import stratego.Player;
import stratego.Square;
/**
 * The piece class has the definitions of the general characteristics of pieces in the game.
 * Each type of piece inherits from the Piece class.
 * @author 220026989
 * @ version - 1.0
 */
public abstract class Piece {
    private Player owner;
    private Square square;
    private int rank;
    protected static final int MARSHAL_RANK = 10;
    /**
     * Constructor method of the Piece class that initializes the piece object.
     * @param owner The player object to which the piece belongs to.
     * @param square The square object to which the piece belongs to.
     * @param rank The rank of the piece object.
     */
    public Piece(Player owner, Square square, int rank) {
        this.owner = owner;
        this.square = square;
        this.rank = rank;
        square.placePiece(this);
    }
    /**
     * Invoking the overloaded constructor that initializes the piece object without a rank.
     * @param owner The player object to which the piece belongs to.
     * @param square The square object to which the piece belongs to.
     */
    public Piece(Player owner, Square square) {
        this.owner = owner;
        this.square = square;
        square.placePiece(this);
    }
    /**
     * An abstract class getLegalMoves that returns the squares to which the piece moves to.
     * The method is abstract as it is implemented differently
     * @return The list of squares to which the piece can move into.
     */
    public abstract List<Square> getLegalMoves();
    /**
     * An abstract class getLegalAttacks that returns the squares on which the given piece can attack.
     * The method is abstract as it is implemented differently.
     * @return The list of squares on which the piece can attack to.
     */
    public abstract List<Square> getLegalAttacks();
    /**
     * A method that gives the CombatResult when a given piece attacks a targetPiece.
     * @param targetPiece The piece on which the given piece attacks to.
     * @return The combatResult when the given piece(this) attacks the targetPiece.
     */
    public CombatResult resultWhenAttacking(Piece targetPiece) {
        if (targetPiece instanceof Bomb) {
            if (this instanceof Miner) {
                return CombatResult.WIN;
            } else {
                return CombatResult.DRAW;
            }
        } else if (targetPiece instanceof Flag) {
            return CombatResult.WIN;
        } else if (this.getRank() > targetPiece.getRank()) {
            return CombatResult.WIN;
        } else if (this.getRank() < targetPiece.getRank()) {
            return CombatResult.LOSE;
        } else if (this.getRank() == targetPiece.getRank()) {
            return CombatResult.DRAW;
        }
        return null;
    }
    /**
     * A method that acts on the squares and pieces when one given(this) piece attacks a targetPiece.
     * @param targetSquare The piece object on which the given piece object(this) is attacking.
     */
    public void attack(Square targetSquare) {
        if (this.resultWhenAttacking(targetSquare.getPiece()).equals(CombatResult.WIN)) {
            targetSquare.getPiece().beCaptured();
            this.move(targetSquare);
        } else if (this.resultWhenAttacking(targetSquare.getPiece()).equals(CombatResult.LOSE)) {
            this.beCaptured();
        } else if (this.resultWhenAttacking(targetSquare.getPiece()).equals(CombatResult.DRAW)) {
            this.beCaptured();
            targetSquare.getPiece().beCaptured();
        }
    }
    /**
     * The method that moves a given piece object to another square object.
     * @param toSquare The square object to which the piece object moves to.
     */
    public void move(Square toSquare) {
        toSquare.placePiece(this);
        this.square.removePiece();
        this.square = toSquare;
    }
    /**
     * The method that captures a piece.This method removes teh piece from the square and sets it to null.
     */
    public void beCaptured() {
        this.getSquare().removePiece();
        this.square = null;
    }
    /**
     * A method that gets the square object of the given piece.
     * @return Square object on which the piece sits on.
     */
    public Square getSquare() {
        return this.square;
    }
    /**
     * The method that gets the owner of a given piece object.
     * @return The owner object to which the given piece belongs to.
     */
    public Player getOwner() {
        return this.owner;
    }
    /**
     * A method that returns the rank of the given object.
     * @return The rank of the given piece object.
     */
    public int getRank() {
        return this.rank;
    }
    /**
     * A method that sets the square object to null.
     */
    public void setSquareToNull() {
        this.square = null;
    }
}
