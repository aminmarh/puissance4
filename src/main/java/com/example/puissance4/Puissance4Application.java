package com.example.puissance4;

import com.example.puissance4.factory.InvalidPlayerTypeException;
import com.example.puissance4.game.Table;
import com.example.puissance4.hci.IInput;
import com.example.puissance4.hci.IOutput;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.InputMismatchException;

/**
 * Spring Boot application for running the Puissance 4 game.
 * This class serves as the entry point for the application, setting up and starting the game.
 * It handles the game flow, including showing menus, starting games, and shutting down the application.
 */
@SpringBootApplication
public class Puissance4Application implements CommandLineRunner {

    private final Table table;
    private final IInput in;
    private final IOutput out;

    /**
     * Constructs the application with necessary game components for managing gameplay and player interaction.
     * This setup allows for handling user input and output, and executing game logic.
     *
     * @param table The main game logic handler, responsible for managing gameplay.
     * @param in The interface for handling user input, used for menu selections and in-game decisions.
     * @param out The interface for handling user output, used for displaying game state, menus, and alerts.
     */
    public Puissance4Application(Table table, IInput in, IOutput out) {
        this.table = table;
        this.in = in;
        this.out = out;
    }

    /**
     * Main method that starts the Spring Boot application.
     * @param args Command line arguments passed during application start.
     */
    public static void main(String[] args) {
        SpringApplication.run(Puissance4Application.class, args);
    }

    /**
     * Runs the application logic after the Spring application context is fully initialized.
     * This method controls the main loop of the application, displaying the menu and processing user choices.
     * Depending on the user's choice, it will start a game or terminate the application.
     *
     * @param args Command line arguments provided during application start, not directly used in this method.
     * @throws Exception Handles any exceptions that might occur during the game execution, including input/output errors.
     */
    @Override
    public void run(String... args) throws Exception {
        boolean running = true;
        while (running) {
            out.showMenu();
            try {
                int choice = in.retrieveMainMenuChoice();
                switch (choice) {
                    case 1: // Start a new game
                        table.play();
                        break;
                    case 2: // Exit the application
                        out.goodbye();
                        running = false;
                        break;
                    default: // Handle invalid menu option
                        out.alertInvalidPlayerType();
                        break;
                }
            } catch (InputMismatchException e) {
                out.alertInvalidNumber(); // Alert if the input is not a valid integer.
            }
        }
    }
}
