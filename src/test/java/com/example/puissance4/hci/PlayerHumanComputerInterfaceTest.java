package com.example.puissance4.hci;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.InputMismatchException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class PlayerHumanComputerInterfaceTest {
    private PlayerHumanComputerInterface playerHCI;
    private IInput in;
    private IOutput out;

    @BeforeEach
    void setUp() {
        in = mock(IInput.class);
        out = mock(IOutput.class);
        playerHCI = new PlayerHumanComputerInterface(in, out);
    }

    @Test
    void playRoundTest() {
        when(in.retrievePlayerMove()).thenReturn(1);
        int choice = playerHCI.playRound();
        verify(in, times(1)).retrievePlayerMove();
        assertEquals(1, choice);
    }

    @Test
    void playRoundInvalidNumberTest() {
        when(in.retrievePlayerMove()).thenThrow(InputMismatchException.class).thenReturn(1);
        playerHCI.playRound();
        verify(out, times(1)).alertInvalidNumber();
    }

    @Test
    void badMoveTest() {
        playerHCI.badMove();
        verify(out, times(1)).alertInvalidColumn();
    }
}