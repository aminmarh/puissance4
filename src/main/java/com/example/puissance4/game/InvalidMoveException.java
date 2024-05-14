package com.example.puissance4.game;

/**
 * Exception class for handling errors related to invalid moves in the Puissance 4 game.
 * This exception is thrown when a player attempts to make a move that is not allowed according to the game rules,
 * such as placing a token in a full column or outside the bounds of the game board.
 */
public class InvalidMoveException extends Exception {

    /**
     * Constructs an InvalidMoveException with a default error message.
     * The message "Invalid move" is used to clearly indicate that the error occurred due to an invalid game move.
     */
    public InvalidMoveException() {
        super("Invalid move");
    }
}
