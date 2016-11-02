package cracking.stackqueue;

import org.junit.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;


public class StacksTest {

	private Stacks stack = new Stacks();
	

	@Test(expected = RuntimeException.class)
	public void pushOverflow(){
		stack.push(1);
    	stack.push(2);
    	stack.push(3);
		assertThat(stack.currentStackIndex, is(1));
    	stack.push(4);
    	stack.push(5);
	}
}