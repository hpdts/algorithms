package interviewExposed;

import java.util.*;
import java.util.Arrays;
import java.util.stream.Collectors;

public class MaximumProductSubarray{

	public int maxProduct(int[] nums){
		int[] max = new int[nums.length];
		int[] min = new int[nums.length];

		max[0] = min[0] = nums[0];
		int result = nums[0];

		for(int i = 1; i < nums.length; i++){
			System.out.println("nums[i]: " + nums[i]);
			if(nums[i] > 0){
				max[i] = Math.max(nums[i], max[i-1] * nums[i]);
				min[i] = Math.min(nums[i], min[i-1] * nums[i]);
				System.out.println("positive max[i]: " + max[i]);
				System.out.println("min[i]: " + min[i]);
			}else{
				max[i] = Math.max(nums[i], min[i-1] * nums[i]);
				min[i] = Math.min(nums[i], max[i-1] * nums[i]);	

				System.out.println("negative max[i]: " + max[i]);
				System.out.println("min[i]: " + min[i]);
			}
			result = Math.max(result, max[i]);
		}
		return result;
	}

}

