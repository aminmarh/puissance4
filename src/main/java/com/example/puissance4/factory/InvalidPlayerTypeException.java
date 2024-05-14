package com.example.puissance4.factory;

/**
 * Custom exception class to handle scenarios where an invalid player type is specified.
 * This exception is thrown when an attempt is made to create a player with a type that
 * is not recognized or supported by the system.
 */
public class InvalidPlayerTypeException extends Exception {

    /**
     * Constructor for InvalidPlayerTypeException.
     * Initializes a new instance of this exception with a predefined message indicating
     * that an invalid player type has been encountered.
     */
    public InvalidPlayerTypeException() {
        super("Invalid player type");
    }
}
