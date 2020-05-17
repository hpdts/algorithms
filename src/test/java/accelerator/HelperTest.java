package accelerator;

import org.junit.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import java.util.*;

public class HelperTest {
	Helper helper = new Helper();

	@Test
    public void printArray(){
    	int[] arr = {1,2,3};
    	helper.printArray(arr);
    	System.out.println("reverse: ");
    	helper.printArrayreverse(arr);
    }

    @Test
    public void reverseString(){
    	String reverse = helper.reverseString("hello");
    	System.out.println("reverse: " + reverse);
    }

    @Test
    public void phone(){
    	helper.getCombos("23"); 
    }

    @Test
    public void TwoArrays(){
    	int[][] result = helper.compute(new int[]{ 1,2,3,4,5,6});

    	for(int i =0; i < result.length; i++){
    		System.out.println(Arrays.toString(result[i]));
    	}

    	result = helper.compute(new int[]{ 1,2,3,4,5});

    	for(int i =0; i < result.length; i++){
    		System.out.println(Arrays.toString(result[i]));
    	}
    }

    @Test
    public void flatten(){
    	int[][] matrix =  {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
    	int[] result = helper.computeFlatten(matrix);
    	System.out.println(Arrays.toString(result));
    }
    
    @Test
    public void pow(){
    	int result = helper.computePow(3, 4);
    	assertThat(result, is(81)); 
    }

    @Test
    public void merge(){
    	int[] nums1 = {1, 4, 7};
 		int[] nums2 = {2, 3, 6, 9};
    	int[] result = helper.computeMerge(nums1, nums2);
    	System.out.println("Merged: "); 
    	System.out.println(Arrays.toString(result)); 
    }

    @Test
    public void powerSet(){
    	List<String> out = helper.computePowerSet("abc");
    	assertThat(out.toString(), is("[, c, b, bc, a, ac, ab, abc]"));
    }

    @Test
    public void intersection(){
    	int[] nums1 = {1, 3, 4, 7, 11, 107};
 		int[] nums2 = {2, 3, 11, 19};
    	List<Integer> intersection = helper.intersection(nums1, nums2);
    	assertThat(intersection.toString(), is("[3, 11]"));

    	int[] nums11 = {1, 3, 4, 7, 11, 107};
 		int[] nums22 = {1};
    	intersection = helper.intersection(nums11, nums22);
    	assertThat(intersection.toString(), is("[1]"));
    }
}