package cracking.reboot.stringarrays;

import java.util.*;

public class MyStringBuilder{
	char[] buffer = new char[10];
	int index = 0;

	public void append(String input){
		if(buffer.length > index){
			char[] newBuffer = new char[buffer.length * 2];
			System.arraycopy(buffer, 0, newBuffer, 0, buffer.length);
			buffer = newBuffer;

		}
		char[] inputLetters = input.toCharArray();
		for(char letter : inputLetters){
			buffer[index++] = letter;
		}
		
	}

	public String toString(){
		return new String(buffer, 0, index);
	}
}