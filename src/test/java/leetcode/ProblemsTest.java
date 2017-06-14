package leetcode;

import org.junit.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import java.util.*;
import java.awt.Point;
import static leetcode.Problems.*;


public class ProblemsTest {

	Problems problem = new Problems();

	@Test
    public void addition(){

    	String start = "hit";
		String end = "cog";
		String[] dictArray = new String[] {"hot","dot","dog","lot","log"};
        System.out.println("dictArray: " + dictArray); 
		Set<String> dict = new HashSet<>(Arrays.asList(dictArray));
        System.out.println("dict: " + dict); 

    	assertThat(problem.ladderLength(start, end, dict), is(5));
    }

    @Test
    public void sortTwoArrays(){
    	int[] a = new int[] {1,8};
    	int[] b = new int[] {2,6};

    	int[] c = problem.mergeTwoSortedArrays(a, b);
    	System.out.println("c: " + Arrays.toString(c));
    	int[] d = new int[] {1,2,6,8};
    	assertTrue(Arrays.equals(c, d));
    }

    @Test
    public void keyboard(){
    	assertThat(problem.keyboard(5, "ace"), is("!RR!RRRR!"));
    	assertThat(problem.keyboard(5, "gio"), is("DR!DRRR!DDRRRR!"));
    	/*abcde
    	  fghij
    	  klmno
    	  p*/ 
    }

    @Test
    public void regExp(){
    	/* Quantifiers
    	? Question mark -> Zero or more occurrences of the preceding element
    	. Asterisk -> Zero or more occurrences of the preceding element
    	Wildcard pattern
    	colou?r matches color or colour
		ab*c matches ac,abbc,abbbbc
		u? matches "", u not matches a
		u?u? matches "", u, uu not matches a
		au? matches a,au not matches u
		*/
        assertTrue(problem.processPattern("u?").size() == 1);
        assertTrue(problem.processPattern("b?b?").size() == 2);
        assertTrue(problem.processPattern("b?b?j?j?v?v?").size() == 6);
        assertTrue(problem.processPattern("au?").size() == 2);
        assertTrue(problem.processPattern("b?b?adf").size() == 5);

		assertTrue(problem.isMatch("uuuuuua","u*a"));
		assertFalse(problem.isMatch("a","u?"));

		assertTrue(problem.matches("","u?"));
		assertTrue(problem.matches("u","u?"));
		assertFalse(problem.matches("a","u?"));

		assertTrue(problem.matches("","u?u?"));
		assertTrue(problem.matches("u","u?u?"));
		assertTrue(problem.matches("uu","u?u?"));
		assertFalse(problem.matches("a","u?u?"));

		assertTrue(problem.matches("a","au?"));
		assertTrue(problem.matches("au","au?"));
		assertFalse(problem.matches("u","au?"));
    }

    @Test
    public void pow(){
        assertThat(problem.powerOfIterative(5, 3), is(125.0));
        //assertThat(problem.pow(5L, 3L), is(125L));
        assertThat(problem.pow(2L, 4L), is(16L));
        assertThat(problem.powerOfIterative(5, -3), is(0.008000000000000002));
    }

    @Test
    public void uniqueCharacters(){
        assertTrue(problem.isUniqueCharacters("key"));
        assertFalse(problem.isUniqueCharacters("thekey"));
        assertTrue(problem.isUniqueChars("key"));
        assertFalse(problem.isUniqueChars("thekey"));
    }

    @Test
    public void mergeIntervals(){
        List<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(1,3));
        intervals.add(new Interval(2,6));
        intervals.add(new Interval(8,10));
        intervals.add(new Interval(15,18));

