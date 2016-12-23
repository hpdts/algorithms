package cracking.searchsort;

import org.junit.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import java.util.*;
import java.awt.Point;


public class SearchSortTest {

	private SearchSort searchSort = new SearchSort();
	
	@Test
	public void mergeArray(){
		
		int[] a = new int[]{1, 3, 8 , 0, 0 , 0};
		int[] b = new int[]{2, 6, 20};
		int[] c = searchSort.mergeArray(a, b);
		System.out.println("c: " + Arrays.toString(c));
		//assertThat(searchSort.staircase(3), is(2));
	}

	@Test
	public void mergeBook(){
		
		int[] a = new int[]{1, 3, 8 , 0, 0 , 0};
		int[] b = new int[]{2, 6, 20};
		searchSort.merge(a, b, 3, 3);
		System.out.println("a: " + Arrays.toString(a));
		//assertThat(searchSort.staircase(3), is(2));
	}

	@Test
	public void sortAnagrams(){
		String[] strings = new String[]{"home", "god", "dog", "drive", "draw", "pea"};
		System.out.println("WORDS sorted: " + Arrays.toString(strings));
		String[] stringsSorted = searchSort.sortStrings(strings);
		System.out.println("strings sorted: " + Arrays.toString(stringsSorted));

		String[] strings2 = new String[]{"home", "god", "dog", "drive", "draw", "pea"};
		Arrays.sort(strings2, new AnagramComparator());
		System.out.println("strings Book sorting: " + Arrays.toString(strings2));
	}
	
	@Test
	public void anagrams(){
		assertTrue(searchSort.isAnagram("god", "dog"));
		assertFalse(searchSort.isAnagram("me","mine"));

	}

	@Test
	public void binarySearch(){
		System.out.println("**** Binary Search ****");

		int[] numbers = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
		System.out.println("numbers: " + Arrays.toString(numbers));

		assertTrue(searchSort.binarySearch(numbers, 6));

		assertFalse(searchSort.binarySearch(numbers, 60));
	}

	@Test
	public void binarySearchRecursive(){
		System.out.println("**** Binary Search Recursive ****");

		int[] numbers = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
		System.out.println("numbers: " + Arrays.toString(numbers));

		assertTrue(searchSort.binarySearchRecursive(numbers, 0, numbers.length -1, 6) > 0);

		//search with java API
		assertTrue(Arrays.binarySearch(numbers, 6) > 0);
	}

	@Test
	public void binarySearchRotated(){
		System.out.println("**** Binary Search Rotated Array ****");

		int[] numbers = new int[]{15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14};
		System.out.println("numbers: " + Arrays.toString(numbers));

		assertTrue(searchSort.binarySearchRotated(numbers, 5));

		assertFalse(searchSort.binarySearchRotated(numbers, 60));
	}

	@Test
	public void binarySearchRotatedBook(){
		System.out.println("**** Binary Search Rotated Array Book ****");

		int[] numbers = new int[]{15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14};
		System.out.println("numbers: " + Arrays.toString(numbers));

		assertTrue(searchSort.search(numbers, 0, numbers.length -1, 5) > 0);

		assertFalse(searchSort.search(numbers, 0, numbers.length - 1, 60) > 0);
	}

	@Test
	public void insertionSort(){
		System.out.println("**** Insertion Sort ****");
		int[] numbers = new int[]{15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14};
		System.out.println("Sorted: " + Arrays.toString(searchSort.insertionSort(numbers)));
	}
}