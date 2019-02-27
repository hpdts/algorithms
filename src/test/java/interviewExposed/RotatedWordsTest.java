package interviewExposed;

import org.junit.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import java.util.*;

public class RotatedWordsTest {

	public RotatedWords rotatedWords = new RotatedWords();

	@Test
	public void rotatedWords(){
		assertTrue(rotatedWords.isSameReflection("sample", "plesam"));
	}

	@Test
	public void rotatedWords2(){
		assertTrue(rotatedWords.isSameReflection("abc", "cab"));
	}

	@Test
	public void rotatedWords3(){
		assertFalse(rotatedWords.isSameReflection("ab", "aa"));
	}

	@Test
	public void closestXdestinations1(){

		int numDestinations = 3;
		 List<List<Integer>> allLocations = new ArrayList<List<Integer>>();
		 List<Integer> coordenate1 = new ArrayList<>();
		 coordenate1.add(1);
		 coordenate1.add(2);

		 List<Integer> coordenate2 = new ArrayList<>();
		 coordenate2.add(3);
		 coordenate2.add(4);

		 List<Integer> coordenate3 = new ArrayList<>();
		 coordenate3.add(1);
		 coordenate3.add(-1);

		 allLocations.add(coordenate1);
		 allLocations.add(coordenate2);
		 allLocations.add(coordenate3);

		int numDeliveries = 2;
		List<List<Integer>> closeLocations = rotatedWords.ClosestXdestinations(numDestinations, allLocations, numDeliveries);
		

		assertThat(closeLocations.get(0).get(0), is(1));
		assertThat(closeLocations.get(0).get(1), is(-1));
	}

	@Test
	public void closestXdestinations2(){

		int numDestinations = 3;
		 List<List<Integer>> allLocations = new ArrayList<List<Integer>>();
		 List<Integer> coordenate1 = new ArrayList<>();
		 coordenate1.add(1);
		 coordenate1.add(-3);

		 List<Integer> coordenate2 = new ArrayList<>();
		 coordenate2.add(1);
		 coordenate2.add(2);

		 List<Integer> coordenate3 = new ArrayList<>();
		 coordenate3.add(3);
		 coordenate3.add(4);

		 allLocations.add(coordenate1);
		 allLocations.add(coordenate2);
		 allLocations.add(coordenate3);

		int numDeliveries = 1;
		List<List<Integer>> closeLocations = rotatedWords.ClosestXdestinations(numDestinations, allLocations, numDeliveries);
		

		assertThat(closeLocations.get(0).get(0), is(1));
		assertThat(closeLocations.get(0).get(1), is(2));
	}

	@Test
	public void closestXdestinations3(){

		int numDestinations = 6;
		 List<List<Integer>> allLocations = new ArrayList<List<Integer>>();
		 List<Integer> coordenate1 = new ArrayList<>();
		 coordenate1.add(3);
		 coordenate1.add(6);

		 List<Integer> coordenate2 = new ArrayList<>();
		 coordenate2.add(2);
		 coordenate2.add(4);

		 List<Integer> coordenate3 = new ArrayList<>();
		 coordenate3.add(5);
		 coordenate3.add(3);

		 List<Integer> coordenate4 = new ArrayList<>();
		 coordenate4.add(2);
		 coordenate4.add(7);

		 List<Integer> coordenate5 = new ArrayList<>();
		 coordenate5.add(1);
		 coordenate5.add(8);

		 List<Integer> coordenate6 = new ArrayList<>();
		 coordenate6.add(7);
		 coordenate6.add(9);

		 allLocations.add(coordenate1);
		 allLocations.add(coordenate2);
		 allLocations.add(coordenate3);
		 allLocations.add(coordenate4);
		 allLocations.add(coordenate5);
		 allLocations.add(coordenate6);

		int numDeliveries = 3;
		List<List<Integer>> closeLocations = rotatedWords.ClosestXdestinations(numDestinations, allLocations, numDeliveries);

		assertThat(closeLocations.get(0).get(0), is(2));
		assertThat(closeLocations.get(0).get(1), is(4));

		assertThat(closeLocations.get(1).get(0), is(5));
		assertThat(closeLocations.get(1).get(1), is(3));
	}
}