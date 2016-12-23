package cracking.searchsort;

import java.util.*;
import java.awt.Point;


 public class SearchSort {
	
	public int[] mergeArray(int[] a, int[] b){
		int[] c = Arrays.copyOf(a, a.length);
		int i = 0;
		int j = 0;
		int k = 0;
		while(i < b.length && j < b.length && k < a.length ){
			System.out.println("i=" + i + ",j=" + j + ",k=" + k);
			System.out.println("c[i] <= b[j]:" + c[i] + "," + b[j]);
			
			if(c[i] <= b[j]){
				System.out.println("a[k] = c[i]:" + a[k] + "," + c[i]);
				a[k++] = c[i];
				i++;
			}else{
				System.out.println("a[k] = b[j]:" + a[k] + "," + b[j]);
				a[k++] = b[j];
				j++;
			}

		}
		if(j < b.length){
			while(j < b.length){
				a[k++] = b[j++];
			}
		}

		if(i < b.length){
			while(j < b.length){
				a[k++] = b[i++];
			}
		}
		return a;			
	}

	public static void merge(int[] a, int[] b, int lastA, int lastB) {
		int indexA = lastA - 1; /* Index of last element in array a */
		int indexB = lastB - 1; /* Index of last element in array b */
		int indexMerged = lastB + lastA - 1; /* end of merged array */
		
		/* Merge a and b, starting from the last element in each */
		while (indexA >= 0 && indexB >= 0) {
			/* end of a is > than end of b */
			if (a[indexA] > b[indexB]) {
			 	a[indexMerged] = a[indexA]; // copy element
			 	indexMerged--; // move indices
			 	indexA--;
			} else {
			 	a[indexMerged] = b[indexB]; // copy element
			 	indexMerged--; // move indices
			 	indexB--;
			}
		 }
		
		 /* Copy remaining elements from b into place */
		 while (indexB >= 0) {
		 	a[indexMerged] = b[indexB];
		 	indexMerged--;
		 	indexB--;
		 }
	}

	public String[] sortStrings(String[] strings){
		Map<String, List<String>> anagram = new HashMap<>();
		for(String word : strings){
			String key = sortString(word);
			if(anagram.containsKey(key)){
				List<String> anagrams = anagram.get(key);
				anagrams.add(word);
			}else{
				List<String> anagrams = new ArrayList<>();
				anagrams.add(word);
				anagram.put(key, anagrams);
			}
		}
		String[] output = new String[strings.length];
		int index = 0;
		 for (String key : anagram.keySet()) {
		 	List<String> list = anagram.get(key);
		 	for (String word : list) {
		 		output[index] = word;
		 		index++;
		 	}
		}

		return output;
	}

	public String sortString(String string1){
		char[] chars1 = string1.toCharArray();
		Arrays.sort(chars1);
		return new String(chars1);
	}

	public boolean isAnagram(String string1, String string2){
		char[] chars1 = string1.toCharArray();
		char[] chars2 = string2.toCharArray();
		Arrays.sort(chars1);
		Arrays.sort(chars2);

		return Arrays.equals(chars1, chars2);
 
	}

	public boolean binarySearchRotated(int[] numbers, int target){
		int start = 0;
		int end = numbers.length - 1;
		while (end >= start){
			int middle = (start + end) / 2; 
			
			if(numbers[middle] == target){
				return true;
			}

			System.out.println("start: " +  start);
			System.out.println("end: " +  end);
			System.out.println("middle: " +  middle);

			if(numbers[start] < numbers[middle]){
				if(numbers[start] <= target && target < numbers[middle]){
					end = middle - 1; 
				}else{
					start = middle + 1; 
				}
			}else{
				if(numbers[middle] < target && target <= numbers[end]){
					start = middle + 1;
				}else{
					end = middle - 1;
				}
			}
			
		}	

		return false;
	}

	public boolean binarySearch(int[] numbers, int target){
		int start = 0;
		int end = numbers.length - 1;
		while (end >= start){
			int middle = (start + end) / 2; 
			if(numbers[middle] == target){
				return true;
			}
			System.out.println("start: " +  start);
			System.out.println("end: " +  end);
			System.out.println("middle: " +  middle);
			if(numbers[middle] < target){
				start = middle + 1;
			}
			if(numbers[middle] > target) {
				end = middle - 1;
			}
		}	

		return false;
	}

	public int binarySearchRecursive(int a[], int left, int right, int target){
		int middle = (left + right) / 2;
		if(left > right){
			return -1;
		}
		if(a[middle] == target){
			return middle;
		}
		if(target < a[middle]){
			return binarySearchRecursive(a, left, middle - 1, target);
		}else if(target > middle){
			return binarySearchRecursive(a, middle + 1, right, target);
		}
		return -1;

	}

	public int search(int a[] , int left, int right, int x) {
		int mid = (left + right) / 2;
		 if (x == a[mid]) { // Found element
		 	return mid;
		 }
	
		if (right < left) {
			return -1;
		}
		
		 /* Either the left or right half must be normally ordered. Find
		 * out which side is normally ordered, and then use the normally
		 * ordered half to figure out which side to search to find x. */
		 if (a[left] < a[mid]) { // Left is normally ordered.
		 	if (x >= a[left] && x <= a[mid]) {
		 		return search(a, left, mid - 1, x); // Search left
		 	} else {
		 		return search(a, mid + 1, right, x); // Search right
		 	}
		 } else if (a[mid] < a[left]) { // Right is normally ordered.
		 	if (x >= a[mid] && x <= a[right]) {
		 		return search(a, mid + 1, right, x); // Search right
		 	} else {
		 			return search(a, left, mid - 1, x); // Search left
		 	}
		} else if (a[left] == a[mid]) { // Left half is all repeats
		 	if (a[mid] != a[right]) { // If right is diff., search it
		 		return search(a, mid + 1, right, x); // search right
		 	} else { // Else, we-have to search both halves
		 		int result = search(a, left, mid - 1, x); // Search left
		 		if (result == -1) {
		 			return search(a, mid + 1, right, x); // Search right
		 		} else {
		 			return result;
		 		}
		 	}
		 }
	 	return -1;
	 }

	 public int[] insertionSort(int[] input){
	 	int temp = 0, minor;
	 	for(int i = input.length -1; i > 0; i--){
	 		minor = 0;
	 		for(int j=1; j <= i; j++){
	 			if(input[j] < input[minor]){
	 				minor = j;
	 			}
	 		}
	 		temp = input[minor];
	 		input[minor] = input[i];
	 		input[i] = temp;
	 	}	
	 	return input;
	 }
 }	
	
