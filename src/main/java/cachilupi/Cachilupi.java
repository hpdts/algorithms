package cachilupi;

import java.util.*;
import com.google.common.collect.*;

public class Cachilupi{

	public boolean isNumberACachilupi(String candidateNumber){
		for(int i = 0; i < candidateNumber.length() ; i++){
			int expectedOccurrencesOfNumber = Character.getNumericValue(candidateNumber.charAt(i));
			int currentOccurrencesOfNumber = countTotalOfNumbers(candidateNumber, i);
			if(expectedOccurrencesOfNumber != currentOccurrencesOfNumber){
				//return false;
			}
		}
		return true;
	}

	public int countTotalOfNumbers(String candidateNumber, int position){
		//Map<Integer, Character> charOcurrences = new HashMap<Integer, Character>(); 
		Multiset charOcurrences = Multisets.newHashMultiset();
		int zerosCounter = 0;
		for(int i = 0; i < candidateNumber.length() ; i++){
			charOcurrences.add(candidateNumber.charAt(i));
			if(position == 0 && Character.getNumericValue(candidateNumber.charAt(i)) == 0){
				zerosCounter++;		
			}

		}	

		return zerosCounter;
	}
}