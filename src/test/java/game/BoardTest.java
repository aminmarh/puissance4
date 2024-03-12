<<<<<<< Updated upstream
import static org.junit.jupiter.api.Assertions.*;
class BoardTest {
  
=======
package game;

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

>>>>>>> Stashed changes
}