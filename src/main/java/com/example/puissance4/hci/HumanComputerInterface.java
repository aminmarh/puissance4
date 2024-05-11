package com.example.puissance4.hci;

import com.example.puissance4.factory.IPlayerFactory;
import com.example.puissance4.factory.InvalidPlayerTypeException;
import com.example.puissance4.game.Board;
import com.example.puissance4.game.IHumanComputerInterface;
import com.example.puissance4.game.IPlayer;
import com.example.puissance4.game.Table;
import org.springframework.stereotype.Component;

import java.util.InputMismatchException;

/**
 * Implements the IHumanComputerInterface to manage interactions between the game's human and computer elements.
 * This class coordinates the game setup, play, and conclusion processes, interfacing between the user input/output and the game logic.
 */
@Component
public class HumanComputerInterface implements IHumanComputerInterface {
    private IPlayerFactory playerFactory;
    private IInput in;
    private IOutput out;

    /**
     * Constructs a HumanComputerInterface with necessary dependencies for managing players and interacting with users.
     * @param playerFactory The factory responsible for creating and managing players.
     * @param in The input handler for obtaining user input.
     * @param out The output handler for sending information to the user.
     */
    public HumanComputerInterface(IPlayerFactory playerFactory, IInput in, IOutput out) {
        this.playerFactory = playerFactory;
        this.in = in;
        this.out = out;
    }

    /**
     * Initializes the game by setting up players and welcoming users.
     * It prompts for player names and types, creating players accordingly.
     * @return An array of IPlayer, each representing an initialized player.
     */
    @Override
    public IPlayer[] initGame() {
        playerFactory.resetPlayers();
        out.welcome(); // Display a welcome message.
        for (int i = 0; i< Table.NB_JOUEURS; i++) {
            String name;

            out.askPlayerName(); // Ask for the player's name.
            name = in.retrievePlayerName(); // Retrieve the name entered by the user.

            boolean validChoice = false;
            int choice = 0;
            out.askPlayerType(); // Ask for the type of player (Human or AI).

            while (!validChoice) {
                try {
                    choice = in.retrievePlayerType();
                    if (choice == 1 || choice == 2) {
                        playerFactory.createPlayer(choice, name);
                        validChoice = true;
                    } else {
                        out.alertInvalidPlayerType();
                    }
                } catch (InputMismatchException e) {
                    out.alertInvalidNumber(); // Alert if the input is not a valid integer.
                } catch (InvalidPlayerTypeException e) {
                    out.alertInvalidPlayerType(); // Alert if the chosen player type is invalid.
                }
            }
        }
        return this.playerFactory.getPlayers();// Return the array of created players.
    }

    /**
     * Handles the end of the game by displaying the final board state, announcing the result, and saying goodbye.
     * @param winner The player who has won the game or null if the game ended in a draw.
     * @param board The final state of the game board.
     */
    @Override
    public void finishGame(IPlayer winner, Board board) {
        showBoard(board); // Display the final state of the board.
        if (winner == null) {
            out.announceDraw(); // Announce a draw if no winner.
        } else {
            out.announceVictory(winner.getName()); // Announce the victory with the winner's name.
        }
        out.goodbye(); // Display a goodbye message.
    }

    /**
     * Displays the current state of the board.
     * @param board The board to be displayed.
     */
    @Override
    public void showBoard(Board board) {
        out.displayBoard(board.toString()); // Output the current state of the board.
    }
}
