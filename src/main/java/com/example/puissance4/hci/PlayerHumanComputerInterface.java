package com.example.puissance4.hci;

import com.example.puissance4.player.IPlayerHumanComputerInterface;
import org.springframework.stereotype.Component;

import java.util.InputMismatchException;

@Component
public class PlayerHumanComputerInterface implements IPlayerHumanComputerInterface {

    private IInput in;
    private IOutput out;
    public PlayerHumanComputerInterface(IInput in, IOutput out) {
        this.in = in;
        this.out = out;
    }
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
                in.clearInputBuffer();
            }
        }
        return choice - 1;
    }

    @Override
    public void badMove() {
        out.alertInvalidColumn();
    }
}
