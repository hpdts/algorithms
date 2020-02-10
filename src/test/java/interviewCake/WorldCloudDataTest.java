package interviewCake;

import org.junit.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import java.util.*;


public class WorldCloudDataTest {

    private WordCloudData wordCloudData = new WordCloudData("Bill finished his cake at the edge of the cliff.");
	
	@Test
    public void wordCloud(){
    	System.out.println("counts: " + wordCloudData.getWordsToCounts());
    }

    @Test
    public void duplicate(){
    	int[] numbers = {4,3,1,1,4};
    	System.out.println("numbers: " + Arrays.toString(numbers));
    	int result = wordCloudData.findDuplicate(numbers);
    	System.out.println("result: " + result);
    }

    @Test
    public void topScores(){
    	int[] unsortedScores = {37, 89, 41, 65, 91, 53, 37};
		final int HIGHEST_POSSIBLE_SCORE = 100;

		int[] sortedScores = wordCloudData.sortScores(unsortedScores, HIGHEST_POSSIBLE_SCORE);
		System.out.println("sorted: " + Arrays.toString(sortedScores));
    }
}