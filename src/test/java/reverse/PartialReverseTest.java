package reverse;

import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import java.util.*;

public class PartialReverseTest {
    private PartialReverse partialReverse = new PartialReverse();

    @Test
    public void doPartialReverse() {

        Integer[] numbers = new Integer[6];
        numbers[0] = 0;   
        numbers[1] = 1;   
        numbers[2] = 2;    
        numbers[3] = 3;    
        numbers[4] = 4;    
        numbers[5] = 5;    
        
        partialReverse.execute(numbers, 1, 3);
        assertThat(Arrays.toString(numbers), is("[0, 3, 2, 1, 4, 5]"));
    }

    
} 
