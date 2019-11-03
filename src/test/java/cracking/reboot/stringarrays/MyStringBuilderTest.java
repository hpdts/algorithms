package cracking.reboot.stringarrays;

import org.junit.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;


public class MyStringBuilderTest {

	private MyStringBuilder myStringBuilder = new MyStringBuilder();

	@Test
	public void add(){
		myStringBuilder.append("Vietnam");
		myStringBuilder.append(" not");
		myStringBuilder.append(" good");

		assertThat(myStringBuilder.toString(), is("Vietnam not good"));
	}
}