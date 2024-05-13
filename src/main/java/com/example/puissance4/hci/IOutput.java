package com.example.puissance4.hci;

/**
 * Defines the interface for output operations in the Puissance 4 game.
 * This interface specifies methods required to communicate game-related information to players,
 * including prompts, alerts, and game status updates.
 */
public interface IOutput {

    /**
     * Displays a welcome message to the user at the start of the game.
     */
    void welcome();

    /**
     * Prompts the player to enter their name, typically used during game setup.
     */
    void askPlayerName();

    /**
     * Prompts the player to select their type (e.g., Human or AI), typically used during player setup.
     */
    void askPlayerType();

    /**
     * Alerts the user when an invalid number has been entered, typically in response to malformed input.
     */
    void alertInvalidNumber();

    /**
     * Alerts the user when an invalid player type has been selected, ensuring only valid options are chosen.
     */
    void alertInvalidPlayerType();

    /**
     * Displays the current state of the game board.
     * @param board The string representation of the game board.
     */
    void displayBoard(String board);

    /**
     * Alerts the user when an invalid column has been selected for a move, typically when the column is full or out of bounds.
     */
    void alertInvalidColumn();

    /**
     * Announces that the game has ended in a draw when no players have won and no further moves are possible.
     */
    void announceDraw();

    /**
     * Announces the victory of a player, displaying their name.
     * @param winner The name of the player who has won the game.
     */
    void announceVictory(String winner);

    /**
     * Displays a goodbye message at the end of the game session, typically used when the game concludes or the player exits.
     */
    void goodbye();

    /**
     * Calls the specified player to make their move, using the player's name for personalization.
     * @param name The name of the player whose turn it is to play.
     */
    void callPlayer(String name);

    /**
     * Displays the main menu with options such as starting a new game or exiting.
     * This method should clearly articulate the choices available to the user and how to select them.
     */
    void showMenu();

    /**
     * Refresh the human computer interface after every player move.
     */
    void refreshInterface();
}
