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
	
}
