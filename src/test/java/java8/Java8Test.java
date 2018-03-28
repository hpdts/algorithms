package java8;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import com.google.common.collect.*;
import java.util.*;
import org.junit.*;
import static java8.Java8.*;
import static org.junit.Assert.*;


public class Java8Test {
    private Java8 java8 = new Java8();

    @Test
	public void filteringNames(){
		Book book = new Book(1, "Lord of the rings", "tolkien");
		Book book2 = new Book(2, "The Shinning", "Redrum");
		Book book3 = new Book(3, "Michael Jackson", "Biography");
		List<Book> books = new ArrayList<>();
		books.add(book);
		books.add(book2);
		books.add(book3);

		List<String> names = java8.getBookNames(books);
		System.out.println("names: " + names);
		assertThat(names.size(), is(3));

		assertTrue(books.contains(book2));
		System.out.println("New List: " + books);

		Point one = new Point(1, 2);
		Point two = new Point(2, 1);
		Point three = new Point(3, 3);

		ArrayList points = new ArrayList();
		points.add(one);
		points.add(two);
		points.add(three);
		assertTrue(points.contains(two));

		HashMap map = new HashMap();
		map.put(one, 1);
		map.put(two, 2);

		assertThat(map.get(one), is(1));
	}

	@Test
	public void getNextState(){
		char[][] board = new char[][]{{'d', 'd', 'd'}, {'a', 'a', 'a'}, {'a', 'a', 'a'}};
	/*	d d d  => d,a,
  1// a a a
  2// a a a*/
  		System.out.println("Board: " + Arrays.deepToString(board));

		char[][] newBoard = java8.getNextState(board);

		System.out.println("Next State Board: " +  Arrays.deepToString(newBoard));
	}

	@Test
	public void sudoku(){
		int[][] solutionBoard = new int[][] {{4,3,5,2,6,9,7,8,1},
		                             {6,8,2,5,7,1,4,9,3},
		                             {1,9,7,8,3,4,5,6,2},
		                             {8,2,6,1,9,5,3,4,7},
		                             {3,7,4,6,8,2,9,1,5},
		                             {9,5,1,7,4,3,6,2,8},
		                             {5,1,9,3,2,6,8,7,4},
		                             {2,4,8,9,5,7,1,3,6},
		                             {7,6,3,4,1,8,2,5,9}};

		int[][] board = new int[][] {{3,0,6,5,0,8,4,0,0},
		                             {5,2,0,0,0,0,0,0,0},
		                             {0,8,7,0,0,0,0,3,1},
		                             {0,0,3,0,1,0,0,4,0},
		                             {9,0,0,8,6,3,0,0,5},
		                             {0,5,0,0,9,0,6,0,0},
		                             {1,3,0,0,0,0,2,5,0},
		                             {0,0,0,0,0,0,0,7,4},
		                             {0,0,5,2,0,6,3,0,0}};


		//assertTrue(java8.isSudoku(solutionBoard));
		//int[][] solBoard = java8.getSudokuSolution(board);
	}

	//01-27-2018 Problem
	@Test
	public void contest(){
		List<String> result = java8.getSubStrings("wawaglknagagwvmagkwkwlael", 4);
		//System.out.println("Result: " + result);
		assertThat(result.size(), is(6));
	} 

	@Test
	public void scene(){
		String input = "ababcbacadefegdehijhklij";
		//"abc"
		List<Integer> indexes = java8.getIndexes(input);
		System.out.println("indexes: " + indexes);
		assertThat(indexes.get(0), is(9));
		assertThat(indexes.get(1), is(7));
		assertThat(indexes.get(2), is(8));
	}

	//03-12-2018 Problem A
	//find longest part on each word. if the parts have the same length pick the first one 
	//to appear on array parts 
	@Test
	public void containsParts(){
		String[] words = { "Apple", "melon", "banana", "orange" };
		String[] parts = { "a" , "lon" , "mel", "bana" , "na", "ra"};

		String[] output = java8.getWordParts(words, parts);
		//apple, me[lon], bana[na]
		//System.out.println("output: " + output);
		assertThat(output[0], is("[bana]na"));
		assertThat(output[1], is("o[ra]nge"));
		assertThat(output[2], is("Apple"));
		assertThat(output[3], is("me[lon]"));
	}

	@Test
	public void parseJson(){
		assertFalse(java8.parseJSON("[\"boom\", 42, \"anytime, hello\"]"));
		assertTrue(java8.parseJSON("[653, \"good\", \"bad\", 22]"));
		assertFalse(java8.parseJSON("653]"));
		assertFalse(java8.parseJSON("653["));
		assertFalse(java8.parseJSON("653]["));
		assertTrue(java8.parseJSON("5"));
		assertTrue(java8.parseJSON("32222"));
		assertTrue(java8.parseJSON("\"yay\""));
		assertTrue(java8.parseJSON("\"happiness\""));
		assertTrue(java8.parseJSON("[42]"));
		assertFalse(java8.parseJSON("[653"));
		assertFalse(java8.parseJSON("\"653"));
		assertFalse(java8.parseJSON("\"653\",653\""));
	}
}