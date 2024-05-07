package com.example.puissance4.player;

import com.example.puissance4.game.Board;
import com.example.puissance4.game.Token;
import static org.mockito.Mockito.*;

import com.example.puissance4.player.AI;
import com.example.puissance4.player.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AITest {
    private AI aiPlayer;
    private Board board;

    @BeforeEach
    void setUpTest() {
        aiPlayer = new AI("AI", Token.Red);
        board = new Board();
    }

    @Test
    void playTest() {
        aiPlayer.play(board);
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