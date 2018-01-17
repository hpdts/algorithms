package leetcode;

import org.junit.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class QueueTest {

	public Queue<Integer> queue = new Queue<>(Integer.class, 10);

	@Test
    public void push(){
        queue.push(1);
        assertThat(queue.peek(), is(1));
        queue.pop();
        assertTrue(queue.size() == 0);
        queue.push(2);
        queue.push(3);
        assertThat(queue.peek(), is(2));
        queue.pop();
        assertThat(queue.peek(), is(3));
    }
}