package console;

import hci.IInput;

import java.util.Scanner;

public class ConsoleInput implements IInput {
    Scanner sc;
    @Override
    public String retrievePlayerName() {
        return sc.nextLine();
    }

    @Override
    public int retrievePlayerType() {
        return sc.nextInt();
    }

    @Override
    public int retrievePlayerMove() {
        return sc.nextInt();
    }
}
