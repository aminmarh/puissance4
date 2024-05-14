package com.example.puissance4.hci;

import com.example.puissance4.player.IPlayerHumanComputerInterface;
import org.springframework.stereotype.Component;

import java.util.InputMismatchException;

/**
 * Implements the IPlayerHumanComputerInterface for handling the interaction between players and the computer,
 * facilitating the input and output processes during game play.
 */
@Component
public class PlayerHumanComputerInterface implements IPlayerHumanComputerInterface {

    private IInput in;
    private IOutput out;

    /**
     * Constructs a PlayerHumanComputerInterface with specific input and output handlers.
     * @param in Interface for retrieving player input.
     * @param out Interface for sending output to the player.
     */
    public PlayerHumanComputerInterface(IInput in, IOutput out) {
        this.in = in;
        this.out = out;
    }

    /**
     * Manages a single round of player interaction, prompting the player to make a move and validating the input.
     * This method ensures that the player's move is within the acceptable range for column indices.
     *
     * @param playerName The name of the player whose turn it is to play.
     * @return The zero-based column index where the player wishes to place their token, adjusted from one-based input.
     */
    @Override
    public int playRound(String playerName) {
        out.callPlayer(playerName);
        int choice = 0;
        boolean validNumber = false;

        while (!validNumber) {
            try {
                choice = in.retrievePlayerMove();
                if (choice >= 1 && choice <= 7) {
                    validNumber = true;
                } else {
                    out.alertInvalidColumn();
                }
            } catch (InputMismatchException e) {
                out.alertInvalidNumber();
            }
        }
        return choice - 1;
    }

    /**
     * Alerts the player that an attempted move was invalid, typically due to the chosen column being full.
     */
    @Override
    public void badMove() {
        out.alertInvalidColumn();
    }
}
