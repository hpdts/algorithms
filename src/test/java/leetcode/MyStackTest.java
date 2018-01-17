package leetcode;

import org.junit.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class MyStackTest {

	public MyStack stack = new MyStack();

	@Test
    public void push(){
    	stack.push(1);
    	assertThat(stack.top(), is(1));
    	stack.pop();
    	assertTrue(stack.empty());
    	stack.push(2);
    	stack.push(3);
        stack.pop();
    	assertThat(stack.top(), is(2));
    }
}