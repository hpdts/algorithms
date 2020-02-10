package cracking.reboot.stringarrays;

import java.util.*;

public class Strings {

	public boolean isHasAllUniqueCharacters(String word){
		//ASCII: American Standard Code for Information Interchange only 1 byte
		//7 bits 2^7
		if(word.length() > 128){
			return false;
		}

		boolean[] char_set = new boolean[128];
		for(int i = 0; i < word.length(); i++){
			int val = word.charAt(i);
			System.out.println("val int: " + val);
			System.out.println("word.charAt(i): " + word.charAt(i));
			if(char_set[val]){
				return false;
			}
			char_set[val] = true;
		}
		return true;
	}

	public boolean isUnique(int[] array){
		Arrays.sort(array);
		for(int i = 0; i < array.length - 1; i++){
			if(array[i] == array[i+1]){
				return false;
			}
		}
		return true;
	} 

	public boolean arePermutations(String word1, String word2){
		char[] lettersWord1 = word1.toCharArray();
		char[] lettersWord2 = word2.toCharArray();

		Arrays.sort(lettersWord1);
		Arrays.sort(lettersWord2);

		return Arrays.equals(lettersWord1, lettersWord2);
	}

	public boolean arePermutations2(String word1, String word2){
		if(word1.length() != word2.length()){
			return false;
		}

		int[] lettersCountWord1 = new int[128];
		for(int i = 0; i < word1.length(); i++){
			lettersCountWord1[word1.charAt(i)]++;
		}

		for(int i=0; i < word2.length() ; i++){
			lettersCountWord1[word2.charAt(i)]--;
			if(lettersCountWord1[word2.charAt(i)] < 0){
				return false;
			}
		}
		return true;
	}

	public int countCharacters(char[] word, int start, int end, char target){
		int count = 0;
		for(int i = start; i < end; i++){
			if(word[i] == target){
				count++;
			}
		}
		return count;
	}

	public void replaceSpaces(char[] word, int trueLength){
		int numberSpaces = countCharacters(word, 0, trueLength, ' ');
		int newIndex = trueLength - 1 + numberSpaces * 2;

		System.out.println("newIndex: " + newIndex);
		System.out.println("numberSpaces: " + numberSpaces);

		if(newIndex + 1 < word.length){
			word[newIndex + 1] = '\0';
		}

		for(int oldIndex = trueLength -1; oldIndex >= 0; oldIndex-=1){
			System.out.println("word[oldIndex]: " + word[oldIndex]);
			System.out.println("oldIndex: " + oldIndex);
			System.out.println("newIndex: " + newIndex);
			
			if(word[oldIndex] == ' '){
				word[newIndex] = '0';
				word[newIndex - 1] = '2';
				word[newIndex - 2] = '%';
				newIndex-=3;
			}else{
				word[newIndex] = word[oldIndex];
				newIndex-=1;
			}
		}
	}

	public boolean isPalindromePermutation(String word){
		boolean isPalindrome = true;
		Map<Character, Integer> counts = new HashMap<>();
		for(char letter : word.toCharArray()){
			if(counts.containsKey(letter)){
				int count = counts.get(letter); 
				counts.put(letter, count+1);
			}else{
				counts.put(letter, 1);
			}
		}

		System.out.println("map: " + counts.toString());

		boolean hasOneCount = false;
		//boolean isPalindrome = true;
		for(Map.Entry<Character, Integer> entry : counts.entrySet()){
			char letter = entry.getKey();
			int value = entry.getValue();

			if(value == 1){
				if(hasOneCount){
					isPalindrome = false;
					return isPalindrome;
				}
				hasOneCount = true;
			}
		}

		return isPalindrome;
	}

	public boolean isPermutationOfPalidrome(String phrase){
		int[] table = buidCharFrequencyTable(phrase);
		return checkMaxOneOdd(table);
	}  

	public boolean checkMaxOneOdd(int[] table){
		boolean foundOdd = false;
		for(int count : table){
			if(count % 2 == 1){
				if(foundOdd){
					return false;
				}
				foundOdd = true;
			}
		}
		return true;
	}

