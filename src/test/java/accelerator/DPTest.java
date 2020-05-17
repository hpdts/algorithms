package accelerator;

import org.junit.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import java.util.*;

public class DPTest {

	DP dp = new DP();

	@Test
    public void fibonacci(){
    	int fibonacci = dp.fibonacci(5);
    	assertThat(fibonacci, is(5));  
    	fibonacci = dp.fibonacciMemoization(10);
    	assertThat(fibonacci, is(55)); 
    	fibonacci = dp.fibonacciBottom(20);
    	assertThat(fibonacci, is(6765));  
    	fibonacci = dp.fibonacciBottom(30);
    	assertThat(fibonacci, is(832040));  
    }

    @Test
    public void latticePaths(){
    	int paths = dp.latticePaths(0,0);
    	assertThat(paths, is(1));  
    	paths = dp.latticePaths(1,1);
    	assertThat(paths, is(2));  
    	paths = dp.latticePaths(3,2);
    	assertThat(paths, is(10)); 
    	paths = dp.latticePaths(2,3);
    	assertThat(paths, is(10)); 
    	paths = dp.latticePaths(2,2);
    	assertThat(paths, is(6));
    	paths = dp.latticePaths(2,1);
    	assertThat(paths, is(3));  
    	paths = dp.latticePaths(1,2);
    	assertThat(paths, is(3));   
    	paths = dp.latticePaths(20,20);
    	assertThat(paths, is(407575348));   
    	paths = dp.latticePaths(10,10);
    	assertThat(paths, is(184756));   
    	paths = dp.latticePaths(17,14);
    	assertThat(paths, is(265182525));    
    }

    @Test
    public void nonConsecutives1(){
    	List<String> numbers = dp.nonConsecutives1(2);
    	assertThat(numbers.toString(), is("[00, 01, 10]"));
    	DP dp2 = new DP();
    	numbers = dp2.nonConsecutives1(3);
    	DP dp3 = new DP();
    	numbers = dp3.nonConsecutives1(20);
    	//assertThat(numbers.toString(), is("[000, 001, 010, 100, 101]"));
    	assertTrue(dp.hasConsecutive1("111"));
    	assertFalse(dp.hasConsecutive1("101"));
    	assertFalse(dp.hasConsecutive1("10"));
    	assertTrue(dp.hasConsecutive1("11"));
    }

    @Test
    public void areConsecutive(){
    	int number = dp.maxConsecutiveSum(new int[] {6, -1, 3, 5, -10});
    	assertThat(number, is(13));
    }

    @Test
    public void bitFlip(){
    	int number = dp.BitFlip(new int[] {0,1,1,1,0,1,0,1,0,0}, 2);
    	assertThat(number, is(7));
    	number = dp.BitFlip(new int[] {0,1}, 1);
    	assertThat(number, is(2));
    }
    
    @Test
    public void productSubarray(){
        int max = dp.maxProductSubarray(new int[] {2, 3, -2, 4});
        assertThat(max, is(6));

        max = dp.maxProductSubarray(new int[] {-2, -3, -2, 4});
        assertThat(max, is(24));
    }
}