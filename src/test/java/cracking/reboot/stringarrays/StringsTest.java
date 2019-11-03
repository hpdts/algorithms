package cracking.reboot.stringarrays;

import org.junit.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import java.util.Arrays; 


public class StringsTest {

	private Strings strings = new Strings();

	@Test
	public void unique(){
		assertFalse(strings.isHasAllUniqueCharacters("ana"));
		assertTrue(strings.isHasAllUniqueCharacters("vamos"));
		assertTrue(strings.isHasAllUniqueCharacters("dieE"));
	}

	@Test
	public void isUnique(){
		assertTrue(strings.isUnique(new int[]{1 , 2, 4, 5}));
		assertFalse(strings.isUnique(new int[]{1 , 2, 4 , 5, 1}));
		assertFalse(strings.isUnique(new int[]{1 , 2, 3, 4, 4 , 5}));
	}

	@Test
	public void arePermutation(){
		assertTrue(strings.arePermutations("silent","listen"));
		assertTrue(strings.arePermutations("elvis", "lives"));
		assertFalse(strings.arePermutations("paco", "poco"));
	}

	@Test
	public void arePermutation2(){
		assertTrue(strings.arePermutations2("fried","fired"));
		assertTrue(strings.arePermutations2("parent", "entrap"));
		assertFalse(strings.arePermutations2("parents", "entraap"));
		assertTrue(strings.arePermutations2("sister", "resist"));
		assertFalse(strings.arePermutations2("paco", "poco"));
	}

	@Test
	public void urlify(){
		String word = "Mr John Smith         ";
		assertThat(strings.countCharacters(word.toCharArray(), 0, 13, ' '), is(2));
		assertThat(strings.countCharacters(word.toCharArray(), 0, 14, ' '), is(3));
		char[] letters = word.toCharArray();
		strings.replaceSpaces(letters, 13);
		System.out.println("letters: " + String.valueOf(letters));
	}

	@Test
	public void arePalindromePermutation(){
		assertTrue(strings.isPalindromePermutation("abba"));
		assertTrue(strings.isPalindromePermutation("aabb"));
		assertFalse(strings.isPalindromePermutation("parents"));
		assertTrue(strings.isPalindromePermutation("oso"));
		assertTrue(strings.isPalindromePermutation("civic"));
		assertTrue(strings.isPalindromePermutation("ciivvvvviic"));
		assertTrue(strings.isPalindromePermutation("cvici"));
		assertTrue(strings.isPalindromePermutation("ardar"));
		assertTrue(strings.isPalindromePermutation("tacocat"));
		assertTrue(strings.isPermutationOfPalidrome("Taco cat"));
		assertTrue(strings.isPermutationOfPalidrome("madam"));
		assertTrue(strings.isPermutationOfPalidrome2("aba"));
		assertTrue(strings.isPermutationOfPalidrome3("aba"));
	}


	@Test
	public void areOneEdition(){
		assertTrue(strings.areOneOperationAway("hello", "helpo"));
		assertTrue(strings.areOneOperationAway("bale", "ale"));
		assertTrue(strings.areOneOperationAway("ale", "bale"));
		assertFalse(strings.areOneOperationAway("bale", "alell"));

		assertTrue(strings.areOneOperationAway2("hello", "helpo"));
		assertTrue(strings.areOneOperationAway2("bale", "ale"));
		assertTrue(strings.areOneOperationAway2("ale", "bale"));
		assertFalse(strings.areOneOperationAway2("bale", "alell"));
	}

	@Test
	public void reverse(){
		assertThat(strings.reverse("a,b$c"), is("c,b$a"));
	}

	@Test
	public void compress(){
		assertThat(strings.compressBad("aabcccccaaa"), is("a2b1c5a3"));
		assertThat(strings.compress("aabcccccaaa"), is("a2b1c5a3"));
		assertThat(strings.compressBest("aabcccccaaa"), is("a2b1c5a3"));
	}

	/*@Test
	public void binarySearch(){
		int[] nums = new int[] {1,2,3,4,5};
		assertTrue(strings.binarySearch(nums, 4));
		assertFalse(strings.binarySearch(nums, 8));
		assertTrue(strings.binarySearch(nums, 1));
	}*/

	@Test
	public void rotate(){
		int[][] nums = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
		int[][] newNums = strings.rotateMatrix(nums);
		assertThat(newNums[0][0], is(7));
		assertThat(newNums[1][1], is(5));
		assertThat(newNums[2][2], is(3));
		System.out.println(Arrays.deepToString(newNums));
		int[][] newNums2 = strings.rotateMatrix2(nums);
		assertThat(newNums2[0][0], is(7));
		assertThat(newNums2[1][1], is(5));
		assertThat(newNums2[2][2], is(3));
	}

}