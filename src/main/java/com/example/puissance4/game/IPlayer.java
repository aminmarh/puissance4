package com.example.puissance4.game;

public interface IPlayer {
    public String getName();

    public Token getToken();

    public void play(Board board);
}
