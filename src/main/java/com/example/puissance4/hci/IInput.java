package com.example.puissance4.hci;

/**
 * Defines the interface for handling input from users in the Puissance 4 game.
 * This interface specifies methods required to retrieve information from players,
 * such as their names, types, and moves during the game.
 */
public interface IInput {

    /**
     * Retrieves the name of a player from input.
     * This method is called to prompt and read the player's name from the input source,
     * typically used during game initialization.
     *
     * @return A String representing the player's name as entered by the user.
     */
    String retrievePlayerName();

    /**
     * Retrieves the type of a player from input.
     * This method is used to read the player's type (e.g., human or AI) from the input source.
     * It is expected to enforce or provide options for the type of players that can be entered.
     *
     * @return An integer representing the type of the player, where different integers correspond to different player types.
     */
    int retrievePlayerType();

    /**
     * Retrieves the next move of a player from input.
     * This method prompts and reads the player's choice of column where they wish to place their token,
     * typically during their turn in the gameplay.
     *
     * @return An integer representing the column index where the player wants to place their token.
     */
    int retrievePlayerMove();
}
