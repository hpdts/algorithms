package interviewExposed;

import java.util.*;
import java.util.Arrays;
import java.util.stream.Collectors;

public class AdjacentHouses{

	public List<Integer> cellCompetes(int[] states, int days){
		int[] previousState = states.clone();
		int[] currentState = previousState.clone();
		int leftIndex, centerIndex, rightIndex;


		while(days > 0){
			previousState = currentState.clone();
			//check ends o for unnocupied space 0 at ends
			//first item
			if(states.length > 1){//1,0
				currentState[0] = (0 == previousState[1]) ? 0 : 1;
				currentState[states.length - 1] = (previousState[states.length - 2] == 0) ? 0 : 1;
			}else{//1
				currentState[0] = 0;
			}
			for(int i = 0; i < (states.length - 2); i++){
				leftIndex = i;
				centerIndex = i + 1;
				rightIndex = i + 2;
				System.out.println("leftIndex: " + leftIndex + " ,centerIndex: " + centerIndex + ", rightIndex: " + rightIndex);
				System.out.println("previousState[leftIndex]: " + previousState[leftIndex] + ", previousState[centerIndex]: " + previousState[centerIndex] + " ,previousState[rightIndex]: " + previousState[rightIndex] );
				//either active or inactive
				currentState[centerIndex] = (previousState[leftIndex] == previousState[rightIndex]) ? 0 : 1;				
			}
		
			days--;
		}
		return Arrays.stream(currentState).boxed().collect(Collectors.toList());
	}
}