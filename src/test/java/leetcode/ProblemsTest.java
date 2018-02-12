package leetcode;

import org.junit.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import java.util.*;
import java.awt.Point;
import static leetcode.Problems.*;
import java.util.stream.*;


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

    @Test
    public void strStr(){
        String text = "text hey this is my town dont come any closer";
        assertThat(problem.strStr(text, "any"), is(35));
        
    }

    @Test
    public void boardWinner(){
        String winners = "Michael,Michael,Michael,Michael,Tom,Tom,John,Paul,John,Sam,Anna,Tom";
        problem.getWinnersBoard(winners);
    }

    @Test
    public void longestConsecutive(){
        int[] numbers = new int[] {100, 4, 200, 1, 3, 2};
        int longest = problem.longestConsecutive(numbers);
        assertThat(longest, is(4));
    }

    @Test
    public void arrayRotation(){
        int[] numbers = new int[] {100, 4, 200, 1, 3, 2};
        int pivotalIndex = 5;
        int[] numbersRotatedExpected = new int[] {2, 100, 4, 200, 1, 3};
        int[] rotated = problem.rotate(numbers, pivotalIndex);


        assertTrue(Arrays.equals(rotated, numbersRotatedExpected));

        numbers = new int[] {100, 4, 200, 1, 3, 2};
        pivotalIndex = 3;
        numbersRotatedExpected = new int[] {1, 3, 2, 100, 4, 200 };
        rotated = problem.rotate(numbers, pivotalIndex);

        System.out.println("rotated: " + Arrays.toString(rotated));
        assertTrue(Arrays.equals(rotated, numbersRotatedExpected));
    }

    @Test
    public void isPalindrome(){
       // assertTrue(problem.isPalindrome("Red rum, sir, is murder"));
        assertTrue(problem.isPalindromeStack("Red rum, sir, is murder"));
        assertTrue(problem.isValidPalindromePointers("Red rum, sir, is murder"));
        //assertFalse(problem.isPalindrome("Programcreek is awesome"));
    }

    @Test
    public void getConsecutiveNumber(){
        int[] numbers = {1, 2, 3, 4, 6};
        int[] numbers2 = {1, 2, 3, 4, 5};
        assertThat(problem.isAConsecutiveMissing(numbers), is(5));
        assertNull(problem.isAConsecutiveMissing(numbers2));
        assertThat(problem.isAConsecutiveMissingBinarySearch(numbers), is(5));
        assertThat(problem.isAConsecutiveMissingSum(numbers), is(5));
    }

    @Test
    public void zigZag(){
        assertThat(problem.zigZagConversion("PAYPALISHIRING", 3), is("PAHNAPLSIIGYIR"));
    }

    @Test
    public void arithmeticExpression(){
        assertTrue("+", problem.isOperand('+'));
        assertTrue("-", problem.isOperand('-'));
        assertTrue("/", problem.isOperand('/'));
        assertTrue("*", problem.isOperand('*'));
        assertFalse("%", problem.isOperand('%'));

        assertThat("adition", problem.applyOperand('+', 2, 3), is(5));
        assertThat("substraction", problem.applyOperand('-', 3, 2), is(1));
        assertThat("division", problem.applyOperand('/', 2, 2), is(1));
        assertThat("multiplication", problem.applyOperand('*', 2, 3), is(6));
        assertThat("module", problem.applyOperand('%', 1, 1), is(0));

        assertThat("5+4-2*7/7", problem.solveArithmeticExpression("5+4-2*7/7"), is(7));
        assertThat("5+4-2", problem.solveArithmeticExpression("5+4-2"), is(7));
        assertThat("5+4", problem.solveArithmeticExpression("5+4"), is(9));
    }

    @Test
    public void addBinary(){
        assertThat(problem.addBinary("10", "10"), is("100"));
    }

    @Test
    public void addBinary2(){
        assertThat(problem.addBinary2("10", "10"), is("100"));
    }

    @Test
    public void lengthString(){
        assertThat(problem.lengthOfLastWord("every day I play the blues"), is(5));
    }

    @Test
    public void minimumTotal(){
        ArrayList<Integer> row1 = new ArrayList<>();
        row1.add(2);

        ArrayList<Integer> row2 = new ArrayList<>();
        row2.add(3);
        row2.add(4);

        ArrayList<Integer> row3 = new ArrayList<>();
        row3.add(6);
        row3.add(5);
        row3.add(7);

        ArrayList<Integer> row4 = new ArrayList<>();
        row4.add(4);
        row4.add(1);
        row4.add(8);
        row4.add(3);

        ArrayList<ArrayList<Integer>> triangle = new ArrayList<ArrayList<Integer>>();  
        triangle.add(row1);
        triangle.add(row2);
        triangle.add(row3);
        triangle.add(row4);

        assertThat(problem.minimumTotal(triangle), is(11));
    }

    @Test
    public void duplicatesI(){
        int[] numbers = new int[] {1, 2, 3, 4, 5, 6 };
        int[] numbersDuplication = new int[] {1, 2, 3, 4, 5, 6, 1};

        assertFalse(problem.isThereDuplicatesI(numbers));
        assertTrue(problem.isThereDuplicatesI(numbersDuplication));
    }

    @Test
    public void duplicatesII(){
        int[] numbersDuplication = new int[] {1, 2, 3, 4, 5, 6, 1};

        assertTrue(problem.isThereDuplicatesII(numbersDuplication, 8));
        assertTrue(problem.containsNearbyDuplicate(numbersDuplication, 8));
        assertTrue(problem.containsNearbyDuplicateI(numbersDuplication, 8));
        assertFalse(problem.isThereDuplicatesII(numbersDuplication, 3));
    }

    @Test
    public void duplicatesIII(){
        int[] numbersDuplication = new int[] {1, 2, 3, 4, 5, 6, 1};

        assertTrue(problem.containsNearbyAlmostDuplicate(numbersDuplication, 3, 8));
    }

    @Test
    public void removeDuplicates(){
        int[] numbersDuplication = new int[] { 1, 2, 2, 3, 3 };

        System.out.println("uniques: " + Arrays.toString(problem.removeDuplicatesSortedArray(numbersDuplication)));
    }

    @Test
    public void removeDuplicatesIII(){
        int[] numbersDuplication = new int[] { 1, 1, 1, 2, 2, 3, 3 };
        int result = problem.removeDuplicatesIII(numbersDuplication);

        System.out.println("uniques new: " + Arrays.toString(numbersDuplication));
    }

    @Test
    public void removeDuplicatesIV(){
        int[] numbersDuplication = new int[] { 1, 1, 1, 2, 2, 3, 3 };
        int result = problem.removeDuplicatesIV(numbersDuplication);

        System.out.println("uniques IV: " + Arrays.toString(numbersDuplication));
    }

    @Test
    public void removeElement(){
        int[] numbers = new int[] { 1, 1, 1, 2, 2, 3, 3 };
        int newIndex = problem.removeElement(numbers, 1);
        assertThat(newIndex, is(4));

        System.out.println("removeElement: " + Arrays.toString(numbers));
    }

    @Test
    public void moveZeroes(){
        int[] numbers = new int[] { 0, 0, 1, 0, 3, 12 };
        problem.moveZeroes(numbers);

        System.out.println("moveZeroes: " + Arrays.toString(numbers));

        numbers = new int[] { 0, 1, 1, 0, 3, 12 };
        problem.moveZeroesII(numbers);

        System.out.println("moveZeroesII: " + Arrays.toString(numbers));
    }

    @Test
    public void lengthOfLongestSubstring(){
        String word = "abcabcbb";
        
        assertThat(problem.lengthOfLongestSubstring(word), is(3));
        assertThat(problem.lengthOfLongestSubstringI(word), is(3));
    }

    @Test
    public void lengthOfLongestSubstringTwoDistinct(){
        String word = "abcbbbbcccbdddadacb";
        
        assertThat(problem.lengthOfLongestSubstringTwoDistinct(word), is(10));
    }

    @Test
    public void findSubstring(){
        String word = "barfoothefoobarman";
        String[] words = new String[]{"foo", "bar"};
        
        List<Integer> solutions = problem.findSubstring(word, words);
        assertThat(solutions.get(0), is(0));
    }

    @Test
    public void minWindow(){
        String word = "ADOBECODEBANC";
        String t = "BANC";
        
        assertThat(problem.minWindow(word, t), is("BANC"));
    }  

    //QUESTION FB 1-5-2016
    //https://www.geeksforgeeks.org/find-the-smallest-window-in-a-string-containing-all-characters-of-another-string/
    @Test
    public void shortest(){
                       //012345    
        String input = "aaccbc";//0,2;0,3;0,4;0,5
                                //1,3;1,4;1,5
                                //2,4;2,5
                                //3,5
        String alphabet = "abc";//output accb
       
        //assertThat(problem.findShortest(input, alphabet), is("accb"));

        String str = "aaaabbbbbcabbbbcabbccccc";
        //Brute force solution quadratic
        //assertThat(problem.findShortest(str, alphabet), is("bca"));
        //assertThat(problem.getMinSubstring(alphabet, str), is("bca"));
        assertThat(problem.findSubString(str, alphabet), is("bca"));


        /*input = "geeksforgeeks";
        alphabet = "ork";
        assertThat(problem.findSubString(input, alphabet), is("ksfor"));*/
    }  

    @Test
    public void findSubstringII(){
        String[] words = {"foo", "bar"};
        List<Integer> indices = problem.findSubstringII("barfoothefoobarman", words);
        System.out.println("indices: " + indices);
    }

    @Test
    public void findMin(){
        int[] numbers = {4,5,6,7,0,1,2};
        assertThat(problem.findMin(numbers), is(0));
    }

    @Test
    public void findMinDuplicates(){
        int[] numbers = {4, 5, 5, 6, 7, 7, 0, 1, 2};
        assertThat(problem.findMinWithDuplicates(numbers), is(0));
    }


    
}