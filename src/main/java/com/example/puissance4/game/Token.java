package com.example.puissance4.game;

/**
 * Enum representing the different types of tokens used in Puissance 4 game.
 * This enum defines three types of tokens: Red, Yellow, and Empty. Each token type
 * has its own display characteristics and behavior.
 */
public enum Token {
    /**
     * Red token used by one of the players.
     * It overrides the toString method to return a string with ANSI color codes for red.
     */
    Red {
        @Override
        public String toString() {
            // Returns the Red token representation with ANSI color code for red.
            return "\u001B[31m" + "R" + "\u001B[0m";
        }
        @Override
        public Token opposite() {
            // The opposite of Red is Yellow, typically used by the opponent.
            return Yellow;
        }
    },

    /**
     * Yellow token used by one of the players.
     * It overrides the toString method to return a string with ANSI color codes for yellow.
     */
    Yellow {
        @Override
        public String toString() {
            // Returns the Yellow token representation with ANSI color code for yellow.
            return "\u001B[33m" + "Y" + "\u001B[0m";
        }
        @Override
        public Token opposite() {
            // The opposite of Yellow is Red, typically used by the opponent.
            return Red;
        }
    },

    /**
     * Empty token indicating an unoccupied space on the board.
     * It overrides the toString method to return a single space character.
     */
    Empty {
        @Override
        public String toString() {
            // Returns a space character representing an empty slot in the game board.
            return " ";
        }
        @Override
        public Token opposite() {
            // For an empty token, the opposite is itself as it's a neutral placeholder.
            return Empty;
        }
    };

    /**
     * Abstract method to be implemented by each token type.
     * It returns the opposite token type, usually used to identify the opponent's tokens.
     * @return Token the opposite token.
     */
    public abstract Token opposite();
}
