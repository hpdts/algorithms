package cracking.tree;

import java.util.*;

public class Graph {
	 private final Map<Integer, Set<Integer>> mGraph = new HashMap<>();

    /**
     * Adds a new node to the graph.  If the node already exists, this
     * function is a no-op.
     * @param node The node to add.
     * @return Whether or not the node was added.
     */
    public boolean addNode(Integer node) {
        /* If the node already exists, don't do anything. */
        if (mGraph.containsKey(node)){
            return false;
        }

        /* Otherwise, add the node with an empty set of outgoing edges. */
        mGraph.put(node, new HashSet<Integer>());
        return true;
    }

    /**
     * Given a start node, and a destination, adds an arc from the start node 
     * to the destination.  If an arc already exists, this operation is a 
     * no-op.  If either endpoint does not exist in the graph, throws a 
     * NoSuchElementException.
     *
     * @param start The start node.
     * @param dest The destination node.
     * @throws NoSuchElementException If either the start or destination nodes
     *                                do not exist.
     */
    public void addEdge(Integer start, Integer dest) {
        /* Confirm both endpoints exist. */
        if (!mGraph.containsKey(start) || !mGraph.containsKey(dest)){
            throw new NoSuchElementException("Both nodes must be in the graph.");
        }

        /* Add the edge. */
        mGraph.get(start).add(dest);
    }

	/**
     * Given two nodes in the graph, returns whether there is an edge from the
     * first node to the second node.  If either node does not exist in the
     * graph, throws a NoSuchElementException.
     *
     * @param start The start node.
     * @param end The destination node.
     * @return Whether there is an edge from start to end.
     * @throws NoSuchElementException If either endpoint does not exist.
     */
    public boolean edgeExists(Integer start, Integer end) {
        /* Confirm both endpoints exist. */
        if (!mGraph.containsKey(start) || !mGraph.containsKey(end))
            throw new NoSuchElementException("Both nodes must be in the graph.");

        return mGraph.get(start).contains(end);
    }

    public void display(){
    	for(Integer label : mGraph.keySet()){
    		Set<Integer> neighbors = mGraph.get(label);
    		System.out.println("node:"  + label );
    		for(Integer neighbor : neighbors){
    			System.out.println(label  + "->" + neighbor);
    		}

    	}
    }

}