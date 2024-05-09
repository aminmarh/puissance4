package com.example.puissance4.player;

import com.example.puissance4.game.InvalidMoveException;
import com.example.puissance4.game.Board;
import com.example.puissance4.game.Token;

/**
 * Represents a human player in the Puissance 4 game.
 * This class extends the abstract Player class, implementing the human-specific interaction logic for making moves on the board.
 */
public class Human extends Player {
    private IPlayerHumanComputerInterface app;  // Interface to facilitate human-computer interaction.

    /**
     * Constructs a new Human player with the specified name, token, and interaction interface.
     * @param name The name of the player.
     * @param token The token type that the player will use in the game.
     * @param app The interface that handles human-computer interactions specific to gameplay.
     */
    public Human(String name, Token token, IPlayerHumanComputerInterface app) {
        super(name, token);
        this.app = app;
    }

    /**
     * Executes a move for the human player using the human-computer interaction interface.
     * This method repeatedly prompts the player to make a move until a valid move is made.
     *
     * @param board The game board where the player will make their move.
     */
    @Override
    public void play(Board board) {
        boolean goodMove = false;
        while (!goodMove) {
            try {
                // Attempt to make a move at the column selected by the player.
                // The column index is retrieved through the human-computer interaction interface.
                board.putToken(app.playRound(this.getName()), this.getToken());
                goodMove = true;  // Move was successful, exit the loop.
            } catch (InvalidMoveException e) {
                // If the move is invalid (e.g., the column is full), inform the player and prompt for another attempt.
                app.badMove();
            }
        }
    }
}