	public int getCharNumber(Character c){
		int a = Character.getNumericValue('a');
		int z = Character.getNumericValue('z');
		int val = Character.getNumericValue(c);
		if(a <= val && val <= z){
			return val - a;
		}
		return -1;
	}

	public int[] buidCharFrequencyTable(String phrase){
		int[] table = new int[Character.getNumericValue('z') - Character.getNumericValue('a') +1];

		for(char c : phrase.toCharArray()){
			int x = getCharNumber(c);
			if(x != -1){
				table[x]++;
			}
		}
		return table;
	}

	public boolean isPermutationOfPalidrome2(String phrase){
		int countOdd = 0;
		int[] table = new int[Character.getNumericValue('z') - Character.getNumericValue('a') +1];

		for(char c : phrase.toCharArray()){
			int x = getCharNumber(c);
			if(x != -1){
				table[x]++;
				if(table[x] % 2 == 1){
					countOdd++;
				}else{
					countOdd--;
				}
			}
		}
		return countOdd <= 1;
	}

	public int toggle(int bitVector, int index){
		if(index < 0){
			return bitVector;
		}

		int mask = 1 << index;
		bitVector ^= mask;
		return bitVector;	
	}

	public int createBitVector(String phrase){
		int bitVector = 0;
		for (char c : phrase.toCharArray()){
			int x = getCharNumber(c);
			bitVector = toggle(bitVector, x);
		}
		return bitVector;
	}

	public boolean checkAtMostOneBitSet(int bitVector){
		return (bitVector & (bitVector -1)) == 0;
	}

	public boolean isPermutationOfPalidrome3(String phrase){
		int bitVector = createBitVector(phrase);
		return checkAtMostOneBitSet(bitVector);
	}

	public boolean areOneOperationAway(String word1, String word2){
		if(word1.length() == word2.length()){
			return areOneEditionAway(word1, word2);
		}else if(word1.length() + 1 == word2.length()){
			return areOneAdditionAway(word1, word2);
		}else if(word1.length() - 1 == word2.length()){
			return areOneAdditionAway(word2, word1);
		}
		return false;
	}

	public boolean areOneEditionAway(String word1, String word2){
		char[] letters1 = word1.toCharArray();
		char[] letters2 = word2.toCharArray();
		boolean alreadyOneEdition = false;
		for(int i =0; i < word1.length(); i++){
			if(letters1[i] != letters2[i]){
				if(alreadyOneEdition){
					return false;
				}
				alreadyOneEdition = true;
			}
		}
		return true;
	}

	public boolean areOneAdditionAway(String longWord, String shortword){
		char[] letters1 = longWord.toCharArray();
		char[] letters2 = shortword.toCharArray();
		int index1 = 0;
		int index2 = 0;
		while(index1 < longWord.length() || index2 < shortword.length()){
			if(letters1[index1] != letters2[index2]){
				if(index1 != index2){
					return false;
				}
				index2++;
			}else{
				index1++;
				index2++;
			}
		}
		return true;
	}

	public boolean areOneOperationAway2(String word1, String word2){
		if(Math.abs(word1.length() - word2.length()) > 1){
			return false;
		}

		String shorter = word1.length() < word2.length() ? word1 : word2; 
		String longer = word1.length() < word2.length() ? word2 : word1; 
		int index1 = 0;
		int index2 = 0;
		boolean foundDifference = false;
		while(index1 < shorter.length() || index2 < longer.length()){
			if(shorter.charAt(index1) != longer.charAt(index2)){
				if(foundDifference){
					return false;	
				}
				foundDifference = true;
				if(shorter.length() == longer.length()){
					index1++;
				}
			}else{
				index1++;
			}
			index2++;
		}
		return true;
	}

