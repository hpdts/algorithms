package cracking.recursion;

import org.junit.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import java.util.*;
import java.awt.Point;


public class RecursionTest {

	private Recursion recursion = new Recursion();
	

	@Test
	public void staircase(){
		
		assertThat(recursion.staircase(3), is(2));
	}

	@Test
	public void staircase2(){
		
		assertThat(recursion.fibRecur(3), is(2));
		assertThat(recursion.fibRecur(4), is(3));
		assertThat(recursion.fibRecur(5), is(5));
		assertThat(recursion.fibRecur(6), is(8));
		assertThat(recursion.fibRecur(7), is(13));
	}

	@Test
	public void countWays(){
		
		assertThat(recursion.countWays(10), is(274));
	}

	@Test
	public void countWaysDP(){
		
		assertThat(recursion.countWaysDP(10, new int[12]), is(274));
	}


	@Test
	public void robothPath(){
		List<String> paths = recursion.robotPaths(3);
		System.out.println("paths: " + paths);
		assertNotNull(paths);
	}

	@Test
	public void getPathBook(){
		ArrayList<Point>  paths = new ArrayList<>();
		assertTrue(recursion.getPathBook(3, 3, paths));
		System.out.println("paths: " + paths);
	}

	@Test
	public void getPathBookCache(){
		ArrayList<Point>  paths = new ArrayList<>();
		Hashtable<Point, Boolean> cache = new Hashtable<>();
		assertTrue(recursion.getPathCache(3, 3, paths, cache));
		System.out.println("paths: " + paths);
	}

	@Test
	public void magicIndex(){
		int[] numbers = {9, 4, 3, 2, 10, 5, 7, 8};
		assertThat(recursion.isMagicalIndex(numbers), is(5));
	}

	@Test
	public void magicFastBook(){
		int[] numbers = {9, 4, 3, 2, 10, 5, 7, 8};
		assertThat(recursion.magicFastBook(numbers), is(5));
	}

	@Test
	public void subset(){
		char set[] = {'a', 'b', 'c'};
        recursion.printSubsets(set);
	}

	@Test
	public void subsetBook(){
        ArrayList<Integer> setInts = new ArrayList<>(Arrays.asList(1, 2));
        ArrayList<ArrayList<Integer>> getSubsets = recursion.getSubsets(setInts, 0);
        for(ArrayList<Integer> setSub : getSubsets){
        	System.out.println("set: " + setSub.toString());
        }
	}

	@Test
	public void subsetBook2(){
        ArrayList<Integer> setInts = new ArrayList<>(Arrays.asList(1, 2));
        ArrayList<ArrayList<Integer>> getSubsets = recursion.getSubsets2(setInts);
        for(ArrayList<Integer> setSub : getSubsets){
        	System.out.println("set: " + setSub.toString());
        }
	}

	@Test
	public void permutations(){
		List<String> permutations = new ArrayList<>();
 	
        String chars = "AB";
        recursion.permutations("", chars, permutations);

        System.out.println("permutations: " + permutations);
	}

	@Test
	public void permutationsBook(){
		List<String> permutations = new ArrayList<>();
 	
        String chars = "AB";
        permutations = recursion.getPerms(chars);

        System.out.println("permutations2: " + permutations);
	}

	@Test
	public void printParenthesis(){
        recursion.printParenthesis(2);
        System.out.println("Parenthesis: " + recursion.str);

	}

	@Test
	public void generateParenthesis(){
        Set<String> parens = recursion.generateParens(4);
        System.out.println("Parens: " + parens);

	}

	@Test
	public void generateParenthesisBook2(){
        ArrayList<String> parens = recursion.generateParensBook(2);
        assertThat(parens.toString(), is("[(()), ()()]"));
	}

