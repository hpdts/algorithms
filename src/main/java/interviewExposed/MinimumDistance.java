package interviewExposed;

import java.util.*;
import java.util.Arrays;
import java.util.stream.Collectors;

class Cell{
	int row;
	int col;
	int distance;

	Cell(int row, int col, int distance){
		this.row = row;
		this.col = col;
		this.distance = distance;
	}

    public String toString(){
    	return "row: " + this.row + ";col: " + this.col + ";distance: " + this.distance;
    }
}


public class MinimumDistance{

	public int totalDistance(int numRows, int numColumns, List<List<Integer>> area){
		boolean[][] visited = new boolean[numRows][numColumns];

		for(int i = 0; i < numRows; i++){
			for(int j=0; j < numColumns; j++){
				int value = area.get(i).get(j);
				if(value == 1 || value == 9){
					visited[i][j] = true;
				}else{
					visited[i][j] = false;
				}
			}
		}

		for(int i = 0; i < numRows; i++){
			for(int j=0; j < numColumns; j++){
				System.out.println("i: " + i + ", j: " + j + ", visited: " + visited[i][j]);
			}
		}

		Queue<Cell> queue = new LinkedList<>();
		queue.add(new Cell(0, 0, 0));

		while(!queue.isEmpty()){
			Cell cell = queue.poll();
			int dist = cell.distance;
			int row = cell.row;
			int col = cell.col;
			System.out.println("dist: " + dist + ", row: " + row + ", col: " + col);
			int value = area.get(row).get(col);
			System.out.println("value: " + value);
			
			if(value == 9){
				return dist;
			} 

			//up
			if(row - 1 >= 0 && visited[row - 1][col]){
				visited[row][col] = false;
				queue.add(new Cell(row - 1, col, dist+1));
				System.out.println("up: " + (row - 1));
			}

			//down
			if(row + 1 < numRows && visited[row + 1][col]){
				visited[row][col] = false;
				queue.add(new Cell(row + 1, col, dist+1));
				System.out.println("down: " + (row + 1));
			}

			//right
			if(col + 1 < numColumns && visited[row][col + 1]){
				visited[row][col] = false;
				queue.add(new Cell(row, col + 1, dist+1));
				System.out.println("right: " + (col + 1));
			}

			//left
			if(col - 1 >= 0 && visited[row][col - 1]){
				visited[row][col] = false;
				queue.add(new Cell(row, col - 1, dist+1));
				System.out.println("left: " + (col - 1));
			}
		} 
		return -1;
	}
}