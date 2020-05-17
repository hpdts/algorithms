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
    	//140  44 100 4 
      	int[] stockPrices = new int[] {10, 7, 5, 8, 11, 9};
		int maxProfit = exercise.getMaxProfit(stockPrices);
		assertThat(maxProfit, is(6)); 

		stockPrices = new int[] {10, 20, 30, 5, 10};
		maxProfit = exercise.getMaxProfit(stockPrices);
		assertThat(maxProfit, is(20)); 
		//140  44 100 4 

		stockPrices = new int[] {140, 44, 100, 4};
		//second number 
		maxProfit = exercise.getMaxProfit(stockPrices);
		assertThat(maxProfit, is(56)); 
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

	@Test
    public void reverse(){
		String reverse = exercise.reverseString("123");
		assertThat(reverse, is("321")); 
	}

	@Test
    public void rearrange(){
    	int[] a = new int[] {1,3,2,2,5};
		exercise.rearrangeEvenOdd(a);
	}

	@Test
    public void maxCandy1(){
    	int[] a = new int[] {3,4,7,7,6,6};
		int different = exercise.maximumCandy(a);
		assertThat(different, is(3)); 
	}

	@Test
    public void maxCandy2(){
    	int[] a = new int[] {80,80,1000000000,80,80,80,80,80,80,123456789};
		int different = exercise.maximumCandy(a);
		assertThat(different, is(3)); 
	}

	@Test
    public void pyramid(){
    	String word = "banana";
		assertTrue(exercise.isPyramid(word)); 
		word = "bandana";
		assertFalse(exercise.isPyramid(word));
		word = "appbbb";
		assertTrue(exercise.isPyramid(word));
		word = "a";
		assertTrue(exercise.isPyramid(word));
	}

	@Test
    public void increasing(){
    	int[] input = new int[] {1, 3, 2, 3, 4, 8, 7, 9};
    	int lenght = exercise.longestIncreasingSubArray(input);
		assertThat(lenght, is(5)); 

		exercise.printAllSubArray(input);

		input = new int[] {1,8,2};
    	lenght = exercise.longestIncreasingSubArray(input);
		assertThat(lenght, is(2)); 
    }

    @Test
    public void biggest(){
    	int number = 423865;
    	int num = exercise.biggestNumber(number);
    	assertThat(num, is(865432)); 
    }

    @Test
    public void converter(){
    	float value  = exercise.converter(1.0f, "USD", "CAD");
    	assertThat(value, is(1.27f));
    	value  = exercise.converter(2.0f, "USD", "CAD");
    	assertThat(value, is(2.55f));

    	value  = exercise.converter(2.0f, "USD", "INR");
    	assertThat(value, is(142.00f));

    	value  = exercise.converter(1.0f, "CAD", "JPY");
    	assertThat(value, is(83.00f));
    }
}