	public String reverse(String input) 
    { 
    	char[] chars = input.toCharArray(); 	
        int rigthIndex = input.length() - 1;
        int leftIndex = 0;

        while (leftIndex < rigthIndex) 
        { 
            if (!Character.isAlphabetic(chars[leftIndex])) {
                leftIndex++; 
            }else if(!Character.isAlphabetic(chars[rigthIndex])) {
                rigthIndex--; 
            }else { 
                char tmp = chars[leftIndex]; 
                chars[leftIndex] = chars[rigthIndex]; 
                chars[rigthIndex] = tmp; 
                leftIndex++; 
                rigthIndex--; 
            } 
        } 
        return new String(chars);
    } 

    public String compressBad(String str){
    	String compressString = "";
    	int countConsecutive = 0;
    	for(int i = 0; i < str.length(); i++){
    		countConsecutive++;
    		if(i + 1 >= str.length() || str.charAt(i) != str.charAt(i+1)){
    			compressString += "" + str.charAt(i) + countConsecutive;
    			countConsecutive = 0;
    		}
    	}
    	return compressString.length() < str.length() ? compressString : str;
    }

    public String compress(String str){
    	StringBuilder compressString = new StringBuilder();
    	int countConsecutive = 0;
    	for(int i = 0; i < str.length(); i++){
    		countConsecutive++;
    		if(i + 1 >= str.length() || str.charAt(i) != str.charAt(i+1)){
    			compressString.append(str.charAt(i)); 
    			compressString.append(countConsecutive); 
    			countConsecutive = 0;
    		}
    	}
    	return compressString.length() < str.length() ? compressString.toString() : str;
    }

	public String compressBest(String str){
		int finalLength = countCompression(str);
		//System.out.println("finalLength: " + finalLength);
		if(finalLength >= str.length()){
			return str;
		}
    	StringBuilder compressString = new StringBuilder(finalLength);
    	int countConsecutive = 0;
    	for(int i = 0; i < str.length(); i++){
    		countConsecutive++;
    		if(i + 1 >= str.length() || str.charAt(i) != str.charAt(i+1)){
    			compressString.append(str.charAt(i)); 
    			compressString.append(countConsecutive); 
    			countConsecutive = 0;
    		}
    	}
    	return compressString.toString();
    }

    private int countCompression(String str){
    	int compressedLength = 0;
    	int countConsecutive = 0;
    	for(int i = 0; i < str.length(); i++){
    		countConsecutive++;
    		if(i + 1 >= str.length() || str.charAt(i) != str.charAt(i+1)){
    			//System.out.println("String.valueOf(countConsecutive).length(): " + String.valueOf(countConsecutive).length());
    			compressedLength += 1 + String.valueOf(countConsecutive).length(); 
    			countConsecutive = 0;
    		}
    	}
    	return compressedLength;
    }

    //1,2,3,4,5, t=4
    public boolean binarySearch(int[] nums, int target){
    	int indexLeft = 0;
    	int indexRight = nums.length -1;
    	int indexMiddle;

    	while(indexLeft <= indexRight){
    		indexMiddle = (indexLeft + (indexRight- 1)) / 2;
    		if(nums[indexMiddle] == target){
    			return true;
    		}else if(nums[indexMiddle] > target){
    			indexRight = indexMiddle - 1;
    		}else{
    			indexLeft = indexMiddle + 1;
    		}
    	}
    	return false;
    }

    public int[][] rotateMatrix(int[][] matrix){
    	int rows = matrix.length - 1;
    	int columns = matrix[0].length - 1;
    	System.out.println("rows: " + rows);
    	System.out.println("columns: " + columns);
    	int[][] newMatrix = new int[matrix.length][matrix[0].length];

    	for(int row = 0; row <= rows; row++){
    		for(int column = 0; column <= columns; column++){
    			int newColumnValue = rows - row;
    			System.out.println("matrix[row][column]: " + matrix[row][column]);
    			System.out.println("newMatrix: " + column + "," + newColumnValue);
    			newMatrix[column][newColumnValue] = matrix[row][column];
    		}
    	}
    	return newMatrix;
    }

