package com.example.puissance4.console;

import com.example.puissance4.hci.IInput;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.util.InputMismatchException;
import java.util.Scanner;

@Component
public class ConsoleInput implements IInput {
    private Scanner sc;

    public ConsoleInput(InputStream in) {
        this.sc = new Scanner(in);
    }

    @Override
    public String retrievePlayerName() {
        if (sc.hasNext()) {
            return sc.next().trim();
        } else {
            return "";
        }
    }

    @Override
    public int retrievePlayerType() {
        try {
            return sc.nextInt();
        } catch (InputMismatchException e) {
            clearInputBuffer();
            throw new InputMismatchException();
        }
    }

    @Override
    public int retrievePlayerMove() {
        try {
            return sc.nextInt();
        } catch (InputMismatchException e) {
            clearInputBuffer();
            throw new InputMismatchException();
        }
    }

    private void clearInputBuffer() {
        if (sc.hasNext()) {
            sc.next();
        }
    }
}
