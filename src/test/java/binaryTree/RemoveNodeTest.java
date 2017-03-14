package binaryTree;

import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static binaryTree.RemoveNode.*;
import java.util.*;

public class RemoveNodeTest {

	private RemoveNode removeNode = new RemoveNode();
	
	@Test
	public void creatingTree(){
		 /*     5
		   /	   \      \
		   3       10      45
		 /   \     /        \
		 1   11   20        56
		          /
                 30
		         /
		         7
		  */

		Node node3 = new Node(3);
		Node node1 = new Node(1);
		//node1.children.add(null);
		node3.children.add(node1);
		Node node11 = new Node(11);
		//node11.children.add(null);
		node3.children.add(node11);

		Node node45 = new Node(45);
		Node node56 = new Node(56);
		//node56.children.add(null);
		node45.children.add(node56);

		Node node10 = new Node(10);
		Node node20 = new Node(20);

		
		Node node30 = new Node(30);
		Node node7 = new Node(7);
		//node7.children.add(null);
		node30.children.add(node7);

		node20.children.add(node30);
		node10.children.add(node20);

		removeNode.root = new Node(5);
		root.children.add(node3);
		root.children.add(node45);
		root.children.add(node10);
		

		System.out.println("Before Tree: " + removeNode.root);
		removeNode.cleanUp();
		//removeNode.bfs();

		System.out.println("After Tree: " + removeNode.root);

	}
	

}