    public int[][] rotateMatrix2(int[][] matrix){
    	if(matrix.length == 0 || matrix.length != matrix[0].length){
    		return null;
    	}
    	int n = matrix.length;
    	for(int layer = 0; layer < (n/2);layer++){
    		int first = layer;
    		int last = n - 1 - layer;
    		//System.out.println("first: " + first);
    		System.out.println("layer: " + layer);
    		//System.out.println("last: " + last);
    		for(int i = first; i < last; i++){
    			int offset = i - first;
    			int top = matrix[first][i];
    			//System.out.println("offset: " + offset);
    			//System.out.println("top: " + top);
    			//left -> top
    			//System.out.println("left: (" + first + "," + i + ") = " + matrix[last - offset][first]);
    			//System.out.println("top: " + matrix[last - offset][first]);
    			matrix[first][i] = matrix[last - offset][first];

    			//bottom -> left
    			//System.out.println("bottom: " + matrix[last-offset][first]);
    			//System.out.println("left: " + matrix[last][last-offset]);
    			matrix[last-offset][first] = matrix[last][last-offset];

    			//right -> bottom
    			//System.out.println("right: " + matrix[last][last - offset]);
    			//System.out.println("bottom: " + matrix[i][last]);
    			matrix[last][last - offset] = matrix[i][last];

    			//top -> right
    			//System.out.println("top: " + matrix[i][last]);
    			//System.out.println("right: " + top);
    			matrix[i][last] = top; //right - saved top
    		}
    	}
    	return matrix;
    }

	public void sort(int[] arr, int left, int right){
		System.out.println(" left: " + left);
		System.out.println(" right: " + right);
		if(left < right){
			int middle = (left + right) / 2;
			System.out.println("middle: " + middle);
			sort(arr, left, middle);
			sort(arr, middle+1, right);
			System.out.println("merge left: " + left);
			System.out.println("merge middle: " + middle);
			System.out.println("merge right: " + right);

			merge(arr, left, middle, right); 
		}
	}

	public void merge(int[] arr, int left, int middle, int right){

		int sizeSubArray1 = middle - left + 1;
		int sizeSubArray2 = right - middle;

		int[] leftArray = new int[sizeSubArray1];
		int[] rightArray = new int[sizeSubArray2];

		for(int i=0;i<sizeSubArray1;i++){
			leftArray[i] = arr[i];
		}

		for(int i=0;i<sizeSubArray2;i++){
			rightArray[i] = arr[i];
		}

		int indexLeftArray = 0;
		int indexRightArray = 0;
		
		int mergeIndexArray = left;

		while(indexLeftArray < sizeSubArray1 && indexRightArray < sizeSubArray2){
			if(leftArray[indexLeftArray] <= rightArray[indexRightArray]){
				arr[mergeIndexArray] = leftArray[indexLeftArray];
				indexLeftArray ++;
			}else{
				arr[mergeIndexArray] = rightArray[indexRightArray];
				indexRightArray++;
			}
			mergeIndexArray++;
		}

		while(indexLeftArray < sizeSubArray1){
			arr[mergeIndexArray] = leftArray[indexLeftArray];
			indexLeftArray++;
			mergeIndexArray++;
		}

		while(indexRightArray < sizeSubArray2){
			arr[mergeIndexArray] = rightArray[indexRightArray];
			indexRightArray ++;
			mergeIndexArray++;
		}
	} 

	public boolean isRotationEachOther(String s1, String s2){
		if(s1.length() != s2.length()){
			return false;
		}
		for(int i = 1; i < s1.length();i++){
			String window = s1.substring(i, s1.length());
			System.out.println("window: " + window);
			int match = s2.indexOf(window);
			System.out.println("match: " + match);
			if(match != -1 && window.length() + 1 < s2.length()){
				String rightString = s2.substring(window.length(), s2.length());
				String leftString = s1.substring(0, i);
				System.out.println("rightString: " + rightString);
				System.out.println("leftString: " + leftString);
				return rightString.equals(leftString);
			}
			
		}
		return false;
	}

