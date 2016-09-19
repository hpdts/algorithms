package cracking.stringarrays;

import java.util.*;

public class Whitespace {

	public String replaceWhitespace (String input, int lenght) {
		String newString = "";
		//char whitespace = '%20';
		char[] inputArray = input.toCharArray();

		for(int i = 0; i < lenght; i ++){
			System.out.println("i: " + i + "," + inputArray[i]);
			if(inputArray[i] == ' '){
				System.out.println("space");
				newString = newString + "%20";
			} else {
				newString = newString + inputArray[i];
			}
		}
		return newString;
	}

	public String replaceSpaces(String input, int length) {
		char[] str0 = input.toCharArray();
 		int spaceCount = 0, newLength, i;
		for (i = 0; i < length; i++) {
			if (str0[i] == ' ') {
				spaceCount++;
			}
		}
		newLength = length + spaceCount * 2;
		char[] str = new char[newLength];
		str = Arrays.copyOf(str0, newLength);
	 	//str[newLength] = '\0';
		for (i = length - 1; i >= 0; i--) {
			if (str[i] == ' ') {
				str[newLength - 1] = '0';
 				str[newLength - 2] = '2';
 				str[newLength - 3] = '%';
 				newLength = newLength - 3;
 			} else {
 				str[newLength - 1] = str[i];
 				newLength = newLength - 1;
 			}
 		}
 		return new String(str);
 	}

}
