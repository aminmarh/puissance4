package com.example.puissance4.savegame;

public interface ISave {
    void loadGame();

    void saveGame();

    boolean isSavedGame();

    void deleteSavedGame();
}
