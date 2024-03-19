package game;

public class Board {
    private static final int ROWS=6;
    private static final int COLUMNS=7;
    private Token[][] board;


    public Board (IPlayer[] players){
        this.board= new Token[ROWS][COLUMNS];
        for (int i=0; i<ROWS; i++){
            for (int j=0; j<COLUMNS;j++){
                board[i][j]=Token.Empty;
            }
        }
        this.players=players;
    }

    private void putToken(int column, Token token) {
        for (int i = ROWS - 1; i >= 0; i--) {
            if (board[i][column] == Token.Empty) {
                board[i][column] = token;
            }
        }
    }

    private boolean isFull() {
        for (int i = 0; i < COLUMNS; i++) {
            if (board[0][i] == Token.Empty) {
                return false;
            }
        }
        return true;
    }

    private boolean isWinned() {
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLUMNS; col++) {
                Token token = board[row][col];
                if (token != Token.Empty &&
                        ((row <= ROWS - 4 && checkDirection(token, row, col, 1, 0)) || // vertical
                                (col <= COLUMNS - 4 && checkDirection(token, row, col, 0, 1)) || // horizontal
                                (row <= ROWS - 4 && col <= COLUMNS - 4 && checkDirection(token, row, col, 1, 1)) || // diagonal down
                                (row >= 3 && col <= COLUMNS - 4 && checkDirection(token, row, col, -1, 1)))) { // diagonal up
                    return true;
                }
            }
        }
        return false;
    }

    private boolean checkDirection(Token token, int row, int col, int rowDir, int colDir) {
        for (int i = 0; i < 4; i++) {
            if (board[row + i * rowDir][col + i * colDir] != token) {
                return false;
            }
        }
        return true;
    }

    public IPlayer play() {
        while (true) {
            for (IPlayer player : players) {
                int column = player.play();
                boolean goodPlay = false;
                while (!goodPlay) {
                    try {
                        putToken(column, player.getToken());
                        goodPlay = true;
                    } catch (ArrayIndexOutOfBoundsException e) {
                        column = player.play();
                    }
                }
                if (isWinned()) {
                    return player;
                }
                if (isFull()) {
                    return null;
                }
            }
        }
    }
    public String toString (){
        StringBuilder sb = new StringBuilder();
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLUMNS; col++) {
                sb.append("|").append(board[row][col]);
            }
            sb.append("|\n");
        }
        return sb.toString();
    }
}
