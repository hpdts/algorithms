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

	
}
