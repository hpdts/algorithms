package interviewCake;

import org.junit.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import java.util.*;


public class ExerciseTest {
	private Exercise exercise = new Exercise();

	@Test
    public void inFlight(){
    	int flightLength = 10;
    	int[] movies = {1,3,4,5,9,7};
    	assertTrue(exercise.infligthEntertainment(10, movies));
    }

    @Test
    public void stocksApple(){
      	int[] stockPrices = new int[] {10, 7, 5, 8, 11, 9};
		int maxProfit = exercise.getMaxProfit(stockPrices);
		assertThat(maxProfit, is(6)); 
	}

	@Test
    public void highestProduct(){
      	int[] nums = new int[] {-10,-10,1,3,2};
		int maxProduct = exercise.highestProductOf3(nums);
		assertThat(maxProduct, is(300)); 
	}


	@Test
    public void intersection(){
      	int[] a = new int[] {1,3,4,7,11,107};
      	int[] b = new int[] {2,3,11,19};
		List<Integer> intersection = exercise.intersection(a, b);
		assertThat(intersection.size(), is(2)); 
		System.out.println("List: " + intersection.toString());
	}
}