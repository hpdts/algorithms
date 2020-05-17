package cracking.reboot.stacksQueues;

import org.junit.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import java.util.Arrays; 

public class MultiStackTest {
	MultiStack multiStack = new MultiStack(3, 10);

	@Test
	public void stacks3(){
		multiStack.push(0,1);
		multiStack.push(0,2);
		multiStack.push(0,3);
		assertThat(multiStack.peek(0), is(3)); 
		multiStack.push(1,10);
		multiStack.push(1,20);
		multiStack.push(1,30);
		multiStack.push(1,40);
		multiStack.push(1,50);
		int value = multiStack.pop(1);
		assertThat(value, is(50)); 
	}

}