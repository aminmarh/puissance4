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
        this.gameManager = gameManager;     // Set the game manager.
    }

    /**
     * Starts and manages the game play loop. Controls the sequence of player turns,
     * checks for game ending conditions, and coordinates with the game manager to handle game events.
     */
    public void play() {
        this.board = new Board();
        this.players = gameManager.initGame();


        while (true) {
            for (IPlayer player : players) {
                gameManager.refreshInterface();
                gameManager.showBoard(this.board);
                player.play(this.board);

                if (this.board.isWon()) {
                    gameManager.refreshInterface();
                    gameManager.finishGame(player, this.board);
                    return;
                }

                if (this.board.isFull()) {
                    gameManager.refreshInterface();
                    gameManager.finishGame(null, this.board);
                    return;
                }
            }
        }
    }
}
