package cracking.tree;

import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


public class BinarySearchTreeTest {

	private BinarySearchTree binarySearchTree = new BinarySearchTree();
	
	@Test
	public void arrayToTree(){
		int[] numbers = {1, 2, 7, 9, 10, 20, 45};
		binarySearchTree.arrayToTree(numbers);
		System.out.println("dispplay: " + binarySearchTree.levelOrderQueue());

		binarySearchTree.arrayToTree2(numbers);
		System.out.println("dispplay2: " + binarySearchTree.levelOrderQueue());
	}
	
}
