package com.example.puissance4.hci;

import com.example.puissance4.factory.IPlayerFactory;
import com.example.puissance4.factory.InvalidPlayerTypeException;
import com.example.puissance4.game.Board;
import com.example.puissance4.game.IHumanComputerInterface;
import com.example.puissance4.game.IPlayer;
import com.example.puissance4.game.Table;
import org.springframework.stereotype.Component;

import java.util.InputMismatchException;

@Component
public class HumanComputerInterface implements IHumanComputerInterface{
    private IPlayerFactory playerFactory;
    private IInput in;
    private IOutput out;

    // TODO: maybe transfer the input mismatch errors to the console class
    public HumanComputerInterface(IPlayerFactory playerFactory, IInput in, IOutput out) {
        this.playerFactory = playerFactory;
        this.in = in;
        this.out = out;
    }

    @Override
    public IPlayer[] initGame(){
        out.welcome();
        for (int i = 0; i< Table.NB_JOUEURS; i++) {
            String name;

            out.askPlayerName();
            name = in.retrievePlayerName();


            out.askPlayerType();
            boolean validChoice = false;
            int choice;
            while (!validChoice) {
                try {
                    choice = in.retrievePlayerType();
                    validChoice = choice == 1 || choice == 2;
                    playerFactory.createPlayer(choice, name);
                } catch (InputMismatchException e) {
                    out.alertInvalidNumber();
                } catch (InvalidPlayerTypeException e) {
                    out.alertInvalidPlayerType();
                }
            }
        }
        return this.playerFactory.getPlayers();
    }

    @Override
    public void finishGame(IPlayer winner, Board board) {
        showBoard(board);
        if (winner == null) {
            out.announceDraw();
        } else {
            out.announceVictory(winner.getName());
        }
        out.goodbye();
    }

    @Override
    public void showBoard(Board board) {
        out.displayBoard(board.toString());
    }
}
