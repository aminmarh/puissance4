package com.example.puissance4.savegame;

import com.example.puissance4.factory.IPlayerFactory;
import com.example.puissance4.game.Board;
import com.example.puissance4.game.IPlayer;
import com.example.puissance4.game.Table;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class SaveTest {

    @Mock
    private Table table;

    @Mock
    private IPlayerFactory playerFactory;

    private Save save;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        save = new Save(table, playerFactory);
    }

    @Test
    public void isSavedGame_returnsTrueWhenFileExists() {
        // Given
        try {
            Files.createFile(Paths.get("save.json"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        // When
        boolean result = save.isSavedGame();

        // Then
        assertTrue(result);
    }

    @Test
    public void isSavedGame_returnsFalseWhenFileDoesNotExist() {
        // Given
        try {
            Files.deleteIfExists(Paths.get("save.json"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        // When
        boolean result = save.isSavedGame();

        // Then
        assertFalse(result);
    }

    @Test
    public void deleteSavedGame_deletesFile() {
        // Given
        try {
            Files.createFile(Paths.get("save.json"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        // When
        save.deleteSavedGame();

        // Then
        assertFalse(Files.exists(Paths.get("save.json")));
    }
}