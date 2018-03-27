package java8;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import com.google.common.collect.*;
import java.util.*;
import org.junit.*;
import static java8.Java8.*;
import static org.junit.Assert.*;
import javafx.util.Pair;


public class PairIteratorTest {
	
	//Go 3-2-2018 Phone Interview
    @Test
    public void iterators(){
        List<String> original = new ArrayList<>();
        original.add("foo");
        original.add("foo");
        original.add("foo");
        original.add("bar");
        original.add("bar");
        original.add("abc");
        original.add("abc");

        Iterator<String> iterator = original.iterator();

        PairIterator pairIterator = new PairIterator(iterator);

        while(pairIterator.hasNext()){
        	Pair<String, Integer> pair = pairIterator.next();
        	System.out.println("pair: " + pair);
        }


    }



}