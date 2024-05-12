package com.example.puissance4.game;

/**
 * Defines the interface for interactions between the game logic and the user interface.
 * This interface facilitates the initialization, display, and termination of a game
 * between humans and/or computer players in the Puissance 4 game.
 */
public interface IHumanComputerInterface {

    /**
     * Initializes and starts a new game session, setting up players and game state.
     * This method should handle all necessary setup for a new game including creating players,
     * initializing the board, and any other initial configurations.
     *
     * @return An array of IPlayer representing the players involved in the game, fully initialized and ready to play.
     */
    public IPlayer[] initGame();

    /**
     * Handles the end of the game, performing any necessary cleanup and displaying the game's outcome.
     * This method should be called once the game logic determines that a player has won or the game has ended in a draw.
     *
     * @param winner The player who has won the game, or null if the game ended in a draw.
     * @param board The final state of the game board to be displayed or processed further.
     */
    public void finishGame(IPlayer winner, Board board);

    /**
     * Displays the current state of the game board.
     * This method should visually represent the board in a manner appropriate for the interface being used,
     * whether it's a graphical UI, a web interface, or a console output.
     *
     * @param board The current state of the game board to be displayed.
     */
    public void showBoard(Board board);

    /**
     * Clears the console after every player move.
     */
    void clearConsole();
}
