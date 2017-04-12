package cracking.searchsort;

import org.junit.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import static cracking.searchsort.SearchSort.*;
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

	@Test
	public void mergeSort(){
		System.out.println("**** Merge Sort ****");
		int[] numbers = new int[]{17, 13, 2, 8};
		System.out.println("Sorted: " + Arrays.toString(searchSort.sortMerge(numbers)));
		searchSort.iterativeMergesort(numbers);
		System.out.println("Iterative Sorted: " + Arrays.toString(numbers));
	}

	@Test
	public void mergeSortTwoElements(){
		System.out.println("**** Merge Sort Two elements****");
		int[] numbers = new int[]{2, 1};
		System.out.println("Sorted: " + Arrays.toString(searchSort.sortMerge(numbers)));
	}

	@Test
	public void iterativeMergeSort(){
		System.out.println("**** Iterative Merge Sort ****");
		int[] numbers = new int[]{17, 13};
		searchSort.iterativeMergesort(numbers);
		System.out.println("Iterative Sorted: " + Arrays.toString(numbers));
	}

	@Test
	public void sortWithEmptyStrings(){
		System.out.println("**** Sort empty String ****");
		String[] words = {"travel", "", "", "", "tree", "car", "hello"};
		int countEmptyString = searchSort.sortCountEmpty(words);
		System.out.println("Count: " + countEmptyString);
		System.out.println("Words: " + Arrays.toString(words));

		//binary search 

		assertTrue(searchSort.binarySearch2(words, "tree", 0, words.length - countEmptyString));
		assertFalse(searchSort.binarySearch2(words, "martin", 0, words.length - countEmptyString));

	}

	@Test
	public void searchEmptyStrings(){
		String[] words = {"at", "", "", "", "ball", "", "", "car", "", "", "dad", "", ""};
		int position = searchSort.searchR(words, "dad", 0, words.length - 1);

		assertThat(position, is(10));

	}

	@Test
	public void searchOnMatrix(){
		int[][] matrix = {{1,2,3,4},
						  {2,3,4,5},
						  {3,4,5,6},
						  {7,8,9,10}};
		assertTrue(searchSort.searchOnMatrix(matrix, 10));
	}

	@Test
	public void findElement(){

		int[][] matrix = {{15, 20, 40, 85},
						  {20, 35, 80, 95},
						  {30, 55, 95, 105},
						  {40, 80, 100, 120}};
		assertTrue(searchSort.findElement(matrix, 55));
	}

	@Test
	public void circus(){

		Person p1 = new Person(65, 100);
		Person p1a = new Person(65, 101);
		Person p2 = new Person(70, 150);
		Person p3 = new Person(56, 90);
		Person[] persons = {p1, p1a, p2 ,p3};

		System.out.println("Int compare: " + p1.compareTo(p1a));
		Person[] persons2 = searchSort.selectionSortPerson(persons);
		searchSort.mergesort(persons);
		System.out.println("Sorted Merge: " + Arrays.toString(persons));
		
		//< 0 p1 lower than p2
		//> 0 p1 greater than p2
		//0 p1 equal than p2, check weight

		assertTrue(Arrays.equals(persons2, persons));

		HtWt h1 = new  HtWt(65, 100);
		HtWt h1a = new HtWt(65, 101);
		HtWt h2 = new  HtWt(70, 150);
		HtWt h3 = new  HtWt(56, 90);

		List<HtWt> heights = new ArrayList<HtWt>();
		heights.add(h1);
		heights.add(h1a);
		heights.add(h2);
		heights.add(h3);

		System.out.println("Sorted Book: " + heights.toString());
		
	}

	@Test
	public void streamInt(){
		LinkedList<Integer> numbers = new LinkedList<>();
		assertThat(searchSort.addSortedNumbers(numbers, 26), is(0));
		assertThat(searchSort.addSortedNumbers(numbers, 10), is(0));
		assertThat(searchSort.addSortedNumbers(numbers, 45), is(2));
		assertThat(searchSort.addSortedNumbers(numbers, 5), is(0));
		assertThat(searchSort.addSortedNumbers(numbers, 3), is(0));
		assertThat(searchSort.addSortedNumbers(numbers, 6), is(2));
		assertThat(searchSort.addSortedNumbers(numbers, 7), is(3));
		assertThat(searchSort.addSortedNumbers(numbers, 7), is(3));


		System.out.println("Stream numbers: " + numbers);
	}

}