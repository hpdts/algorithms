package cracking.searchsort;

import org.junit.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import java.util.*;
import java.awt.Point;


public class AnagramComparatorTest {

	private AnagramComparator anagram = new AnagramComparator();

	@Test
	public void sortBook(){
		System.out.println("*******BOOK**********");
		String[] strings = new String[]{"home", "god", "dog", "drive", "draw", "pea"};
		System.out.println("WORDS: " + Arrays.toString(strings));
		anagram.sortBook(strings);
		System.out.println("strings sorted: " + Arrays.toString(strings));
	}
}