	public boolean isRotationEachOther2(String s1, String s2){
		if(s1.length() != s2.length()){
			return false;
		}
		String s3 = s1 + s1;
		return s3.contains(s2);
	}	

	public int[] merge(int[] a, int[] b){
		int[] c = new int[a.length + b.length];

		int aIndex = 0;
		int bIndex = 0;
		int cIndex = 0;

		while(aIndex < a.length && bIndex < b.length){
			if(a[aIndex] <= b[bIndex]){
				c[cIndex++] = a[aIndex++];
			}else{
				c[cIndex++] = b[bIndex++];
			}
		}

		while(aIndex < a.length){
			c[cIndex++] = a[aIndex++];	
		}
		while(bIndex < b.length){
			c[cIndex++] = b[bIndex++];	
		}
		return c;
	}  

	public int[] mergeArrays(int[] myArray, int[] alicesArray) {
	    // set up our mergedArray
	    int[] mergedArray = new int[myArray.length + alicesArray.length];

	    int currentIndexAlices = 0;
	    int currentIndexMine   = 0;
	    int currentIndexMerged = 0;

	    while (currentIndexMerged < mergedArray.length) {

	        boolean isMyArrayExhausted = currentIndexMine >= myArray.length;
	        boolean isAlicesArrayExhausted = currentIndexAlices >= alicesArray.length;

	        // case: next comes from my array
	        // my array must not be exhausted, and EITHER:
	        // 1) Alice's array IS exhausted, or
	        // 2) the current element in my array is less
	        //    than the current element in Alice's array
	        if (!isMyArrayExhausted && (isAlicesArrayExhausted
	                || (myArray[currentIndexMine] < alicesArray[currentIndexAlices]))) {

	            mergedArray[currentIndexMerged] = myArray[currentIndexMine];
	            currentIndexMine++;

	        // case: next comes from Alice's array
	        } else {
	            mergedArray[currentIndexMerged] = alicesArray[currentIndexAlices];
	            currentIndexAlices++;
	        }

	        currentIndexMerged++;
	    }

	    return mergedArray;
	}

	public boolean isFirstComeFirstServed(int[] takeOutOrders, int[] dineInOrders, int[] servedOrders) {
	    int takeOutOrdersIndex = 0;
	    int dineInOrdersIndex = 0;

	    for (int order : servedOrders) {

	        // if we still have orders in takeOutOrders
	        // and the current order in takeOutOrders is the same
	        // as the current order in servedOrders
	        if (takeOutOrdersIndex < takeOutOrders.length && order == takeOutOrders[takeOutOrdersIndex]) {
	            takeOutOrdersIndex++;

	        // if we still have orders in dineInOrders
	        // and the current order in dineInOrders is the same
	        // as the current order in servedOrders
	        } else if (dineInOrdersIndex < dineInOrders.length && order == dineInOrders[dineInOrdersIndex]) {
	            dineInOrdersIndex++;

	        // if the current order in servedOrders doesn't match the current
	        // order in takeOutOrders or dineInOrders, then we're not serving first-come,
	        // first-served
	        } else {
	            return false;
	        }
	    }

	    // check for any extra orders at the end of takeOutOrders or dineInOrders
	    if (dineInOrdersIndex != dineInOrders.length || takeOutOrdersIndex != takeOutOrders.length) {
	        return false;
	    }

	    // all orders in servedOrders have been "accounted for"
	    // so we're serving first-come, first-served!
	    return true;
	}

	private int[] removeFirstOrder(int[] orders) {
	    return Arrays.copyOfRange(orders, 1, orders.length);
	}

