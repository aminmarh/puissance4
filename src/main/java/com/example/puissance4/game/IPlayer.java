package com.example.puissance4.game;

/**
 * Interface representing a player in the Puissance 4 game.
 * This interface defines the basic responsibilities and actions that any type of player (human or AI) must be able to perform.
 */
public interface IPlayer {

    /**
     * Retrieves the name of the player.
     * This method is used to identify the player within the game, typically in user interfaces and game logs.
     *
     * @return A String representing the player's name.
     */
    public String getName();

    /**
     * Retrieves the token type associated with the player.
     * Each player uses a specific token (e.g., Red or Yellow) to make moves on the game board.
     *
     * @return The Token representing the player's token type.
     */
    public Token getToken();

    /**
     * Executes a move by the player on the given game board.
     * This method encapsulates the player's strategy or interaction logic for making a move during their turn.
     *
     * @param board The game board where the player will make their move.
     */
    public void play(Board board);
}
