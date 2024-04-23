package game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import player.AI;
import player.Human;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class TableTest {

    private Table table;
    @BeforeEach
    void setUp() {
        IPlayer player1 = mock(Human.class);
        when(player1.getToken()).thenReturn(Token.Red);
        when(player1.play(null)).thenReturn(1);

        IPlayer player2 = mock(AI.class);
        when(player2.getToken()).thenReturn(Token.Yellow);
        when(player2.play(null)).thenReturn(2);

        this.table = new Table(new IPlayer[]{player1, player2});
    }

    @Test
    void play() {
        assertEquals(Token.Red, this.table.play().getToken());
    }
}