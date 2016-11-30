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

	public ArrayList<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> result = new ArrayList<Integer>();
 
        if(matrix == null || matrix.length == 0) return result;
 
 		//rows
        int m = matrix.length;
        //cols
        int n = matrix[0].length;
 		
 		//indexrows
        int x=0; 
        //indexcols
        int y=0;
 
        while(m>0 && n>0){
 			System.out.println("indexrows: " + x);
 			System.out.println("indexcols: " + y);
            //if one row/column left, no circle can be formed
            if(m == 1){
                for(int i=0; i<n; i++){
                    result.add(matrix[x][y++]);
                }
                break;
            }else if(n == 1){
                for(int i=0; i<m; i++){
                    result.add(matrix[x++][y]);
                }
                break;
            }
 
            //below, process a circle
 
            //top - move right
            for(int i=0;i < n-1;i++){
            	int elem = matrix[x][y++];
            	System.out.println("top: " + elem);
                result.add(elem);
            }
 
            //right - move down
            for(int i=0;i < m-1;i++){
            	int elem = matrix[x++][y];
            	System.out.println("right: " + elem);
                result.add(elem);
            }
 
            //bottom - move left
            for(int i=0;i<n-1;i++){
            	int elem = matrix[x][y--];
            	System.out.println("bottom: " + elem);
                result.add(elem);
            }
 
            //left - move up
            for(int i=0;i<m-1;i++){
            	int elem = matrix[x--][y];
            	System.out.println("left: " + elem);
                result.add(elem);
            }
 
            x++;
            y++;
            m = m-2;
            n = n-2;
        }
 
        return result;
    }
	
	public List<Integer> myPrint(int[][] matrix, int rowMiddle, int colMiddle){
		List<Integer> result = new ArrayList<>();
		int rows = matrix.length; 
		int cols = matrix[0].length; 
		//print top rows
		for(int i = 0; i < rowMiddle; i++){
			for(int j =0; j < cols; j++){
				System.out.println("top: " + matrix[i][j]);
				result.add(matrix[i][j]);
			}
		}
		//print bottom
		for(int i = rowMiddle + 1; i < rows; i++){
			for(int j =0; j < cols; j++){
				System.out.println("bottom: " + matrix[i][j]);
				result.add(matrix[i][j]);
			}
		}

		//print middle
		for(int j =0; j < cols; j++){
			System.out.println("middle: " + matrix[rowMiddle][j]);
			result.add(matrix[rowMiddle][j]);
		}
		return result;

	}
	
}
