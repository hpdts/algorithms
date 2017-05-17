package binaryTree;

import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static binaryTree.BinaryTree.*;
import static org.junit.Assert.*;
import java.util.*;

public class BinaryTreeTest {

	private BinaryTree binaryTree = new BinaryTree();
	
	@Test
	public void creatingTree(){
		BinaryTree.Node root = new BinaryTree.Node(3);
		binaryTree.insert(root, 2);
		binaryTree.insert(root, 10);
		binaryTree.insert(root, 8);
		
		binaryTree.printInOrder(root);
		
		binaryTree.levelOrderQueue(root);

		assertThat(binaryTree.DFS(root), is(" 3 2 10 8"));
		//assertThat(binaryTree.DFSOnList(root).toString(), is("[ 3,  2,  10,  8]"));

		assertTrue(binaryTree.DFS(root).toString().contains("3"));
		assertTrue(binaryTree.DFS(root).toString().contains("2"));
		assertTrue(binaryTree.DFS(root).toString().contains("10"));
		assertTrue(binaryTree.DFS(root).toString().contains("8"));
		//assertThat(binaryTree.levelOrderQueue(root), is(" 3\n 2 10\n 8\n"));
	}
	
	@Test
	public void solveArithmethicExpression(){
		BinaryTree.Node root = new BinaryTree.Node(3);
		binaryTree.insert(root, 2);
		binaryTree.insert(root, 10);
		binaryTree.insert(root, 8);
		
		binaryTree.printInOrder(root);
		
		binaryTree.levelOrderQueue(root);

		//assertThat(binaryTree.DFS(root), is(" 3 2 10 8"));
		//assertThat(binaryTree.DFSOnList(root).toString(), is("[ 3,  2,  10,  8]"));
		//assertThat(binaryTree.levelOrderQueue(root), is(" 3\n 2 10\n 8\n"));
	}

	@Test
	public void dfs(){
		//create tree
	/*	      1
		 /       \
		 2        3
		/ \      / \
        6  7     8  20
           \     /
            40   30 */


		BinaryTree.Node root = new BinaryTree.Node(1);
		BinaryTree.Node node2 = new BinaryTree.Node(2);
		BinaryTree.Node node3 = new BinaryTree.Node(3);
		root.left = node2;
		root.right = node3;

		BinaryTree.Node node6 = new BinaryTree.Node(6);
		BinaryTree.Node node7 = new BinaryTree.Node(7);

		node2.left = node6;
		node2.right = node7;

		BinaryTree.Node node8 = new BinaryTree.Node(8);
		BinaryTree.Node node20 = new BinaryTree.Node(20);

		node3.left = node8;
		node3.right = node20;

		BinaryTree.Node node40 = new BinaryTree.Node(40);
		BinaryTree.Node node30 = new BinaryTree.Node(30);

		node8.left = node30;
		node7.right = node40;

		System.out.println("tree: " + binaryTree);
		assertTrue(binaryTree.dfs(root, 30));
		assertFalse(binaryTree.dfs(root, 300));

		assertTrue(binaryTree.bfs(root, 30));
		assertFalse(binaryTree.bfs(root, 300));

		System.out.println("PreOrder: ");
		binaryTree.preOrder(root);

		System.out.println("PostOrder: ");
		binaryTree.postOrder(root);

		System.out.println("InOrder: ");
		binaryTree.inOrder(root);

		assertThat(binaryTree.height(root), is(4));

		System.out.println("levelOrder: ");
		binaryTree.levelOrder(root);

	}	

	@Test
	public void validateBinarySearchTree(){
		BinaryTree.Node root = new BinaryTree.Node(5);
		BinaryTree.Node node3 = new BinaryTree.Node(3);
		BinaryTree.Node node8 = new BinaryTree.Node(8);

		BinaryTree.Node node1 = new BinaryTree.Node(1);
		BinaryTree.Node node4 = new BinaryTree.Node(4);

		root.left = node3;
		root.right = node8;

		node3.left = node1;
		node3.right = node4;

		Node node7 = new Node(7);
		Node node9 = new Node(9);

		node8.left = node7;
		node8.right = node9;


		assertTrue(binaryTree.isValidBST(root));
		assertTrue(binaryTree.isValidBST2(root));
		assertTrue(binaryTree.validateBinarySearchTree2(root));

	}	

	@Test
	public void InvertTree(){
		BinaryTree.Node root = new BinaryTree.Node(1);
		BinaryTree.Node node2 = new BinaryTree.Node(2);
		BinaryTree.Node node3 = new BinaryTree.Node(3);
		root.left = node2;
		root.right = node3;

		BinaryTree.Node node6 = new BinaryTree.Node(6);
		BinaryTree.Node node7 = new BinaryTree.Node(7);

		node2.left = node6;
		node2.right = node7;

		BinaryTree.Node node8 = new BinaryTree.Node(8);
		BinaryTree.Node node20 = new BinaryTree.Node(20);

		node3.left = node8;
		node3.right = node20;
		System.out.println("Tree: " + root);

		binaryTree.invertTree(root);
		System.out.println("Inverted Tree: " + root);

		binaryTree.invertTreeIterative(root);
		System.out.println("Inverted Tree Iterative: " + root);
	}

	@Test
	public void findKthSmallestElement(){
		 /*    4
		   /	   \    
		   2	    7
		 /  \      / \
		 1   3     6  8
		  */

		Node root = new Node(4);
		Node node2 = new Node(2);
		Node node7 = new Node(7);

		root.left  = node2;
		root.right = node7;

		Node node1 = new Node(1);
		Node node3 = new Node(3);

		node2.left = node1;
		node2.right = node3;

		Node node6 = new Node(6);
		Node node8 = new Node(8);

		node7.left = node6;
		node7.right = node8;

		assertThat(binaryTree.findKthSmallestElement(root, 1), is(1));
		assertThat(binaryTree.findKthSmallestElement(root, 2), is(2));
		assertThat(binaryTree.findKthSmallestElement(root, 5), is(6));
		assertThat(binaryTree.findKthSmallestElement(root, 7), is(8));

		assertThat(binaryTree.kthSmallest(root, 1), is(1));
		assertThat(binaryTree.kthSmallest(root, 2), is(2));
		assertThat(binaryTree.kthSmallest(root, 5), is(6));
		assertThat(binaryTree.kthSmallest(root, 7), is(8));

		assertThat(binaryTree.kthSmallest2(root, 1), is(1));
		assertThat(binaryTree.kthSmallest2(root, 2), is(2));
		assertThat(binaryTree.kthSmallest2(root, 5), is(6));
		assertThat(binaryTree.kthSmallest2(root, 7), is(8));
	}

		@Test
	public void longestConsecutive(){
		 /*    1
		   /	   \    
		   2	    4
		 /        / \
		 3        5  6
		             /
					7
		  */  

		Node root = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);

		root.left  = node2;
		node2.left = node3;

		Node node4 = new Node(4);
		root.right = node4;
		
		Node node5 = new Node(5);
		Node node6 = new Node(6);
		node4.left = node5;
		node4.right = node6;

		Node node7 = new Node(7);
		node6.left = node7;

		assertThat(binaryTree.longestConsecutive(root), is(3));
		assertThat(binaryTree.longestConsecutiveIterative(root), is(3));
		
		
	}
}
