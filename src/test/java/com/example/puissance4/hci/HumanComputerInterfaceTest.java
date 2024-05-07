package com.example.puissance4.hci;

import com.example.puissance4.factory.IPlayerFactory;
import com.example.puissance4.factory.InvalidPlayerTypeException;
import com.example.puissance4.game.Board;
import com.example.puissance4.game.IPlayer;
import com.example.puissance4.game.Table;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

class HumanComputerInterfaceTest {
    private HumanComputerInterface hci;
    private IPlayerFactory playerFactory;
    private IInput in;
    private IOutput out;

    @BeforeEach
    void setUp() {
        playerFactory = mock(IPlayerFactory.class);
        in = mock(IInput.class);
        out = mock(IOutput.class);
        hci = new HumanComputerInterface(playerFactory, in, out);
    }

    @Test
    void initGameTest() throws InvalidPlayerTypeException {
        when(in.retrievePlayerName()).thenReturn("Player1");
        when(in.retrievePlayerType()).thenReturn(1);
        hci.initGame();
        verify(out, times(1)).welcome();
        verify(out, times(Table.NB_JOUEURS)).askPlayerName();
        verify(out, times(Table.NB_JOUEURS)).askPlayerType();
        verify(playerFactory, times(Table.NB_JOUEURS)).createPlayer(anyInt(), anyString());
    }

    @Test
    void finishGameTest() {
        IPlayer player = mock(IPlayer.class);
        when(player.getName()).thenReturn("Player1");
        hci.finishGame(player, mock(Board.class));
        verify(out, times(1)).announceVictory(anyString());
        verify(out, times(1)).goodbye();
    }

    @Test
    void showBoardTest() {
        Board board = mock(Board.class);
        when(board.toString()).thenReturn("Board");
        hci.showBoard(board);
        verify(out, times(1)).displayBoard(anyString());
    }
}