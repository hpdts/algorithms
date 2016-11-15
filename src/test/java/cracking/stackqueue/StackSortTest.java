package cracking.stackqueue;

import org.junit.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import java.util.*;


public class StackSortTest {

        private StackSort stackSort = new StackSort();


        @Test
        public void sorting(){
        	 Stack<Integer> input = new Stack<Integer>();
                input.add(34);
                input.add(3);
                input.add(31);
                input.add(98);
                input.add(92);
                input.add(23);
                Stack<Integer> output = stackSort.sortStack(input);
                System.out.println("input: "+input);
                System.out.println("final sorted list: " + output);
                assertThat(output.pop(), is(98));
                assertThat(output.pop(), is(92));
        	assertThat(output.pop(), is(34));
        }

        @Test
        public void sortingBook(){
                 Stack<Integer> input = new Stack<Integer>();
                input.add(34);
                input.add(3);
                input.add(31);
                input.add(98);
                input.add(92);
                input.add(23);
                Stack<Integer> output = stackSort.sort(input);
                System.out.println("input: "+input);
                System.out.println("final sorted list: " + output);
                assertThat(output.pop(), is(98));
                assertThat(output.pop(), is(92));
                assertThat(output.pop(), is(34));
        }

}