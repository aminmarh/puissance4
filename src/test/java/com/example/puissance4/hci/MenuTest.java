package com.example.puissance4.hci;

import com.example.puissance4.game.Table;
import com.example.puissance4.savegame.ISave;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.InputMismatchException;

import static org.mockito.Mockito.*;

class MenuTest {
    private IInput input;
    private IOutput output;
    private Table table;
    private ISave save;
    private Menu menu;

    @BeforeEach
    void setUp() {
        input = Mockito.mock(IInput.class);
        output = Mockito.mock(IOutput.class);
        table = Mockito.mock(Table.class);
        save = Mockito.mock(ISave.class);
        menu = new Menu(input, output, table, save);
        when(save.isSavedGame()).thenReturn(false);
    }

    @Test
    void startApplicationWithSavedGameTest() {
        when(input.retrieveMainMenuChoice()).thenReturn(1, 4);
        menu.startApplication();
        verify(output, times(2)).showMenu();
        verify(save).deleteSavedGame();
        verify(table).startGame();
        verify(output).goodbye();
    }

    @Test
    void startApplicationWithoutSavedGameTest() {
        when(input.retrieveMainMenuChoice()).thenReturn(1, 4);
        menu.startApplication();
        verify(output, times(2)).showMenu();
        verify(save).deleteSavedGame();
        verify(table).startGame();
        verify(output).goodbye();
    }

    @Test
    void startApplicationWithInvalidInputTest() {
        when(input.retrieveMainMenuChoice()).thenThrow(new InputMismatchException()).thenReturn(4);
        menu.startApplication();
        verify(output).alertInvalidCharacterMenu();
        verify(output).goodbye();
    }
}