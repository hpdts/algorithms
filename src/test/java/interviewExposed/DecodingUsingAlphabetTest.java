package interviewExposed;

import org.junit.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import java.util.*;

public class DecodingUsingAlphabetTest {

	private DecodingUsingAlphabet decodingUsingAlphabet = new DecodingUsingAlphabet();

	@Test
	public void decodingAlphabet(){

		char digits[] = {'1','2','3','4'};
		int ways = decodingUsingAlphabet.countDecoding(digits, digits.length);
		assertThat(ways, is(3));
	}

	@Test
	public void decodingAlphabetDP(){

		char digits[] = {'1','2','3','4'};
		int ways = decodingUsingAlphabet.countDecodingDP(digits, digits.length);
		assertThat(ways, is(3));
	}
}