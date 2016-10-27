package cracking.stringarrays;

import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;


public class MedianOfTwoSortedArraysTest {

	private MedianOfTwoSortedArrays medians = new MedianOfTwoSortedArrays();
	
	@Test
	public void getMedian(){

		int N = 5;
        int[] arr1 = {1, 12, 15, 26, 38};
        int[] arr2 = {2, 13, 17, 30, 45};
        int med = medians.median(arr1, arr2);

		assertThat(med, is(16));

	}


}
