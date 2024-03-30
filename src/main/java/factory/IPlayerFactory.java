package factory;

import game.IPlayer;

public interface IPlayerFactory {
    public void createPlayer(int type, String name) throws InvalidPlayerTypeException;
    public IPlayer[] getPlayers();
}
