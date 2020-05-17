package accelerator;

import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;


public class DecreaseConquerTest {
	DecreaseConquer decreaseConquer = new DecreaseConquer();

	@Test
    public void numberOfOnes(){
    	/*[0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1] --> 8`
 * `[0, 0, 0] --> 0`
 * `[0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1] --> 7`*/
    	int ones = decreaseConquer.numberOfOnes(new int[] {0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1});
    	assertThat(ones, is(8));   
    	ones = decreaseConquer.numberOfOnes(new int[] {0, 0, 0});
    	assertThat(ones, is(0));  
    	ones = decreaseConquer.numberOfOnes(new int[] {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1});
    	assertThat(ones, is(7));  
    }

    @Test
    public void closestValue(){
    	/*    [1, 2, 3, 5, 5, 7, 9, 10, 11], 6 --> 5`
 * `[1, 2, 3], 8 --> 3`
 * `[1, 10, 22, 59, 67, 72, 100], 70 --> 72`*/
    	int close = decreaseConquer.closestValue(new int[] {1, 2, 3, 5, 5, 7, 9, 10, 11}, 6);
    	assertThat(close, is(5));   
    	close = decreaseConquer.closestValue(new int[] {1, 10, 22, 59, 67, 72, 100}, 70);
    	assertThat(close, is(72));   
    	close = decreaseConquer.closestValue(new int[] {1, 2, 3}, 8);
    	assertThat(close, is(3));   
    }

    @Test
    public void squareRoot(){
    /*`4 --> 2.0`
 		* `98 --> 9.899495`
 		* `14856 --> 121.885192*/
 		Double squareRoot = decreaseConquer.squareRoot(4);
    	assertThat(squareRoot, is(2.0)); 
    	squareRoot = decreaseConquer.squareRoot(98);
    	assertThat(squareRoot, is(9.89899999999999)); 
    	squareRoot = decreaseConquer.squareRoot(14856);
    	assertThat(squareRoot, is(121.88500000000002)); 
	}

	@Test
    public void greaterValues(){
    	/* * `[1, 2, 3, 5, 5, 7, 9, 10, 11], 5 --> 4`
 * `[1, 2, 3], 4 --> 0`
 	 s	
 * `[1, 10, 22, 59, 67, 72, 100], 13 --> 5`*/
 	//e   m        
 		int greater = decreaseConquer.greaterValues(new int[] {1, 2, 3, 5, 5, 7, 9, 10, 11}, 5);
    	assertThat(greater, is(4)); 
 		greater = decreaseConquer.greaterValues(new int[] {1, 2, 3}, 4);
    	assertThat(greater, is(0)); 
 		greater = decreaseConquer.greaterValues(new int[] {1, 10, 22, 59, 67, 72, 100}, 13);
    	assertThat(greater, is(5)); 
	}

	@Test
    public void binarySearch(){ 
    	assertTrue(decreaseConquer.binarySearch(new int[] {1, 2, 3, 4, 5, 6}, 0, 6, 2)); 
	}



    @Test
    public void binaryrotatedSearch(){ 
        assertFalse(decreaseConquer.rotatedArraySearch(new int[] {35, 46, 79, 102, 1, 14, 29, 31}, 47)); 
        assertTrue(decreaseConquer.rotatedArraySearch(new int[] {3, 4, 1, 2}, 3)); 
        assertTrue(decreaseConquer.rotatedArraySearch(new int[] {35, 46, 79, 102, 1, 14, 29, 31}, 46)); 
        assertTrue(decreaseConquer.rotatedArraySearch(new int[] {7, 8, 9, 10, 1, 2, 3, 4, 5, 6}, 9)); 
    }

}