package accelerator;

import java.util.*;
import java.io.*;  

public class WordSearch{

	public boolean wordSearch(char[][] matrix, String input){
		boolean[][] visited = new boolean[matrix.length][matrix[0].length];
		for(int row = 0; row < matrix.length; row++){
			for(int col = 0; col < matrix[0].length; col++){
				if(helper(matrix, input, visited, 0, row, col)){
					return true;
				}
			}
		}
		return false;
	}

	public boolean helper(char[][] matrix, String input, boolean[][] visited, int indexWord, int row, int col){
		if(row < 0 || col < 0 || row >= matrix.length || col >= matrix[0].length || visited[row][col]){
			return false;
		}
		if(input.charAt(indexWord) != matrix[row][col]){
			return false;
		}
		if(++indexWord == input.length()){
			return true;
		}

		visited[row][col] = true;
		if(helper(matrix, input, visited, indexWord, row-1, col)|| 
		   helper(matrix, input, visited, indexWord, row+1, col)||
		   helper(matrix, input, visited, indexWord, row, col-1)||
		   helper(matrix, input, visited, indexWord, row, col+1)){
			return true;
		}
		visited[row][col] = false;
		return false;
	}

}