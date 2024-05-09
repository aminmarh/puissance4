package com.example.puissance4.player;

/**
 * Interface defining the methods necessary for human-computer interaction during game play.
 * This interface facilitates communication between human players and the game system, managing input and output related to player moves.
 */
public interface IPlayerHumanComputerInterface {

    /**
     * Conducts a round of play, prompting the player to make a move.
     * This method is responsible for interfacing with the player to get their next move based on the current state of the game.
     * It is expected to handle all user interactions required to retrieve a valid move from the player.
     *
     * @param playerName The name of the player making the move, used for personalized prompts.
     * @return The zero-based index of the column where the player wishes to place their token.
     */
    public int playRound(String playerName);

    /**
     * Notifies the player that an attempted move was invalid.
     * This method is called when a player makes a move that is not allowed by the game rules,
     * such as trying to place a token in a full column. It should instruct the player to make another move.
     */
    public void badMove();
}
