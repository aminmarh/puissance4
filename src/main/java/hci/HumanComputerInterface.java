package hci;

import factory.IPlayerFactory;
import factory.InvalidPlayerTypeException;
import game.Board;
import game.IHumanComputerInterface;
import game.IPlayer;
import game.Table;
import org.springframework.stereotype.Component;
import player.IPlayerHumanComputerInterface;
import java.util.InputMismatchException;

@Component
public class HumanComputerInterface implements IHumanComputerInterface, IPlayerHumanComputerInterface {
    private IPlayerFactory playerFactory;
    IInput in;
    IOutput out;

    // TODO: maybe transfer the input mismatch errors to the console class
    public HumanComputerInterface(IPlayerFactory playerFactory, IInput in, IOutput out) {
        this.playerFactory = playerFactory;
        this.in = in;
        this.out = out;
    }

    @Override
    public void initGame(){
        out.welcome();
        for (int i=0; i< Table.NB_JOUEURS;i++) {
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
    }

    @Override
    public void finishGame(IPlayer winner) {
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

    @Override
    public int playRound() {
        int choice = -1;
        boolean validNumber = false;
        while (!validNumber) {
            try {
                choice = in.retrievePlayerMove();
                validNumber = true;
            } catch (InputMismatchException e) {
                out.alertInvalidNumber();
            }
        }
        return choice;
    }

    @Override
    public void badMove() {
        out.alertInvalidColumn();
    }
}
