package com.example.puissance4;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.puissance4.hci.Menu;

/**
 * Spring Boot application for the Puissance 4 (Connect Four) game.
 * This class is the entry point of the application, responsible for setting up and starting the game using Spring Boot's framework.
 */
@SpringBootApplication
public class Puissance4Application implements CommandLineRunner {

    @Autowired
    private Menu menu;

    /**
     * The main method that serves as the entry point for the Spring Boot application.
     * @param args Command line arguments passed during application start.
     */
    public static void main(String[] args) {
        SpringApplication.run(Puissance4Application.class, args);
    }

    /**
     * This method is called after the application has started and the Spring context is fully initialized.
     * It delegates the control to GameController to handle the application logic.
     *
     * @param args Command line arguments provided during application start, not used directly in this method.
     * @throws Exception if any exception occurs during the game execution or interaction.
     */
    @Override
    public void run(String... args) throws Exception {
        menu.startApplication();
    }
}
