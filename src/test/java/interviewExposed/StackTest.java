package interviewExposed;

import org.junit.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class StackTest {

	public Stack<Integer> stack = new Stack<Integer>();

	@Test
    public void push(){
    	stack.enqueue(3);
		stack.enqueue(2);
		stack.enqueue(1);
		stack.traverse();
    }

    @Test
    public void deleteAll(){
		stack.enqueue(2);
		stack.enqueue(1);
		stack.traverse();
		stack.deleteAll();
		stack.traverse();
    }


}