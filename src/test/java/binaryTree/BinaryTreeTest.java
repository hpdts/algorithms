package binaryTree;

import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


public class BinaryTreeTest {

	private BinaryTree binaryTree = new BinaryTree();
	
	@Test
	public void creatingTree(){
		BinaryTree.Node root = new BinaryTree.Node(3);
		binaryTree.insert(root, 2);
		binaryTree.insert(root, 10);
		binaryTree.insert(root, 8);
		
		binaryTree.printInOrder(root);
		
		assertThat(binaryTree.DFS(root), is(" 3 2 10 8"));
		assertThat(binaryTree.DFSOnList(root).toString(), is("[ 3,  2,  10,  8]"));
	}
	
}
