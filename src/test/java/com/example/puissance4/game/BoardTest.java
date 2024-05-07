package com.example.puissance4.game;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {

    private Board board;

    @BeforeEach
    void setUpBoard() {
        this.board = new Board();
    }

    @Test
    void testToString() {
        String expected = """
                | | | | | | | |
                | | | | | | | |
                | | | | | | | |
                | | | | | | | |
                | | | | | | | |
                | | | | | | | |
                """;
        assertEquals(expected, board.toString());
    }

    @Test
    void testPutToken() {
        try {
            board.putToken(0, Token.Red);
        } catch (InvalidMoveException e) {
            fail("Invalid move");
        }
        assertEquals(Token.Red, board.getBoard()[Board.ROWS - 1][0]);
    }

    @Test
    void testIsFull() {
        for (int i = 0; i < Board.COLUMNS; i++) {
            for (int j = 0; j < Board.ROWS; j++) {
                try {
                    board.putToken(i, Token.Red);
                } catch (InvalidMoveException e) {
                    fail("Invalid move");
                }
            }
        }
        assertTrue(board.isFull());
    }

    @Test
    void testIsWinned() {
        for (int i = 0; i < 4; i++) {
            try {
                board.putToken(i, Token.Red);
            } catch (InvalidMoveException e) {
                fail("Invalid move");
            }
        }
        assertTrue(board.isWon());
    }

    @Test
    void testIsMoveValid() {
        assertTrue(board.isMoveValid(0));
        assertTrue(board.isMoveValid(6));
        assertFalse(board.isMoveValid(7));
        for (int i = 0; i < 6; i++) {
            try {
                board.putToken(1, Token.Red);
            } catch (InvalidMoveException e) {
                fail("Invalid move");
            }
        }
        assertFalse(board.isMoveValid(1));
    }

    /**
     * Tests if the `canWinInNextMove` method correctly identifies a winning scenario.
     * This test checks the method's ability to predict a win when a token is placed in a specific column
     * that would complete a sequence of four consecutive tokens, resulting in a win.
     */
    @Test
    void testCanWinInNextMoveWinScenario() {
        try {
            // Setup the board with three consecutive Red tokens
            board.putToken(0, Token.Red);
            board.putToken(1, Token.Red);
            board.putToken(2, Token.Red);
            // Check if placing a fourth Red token results in a win
            assertTrue(board.canWinInNextMove(3, Token.Red), "AI should detect a winning move");
        } catch (InvalidMoveException e) {
            fail("Invalid move during setup of win scenario");
        }
    }

    /**
     * Tests if the `canWinInNextMove` method correctly identifies a non-winning scenario.
     * This test verifies whether the method can accurately determine when a move does not result in a win,
     * even if it's placed next to other tokens of the same type.
     */
    @Test
    void testCanWinInNextMoveNoWinScenario() {
        try {
            // Setup the board with two non-consecutive Red tokens
            board.putToken(0, Token.Red);
            board.putToken(1, Token.Red);
            // Verify that placing another Red token in a non-winning column does not falsely report a win
            assertFalse(board.canWinInNextMove(3, Token.Red), "AI should correctly identify no win scenario");
        } catch (InvalidMoveException e) {
            fail("Invalid move during setup of no win scenario");
        }
    }

}