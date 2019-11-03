package interviewExposed;

import java.util.*;
import java.util.regex.*;
import java.util.Arrays;
import java.util.stream.Collectors;

public class RedBlue{

	public int isPattern(String pattern, String input){  
		StringBuffer patternBuffer = new StringBuffer();

		// check input and pattern strings 
		if (pattern == null || input == null) {
			throw new IllegalArgumentException();
		}

		// pattern character array
		List<Character> chars = new ArrayList<Character>();
		for (char c : pattern.toCharArray()) {

			if (!chars.contains(c)) {
				// new character found, append new group
				patternBuffer.append("(.+)");
				chars.add(c);
			} else {
				// looking for unique sequence by number
				patternBuffer.append("\\").append(chars.indexOf(c)+1);
			}
		}
		System.out.println("patternBuffer.toString(): " + patternBuffer.toString());
		// compiling pattern and checking input string 
		Pattern patternObj = Pattern.compile(patternBuffer.toString());
		Matcher matcher = patternObj.matcher(input);
		if (matcher.find()) {
			return 1;
		}
		return 0;
	}

	public int minPalPartion(String str) 
    { 
        // Get the length of the string 
        int lengthString = str.length(); 
        
        /* Create two arrays to build the solution 
           in bottom up manner 
           C[i][j] = Minimum number of cuts needed  
                     for palindrome partitioning 
                     of substring str[i..j] 
           P[i][j] = true if substring str[i..j] is 
                     palindrome, else false 
           Note that C[i][j] is 0 if P[i][j] is 
           true */
        int[][] cuts = new int[lengthString][lengthString]; 
        boolean[][] isPalindrome = new boolean[lengthString][lengthString]; 
        
        int i, j, k, L; // different looping variables 
        
        // Every substring of length 1 is a palindrome 
        for (i = 0; i < lengthString; i++) 
        { 
            isPalindrome[i][i] = true; 
            cuts[i][i] = 0; 
        } 
        
        /* L is substring length. Build the solution in 
         bottom up manner by considering all substrings 
         of length starting from 2 to n. The loop  
         structure is same as Matrx Chain Multiplication 
         problem ( 
        See https://www.geeksforgeeks.org/matrix-chain-multiplication-dp-8/ )*/
        for (L = 2; L <= lengthString; L++) 
        { 
            // For substring of length L, set different 
            // possible starting indexes 
            for (i = 0; i < lengthString - L + 1; i++) 
            { 
                j = i + L - 1; // Set ending index 
                System.out.println("i: " + i);
                System.out.println("j: " + j);
                System.out.println("L: " + L);
        		System.out.println("str.charAt(i): " + str.charAt(i));
        		System.out.println("str.charAt(j): " + str.charAt(j));
                // If L is 2, then we just need to  
                // compare two characters. Else need to 
                // check two corner characters and value  
                // of P[i+1][j-1] 
                if (L == 2) {
                    isPalindrome[i][j] = (str.charAt(i) == str.charAt(j));
                } else{
                    isPalindrome[i][j] = (str.charAt(i) == str.charAt(j)) && isPalindrome[i+1][j-1];
                }
        
                // IF str[i..j] is palindrome, then  
                // C[i][j] is 0 
                if (isPalindrome[i][j] == true) {
                    cuts[i][j] = 0; 
                }
                else
                { 
                    // Make a cut at every possible 
                    // location starting from i to j, 
                    // and get the minimum cost cut. 
                    cuts[i][j] = Integer.MAX_VALUE; 
                    for (k = i; k <= j - 1; k++){
                        cuts[i][j] = Integer.min(cuts[i][j], cuts[i][k] + cuts[k+1][j] + 1);
                    }
                } 
            } 
        } 
        
        // Return the min cut value for complete  
        // string. i.e., str[0..n-1] 
        return cuts[0][lengthString-1]; 
    } 

    public void permute(String str, int starting, int ending) 
    { 
    	System.out.println("Permute beggining starting:" + starting + ", ending: " + ending);
        if (starting == ending){
            System.out.println(str); 
        }
        else
        { 
            for (int i = starting; i <= ending; i++) 
            { 
            	System.out.println("i: " + i);
                if(starting != i){
            		System.out.println("Call swap starting:" + starting + ", i: " + i);
                	str = swap(str,starting,i); 
                	System.out.println("str: " + str);
                }
                permute(str, starting + 1, ending); 
                if(starting != i){
            		System.out.println("Call swap after starting:" + starting + ", i: " + i);
                	str = swap(str,starting,i); 
                	System.out.println("str after: " + str);
            	}
            } 
        } 
    } 
    
    public String swap(String a, int i, int j) 
    { 
        char temp; 
        char[] charArray = a.toCharArray(); 
        temp = charArray[i] ; 
        charArray[i] = charArray[j]; 
        charArray[j] = temp; 
        return String.valueOf(charArray); 
    } 

    public int minCost(int[][] cost){
    	return minCost(cost, cost.length-1, cost.length-1);    
    }

    public int minCost(int[][] cost, int row, int column){
    	if(row < 0 || column < 0){
    		return Integer.MAX_VALUE;
    	}else if(row == 0 && column == 0){
    		return cost[row][column];
    	}else{
    		return cost[row][column] + Math.min(minCost(cost, row-1,column), minCost(cost, row, column-1));
    	}
    }

    public int minPathSumDP(int[][] grid) {
	    if(grid == null || grid.length==0){
	        return 0;
	    }
	 
	    int rows = grid.length;
	    int columns = grid[0].length;
	 
	    int[][] dp = new int[rows][columns];
	    dp[0][0] = grid[0][0];    
	 
	    // initialize top row
	    for(int row=1; row < rows; row++){
	    	System.out.println("row: " + row);
	    	System.out.println("dp[0][row-1]: " + dp[0][row-1]);
	    	System.out.println("grid[0][row]: " + grid[0][row] + "\n");
	        dp[0][row] = dp[0][row-1] + grid[0][row];
	    }
	 
	 	System.out.println("DP rows" + Arrays.stream(dp).map(Arrays::toString).collect(Collectors.joining(System.lineSeparator())));

	    // initialize left column
	    for(int column=1; column< columns; column++){
	        dp[column][0] = dp[column-1][0] + grid[column][0];
	    }
	 
	    // fill up the dp table
	    for(int i=1; i< rows; i++){
	        for(int j=1; j< columns; j++){
	            if(dp[i-1][j] > dp[i][j-1]){
	                dp[i][j] = dp[i][j-1] + grid[i][j];
	            }else{
	                dp[i][j] = dp[i-1][j] + grid[i][j];
	            }
	        }
	    }
	 
	    return dp[rows-1][columns-1];
	}
}
