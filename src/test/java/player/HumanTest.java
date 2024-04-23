package player;

import static org.mockito.Mockito.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import game.Token;
import static org.junit.jupiter.api.Assertions.*;

class HumanTest {
    private Player player = mock(Human.class);

    @BeforeEach
    public void setUpHumanPlayer() {
        when(player.getName()).thenReturn("Player 1");
        when(player.getToken()).thenReturn(Token.Red);
        when(player.play(null)).thenReturn(1);
    }

    @Test
    void getNameTest() {
        assertEquals("Player 1", player.getName());
    }

    @Test
    void getTokenTest() {
        assertEquals(Token.Red, player.getToken());
    }

    @Test
    void humanPlayTest() {
        assertEquals(1, player.play(null));
    }
}