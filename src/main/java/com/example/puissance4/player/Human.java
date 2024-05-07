package com.example.puissance4.player;

import com.example.puissance4.game.InvalidMoveException;
import com.example.puissance4.game.Board;
import com.example.puissance4.game.Token;

public class Human extends Player {
    private IPlayerHumanComputerInterface app;

    public Human(String name, Token token, IPlayerHumanComputerInterface app) {
        super(name, token);
        this.app = app;
    }
    @Override
    public void play(Board board) {
        boolean goodMove = false;
        while (!goodMove) {
            try {
                board.putToken(app.playRound(), this.getToken());
                goodMove = true;
            } catch (InvalidMoveException e) {
                app.badMove();
            }
        }
    }
}
