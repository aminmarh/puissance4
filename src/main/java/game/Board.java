package game;

public class Board {
    private static final int ROWS=6;
    private static final int COLUMNS=7;
    private Token[][] board;

    public Board (){
        this.board= new Token[ROWS][COLUMNS];
        for (int i=0; i<ROWS; i++){
            for (int j=0; j<COLUMNS;j++){
                board[i][j]=Token.Empty;
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
