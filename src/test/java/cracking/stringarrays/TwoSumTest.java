package cracking.stringarrays;

import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;


public class TwoSumTest {

	private TwoSum twoSum = new TwoSum();
	
	@Test
	public void twoSum(){
		int[] numbers = {2, 7, 11, 15};
		int target = 9;
		int[] sum = twoSum.twoSum(numbers, target);	
		assertThat(sum[0], is(0));
		assertThat(sum[1], is(1));
	}

	


}
