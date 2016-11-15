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
	

	public String sort(String s) {
	 	char[] content = s.toCharArray();
 		Arrays.sort(content);
 		return new String(content);
 	}

 	public boolean permutation(String s, String t) {
 		if (s.length() != t.length()) {
 			return false;
 		}
 		return sort(s).equals(sort(t));
 	}

 	public boolean permutationArray(String s, String t) {
		if (s.length() != t.length()) {
 			return false;
 		}

 		int[] letters = new int[256]; // Assumption

		char[] s_array = s.toCharArray();
 		for (char c : s_array) { // count number of each char in s.
 			letters[c]++;
 		}

 		for (int i = 0; i < t.length(); i++) {
 			int c = (int) t.charAt(i);
 			if (--letters[c] < 0) {
 				return false;
 			}
 		}

 		return true;
 	}

 	/*public void AllPermutation(String perm, String word) { 
 		if (word.isEmpty()) { 
 			System.err.println(perm + word); 
 		} else { 
 			for (int i = 0; i < word.length(); i++) { 
 				permutation(perm + word.charAt(i), word.substring(0, i) + word.substring(i + 1, word.length())); 
 			} 
 		} 
 	}*/

}
