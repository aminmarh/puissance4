package player;

import game.Token;
import static org.mockito.Mockito.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AITest {
    private Player player = mock(AI.class);

    @BeforeEach
    public void setUpAIPlayer() {
        when(player.getName()).thenReturn("AI");
        when(player.getToken()).thenReturn(Token.Yellow);
        when(player.play(null)).thenReturn(5);
    }

    @Test
    void getNameTest() {
        assertEquals("AI", player.getName());
    }

    @Test
    void getTokenTest() {
        assertEquals(Token.Yellow, player.getToken());
    }

    @Test
    void AIPlayTest() {
        assertEquals(5, player.play(null));
    }
}