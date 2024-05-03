package com.example.puissance4.hci;

import com.example.puissance4.factory.IPlayerFactory;
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
