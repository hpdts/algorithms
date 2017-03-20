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
		assertThat(binaryTree.DFSOnList(root).toString(), is("[ 3,  2,  10,  8]"));
		assertThat(binaryTree.levelOrderQueue(root), is(" 3\n 2 10\n 8\n"));
	}
	
	@Test
	public void solveArithmethicExpression(){
		BinaryTree.Node root = new BinaryTree.Node(3);
		binaryTree.insert(root, 2);
		binaryTree.insert(root, 10);
		binaryTree.insert(root, 8);
		
		binaryTree.printInOrder(root);
		
		binaryTree.levelOrderQueue(root);

		assertThat(binaryTree.DFS(root), is(" 3 2 10 8"));
		assertThat(binaryTree.DFSOnList(root).toString(), is("[ 3,  2,  10,  8]"));
		assertThat(binaryTree.levelOrderQueue(root), is(" 3\n 2 10\n 8\n"));
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
		//create tree
	/*	      1
		 /       \
		 2        3
		/ \      / \
        6  7     9  20
                     \
                     30 */


		BinaryTree.Node root = new BinaryTree.Node(2);
		BinaryTree.Node node2 = new BinaryTree.Node(1);
		BinaryTree.Node node3 = new BinaryTree.Node(3);
		root.left = node2;
		root.right = node3;

		/*BinaryTree.Node node6 = new BinaryTree.Node(6);
		BinaryTree.Node node7 = new BinaryTree.Node(7);

		node2.left = node6;
		node2.right = node7;

		BinaryTree.Node node8 = new BinaryTree.Node(9);
		BinaryTree.Node node20 = new BinaryTree.Node(20);

		node3.left = node8;
		node3.right = node20;

		BinaryTree.Node node30 = new BinaryTree.Node(30);

		node20.right = node30;*/

		assertTrue(binaryTree.isValidBST(root));
		assertTrue(binaryTree.validateBinarySearchTree2(root));

	}	

}
