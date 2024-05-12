package com.example.puissance4.factory;

import com.example.puissance4.game.IPlayer;
import com.example.puissance4.game.Table;
import com.example.puissance4.game.Token;
import org.springframework.stereotype.Component;
import com.example.puissance4.player.AI;
import com.example.puissance4.player.Human;
import com.example.puissance4.player.IPlayerHumanComputerInterface;

/**
 * PlayerFactory is responsible for creating player instances and managing them.
 * It supports creating different types of players based on input parameters and maintains a list of all players.
 */
@Component
public class PlayerFactory implements IPlayerFactory {
    private IPlayer[] players;
    private int currentPlayer = 0;
    private Token[] tokens;
    private IPlayerHumanComputerInterface playerHumanComputerInterface;

    /**
     * Constructs a PlayerFactory with a specific interface for player interactions.
     *
     * @param playerHumanComputerInterface Interface used to facilitate human-computer interactions.
     */
    public PlayerFactory(IPlayerHumanComputerInterface playerHumanComputerInterface) {
        this.players = new IPlayer[Table.NB_JOUEURS]; // Initialize the players array based on the number of players
        this.currentPlayer = 0; // Start with the first player
        this.tokens = new Token[]{Token.Red, Token.Yellow}; // Initialize tokens for two players
        this.playerHumanComputerInterface = playerHumanComputerInterface;
    }

    /**
     * Creates a player of a specified type (human or AI) and assigns a token.
     * @param type The type of player to create (1 for Human, 2 for AI).
     * @param name The name of the player.
     * @throws InvalidPlayerTypeException If the specified player type is not recognized.
     */
    @Override
    public void createPlayer(int type, String name) throws InvalidPlayerTypeException {
        if (type == 1) {
            players[currentPlayer] = new Human(name, tokens[currentPlayer], this.playerHumanComputerInterface);
        } else if (type == 2) {
            players[currentPlayer] = new AI(name, tokens[currentPlayer]);
        } else {
            throw new InvalidPlayerTypeException(); // Throw an exception if the type is not 1 or 2
        }
        currentPlayer++; // Increment to prepare for the next player
    }

    /**
     * Returns the array of players created by this factory.
     * @return An array of IPlayer instances, representing all the players created.
     */
    @Override
    public IPlayer[] getPlayers() {
        return players;
    }

    /**
     * Resets the player creation process by setting the player index back to the start.
     * This method is used to clear any existing player setup when reinitializing or starting a new game,
     * ensuring that players are created from a clean state.
     */
    @Override
    public void resetPlayers() {
        currentPlayer = 0;
    }
}
