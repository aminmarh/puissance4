package com.example.puissance4.console;

import com.example.puissance4.hci.IInput;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.util.Scanner;

@Component
public class ConsoleInput implements IInput {
    Scanner sc;

    public ConsoleInput(InputStream in) {
        this.sc = new Scanner(in);
    }
    @Override
    public String retrievePlayerName() {
        return sc.next().trim();
    }

    @Override
    public int retrievePlayerType() {return sc.nextInt();}

    @Override
    public int retrievePlayerMove() {
        return sc.nextInt();
    }
}
