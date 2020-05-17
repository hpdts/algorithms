package cracking.tree;

import org.junit.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import java.util.*;
import static org.junit.Assert.*;

public class BinarySearchTreeTest {

	private BinarySearchTree binarySearchTree = new BinarySearchTree();
    private BinarySearchTree tree = new BinarySearchTree();
	private	BinarySearchTree tree2 = new BinarySearchTree();
	
	@Before
    public void setUp() {
        binarySearchTree.root = null;
          
        // TREE 1
        /* Construct the following tree
              26
             /   \
            10     3
           /    \     \
          4      6      3
           \
            30  */
           
        tree.root = new BinarySearchTree.Node(26);
        tree.root.right = new BinarySearchTree.Node(3);
        tree.root.right.right = new BinarySearchTree.Node(3);
        tree.root.left = new BinarySearchTree.Node(10);
        tree.root.left.left = new BinarySearchTree.Node(4);
        tree.root.left.left.right = new BinarySearchTree.Node(30);
        tree.root.left.right = new BinarySearchTree.Node(6);
  
        // TREE 2
        /* Construct the following tree
           10
         /    \
         4      6
          \
          30  */
           
        tree2.root = new BinarySearchTree.Node(10);
        tree2.root.right = new BinarySearchTree.Node(6);
        tree2.root.left = new BinarySearchTree.Node(4);
        tree2.root.left.right = new BinarySearchTree.Node(30);
    }

	@Test
	public void arrayToTree(){
		int[] numbers = {1, 2, 7, 9, 10, 20, 45};
		binarySearchTree.arrayToTree(numbers);

		binarySearchTree.printInOrder(binarySearchTree.root);
	}
	
	//createMinimalBST
	@Test
	public void arrayToTreeBook(){
		int[] numbers = {1, 2, 7, 9, 10, 20, 45};
		binarySearchTree.createMinimalBST(numbers);
		binarySearchTree.printInOrder(binarySearchTree.root);
	}

	@Test
	public void treeByLevels(){
		int[] numbers = {1, 2, 7, 9, 10, 20, 45};
		binarySearchTree.createMinimalBST(numbers);
		binarySearchTree.printInOrder(binarySearchTree.root);

		List<List<Integer>> levels  = binarySearchTree.treeByLevel();
		assertThat(levels.size(), is(3));
		assertThat("root ", levels.get(0).toString(), is("[9]"));
		assertThat("level 1", levels.get(1).toString(), is("[2, 20]"));
		assertThat("level 2", levels.get(2).toString(), is("[1, 7, 10, 45]"));
	}

	@Test
	public void treeByLevelsBook(){
		int[] numbers = {1, 2, 7, 9, 10, 20, 45};
		binarySearchTree.createMinimalBST(numbers);

		ArrayList<LinkedList<BinarySearchTree.Node>> levels  = binarySearchTree.createLevelLinkedList();
		assertThat(levels.size(), is(3));
	}

	@Test
	public void treeByLevelsBookBFS(){
		int[] numbers = {1, 2, 7, 9, 10, 20, 45};
		binarySearchTree.createMinimalBST(numbers);

		ArrayList<LinkedList<BinarySearchTree.Node>> levels  = binarySearchTree.createLevellinkedListBFS(binarySearchTree.root);
		assertThat(levels.size(), is(3));
	}

	@Test
	public void isBST(){
		int[] numbers = {1, 2, 7, 9, 10, 20, 45};
		binarySearchTree.createMinimalBST(numbers);

		assertTrue(binarySearchTree.isBST());
	}

	@Test
	public void checkBST(){
		int[] numbers = {1, 2, 7, 9, 10, 20, 45};
		binarySearchTree.createMinimalBST(numbers);

		assertTrue(binarySearchTree.checkBST(binarySearchTree.root));
	}

	@Test
	public void checkBST2(){
		int[] numbers = {1, 2, 7, 9, 10, 20, 45};
		binarySearchTree.createMinimalBST(numbers);

		assertTrue(binarySearchTree.checkBST2(binarySearchTree.root));
	}

