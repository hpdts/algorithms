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
		Set<String> dict = new HashSet<>(Arrays.asList(dictArray));

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

}