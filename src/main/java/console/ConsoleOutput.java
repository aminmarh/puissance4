package console;

import hci.IOutput;

import java.util.Properties;

public class ConsoleOutput implements IOutput {
    private Properties strings;
    @Override
    public void welcome() {
        System.out.println(strings.get("welcome_message"));
    }

    @Override
    public void askPlayerName() {
        System.out.println(strings.get("player_name"));
    }

    @Override
    public void askPlayerType() {
        System.out.println(strings.get("player_type"));
    }

    @Override
    public void alertInvalidNumber() {
        System.out.println(strings.get("number_error"));
    }

    @Override
    public void alertInvalidPlayerType() {
        System.out.println(strings.get("invalid_player_type"));
    }

    @Override
    public void displayBoard(String board) {
        System.out.println(board);
    }

    @Override
    public void alertInvalidColumn() {
        System.out.println(strings.get("invalid_column"));
    }

    @Override
    public void announceDraw() {
        System.out.println(strings.get("draw_message"));
    }

    @Override
    public void announceVictory(String winner) {
        System.out.printf((String) strings.get("victory_message"), winner);
    }

    @Override
    public void goodbye() {
        System.out.println(strings.get("goodbye_message"));
    }
}
