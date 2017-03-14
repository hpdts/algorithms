package cracking.moderate;

import org.junit.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import java.util.*;
import java.awt.Point;


public class ModerateTest {

	private Moderate moderate = new Moderate();

	@Test
	public void rotatedArray(){
		int[] numbers1 = new int[] {10, 15 , 20, 0, 5};
		int[] numbers2 = new int[] {50, 5, 20, 30, 40};
		//assertTrue(moderate.binarySearchRotated(numbers1, 5));
		//assertTrue(moderate.binarySearchRotated(numbers2, 5));
		//assertThat(result, is(5));
		int result = moderate.searchRotatedArray(numbers2, 5);
		assertThat(result, is(5));
	}

	@Test
	public void media(){
		int[] numbers = new int[] {2, 45, 67, 3, 1, 90, 156, 4};
		Arrays.sort(numbers);
		System.out.println("Numbers sorted: " + numbers);
		int size = numbers.length;
		if(size % 2  == 0){
			System.out.println("Median: " + (numbers[size/2] + numbers[(size/2) +1]) / 2);
		}else{
			System.out.println("Median: " + numbers[size/2]);
		}
		//for bigger arrays use median of medians get median 
		//for different portions of the array and get the media 
		//for all of them
	}

	@Test
	public void swapInts(){
		int x = 5;
		int y = 8;

 		int temp = x;
 		x = y;
 		y = temp;

		assertThat(x, is(8));

		x = 5;
		y = 8;

 		x = y - x;
 		y = y - x;
 		x = x + y;

		assertThat(y, is(5));

		int a = 5;
		int b = 8;

		a = a^b; // a = 101A110 = 011
		b = a^b; // b = 011A110 = 101
		a = a^b; // a = 011A10l = 110
		
		assertThat(b, is(5));
	}

	@Test
	public void ticTacToe(){

		int[][] boardWinCol = new int[][]{{0,-1,-1},
									   {0 ,-1,0},
									   {0,-1,-1}};

		int[][] boardWin = new int[][]{{-1,-1,-1},
									   {0 ,0,0},
									   {-1,-1,-1}};

		int[][] boardWin2 = new int[][]{{1,-1,-1},
									   {0,1,1},
									   {-1,-1,1}};

		int[][] boardWinDiagonal = new int[][]{{0,-1,1},
									   			{0,1,1},
									   			{1,-1,1}};
									   							   
	    //column or row sum or diagonal sum could be 3 or 0 win

		int[][] boardLoose = new int[][]{{-1,-1,-1},
									     {1,0,0},
									     {0,-1,-1}};

		assertTrue(moderate.isTicTacToeWinner(boardWinCol));
		assertTrue(moderate.isTicTacToeWinner(boardWin));
		assertTrue(moderate.isTicTacToeWinner(boardWin2));
		assertTrue(moderate.isTicTacToeWinner(boardWinDiagonal));
		assertTrue(moderate.isTicTacToeWinner(boardLoose));
	}

	@Test
	public void boardWin(){
		char[][] board = new char[][]{{'\0', 'o' ,'\0'},
						  			  {'o',  '\0' ,'\0'},
						  			  {'x','x','x'}};
		int number = moderate.convertBoardToInt(board);
		System.out.println("number: " + number);

	}

	@Test
	public void trailingZeros(){
		assertThat(moderate.trailingZeros(10), is(2));
		assertThat(moderate.trailingZeros(15), is(3));
		//assertThat(moderate.trailingZeros(25), is(2));
		assertThat(moderate.countFactZeros(25), is(6));
		assertThat(moderate.countFactZeros2(25), is(6));
		assertThat(moderate.countFactZeros(15), is(3));
	}

	@Test
	public void getMax(){
		assertThat(moderate.getMax(25, 2), is(25));
		assertThat(moderate.getMaxBook(25, 2), is(25));
		assertThat(moderate.getMaxNaive(25, 2), is(25));
		assertThat(moderate.flip(1), is(0));
		assertThat(moderate.flip(0), is(1));
		int a = -25;
		System.out.println("shift: " + ((a >> 31) & 0x1));
	}
	
	@Test
	public void masterMind(){
		moderate.masterMind("YRGB");
		moderate.masterMind("YRGM");
		moderate.masterMind("RGYB");
		moderate.estimate("RGBY", "RGYB");
	}

	@Test
	public void findUnsortedSequence(){
		int[] numbers = { 1, 2, 4, 7, 10, 11, 7, 12, 6, 7, 16, 18, 19 };
		moderate.findUnsortedSequence(numbers);
	}

	@Test
	public void wordsFrequency(){
		String text = "Hola como estas this is a text Design a method to find the frequency of occurrences of any given word in a book";
		Map<String, Integer> words = moderate.getFrequency(text);
		System.out.println("words: " + words.toString());
		assertThat(words.get("Hola"), is(1));

		String[] book = new String[] {"hola", "text", "ruin", "day", "day"};
		Hashtable<String, Integer> words2 = moderate.setupDictionary(book);

		assertThat(moderate.getFrequency(words2,"day"), is(2));
	}

	@Test
	public void numberToNames(){
		assertThat(moderate.numberToName(3), is("three"));
		assertThat(moderate.numberToName(11), is("eleven"));
		assertThat(moderate.numberToName(35), is("thirty five"));
	}

	@Test
	public void findSum(){
		int[] numbers = { 1, 2, 4, 10, 11,  12, 6, 7, 16, 18, 19, 3 };
		moderate.findSum(numbers, 9);

		moderate.printPairSums(numbers, 9);
	}
	
	
}