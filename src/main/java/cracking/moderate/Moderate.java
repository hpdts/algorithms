package cracking.moderate;

import java.util.*;

 public class Moderate {

	public boolean binarySearchRotated(int[] numbers, int target){
		int start = 0;
		int end = numbers.length - 1;
		while (end >= start){
			int middle = (start + end) / 2; 
			System.out.println("numbers[mid]: " +  numbers[middle]);

			if(numbers[middle] == target){
				return true;
			}

			System.out.println("start: " +  start);
			System.out.println("end: " +  end);
			System.out.println("middle: " +  middle);
			System.out.println("numbers[start]: " +  numbers[start]);
			System.out.println("numbers[end]: " +  numbers[end]);

			if(numbers[start] < numbers[middle]){
				if(numbers[start] > target && target <= numbers[middle]){
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

 	public int searchRotatedArrayIterative(int[] numbers, int target){
 		int start = 0;
 		int end = numbers.length-1;
 		while(end >= start){
 			int mid = (start + end) / 2;

			System.out.println("numbers[mid]: " +  numbers[mid]);

 			if(numbers[mid] == target){
 				return numbers[mid];
 			}

 			System.out.println("start: " +  start);
			System.out.println("end: " +  end);
			System.out.println("middle: " +  mid);

 			if(numbers[start] < numbers[mid]){
 				if(target >= numbers[start]  && target <= numbers[mid]){
 					//numbers[start] <= target && target < numbers[middle]
 					end = mid - 1;
 				}else{
 					start = mid + 1;
 				}
 			}else{
 				if(target >= numbers[mid] && target <= numbers[end]){
 					start = mid + 1;
 				}else{
 					end = mid - 1;
 				}
 			}

 		}
 		return -1;
 	}

 	public int searchRotatedArray(int[] numbers, int target){
 		return search(numbers, 0, numbers.length -1, target);
 	}

 	public int search(int[] numbers, int left, int right, int target){
 		int mid = (left + right) / 2;
 		if(numbers[mid] == target){
 			System.out.println("mid: " + mid);
 			return numbers[mid];
 		}
 		if(right < left){
 			return -1;
 		}

 		System.out.println("start: " +  left);
			System.out.println("end: " +  right);
			System.out.println("middle: " +  mid);
			
 		//first half ordered
 		if(numbers[left] < numbers[mid]){
 			if(target >= numbers[left] && target <= numbers[mid]){
 				return search(numbers, left, mid -1, target);
 			}else{
 				return search(numbers, mid +1, right, target);
 			}
 		}else if(numbers[mid] < numbers[right]){
 			if(target >= numbers[mid] && target <= right){
 				return search(numbers, mid + 1, right, target);
 			}else{
 				return search(numbers, left, mid-1, target);
 			}
 		}else if (numbers[left] == numbers[mid]) { // Left half is all repeats
		 	System.out.println(numbers[left] + "," + numbers[mid]);
		 	if (numbers[mid] != numbers[right]) { // If right is diff., search it
		 		return search(numbers, mid + 1, right, target); // search right
		 	} else { // Else, we-have to search both halves
		 		int result = search(numbers, left, mid - 1, target); // Search left
		 		if (result == -1) {
		 			return search(numbers, mid + 1, right, target); // Search right
		 		} else {
		 			return result;
		 		}
		 	}
		 }
		 return -1;
 	}

 	public boolean isTicTacToeWinner(int[][] board){
 		int columns = board[0].length;
 		int rows = board.length;
 		int sumColumns = 0;
 		int sumRows = 0;
 		int sumDiagonalDown = 0;
 		int sumDiagonalUp = 0;
 		//check diagonal
 		for(int col = 0; col < columns; col++){
 			for(int row = 0; row < rows; row++){
 				System.out.println("board[row][col]: " + board[row][col]);
 				System.out.println("row: " + row + "col: " + col);
 				sumColumns+= board[row][col];
 				sumRows+= board[col][row];
 				sumDiagonalDown+= board[col][col];
 				sumDiagonalUp+= board[row][row + (columns-1-row)];
 			}
 			if(sumColumns == 3 || sumColumns == 0 ){
 				return true;
 			}
 			if(sumRows == 3 || sumRows == 0 ){
 				return true;
 			}
 			if(sumDiagonalDown == 3 || sumDiagonalDown == 0 ){
 				return true;
 			}
 			if(sumDiagonalUp == 3 || sumDiagonalUp == 0 ){
 				return true;
 			}
 			sumColumns = 0;
 			sumRows = 0;
 			sumDiagonalDown = 0;
 			sumDiagonalUp = 0;
 		}

 		return false;
 	}

 	public int convertBoardToInt(char[][] board) {
		int factor = 1;
		int sum = 0;
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				System.out.println("board[i][j]: " + board[i][j]);
				int v = 0;
				if (board[i][j] == 'x') {
		 			v = 1;
		 		}else if (board[i][j] == 'o') {
					v = 2;
				}
				sum += v * factor;
				factor *= 3;

				System.out.println("v: " + v + ", sum: " + sum + ", factor: " + factor);
			}
		}
		return sum;
	}

	//only trailing zeros
	public int trailingZeros(int number){
		int trailingZeros = 0;
		for(int i = 1; i <= number; i++){
			if((i % 5) == 0){
				trailingZeros++;
			}
		}
		return trailingZeros;
	}


	/* If the number is a 5 of five, return which power of 5.
	 -> 1,
	 * 25-> 2, etc.
	 */
	public int factorsOf5(int i) {
		int count = 0;
		while (i % 5 == 0) {
			count++;
			i /= 5;
		}
		return count;
	}
		
	public int countFactZeros(int num) {
		int count = 0;
		for (int i = 2; i <= num; i++) {
			count += factorsOf5(i);
		}
	 	return count;
	}

	public int countFactZeros2(int num) {
	 int count = 0;
	 if (num < 0) {
	 	return -1;
	 }
	 for (int i = 5; num / i > 0; i *= 5) {

	 	System.out.println("i: " + i);
		count += num / i;
	 }
	 return count;
    }

    public int getMax(int a, int b) {
	    int c = a - b;
	    int k = (c >> 31) & 0x1;
	    int max = a - k * c;
	    return max;
	}

	//bitwise exclusive OR operator 1 different value 0 the same
	/* Flips a 1 to a 0 and a 0 to a 1 */
	public static int flip(int bit) {
		return 1 ^ bit;
	}
	
	/* Returns 1 if a is positive, and 0 if a is negative */
	public static int sign(int a) {
		return flip((a >> 31) & 0x1);
	}
	
	 public static int getMaxNaive(int a, int b) {
	 	int k = sign(a - b);
	 	int q = flip(k);
	 	return a * k + b * q;
	 }	

	public static int getMaxBook(int a, int b) {
		int c = a - b;

		int sa = sign(a); // if a >= 0, then 1 else 0
		int sb = sign(b); // if b >= 1, then 1 else 0
		int sc = sign(c); // depends on whether or not a - b overflows
		
		/* Goal: define a value k which is 1 if a > b and 0 if a < b.
		* (if a = b, it doesn't matter what value k is) */
		
		// If a and b have different signs, then k = sign(a)
		int use_sign_of_a = sa ^ sb;
		
		// If a and b have the same sign, then k = sign(a - b)
		int use_sign_of_c = flip(sa ^ sb);
		
		int k = use_sign_of_a * sa + use_sign_of_c * sc;
		int q = flip(k); // opposite of k
		
		return a * k + b * q;
	}

	public void masterMind(String guess){
		String value = "RGBY";
		int hits = 0;
		int pseudoHits = 0;
		for(int i = 0; i < guess.length(); i++){
			if(guess.charAt(i) == value.charAt(i)){
				hits++;
			}else if(value.indexOf(guess.charAt(i)) >= 0){
				pseudoHits++;
			}
		}
		System.out.println("hits: " + hits);
		System.out.println("pseudoHits: " + pseudoHits);
	}


	 class Result {
	 	public int hits = 0;
	 	public int pseudoHits = 0;
	
		public String toString() {
	 		return "(" + hits + ", " + pseudoHits + ")";
		}
	}
	
	public int code(char c) {
		switch (c) {
		case 'B':
			return 0;
		case 'G':
			return 1;
		case 'R':
			return 2;
		case 'Y':
			return 3;
		default:
			return -1;
		}
	 }
	
	public static int MAX_COLORS = 4;
	
	public Result estimate(String guess, String solution) {
		if (guess.length() != solution.length()){
			return null;
		} 
	
		Result res = new Result();
		int[] frequencies = new int[MAX_COLORS];
	
		/* Compute hits and build frequency table */
		for (int i = 0; i < guess.length(); i++) {
			if (guess.charAt(i) == solution.charAt(i)) {
				res.hits++;
			} else {
				/* Only increment the frequency table (which will be used
				* for pseudo-hits) if it's not a hit. If it's a hit, the
				* slot has already been "used." */
			 	int code = code(solution.charAt(i));
			 	frequencies[code]++;
			 }
		}	
			
		/* Compute pseudo-hits */
		for (int i = 0; i < guess.length(); i++) {
			int code = code(guess.charAt(i));
			if (code >= 0 && frequencies[code] > 0 && guess.charAt(i) != solution.charAt(i)) {
					res.pseudoHits++;
					frequencies[code]--;
			}
		}	

		return res;
	}	


	public int findEndOfLeftSubsequence(int[] array) {
		for (int i = 1; i < array.length; i++) {
	 		if (array[i] < array[i - 1]){
	 			return i - 1;
	 		} 
	 	}
		return array.length - 1;
	}
	
	public int findStartOfRightSubsequence(int[] array) {
		for (int i = array.length - 2; i >= 0; i--) {
	 		if (array[i] > array[i + 1]){
	 			return i + 1;
	 		} 
	 	}
	 	return 0;
	}
	
  	public int shrinkLeft(int[] array, int min_index, int start) {
		int comp = array[min_index];
		for (int i = start - 1; i >= 0; i--) {
		 	if (array[i] <= comp){
		 		return i + 1;
		 	} 
		}
		return 0;
 	}

 	public int shrinkRight(int[] array, int max_index, int start) {
		int comp = array[max_index];
		for (int i = start; i < array.length; i++) {
		 	if (array[i] >= comp){ 
		 		return i - 1;
		 	}
		}
		return array.length - 1;
	}

 	public void findUnsortedSequence(int[] array) {
		/* find left subsequence */
		 int end_left = findEndOfLeftSubsequence(array);
		
		 /* find right subsequence */
		 int start_right = findStartOfRightSubsequence(array);
		
		 /* find min and max element of middle */
		 int min_index = end_left + 1;
		 if (min_index >= array.length){
		 	return; // Already sorted
		 } 
		
		 int max_index = start_right - 1;
		 for (int i = end_left; i <= start_right; i++) {
		 	if (array[i] < array[min_index]){
		 		min_index = i;
		 	} 
		 	if (array[i] > array[max_index]){
		 		max_index = i;
		 	} 
		 }
		
		 /* slide left until less than array[min_index] */
		 int left_index = shrinkLeft(array, min_index, end_left);
		
		 /* slide right until greater than array[max_index] */
		 int right_index = shrinkRight(array, max_index, start_right);
		
		 System.out.println("indices: " + left_index + " " + right_index);
	 }

	 public Map<String, Integer> getFrequency(String text){
	 	Map<String, Integer> words = new HashMap<>();
	 	StringTokenizer tokens = new StringTokenizer(text, " ");
	 	while(tokens.hasMoreTokens()){
	 		String word = tokens.nextToken();
	 		System.out.println("word: " + word);
	 		if(words.containsKey(word)){
	 			int count = words.get(word);
	 			words.put(word, count++);
	 		}else{
	 			words.put(word, 1);
	 		}
	 	}
	 	return words;
	 }

	 public Hashtable<String, Integer> setupDictionary(String[] book) {
		Hashtable<String, Integer> table = new Hashtable<String, Integer>();
		for (String word : book) {
			word = word.toLowerCase();
			if (word.trim() != "") {
				if (!table.containsKey(word)) {
					table.put(word, 0);
				}
				table.put(word, table.get(word) + 1);
			}
		}
		return table;
 	}

 	public int getFrequency(Hashtable<String, Integer> table, String word) {
 		if(table == null || word == null){
 			return -1;	
 		} 
 		word = word.toLowerCase();

 		if(table.containsKey(word)) {
 			return table.get(word);
 		}else{
 			return 0;
 		}
 	}

 	public String numberToName(int number){
 		Map<Integer, String> first19 = new HashMap<Integer, String>();
 		first19.put(1, "one");
 		first19.put(2, "two");
 		first19.put(3, "three");
 		first19.put(4, "four");
 		first19.put(5, "five");
 		first19.put(6, "sixs");
 		first19.put(7, "seven");
 		first19.put(8, "eight");
 		first19.put(9, "nine");
 		first19.put(10, "ten");
 		first19.put(11, "eleven");
 		first19.put(12, "twelve");
 		first19.put(13, "thirteen");
 		first19.put(14, "fourteen");
 		first19.put(15, "fifthteen");
 		first19.put(16, "sixteen");
 		first19.put(17, "seventeen");
 		first19.put(18, "eighteen");
 		first19.put(19, "nineteen");

		Map<Integer, String> tens = new HashMap<Integer, String>();
 		tens.put(2, "twenty");
 		tens.put(3, "thirty");
 		tens.put(4, "forty");
 		tens.put(5, "fifty");
 		tens.put(6, "sixty");
 		tens.put(7, "seventy");
 		tens.put(8, "eighty");
 		tens.put(9, "ninety");


 		if(number > 0 && number < 20){
 			return first19.get(number);
 		}else if(number > 19 && number < 100){
			int tensValue = number / 10;
			int units = number % 10;

			return tens.get(tensValue) + " " + first19.get(units);
 		}

 		return null;

 	}


 	public static String[] digits = {"One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
 	public static String[] teens = {"Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
 	public static String[] tens = {"Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
	public static String[] bigs = {"", "Thousand", "Million"};

	public static String numToString(int number) {
		if (number == 0) {
			return "Zero";
		} else if (number < 0) {
			return "Negative " + numToString(-1 * number);
		}
	
		int count = 0;
		String str = "";
	
		while (number > 0) {
			if (number % 1000 != 0) {
				str = numToString100(number % 1000) + bigs[count] + " " + str;
			}
			number /= 1000;
			count++;
		}
	
		return str;
	 }

 	public static String numToString100(int number) {
 		String str = "";
		
 		/* Convert hundreds place */
 		if (number >= 100) {
 			str += digits[number / 100 - 1] + " Hundred ";
 			number %= 100;
		}

		/* Convert tens place */
		if (number >= 11 && number <= 19) {
			return str + teens[number - 11] + " ";
		} else if (number ==10 || number >= 20) {
			str += tens[number / 19 - 1] + " ";
			number %= 10;
		}
	
		/* Convert ones place */
		if (number >= 1 && number <= 9) {
			str += digits[number - 1] + " ";
		}
	
		return str;
 	}

 	public static int getMaxSum(int[] a) {
		int maxsum = 0;
		int sum = 0;
		for (int i = 0; i < a.length; i++) {
			sum += a[i];
			if (maxsum < sum) {
				maxsum = sum;
			}else if (sum < 0) {
				sum = 0;
			}
		}
		return maxsum;
	}

	public void findSum(int[] numbers, int num){
		Map<Integer, Integer> sums = new HashMap<>();
		for(int number : numbers){
			if(sums.containsKey(num - number)){
				System.out.println("Number: " + number + ", and number: " + (num - number));
			}
			sums.put(number, 0);
		}

	}

	public void printPairSums(int[] array, int sum) {
		Arrays.sort(array);
		int first = 0;
		int last = array.length - 1;
		while (first < last) {
			int s = array[first] + array[last];
			if (s == sum) {
				System.out.println(array[first] + " " + array[last]);
				first++;
				 last--;
		 	} else {
				if (s < sum){
					first++;
				} 
				else{
				 last--;
				}
			}
		}
	}

}

