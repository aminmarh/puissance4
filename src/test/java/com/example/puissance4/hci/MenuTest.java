package com.example.puissance4.hci;

import com.example.puissance4.game.Table;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Locale;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verify;

class MenuTest {
    private IInput input;
    private IOutput output;
    private Table table;
    private Menu menu;

    @BeforeEach
    void setUp() {
        input = mock(IInput.class);
        output = mock(IOutput.class);
        table = mock(Table.class);
        menu = new Menu(input, output, table);
    }

    @Test
    void startApplicationTest() {
        when(input.retrieveMainMenuChoice()).thenReturn(2, 3);
        when(input.retrieveLanguage()).thenReturn(1);

        menu.startApplication();

        verify(output, times(2)).showMenu();
        verify(output).selectLanguage();
        verify(output).setLanguage(Locale.ENGLISH);
        verify(output).goodbye();
    }
}