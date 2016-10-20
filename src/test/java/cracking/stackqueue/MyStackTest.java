package cracking.stackqueue;

import org.junit.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;


public class MyStackTest {

	private MyStack stack = new MyStack();
	

	@Test
	public void push(){
		stack.push(1);
    	stack.push(2);
    	stack.push(3);
    	stack.push(4);
		stack.pop();
		assertThat(stack.peek(), is(3));
	}
}