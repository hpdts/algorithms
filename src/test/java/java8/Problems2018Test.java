package java8;

import java.util.*;
import org.junit.*;
import static java8.Java8.*;
import static org.junit.Assert.*;
import static java8.Problems2018.*;
import static org.hamcrest.Matchers.*;


public class Problems2018Test {

	private Problems2018 problems2018 = new Problems2018();

    @Test
	public void intervalsOverlap(){
		//Given [1,3],[2,6],[8,10],[15,18],
		//return [1,6],[8,10],[15,18].

		Interval one = new Interval(1, 6);
		Interval oneMore = new Interval(1, 6);
		Interval two = new   Interval(2, 3);
		Interval three = new Interval(8, 10);
		Interval four = new  Interval(15, 18);

		List<Interval> intervals = new ArrayList<>();
		intervals.add(one);
		intervals.add(oneMore);
		intervals.add(two);
		intervals.add(three);
		intervals.add(four);

		List<Interval> merged = problems2018.mergeIntervals(intervals);
		assertThat(merged.size(), is(3));

	}

	@Test
	public void findLargestNumber(){
		int[] numbers =  new int[]{3, 30, 34, 5, 9};
		String largeNumber = problems2018.formLargestNumber(numbers);
		assertThat(largeNumber, is("9534330"));
		                          //9534303
	}

}