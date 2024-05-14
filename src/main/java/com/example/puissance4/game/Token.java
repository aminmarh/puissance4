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
            return "\u001B[31m" + "R" + "\u001B[0m";
        }
        @Override
        public Token opposite() {
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
            return "\u001B[33m" + "Y" + "\u001B[0m";
        }
        @Override
        public Token opposite() {
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
            return " ";
        }
        @Override
        public Token opposite() {
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
