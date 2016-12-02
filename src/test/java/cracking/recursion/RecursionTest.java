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
        Set<String> parens = recursion.generateParens(2);
        System.out.println("Parens: " + parens);

	}

	@Test
	public void generateParenthesisBook2(){
        ArrayList<String> parens = recursion.generateParensBook(2);
        assertThat(parens.toString(), is("[(()), ()()]"));
	}

	

	
}