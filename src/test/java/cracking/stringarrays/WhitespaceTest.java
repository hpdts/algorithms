package cracking.stringarrays;

import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;


public class WhitespaceTest {

	private Whitespace whitespace = new Whitespace();
	
	@Test
	public void replaceWhitespace(){
		assertThat(whitespace.replaceWhitespace("MR John Smith    ", 13), is("MR%20John%20Smith"));
		assertThat(whitespace.replaceWhitespace("ana   maria", 11), is("ana%20%20%20maria"));
		assertThat(whitespace.replaceWhitespace("paco", 4), is("paco"));
	}

	@Test
	public void replaceWhitespaceBookSolution(){
		assertThat(whitespace.replaceSpaces("MR John Smith    ", 13), is("MR%20John%20Smith"));
		assertThat(whitespace.replaceSpaces("ana   maria", 11), is("ana%20%20%20maria"));
		assertThat(whitespace.replaceSpaces("paco", 4), is("paco"));
	}
}
