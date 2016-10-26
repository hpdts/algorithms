package cracking.stackqueue;

import org.junit.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;


public class StackWithMinTest {

	private StackWithMin stack = new StackWithMin();
	

	@Test
	public void push(){
		stack.push(1);
    	stack.push(2);
    	stack.push(3);
    	stack.push(4);
		stack.pop();
		assertThat(stack.min(), is(1));
	}

	@Test
	public void minChange(){
		stack.push(10);
		stack.push(2);
    	stack.push(3);
    	stack.push(4);
    	stack.push(1);
    	assertThat(stack.min(), is(1));
		stack.pop();
		assertThat(stack.min(), is(2));
	}
}