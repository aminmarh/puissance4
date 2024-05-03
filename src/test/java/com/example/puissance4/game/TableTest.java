package com.example.puissance4.game;

import com.example.puissance4.player.AI;
import com.example.puissance4.player.Human;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class TableTest {
    private Table table;
    private IHumanComputerInterface gameManager;
    private IPlayer player1;
    private IPlayer player2;

    @BeforeEach
    void setUpTest() {
        gameManager = mock(IHumanComputerInterface.class);
        player1 = mock(Human.class);
        player2 = mock(AI.class);
        when(player1.getToken()).thenReturn(Token.Red);
        when(player2.getToken()).thenReturn(Token.Yellow);
        doAnswer(invocation -> {
            Board board = invocation.getArgument(0);
            board.putToken(0, player1.getToken());
            return null;
        }).when(player1).play(any(Board.class));

        doAnswer(invocation -> {
            Board board = invocation.getArgument(0);
            board.putToken(1, player2.getToken());
            return null;
        }).when(player2).play(any(Board.class));
        when(gameManager.initGame()).thenReturn(new IPlayer[]{player1, player2});
        this.table = new Table(gameManager);
    }

    @Test
    void playTest() {
        table.play();
        verify(gameManager, atLeastOnce()).showBoard(any(Board.class));
        verify(player1, atLeastOnce()).play(any(Board.class));
        verify(player2, atLeastOnce()).play(any(Board.class));
    }
}
