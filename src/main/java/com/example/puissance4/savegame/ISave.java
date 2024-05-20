package com.example.puissance4.savegame;

public interface ISave {
    /**
     * Loads a saved game previously saved
     */
    void loadGame();

    /**
     * Saves the current game state
     */
    void saveGame();

    /**
     * Checks if a saved game exists
     * @return true if a saved game exists, false otherwise
     */
    boolean isSavedGame();

    /**
     * Deletes the saved game
     */
    void deleteSavedGame();
}
