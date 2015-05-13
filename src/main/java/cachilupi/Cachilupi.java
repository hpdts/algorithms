package cachilupi;

import java.util.*;
import com.google.common.collect.*;


public class Cachilupi{

	private	Multiset<Character> charOcurrences = HashMultiset.create();

	public boolean isNumberACachilupi(String candidateNumber){
		charOcurrences = occurrencesOfNumbers(candidateNumber);
		for(int i = 0; i < candidateNumber.length() ; i++){
			if(Character.getNumericValue(candidateNumber.charAt(i)) != charOcurrences.count(Character.forDigit(i, 10))){
				return false;
			}
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