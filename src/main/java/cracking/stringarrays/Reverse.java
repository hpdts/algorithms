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

}
