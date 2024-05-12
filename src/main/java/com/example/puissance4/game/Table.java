package com.example.puissance4.game;

import org.springframework.stereotype.Component;

/**
 * Represents the game table for Puissance 4, managing the flow of the game including player turns,
 * board updates, and game completion checks.
 */
@Component
public class Table {
    public static final int NB_JOUEURS = 2;

    private Board board;
    private IPlayer[] players;
    private IHumanComputerInterface gameManager;

    /**
     * Constructs a new game table with the necessary components to manage game play.
     * @param gameManager The interface implementation that handles player interactions and game progression.
     */
    public Table(IHumanComputerInterface gameManager) {
        this.board = new Board();           // Initialize a new game board.
        this.gameManager = gameManager;     // Set the game manager.
    }

    /**
     * Starts and manages the game play loop. Controls the sequence of player turns,
     * checks for game ending conditions, and coordinates with the game manager to handle game events.
     */
    public void play() {
        resetTable();
        this.players = gameManager.initGame();  // Initialize the game and players.

        // Game loop continues until a break condition is met (win or draw).
        while (true) {
            for (IPlayer player : players) {
                gameManager.showBoard(this.board);  // Display the current state of the board.
                player.play(this.board);            // Current player makes a move.

                // Check if the current player's move resulted in a win.
                if (this.board.isWon()) {
                    gameManager.finishGame(player, this.board);  // End the game with a winner.
                    return;  // Exit the game loop.
                }

                // Check if the board is full and no more moves can be made (draw).
                if (this.board.isFull()) {
                    gameManager.finishGame(null, this.board);  // End the game with a draw.
                    return;  // Exit the game loop.
                }
            }
        }
    }

    /**
     * Resets the entire table, including the board and player setup.
     */
    public void resetTable() {
        board.resetBoard();
    }
}
