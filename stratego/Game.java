package stratego;
/**
 * A Game class with the declaration for two players, the maximum height and width of the game board, the squares that contain water.
 * The 2d Square array is already declared when a game object is created.
 * @author 220026989
 * @ version - 1.0
 */
public class Game {
    /** HEIGHT defines the max height of the board. */
    public static final int HEIGHT = 10;
    /** WIDTH defines the max width of the board. */
    public static final int WIDTH = 10;
    /** WATER_ROWS array contains the values of the rows that have water in them.*/
    public static final int[] WATER_ROWS = {4, 5};
    /** WATER_COLS array constains the values of the columns that have water in them.*/
    public static final int[] WATER_COLS = {2, 3, 6, 7};
    private Player p0, p1;
    private Square[][] squares;
    /**
     * Game constructor for the Game class that initializes first player, second player and creates the squares required for the game.
     * The constructor initializes water squares according to the values in water_rows and water_cols.
     * @param p0 First player object.
     * @param p1 Second player object.
     */
    public Game(Player p0, Player p1) {
        this.p0 = p0;
        this.p1 = p1;
        squares = new Square[HEIGHT][WIDTH];
        /*First step for creating the square objects.For loop to create and initializing the squares.*/
        for (int i = 0; i < HEIGHT; i++) {
            for (int j = 0; j < WIDTH; j++) {
                squares[i][j] = new Square(this, i, j, false);
            }
        }
        /*The second step of creating the square objects.The method that can be done in a single step is split into two as to reduce
        time and space complexity*/
        for (int i : WATER_ROWS) {
                for (int j : WATER_COLS) {
                    this.getSquare(i, j).setIsWater(true);
                }
        }
    }
    /**
     * Method that returns the player object.
     * @param playerNumber The player number that is required to which player should be returned.
     * @throws IllegalArgumentException when a playerNumber other than one or two is asked to be found.
     * @return the player object whose playerNumber matches with the method argument.
     */
    public Player getPlayer(int playerNumber) throws IllegalArgumentException {
        if (playerNumber == 0) {
            return p0;
        } else if (playerNumber == 1) {
            return p1;
        } else {
            throw new IllegalArgumentException();
        }
    }
    /**
    *Method that returns the player who has won.
    * @return the player object that has won.
    */
    public Player getWinner() {
        if (p0.hasLost() || p1.hasLost()) {
            if (p1.hasLost()) {
                return p0;
            } else if (p0.hasLost()) {
                return p1;
            }
        }
        return null;
    }
/**
 * Method that returns a square object that matches with the row and column specified through the arguments.
 * @param row The row number to identify the row.
 * @param col The column number to specify the column
 * @return The Square object specified by row and column number
 * @throws IndexOutOfBoundsException Throws an error when the row and column specified are out of bounds.
 */
    public Square getSquare(int row, int col) throws IndexOutOfBoundsException {
        if (row >= HEIGHT || col >= WIDTH || row < 0 || col < 0) {
            throw new IndexOutOfBoundsException();
        }
        return squares[row][col];
    }
}
