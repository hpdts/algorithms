package interviewExposed;

import org.junit.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import java.util.*;

public class LongestIncreasingSubsequenceTest {

	private LongestIncreasingSubsequence longestIncreasingSubsequence = new LongestIncreasingSubsequence();
	
	@Test
	@Ignore
	public void longestIncreasingSubsequence2(){
		Integer[] input = new Integer[]{0, 8, 4};
		int length = longestIncreasingSubsequence.getLongestIncreasingSubsequence(input);
		assertThat(length, is(2));
	}
    
    @Test
    //3,2
    //50,3,10,7,40,80
    //10,22,33,50,60,80
	public void longestIncreasingSubsequence3(){
		Integer[] input = new Integer[]{3, 10 , 2 ,1, 20};
		int length = longestIncreasingSubsequence.getLongestIncreasingSubsequence(input);
		assertThat(length, is(3));
	}

	@Ignore
	@Test
	public void longestIncreasingSubsequence(){
		Integer[] input = new Integer[]{0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15};
		int length = longestIncreasingSubsequence.getLongestIncreasingSubsequence(input);

		assertThat(length, is(6));

	}


}