        List<Interval> newInterval = problem.mergeIntervals(intervals);
        System.out.println("newInterval: " + newInterval);
        assertThat(newInterval.size(), is(3));
    }

    @Test
    public void newIntervals(){
        List<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(1,3));
        intervals.add(new Interval(6,9));

        Interval newInterval = new Interval(2, 5);
        List<Interval> newIntervals = problem.insert(intervals, newInterval);
        System.out.println("newInterval: " + newIntervals);
        assertThat(newIntervals.size(), is(2));
    }

    @Test
    public void fibonacci(){
        //0 1 1 2 3 5 8 13 21 34
        assertThat(problem.fibonacci(0), is(0));
        assertThat(problem.fibonacci(1), is(1));
        assertThat(problem.fibonacci(2), is(1));
        assertThat(problem.fibonacci(3), is(2));
        assertThat(problem.fibonacci(4), is(3));
        assertThat(problem.fibonacci(5), is(5));

        assertThat(problem.fibonacciIterative(0), is(0));
        assertThat(problem.fibonacciIterative(1), is(1));
        assertThat(problem.fibonacciIterative(2), is(1));
        assertThat(problem.fibonacciIterative(3), is(2));
        assertThat(problem.fibonacciIterative(4), is(3));
        assertThat(problem.fibonacciIterative(5), is(5));
        
        assertThat(problem.findFibonacciValue(10), is(55));
    }

    @Test
    public void getLetterCount(){
        assertTrue(problem.areAnagrams("aree","eare"));
    }

    @Test
    public void getAddTwoNumbersList(){
        List<Integer> num1 = new ArrayList<>();
        List<Integer> num2 = new ArrayList<>();
        
        num1.add(3);
        num1.add(5);
        num1.add(9);
        
        num2.add(6);
        num2.add(6);
        num2.add(8);

        List<Integer> result = problem.addTwoNumbersList(num1, num2);
        System.out.println("result: " + result.toString());
    }

    @Test
    public void twoSumUp(){
        int[] numbers = new int[] {1,2,3,4,5,6};
        int target = 9;
        problem.twoSumUp(numbers, target);

        int[] indexs = problem.twoSum(numbers, target);
        assertThat(indexs[0], is(3));
        assertThat(indexs[1], is(4));

        indexs = problem.twoSumOrder(numbers, target);
        assertThat(indexs[0], is(2));
        assertThat(indexs[1], is(5));

        List<List<Integer>> result = problem.threeSum(new int[] {-1,0,1,2,-1,-4});
        System.out.println("result: " + result);
    }

    @Test
    public void primeNumbers(){
        problem.getPrimeNumbers(100);
        problem.getPrimeSieve(100);
    }

    @Test
    public void threeSumClosest(){
        int[] numbers = new int[] {3,5,1,4,2,6};
        int target = 6;
        assertThat(problem.threeSumClosest(numbers, target), is(6));
    }

    @Test
    public void atoi(){
        assertThat(problem.atoi("100"), is(100));
    }

    @Test
    public void merge(){
        int a[] = new int[] {  0, 0, 0, 0, 1, 3, 5, 7 };
        int b[] = new int[] { 2, 4, 6, 8 };
        //problem.merge(a, b);
        //System.out.println("array merge: " + Arrays.toString(a));
        //problem.merge2(a, b);
        //System.out.println("array merge: " + Arrays.toString(a));
    }

    @Test
    public void parenthesis(){
        assertTrue(problem.isValid("{()}"));
    }

    @Test
    public void spiralOrder(){
        int[][] matrix = new int[][]{ {1,  2,  3,  4,  5,  6},
                             {7,  8,  9,  10, 11, 12},
                             {13, 14, 15, 16, 17, 18}
                           };
        System.out.println("Spiral : ");
        problem.spiralOrder(matrix);
    }

    @Test
    public void fixWidth(){
        String text = "text hey this is my town dont come any closer";
        String[] wordsByLength10 = problem.wordsFixWidth(text);
        assertThat(wordsByLength10[0], is("text hey"));
        assertThat(wordsByLength10[1], is("this is my"));
        assertThat(wordsByLength10[2], is("town dont"));
    }

    @Test
    public void longestParenthese(){
        String text = "(()";
        assertThat(problem.longestValidParentheses(text), is(2));
    }
 
 
}