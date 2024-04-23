package hci;

import factory.IPlayerFactory;
import factory.InvalidPlayerTypeException;
import game.Board;
import game.IHumanComputerInterface;
import game.IPlayer;
import game.Table;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import player.IPlayerHumanComputerInterface;

import java.util.InputMismatchException;
import java.util.Properties;
import java.util.Scanner;

@Component
public class HumanComputerInterface implements IHumanComputerInterface, IPlayerHumanComputerInterface {

    private Properties strings;
    private Scanner sc;

    private IPlayerFactory playerFactory;

    @Autowired
    public HumanComputerInterface(Properties strings, IPlayerFactory playerFactory) {
        this.strings = strings;
        sc = new Scanner(System.in);
        this.playerFactory = playerFactory;
    }

    @Override
    public void initGame(){
        System.out.println(strings.get("welcome_message"));
        for (int i=0; i< Table.NB_JOUEURS;i++) {
            String name;
            System.out.println(strings.get("player_name"));
            name = sc.nextLine();

            System.out.println(strings.get("player_type"));
            boolean validChoice = false;
            int choice;
            while (!validChoice) {
                try {
                    choice = sc.nextInt();
                    validChoice = choice == 1 || choice == 2;
                    playerFactory.createPlayer(choice, name);
                } catch (InputMismatchException e) {
                    System.out.println(strings.get("number_error"));
                } catch (InvalidPlayerTypeException e) {
                    System.out.println(strings.get("invalid_player_type"));
                }
            }
        }
    }

    @Override
    public void finishGame(IPlayer winner) {
        if (winner == null) {
            System.out.println(strings.get("draw_message"));
        } else {
            System.out.printf((String) strings.get("victory_message"), winner.getName());
        }
        System.out.println(strings.get("goodbye_message"));
    }

    @Override
    public void showBoard(Board board) {
        System.out.println(board.toString());
    }

    @Override
    public int playRound() {
        int choice = -1;
        boolean validNumber = false;
        while (!validNumber) {
            try {
                choice = sc.nextInt();
                validNumber = true;
            } catch (InputMismatchException e) {
                System.out.println(strings.get("number_error"));
            }
        }
        return choice;
    }

    @Override
    public void badMove() {
        System.out.println(strings.get("invalid_column"));
    }
}
