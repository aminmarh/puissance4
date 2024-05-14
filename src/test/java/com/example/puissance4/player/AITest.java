package com.example.puissance4.player;

import com.example.puissance4.game.Board;
import com.example.puissance4.game.InvalidMoveException;
import com.example.puissance4.game.Token;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

/**
 * Test class for AI behavior in the Puissance 4 game.
 * Uses Mockito to mock the Board class and tests various strategic decisions the AI might make.
 */
class AITest {
    private AI aiPlayer;
    private Board board;

    /**
     * Set up common test fixtures before each test.
     * Initializes AI with "AI" as its name and Red as its token.
     * Mocks the Board class to simulate different game scenarios.
     */
    @BeforeEach
    void setUpTest() {
        aiPlayer = new AI("AI", Token.Red);
        board = Mockito.mock(Board.class);
    }

    /**
     * Tests AI's behavior when a winning move is available.
     * Ensures the AI selects the winning move when it can win the game with one move.
     */
    @Test
    void testPlayWithWinningMoveAvailable() throws InvalidMoveException {
        when(board.canWinInNextMove(3, Token.Red)).thenReturn(true);
        aiPlayer.play(board);
        Mockito.verify(board).putToken(3, Token.Red);
    }

    /**
     * Tests AI's decision-making when it needs to block an opponent's winning move.
     * Verifies that the AI will place a token to block the opponent's win if it cannot win itself.
     */
    @Test
    void testPlayWithBlockingMoveAvailable() throws InvalidMoveException {
        when(board.canWinInNextMove(Mockito.anyInt(), Mockito.any())).thenReturn(false);
        when(board.canWinInNextMove(2, Token.Yellow)).thenReturn(true);
        when(board.isMoveValid(2)).thenReturn(true);
        aiPlayer.play(board);
        Mockito.verify(board).putToken(2, Token.Red);
    }

    /**
     * Tests AI's behavior when there are no immediate wins or blocks available.
     * Checks that AI defaults to a valid random move in such scenarios.
     */
    @Test
    void testPlayFallbackRandomMove() throws InvalidMoveException {
        when(board.canWinInNextMove(Mockito.anyInt(), Mockito.any())).thenReturn(false);
        when(board.isMoveValid(Mockito.anyInt())).thenReturn(false);
        when(board.isMoveValid(4)).thenReturn(true);
        aiPlayer.play(board);
        Mockito.verify(board).putToken(4, Token.Red);
    }
}
