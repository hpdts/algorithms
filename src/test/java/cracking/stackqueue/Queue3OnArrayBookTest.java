package cracking.stackqueue;

import org.junit.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;


public class Queue3OnArrayBookTest {

	private Queue3OnArrayBook stack = new Queue3OnArrayBook();
	
	@Test
	public void push() {
		stack.push(1,1);
    	stack.push(1,2);
    	stack.push(1,3);
		stack.pop(1);
		assertThat(stack.peek(1), is(2));
	}

	@Test
	public void push2(){
		stack.push(2,1);
    	stack.push(2,2);
    	stack.push(2,3);
		stack.pop(2);
		assertThat(stack.peek(2), is(2));
	}

	@Test
	public void push3(){
		stack.push(0,1);
    	stack.push(0,2);
    	stack.push(0,3);
		stack.pop(0);
		assertThat(stack.peek(0), is(2));
	}
}