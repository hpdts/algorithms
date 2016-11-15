package cracking.stringarrays;

import java.util.*;

public class Reverse {

	public String reverseStack(String input){
		Stack<Character> chars = new Stack<>();
		if(input == null || "".equals(input)){
			throw new RuntimeException("Input empty or null");
		}

		for(Character charString : input.toCharArray()){
			chars.push(charString);
		}

		String output = "";
	    while (!chars.isEmpty()) {
	        char ch = chars.pop(); 
	        output = output + ch; 
	    }

		return output;
	}

	public String reverseJava(String input){
		StringBuilder output = new StringBuilder(input);
		return output.reverse().toString();
	}


	//test recursive solution reverse
	public static String reverseRecursively(String str) {
        //base case to handle one char string and empty string
        if (str.length() < 2) {
            return str;
        }
        return reverseRecursively(str.substring(1)) + str.charAt(0);

    }
}
