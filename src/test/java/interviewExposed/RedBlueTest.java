package interviewExposed;

import org.junit.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import java.util.*;

public class RedBlueTest {

	private RedBlue redBlue = new RedBlue();

	@Test
	public void isPattern(){
		int value = redBlue.isPattern("abba", "redbluebluered");
		assertThat(value, is(1));
		value = redBlue.isPattern("abcd", "thequickbrownfox");
		assertThat(value, is(1));
		value = redBlue.isPattern("abcd", "thequickbrownfoxred");
		assertThat(value, is(1));
		value = redBlue.isPattern("abcda", "redbluegreenfrered");
		assertThat(value, is(1));
		value = redBlue.isPattern("aab", "111111");
		assertThat(value, is(1));
	}
}