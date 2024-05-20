package com.example.puissance4.hci;

import com.example.puissance4.savegame.Save;
import com.example.puissance4.game.Table;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
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
    private Save save;


    /**
     * Constructs a Menu with dependencies for input, output, and game table.
     *
     * @param in  The input handler for user interactions.
     * @param out The output handler for displaying information to the user.
     * @param table The main game logic handler, responsible for managing gameplay.
     * @param save  The save handler for managing game saves.
     */
    public Menu(IInput in, IOutput out, Table table, Save save) {
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
                handleReturnToMenu();
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
        switch (choice) {
            case 1:
                clearSaveFile();
                return handleStartGame();
            case 2:
                return handleResumeOrChangeLanguage();
            case 3:
                return handleLanguageOrExit();
            case 4:
                return handleExit();
            default:
                out.alertInvalidCharacterMenu();
                return true;
        }
    }

    /**
     * Handles the user's choice to start a new game, initializing the game table and starting the game.
     * This method creates a new game table, initializes the players, and starts the game.
     * It returns a boolean indicating whether the application should continue running after starting the game.
     *
     * @return A boolean indicating whether the application should continue running after starting the game.
     */
    private boolean handleStartGame() {
        try {
            table.startGame();
        } catch (ReturnToMenuException e) {
            saveGameState();
            throw e;
        }
        return true;
    }

    /**
     * Handles the user's choice to resume a game or change the language setting.
     * This method loads the saved game state if available or prompts the user to change the language.
     * It returns a boolean indicating whether the application should continue running after loading the game or changing the language.
     *
     * @return A boolean indicating whether the application should continue running after loading the game or changing the language.
     */
    private boolean handleResumeOrChangeLanguage() {
        if (saveFileExists()) {
            save.loadGame();
            table.continueGame();
            deleteSaveFile();
            return true; // Game continues after loading
        } else {
            initLanguage(out);
            return true; // Continue to language change
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
        if (saveFileExists()) {
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
        if (saveFileExists()) {
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
        if (saveFileExists()) {
            out.showMenuWithResume();
        } else {
            out.showMenu();
        }
    }

    /**
     * Checks if the save file exists in the current directory.
     *
     * @return A boolean indicating whether the save file exists in the current directory.
     */
    private boolean saveFileExists() {
        return Files.exists(Paths.get("save.json"));
    }

    /**
     * Clears the save file from the current directory.
     */
    private void clearSaveFile() {
        if (saveFileExists()) {
            deleteSaveFile();
        }
    }

    /**
     * Deletes the save file from the current directory.
     */
    private void deleteSaveFile() {
        try {
            Files.delete(Paths.get("save.json"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Handles the user's choice to return to the main menu, saving the game state before returning.
     */
    private void handleReturnToMenu() {
        saveGameState();
    }

    /**
     * Saves the current game state to a JSON file.
     */
    private void saveGameState() {
        save.savePlayersToJson(table.getPlayers());
        save.saveBoardOnJson(table.getBoard());
    }

}
