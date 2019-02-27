package binaryTree;

import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static binaryTree.BinaryTree.*;
import static binaryTree.BSTIterator.*;
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
		/*	5
		 /       \
		 3        8
		/ \      / \
        1  4     7  9 */

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

		System.out.println("InOrder Iterative: ");
		binaryTree.inOrderIterative(root);

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

	@Test
	public void flattenBinary(){
		 /*    1
		   /	   \    
		   2	    5
		 /   \       \
		 3    4       6
		  */  

		Node root = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(4);

		root.left  = node2;
		node2.left = node3;
		node2.right = node4;
		
		Node node5 = new Node(5);
		Node node6 = new Node(6);
		root.right = node5;
		node5.right = node6;

		List<Integer> numbers = binaryTree.flattenBinaryIterative(root);
		assertThat(numbers.size(), is(6));

		List<Integer> numbers2 = binaryTree.flattenBinary(root);
		assertThat(numbers2.size(), is(6));

		binaryTree.flatten(root);
		System.out.println("new tree: " + root);
	}

	@Test
	public void hasPathSum(){
		 /*    5
		   /	   \    
		   4	   8
		 /        / \
		 11      13  4
		/   \          \
		7	2		    1
		  */  

		Node root = new Node(5);
		Node node4 = new Node(4);
		Node node8 = new Node(8);

		root.left  = node4;
		root.right = node8;
		
		Node node11 = new Node(11);
		node4.left = node11;
		
		Node node7 = new Node(7);
		Node node2 = new Node(2);
		node11.left = node7;
		node11.right = node2;

		Node node13 = new Node(13);
		Node node42 = new Node(4);
		node8.left = node13;
		node8.right = node42;

		Node node1 = new Node(1);
		node42.right = node1;

		assertTrue(binaryTree.hasPathSum(root, 22));
		assertTrue(binaryTree.hasPathSum2(root, 22));
	}

	@Test
	public void pathSums(){
		 /*    5
		   /	   \    
		   4	   8
		 /        / \
		 11      13  4
		/   \       /   \
		7	2	    5    1
		  */  

		Node root = new Node(5);
		Node node4 = new Node(4);
		Node node8 = new Node(8);

		root.left  = node4;
		root.right = node8;
		
		Node node11 = new Node(11);
		node4.left = node11;
		
		Node node7 = new Node(7);
		Node node2 = new Node(2);
		node11.left = node7;
		node11.right = node2;

		Node node13 = new Node(13);
		Node node42 = new Node(4);
		node8.left = node13;
		node8.right = node42;

		Node node1 = new Node(1);
		Node node51 = new Node(5);
		node42.right = node1;
		node42.left = node51;

		List<ArrayList<Integer>> paths = binaryTree.pathSums(root, 22);
		System.out.println("paths: " + paths);
		assertThat(binaryTree.getHeight(root), is(3));
		
	}

	@Test
	public void inOrderConstructTree(){
		int[] inOrder = new int[] { 4, 2, 5, 1, 6, 7, 3, 8 };
		int[] postOrder = new int[] { 4, 5, 2, 6, 7, 8, 3, 1 };

		Node tree = binaryTree.buildTree(inOrder, postOrder);
		System.out.println("tree built: " + tree);
	}

	@Test
	public void bstFromSortedArray(){
		int[] sorted = new int[] { 1, 2, 3, 4};
		Node tree = binaryTree.buildTreeFromSortedArray(sorted);
		String treeString = binaryTree.levelOrderQueue(tree);
		System.out.println("tree built: " + treeString);
	}

	@Test
	public void bstFromSortedList(){
		ListNode root = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);

		root.next = node2;
		node2.next = node3;
		node3.next = node4;

		Node tree = binaryTree.sortedListToBST(root);
		String treeString = binaryTree.levelOrderQueue(tree);
		System.out.println("tree built from list: " + treeString);
	}

	@Test
	public void minDepth(){
		Node root = new Node(5);
		Node node4 = new Node(4);
		Node node8 = new Node(8);

		root.left  = node4;
		root.right = node8;
		
		Node node11 = new Node(11);
		node4.left = node11;
		
		Node node7 = new Node(7);
		Node node2 = new Node(2);
		node11.left = node7;
		node11.right = node2;

		Node node13 = new Node(13);
		Node node42 = new Node(4);
		node8.left = node13;
		node8.right = node42;

		Node node1 = new Node(1);
		Node node51 = new Node(5);
		node42.right = node1;
		node42.left = node51;
		
		assertThat(binaryTree.minDepth(root), is(3));

	}

	@Test
	public void maxSum(){
		/*		  5	
              /     \
             4       8
            /      /   \
           11     13    42 
          /  \         /   \
         7    2        51     1 */


		Node root = new Node(5);
		Node node4 = new Node(4);
		Node node8 = new Node(8);

		root.left  = node4;
		root.right = node8;
		
		Node node11 = new Node(11);
		node4.left = node11;
		
		Node node7 = new Node(7);
		Node node2 = new Node(2);
		node11.left = node7;
		node11.right = node2;

		Node node13 = new Node(13);
		Node node42 = new Node(4);
		node8.left = node13;
		node8.right = node42;

		Node node1 = new Node(1);
		Node node51 = new Node(5);
		node42.right = node1;
		node42.left = node51;
		
		assertThat(binaryTree.maxPathSum(root), is(48));

	}

	@Test
	public void isBalanced(){
		Node root = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);

		root.left = node2;
		//node2.left = node3;
		assertTrue(binaryTree.isBalanced(root));
	}

	@Test
	public void isSymmetric(){
		Node root = new Node(1);
		Node node2Left = new Node(2);
		Node node2Right = new Node(2);
		Node node3Left = new Node(3);
		Node node3Right = new Node(3);
		Node node4Right = new Node(4);
		Node node4Left = new Node(4);

		root.left = node2Left;
		root.right = node2Right;

		node2Left.left = node3Left;
		node2Left.right = node4Left;

		node2Right.left = node4Right;
		node2Right.right = node3Right;		

		assertTrue(binaryTree.isSymmetric(root));
	}

	@Test
	public void iterator(){
		Node root = new Node(8);
		Node node3 = new Node(3);
		Node node10 = new Node(10);
		Node node1 = new Node(1);
		Node node6 = new Node(6);
		Node node14 = new Node(14);
		Node node4 = new Node(4);
		Node node7 = new Node(7);
		Node node13 = new Node(13);

		root.left = node3;
		root.right = node10;

		node3.left = node1;
		node3.right = node6;

		node6.left = node4;
		node6.right = node7;

		node10.right = node14;
		node14.left = node13;

		BSTIterator bstIterator = new BSTIterator(root);

        while(bstIterator.hasNext()){
            Node node = bstIterator.next();
            if(node != null){
                System.out.println("bstIterator: " + node.value);
            }
        }
	}

	@Test
	public void rightSideView(){
		Node root = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node5 = new Node(5);

		root.left = node2;
		root.right = node3;
		node2.right = node5;

		List<Integer> numbersRight = binaryTree.rightSideView(root);
		System.out.println("numbersRight: " + numbersRight.toString());
	}

	@Test
	public void lowestCommonAncestor(){

		Node root = new Node(5);
		Node node3 = new Node(3);
		Node node8 = new Node(8);
		Node node1 = new Node(1);
		Node node4 = new Node(4);
		Node node7 = new Node(7);
		Node node9 = new Node(9);

		/*	 5
		 /       \
		 3        8
		/ \      / \
        1  4     7  9
   			*/

		root.left = node3;
		root.right = node8;

		node3.left = node1;
		node3.right = node4;

		node8.left = node7;
		node8.right = node9;

		Node lca = binaryTree.lowestCommonAncestor(root, node1, node9);
		assertThat(lca.value, is(5));	

		lca = binaryTree.lowestCommonAncestor(root, node1, node4);
		assertThat(lca.value, is(3));		
	}

	@Test
	public void lowestCommonAncestorI(){

		Node root = new Node(5);
		Node node3 = new Node(3);
		Node node8 = new Node(8);
		Node node1 = new Node(1);
		Node node4 = new Node(4);
		Node node7 = new Node(7);
		Node node9 = new Node(9);

		/*	 5
		 /       \
		 3        8
		/ \      / \
        1  4     7  9
   			*/

		root.left = node3;
		root.right = node8;

		node3.left = node1;
		node3.right = node4;

		node8.left = node7;
		node8.right = node9;

		Node lca = binaryTree.lowestCommonAncestorI(root, node1, node4);
		assertThat(lca.value, is(3));			
	}

	@Test
	public void validSerialization(){
		assertTrue(binaryTree.isValidSerialization("9,3,4,#,#,1,#,#,2,#,6,#,#"));
	}


	@Test
	public void nextPointer(){

		NodeNext root = new  NodeNext(1);
		NodeNext node2 = new NodeNext(2);
		NodeNext node3 = new NodeNext(3);
		NodeNext node4 = new NodeNext(4);
		NodeNext node5 = new NodeNext(5);
		NodeNext node6 = new NodeNext(6);
		NodeNext node7 = new NodeNext(7);

		/*	 1
	       /  \
	      2    3
	     / \  / \
	    4  5  6  7
	   			*/

		root.left = node2;
		root.right = node3;

		node2.left = node4;
		node2.right = node5;

		node3.left = node6;
		node3.right = node7;

		binaryTree.connect(root);

		System.out.println("tree: " + root);
	}

	@Test
	public void nextPointer2(){

		NodeNext root = new  NodeNext(1);
		NodeNext node2 = new NodeNext(2);
		NodeNext node3 = new NodeNext(3);
		NodeNext node4 = new NodeNext(4);
		NodeNext node5 = new NodeNext(5);
		NodeNext node6 = new NodeNext(6);
		NodeNext node7 = new NodeNext(7);

		/*	 1
	       /  \
	      2    3
	     / \  / \
	    4  5  6  7
	   			*/

		root.left = node2;
		root.right = node3;

		node2.left = node4;
		node2.right = node5;

		node3.left = node6;
		node3.right = node7;

		binaryTree.connect2(root);

		System.out.println("next: " + root);
	}

	@Test
	public void nextPointer3(){

		NodeNext root = new  NodeNext(1);
		NodeNext node2 = new NodeNext(2);
		NodeNext node3 = new NodeNext(3);
		NodeNext node4 = new NodeNext(4);
		NodeNext node5 = new NodeNext(5);
		NodeNext node6 = new NodeNext(6);
		NodeNext node7 = new NodeNext(7);

		root.left = node2;
		root.right = node3;

		node2.left = node4;
		node2.right = node5;

		node3.left = node6;
		node3.right = node7;

		binaryTree.connect3(root);

		System.out.println("next3: " + root);
	}

	@Test
	public void generateTrees(){
		List<Node> trees = binaryTree.generateTrees(4);
		System.out.println("tree0: " + trees.get(0));
	}

	@Test
	public void sumRootToLeaf(){
		Node root = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);

		root.left = node2;
		root.right = node3;

		assertThat(binaryTree.sumNumbers(root), is(25));
		assertThat(binaryTree.sumNumbersII(root), is(25));
	}

	@Test
	public void countNodes(){

		Node root = new  Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(4);
		Node node5 = new Node(5);
		Node node6 = new Node(6);
		Node node7 = new Node(7);

		/*	 1
	       /  \
	      2    3
	     / \  / \
	    4  5  6  7
	   			*/

		root.left = node2;
		root.right = node3;

		node2.left = node4;
		node2.right = node5;

		node3.left = node6;
		node3.right = node7;

		assertThat(binaryTree.countNodes(root), is(7));
		assertThat(binaryTree.countNodesI(root), is(7));
	}

	@Test
	public void closestValue(){

		Node root = new Node(5);
		Node node3 = new Node(3);
		Node node8 = new Node(8);
		Node node1 = new Node(1);
		Node node4 = new Node(4);
		Node node7 = new Node(7);
		Node node9 = new Node(9);

		/*	 5
		 /       \
		 3        8
		/ \      / \
        1  4     7  9
   			*/

		root.left = node3;
		root.right = node8;

		node3.left = node1;
		node3.right = node4;

		node8.left = node7;
		node8.right = node9;

		int value = binaryTree.closestValue(root, 2);
		//System.out.println("value: " + value);

		assertThat(binaryTree.closestValueIterative(root, 2), is(3));

	}

	

	@Test
	public void getNNode(){

		Node root = new Node(5);
		Node node3 = new Node(3);
		Node node8 = new Node(8);
		Node node1 = new Node(1);
		Node node4 = new Node(4);
		Node node7 = new Node(7);
		Node node9 = new Node(9);

		/*	 5
		 /       \
		 3        8
		/ \      / \
        1  4     7  9
   			*/

		root.left = node3;
		root.right = node8;

		node3.left = node1;
		node3.right = node4;

		node8.left = node7;
		node8.right = node9;

		assertThat(binaryTree.getNNode(root, 1), is(9));
		assertThat(binaryTree.getNNode(root, 3), is(7));
	}

	@Test
	public void binaryTreePaths(){

		Node root = new Node(5);
		Node node3 = new Node(3);
		Node node8 = new Node(8);
		Node node1 = new Node(1);
		Node node4 = new Node(4);
		Node node7 = new Node(7);
		Node node9 = new Node(9);

		/*	 5
		 /       \
		 3        8
		/ \      / \
        1  4     7  9
   			*/

		root.left = node3;
		root.right = node8;

		node3.left = node1;
		node3.right = node4;

		node8.left = node7;
		node8.right = node9;


		List<String> paths = binaryTree.binaryTreePaths(root);
		System.out.println("paths: " + paths.toString());

	}

	@Test
	public void maxDepth(){

		Node root = new Node(5);
		Node node3 = new Node(3);
		Node node8 = new Node(8);
		Node node1 = new Node(1);
		Node node4 = new Node(4);
		Node node7 = new Node(7);
		Node node9 = new Node(9);
		Node node10 = new Node(10);

		/*	 5
		 /       \
		 3        8
		/ \      / \
        1  4     7  9
        			\
        			10	
   			*/

		root.left = node3;
		root.right = node8;

		node3.left = node1;
		node3.right = node4;

		node8.left = node7;
		node8.right = node9;
		node9.right = node10;


		assertThat(binaryTree.maxDepth(root), is(4));

	}

	@Test
	public void recoverTree(){

		Node root = new Node(5);
		Node node3 = new Node(3);
		Node node8 = new Node(8);
		Node node1 = new Node(1);
		Node node4 = new Node(4);
		Node node7 = new Node(7);
		Node node9 = new Node(9);

		/*	 5
		 /       \
		 3        8
		/ \      / \
        9  4     7  1
   			*/

		root.left = node3;
		root.right = node8;

		node3.left = node9;
		node3.right = node4;

		node8.left = node7;
		node8.right = node1;
		System.out.println("Oldtree: " + root.toString());

		binaryTree.recoverTree(root);
		System.out.println("Newtree: " + root.toString());

	}

	@Test
	public void diameterTree(){

		Node root = new Node(5);
		Node node1 = new Node(1);
		Node node3 = new Node(3);
		Node node10 = new Node(10);
		Node node4 = new Node(4);
		Node node11 = new Node(11);
		Node node12 = new Node(12);

		/*	 5
		 /       \
		 4        1
		/ \       \
        3  11     10
             \
              12       
   			*/

		root.left = node4;
		root.right = node1;

		node4.left = node3;
		node4.right = node11;

		node11.right = node12;
		node1.right = node10;

		//System.out.println("Oldtree: " + root.toString());
		int diameter = binaryTree.diameterTree(root);
		assertThat(binaryTree.getHeight2(root.left), is(2));
		System.out.println("diameter: " + diameter);

	}

	@Test
	public void sameTree(){
		Node rootA = new Node(5);
		Node node1 = new Node(1);
		Node node4 = new Node(4);

		rootA.left = node4;
		rootA.right = node1;

		Node rootB = new Node(5);
		Node node1B = new Node(1);
		Node node4B = new Node(4);

		rootB.left = node4B;
		rootB.right = node1B;

		assertTrue(binaryTree.isSameTree(rootA, rootB));
	}

	@Test
	public void serialize(){
		Node root = new Node(5);
		Node node1 = new Node(1);
		Node node4 = new Node(4);
		Node node2 = new Node(2);
		Node node3 = new Node(3);

		root.left = node4;
		root.right = node1;

		node1.left = node2;
		node1.right = node3;

		/*	 5
		 /       \
		 4        1 
		         / \
		         2  3   
   			*/
		//451 inorder  
		String serialization = binaryTree.serialize(root);
		assertThat(serialization, is("5,4,1,#,#,2,3,#,#,#,#,")); 

		Node deserializeTree = binaryTree.deserialize(serialization);

		System.out.println("root deserialize: " + deserializeTree.toString());
		
	}
}
