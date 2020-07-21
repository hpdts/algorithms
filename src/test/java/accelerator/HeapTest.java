package accelerator;

import org.junit.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import java.util.*;

public class HeapTest {
	Heap heap = new Heap("min");

	@Test
    public void insert(){
    	heap.insert(9);
    	heap.insert(90);
    	heap.insert(3);
    	
    	assertThat(heap.removePeak(), is(3));
    }


}