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
    public void startGame() {
        this.board = new Board();
        this.players = gameManager.initGame();
        play();
    }

    /**
     * Manages the game play loop, allowing for the continuation of a game that has been paused or interrupted.
     */
    private void play() {
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

    /**
     * Resumes a game that was previously paused or interrupted, allowing the game to continue from its last state.
     */
    public void continueGame() {
        int[] numberOfTokens = new int[NB_JOUEURS];
        for (Token[] row : board.getBoard()) {
            for (Token token : row) {
                if (token != Token.Empty) {
                    numberOfTokens[token.ordinal()]++;
                }
            }
        }
        int lastPlayer = numberOfTokens[0] > numberOfTokens[1] ? 1 : 0;
        if (lastPlayer == 1) {
            IPlayer tmp = players[0];
            players[0] = players[1];
            players[1] = tmp;
        }
        play();
    }

    public IPlayer[] getPlayers() {
        return players;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public void setPlayers(IPlayer[] players) {
        this.players = players;
    }
}
