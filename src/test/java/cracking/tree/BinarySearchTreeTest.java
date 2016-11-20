package cracking.tree;

import org.junit.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import java.util.*;
import static org.junit.Assert.*;


public class BinarySearchTreeTest {

	private BinarySearchTree binarySearchTree = new BinarySearchTree();
	
	@Before
    public void setUp() {
        binarySearchTree.root = null;
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
}
