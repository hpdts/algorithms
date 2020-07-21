package accelerator;

import org.junit.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import java.util.*;
import static accelerator.BinaryTreeDescendants.*;

public class BinaryTreeDescendantsTest {
	BinaryTreeDescendants btd = new BinaryTreeDescendants();

/*
       10 d6
      /             \
     12d2           34d2         //count 0 d 2 max count + descendents + 1

    /   \           /    \
   23d0 45d0       89d0   7d0

   23 12 45 10 34 89 7
   */ 
	@Test
    public void nthElementInOrderNull(){
    	Node root = new Node(10, 6);
    	Node left = new Node(12, 2);
    	Node right = new Node(34, 2);
    	Node leftLeft = new Node(23, 0);
    	Node leftRight = new Node(45, 0);
    	Node rightLeft = new Node(89, 0);
    	Node rightRight = new Node(7, 0);

    	Node response = btd.inorderNode(root, 3);
    	assertNull(response);
    }

    @Test
    public void nthElementInOrder(){
    	Node root = new Node(10, 6);
    	Node left = new Node(12, 2);
    	Node right = new Node(34, 2);
    	Node leftLeft = new Node(23, 0);
    	Node leftRight = new Node(45, 0);
    	Node rightLeft = new Node(89, 0);
    	Node rightRight = new Node(7, 0);

    	root.left = left;
    	root.right = right;
    	root.left.left = leftLeft;
    	root.left.right = leftRight;
    	root.right.left = rightLeft;
    	root.right.right = rightRight;

    	btd.inOrderIterative(root);
    	
    	Node response = btd.inorderNode(root, 3);
    	assertThat(response.value, is(10));

    	//btd.helperInOrderNoMemory(root, 3);
    	//assertThat(btd.getNodeIndex().value, is(10));

    	btd.helperInOrderNoMemory(root, 0);
    	//assertThat(btd.getNodeIndex().value, is(23));
    	Node res = btd.kthSmallest(root, 0);
    	assertThat(res.value, is(23));

		response = btd.getNode(root, 3);
    	assertThat(response.value, is(10));
    	
    	
    }
}