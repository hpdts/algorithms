package euler;

import org.junit.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import java.util.*;


public class EulerTest {

	private Euler euler = new Euler();

	@Test
	public void fibonacci(){
		int fibonacci = euler.fibonnacci(0);
		assertThat(fibonacci, is(0));
		fibonacci = euler.fibonnacci(1);
		assertThat(fibonacci, is(1));
		fibonacci = euler.fibonnacci(2);
		assertThat(fibonacci, is(1));
		fibonacci = euler.fibonnacci(3);
		assertThat(fibonacci, is(2));
		fibonacci = euler.fibonnacci(4);
		assertThat(fibonacci, is(3));
		fibonacci = euler.fibonnacci(5);
		assertThat(fibonacci, is(5));
		fibonacci = euler.fibonnacci(6);
		assertThat(fibonacci, is(8));
		fibonacci = euler.fibonnacci(7);
		assertThat(fibonacci, is(13));
		//result less 4.000.000
		int result = euler.evenNumbersFibonacci();
		System.out.println("result: " + result);
	}

	@Test
	public void primeFactorization(){
		//Set<Integer> primefactors = new HashSet<>();
		Set primefactors = euler.primeFactors("600851475143");
		System.out.println("primefactors: " + primefactors.toString());
	}

	@Test
	public void palidrome(){
		//Set<Integer> primefactors = new HashSet<>();
		//List<Integer> palindromes = euler.threeDigitPalidrome();
		assertTrue(euler.isPalindrome("9009"));
		assertTrue(euler.isPalindrome("121"));
		System.out.println("3DigitPalidrome: " + euler.threeDigitPalidrome());
	}

	@Ignore
	@Test
	public void smallestDivisible(){
		System.out.println("smallestDivisible: " + euler.smallestDivisible());
	}

	@Test
	public void squares(){
		assertThat(euler.sumSquare(10), is(2640));
		//assertThat(euler.sumSquare(100), is(264055));
	}

	@Ignore
	@Test
	public void isPrime(){
		assertTrue(euler.isPrime(2));
		assertTrue(euler.isPrime(3));
		assertTrue(euler.isPrime(5));
		assertTrue(euler.isPrime(7));
		assertTrue(euler.isPrime(11));
		assertFalse(euler.isPrime(4));
		assertFalse(euler.isPrime(15));

		assertThat(euler.getNthPrime(6), is(13)); 
		assertThat(euler.getNthPrime(10001), is(104743)); 
	}

	@Test
	public void productSerie(){
		assertThat(euler.largestProductOnSeries(), is(23514624000L));
	}

	@Test
	public void pythagoreanTriplet(){
		//euler.pythagoreanTriplet();
	}
}