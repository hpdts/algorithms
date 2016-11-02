package cracking.stackqueue;

import org.junit.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import java.util.*;


public class TowerOfHanoiStacksTest {

	private TowerOfHanoiUsingStacks hanoi = new TowerOfHanoiUsingStacks();
	

	@Test
	public void hanoi(){
         hanoi.tower[1] = new Stack<Integer>();
         hanoi.tower[2] = new Stack<Integer>();
         hanoi.tower[3] = new Stack<Integer>();
         TowerOfHanoiUsingStacks.N = 3;
         int num = 3;
         hanoi.toh(num);
     }

}