package game;

public class Table {
    public static final int NB_JOUEURS = 2;

    private Board board;
    private IPlayer[] players;

    public Table (IPlayer[] players) {
        this.board = new Board();
        this.players = players;
    }

    public IPlayer play() {
        while (true) {
            for (IPlayer player : players) {
                player.play(this.board);
                if (this.board.isWinned()) {
                    return player;
                }
                if (this.board.isFull()) {
                    return null;
                }
            }
        }
    }
}
