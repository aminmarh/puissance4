package com.example.puissance4.game;

import com.example.puissance4.hci.IInput;
import com.example.puissance4.hci.IOutput;
import org.springframework.stereotype.Component;

import java.util.InputMismatchException;

/**
 * GameController manages the game states and interactions for the Puissance 4 game.
 * It controls the game flow including menu display, game initiation, and application termination.
 */
@Component
public class GameController {
    private final IInput input;
    private final IOutput output;
    private final Table table;

    /**
     * Constructs a GameController with dependencies for input, output, and game table.
     *
     * @param input  The input handler for user interactions.
     * @param output The output handler for displaying information to the user.
     * @param table  The main game logic handler, responsible for managing gameplay.
     */
    public GameController(IInput input, IOutput output, Table table) {
        this.input = input;
        this.output = output;
        this.table = table;
    }

    /**
     * Starts the application's main loop, handling menu selections and delegating game operations.
     * It repeatedly displays the menu, processes the user input, and manages game states based on user interaction.
     */
    public void startApplication() {
        boolean running = true;
        while (running) {
            output.showMenu();
            try {
                int choice = input.retrieveMainMenuChoice();
                switch (choice) {
                    case 1:
                        table.play();
                        break;
                    case 2:
                        output.goodbye();
                        running = false;
                        break;
                    default:
                        output.alertInvalidPlayerType();
                        break;
                }
            } catch (InputMismatchException e) {
                output.alertInvalidNumber();
            }
        }
    }
}
