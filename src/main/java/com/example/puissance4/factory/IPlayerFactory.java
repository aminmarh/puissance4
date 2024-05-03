package com.example.puissance4.factory;

import com.example.puissance4.game.IPlayer;

public interface IPlayerFactory {
    public void createPlayer(int type, String name) throws InvalidPlayerTypeException;
    public IPlayer[] getPlayers();
}
