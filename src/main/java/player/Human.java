package player;

import game.Board;
import game.InvalidMoveException;
import game.Token;

public class Human extends Player {
    private IPlayerHumanComputerInterface app;

    public Human(String name, Token token, IPlayerHumanComputerInterface app) {
        super(name, token);
        this.app = app;
    }

    public int play() {
        return app.playRound();
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
