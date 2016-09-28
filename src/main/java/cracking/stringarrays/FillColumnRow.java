package cracking.stringarrays;

import java.util.*;

public class FillColumnRow {

	public int[][] fillRowColumnWith0(int[][] input){
		int[][] dataCopy = Arrays.stream(input)
             				.map((int[] row) -> row.clone())
             				.toArray((int length) -> new int[length][]);

		if(input == null){
			throw new RuntimeException("input can not be null");
		}
		int rows = input.length;
		int columns = input[0].length;

		for(int row = 0; row < rows; row++){
			for(int col = 0; col < columns; col++){
				if(input[row][col] == 0){
					fillRowColumn(row, col, 0, dataCopy);
				}

			}
		}
		return dataCopy;


	}

	public void fillRowColumn(int rowTarget, int columnTarget, int value, int[][] input){
		int rows = input.length;
		int columns = input[0].length;

		for(int row = 0; row < rows; row++){
			input[row][columnTarget] = value;
		}

		for(int col = 0; col < columns; col++){
			input[rowTarget][col] = value;
		}
	}

	public void setZeros(int[][] matrix) {
		boolean[] row = new boolean[matrix.length];
		boolean[] column = new boolean[matrix[0].length];
		
		// Store the row and column index with value 0
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length;j++) {
				if (matrix[i][j] == 0) {
					row[i] = true;
		 			column[j] = true;
		 		}
		 	}
		}
		
		// Set arr[i][j] to 0 if either row i or column j has a 0
		for (int i = 0; i < matrix.length; i++) {
		 	for (int j = 0; j < matrix[0].length; j++) {
		 		if (row[i] || column[j]) {
		 			matrix[i][j] = 0;
		 		}
		 	}
		}
	}	
}
