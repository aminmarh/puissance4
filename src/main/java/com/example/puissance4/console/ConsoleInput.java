package com.example.puissance4.console;

import com.example.puissance4.hci.IInput;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * A component responsible for handling console inputs for the game,
 * leveraging Java's Scanner to read input stream data.
 */
@Component
public class ConsoleInput implements IInput {
    private Scanner sc;

    /**
     * Constructor that initializes the Scanner with an input stream.
     *
     * @param in The input stream to read from (usually System.in)
     */
    public ConsoleInput(InputStream in) {
        this.sc = new Scanner(in);
    }

    /**
     * Retrieves the player's name from the console input.
     * The input is expected to be a single line representing the name.
     *
     * @return A trimmed string representing the player's name.
     *         Returns an empty string if no input is available.
     */
    @Override
    public String retrievePlayerName() {
        if (sc.hasNext()) {
            return sc.next().trim();
        } else {
            return "";
        }
    }

    /**
     * Retrieves the player type from the console input.
     * The player type is expected to be an integer where the specifics
     * of the values are defined by the game rules.
     *
     * @return The integer representing the player type.
     */
    @Override
    public int retrievePlayerType() {
        try {
            return sc.nextInt();
        } catch (InputMismatchException e) {
            clearInputBuffer();
            throw new InputMismatchException();
        }
    }

    /**
     * Retrieves the player's move from the console input.
     * This is typically an integer representing a column in the game
     * where the player wants to drop their piece.
     *
     * @return The integer representing the player's move.
     */
    @Override
    public int retrievePlayerMove() {
        try {
            return sc.nextInt();
        } catch (InputMismatchException e) {
            clearInputBuffer();
            throw new InputMismatchException();
        }
    }

    private void clearInputBuffer() {
        if (sc.hasNext()) {
            sc.next();
        }
    }
}
