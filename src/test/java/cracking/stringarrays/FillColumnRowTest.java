package cracking.stringarrays;

import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import java.util.*;


public class FillColumnRowTest {

	private FillColumnRow fillColumnRow = new FillColumnRow();
	
	@Test
	public void noFill(){
		int[][] numbers = new int[4][4];
		int element = 1;

		for(int i=0; i < 4; i++){
			for(int j=0; j < 4; j++){
				numbers[i][j] = element++;
			}
		}
		int[][] newNumbers = fillColumnRow.fillRowColumnWith0(numbers);
		printArray(newNumbers);
		assertThat(newNumbers[3][3], is(16));
		assertThat(newNumbers[0][2], is(3));
	}

	@Test
	public void fill(){
		int[][] numbers = new int[4][6];
		int element = 1;

		for(int i=0; i < 4; i++){
			for(int j=0; j < 6; j++){
				numbers[i][j] = element++;
			}
		}
		numbers[0][2] = 0;
		printArray(numbers);
		int[][] newNumbers = fillColumnRow.fillRowColumnWith0(numbers);
		System.out.println("FILLED");
		printArray(newNumbers);
		assertThat(newNumbers[3][4], is(23));
		assertThat(newNumbers[0][2], is(0));
	}

	@Test
	public void fillBook(){
		int[][] numbers = new int[4][6];
		int element = 1;

		for(int i=0; i < 4; i++){
			for(int j=0; j < 6; j++){
				numbers[i][j] = element++;
			}
		}
		numbers[0][2] = 0;
		printArray(numbers);
		fillColumnRow.setZeros(numbers);
		System.out.println("FILLED");
		printArray(numbers);
		assertThat(numbers[3][4], is(23));
		assertThat(numbers[0][2], is(0));
	}

	private void printArray(int[][] input){
		for (int[] arr : input) {
            System.out.println(Arrays.toString(arr));
        }
	}

}
