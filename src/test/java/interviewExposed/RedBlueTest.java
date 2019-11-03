package interviewExposed;

import org.junit.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import java.util.*;
import java.util.stream.Collectors;

public class RedBlueTest {

	private RedBlue redBlue = new RedBlue();

	@Test
	public void isPattern(){
		int value = redBlue.isPattern("abba", "redbluebluered");
		assertThat(value, is(1));
		value = redBlue.isPattern("abcd", "thequickbrownfox");
		assertThat(value, is(1));
		value = redBlue.isPattern("abcd", "thequickbrownfoxred");
		assertThat(value, is(1));
		value = redBlue.isPattern("abcda", "redbluegreenfrered");
		assertThat(value, is(1));
		value = redBlue.isPattern("aab", "111111");
		assertThat(value, is(1));
	}

	@Test
	public void palindrome(){
		String str = "ababbbabbababa";
		System.out.println("palindrome str: " + str);
		int min = redBlue.minPalPartion(str);
		assertThat(min, is(3));
	}

	@Test
	public void palindrome2(){
		String str = "aab";
		System.out.println("palindrome str: " + str);
		int min = redBlue.minPalPartion(str);
		assertThat(min, is(1));
	}

	@Test
	public void palindrome3(){
		String str = "1234";
		System.out.println("palindrome str: " + str);
		int min = redBlue.minPalPartion(str);
		assertThat(min, is(3));
	}

	@Test
	public void allPermutations(){
		String str = "ABC";
		System.out.println("All permutations str: " + str);
		redBlue.permute(str, 0, str.length()-1);
	}

	@Test
	public void swap(){
		String str = "ABC";
		str = redBlue.swap(str, 0, 1);
		str = redBlue.swap(str, 0, 1);
		assertThat(str, is("ABC"));
	}

	@Test
	public void allPermutationsAB(){
		String str = "AB";
		System.out.println("All permutations str: " + str);
		redBlue.permute(str, 0, str.length()-1);
		System.out.println("-----------------------------");
	}

	@Test
	public void minCostPath(){
		System.out.println("-----------------------------");
		int[][] matrix = {{1,2,3},
						  {1,8,2},
						  {1,1,1}};
		System.out.println("min Cost Path " + Arrays.stream(matrix).map(Arrays::toString).collect(Collectors.joining(System.lineSeparator())));
		int min = redBlue.minCost(matrix);
		assertThat(min, is(5));
	}

	@Test
	public void minCostPath2(){
		System.out.println("-----------------------------");
		int[][] matrix = {{1,3,2},
						  {4,3,1},
						  {5,6,1}};
		System.out.println("min Cost Path 2 \n" + Arrays.stream(matrix).map(Arrays::toString).collect(Collectors.joining(System.lineSeparator())));

		int min = redBlue.minCost(matrix);
		assertThat(min, is(8));
	}

	@Test
	public void minCostPathDP(){
		System.out.println("-----------------------------");
		int[][] matrix = {{1,3,2},
						  {4,3,1},
						  {5,6,1}};
		System.out.println("min Cost Path DP\n" + Arrays.stream(matrix).map(Arrays::toString).collect(Collectors.joining(System.lineSeparator())));

		int min = redBlue.minPathSumDP(matrix);
		assertThat(min, is(8));
	}
}