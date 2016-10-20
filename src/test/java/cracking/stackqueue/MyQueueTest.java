package cracking.stackqueue;

import org.junit.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;


public class MyQueueTest {

	private MyQueue queue = new MyQueue();
	

	@Test
	public void enqueue(){
		queue.enqueue(1);
    	queue.enqueue(2);
    	queue.enqueue(3);
    	queue.enqueue(4);
		assertThat(queue.dequeue(), is(1));
	}
}