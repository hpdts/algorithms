package cracking.reboot.stacksQueues;

import org.junit.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import java.util.Arrays; 

public class FixedMultiStackTest {
	private FixedMultiStack fixedMultiStack = new FixedMultiStack(10);

	@Test
	public void stacks3(){
		fixedMultiStack.push(0, 1);
		fixedMultiStack.push(1, 37);
		fixedMultiStack.push(2, 14);
		assertThat(fixedMultiStack.peek(1), is(37)); 
		fixedMultiStack.pop(0);
		assertTrue(fixedMultiStack.isEmpty(0));
	}
}