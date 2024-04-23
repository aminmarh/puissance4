package game;

import org.springframework.beans.factory.annotation.Autowired;

public class Board {
    public static final int ROWS=6;
    public static final int COLUMNS=7;
    private Token[][] board;


    public Board (){
        this.board= new Token[ROWS][COLUMNS];
        for (int i=0; i<ROWS; i++){
            for (int j=0; j<COLUMNS;j++){
                board[i][j]=Token.Empty;
            }
        }
    }

    public Token[][] getBoard() {
        return board.clone();
    }

    public void putToken(int column, Token token) throws InvalidMoveException {
        if(!isMoveValid(column)) {
            throw new InvalidMoveException();
        }
        for (int i = ROWS - 1; i >= 0; i--) {
            if (board[i][column] == Token.Empty) {
                board[i][column] = token;
                return;
            }
        }
    }

    public boolean isMoveValid(int column) {
        if (column < 0 || column >= COLUMNS) {
            return false;
        }
        for (int i = 0; i < ROWS; i++) {
            if (board[i][column] == Token.Empty) {
                return true;
            }
        }
        return false;
    }

    public boolean isFull() {
        for (int i = 0; i < COLUMNS; i++) {
            if (board[0][i] == Token.Empty) {
                return false;
            }
        }
        return true;
    }

    public boolean isWinned() {
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
