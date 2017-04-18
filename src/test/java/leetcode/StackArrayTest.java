package leetcode;

import org.junit.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class StackArrayTest {

	public StackArray stack = new StackArray(10);

	@Test
    public void push(){
    	stack.push(1);
    	assertThat(stack.peek(), is(1));
    	assertThat(stack.pop(), is(1));
    	assertTrue(stack.isEmpty());
    	stack.push(2);
    	stack.push(3);

    	assertThat(stack.pop(), is(3));
    }
}