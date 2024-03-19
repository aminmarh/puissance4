package player;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import game.Token;
import static org.junit.jupiter.api.Assertions.*;

class HumanTest {
    private Player player;

    @BeforeEach
    public void setUp() {
        player = new Human("Player 1", Token.Red);
    }

    @Test
    void getName() {
        assertEquals("Player 1", player.getName());
    }

    @Test
    void getToken() {
        assertEquals(Token.Red, player.getToken());
    }
}