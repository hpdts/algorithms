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

}