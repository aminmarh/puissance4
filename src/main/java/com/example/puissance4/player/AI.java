package com.example.puissance4.player;

import com.example.puissance4.game.Board;
import com.example.puissance4.game.InvalidMoveException;
import com.example.puissance4.game.Token;

import java.util.logging.Logger;

import static java.lang.System.exit;

/**
 * Represents an AI player in the Puissance 4 game.
 * This class extends the Player class and implements an AI that can make strategic moves.
 */
public class AI extends Player {

    /**
     * Constructs an AI player with a specified name and token.
     * @param name the name of the player.
     * @param token the token type the player will use.
     */
    public AI(String name, Token token) {
        super(name, token);
    }

    /**
     * Plays a move on the given board.
     * The AI evaluates the board and determines the best move to make, either to win, block or randomly place a token.
     * @param board the game board where the move will be made.
     */
    @Override
    public void play(Board board) {
        int move = findBestMove(board);
        try {
            board.putToken(move, this.getToken());
        } catch (InvalidMoveException e) {
            Logger.getAnonymousLogger().severe("Error ai player: " + e.getMessage());
            exit(1);
        }
    }

    /**
     * Finds the best possible move for the AI based on the current state of the board.
     * It first checks for a winning move, then for a move to block the opponent's win, and finally defaults to a random move.
     * @param board the game board to analyze for the best move.
     * @return the column index where the token should be placed.
     */
    private int findBestMove(Board board) {
        for (int i = 0; i < Board.COLUMNS; i++) {
            if (board.canWinInNextMove(i, this.getToken())) {
                return i;
            }
        }

        for (int i = 0; i < Board.COLUMNS; i++) {
            if (board.canWinInNextMove(i, this.getToken().opposite())) {
                return i;
            }
        }

        return selectStrategicMove(board);
    }

    /**
     * Selects a random valid move from the available columns on the board.
     * This is used as a fallback when no immediate winning or blocking moves are found.
     * @param board the game board to select a move from.
     * @return the column index for the random valid move.
     */
    private int selectStrategicMove(Board board) {
        int move = (int) (Math.random() * Board.COLUMNS);
        while (!board.isMoveValid(move)) {
            move = (int) (Math.random() * Board.COLUMNS);
        }
        return move;
    }
}
