package com.example.puissance4.game;

/**
 * Represents the game board for Puissance 4 (Connect Four). This class manages the state of the board and provides
 * functionality to manipulate and query the state of the game.
 */
public class Board {
    public static final int ROWS = 6;
    public static final int COLUMNS = 7;
    private Token[][] board;

    /**
     * Initializes an empty game board with all slots set to Token.Empty.
     */
    public Board() {
        this.board = new Token[ROWS][COLUMNS];
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                board[i][j] = Token.Empty;
            }
        }
    }

    /**
     * Returns a deep copy of the game board.
     * @return A clone of the board array.
     */
    public Token[][] getBoard() {
        return board.clone();
    }

    /**
     * Attempts to place a token in the specified column.
     * @param column The column index where the token should be placed.
     * @param token The type of token to place.
     * @throws InvalidMoveException if the column is full or invalid.
     */
    public void putToken(int column, Token token) throws InvalidMoveException {
        if (!isMoveValid(column)) {
            throw new InvalidMoveException();
        }
        for (int i = ROWS - 1; i >= 0; i--) {
            if (board[i][column] == Token.Empty) {
                board[i][column] = token;
                return;
            }
        }
    }

    /**
     * Checks if placing a token in the specified column is valid.
     * @param column The column index to check.
     * @return true if the column is within bounds and has space available, false otherwise.
     */
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

    /**
     * Determines if the board is completely filled with tokens.
     * @return true if all slots are occupied, false otherwise.
     */
    public boolean isFull() {
        for (int i = 0; i < COLUMNS; i++) {
            if (board[0][i] == Token.Empty) {
                return false;
            }
        }
        return true;
    }

    /**
     * Checks if any player has won the game.
     * @return true if there is a winning line of four consecutive tokens, false otherwise.
     */
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

    /**
     * Checks a specific direction for four consecutive matching tokens.
     * @param token The token type to check.
     * @param row The starting row index.
     * @param col The starting column index.
     * @param rowDir The row direction to check.
     * @param colDir The column direction to check.
     * @return true if four consecutive tokens match the starting token, false otherwise.
     */
    private boolean checkDirection(Token token, int row, int col, int rowDir, int colDir) {
        for (int i = 0; i < 4; i++) {
            if (board[row + i * rowDir][col + i * colDir] != token) {
                return false;
            }
        }
        return true;
    }

    /**
     * Provides a visual representation of the game board as a string.
     * @return String representation of the board.
     */
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
