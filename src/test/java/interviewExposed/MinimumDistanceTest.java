package interviewExposed;

import org.junit.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import java.util.*;

public class MinimumDistanceTest {

	MinimumDistance minimumDistance = new MinimumDistance();


	@Test
	public void totalDistance(){
		int numRows = 3;
		int numColumns = 3;

		 List<List<Integer>> area = new ArrayList<List<Integer>>();
		 List<Integer> grid1 = new ArrayList<>();
		 grid1.add(1);
		 grid1.add(0);
		 grid1.add(0);

		 List<Integer> grid2 = new ArrayList<>();
		 grid2.add(1);
		 grid2.add(0);
		 grid2.add(0);

		 List<Integer> grid3 = new ArrayList<>();
		 grid3.add(1);
		 grid3.add(9);
		 grid3.add(1);


		 area.add(grid1);
		 area.add(grid2);
		 area.add(grid3);

		int dist = minimumDistance.totalDistance(numRows, numColumns, area);
		assertThat(dist, is(3));
	}

	@Test
	public void totalDistance2(){
		int numRows = 5;
		int numColumns = 4;

		 List<List<Integer>> area = new ArrayList<List<Integer>>();
		 List<Integer> grid1 = new ArrayList<>();
		 grid1.add(1);
		 grid1.add(1);
		 grid1.add(1);
		 grid1.add(1);

		 List<Integer> grid2 = new ArrayList<>();
		 grid2.add(0);
		 grid2.add(1);
		 grid2.add(1);
		 grid2.add(1);

		 List<Integer> grid3 = new ArrayList<>();
		 grid3.add(0);
		 grid3.add(1);
		 grid3.add(0);
		 grid3.add(1);

		 List<Integer> grid4 = new ArrayList<>();
		 grid4.add(1);
		 grid4.add(1);
		 grid4.add(9);
		 grid4.add(1);

		 List<Integer> grid5 = new ArrayList<>();
		 grid5.add(0);
		 grid5.add(0);
		 grid5.add(1);
		 grid5.add(1);

		 area.add(grid1);
		 area.add(grid2);
		 area.add(grid3);
		 area.add(grid4);
		 area.add(grid5);

		int dist = minimumDistance.totalDistance(numRows, numColumns, area);
		assertThat(dist, is(5));
	}

	@Test
	public void totalDistance3(){
		int numRows = 5;
		int numColumns = 4;

		 List<List<Integer>> area = new ArrayList<List<Integer>>();
		 List<Integer> grid1 = new ArrayList<>();
		 grid1.add(0);
		 grid1.add(0);
		 grid1.add(0);
		 grid1.add(0);

		 List<Integer> grid2 = new ArrayList<>();
		 grid2.add(0);
		 grid2.add(0);
		 grid2.add(0);
		 grid2.add(0);

		 List<Integer> grid3 = new ArrayList<>();
		 grid3.add(0);
		 grid3.add(1);
		 grid3.add(0);
		 grid3.add(1);

		 List<Integer> grid4 = new ArrayList<>();
		 grid4.add(1);
		 grid4.add(1);
		 grid4.add(9);
		 grid4.add(1);

		 List<Integer> grid5 = new ArrayList<>();
		 grid5.add(0);
		 grid5.add(0);
		 grid5.add(1);
		 grid5.add(1);

		 area.add(grid1);
		 area.add(grid2);
		 area.add(grid3);
		 area.add(grid4);
		 area.add(grid5);

		int dist = minimumDistance.totalDistance(numRows, numColumns, area);
		assertThat(dist, is(-1));
	}

}