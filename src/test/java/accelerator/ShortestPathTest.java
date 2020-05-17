package accelerator;

import org.junit.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import java.util.*;
import static accelerator.ShortestPath.*;

public class ShortestPathTest {

	public ShortestPath shortestPath = new ShortestPath();

	@Test
	public void hospital(){
		int[][] input = {{0,1,0,0,0},
	                     {1,0,0,2,1},
	                     {0,1,0,0,0}};
	    Point origin = new Point(0, 0);

	    Point destination = new Point(0, 1);
	    int dist = shortestPath.shortestPath(input, origin, destination);
	    assertThat(dist, is(1));

	    origin = new Point(1, 1);
	    destination = new Point(1, 4);
	    dist = shortestPath.shortestPath(input, origin, destination);
	    assertThat(dist, is(5));

	    destination = new Point(0, 0);
	    dist = shortestPath.shortestPath(input, origin, destination);
	    assertThat(dist, is(-1));

	    int small = shortestPath.getSmallestSumDistance(input);
	    assertThat(small, is(8));
	   /* Point origin = new Point(1, 4);
	    Point destination = new Point(2, 2);
	    int dist = shortestPath.shortestPath(input, origin, destination);
	    assertThat(dist, is(3));*/
	}



}