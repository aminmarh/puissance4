package com.example.puissance4.factory;

public class InvalidPlayerTypeException extends Exception {
    public InvalidPlayerTypeException() {
        super("Invalid player type");
    }
}
