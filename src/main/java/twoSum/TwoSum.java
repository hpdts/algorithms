package twoSum;

import java.util.*;


public class TwoSum {

    //http://www.programcreek.com/2012/12/leetcode-solution-of-two-sum-in-java/
	public int[] getTwoSumIndexes(int[] numbers, int target){
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int[] result = new int[2];
     
        for (int i = 0; i < numbers.length; i++) {
            if (map.containsKey(numbers[i])) {
                int index = map.get(numbers[i]);
                result[0] = index + 1 ;
                result[1] = i + 1;
                break;
            } else {
                map.put(target - numbers[i], i);
            }
        }
     
        return result;
	}

	
}