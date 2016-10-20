package cracking.stackqueue;

import org.junit.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;


public class StackArrayTest {

	private StackArray stack = new StackArray();
	
	@Test
	public void push(){
		stack.push1(1);
    	stack.push1(2);
    	stack.push1(3);
		stack.pop1();
		assertThat(stack.peek1(), is(2));
	}

	@Test
	public void push2(){
		stack.push2(1);
    	stack.push2(2);
    	stack.push2(3);
		stack.pop2();
		assertThat(stack.peek2(), is(2));
	}

	@Test
	public void push3(){
		stack.push3(1);
    	stack.push3(2);
    	stack.push3(3);
		stack.pop3();
		assertThat(stack.peek3(), is(2));
	}
}