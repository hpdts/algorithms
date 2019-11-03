package interviewExposed;

import org.junit.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import java.util.*;

public class MaxProfitTest {

	private MaxProfit maxProfit = new MaxProfit();

	@Test
	@Ignore
	public void maxProfit(){
		int[] prices = {1, 2, 3};
		System.out.println("prices: " + Arrays.toString(prices));
		int profit = maxProfit.maxProfit(prices);
		assertThat(profit, is(2));
	}

	@Test
	public void maxProfit2(){
		int[] prices = {1, 2, 3};
		System.out.println("prices: " + Arrays.toString(prices));
		int profit = maxProfit.maxProfit2(prices);
		assertThat(profit, is(2));
	}


	@Test
	public void maxProfit21(){
		int[] prices = {7,1,5,3,6,4};
		System.out.println("prices: " + Arrays.toString(prices));
		int profit = maxProfit.maxProfit2(prices);
		assertThat(profit, is(7));
	}

	@Test
	public void maxProfit3(){
		int[] prices = {1, 7, 2, 3, 6, 7, 6, 7};
		System.out.println("prices: " + Arrays.toString(prices));
		int profit = maxProfit.maxProfit3(prices);
		assertThat(profit, is(12));
	}

	
	


}