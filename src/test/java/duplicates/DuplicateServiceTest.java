package duplicates;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import com.google.common.collect.*;
import java.util.*;
import org.junit.*;


public class DuplicateServiceTest {
    private RemoveDuplicatesService removeDuplicatesService = new RemoveDuplicatesService();

    @Before
    public void setUp() {

    }

    @Test //input {1,2,3,3} output->{3}
    public void shouldGetOneDuplicates() {
        List<Integer> numbers = new ArrayList<Integer>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(3);

        
        List<Integer> result =  removeDuplicatesService.execute(numbers);

        assertThat(result.size(), is(1));
        assertThat(result.get(0).toString(), is("3"));

    }

    @Test //input {1,1,1,1,1} output->{1,1,1,1}
    public void shouldGetSeveralDuplicates() {
        List<Integer> numbers = new ArrayList<Integer>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(1);
        numbers.add(1);
        numbers.add(1);

        List<Integer> result =  removeDuplicatesService.execute(numbers);

        assertThat(result.size(), is(4));
        assertThat(result.get(0).toString(), is("1"));

    }

    @Test //input {1,2,-3,1,2,2,1} output->{1,2,2,1}
    public void shouldGetMultipleDuplicates() {
        List<Integer> numbers = new ArrayList<Integer>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(-3);
        numbers.add(1);
        numbers.add(2);
        numbers.add(2);
        numbers.add(1);

        List<Integer> result =  removeDuplicatesService.execute(numbers);

        assertThat(result.size(), is(4));
        assertThat(result.get(0).toString(), is("1"));

    }
  
    
} 
