package com.example.puissance4;

import com.example.puissance4.game.Table;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Spring Boot application for running the Puissance 4 game.
 * This class serves as the entry point for the application, setting up and starting the game.
 */
@SpringBootApplication
public class Puissance4Application implements CommandLineRunner {

    private final Table table;  // Central game table that manages the flow of the game.

    /**
     * Constructs the application with necessary game components.
     * @param table The main game logic handler, responsible for managing gameplay.
     */
    public Puissance4Application(Table table) {
        this.table = table;
    }

    /**
     * Main method that starts the Spring Boot application.
     * @param args Command line arguments passed during application start.
     */
    public static void main(String[] args) {
        SpringApplication.run(Puissance4Application.class, args);
    }

    /**
     * Runs the game after the Spring application context is fully initialized.
     * This method is called automatically by Spring Boot once the application is up and running.
     * It starts the game process by calling the play method on the game table.
     *
     * @param args Command line arguments provided during application start, not used directly in this method.
     * @throws Exception Handles any exceptions that might occur during the game execution.
     */
    @Override
    public void run(final String... args) throws Exception {
        table.play();  // Start the game loop.
    }
}
