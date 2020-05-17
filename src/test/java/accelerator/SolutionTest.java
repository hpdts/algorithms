package accelerator;

import org.junit.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import java.util.*;

public class SolutionTest {
	Solution sol = new Solution();

	@Test
    public void student(){
    	 String[][]  studentCoursePairs1 = {
        {"58", "Linear Algebra"},
        {"94", "Art History"},
        {"94", "Operating Systems"},
        {"17", "Software Design"},
        {"58", "Mechanics"},
        {"58", "Economics"},
        {"17", "Linear Algebra"},
        {"17", "Political Science"},
        {"94", "Economics"},
        {"25", "Economics"},
        {"58", "Software Design"}
      };
    	HashMap<String, List<String>> out = sol.sol(studentCoursePairs1);
    	assertThat(out.get("58, 17").toString(), is("[Software Design, Linear Algebra]"));
    }

    @Test
    @Ignore
    public void student2(){
		String[][] studentCoursePairs2 = {
        {"42", "Software Design"},
        {"0", "Advanced Mechanics"},
        {"9", "Art History"},
      };
    	HashMap<String, List<String>> out = sol.sol(studentCoursePairs2);
    	assertThat(out.get("9, 42").toString(), is("[]"));
    }

    /*@Test
    public void read4(){
		String text = "42 Software Design Advanced Mechanics Art History";
    	int left = sol.read(text);
    	assertThat(left, is(3));
    }*/
    

}