package com.example.puissance4.player;

import com.example.puissance4.game.Board;
import com.example.puissance4.game.InvalidMoveException;
import com.example.puissance4.game.Token;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

class HumanTest {
    private Human humanPlayer;
    private IPlayerHumanComputerInterface app;
    private Board board;

    @BeforeEach
    void setUpTest() {
        app = mock(IPlayerHumanComputerInterface.class);
        humanPlayer = new Human("Human", Token.Red, app);
        board = new Board();
    }

    @Test
    void playTest() throws InvalidMoveException {
        when(app.playRound()).thenReturn(1);
        humanPlayer.play(board);
        boolean isMoveMade = false;
        for (int i = 0; i < Board.ROWS; i++) {
            for (int j = 0; j < Board.COLUMNS; j++) {
                if (board.getBoard()[i][j] == Token.Red) {
                    isMoveMade = true;
                    break;
                }
            }
            if (isMoveMade) {
                break;
            }
        }
        assertTrue(isMoveMade);
    }
}