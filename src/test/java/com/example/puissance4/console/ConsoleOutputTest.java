package com.example.puissance4.console;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.context.MessageSource;

import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.Locale;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class ConsoleOutputTest {
    @Mock
    private MessageSource l10n;
    @Mock
    private OutputStream out;
    private ConsoleOutput consoleOutput;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        consoleOutput = new ConsoleOutput(l10n, out);
    }

    @Test
    void welcomeTest() throws Exception {
        when(l10n.getMessage("welcome_message", null, Locale.ENGLISH)).thenReturn("Welcome to Connect Four game!");
        consoleOutput.welcome();
        verify(out).write("Welcome to Connect Four game!".getBytes(StandardCharsets.UTF_8));
    }

    @Test
    void askPlayerNameTest() throws Exception {
        when(l10n.getMessage("player_name", null, Locale.ENGLISH)).thenReturn("Enter the name of the player.");
        consoleOutput.askPlayerName();
        verify(out).write("Enter the name of the player.".getBytes(StandardCharsets.UTF_8));
    }

    @Test
    void announceVictoryTest() throws Exception {
        String winner = "Player1";
        when(l10n.getMessage("victory_message", new Object[]{winner}, Locale.ENGLISH)).thenReturn(winner + " wins!");
        consoleOutput.announceVictory(winner);
        verify(out).write((winner + " wins!").getBytes(StandardCharsets.UTF_8));
    }
}