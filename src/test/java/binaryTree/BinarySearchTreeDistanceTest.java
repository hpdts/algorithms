package binaryTree;

import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static binaryTree.BinarySearchTreeDistance.*;


public class BinarySearchTreeDistanceTest {

	private BinarySearchTreeDistance binaryTree = new BinarySearchTreeDistance();
	
	@Test
	public void insert(){

		/*    5
		   /	\
		   3    6
		 /   \
		 1   4
		  \  	  
		   2 
		   Distance between  node 1 and 2*/

		Node root = new Node(5);
		binaryTree.insert(root, 3);
		binaryTree.insert(root, 6);
		binaryTree.insert(root, 1);
		binaryTree.insert(root, 4);
		binaryTree.insert(root, 2);

		//System.out.println("root: " + root);
		//System.out.println("PostOrder: ");
		binaryTree.postOrder(root);

		assertThat(binaryTree.lowestCommonAncestor(root, new Node(1), new Node(4)).number, is(3));
		assertThat(binaryTree.distance(root, new Node(2), new Node(4)), is(3));

	}


}