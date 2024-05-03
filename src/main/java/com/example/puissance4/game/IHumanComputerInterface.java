package com.example.puissance4.game;

public interface IHumanComputerInterface {
    public IPlayer[] initGame();
    public void finishGame(IPlayer winner);
    public void showBoard(Board board);
}
