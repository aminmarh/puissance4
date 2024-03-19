package player;

import game.Token;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IATest {
    private Player ia;
    @BeforeEach
    public void setUp() {
        ia = new IA("IA", Token.Yellow);
    }
    @Test
    void getName() {
        assertEquals("IA", ia.getName());
    }

    @Test
    void getToken() {
        assertEquals(Token.Yellow, ia.getToken());
    }

}