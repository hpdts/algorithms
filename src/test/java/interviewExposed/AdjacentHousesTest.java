package interviewExposed;

import org.junit.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import java.util.*;

public class AdjacentHousesTest {

	private AdjacentHouses adjacentHouses = new AdjacentHouses();

	@Test
	public void adjacentHousesLegal1(){
		int days = 1;
		int[] states = new int[]{1,0,0,0,0,1,0,0};
		//System.out.println("first State: " + Arrays.toString(states));
		List<Integer> newStates = adjacentHouses.cellCompetes(states, days);
		//System.out.println("newStates: " + newStates.toString());

		assertThat(newStates.get(0), is(0));
		assertThat(newStates.get(1), is(1));
		assertThat(newStates.get(2), is(0));
		assertThat(newStates.get(3), is(0));
		assertThat(newStates.get(4), is(1));
		assertThat(newStates.get(5), is(0));
		assertThat(newStates.get(6), is(1));
		assertThat(newStates.get(7), is(0));
	}

	@Test
	public void adjacentHousesLegal2(){
		int days = 2;
		int[] states = new int[]{1,1,1,0,1,1,1,1};
		//System.out.println("first State: " + Arrays.toString(states));
		List<Integer> newStates = adjacentHouses.cellCompetes(states, days);
		//System.out.println("newStates: " + newStates.toString());

		assertThat(newStates.get(0), is(0));
		assertThat(newStates.get(1), is(0));
		assertThat(newStates.get(2), is(0));
		assertThat(newStates.get(3), is(0));
		assertThat(newStates.get(4), is(0));
		assertThat(newStates.get(5), is(1));
		assertThat(newStates.get(6), is(1));
		assertThat(newStates.get(7), is(0));
	}

	@Test
	public void adjacentHousesOneElement(){
		int days = 1;
		int[] states = new int[]{1};
		List<Integer> newStates = adjacentHouses.cellCompetes(states, days);

		assertThat(newStates.get(0), is(0));
	}

}