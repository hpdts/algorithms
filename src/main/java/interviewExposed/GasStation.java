package interviewExposed;

import java.util.*;
import java.util.Arrays;
import java.util.stream.Collectors;

public class GasStation{

	public int minimumStartingPoint(int[] gas, int[] cost){
		int start = 0;
		int sumRemaining = 0;
		int total = 0;

		for(int i = 0; i < gas.length; i++){
			int remaining = gas[i] - cost[i];
			if(sumRemaining >= 0){
				sumRemaining += remaining;
			}else{
				sumRemaining = remaining;
                start = i;
			}
			total += remaining;
		} 
		if(total >= 0){
            return start;
		}else{
			return -1;
		}

	}

}