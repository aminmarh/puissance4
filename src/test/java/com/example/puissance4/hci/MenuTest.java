package com.example.puissance4.hci;

import com.example.puissance4.game.Table;
import com.example.puissance4.savegame.ISave;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Locale;

import static org.mockito.Mockito.*;

class MenuTest {

    private IInput in;
    private IOutput out;
    private Table table;
    private ISave save;
    private Menu menu;

    @BeforeEach
    void setUp() {
        this.in = mock(IInput.class);
        this.out = mock(IOutput.class);
        this.table = mock(Table.class);
        this.save = mock(ISave.class);
        this.menu = new Menu(in, out, table, save);

        when(save.isSavedGame()).thenReturn(true);
    }

    @Test
    void exitApplicationTest() {
        when(in.retrieveMainMenuChoice()).thenReturn(4);

        menu.startApplication();

        verify(out).goodbye();
    }

    @Test
    void changeLanguageTest() {
        when(in.retrieveMainMenuChoice()).thenReturn(3, 4);
        when(in.retrieveLanguage()).thenReturn(2);

        menu.startApplication();

        verify(out).selectLanguage();
        verify(out).setLanguage(Locale.FRENCH);
    }
}