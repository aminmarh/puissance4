package com.example.puissance4.factory;

import com.example.puissance4.game.IPlayer;

/**
 * Interface defining the factory methods for creating and retrieving players in the Puissance 4 game.
 * This factory interface is responsible for player creation based on specified types and managing player instances.
 */
public interface IPlayerFactory {

    /**
     * Creates a player of the specified type with the given name.
     * The method is designed to handle different types of players, such as human or AI, based on the type parameter.
     *
     * @param type An integer representing the player type. Specific numbers are mapped to specific player types.
     * @param name The name of the player to be created.
     * @throws InvalidPlayerTypeException If the provided type is not recognized as a valid player type.
     */
    public void createPlayer(int type, String name) throws InvalidPlayerTypeException;

    /**
     * Retrieves an array of all players currently managed by the factory.
     * This method provides access to all player instances that have been created and are currently active.
     *
     * @return An array of IPlayer instances representing all the players.
     */
    public IPlayer[] getPlayers();
}
