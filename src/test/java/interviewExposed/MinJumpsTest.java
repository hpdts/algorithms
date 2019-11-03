package interviewExposed;

import org.junit.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import java.util.*;

public class MinJumpsTest {
	private MinJumps minJumps = new MinJumps();

	@Test
	public void minJumps(){
		System.out.println("here");
		int[] arr = {1, 3, 6, 3, 2, 3, 6, 8, 9, 5};
		int jumps = minJumps.minJumps(arr);
		assertThat(jumps, is(4));
	}

	@Test
	public void minJumpsDP(){
		System.out.println("DP");
		int[] arr = {1, 3, 6, 3, 2, 3, 6, 8, 9, 5};
		System.out.println("array: " + Arrays.toString(arr));
		int jumps = minJumps.minJumpsDP(arr, arr.length);
		assertThat(jumps, is(4));
	}

	@Test
	public void fibonacci(){
		assertThat(minJumps.fibonacci(1), is(1));
		assertThat(minJumps.fibonacci(2), is(1));
		assertThat(minJumps.fibonacci(3), is(2));
		assertThat(minJumps.fibonacci(4), is(3));
		assertThat(minJumps.fibonacci(5), is(5));
		assertThat(minJumps.fibonacci(6), is(8));
	}

	@Test
	public void climbStairs(){
		assertThat(minJumps.climbStairs(1), is(1));
		assertThat(minJumps.climbStairs(2), is(2));
		assertThat(minJumps.climbStairs(3), is(3));
		assertThat(minJumps.climbStairs(4), is(5));
		assertThat(minJumps.climbStairs(5), is(8));
		assertThat(minJumps.climbStairs(6), is(13));
		assertThat(minJumps.climbStairs(7), is(21));
	}

	@Test
	public void fibonacciWrapper(){
		assertThat(minJumps.fibonacciWrapper(1), is(1));
		assertThat(minJumps.fibonacciWrapper(2), is(1));
		assertThat(minJumps.fibonacciWrapper(3), is(2));
		assertThat(minJumps.fibonacciWrapper(4), is(3));
		assertThat(minJumps.fibonacciWrapper(5), is(5));
		assertThat(minJumps.fibonacciWrapper(6), is(8));
		assertThat(minJumps.fibonacciWrapper(20), is(6765));
	}

}