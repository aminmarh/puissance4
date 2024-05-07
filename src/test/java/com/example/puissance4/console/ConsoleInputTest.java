package com.example.puissance4.console;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.InputMismatchException;

import static org.junit.jupiter.api.Assertions.*;

class ConsoleInputTest {
    private ConsoleInput consoleInput;

    @Test
    void retrievePlayerNameEmptyTest() {
        String input = "";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        consoleInput = new ConsoleInput(in);
        assertEquals("", consoleInput.retrievePlayerName());
    }

    @Test
    void retrievePlayerTypeNotIntegerTest() {
        String input = "notAnInteger\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        consoleInput = new ConsoleInput(in);
        assertThrows(InputMismatchException.class, () -> consoleInput.retrievePlayerType());
    }

    @Test
    void retrievePlayerMoveNotIntegerTest() {
        String input = "notAnInteger\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        consoleInput = new ConsoleInput(in);
        assertThrows(InputMismatchException.class, () -> consoleInput.retrievePlayerMove());
    }

    @Test
    void retrievePlayerTypeNegativeTest() {
        String input = "-1\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        consoleInput = new ConsoleInput(in);
        assertEquals(-1, consoleInput.retrievePlayerType());
    }

    @Test
    void retrievePlayerMoveNegativeTest() {
        String input = "-1\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        consoleInput = new ConsoleInput(in);
        assertEquals(-1, consoleInput.retrievePlayerMove());
    }
}