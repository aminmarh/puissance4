package com.example.puissance4.hci;

import com.example.puissance4.savegame.ISave;
import com.example.puissance4.game.Table;
import org.springframework.stereotype.Component;

import java.util.InputMismatchException;
import java.util.Locale;

/**
 * Menu manages the game states and interactions for the Puissance 4 game.
 * It controls the game flow including menu display, game initiation, and application termination.
 */
@Component
public class Menu implements IMenu {
    private final IInput in;
    private final IOutput out;
    private final Table table;
    private final ISave save;


    /**
     * Constructs a Menu with dependencies for input, output, and game table.
     *
     * @param in  The input handler for user interactions.
     * @param out The output handler for displaying information to the user.
     * @param table The main game logic handler, responsible for managing gameplay.
     * @param save  The save handler for managing game saves.
     */
    public Menu(IInput in, IOutput out, Table table, ISave save) {
        this.in = in;
        this.out = out;
        this.table = table;
        this.save = save;
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
                displayMenu();
                int choice = in.retrieveMainMenuChoice();
                running = handleMenuChoice(choice);
            } catch (InputMismatchException e) {
                out.alertInvalidCharacterMenu();
            } catch (ReturnToMenuException e) {
                save.saveGame(); // Save the game if the player stops playing
            }
        }
    }

    /**
     * Handles the user's choice from the main menu, executing the corresponding action.
     * This method processes the user's selection and performs the appropriate action based on the choice.
     * It returns a boolean indicating whether the application should continue running after the action.
     *
     * @param choice The user's choice from the main menu.
     * @return A boolean indicating whether the application should continue running after the action.
     */
    private boolean handleMenuChoice(int choice) {
        return switch (choice) {
            case 1 -> {
                save.deleteSavedGame();
                handleStartGame();
                yield true;
            }
            case 2 -> {
                handleResumeOrChangeLanguage();
                yield true;
            }
            case 3 -> handleLanguageOrExit();
            case 4 -> handleExit();
            default -> {
                out.alertInvalidCharacterMenu();
                yield true;
            }
        };
    }

    /**
     * Handles the user's choice to start a new game, initializing the game table and starting the game.
     * This method creates a new game table, initializes the players, and starts the game.
     * It returns a boolean indicating whether the application should continue running after starting the game.
     *
     */
    private void handleStartGame() {
        try {
            table.startGame();
        } catch (ReturnToMenuException e) {
            save.saveGame();
            throw e;
        }
    }

    /**
     * Handles the user's choice to resume a game or change the language setting.
     * This method loads the saved game state if available or prompts the user to change the language.
     * It returns a boolean indicating whether the application should continue running after loading the game or changing the language.
     *
     */
    private void handleResumeOrChangeLanguage() {
        // Continue to language change
        if (save.isSavedGame()) {
            save.loadGame();
            table.continueGame();
            save.deleteSavedGame();
        } else {
            initLanguage(out);
        }
    }

    /**
     * Handles the user's choice to change the language setting or exit the application.
     * This method prompts the user to change the language or exit the application based on the choice.
     * It returns a boolean indicating whether the application should continue running after changing the language or exiting.
     *
     * @return A boolean indicating whether the application should continue running after changing the language or exiting.
     */
    private boolean handleLanguageOrExit() {
        if (save.isSavedGame()) {
            initLanguage(out);
            return true; // Continue to language change
        } else {
            out.goodbye();
            return false; // Exit the application
        }
    }

    /**
     * Handles the user's choice to exit the application or continue running.
     * This method prompts the user to exit the application or continue running based on the choice.
     * It returns a boolean indicating whether the application should continue running after the user's choice.
     *
     * @return A boolean indicating whether the application should continue running after the user's choice.
     */
    private boolean handleExit() {
        if (save.isSavedGame()) {
            out.goodbye();
            return false; // Exit the application
        } else {
            out.alertInvalidCharacterMenu();
            return true; // Continue running as invalid choice
        }
    }

    /**
     * Displays the main menu to the user, including options to start a new game, resume a game, change the language, or exit.
     * This method shows the main menu options to the user, including the option to resume a game if a save file exists.
     */
    private void displayMenu() {
        if (save.isSavedGame()) {
            out.showMenuWithResume();
        } else {
            out.showMenu();
        }
    }
}
