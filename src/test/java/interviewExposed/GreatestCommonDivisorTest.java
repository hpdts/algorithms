package interviewExposed;

import org.junit.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class GreatestCommonDivisorTest {

	GreatestCommonDivisor greatestCommonDivisor = new GreatestCommonDivisor();

	@Test
	public void greatestCommonDivisor(){
		int num = 5;
		int[] arr = new int[]{2,4,6,8,10};

		int gcd = greatestCommonDivisor.findGCD(num, arr);
		assertThat(gcd, is(2));
	}

	@Test
	public void greatestCommonDivisor2(){
		int num = 5;
		int[] arr = new int[]{8,10,2,4,6};

		int gcd = greatestCommonDivisor.findGCD(num, arr);
		assertThat(gcd, is(2));
	}

	@Test
	public void greatestCommonDivisorOdd(){
		int[] arr = new int[]{3,2,5};

		int gcd = greatestCommonDivisor.findGCD(arr.length, arr);
		assertThat(gcd, is(1));
	}

	@Test
	public void greatestCommonDivisorDuplicated(){
		int[] arr = new int[]{10,10,10};

		int gcd = greatestCommonDivisor.findGCD(arr.length, arr);
		assertThat(gcd, is(10));
	}

	@Test
	public void greatestCommonDivisorBigNumbers(){
		int[] arr = new int[]{10,1000};

		int gcd = greatestCommonDivisor.findGCD(arr.length, arr);
		assertThat(gcd, is(10));
	}

	@Test
	public void greatestCommonDivisorBigNumbers2(){
		int[] arr = new int[]{1000,10000};

		int gcd = greatestCommonDivisor.findGCD(arr.length, arr);
		assertThat(gcd, is(1000));
	}

	@Test
	public void greatestCommonDivisor3(){
		int num = 1;
		int[] arr = new int[]{8};

		int gcd = greatestCommonDivisor.findGCD(num, arr);
		assertThat(gcd, is(8));
	}

	@Test(expected = RuntimeException.class)
	public void greatestCommonDivisor4(){
		int num = 0;
		int[] arr = new int[]{8};
		int gcd = greatestCommonDivisor.findGCD(num, arr);
	}

	

	@Test
	public void greatestCommonDivisor2Numbers(){
		int gcd = greatestCommonDivisor.findGCD2Numbers(2, 4);
		assertThat(gcd, is(2));
		gcd = greatestCommonDivisor.findGCD2Numbers(4, 2);
		assertThat(gcd, is(2));

		int[] arr = new int[]{8,10,2,4,6};
		gcd = greatestCommonDivisor.findGCDNumbers(arr);
		assertThat(gcd, is(2));
	}
}