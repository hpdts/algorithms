package cracking.stringarrays;

import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import java.util.*;


public class RotationTest {

	private Rotation rotation = new Rotation();
	
	@Test
	public void rotationNumbers(){
		int[][] numbers = new int[4][4];
		int element = 1;

		for(int i=0; i < 4; i++){
			for(int j=0; j < 4; j++){
				numbers[i][j] = element++;
			}
		}
		printArray(numbers);
		System.out.println("ROTATED 90 CLOCKWISE");
		printArray(rotation.rotate90(numbers));
	}

	@Test
	public void rotationChars(){
		char[][] numbers = new char[4][7];
		int element = 1;

		for(int i=0; i < 4; i++){
			for(int j=0; j < 7; j++){
				if(j == 3){
					if(i == 0){
						numbers[i][j] = '^';
					}else{
						numbers[i][j] = '|';
					}
				}else{
					numbers[i][j] = '*';
				}
			}
		}
		printArray(numbers);
		System.out.println("ROTATED 90 CLOCKWISE");
		printArray(rotation.rotate90(numbers));
	}

	private void printArray(int[][] input){
		for (int[] arr : input) {
            System.out.println(Arrays.toString(arr));
        }
	}

	private void printArray(char[][] input){
		for (char[] arr : input) {
            System.out.println(Arrays.toString(arr));
        }
	}

	@Test
	public void spiralPrint(){
		int[][] numbers = new int[6][6];
		int element = 1;

		for(int i=0; i < 6; i++){
			for(int j=0; j < 6; j++){
				numbers[i][j] = element++;
			}
		}
		printArray(numbers);
		ArrayList<Integer> spirals = rotation.spiralOrder(numbers);
		System.out.println("SpiralPrint " + spirals.toString());
		
	}

	@Test
	public void myPrint(){
		//22 middle
		System.out.println("MyPrint");
		int[][] numbers = new int[6][6];
		int element = 1;

		for(int i=0; i < 6; i++){
			for(int j=0; j < 6; j++){
				numbers[i][j] = element++;
			}
		}
		printArray(numbers);
		List<Integer> spirals = rotation.myPrint(numbers, 3 , 3);
		System.out.println("myPrint " + spirals.toString());
		
	}
	
}
