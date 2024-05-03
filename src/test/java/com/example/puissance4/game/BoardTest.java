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
}