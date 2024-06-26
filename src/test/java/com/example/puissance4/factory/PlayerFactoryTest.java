package com.example.puissance4.factory;

import com.example.puissance4.factory.InvalidPlayerTypeException;
import com.example.puissance4.factory.PlayerFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.example.puissance4.player.AI;
import com.example.puissance4.player.Human;

import static org.junit.jupiter.api.Assertions.*;

class PlayerFactoryTest {
    private PlayerFactory playerFactory;

    @BeforeEach
    void setUpTest() {
        this.playerFactory = new PlayerFactory(null);
    }

    @Test
    void createAndGetPlayersTest() {
        try {
            playerFactory.createPlayer(1, "Player");
            playerFactory.createPlayer(2,"Computer");
        } catch (InvalidPlayerTypeException e) {
            throw new RuntimeException(e);
        }
        assertEquals(Human.class, playerFactory.getPlayers()[0].getClass());
        assertEquals(AI.class, playerFactory.getPlayers()[1].getClass());
    }

    @Test
    void invalidPlayerTypeExceptionThrownTest() {
        try {
            playerFactory.createPlayer(1, "Player");
        } catch (InvalidPlayerTypeException e) {
            throw new RuntimeException(e);
        }
        assertThrows(InvalidPlayerTypeException.class, () -> {
            playerFactory.createPlayer(3, "Bad Player");
        });
        try {
            playerFactory.createPlayer(2, "Player");
        } catch (InvalidPlayerTypeException e) {
            throw new RuntimeException(e);
        }
        assertEquals(Human.class, playerFactory.getPlayers()[0].getClass());
        assertEquals(AI.class, playerFactory.getPlayers()[1].getClass());
    }

    @Test
    void resetPlayerTest(){
        try {
            playerFactory.createPlayer(1, "Player");
        } catch (InvalidPlayerTypeException e) {
            throw new RuntimeException(e);
        }
        playerFactory.resetPlayers();
        assertNull(playerFactory.getPlayers()[0]);
    }
}