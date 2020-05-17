package accelerator;

import org.junit.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import java.util.*;

public class GraphTest {
	Graph graph = new Graph();

    /* 1-2-3-5
       |  /
       4 / */
	@Test
    public void insert(){
    	graph.addVertex(1);
    	graph.addVertex(2);
    	graph.addVertex(3);
    	graph.addVertex(4);
    	graph.addVertex(5);
    	graph.addVertex(6);
    	graph.removeVertex(6);
    	graph.addEdge(1,2);
    	graph.addEdge(2,3);
    	graph.addEdge(3,5);
    	graph.addEdge(4,3);
    	graph.addEdge(2,3);
    	graph.removeEdge(2,3);
    	graph.display();
    	List<Integer> neighbors = graph.neighbors(4);
    	System.out.println("neighbors: " + neighbors);
    	assertTrue(graph.isVertex(2));
    }

}