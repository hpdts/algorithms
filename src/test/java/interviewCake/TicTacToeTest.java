package interviewCake;

import org.junit.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import java.util.*;


public class TicTacToeTest {

	private TicTacToe ticTacToe = new TicTacToe();

	/*@Test
    public void display(){
		ticTacToe.displayBoard();
		//ticTacToe
		ticTacToe.addToken('X', 0, 0);
		ticTacToe.displayBoard();
		ticTacToe.addToken('X', 0, 1);
		ticTacToe.displayBoard();
    }*/

    @Test
    public void move(){
    	ticTacToe.displayBoard();
    	assertFalse(ticTacToe.isBoardFull());
    	for(int i = 0; i < 9 ;i++){
    		ticTacToe.move();
    	}
    	ticTacToe.displayBoard();
    	assertTrue(ticTacToe.isBoardFull());
    }
//./page2.html#na&amp;#xEFve
//./page2.html#na&amp%59#xEFve
}