package cracking.recursion;

import java.util.*;
import java.awt.Point;


 public class Recursion {
	
	public int staircase(int steps){

		if(steps == 0){
			return 0;
		}

		if(steps == 1){
			return 1;
		}else{
			return staircase(steps - 1) + staircase(steps - 2);
		}		
	}

	public int fibRecur(int x) {
		if (x == 0)
			return 0;
		if (x == 1)
			return 1;
		else {
			int f = fibRecur(x - 1) + fibRecur(x - 2);
			return f;
		}

	}


	public int countWays(int n) {
		if (n < 0) {
			return 0;
		} else if (n == 0) {
			return 1;
		} else {
			return countWays(n - 1) + countWays(n - 2) + countWays(n - 3);
		}
	}

	public  int countWaysDP(int n, int[] map) {
		if (n < 0) {
			return 0;
		} else if (n == 0) {
			return 1;
		} else if (map[n] != 0) {
			return map[n];
		} else {
			map[n] = countWaysDP(n - 1, map) + countWaysDP(n - 2, map) + countWaysDP(n - 3, map);
			return map[n];
 		}
 	}


 	public static List<String> robotPaths(int n){
    	List<String> pathList = new ArrayList<String>();
    	getPaths(n, 1,1, "", pathList);
    	return pathList;
	}

	public static void getPaths(int n, int i, int j, String path, List<String> pathList){
    	path += String.format(" (%d,%d)", i , j);
    	if(i == n && j == n){ //reach the (n,n) point
    	    pathList.add(path);
    	}else if( i > n || j > n){//wrong way
    	    return;
    	}else {
    	    getPaths(n, i +1, j , path, pathList);
    	    getPaths(n, i , j +1, path, pathList);
    	}
    }

    public boolean getPathBook(int x, int y, ArrayList<Point> path) {
		Point p = new Point(x, y);
		path.add(p);
		if (x == 0 && y == 0) {
			return true; // found a path
		}
		boolean success = false;
		if (x >= 1) { // Try left
			success = getPathBook(x - 1, y, path); // Free! Go left
		 }
		 if (!success && y >= 1) { // Try up
		 	success = getPathBook(x, y - 1, path); // Free! Go up
		 }
		 if (success) {
		 	path.add(p); // Right way! Add to path.
		 }
		 return success;
	}

	public boolean getPathCache(int x, int y, ArrayList<Point> path, Hashtable<Point, Boolean> cache) {
		 Point p = new Point(x, y);
		 if (cache.containsKey(p)) { // Already visited this cell
			return cache.get(p);
		 }
		if (x == 0 && y == 0) {
			return true; // found a path
		}
		boolean success = false;
		if (x >= 1) { // Try right
			success = getPathCache(x - 1, y, path, cache); // Free! Go right
		}
		if (!success && y >= 1) { // Try down
			success = getPathCache(x, y - 1, path, cache); // Free! Go down
		}
		if (success) {
			path.add(p); // Right way! Add to path
		}
		cache.put(p, success); // Cache result

		return success;
 	}

 	public int isMagicalIndex(int[] numbers){
 		return checkIndex(numbers, 0);
 	}

 	public int checkIndex(int[] numbers, int index){
 		if(numbers[index] == index){
 			return index;
 		}else if(index > numbers.length){
 			return -1;
 		}else{
 			return checkIndex(numbers, index + 1);
 		}
 	}

 	public int magicFast(int[] array, int start, int end) {
		if (end < start || start < 0 || end >= array.length) {
			return -1;
		}
		int mid = (start + end) / 2;
		if (array[mid] == mid) {
			return mid;
		} else if (array[mid] > mid){
			return magicFast(array, start, mid - 1);
		 } else {
		 	return magicFast(array, mid + 1, end);
		 }
	}
		
	public int magicFast(int[] array) {
		return magicFast(array, 0, array.length - 1);
	}

	public int magicFastBook(int[] array, int start, int end) {
		if (end < start || start < 0 || end >= array.length) {
			return -1;
		}
		int midIndex = (start + end) / 2;
		int midValue = array[midIndex];
		if (midValue == midIndex) {
			return midIndex;
		}
		

		/* Search left */
		int leftIndex = Math.min(midIndex - 1, midValue);
		int left = magicFastBook(array, start, leftIndex);
		if (left >= 0) {
			return left;
		}

		/* Search right */
		int rightIndex = Math.max(midIndex + 1, midValue);
		int right = magicFastBook(array, rightIndex, end);

		return right;
 	}

 	public int magicFastBook(int[] array) {
 		return magicFastBook(array, 0, array.length - 1);
 	}

 	public void printSubsets(char set[])
    {
        int n = set.length;
 
        // Run a loop for printing all 2^n
        // subsets one by obe
        for (int i = 0; i < (1<<n); i++)
        {
        	//2 pow of N
        	System.out.println("1<<n: " + (1<<n));
            System.out.print("{ ");
 
            // Print current subset
            for (int j = 0; j < n; j++){
 
                // (1<<j) is a number with jth bit 1
                // so when we 'and' them with the
                // subset number we get which numbers
                // are present in the subset and which
                // are not
                System.out.println("i: " + i +", j: " + j +", 1<<j" + (1 << j));
                System.out.println("i binary: " + Integer.toBinaryString(i));
                if ((i & (1 << j)) > 0){
                    System.out.print(set[j] + " ");
                }
 			}
            System.out.println("}");
        }
    }

    public ArrayList<ArrayList<Integer>> getSubsets(ArrayList<Integer> set, int index) {
		ArrayList<ArrayList<Integer>> allsubsets;
		System.out.println("set.size():" + set.size() + "index: " + index);
		if (set.size() == index) { // Base case - add empty set
			System.out.println("set.size() == index");
			allsubsets = new ArrayList<ArrayList<Integer>>();
			allsubsets.add(new ArrayList<Integer>()); // Empty set
		}else {
			allsubsets = getSubsets(set, index + 1);
			int item = set.get(index);
			System.out.println("item:" + item);
			ArrayList<ArrayList<Integer>> moresubsets = new ArrayList<ArrayList<Integer>>();
			System.out.println("allsubsets: " + allsubsets.toString());
			for (ArrayList<Integer> subset : allsubsets) {
				System.out.println("subset: " + subset.toString());
				ArrayList<Integer> newsubset = new ArrayList<Integer>();
				newsubset.addAll(subset); //
				newsubset.add(item);
				System.out.println("newsubset: " + newsubset.toString());
				moresubsets.add(newsubset);
			}
			System.out.println("moresubsets: " + moresubsets.toString());
			allsubsets.addAll(moresubsets);
		}
		System.out.println("final allsubsets: " + allsubsets.toString());
 		return allsubsets;
 	}
 
 	public ArrayList<ArrayList<Integer>> getSubsets2(ArrayList<Integer> set) {
		ArrayList<ArrayList<Integer>> allsubsets = new ArrayList<ArrayList<Integer>>();
		int max = 1 << set.size(); /* Compute 2^n */
		System.out.println("max: " + max);
		for (int k = 0; k < max; k++) {
			ArrayList<Integer> subset = convertIntToSet(k, set);
			allsubsets.add(subset);
		}
		return allsubsets;
 	}

 	public ArrayList<Integer> convertIntToSet(int x, ArrayList<Integer> set) {
 		ArrayList<Integer> subset = new ArrayList<Integer>();
 		int index = 0;
 		System.out.println("x: "+ x);
 		for (int k = x; k > 0; k >>= 1) {
 			System.out.println("k >>= 1: " + (k >>= 1));
 			System.out.println("(k & 1): " + (k & 1));
 			if ((k & 1) == 1) {
 				subset.add(set.get(index));
 			}
 			index++;
 		}
 		return subset;
 	}

 	public void permutations(String prefix, String str, List<String> permutations){
 		int length = str.length();
 		if(length == 0){
 			permutations.add(prefix);
 			System.out.println("permutation: " + prefix);
 		}else{
 			for(int i = 0; i < length; i++){
 				String newPermutation = prefix + str.charAt(i);
 				String stringWithoutLetter = str.substring(0, i) + str.substring(i+1, length);
 				System.out.println("newPermutation: " + newPermutation);
 				System.out.println("stringWithoutLetter: " + stringWithoutLetter);
 				permutations(newPermutation, stringWithoutLetter, permutations);
 			}
 		}
 	}

 	public ArrayList<String> getPerms(String str) {
 		if (str == null) {
 			return null;
 		}
		ArrayList<String> permutations = new ArrayList<String>();
		if (str.length() == 0) { // base case
			permutations.add("");
			return permutations;
		}

 		char first = str.charAt(0); // get the first character
		String remainder = str.substring(1); // remove the 1st character
		ArrayList<String> words = getPerms(remainder);
 		for (String word : words) {
 			for (int j = 0; j <= word.length(); j++) {
 				String s = insertCharAt(word, first, j);
 				permutations. add(s);
 			}
 		}
 		return permutations;
 	}

 	public String insertCharAt(String word, char c, int i) {
 		String start = word.substring(0, i);
		String end = word.substring(i);
 		return start + c + end;
 	}

 	public void printParenthesis(int number){
 		if(number > 0){
 			int pos = 0;
 			int open = 0;
 			int close = 0;
     		printParenthesis(0, number, 0, 0);
     		return;
 		}
 	}

  	StringBuilder str = new StringBuilder();     
  	char[] chars = new char[100]; 

	public void printParenthesis(int pos, int number, int open, int close)
	{	
 		System.out.println("pos: " + pos + ", number: " + number + ", open: " + open + ", close: " + close);

  		if(close == number) 
  		{
  			for(int i = 0; i < pos; i++){
  				System.out.print( chars[i]);
  				str.append(chars[i]);
  			}	
  			System.out.println(" ");
  			str.append(" ");
  		  	return;
  		}else
  		{
  		  if(open > close) {
  		  	System.out.println("pos: " + pos + ", closing: " +  open + ">" + close);
  		  	  chars[pos] = '}';	
  		      printParenthesis(pos+1, number, open, close + 1);
  		  }
  		  if(open < number) {
  		  	System.out.println("pos: " + pos + ", opening: " +  open + "<" + close);
  		     chars[pos] = '{';	
  		     printParenthesis(pos+1, number, open+1, close);
  		  }
  		}
  	}

  	public Set<String> generateParens(int remaining) {
		Set<String> set = new HashSet<String>();
		if (remaining == 0) {
			set.add("");
		} else {
			Set<String> prev = generateParens(remaining - 1);
			for (String str : prev) {
				for (int i = 0; i < str.length(); i++) {
					if (str.charAt(i) == '(') {
		 				String s = insertInside(str, i);
		 				/* Add s to set if it's not already in there. Note:
		 				* HashSet automatically checks for duplicates before
		 				* adding, so an explicit check is not necessary. */
						set.add(s);
		 			}
		 		}
		 		if (!set.contains("()" + str)) {
		 			set.add("()" + str);
		 		}
		 	}
		 }
		return set;
	}
		
	public String insertInside(String str, int leftIndex) {
		 String left = str.substring(0, leftIndex + 1);
		 String right = str.substring(leftIndex + 1, str.length());
		 return left + "()" + right;
	}


	public void addParen(ArrayList<String> list, int leftRem, int rightRem, char[] str, int count) {
		if (leftRem < 0 || rightRem < leftRem){
			return; // invalid state
		}

		if (leftRem == 0 && rightRem == 0) { /* no more parens left */
			String s = String.copyValueOf(str);
			list.add(s);
		} else {
			/* Add left paren, if there are any left parens remaining. */
			 if (leftRem > 0) {
			 	str[count] = '(';
			 	addParen(list, leftRem - 1, rightRem, str, count + 1);
			 }
	
		 /* Add right paren., if expression is valid */
		 if (rightRem > leftRem) {
		 	str[count] = ')';
		 	addParen(list, leftRem, rightRem - 1, str, count + 1);
		 }
	 	}
	 }

 	public ArrayList<String> generateParensBook(int count) {
 		char[] str = new char[count*2];
 		ArrayList<String> list = new ArrayList<String>();
 		addParen(list, count, count, str, 0);
 		return list;
 	}

 	public void floodFillUtil(int screen[][], int x, int y, int previousColor, int newColor)
	{
	   // Base cases
	   if (x < 0 || x >= screen[0].length || y < 0 || y >= screen.length){
	       return;
	   }
	   if (screen[x][y] != previousColor){
	       return;
	   }
	
	   // Replace the color at (x, y)
	   screen[x][y] = newColor;
	
	   // Recur for north, east, south and west
	   floodFillUtil(screen, x+1, y, previousColor, newColor);
	   floodFillUtil(screen, x-1, y, previousColor, newColor);
	   floodFillUtil(screen, x, y+1, previousColor, newColor);
	   floodFillUtil(screen, x, y-1, previousColor, newColor);
	}
 
	// It mainly finds the previous color on (x, y) and
	// calls floodFillUtil()
	public void floodFill(int screen[][], int x, int y, int newColor)
	{
	    int previousColor = screen[x][y];
	    floodFillUtil(screen, x, y, previousColor, newColor);
	}

	enum Color {
		Black, White, Red, Yellow, Green
	}

	public boolean paintFill(Color[][] screen, int x, int y, Color ocolor, Color ncolor) {
		if (x < 0 || x >= screen[0].length || y < 0 || y >= screen.length) {
			return false;
		}
		if (screen[y][x] == ocolor) {
			screen[y][x] = ncolor;
		}

		paintFill(screen, x - 1, y, ocolor, ncolor);
		paintFill(screen, x + 1, y, ocolor, ncolor);
		paintFill(screen, x, y - 1, ocolor, ncolor);
		paintFill(screen, x, y + 1, ocolor, ncolor);
		return true;
	}

	public boolean paintFill(Color[][] screen, int x, int y, Color ncolor){
		if (screen[y][x] == ncolor){
			return false;
		} 
		return paintFill(screen, x, y, screen[y][x], ncolor);
	}

	public int makeChangeIterative(int total){
		int ways = 0;
		for(int count25 = 0; count25 <= total; ++count25){
			for(int count10 = 0; count10 <= total; ++count10){
				for(int count5 = 0; count5  <= total; ++count5){
					int sum = count25 * 25 + count10 * 10 + count5 * 5;
					if(sum == total){
						System.out.println("Quarters: " + count25 + ", Dimes: " + count10 + ", Nickels: " + count5 );
						++ways;
					}
				}

			}	
		}
		return ways;
	}

	public int makeChange(int total, int denomination){
		int nextCoin = 0;

		switch(denomination){
			case 25:
				nextCoin = 10;
				break;
			case 10:
				nextCoin = 5;
				break;
			case 5:
				nextCoin = 1;
				break;
			case 1:
				return 1;
			default:
				return 0;			
		}

		int ways = 0;
		for (int count = 0; count * denomination <= total; ++count){
			ways += makeChange(total - count * denomination, nextCoin);
		}
		return ways;
	}

	public int makeChange(int total){
		if(total < 0){
			return 0;
		}
		return makeChange(total, 25);
	}

	public int makeChangeBook(int n, int denom) {
		int next_denom = 0;
		System.out.println("denom: " + denom);
		System.out.println("next_denom: " + next_denom);
		switch (denom) {
			case 25:
				next_denom = 10;
				break;
			case 10:
				next_denom = 5;
				break;
		 	case 5:
		 		next_denom = 1;
		 		break;
		 	case 1:
		 		return 1;
		 }
		
		 int ways = 0;
		 for (int count = 0; count * denom <= n; count++) {
		 	System.out.println("count: " + count + ", denom: " + denom + ", n: " + n + ", next_denom: " + next_denom);
		 	System.out.println("n - count * denom: " + (n - count * denom));
		 	ways += makeChangeBook(n - count * denom, next_denom);
		 	System.out.println("ways: " + ways);
		 }
		 return ways;
	 }

	 public int total(int n, int[] v, int i) {
		if (n < 0) {
			return 0;
		}
		if (n == 0) {
			System.out.println("count: " + i);
			return 1;
		}
		// means coins over and n>0 so no solution
		if (i == v.length && n > 0) {
			return 0;
		}
		return total(n - v[i], v, i) + total(n, v, i + 1);
	}

	class Queen{
		int column, row;
		Queen(int column, int row){
			this.column = column;
			this.row= row;
		}
		int getColumn(){
			return column;
		}
		int getRow(){
			return row;
		}
	}

	public void set8queens(int[][] board){
		LinkedList<Queen> queens = new LinkedList<Queen>();
		int rows = board.length;
		int columns = board[0].length;

		int startColumn = 0;
		for(int row=0; row < rows; row++ ){
			boolean findQueen = false;
			for(int column = startColumn; column < columns; column++ ){
				//System.out.println("column: " + column + ", row: " + row );
				//System.out.println("board[column][row]: " + board[column][row]);
				if(isFree(board, column, row, queens)){
					Queen queen = new Queen(column, row);
					board[column][row] = 0;
					queens.addFirst(queen);
					findQueen = true;
					startColumn = 0;
					break;
				}
			}
			if(!findQueen && queens.size() > 0){
				//System.out.println("Backtracking");
				Queen queen = queens.removeFirst();
				int columnPrevious = queen.getColumn();
				int rowPrevious = queen.getRow();
				board[columnPrevious][rowPrevious] = 1;
				//System.out.println("columnPrevious: " + columnPrevious + ", rowPrevious: "  + rowPrevious);
				row-=2;
				startColumn = queen.getColumn() + 1;
				//System.out.println("startColumn: "  + startColumn + ",row: " + row );
			}
		}
	}

	public boolean isFree(int[][] board, int column, int row, LinkedList<Queen> queens){

		Iterator<Queen> iterator = queens.iterator();
		while (queens.size() > 0 && iterator.hasNext()) {
   			Queen queen = iterator.next();
   			int columnPrevious = queen.getColumn();
			int rowPrevious = queen.getRow();
   			//System.out.println("columnPrevious: " + columnPrevious + ", rowPrevious: "  + rowPrevious);
   			//System.out.println("column: " + column + ", row: " + row );
	   		if(row == rowPrevious){
	   			return false;
	   		}

   			if(column == columnPrevious){
   				return false;
   			}

   			for(int i = 0; i < board.length ; i++){
   				//System.out.println((columnPrevious+i) + "," +  (rowPrevious+i));
   				if(column == (columnPrevious+i) && row == (rowPrevious+i)){
   					return false;
   				}
   			}

   			for(int i = 0; i < board.length ; i++){
   				//System.out.println((columnPrevious+i) + "," +  (rowPrevious+i));
   				if(column == (columnPrevious-i) && row == (rowPrevious+i)){
   					return false;
   				}
   			}

   			for(int i = 0; i < board.length ; i++){
   				//System.out.println((columnPrevious+i) + "," +  (rowPrevious+i));
   				if(column == (columnPrevious+i) && row == (rowPrevious-i)){
   					return false;
   				}
   			}
		}
		return true;

	}
	
 }