	@Test
	public void floodFill(){
		int[][] screen = new int[][]{
								  {1, 1, 1, 1, 1, 1, 1, 1},
			                      {1, 1, 1, 1, 1, 1, 0, 0},
			                      {1, 0, 0, 1, 1, 0, 1, 1},
			                      {1, 2, 2, 2, 2, 0, 1, 0},
			                      {1, 1, 1, 2, 2, 0, 1, 0},
			                      {1, 1, 1, 2, 2, 2, 2, 0},
			                      {1, 1, 1, 1, 1, 2, 1, 1},
			                      {1, 1, 1, 1, 1, 2, 2, 1},
			                      };

        int[][] screenafter = new int[][]{
        						  {1, 1, 1, 1, 1, 1, 1, 1},
			                      {1, 1, 1, 1, 1, 1, 0, 0},
			                      {1, 0, 0, 1, 1, 0, 1, 1},
			                      {1, 3, 3, 3, 3, 0, 1, 0},
			                      {1, 1, 1, 3, 3, 0, 1, 0},
			                      {1, 1, 1, 3, 3, 3, 3, 0},
			                      {1, 1, 1, 1, 1, 3, 1, 1},
			                      {1, 1, 1, 1, 1, 3, 3, 1},
			                      };

		recursion.floodFill(screen, 4, 4, 3);

		assertThat(screen[4][4], is(3));
		assertThat(screen, is(screenafter));
	}

	@Test
	public void makeChange(){
		int ways = recursion.makeChangeIterative(25);
		System.out.println("ways: " + ways);	
	}

	@Test
	public void makeChangeRecursive(){
		int ways = recursion.makeChange(25);
		System.out.println("2 ways: " + ways);	
	}

	@Test
	public void makeChangeRecursiveBook(){
		System.out.println("ways Book: " + recursion.makeChangeBook(10, 25));
	}

	@Test
	public void total(){
		int amount = 10;
		int[] coins = { 1, 5, 10, 25 };
		System.out.println("Make change " + recursion.total(amount, coins, 0));
	}


	@Test
	public void queens8(){
		int[][] board = new int[][]{
								  {1, 1, 1, 1, 1, 1, 1, 1},
			                      {1, 1, 1, 1, 1, 1, 1, 1},
			                      {1, 1, 1, 1, 1, 1, 1, 1},
			                      {1, 1, 1, 1, 1, 1, 1, 1},
			                      {1, 1, 1, 1, 1, 1, 1, 1},
			                      {1, 1, 1, 1, 1, 1, 1, 1},
			                      {1, 1, 1, 1, 1, 1, 1, 1},
			                      {1, 1, 1, 1, 1, 1, 1, 1},
			                      };

		System.out.println("*********  board with 8 queens: ********* "); 
		recursion.set8queens(board);
		printArray(board);                      

	}


	@Test
	public void queens8Book(){
		Integer[] board = new Integer[8];

		ArrayList<Integer[]> results = new ArrayList<>();

		recursion.placeQueens(0, board, results);
		System.out.println("results: ");
		int j = 0;
		for(Integer i : board){
			System.out.println("Row: " + j + ", col: " + i);
			j++;
		}
	}

	@Test
	public void queens4(){
		int[][] board = new int[][]{
								  {1, 1, 1, 1},
			                      {1, 1, 1, 1},
			                      {1, 1, 1, 1},
			                      {1, 1, 1, 1}};


		System.out.println("********* board with 4 queens: ********"); 
		recursion.set8queens(board);
		printArray(board);                      

	}

	private void printArray(int[][] input){
		for (int[] arr : input) {
            System.out.println(Arrays.toString(arr));
        }
	}

	@Test
	public void boxes(){
		System.out.println("********* Stack Boxes ********"); 
		Recursion.Box box1 = new Recursion.Box(1, 1 ,1 );                  
		Recursion.Box box2 = new Recursion.Box(2, 2 ,2 );                  
		Recursion.Box box3 = new Recursion.Box(3, 3 ,3 );   

		List<Recursion.Box> input = new ArrayList<>();
		input.add(box2);
		input.add(box1);
		input.add(box3);
		assertThat(recursion.tallestStack(input), is(6));
	}

	@Test
	public void compression(){
		System.out.println("********* compression ********");
		assertThat(recursion.compress("aabc"), is("aabc"));
		assertThat(recursion.compress("abc"), is("abc"));
		assertThat(recursion.compress("aaabc"), is("ax3bc"));
		assertThat(recursion.compress("aaaabc"), is("ax4bc"));
		assertThat(recursion.compress("aaaabccccc"), is("ax4bcx5"));
		assertThat(recursion.compress("ax1bccccc"), is("ax1bcx5"));
	}

	@Test
	public void binaryExpression(){
		System.out.println("********* Binary Parenthesis ********"); 
		//assertFalse(recursion.addParenthesisToBinary("1^0|0|1", false));
		System.out.println("add paren: " + recursion.addParen("1^0|0|1"));

		System.out.println("times: " + recursion.f("1^0|0|1", false, 0, 0)); 


	}
}