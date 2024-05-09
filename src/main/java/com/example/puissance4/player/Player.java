package com.example.puissance4.player;

import com.example.puissance4.game.IPlayer;
import com.example.puissance4.game.Token;

/**
 * Abstract base class for players in the Puissance 4 game.
 * Provides common functionality and structure for all types of players (e.g., Human, AI) through the IPlayer interface.
 */
public abstract class Player implements IPlayer {
    private String name;  // The name of the player.
    private Token token;  // The type of token this player uses.

    /**
     * Constructs a player with a specified name and token type.
     * @param name The name of the player, used for identification during gameplay.
     * @param token The type of token the player will use, essential for game logic and display.
     */
    protected Player(String name, Token token) {
        this.name = name;
        this.token = token;
    }

    /**
     * Retrieves the name of the player.
     * @return The name of the player as a string.
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * Retrieves the type of token associated with this player.
     * Tokens differentiate players and their moves on the game board.
     * @return The token representing the player's type.
     */
    @Override
    public Token getToken() {
        return token;
    }
}
