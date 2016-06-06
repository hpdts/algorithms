package twoSum;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import java.util.*;
import org.junit.*;

public class TwoSumTest {
    private TwoSum twoSum;

	@Before
    public void setUp() {
        twoSum = new TwoSum();
    }

 
    @Test
    public void shouldGetTwoSum(){
        int[] numbers = { 2, 7, 11, 15 };

        int[] indexes = twoSum.getTwoSumIndexes(numbers, 9);

        assertThat(indexes[0], is(1));
        assertThat(indexes[1], is(2));
    }

    
} 
