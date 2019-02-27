package interviewExposed;

import java.util.*;
import java.util.Arrays;

public class GreatestCommonDivisor{

	public int findGCD(int size, int[] numbers){
		if(size == 0){
			throw new RuntimeException("no numbers input");
		} 

		int common = 1;
		int candidate = common;
		int min = Arrays.stream(numbers).min().getAsInt();
		//candidate = min;
		while(candidate <= min){
			candidate++;
			boolean isDivisor = true;
			//System.out.println("candidate: " + candidate);
			for(int i=0; i < size; i++){
				if((numbers[i] % candidate) != 0){
					isDivisor = false;
					break;
				}
			}
			if(isDivisor){
				common = candidate;
			}
		}
		return common;
	}

	public int findGCD2Numbers(int a, int b){
		if(a == 0){
			return b;
		}
		return findGCD2Numbers(b % a, a);
	}

	public int findGCDNumbers(int[] numbers){
		int result = numbers[0];
		for(int i = 1; i < numbers.length; i++){
			result = findGCD2Numbers(numbers[i], result);
		}
		return result;
	}

}