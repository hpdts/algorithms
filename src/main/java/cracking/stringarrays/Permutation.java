package cracking.stringarrays;

import java.util.*;

public class Permutation {

	public boolean isAPermutation (String input1, String input2) {
		Map<Character, Integer> countCharInput1 = new HashMap<>();
		Map<Character, Integer> countCharInput2 = new HashMap<>();

		getCountByChar(countCharInput1, input1);
		getCountByChar(countCharInput2, input2);

		return countCharInput1.equals(countCharInput2);
	}

	public void getCountByChar(Map<Character, Integer> countCharInput, String input){
		for(Character letter : input.toCharArray()){
			if(countCharInput.containsKey(letter)){
				countCharInput.put(letter, countCharInput.get(letter) + 1); 	
			}else {
				countCharInput.put(letter, 1);
			}
		}
	}
	

}
