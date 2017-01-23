package cracking.moderate;

import java.util.*;

 public class Moderate {

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

	public String masterMind(String guess){
		String value = "RGBY";
		

	}

 }