package game;
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
        board.putToken(0, Token.Red);
        assertEquals(Token.Red, board.getBoard()[0][0]);
    }

    @Test
    void testIsFull() {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                board.putToken(j, Token.Red);
            }
        }
        assertTrue(board.isFull());
    }

    @Test
    void testIsWinned() {
        for (int i = 0; i < 4; i++) {
            board.putToken(i, Token.Red);
        }
        assertTrue(board.isWinned());
    }
}