package com.example.puissance4.console;

import com.example.puissance4.hci.IOutput;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.Locale;
import java.util.logging.Logger;

/**
 * ConsoleOutput implements IOutput to handle all console outputs for the Puissance 4 game,
 * utilizing localization for messages.
 */
@Component
public class ConsoleOutput implements IOutput {
    private MessageSource l10n;
    private OutputStream out;
    private  Locale language;
    private static final ProcessBuilder CLEANER_PROCESS;

    static {
        // Determine the correct command based on OS just once
        String os = System.getProperty("os.name");
        if (os.contains("Windows")) {
            CLEANER_PROCESS = new ProcessBuilder("cmd", "/c", "cls").inheritIO();
        } else {
            CLEANER_PROCESS = new ProcessBuilder("clear").inheritIO();
        }
    }

    /**
     * Constructs a ConsoleOutput object with specified localization source and output stream.
     * @param l10n MessageSource for localization
     * @param out OutputStream for displaying text in the console
     */
    public ConsoleOutput(MessageSource l10n, OutputStream out) {
        this.l10n = l10n;
        this.out = out;
        this.language= Locale.ENGLISH;
    }

    /**
     * Prompts the user to select a language for the game's interface.
     * This method displays available language options to the user, pulling the prompt message from the localized resource bundle.
     * The output is adapted based on the currently set language for initial display.
     */
    public void selectLanguage(){
        try {
            out.write(l10n.getMessage("choice_language", null, this.language).getBytes(StandardCharsets.UTF_8));
        } catch (Exception e) {
            Logger.getAnonymousLogger().severe(e.getMessage());
        }
    }

    /**
     * Sets the language for all subsequent game messages displayed in the console.
     * This method updates the language setting, affecting how messages are localized and displayed.
     *
     * @param newLanguage The new locale to set for message localization.
     */
    public void setLanguage(Locale newLanguage) {
        this.language = newLanguage;
    }

    /**
     * Displays an error message if an invalid language selection is made.
     * This method alerts the user to an invalid choice by outputting a localized error message,
     * ensuring that users are aware of the mistake and prompted to correct it.
     */
    public void alertLanguageError (){
        try {
            // Notify user of the number input error using a localized message.
            out.write(l10n.getMessage("number_error", null, this.language).getBytes(StandardCharsets.UTF_8));
            out.write("\n".getBytes(StandardCharsets.UTF_8));
        } catch (Exception e) {
            Logger.getAnonymousLogger().severe(e.getMessage());
        }
    }

    /**
     * Displays a welcome message to the user.
     */
    @Override
    public void welcome() {
        try {
            // Write the localized welcome message to the output stream.
            out.write(l10n.getMessage("welcome_message", null, this.language).getBytes(StandardCharsets.UTF_8));
            out.write("\n".getBytes(StandardCharsets.UTF_8));
        } catch (Exception e) {
            Logger.getAnonymousLogger().severe(e.getMessage());
        }
    }

    /**
     * Prompts the user to enter their name.
     */
    @Override
    public void askPlayerName() {
        try {
            // Request player name using localized text.
            out.write(l10n.getMessage("player_name", null, this.language).getBytes(StandardCharsets.UTF_8));
        } catch (Exception e) {
            Logger.getAnonymousLogger().severe(e.getMessage());
        }
    }

    /**
     * Asks the user to specify the type of player (e.g., human or AI).
     */
    @Override
    public void askPlayerType() {
        try {
            // Request player type using localized text.
            out.write(l10n.getMessage("player_type", null, this.language).getBytes(StandardCharsets.UTF_8));
        } catch (Exception e) {
            Logger.getAnonymousLogger().severe(e.getMessage());
        }
    }

    /**
     * Alerts the user that the inputted number is invalid.
     */
    @Override
    public void alertInvalidNumber() {
        try {
            // Notify user of the number input error using a localized message.
            out.write(l10n.getMessage("number_error", null, this.language).getBytes(StandardCharsets.UTF_8));
        } catch (Exception e) {
            Logger.getAnonymousLogger().severe(e.getMessage());
        }
    }

