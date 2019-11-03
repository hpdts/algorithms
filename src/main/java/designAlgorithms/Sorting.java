package designAlgorithms;

import java.util.*;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Sorting{

	public int[] countingSort(int[] numbers, int range){
		int[] countingArray = new int[range+1];

		for(int number : numbers){
			countingArray[number]++;
		}

		//System.out.println("String: " + Arrays.toString(numbers));
		//System.out.println("counts: " + Arrays.toString(countingArray));

		int[] sortedArray = new int[numbers.length];

		int indexSortedArray = 0;
		for(int i = 0; i < (range + 1); i++){
			int count = countingArray[i];
			//System.out.println("count: " + count);
 
			for(int j = 0; j < count; j++){
				sortedArray[indexSortedArray++] = i;
				//System.out.println("element: " + i);
			}
		}

		return sortedArray;
	} 

	public int[] removeDuplicates(int[] numbers){
		int[] uniques = new int[numbers.length];
		int uniqueIndex = 0;

		for(int i = 0; i < numbers.length; i++){
			int j;
			for(j = 0;j < i; j++){
				System.out.println("numbers[i]: " + numbers[i] + " == " + ", numbers[j]: " + numbers[j]);
				if(numbers[i] == numbers[j]){
					break;
				}
			}

			if(i == j){
				System.out.println("unique: " + numbers[i] + ", i: " + i);

				uniques[uniqueIndex++] = numbers[i];
			}
		}
		return uniques;
	}

	public int[] removeDuplicatesSorting(int[] numbers){
		int[] uniques = new int[numbers.length];
		Arrays.sort(numbers);

		int indexUnique = 0;
		int previousNumber = numbers[0];
		uniques[indexUnique++] = numbers[0];
		for(int i = 0; i < numbers.length; i++){
			if(previousNumber != numbers[i]){
				uniques[indexUnique++] = numbers[i];
			}
			previousNumber = numbers[i];
		}
		return uniques;
	}

	public boolean isEditDistanceOne(String string1, String string2) { 
	    // Find lengths of given strings 
	    int sizeString1 = string1.length(), sizeString2 = string2.length(); 
	  
	    // If difference between lengths is  
	    // more than 1, then strings can't  
	    // be at one distance 
	    if (Math.abs(sizeString1 - sizeString2) > 1){
	    	System.out.println("too big");
	        return false; 
	    }
	  
	    int count = 0; // Count of edits 
	  
	    int i = 0, j = 0; 
	    while (i < sizeString1 && j < sizeString2) 
	    { 
	        // If current characters don't match 
	        System.out.println("string1.charAt(i): " + string1.charAt(i) +" != string2.charAt(j): " + string2.charAt(j));
	        if (string1.charAt(i) != string2.charAt(j)) 
	        { 
	        	System.out.println("count: " + count);
	            if (count == 1) {
	                return false; 
	            }
	  
	            // If length of one string is 
	            // more, then only possible edit 
	            // is to remove a character 
	            if (sizeString1 > sizeString2) {
	                i++; 
	            }
	            else if (sizeString2 < sizeString2) {
	                j++; 
	            }
	            else // Iflengths of both strings // is same 
	            { 
	                i++; 
	                j++; 
	            } 
	            // Increment count of edits  
	            count++; 
	        } else // If current characters match 
	        { 
	            i++; 
	            j++; 
	        } 
	    } 
	  
	    // If last character is extra  
	    // in any string 
	    if (i < sizeString1 || j < sizeString2) {
	        count++; 
	    }
	  	System.out.println("count: " + count);
	    return count == 1; 
	} 

	public int[] mergeSort(int[] a, int[] b){
		int[] c = new int[a.length + b.length];
		int indexA = 0; 
		int indexB = 0; 
		int indexC = 0; 

		while(indexA < a.length && indexB < b.length){
			if(a[indexA] < b[indexB]){
				c[indexC++] = a[indexA++];
			}else if(a[indexA] > b[indexB]){
				c[indexC++] = b[indexB++];
			}else{
				c[indexC++] = a[indexA++];
				c[indexC++] = b[indexB++];
			}
		}
		System.out.println("indexA: " + indexA);
		System.out.println("indexB: " + indexB);
		System.out.println("indexC: " + indexC);
		if(indexA < a.length){
			for(int i = indexA; i < a.length; i++){
				c[indexC++] = a[i];
			}
		}
		if(indexB < b.length){
			for(int i = indexB; i < b.length; i++){
				c[indexC++] = b[i];
			}
		}
		return c;
	}

	public int[] sortScores(int[] unsortedScores, int HIGHEST_POSSIBLE_SCORE){
		int[] countingArray = new int[HIGHEST_POSSIBLE_SCORE+1];
		//count
		for(int score : unsortedScores){
			countingArray[score]++;
		} 

		//int[] sortedArray = new int[unsortedScores.length];

		int indexSortedArray = 0;
		for(int i = countingArray.length - 1; i > 0 ;i--){
			int count = countingArray[i];
			for(int j=0; j < count; j++){
				unsortedScores[indexSortedArray++] = i;
			}
		}
		return unsortedScores;
	}


}