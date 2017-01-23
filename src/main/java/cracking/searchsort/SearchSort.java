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

	public int[] sortMerge(int inputArr[]) {
        doMergeSort(inputArr, 0, inputArr.length - 1);
        return inputArr;
    }

	 public void doMergeSort(int inputArr[], int lowerIndex, int higherIndex) {
         
        if (lowerIndex < higherIndex) {
            int middle = lowerIndex + (higherIndex - lowerIndex) / 2;
            // Below step sorts the left side of the array
            System.out.println("First call lowerIndex: " + lowerIndex + ", higherIndex: " + middle);
		
            doMergeSort(inputArr, lowerIndex, middle);
            // Below step sorts the right side of the array
            System.out.println("Second call lowerIndex: " + (middle +1) + ", higherIndex: " + higherIndex);

            doMergeSort(inputArr, middle + 1, higherIndex);
            // Now merge both sides
            System.out.println("Merge lowerIndex: " + lowerIndex + ", middle: " + middle + ", higherIndex: " + higherIndex);
	
            mergeParts(inputArr, lowerIndex, middle, higherIndex);
        }
    }
 
    private void mergeParts(int array[], int lowerIndex, int middle, int higherIndex) {
 		
 		System.out.println("lowerIndex: " + lowerIndex + ", middle: " + middle + ", higherIndex: " + higherIndex);
		int[] tempMergArr = new int[array.length];
        for (int i = lowerIndex; i <= higherIndex; i++) {
            tempMergArr[i] = array[i];
        }

        System.out.println("temp sorted: " + Arrays.toString(array));

        int i = lowerIndex;
        int j = middle + 1;
        int k = lowerIndex;
        while (i <= middle && j <= higherIndex) {
        	System.out.println("tempMergArr[i]: " + tempMergArr[i] + ", tempMergArr[j]: " + tempMergArr[j]);
            if (tempMergArr[i] <= tempMergArr[j]) {
                array[k] = tempMergArr[i];
                i++;
            } else {
                array[k] = tempMergArr[j];
                j++;
            }
            k++;
        }
        while (i <= middle) {
            array[k] = tempMergArr[i];
            k++;
            i++;
        }
 
    }

	public void iterativeMergesort(int[] a) {
      int[] aux = new int[a.length];
      for (int blockSize = 1; blockSize < a.length; blockSize *= 2){
         for (int start = 0; start < a.length; start += 2*blockSize){
            merge(a, aux, start, start + blockSize, start + 2*blockSize);
         }
      }  
   	}

   	private void merge(int[] a, int[] aux, int lo, int mid, int hi) {
       // DK: add two tests to first verify "mid" and "hi" are in range
       if (mid >= a.length){
       		return;
       } 
       if (hi > a.length){
       		hi = a.length;
       } 
       int i = lo, j = mid;
       for (int k = lo; k < hi; k++) {
          if (i == mid){
          	 aux[k] = a[j++];
          } else if (j == hi) {
          	aux[k] = a[i++];
          } else if (a[j] < a[i]){
          	aux[k] = a[j++];
          } else{
          	 aux[k] = a[i++];
          }                  
       }
       // copy back
       for (int k = lo; k < hi; k++){
          a[k] = aux[k];
       }
    }

    public int sortCountEmpty(String[] words){
    	String temp = "";
    	int count = 0;
    	if(words[0].equals("")){
    		count++;
    	}
    	for(int i = 1; i < words.length ; i++){
    		if(words[i].equals("")){
    			count++;
    		}
    		for(int j = i; j > 0 ; j--){
    			if(words[j].compareTo(words[j-1]) > 0){
    				temp = words[j-1];
    				words[j-1] = words[j];
    				words[j] = temp;
    			}
    		}
    	}
    	return count;
    }


    //binarySearch
    public boolean binarySearch2(String[] words, String target, int start, int end){
    	while(end > start){
    		int middle = (start + end) / 2;
    		if(words[middle].equals(target)){
    			return true;
    		}

    		if(words[middle].compareTo(target) > 0){
    			start = middle + 1;
    		}else{
    			end = middle - 1;
    		}
    	}
    	return false;
    }

    public int searchR(String[] strings, String str, int first, int last) {
		if (first > last){
			return -1;	
		} 
		/* Move mid to the middle */
		int mid = (last + first) / 2;
		/* If mid is empty, find closest non-empty string. */
		if (strings[mid].isEmpty()) {
			int left = mid - 1;
		 	int right = mid + 1;
		 	while (true) {
				if (left < first && right > last) {
					return -1;
				} else if (right <= last && !strings[right].isEmpty()) {
		 			mid = right;
		 			break;
				} else if (left >= first && !strings[left].isEmpty()) {
		 			mid = left;
		 			break;
		 		}
				right++;
		 		left--;
		 	}
		 }
		
		 /* Check for string, and recurse if necessary */
		if (str.equals(strings[mid])) { // Found it!
		 	return mid;
/* The value 0 if the argument is a string lexicographically equal 
to this string; a value less than 0 if the argument is a string lexicographically 
greater than this string; and a value greater than 0 if the argument is a string 
lexicographically less than this string.*/

		} else if (strings[mid].compareTo(str) < 0) { // Search right
		 	return searchR(strings, str, mid + 1, last);
		} else { // Search left
		 	return searchR(strings, str, first, mid - 1);
		 }
	}
		
	public int search(String[] strings, String str) {
		if (strings == null || str == null || str == "") {
		 return -1;
		}
		return searchR(strings, str, 0, strings.length - 1);
	}

	public boolean searchOnMatrix(int[][] matrix, int target){
		for(int i = 0; i < matrix[0].length; i++){
			System.out.println("Begin: " + matrix[i][0] + ", end: " + matrix[i][matrix.length - 1]);
			//if(Arrays.binarySearch(matrix[i], target) > 0){
			if(binarySearchFromHeart(matrix[i], target) > 0){
				return true;
			}
		}		
		return false;
	}

	public int binarySearchFromHeart(int[] matrix, int target){
		int start = 0;
		int end = matrix.length - 1;
		while(start <= end){
			int middle = (start + end) / 2;
			if(matrix[middle] == target){
				return middle;
			}

			if(target < matrix[middle]){
				end = middle -1;
			}else{
				start = middle + 1;
			}
		}
		return -1;
	}

	public int binarySearchBook(int[] a, int x) {
		int low = 0;
		int high = a.length - 1;
		int mid;
		
		while (low <= high) {
			mid = (low + high) / 2;
			if (a[mid] < x) {
				low = mid + 1;
			 } else if (a[mid] > x) {
			 	high = mid - 1;
			 } else {
			 	return mid;
			 }
		 }
		 return -1; // Error
	 }

	public static boolean findElement(int[][] matrix, int elem) {
		int row = 0;
		int col = matrix[0].length - 1;
		while (row < matrix.length && col >= 0) {
			System.out.println("matrix[row][col]:" + matrix[row][col]);
			System.out.println("row: " + row + ", col:" + col);
			
			if (matrix[row][col] == elem) {
		 		return true;
			} else if (matrix[row][col] > elem) {
				col--;
			} else {
		 		row++;
		 	}
		 }
		 return false;
	}

	public static class Person{
		int height;
		int weight;

		Person(int height, int weight){
			this.height = height;
			this.weight = weight;
		}

		public int compareTo(Person person2){
			int comparison = Integer.compare(this.height, person2.height);
			if(comparison == 0){
				return Integer.compare(this.weight, person2.weight);
			}
			return comparison;
		}

		public String toString(){
			return "height: " + height + ", weight: " + weight;
		}
	}

	public Person[] selectionSortPerson(Person[] matrix){
		Person temp = null;
		for(int i = 0; i < matrix.length; i++){
			for(int j = i; j > 0; j--){
				//> 0 p1 greater than p2
				if(matrix[j].compareTo(matrix[j-1]) > 0){
					temp = matrix[j-1];
					matrix[j-1] = matrix[j];
					matrix[j] = temp;
				}
			}
		}
		return matrix;
	}

	public void mergesort(Person[] array) {
		Person[] helper = new Person[array.length];
		mergesort(array, helper, 0, array.length - 1);
	}
	
	public void mergesort(Person[] array, Person[] helper, int low, int high) {
		if (low < high) {
			int middle = (low + high) / 2;
			mergesort(array, helper, low, middle); // Sort left half
			mergesort(array, helper, middle + 1, high); // Sort right half
			merge(array, helper, low, middle, high); // Merge them
		}
	}
	
	public void merge(Person[] array, Person[] helper, int low, int middle, int high) {
		/* Copy both halves into a helper array */
		for (int i = low; i <= high; i++) {
			helper[i] = array[i];
		}
		
		int helperLeft = low;
		int helperRight = middle + 1;
		int current = low;
		
		/* Iterate through helper array. Compare the left and right
		* half, copying back the smaller element from the two halves
		* into the original array. */
		while (helperLeft <= middle && helperRight <= high) {
			if (helper[helperLeft].compareTo(helper[helperRight]) > 0) {
				array[current] = helper[helperLeft];
				helperLeft++;
			} else { // If right element is smaller than left element
				array[current] = helper[helperRight];
				helperRight++;
			}
			current++;
		}
	
	 	/* Copy the rest of the left side of the array into the
	 	* target array */
	 	int remaining = middle - helperLeft;
	 	for (int i = 0; i <= remaining; i++) {
	 		array [current + i] = helper[helperLeft + i];
	 	}
	 }

	 public ArrayList<HtWt> getIncreasingSequence(ArrayList<HtWt> items) {
		Collections.sort(items);
		return longestIncreasingSubsequence(items);
	}
	
	public void longestIncreasingSubsequence(ArrayList<HtWt> array, ArrayList<HtWt>[] solutions, int current_index) {
		if (current_index >= array.size() || current_index < 0){
			return;	
		} 
		HtWt current_element = array.get(current_index);
		
		 /* Find longest sequence we can append current_element to */
		 ArrayList<HtWt> best_sequence = null;
		 for (int i = 0; i < current_index; i++) {
		 	if (array.get(i).isBefore(current_element)) {
		 		best_sequence = seqWithMaxLength(best_sequence,
		 		solutions[i]);
	 		}
		}
	
		/* Append current_element */
	 	ArrayList<HtWt> new_solution = new ArrayList<HtWt>();
	 	if (best_sequence != null) {
	 		new_solution.addAll(best_sequence);
		}
		new_solution.add(current_element);

 		/* Add to list and recurse */
 		solutions[current_index] = new_solution;
 		longestIncreasingSubsequence(array, solutions, current_index+1);
 	}

 	public ArrayList<HtWt> longestIncreasingSubsequence(ArrayList<HtWt> array) {
 		ArrayList<HtWt>[] solutions = new ArrayList[array.size()];
 		longestIncreasingSubsequence(array, solutions, 0);
		
 		ArrayList<HtWt> best_sequence = null;
 		for (int i = 0; i < array.size(); i++) {
 			best_sequence = seqWithMaxLength(best_sequence, solutions[i]);
 		}
		
 		return best_sequence;
 	}

	/* Returns longer sequence */
	public ArrayList<HtWt> seqWithMaxLength(ArrayList<HtWt> seql, ArrayList<HtWt> seq2) {
		if (seql == null){
			return seq2;
		} 		
		if (seq2 == null){
			return seql;
		} 
		return seql.size() > seq2.size() ? seql : seq2;
	}
	
	public static class HtWt implements Comparable {
		/* declarations, etc */
		public int Ht;
		public int Wt;

		public HtWt(int height, int weight){
			this.Ht = height;
			this.Wt = weight; 
		}
		/* used for sort method */
		public int compareTo( Object s ) {
		 	HtWt second = (HtWt) s;
		 	if (this.Ht != second.Ht) {
		 		return ((Integer)this.Ht).compareTo(second.Ht);
		 	} else {
		 		return ((Integer)this.Wt).compareTo(second.Wt);
		 	}
		 }
		
		 /* Returns true if "this" should be lined up before "other."
		 * Note that it's possible that this.isBefore(other) and
		 * other.isBefore(this) are both false. This is different from
		 * the compareTo method, where if a < b then b > a. */
		public boolean isBefore(HtWt other) {
		 	if (this.Ht < other.Ht && this.Wt < other.Wt){
		 		return true;
		 	} 
		 	else{
		 		return false;
		 	} 
		 }

		public String toString(){
			return "height: " + Ht + ", weight: " + Wt;
		}
	}


	public int addSortedNumbers(LinkedList<Integer> numbers, int number){
		if(numbers.size() == 0){
			numbers.add(number);
			return 0;
		}else if(numbers.getLast() <= number){
			int size = numbers.size();
			numbers.addLast(number);
			return size;
		}else if(numbers.getFirst() >= number){
			numbers.addFirst(number);
			return 0;
		}else {
			for(int i = 0; i < numbers.size(); i++){
				if(numbers.get(i) == number){
					return i + 1;
				}else if(numbers.get(i) < number && numbers.get(i+1) > number){
					//shift values from i+1 to lenght
					//i is how number are before
					System.out.println("i: " + i);
					numbers.add(i, number);
					return i + 1;

				}
			}
		}
		return -1;

	}	
}	
			
		