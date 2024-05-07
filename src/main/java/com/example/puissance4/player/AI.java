package com.example.puissance4.player;

import com.example.puissance4.game.Board;
import com.example.puissance4.game.InvalidMoveException;
import com.example.puissance4.game.Token;

public class AI extends Player{

    public AI(String name, Token token) {
        super(name, token);
    }

    @Override
    public void play(Board board) {
        // random move
        int move = (int) (Math.random() * 7);
        boolean goodMove = false;
        while (!goodMove) {
            try {
                board.putToken(move, this.getToken());
                goodMove = true;
            } catch (InvalidMoveException e) {
                move = (int) (Math.random() * 7);
            }
        }
    }
}
