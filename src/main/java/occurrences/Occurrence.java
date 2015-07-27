package occurrences;

import java.util.*;
import com.google.common.collect.*;


public class Occurrence{

    private Map<Integer, Integer> occurrences = new HashMap<Integer, Integer>();

	public void oddOccurrences(int[] numbers){
        
        getOccurrences(numbers);

        StringBuilder odds = new StringBuilder();
        for(Integer numberKey : occurrences.keySet()){
            if(!(occurrences.get(numberKey) % 2 == 0) ){
                if(odds.length() == 0){
                    odds.append(numberKey);
                }else{
                    odds.append(", " + numberKey);    
                }
            }
        }
        System.out.print("Numbers with odd occurrences: " + odds.toString());
    }

	public void evenOccurrences(int[] numbers){

        getOccurrences(numbers);

        StringBuilder evens = new StringBuilder();
        for(Integer numberKey : occurrences.keySet()){
            if(occurrences.get(numberKey) % 2 == 0){
                if(evens.length() == 0){
                    evens.append(numberKey);
                }else{
                    evens.append(", " + numberKey);    
                }
            }
        }
        System.out.print("Numbers with even occurrences: " + evens.toString());
    }

    private void getOccurrences(int[] numbers){
        for(int number : numbers){
            if(occurrences.containsKey(number)){
                occurrences.put(number, occurrences.get(number) + 1);
            }else{
                occurrences.put(number, 1);
            }
        }
    }

}