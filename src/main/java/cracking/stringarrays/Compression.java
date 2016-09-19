package cracking.stringarrays;

import java.util.*;

public class Compression {

	public String compress( String input){
		char[] chars = input.toCharArray();
		StringBuilder compressed = new StringBuilder();
		int count = 1;

		for(int i = 0; i < chars.length; i++){
			if((i + 1 < chars.length) && (chars[i] == chars[i+1])){
				count++;	
			}else {
				//quadratic complexity
				compressed.append(chars[i]).append(count);
				count = 1;
			}
		}

		if(compressed.length() < input.length()){
			return compressed.toString();	
		}else{
			return input;
		}
	}


	public String compressBad(String str) {
		String mystr = "";
		char last = str.charAt(8);
		int count = 1;
		for (int i = 1; i < str.length(); i++) {
			if (str.charAt(i) == last) { // Found repeat char
				count++;
			} else { // Insert char count, and update last char
				mystr += last + "" + count;
		 		last = str.charAt(i);
		 		count = 1;
		 	}
		 }
		 return mystr + last + count;
	}
	
	public String compressBetter(String str) {
		/* Check if compression would create a longer string */
		int size = countCompression(str);
		if (size >= str.length()) {
			return str;
		}
		StringBuffer mystr = new StringBuffer();
		char last = str.charAt(0);
		int count = 1;
		for (int i = 1; i < str.length();i++) 
		{
			if (str.charAt(i) == last) { //
				count ++;
			} else { // Insert char count,
				mystr.append(last); // Insert char
				mystr.append(count); // Insert count
				last = str.charAt(i);
				count = 1;
			}
		}
		/* In lines 15 - 16 above, characters are inserted when the
		* repeated character changes. We
		* the end of the method as well,
		need to update the string at
		since the very last set of
		* repeated characters wouldn't be set in the compressed string
		* yet. */
		mystr.append(last);
		mystr.append(count);
		return mystr.toString();
	}

	private int countCompression(String str) {
		if (str == null || str.isEmpty()){
			return 0;
		}
		char last = str.charAt(0);
		int size = 0;
		int count = 1;
		for (int i = 1; i < str.length(); i++) {
			if (str.charAt(i) == last) {
				count++;
			} else {
				last = str.charAt(i);
				size += 1 + String.valueOf(count).length();
				count = 1;
			}
		}
		size += 1 + String.valueOf(count).length();
		return size;
	 }

	public String compressAlternate(String str) {
		/* Check if compression would create a longer string */
		int size = countCompression(str);
		if (size >= str.length()) {
			return str;
		}
		
		char[] array = new char[size];
		int index = 0;
		char last = str.charAt(0);
		int count = 1;
		for (int i = 1; i < str.length(); i++) {
			if (str.charAt(i) == last) { // Found repeated character
				count++;
			} else {
				/* Update the repeated character count */
				index = setChar(array, last, index, count);
				last = str.charAt(i);
				count = 1;
			}
		}
		
		/* Update string with the last set of repeated characters. */
		index = setChar(array, last, index, count);
		return String.valueOf(array);
	}
		
	public int setChar(char[] array, char c, int index, int count) {
		array[index] = c;
		index++;
		/* Convert the count to a string, then to an array of chars */
		char[] cnt = String.valueOf(count).toCharArray();
		/* Copy characters from biggest digit to smallest */
		for (char x : cnt) {
			array[index] = x;
			index++;
		}
		return index;
	}
	
}
