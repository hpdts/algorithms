package interviewExposed;

import org.junit.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import java.util.*;

public class BinaryTreeTest {

	private BinaryTree binaryTree = new BinaryTree();

	@Before
    public void setUp() {
    	binaryTree.root = null;

    	/* Construct the following tree
              26
             /   \
            10     3
           /    \     \
          4      6      3
           \
            30  */
           
        binaryTree.root = new BinaryTree.Node(26);
        binaryTree.root.right = new BinaryTree.Node(3);
        binaryTree.root.right.right = new BinaryTree.Node(3);
        binaryTree.root.left = new BinaryTree.Node(10);
        binaryTree.root.left.left = new BinaryTree.Node(4);
        binaryTree.root.left.left.right = new BinaryTree.Node(30);
        binaryTree.root.left.right = new BinaryTree.Node(6);
    }

    @Test
    public void maxPath(){
    	int maxSumPath = binaryTree.findMaxSum();
    	assertThat(maxSumPath, is(76));
    }


}