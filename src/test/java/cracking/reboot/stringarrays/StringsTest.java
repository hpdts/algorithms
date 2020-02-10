package cracking.reboot.stringarrays;

import org.junit.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import java.util.Arrays; 
import static cracking.reboot.stringarrays.Strings.CakeType;
import java.util.*;



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

	@Test
	public void mergeSort(){
   		int[] arr = {6,7,9,1};
		strings.sort(arr, 0 , arr.length - 1);
	}

	@Test
	public void rotation(){
 		String s1 = "waterbottle";
		String s2 = "terbottlewa";
		assertTrue(strings.isRotationEachOther(s1, s2));
		assertTrue(strings.isRotationEachOther2(s1, s2));
		assertTrue(strings.isRotationEachOther("dance", "cedan"));
		assertFalse(strings.isRotationEachOther("sun", "son"));
	}

	@Test
	public void merge(){
		int[] a = {1,4,7,8};
		int[] b = {5,6,8,9,20};

		int[] merge = strings.merge(a, b);
		System.out.println("merge: " + Arrays.toString(merge));

		int[] merge2 = strings.mergeArrays(a, b);
		System.out.println("merge2: " + Arrays.toString(merge2));

	}

	@Test
	public void firstComeFirstServed(){
		int[] takeOutOrders = {1, 3, 5};
		int[] dineInOrders = {2, 4, 6};
		int[] servedOrders = {1, 2, 3, 5, 4, 6};
		assertTrue(strings.isFirstComeFirstServed(takeOutOrders, dineInOrders, servedOrders));
		assertTrue(strings.isFirstComeFirstServedRecursive(takeOutOrders, dineInOrders, servedOrders));
			/*	 Take Out Orders: [1, 3, 5]
		 Dine In Orders: [2, 4, 6]
		  Served Orders: [1, 2, 3, 5, 4, 6] */		
	}
	@Test
	public void firstComeFirstServedNo(){
		int[] takeOutOrders = {1, 3, 5};
		int[] dineInOrders = {2, 4, 6};
		int[] servedOrders = {1, 2, 4, 6, 5, 3};
		assertFalse(strings.isFirstComeFirstServed(takeOutOrders, dineInOrders, servedOrders));		
	}

	@Test
	public void maxDuffelBagValue(){
		CakeType[] cakeTypes = new CakeType[] {
		    new CakeType(7, 160),
		    new CakeType(3, 90),
		    new CakeType(2, 15),
		};

		int capacity = 20;
		long max = strings.maxDuffelBagValue(cakeTypes, capacity);
		System.out.println("max: " + max);
		
	}

	@Test
	public void hasPalindromePermutation(){
		assertTrue(strings.hasPalindromePermutation("tata"));
		assertTrue(strings.hasPalindromePermutation("madam"));
		assertTrue(strings.hasPalindromePermutation("tattarrattat"));
		assertFalse(strings.hasPalindromePermutation("hou"));

		List<Integer> numbers = Arrays.asList(7, 8);
		System.out.println("index of 2 is " + Collections.binarySearch(numbers, 2));
		// index of 5 is 2
	}

	

}