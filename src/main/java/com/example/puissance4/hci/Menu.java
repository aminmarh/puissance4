package com.example.puissance4.hci;

import com.example.puissance4.game.Table;
import org.springframework.stereotype.Component;

import java.util.InputMismatchException;
import java.util.Locale;

/**
 * GameController manages the game states and interactions for the Puissance 4 game.
 * It controls the game flow including menu display, game initiation, and application termination.
 */
@Component
public class Menu implements IMenu {
    private final IInput in;
    private final IOutput out;
    private final Table table;

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

    /**
     * Initializes the language setting for the game's user interface.
     * This method prompts the user to choose a language from the available options and sets the application's language accordingly.
     * It handles user input to select between supported languages and provides feedback for invalid choices.
     *
     * @param out The output handler used for displaying language options and alerts.
     */
    private void initLanguage(IOutput out) {
        while (true) {
            out.selectLanguage();
            try {
                int nb = in.retrieveLanguage();
                switch (nb) {
                    case 1 -> {
                        out.setLanguage(Locale.ENGLISH);
                        return;
                    }
                    case 2 -> {
                        out.setLanguage(Locale.FRENCH);
                        return;
                    }
                    case 3 -> {
                        return;
                    }
                    default -> out.alertInvalidCharacterMenu();
                }
            } catch (InputMismatchException e) {
                out.alertInvalidCharacterMenu();
            }
        }
    }

    /**
     * Starts the application's main loop, handling menu selections and delegating game operations.
     * It repeatedly displays the menu, processes the user input, and manages game states based on user interaction.
     */
    @Override
    public void startApplication() {
        boolean running = true;
        while (running) {
            try {
                out.showMenu();
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
                        out.alertInvalidCharacterMenu();
                        break;
                }
            } catch (InputMismatchException e) {
                out.alertInvalidCharacterMenu();
            }
        }
    }
}