	@Test
	public void checkBSTBook(){
		int[] numbers = {1, 2, 7, 9, 10, 20, 45};
		binarySearchTree.createMinimalBST(numbers);

		assertTrue(binarySearchTree.checkBSTBook(binarySearchTree.root));
	}

	@Test
	public void display(){
		int[] numbers = {1, 2, 7, 9, 10, 20, 45};
		binarySearchTree.createMinimalBST(numbers);
		System.out.println("InOrder");
		binarySearchTree.displayInOrder(binarySearchTree.root);
		System.out.println("PostOrder");
		binarySearchTree.displayPostOrder(binarySearchTree.root);
	}

	@Test
	public void inOrderSuccessor(){
		int[] numbers = {1, 2, 7, 9, 10, 20, 45};
		binarySearchTree.createMinimalBST(numbers);
		BinarySearchTree.Node node = new BinarySearchTree.Node(7);

		BinarySearchTree.Node nodeNext = binarySearchTree.inOrderSuccessor(binarySearchTree.root, node);
		assertThat(nodeNext.number, is(9));

		node = new BinarySearchTree.Node(1);
		nodeNext = binarySearchTree.inOrderSuccessor(binarySearchTree.root, node);
		assertThat(nodeNext.number, is(2));
	}

	@Test
	public void firstCommonAncestor(){
		int[] numbers = {1, 2, 7, 9, 10, 20, 45};
		binarySearchTree.createMinimalBST(numbers);
		BinarySearchTree.Node node1 = new BinarySearchTree.Node(1);
		BinarySearchTree.Node node2 = new BinarySearchTree.Node(20);

		BinarySearchTree.Node nodeNext = binarySearchTree.firstCommonAncestor(node1, node2);
		assertThat(nodeNext.number, is(9));

	}

	@Test
	public void firstLCA(){
		int[] numbers = {1, 2, 7, 9, 10, 20, 45};
		binarySearchTree.createMinimalBST(numbers);
		BinarySearchTree.Node node1 = new BinarySearchTree.Node(1);
		BinarySearchTree.Node node2 = new BinarySearchTree.Node(20);

		BinarySearchTree.Node nodeNext = binarySearchTree.findLCA(1, 20);
		assertThat(nodeNext.number, is(9));

	}

	@Test
	public void commonAncestor(){
		int[] numbers = {1, 2, 7, 9, 10, 20, 45};
		binarySearchTree.createMinimalBST(numbers);
	
		BinarySearchTree.Node node1 = new BinarySearchTree.Node(1);
		BinarySearchTree.Node node2 = new BinarySearchTree.Node(20);

		BinarySearchTree.Node nodeNext = binarySearchTree.commonAncestor(binarySearchTree.root, node1, node2);
		assertThat(nodeNext.number, is(9));

	}

	@Test
	public void isSubtree(){
        assertTrue(tree.isSubtree(tree.root, tree2.root));
    }

    @Test
	public void isSubtreeBook(){
        assertTrue(tree.containsTree(tree.root, tree2.root));
    }


	@Test
	public void pathSum(){
		int[] numbers = {1, 2, 7, 9, 10, 20, 45};
		binarySearchTree.createMinimalBST(numbers);
	
		assertTrue(binarySearchTree.hasPathSum(binarySearchTree.root, 12));

	}
	
	@Test
	public void pathSumBook(){
		int[] numbers = {1, 2, 7, 9, 10, 20, 45};
		binarySearchTree.createMinimalBST(numbers);
		binarySearchTree.findSum(binarySearchTree.root, 11);
	}

	@Test
	public void maxInorder(){
		int[] numbers = {1, 2, 7, 9, 10, 20, 45};
		binarySearchTree.createMinimalBST(numbers);
		
		assertThat(binarySearchTree.maxInorder(binarySearchTree.root), is(45));
	}
}
