package com.example.puissance4.savegame;

import com.example.puissance4.factory.IPlayerFactory;
import com.example.puissance4.game.Board;
import com.example.puissance4.game.IPlayer;
import com.example.puissance4.game.Table;
import com.example.puissance4.game.Token;
import com.example.puissance4.player.AI;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class SaveTest {

    @Mock
    private Table table;

    @Mock
    private IPlayerFactory playerFactory;

    private Save save;

    private static final String FILE_PATH = "save.json";

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        // make table return a new board when getBoard is called
        when(table.getBoard()).thenReturn(new Board());
        // make table return a new array of players when getPlayers is called
        when(table.getPlayers()).thenReturn(new IPlayer[] {new AI("ai1", Token.Red), new AI("ai2", Token.Yellow)});
        // make factory return 2 players when getPlayers is called
        when(playerFactory.getPlayers()).thenReturn(new IPlayer[] {new AI("ai1", Token.Red), new AI("ai2", Token.Yellow)});
        save = new Save(table, playerFactory);
    }

    @Test
    void loadGameTest() {
        save.saveGame();
        save.loadGame();
        verify(table).setBoard(any(Board.class));
        verify(table).setPlayers(any(IPlayer[].class));
    }

    @Test
    void isSavedGameTest() {
        // Given
        Path path = Paths.get(FILE_PATH);
        try {
            if (!Files.exists(path)) {
                Files.createFile(path);
            }
        } catch (IOException e) {
            Logger.getAnonymousLogger().severe(e.getMessage());
        }

        // When
        boolean result = save.isSavedGame();

        // Then
        assertTrue(result);
    }

    @Test
    void isSavedGameNegativeTest() {
        // Given
        try {
            Files.deleteIfExists(Paths.get(FILE_PATH));
        } catch (IOException e) {
            Logger.getAnonymousLogger().severe(e.getMessage());
        }

        // When
        boolean result = save.isSavedGame();

        // Then
        assertFalse(result);
    }

    @Test
    void deleteSavedGameTest() {
        // Given
        Path path = Paths.get(FILE_PATH);
        try {
            if (!Files.exists(path)) {
                Files.createFile(path);
            }
        } catch (IOException e) {
            Logger.getAnonymousLogger().severe(e.getMessage());
        }

        // When
        save.deleteSavedGame();

        // Then
        assertFalse(Files.exists(path));
    }
}