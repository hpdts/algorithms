package cracking.hard;

import java.util.*;

public class Hard {

	public int add(int a, int b) {
	 	if (b == 0){
	 		return a;	
	 	} 
	 	int sum = a ^ b; // add without carrying
	 	int carry = (a & b) << 1; // carry, but don't add
	 	return add(sum, carry); // recurse
	}

	int rand(int lower, int higher) {
	 	return lower + (int)(Math.random() * (higher - lower + 1));
	}

	void shuffleArrayInteratively(int[] cards) {
		 for (int i = 0; i < cards.length; i++) {
			int k = rand(0, i);
			int temp = cards[k];
			cards[k] = cards[i];
			cards[i] = temp;
		}
 	}

 	/*public int partition(int[] array, int left, int right, int pivot) {
		while (true) {
			while (left <= right && array[left] <= pivot) {
				left++;
			}
		
			while (left <= right && array[right] > pivot) {
				right--;
			}
			
		
			if (left > right) {
				return left - 1;
			}
			swap(array, left, right);
		}
	 }

	public void swap(int[] array, int left, int right){
		int temp = array[left];
		array[left] = array[right];
		array[right] = temp;
	}

	public int rank(int[] array, int left, int right, int rank) {
	 	int pivot = array[rand(left, right)];
		
	 	//Partition and return end of left partition
	 	int leftEnd = partition(array, left, right, pivot);
		
	 	int leftSize = leftEnd - left + 1;
	 	if (leftSize == rank + 1) {
	 		return max(array, left, leftEnd);
	 	} else if (rank < leftSize) {
	 		return rank(array, left, leftEnd, rank);
	 	} else {
	 		return rank(array, leftEnd + 1, right, rank - leftSize);
	 	}
	}*/

	//max get in a range

	//rotate array
	public void rotate(int[] nums, int k) {
	    if(k > nums.length){ 
	        k=k%nums.length;
	    }

	    int[] result = new int[nums.length];
	 
	 	//adding elements to rotate from end to the beginning
	 	System.out.println("nums.length: " + nums.length);
	    System.out.println("k: " + k);
	    for(int i=0; i < k; i++){
	    	System.out.println("nums.length-k+i: " + (nums.length-k+i));
	        result[i] = nums[nums.length-k+i];
	    }
	 	System.out.println("resul1: " + Arrays.toString(result));
	    
	    int j=0;
	    for(int i=k; i<nums.length; i++){
	    	System.out.println("i: " + i + ",j: " + j);
	    	System.out.println("result[i]: " + result[i] + ", nums[j]: " + nums[j]);
	        result[i] = nums[j];
	        j++;
	    }
	 	System.out.println("resul2: " + Arrays.toString(result));
	    System.arraycopy( result, 0, nums, 0, nums.length );
	}

	public char[] reverseWords(char[] s) {
	    int i=0;
	    for(int j=0; j<s.length; j++){
	        if(s[j]==' '){
	        	System.out.println("words starts at: " + i + "ends at: " + (j-1));
	            reverse(s, i, j-1);        
	            i=j+1;
	        }
	    }
		System.out.println("last word chars: " + Arrays.toString(s));
		System.out.println("i: " + i);
	 	
	    reverse(s, i, s.length-1);
	 
	 	System.out.println("last reverse: " + Arrays.toString(s));
	    return reverse(s, 0, s.length-1);
	}
	 
	public char[] reverse(char[] s, int i, int j){
		System.out.println("before reverse: "  + Arrays.toString(s));
	    while(i<j){
	        char temp = s[i];
	        System.out.println("temp: " + temp);
	        System.out.println("i: " + i + ", j: " + j);
	        System.out.println("s[i]: " + s[i] + ", s[j]: " + s[j]);
	        s[i]=s[j];
	        s[j]=temp;
	        i++;
	        j--;
	    }
	    System.out.println("after reverse: "  + Arrays.toString(s));
	    return s;
	}

	public String reverseWord(String word){
		char[] chars = word.toCharArray();
		int length = chars.length;
		int j = length-1;
		for(int i = 0; i < j; i ++){
			System.out.println("i: " + i + "j: " + j);
			System.out.println("chars[i]: " + chars[i] + "chars[i]: " + chars[j]);
			swap(chars, i , j);
			j--;
		}
		return new String(chars);

	}

	public void swap(char[] chars, int indexElem1, int indexElem2){
		char temp = chars[indexElem1];
	    chars[indexElem1] = chars[indexElem2];
	    chars[indexElem2] = temp;
	}

	//public void rotateArrayOnce(int[] array){
		//int length = array.length;
		/*int temp1 = array[1];
		array[1] = array[0];
		int temp2 = array[2];
		array[2] = temp1;
		array[0] = temp2;*/

		/*for(int i=0; i < length-2; i++){
			System.out.println("i:" + i + ", i+1: " + (i+1));
			int temp1 = array[i+1];
			array[i+1] = array[i];
			//array[i] = temp;
			//temp = array[i+1];
		}*/
		//array[0] = temp;*/
	//}


}