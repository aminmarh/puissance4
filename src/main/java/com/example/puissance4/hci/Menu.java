package com.example.puissance4.hci;

import com.example.puissance4.console.ConsoleOutput;
import com.example.puissance4.game.Table;
import org.springframework.stereotype.Component;

import java.util.InputMismatchException;
import java.util.Locale;

/**
 * GameController manages the game states and interactions for the Puissance 4 game.
 * It controls the game flow including menu display, game initiation, and application termination.
 */
@Component
public class Menu {
    private final IInput in;
    private final IOutput out;
    private final Table table;
    private Locale language;

    /**
     * Constructs a GameController with dependencies for input, output, and game table.
     *
     * @param in  The input handler for user interactions.
     * @param out The output handler for displaying information to the user.
     * @param table  The main game logic handler, responsible for managing gameplay.
     */
    public Menu(IInput in, IOutput out, Table table) {
        this.in = in;
        this.out = out;
        this.table = table;
    }

    public Locale initLanguage(IOutput out) {
        out.selectLanguage();
        int nb = in.retrieveLanguage();
        if (nb == 1) {
            out.setLanguage(Locale.ENGLISH);
            return Locale.ENGLISH;
        } else if (nb == 2) {
            out.setLanguage(Locale.FRENCH);
            return Locale.FRENCH;
        }
        return null;
    }


    /**
     * Starts the application's main loop, handling menu selections and delegating game operations.
     * It repeatedly displays the menu, processes the user input, and manages game states based on user interaction.
     */
    public void startApplication() {
        boolean running = true;
        while (running) {
            out.showMenu();
            try {
                int choice = in.retrieveMainMenuChoice();
                switch (choice) {
                    case 1:
                        table.play();
                        break;
                    case 2:
                        initLanguage(out);
                        break;
                    case 3:
                        out.goodbye();
                        running = false;
                        break;

                    default:
                        out.alertInvalidPlayerType();
                        break;
                }
            } catch (InputMismatchException e) {
                out.alertInvalidNumber();
            }
        }
    }
}