	public boolean isFirstComeFirstServedRecursive(int[] takeOutOrders, int[] dineInOrders, int[] servedOrders) {

	    // base case
	    if (servedOrders.length == 0) {
	        return true;
	    }

	    // if the first order in servedOrders is the same as the
	    // first order in takeOutOrders
	    // (making sure first that we have an order in takeOutOrders)
	    if (takeOutOrders.length > 0 && takeOutOrders[0] == servedOrders[0]) {

	        // take the first order off takeOutOrders and servedOrders and recurse
	        return isFirstComeFirstServedRecursive(removeFirstOrder(takeOutOrders), dineInOrders, removeFirstOrder(servedOrders));

	    // if the first order in servedOrders is the same as the first
	    // in dineInOrders
	    } else if (dineInOrders.length > 0 && dineInOrders[0] == servedOrders[0]) {

	        // take the first order off dineInOrders and servedOrders and recurse
	        return isFirstComeFirstServedRecursive(takeOutOrders, removeFirstOrder(dineInOrders), removeFirstOrder(servedOrders));

	    // first order in servedOrders doesn't match the first in
	    // takeOutOrders or dineInOrders, so we know it's not first-come, first-served
	    } else {
	        return false;
	    }
	}

	public static class CakeType {
	    final int weight;
	    final int value;

	    public CakeType(int weight, int value) {
	        this.weight = weight;
	        this.value  = value;
	    }
	}

	public static class InfinityException extends RuntimeException {
	    public InfinityException() {
	        super("Max value is infinity!");
	    }
	}

	public long maxDuffelBagValue(CakeType[] cakeTypes, int weightCapacity) {

	    // we make an array to hold the maximum possible value at every
	    // duffel bag weight capacity from 0 to weightCapacity
	    // starting each index with value 0
	    long[] maxValuesAtCapacities = new long[weightCapacity + 1];

	    for (int currentCapacity = 0; currentCapacity <= weightCapacity; currentCapacity++) {

	        // set a variable to hold the max monetary value so far for currentCapacity
	        long currentMaxValue = 0;
	        System.out.println("currentCapacity: " + currentCapacity);
	        for (CakeType cakeType : cakeTypes) {
	        	System.out.println("cakeType.weight: " + cakeType.weight);
	        	System.out.println("cakeType.value: " + cakeType.value);
	        	System.out.println("maxValuesAtCapacities" + Arrays.toString(maxValuesAtCapacities));
	            // if a cake weighs 0 and has a positive value the value of our duffel bag is infinite!
	            if (cakeType.weight == 0 && cakeType.value != 0) {
	                throw new InfinityException();
	            }

	            // if the current cake weighs as much or less than the current weight capacity
	            // it's possible taking the cake would get a better value
	            if (cakeType.weight <= currentCapacity) {

	                // so we check: should we use the cake or not?
	                // if we use the cake, the most kilograms we can include in addition to the cake
	                // we're adding is the current capacity minus the cake's weight. we find the max
	                // value at that integer capacity in our array maxValuesAtCapacities
	                System.out.println("(currentCapacity - cakeType.weight): " + (currentCapacity - cakeType.weight));
	                long maxValueUsingCake = cakeType.value
	                    + maxValuesAtCapacities[currentCapacity - cakeType.weight];

	                // now we see if it's worth taking the cake. how does the
	                // value with the cake compare to the currentMaxValue?
	                System.out.println("currentMaxValue: " + currentMaxValue);
	                currentMaxValue = Math.max(maxValueUsingCake, currentMaxValue);
	            }
	        }

	        // add each capacity's max value to our array so we can use them
	        // when calculating all the remaining capacities
	        System.out.println("after cakes currentCapacity: " + currentCapacity);
	        System.out.println("after cakes currentMaxValue: " + currentMaxValue);
	        maxValuesAtCapacities[currentCapacity] = currentMaxValue;
	    }

	    return maxValuesAtCapacities[weightCapacity];
	}

	public boolean hasPalindromePermutation(String theString) {

	    // track characters we've seen an odd number of times
	    Set<Character> unpairedCharacters = new HashSet<>();

	    for (char c : theString.toCharArray()) {
	        if (unpairedCharacters.contains(c)) {
	            unpairedCharacters.remove(c);
	        } else {
	            unpairedCharacters.add(c);
	        }
	    }

	    // the string has a palindrome permutation if it
	    // has one or zero characters without a pair
	    return unpairedCharacters.size() <= 1;
	}

}