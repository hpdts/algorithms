package cracking.tree;

import java.util.*;

public class GraphNode {

    public List<Node> nodes = new ArrayList<>();

	public class Node {
    	public Integer label;
    	public State state;
    	public List<Edge> neighbours;
    	public Node(int label){
    		this.label = label;
    		state = State.Unvisited;
    		neighbours = new ArrayList<>();
    	}
	}

	public class Edge {
    	public Node start;
    	public Node end;
    	public double weight;

    	public Edge(int start, int end, int weight){
    		Node startNode = new Node(start);
			this.start = startNode;

			Node endNode = new Node(end);
			this.end = endNode;
			this.weight =0;
    	}
	}

    public enum State {
	 	Unvisited, Visited, Visiting;
	 }
	
	public List<Node> getNodes(){
		return nodes;
	}

	public void display(){
		for(Node node : nodes){
			System.out.println("Node Label: " + node.label);
		}
	}

	public void addNode(Integer label){
		Node node = new Node(label);
		nodes.add(node);
	}

	public void addEdge(Integer start, Integer end){
		for (Node node : nodes){
			if(node.label.equals(start)){
				Edge edge = new Edge(start, end, 0);
				node.neighbours.add(edge);
			}
		}
	}

	public List<Node> getAdjacents(int nodeLabel){
		List<Node> adjacents = new ArrayList<>();
		for (Node node : nodes){
			if(node.label.equals(nodeLabel)){
				for(Edge neighbour : node.neighbours){
					adjacents.add(neighbour.end);
				}
			}
		}
	 	return adjacents;
	}

	public boolean searchBFS(int start, int end) {
	 	// operates as Queue
		LinkedList<Node> queue = new LinkedList<Node>();
		for (Node node : nodes) {
			for(Node neighbour : getAdjacents(node.label)){
				neighbour.state = State.Unvisited;
			}
		}

		Node startNode = null;
		for(Node node : nodes){
			if(node.label == start){
				startNode = node;
				break;
			}
		}

		startNode.state = State.Visiting;
		queue.add(startNode);
		System.out.println("startNode: " + startNode.label);

		Node temporary;
		while (!queue.isEmpty()) {
			temporary = queue.removeFirst(); // i.e., dequeue()
			if (temporary != null) {
				System.out.println("temp: " + temporary.label);
				for (Node node : getAdjacents(temporary.label)) {
					System.out.println("neighbour: " + node.label + ", visited: " + node.state);
		 			if (node.state == State.Unvisited) {
		 				if (node.label.equals(end)) {
		 					return true;
						} else {
		 					node.state = State.Visiting;
		 					queue.add(node);
		 				}
					}
				}
		 		temporary.state = State.Visited;
		 	}
		 }

		 return false;
 	}
 }