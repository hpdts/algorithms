package cracking.tree;

import org.junit.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;


public class GraphTest {

	private Graph graph = new Graph();
	

	@Test
	public void add(){
		graph.addNode(1);
    	graph.addNode(2);
    	graph.addNode(3);
    	graph.addNode(4);
    	graph.addNode(5);
    	graph.addNode(6);
    	graph.addEdge(1,2);
    	graph.addEdge(1,4);
    	graph.addEdge(2,3);
    	graph.addEdge(2,6);
    	graph.addEdge(3,5);
    	graph.addEdge(4,6);
    	graph.edgeExists(1,6);
    	graph.display();
    	//path between 1 to 6
		//assertThat(queue.dequeue(), is(1));
	}
}