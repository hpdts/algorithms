package cracking.stackqueue;

import org.junit.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;


public class SetOfStacksTest {

	private SetOfStacks stack = new SetOfStacks(3);
	

	@Test
	public void pushOverflow(){
		stack.push(1);
    	stack.push(2);
    	stack.push(3);
    	stack.push(4);
    	stack.push(5);
	}
}