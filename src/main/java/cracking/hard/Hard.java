package cracking.hard;

import java.util.*;
import static java.lang.Math.*;

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

     public int[] intersection(int[] array1, int[] array2){
     	int k = 0;
     	int i = 0;
     	int j = 0;
     	int[] intersection = new int[array1.length];

     	while(i < array1.length && j < array2.length){
     		if(array1[i] < array2[j]){
     			i++;
     		}else if(array2[j] < array1[i]){
     			j++;
     		}else{
				intersection[k++] = array2[j++];
				i++;
     		}
     	}
     	return intersection;
     }

     public int anagramsIntoString(String anagram, String container){
     	Map<Character, Integer> charCounterAnagram = getMapCountChar(anagram);
     	int anagramLenght = anagram.length();
     	char[] charsContainer = container.toCharArray(); 
     	int occurrences = 0;
     	for(int i =0; i < charsContainer.length; i= i + anagramLenght){
     		String newSlidingWindow = container.substring(i, i + anagramLenght);
     		System.out.println("newSlidingWindow: " + newSlidingWindow);
     
     		Map<Character, Integer> charCounterContainer = getMapCountChar(newSlidingWindow);
     		if(charCounterContainer.equals(charCounterAnagram)){
     			occurrences++;
     		}	
     	}
     	return occurrences;
     }

     public Map<Character, Integer> getMapCountChar(String anagram){
     	Map<Character, Integer> letterCounts = new HashMap<Character, Integer>();
     	for(Character letter : anagram.toCharArray()){
     		if(letterCounts.containsKey(letter)){
     			int count = letterCounts.get(letter);
     			letterCounts.put(letter, count++);
     		}else{
     			letterCounts.put(letter, 1);
     		}
     	}
     	return letterCounts;
     }

     class Pair{
     	int a;
     	int b;

     	Pair(int a, int b){
     		this.a = a;
     		this.b = b;
     	}
     }

     public void getallA3B3C3D3(){
     	int n = 100;
     	Map<Long, List<Pair>> cubes = new HashMap<>(); 
     	for(int i = 0; i < n; i++){
     		for (int j = 0; j < n; j++){
     			long sum = (long) (pow(i, 3) + pow(j, 3));
     			if(cubes.containsKey(sum)){
     				for(Pair pair : cubes.get(sum)){
     					System.out.println(i + " " + j + " " + pair.a + " " + pair.b);
     				}
     			}else{
     				List<Pair> pairs = new ArrayList<>();
     				cubes.put(sum, pairs);
     			}

     			cubes.get(sum).add(new Pair(i, j));
     		}
     	}
     }

     public int solvePolishNotationExpression(String[] expression){
     	LinkedList<Integer> stack = new LinkedList<>();
     	for (String value : expression){
     		if(isANumber(value)){
     			stack.addFirst(Integer.valueOf(value));
     		}else if(isOperand(value)){
     			int value2 = Integer.valueOf(stack.removeFirst()); 
     			int value1 = Integer.valueOf(stack.removeFirst()); 
     			int result = apply(value1, value2, value);
     			System.out.println("value1: " + value1 + ", value2: " + value2 + ", value: " + value + ", result: " + result);
     			stack.addFirst(result);
     		}else{
     			throw new RuntimeException("Value: " + value + " not valid.");
     		}
     		System.out.println("stack: " + stack.toString());
     	}
     	return stack.removeFirst();
     }

     public boolean isANumber(String value){
     	try{
     		Integer.parseInt(value);
     	}catch(Exception ex){
     		return false;
     	}
     	return true;
     }

     public boolean isOperand(String value){
     	if(value.matches("[+-/*]")){
     		return true;
     	}
     	return false;
     }

     public int apply(int value1, int value2, String operand){
     	if(operand.equals("+")){
     		return value1 + value2;
     	}else if(operand.equals("-")){
			return value1 - value2;
     	}else if(operand.equals("/")){
     		return value1 / value2;
     	}else if(operand.equals("*")){
     		return value1 * value2;
     	}
     	throw new RuntimeException("Wrong operand: " + operand);
     }

     public int[] add(int[] n1, int[] n2){
     	int biggerSize = Math.max(n1.length, n2.length);
     	int[] result = new int[biggerSize+1];
     	int carryOver = 0;
     	int k = result.length -1;
     	int j = n2.length - 1;
     	int i = n1.length - 1;
     	for(; i >= 0 && j >=0; i--){
     		int sum = carryOver + n1[i] + n2[j];
     		System.out.println("i: " + i + ",j: " + j + ", sum: " + sum);
     		if(sum >= 10){
     			int rest = sum - 10;
     			result[k] = rest;
     			carryOver = 1;
     		}else{
     			result[k] = sum;
     			carryOver = 0;
     		}
     		j--;
     		k--;
     	}
     	System.out.println("i: " + i + ", j : " + j + "carryOver: " + carryOver);
     	System.out.println("result: " + Arrays.toString(result));
     	//int lastNumIndex = (i > -1) ? i : (j > -1) ? : j : -1 );

 		while(j > -1){
 			if(carryOver == 1){
 				result[k] = n2[j] + carryOver;
 				carryOver = 0;
 			}else{
				result[k] = n2[j];
 			}
 			j--;
 		}

 		while(i > -1){
 			if(carryOver == 1){
 				result[k] = n1[i] + carryOver;
 				carryOver = 0;
 			}else{
				result[k] = n1[i];
 			}
 			i--;
 		}

 		if(carryOver == 1){
 			result[k] = carryOver;
 			carryOver = 0;
 		}
     	System.out.println("result2: " + Arrays.toString(result));
    
     	return result;	
     }

     public boolean areIsoMorphic(String word1, String word2){
     	if(word1.length() != word2.length()){
     		return false;
     	}
     	Map<Character, Character> mapChar = new HashMap<>();
     	for(int i =0; i < word1.length(); i ++){
     		char c1 = word1.charAt(i);
     		char c2 = word2.charAt(i);
     		System.out.println("c1: " + c1 + ", c2: " + c2);
			if(mapChar.containsKey(c1)){
				if(mapChar.get(c1) != c2){
					return false;
				}
			}else{
				if(mapChar.containsValue(c2)){
					return false;
				}
				mapChar.put(c1, c2);
			}
     	}
     	System.out.println("mapChar: " + mapChar.toString());
     	return true;
     }

}