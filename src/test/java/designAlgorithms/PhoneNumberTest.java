package designAlgorithms;

import org.junit.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import com.google.common.collect.*;
import java.io.*;
import java.util.*;
import static org.junit.Assert.*;
import static designAlgorithms.LCA.*;

public class PhoneNumberTest {
	PhoneNumber phoneNumber = new PhoneNumber();

	@Test
	public void phoneNumber(){
		List<String> combinations = phoneNumber.letterCombinations("23");
		System.out.println("combinations: " + combinations.toString());

		
		assertThat(combinations.toString(), is("[ad, ae, af, bd, be, bf, cd, ce, cf]"));

		System.out.println("combinations2: " + phoneNumber.letterCombinations2("233").toString());
		System.out.println("only 2 digits");
		System.out.println("combinations2: " + phoneNumber.letterCombinations2("23").toString());
	}

	@Test
	public void phoneNumberBFS(){
	    int[] phoneNumbers = { 2, 3 }; 
        phoneNumber.letterCombinationsBFS(phoneNumbers, phoneNumbers.length);  
        System.out.println("-----------");
        phoneNumber.letterCombinationsBFS(new int[]{ 2, 3, 3 }, 3);  
        System.out.println("----------- DFS");
        phoneNumber.letterCombinationsDFS(new int[]{ 2, 3}, 2); 
        phoneNumber.letterCombinationsDFS(new int[]{ 2, 3, 4}, 3); 

	}
}