package cracking.stringarrays;

import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;


public class ReverseTest {

	private Reverse reverse = new Reverse();
	
	@Test
	public void reverseStack(){
		assertThat(reverse.reverseStack("1234"), is("4321"));
		assertThat(reverse.reverseStack("ana"), is("ana"));
		assertThat(reverse.reverseStack("francisco"), is("ocsicnarf"));
	}

	@Test
	public void reverseJava(){
		assertThat(reverse.reverseJava("1234"), is("4321"));
		assertThat(reverse.reverseJava("ana"), is("ana"));
		assertThat(reverse.reverseJava("francisco"), is("ocsicnarf"));
	}

	@Test(expected = RuntimeException.class)
	public void checkNull(){
		reverse.reverseStack(null);
	}

	@Test
	public void reverseRecursiveJava(){
		assertThat(reverse.reverseRecursively("1234"), is("4321"));
		assertThat(reverse.reverseRecursively("ana"), is("ana"));
		assertThat(reverse.reverseRecursively("francisco"), is("ocsicnarf"));
	}

}
