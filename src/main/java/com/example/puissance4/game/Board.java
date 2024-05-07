package com.example.puissance4.game;

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

    public boolean isWon() {
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

    /**
     * Evaluates if placing a token in a specified column can result in a win.
     * This method simulates the placement of a token in the given column and checks if it leads to a winning condition.
     * After the check, it reverses the move to leave the board state unchanged.
     *
     * @param column the column index where the token is to be placed to check for a win.
     * @param token the type of token (Red or Yellow) to place in the column.
     * @return true if placing the token in the column results in a win, otherwise false.
     */
    public boolean canWinInNextMove(int column, Token token) {
        // First, check if the move is valid (i.e., if the column is not full).
        if (!isMoveValid(column)) {
            return false;
        }

        // Temporarily place the token in the first available row from the bottom that is empty.
        int rowToPlace = -1;  // Initialize with -1 to indicate no token placed yet.
        for (int i = ROWS - 1; i >= 0; i--) {
            if (board[i][column] == Token.Empty) {
                rowToPlace = i;
                board[i][column] = token;  // Place token to simulate the move.
                break;
            }
        }

        // Check if this move leads to a winning condition.
        boolean canWin = isWon();

        // Remove the token to revert the board to its original state.
        if (rowToPlace != -1) {
            board[rowToPlace][column] = Token.Empty;
        }

        // Return whether the simulated move can win the game.
        return canWin;
    }

}
