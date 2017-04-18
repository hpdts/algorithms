package leetcode;

import org.junit.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import java.util.*;
import java.awt.Point;


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

}