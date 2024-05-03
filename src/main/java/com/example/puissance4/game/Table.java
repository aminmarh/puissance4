package com.example.puissance4.game;


import org.springframework.stereotype.Component;

@Component
public class Table {
    public static final int NB_JOUEURS = 2;

    private Board board;
    private IPlayer[] players;
    private IHumanComputerInterface gameManager;

    public Table (IHumanComputerInterface gameManager) {
        this.board = new Board();
        this.gameManager = gameManager;
    }

    public void play() {
        this.players = gameManager.initGame();
        while (true) {
            for (IPlayer player : players) {
                gameManager.showBoard(this.board);
                player.play(this.board);
                if (this.board.isWon()) {
                    gameManager.finishGame(player);
                    return;
                }
                if (this.board.isFull()) {
                    gameManager.finishGame(null);
                    return;
                }
            }
        }
    }
}
