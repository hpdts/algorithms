package designAlgorithms;

import org.junit.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import com.google.common.collect.*;
import java.io.*;
import java.util.*;
import static org.junit.Assert.*;


public class SortingTest {
	public Sorting sorting = new Sorting();
	final int HIGHEST_POSSIBLE_SCORE = 100;

	@Test
	public void countingSort(){
		int range = 10;
		int[] numbers = {1,2,3,4,5,6,1,2,3,7,8,9,1,3,6,3,8,10};
		int[] sortedActual = sorting.countingSort(numbers, range);

		int[] sortedExpected = {1,1,1,2,2,3,3,3,3,4,5,6,6,7,8,8,9,10};
		assertThat(Arrays.toString(sortedActual), is(Arrays.toString(sortedExpected)));
	} 

	@Test
	public void removeDuplicates(){
		int[] numbers = {1,2,3,4,5,6,1,2,3,7,8,9,1,3,6,3,8,10};

		int[] numbersActual = sorting.removeDuplicates(numbers);

		int[] numbersExpected = {1,2,3,4,5,6,7,8,9,10, 0, 0, 0, 0, 0, 0, 0, 0};
		assertThat(Arrays.toString(numbersExpected), is(Arrays.toString(numbersActual)));
	} 

	@Test
	public void removeDuplicatesSorting(){
		int[] numbers = {1,2,3,4,5,6,1,2,3,7,8,9,1,3,6,3,8,10};

		int[] numbersActual = sorting.removeDuplicatesSorting(numbers);

		int[] numbersExpected = {1,2,3,4,5,6,7,8,9,10, 0, 0, 0, 0, 0, 0, 0, 0};
		assertThat(Arrays.toString(numbersExpected), is(Arrays.toString(numbersActual)));
	}

	@Test
	public void oneEdit2Words(){
		assertFalse(sorting.isEditDistanceOne("gfg", "gfg"));
		assertTrue(sorting.isEditDistanceOne("gfg", "gfgg"));
		assertFalse(sorting.isEditDistanceOne("gfg", "gfggfr"));
		assertTrue(sorting.isEditDistanceOne("gfg", "gf"));
	}

	@Test
	public void mergeSort(){
		int[] a = {1, 2, 3};
		int[] b = {2, 5, 6};
		int[] sortedActual = sorting.mergeSort(a, b);

		int[] sortedExpected = {1, 2, 2, 3, 5, 6};
		assertThat(Arrays.toString(sortedActual), is(Arrays.toString(sortedExpected)));
	} 

	@Test
	public void mergeSort2(){
		int[] a = {10, 12};
		int[] b = {1, 2};
		int[] sortedActual = sorting.mergeSort(a, b);

		int[] sortedExpected = {1, 2, 10, 12};
		assertThat(Arrays.toString(sortedActual), is(Arrays.toString(sortedExpected)));
	} 

	@Test
	public void mergeSort3(){
		int[] a = {8, 10, 12};
		int[] b = {1, 9, 11};
		int[] sortedActual = sorting.mergeSort(a, b);

		int[] sortedExpected = {1, 8, 9, 10, 11, 12};
		assertThat(Arrays.toString(sortedActual), is(Arrays.toString(sortedExpected)));
	}

	@Test
	public void mergeSort4(){
		int[] a = {20, 22, 30};
		int[] b = {1, 9, 11};
		a = sorting.mergeSort(a, b);

		int[] sortedExpected = {1, 9, 11, 20, 22, 30};
		assertThat(Arrays.toString(a), is(Arrays.toString(sortedExpected)));
	}

	@Test
	public void countingScores(){
		int[] numbers = {37, 89, 41, 65, 91, 53};
		int[] sortedActual = sorting.sortScores(numbers, HIGHEST_POSSIBLE_SCORE);

		int[] sortedExpected = {91, 89, 65, 53, 41, 37};
		assertThat(Arrays.toString(sortedActual), is(Arrays.toString(sortedExpected)));
	} 
}