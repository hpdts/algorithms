package cracking.stringarrays;

import java.util.*;

public class Rotation {

	//first row last column
	public char[][] rotate90(char[][] input){
		if(input == null){
			throw new RuntimeException("input can not be null");
		}
		int rows = input.length;
		int columns = input[0].length;
		char[][] rotated = new char[columns][rows];

		for(char row = 0; row < rows; row++){
			for(char col = 0; col < columns; col++){
				rotated[col][rows - 1 - row] = input[row][col];
			}
		}
		return rotated;
	}

	public int[][] rotate90(int[][] input){
		if(input == null){
			throw new RuntimeException("input can not be null");
		}
		int rows = input.length;
		int columns = input[0].length;
		int[][] rotated = new int[columns][rows];

		for(int row = 0; row < rows; row++){
			for(int col = 0; col < columns; col++){
				rotated[col][rows - 1 - row] = input[row][col];
			}
		}
		return rotated;
	}


	public void rotate(int[][] matrix, int n) {
		for (int layer = 0; layer < n / 2; ++layer) {
			int first = layer;
	 		int last = n - 1 - layer;
			for(int i = first; i < last; ++i) {
				int offset = i - first;
				// save top
				int top = matrix[first][i];
				 // left -> top
				 matrix[first][i] = matrix[last-offset][first];
				 // bottom -> left
				 matrix[last-offset][first] = matrix[last][last - offset];
				 // right -> bottom
				 matrix[last][last - offset] = matrix[i][last];
				 // top -> right
				 matrix[i][last] = top;
	 		}
	 	}
	 }
	
	
}
