package game;
import player.Human;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {

    @org.junit.jupiter.api.Test
    void testToString() {
        Board board = new Board();
        System.out.println(board.toString());
        String expected = "| | | | | | | |\n" +
                "| | | | | | | |\n" +
                "| | | | | | | |\n" +
                "| | | | | | | |\n" +
                "| | | | | | | |\n" +
                "| | | | | | | |\n" ;
        assertEquals(expected, board.toString());
    }

    void testPlay(){
        Board board = new Board();
        IPlayer player1 = new Human("Player1",Token.Red);
        IPlayer player2 = new Human("Player2",Token.Yellow);
        board.play();


    }
}