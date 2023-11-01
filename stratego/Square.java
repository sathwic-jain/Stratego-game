package stratego;

import java.util.Objects;
import stratego.pieces.Piece;
/**
 * A Square class deals with the characteristics of a square.
 * It has methods that deals with the piece that is linked with a given square, it's row, column and the value of whether the square is
 * filled with water or not.
 * @author 220026989
 * @ version - 1.0
 */
public class Square {
    private Game game;
    private int row;
    private int col;
    private boolean isWater;
    private Piece piece;
    /**
     * Constructor of square class.
     * @param game The game to which the square belongs to.
     * @param row The row number for the specific square.
     * @param col The column number for the specific square.
     * @param isWater The boolean value that signifies if the square is occupied with water or not.
     */
    public Square(Game game, int row, int col, boolean isWater) {
        this.game = game;
        this.row = row;
        this.col = col;
        this.isWater = isWater;
    }
    /**
     * A method that places a piece on a square.
     * @param piece The piece that is to be placed in the given square.
     * @throws IllegalArgumentException When the square already has a piece in it.
     */
    public void placePiece(Piece piece) throws IllegalArgumentException {
        if (Objects.nonNull(this.getPiece())) {
            throw new IllegalArgumentException();
        } else {
            this.piece = piece;
        }
    }
    /**
     * A method that removes the piece in the given square.
     */
    public void removePiece() {
       this.piece = null;
    }
    /**
     * A method that returns the game to which the square belongs to.
     * @return Game of the square.
     */
    public Game getGame() {
        return this.game;
    }
    /**
     * A method that returns the piece that has been assigned to the square.
     * @return The piece that exists in the square.
     */
    public Piece getPiece() {
        return this.piece;
    }
    /**
     * A method that returns the row of the square.
     * @return row number that is assigned to the square.
     */
    public int getRow() {
        return this.row;
    }
    /**
     * A method that returns the column to which the square belongs to.
     * @return column number that is assigned to the square.
     */
    public int getCol() {
        return this.col;
    }
    /**
     * A method that checks whether the given(specified) square can be entered or not.
     * @return A boolean value after checking if the square is filled with water or is occupied by another piece.
     */
    public boolean canBeEntered() {
        if (this.isWater) {
            return (!this.isWater);
        } else if (Objects.nonNull(this.getPiece())) {
            return false;
        }
        return true;
    }
    /**
     * A method that checks if the square is filled with water or not.
     * @return A boolean value after checking if the square has water.
     */
    public boolean isWater() {
        return isWater;
    }
    /**
     * A method to set the value of isWater attribute in the square object.
     * @param value A boolean value
     */
    public void setIsWater(boolean value) {
        this.isWater = value;
    }
}
