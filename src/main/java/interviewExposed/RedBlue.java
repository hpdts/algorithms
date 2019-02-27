package interviewExposed;

import java.util.*;
import java.util.regex.*;
import java.util.Arrays;
import java.util.stream.Collectors;

public class RedBlue{

	public int isPattern(String pattern, String input){  
		StringBuffer patternBuffer = new StringBuffer();

		// check input and pattern strings 
		if (pattern == null || input == null) {
			throw new IllegalArgumentException();
		}

		// pattern character array
		List<Character> chars = new ArrayList<Character>();
		for (char c : pattern.toCharArray()) {

			if (!chars.contains(c)) {
				// new character found, append new group
				patternBuffer.append("(.+)");
				chars.add(c);
			} else {
				// looking for unique sequence by number
				patternBuffer.append("\\").append(chars.indexOf(c)+1);
			}
		}
		System.out.println("patternBuffer.toString(): " + patternBuffer.toString());
		// compiling pattern and checking input string 
		Pattern patternObj = Pattern.compile(patternBuffer.toString());
		Matcher matcher = patternObj.matcher(input);
		if (matcher.find()) {
			return 1;
		}
		return 0;
	}

}
