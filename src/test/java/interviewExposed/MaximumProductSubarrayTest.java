package interviewExposed;

import org.junit.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import java.util.*;

public class MaximumProductSubarrayTest {

	private MaximumProductSubarray maximumProductSubarray = new MaximumProductSubarray();

	@Test
	public void product(){
		int[] nums = {2, 3, -2, 4};
		int maxProduct = maximumProductSubarray.maxProduct(nums);

		assertThat(maxProduct, is(6));
	}

}