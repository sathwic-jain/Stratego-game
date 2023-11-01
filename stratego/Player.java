package stratego;
/**
 * A Player class contains the details required to define a player of the game.
 * It contains the classes that deals with those details crucial to a player.
 * @author 220026989
 * @ version - 1.0
 */
public class Player {
    private String name;
    private int playerNumber;
    private boolean lost;
    /**
     * Constructor for the player class that initializes the object.
     * @param name Takes a string which is the name of the player.
     * @param playerNumber Takes an integer which is the player number
     * The lost value is set to lost whenever a player object is constructed.
     */
    public Player(String name, int playerNumber) {
        this.name = name;
        this.playerNumber = playerNumber;
        lost = false;
    }
    /**
     * A method that gets the name of the specified player.
     * @return A string which is the player name.
     */
    public String getName() {
        return this.name;
    }
    /**
     * A method that gets the player number.
     * @return An integer value which is the player number.
     */
    public int getPlayerNumber() {
        return this.playerNumber;
    }
    /**
     * A method that sets the lost value to true,signifying that the given player has lost.
     */
    public void loseGame() {
        this.lost = true;
    }
    /**
     * A method that returns the boolean value of lost.
     * @return The boolean value contained in lost.
     */
    public boolean hasLost() {
        return this.lost;
    }
}
