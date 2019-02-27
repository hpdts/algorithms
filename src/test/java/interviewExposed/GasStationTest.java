package interviewExposed;

import org.junit.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import java.util.*;

public class GasStationTest {

	private GasStation gasStation = new GasStation();

	@Test
	public void gasStation1(){
		int[] gas = new int[]  {1,2,3,4,5};
		int[] cost = new int[] {3,4,5,1,2};

		int start = gasStation.minimumStartingPoint(gas, cost);
		assertThat(start, is(3));
	}

	@Test
	public void gasStation2(){
		int[] gas = new int[]  {2,3,4};
		int[] cost = new int[] {3,4,3};

		int start = gasStation.minimumStartingPoint(gas, cost);
		assertThat(start, is(-1));
	}

	@Test
	public void gasStation3(){
		int[] gas = new  int[] {1,2,3,4,5};
		int[] cost = new int[] {1,3,2,4,5};

		int start = gasStation.minimumStartingPoint(gas, cost);
		assertThat(start, is(2));
	}

	@Test
	public void gasStation4(){
		int[] gas = new int[]  {1,2};
		int[] cost = new int[] {2,1};

		int start = gasStation.minimumStartingPoint(gas, cost);
		assertThat(start, is(1));
	}
}