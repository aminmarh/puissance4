package game;

public class Table {
    public static final int NB_JOUEURS = 2;

    private Board board;
    private IPlayer[] players;

    public Table (Board board, IPlayer[] players) {
        this.board = board;
        this.players = players;
    }

    public IPlayer play() {
        while (true) {
            for (IPlayer player : players) {
                int column = player.play();
                boolean goodPlay = false;
                while (!goodPlay) {
                    try {
                        this.board.putToken(column, player.getToken());
                        goodPlay = true;
                    } catch (ArrayIndexOutOfBoundsException e) {
                        column = player.play();
                    }
                }
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
