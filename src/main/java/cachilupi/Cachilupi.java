package cachilupi;

import java.util.*;
import com.google.common.collect.*;


public class Cachilupi{

	private	Multiset<Character> charOcurrences = HashMultiset.create();

	public boolean isNumberACachilupi(String candidateNumber){
		charOcurrences = occurrencesOfNumbers(candidateNumber);
		System.out.println("0 times: " + charOcurrences.count("0"));
		for(int i = 0; i < candidateNumber.length() ; i++){
			int expectedOccurrencesOfNumber = Character.getNumericValue(candidateNumber.charAt(i));
			//if(expectedOccurrencesOfNumber != currentOccurrencesOfNumber){
				//return false;
			//}
		}
		return true;
	}

	private Multiset<Character> occurrencesOfNumbers(String candidateNumber){
		for(int i = 0; i < candidateNumber.length() ; i++){
			charOcurrences.add(candidateNumber.charAt(i));
		}	
		return charOcurrences;
	}
}