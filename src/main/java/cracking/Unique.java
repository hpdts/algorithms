package binaryTree;

import java.util.*;

//Using set you can support unicodes, not with counting sort the array can not be that big
public class Unique {
	final int asciiMaximun = 256;

	public boolean hasAllUniqueCharacters(String input){
		Set<Character> uniques = new HashSet<>();
		if(input == null || "".equals(input)){
			throw new RuntimeException("Input empty or null");
		}

		for(Character charString : input.toCharArray()){
			if(!uniques.add(charString)){
				return false;
			}
		}
		return true;
	}


	public boolean uniqueCharsCountingSort(String input){
		int[] uniques = new int[asciiMaximun];
		if(input == null || "".equals(input)){
			throw new RuntimeException("Input empty or null");
		}

		for(Character charString : input.toCharArray()){
			int index = (int) charString;
			if(index > asciiMaximun){
				throw new RuntimeException("Just ASCII chars not : " + index);
			}
			if(uniques[index] == 0){
				uniques[index] = index;
			}else {
				return false;
			}
		}
		return true;
	}

	public boolean uniqueCharsCountingSortUsingBoolean(String input){
		boolean[] uniques = new boolean[asciiMaximun];
		if(input == null || "".equals(input)){
			throw new RuntimeException("Input empty or null");
		}

		for(Character charString : input.toCharArray()){
			int index = (int) charString;
			if(index > asciiMaximun){
				throw new RuntimeException("Just ASCII chars not : " + index);
			}
			if(uniques[index]){
				return false;
			}else {
				uniques[index] = true;
			}
		}
		return true;
	}

	public boolean isUniqueChars2(String str) 
	{
		if(str == null || "".equals(str)){
			throw new RuntimeException("Input empty or null");
		}
	 	if (str.length() > 256){
	 		return false;
	 	} 
		boolean[] char_set = new boolean[256];
		for (int i = 0; i < str.length(); i++) {
 			int val = str.charAt(i);
 			if(val > asciiMaximun){
				throw new RuntimeException("Just ASCII chars not : " + val);
			}
			if (char_set[val]) { // Already found this char in string
 				return false;
 			}
			char_set[val] = true;
 		}
 		return true;
 	}

 	public boolean isUniqueChars(String str) {
		int checker = 0;
		System.out.println("int a: " + (int) 'a');
		for (int i = 0; i < str.length(); i++) 
		{
			System.out.println("NEW char: " + str.charAt(i));
			System.out.println("int char: " + (int) str.charAt(i));
			int val = str.charAt(i) - 'a';
			System.out.println("val: " + val);
			System.out.println("i: " + i);
			System.out.println("(i << val): " + (i << val));
			System.out.println("checker: " + checker);
			System.out.println("checker & (i << val): " + (checker & (i << val)));
			if ((checker & (i << val)) > 0) {
				return false;
			}
			checker |= (i << val);
			System.out.println("|= (i << val): " + checker);
		}
		return true;
	}
}
