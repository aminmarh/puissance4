package com.example.puissance4.hci;

public interface IOutput {
    void welcome();
    void askPlayerName();
    void askPlayerType();
    void alertInvalidNumber();
    void alertInvalidPlayerType();
    void displayBoard(String board);
    void alertInvalidColumn();
    void announceDraw();
    void announceVictory(String winner);
    void goodbye();
    void callPlayer(String name);
}
