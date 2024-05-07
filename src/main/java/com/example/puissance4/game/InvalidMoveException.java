package com.example.puissance4.game;

public class InvalidMoveException extends Exception {
    public InvalidMoveException() {
        super("Invalid move");
    }
}