    /**
     * Alerts the user that the selected player type is invalid.
     */
    @Override
    public void alertInvalidPlayerType() {
        try {
            // Inform the user of an invalid player type selection using a localized message.
            out.write(l10n.getMessage("invalid_player_type", null, this.language).getBytes(StandardCharsets.UTF_8));
        } catch (Exception e) {
            Logger.getAnonymousLogger().severe(e.getMessage());
        }
    }

    /**
     * Displays the current state of the game board.
     * @param board The current board's string representation.
     */
    @Override
    public void displayBoard(String board) {
        try {
            // Display column headers and the board itself.
            out.write("|1|2|3|4|5|6|7|\n".getBytes(StandardCharsets.UTF_8));
            out.write(board.getBytes(StandardCharsets.UTF_8));
        } catch (Exception e) {
            Logger.getAnonymousLogger().severe(e.getMessage());
        }
    }

    /**
     * Alerts the user that the chosen column is invalid.
     */
    @Override
    public void alertInvalidColumn() {
        try {
            // Notify user of an invalid column selection using a localized message.
            out.write(l10n.getMessage("invalid_column", null, this.language).getBytes(StandardCharsets.UTF_8));
        } catch (Exception e) {
            Logger.getAnonymousLogger().severe(e.getMessage());
        }
    }

    /**
     * Announces a draw in the game.
     */
    @Override
    public void announceDraw() {
        try {
            // Communicate a draw situation using a localized message.
            out.write(l10n.getMessage("draw_message", null, this.language).getBytes(StandardCharsets.UTF_8));
            out.write("\n".getBytes(StandardCharsets.UTF_8));
        } catch (Exception e) {
            Logger.getAnonymousLogger().severe(e.getMessage());
        }
    }

    /**
     * Announces the victory of a player.
     * @param winner The name of the winning player.
     */
    @Override
    public void announceVictory(String winner) {
        try {
            // Announce the winner using a formatted localized message.
            out.write(l10n.getMessage("victory_message", new Object[]{winner}, this.language).getBytes(StandardCharsets.UTF_8));
            out.write("\n".getBytes(StandardCharsets.UTF_8));
        } catch (Exception e) {
            Logger.getAnonymousLogger().severe(e.getMessage());
        }
    }

    /**
     * Displays a goodbye message to the user.
     */
    @Override
    public void goodbye() {
        try {
            // Send off the user with a goodbye message using localized text.
            out.write(l10n.getMessage("goodbye_message", null, this.language).getBytes(StandardCharsets.UTF_8));
        } catch (Exception e) {
            Logger.getAnonymousLogger().severe(e.getMessage());
        }
    }

    /**
     * Calls a player to make their move.
     * @param name The name of the player being called.
     */
    @Override
    public void callPlayer(String name) {
        try {
            // Prompt the specified player to make a move using localized text.
            out.write(l10n.getMessage("player_prompt", new Object[]{name},this.language).getBytes(StandardCharsets.UTF_8));
            out.write("\n".getBytes(StandardCharsets.UTF_8));
        } catch (Exception e) {
            Logger.getAnonymousLogger().severe(e.getMessage());
        }
    }

    /**
     * Display the menu options using localized text.
     */
    @Override
    public void showMenu() {
        try {
            out.write(l10n.getMessage("main_menu_message", null, this.language).getBytes(StandardCharsets.UTF_8));
        } catch (Exception e) {
            Logger.getAnonymousLogger().severe(e.getMessage());
        }
    }

    /**
     * Refresh the human computer interface after every player move.
     */
    @Override
    public void refreshInterface() {
        try {
            CLEANER_PROCESS.start().waitFor();
        } catch (InterruptedException e) {
            Logger.getAnonymousLogger().severe(e.getMessage());
            Thread.currentThread().interrupt(); // Restore interrupt status
        } catch (Exception e) {
            Logger.getAnonymousLogger().severe(e.getMessage());
        }
    }
}
