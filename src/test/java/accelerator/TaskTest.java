package accelerator;

import org.junit.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import java.util.*;
import static accelerator.CourseSF.*;

public class TaskTest {
	Task task = new Task();

	@Test
    public void avg1(){
    	/*foo start 100
foo end 120
bar start 125
bar end 130
foo start 130
foo end 160*/
    	List<String> methods = new ArrayList<>(Arrays.asList("foo start 100", "foo end 120",
    		"bar start 125","bar end 130","foo start 130","foo end 160"));
    	task.getAverageTimesTasks(methods);
    }

    /**
foo start 100
bar start 110
bar end 115
foo end 120

    **/
	@Test
    public void avg2(){
    	/*foo start 100
bar start 110
bar end 115
foo end 120
*/
System.out.println("AVG2");
    	List<String> methods = new ArrayList<>(Arrays.asList("foo start 100",
    		"bar start 110","bar end 115","foo end 120"));
    	task.getAverageTimesTasks(methods);
    }

    /*foo start 100
bar start 110
 fuzz start 111
 fuzz end 113
bar end 115
foo end 120
*/
	@Test
    public void avg3(){
    	System.out.println("AVG3");
    	List<String> methods = new ArrayList<>(Arrays.asList("foo start 100",
    		"bar start 110","fuzz start 111","fuzz end 113","bar end 115","foo end 120"));
    	task.getAverageTimesTasks(methods);
    }

    /**
    foo start 100
foo start 105
foo start 100
foo start 105
bar start 110
bar end 115
>foo end 120
foo end 120
foo end 120
foo end 120
**/

	@Test
    public void avg4(){
    	System.out.println("AVG4");
    	List<String> methods = new ArrayList<>(Arrays.asList(
    		"foo start 100",
    		"foo start 105",
    		"foo start 110",
    		"bar start 110",
    		"bar end 115",
    		"foo end 120",
    		"foo end 120",
    		"foo end 120"));
    	task.getAverageTimesTasks(methods);
    }
}