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

        //response = btd.getNode(root, 0);
        //assertThat(response.value, is(23));
    	
    	
    }

    /**
    BST children on the left lower than father
    children on the right greater than father

              5,6
           /       \
          3,2       9,2
        /     \     /    \
        1,0   2,0   6,0   10,0
    **/
    @Test
    public void descendants(){
        Node root = new Node(5, 6);
        Node left = new Node(3, 2);
        Node right = new Node(9, 2);
        Node leftLeft = new Node(1, 0);
        Node leftRight = new Node(2, 0);
        Node rightLeft = new Node(6, 0);
        Node rightRight = new Node(10, 0);

        root.left = left;
        root.right = right;
        root.left.left = leftLeft;
        root.left.right = leftRight;
        root.right.left = rightLeft;
        root.right.right = rightRight;

      /*  Node node = btd.getKthNodeDescendant(root, 2);
        assertThat(node.value, is(2));
System.out.println("Second Test");
        //node = btd.getKthNodeDescendant(root, 0);
        //assertThat(node.value, is(1));
System.out.println("Thrid Test");
        node = btd.getKthNodeDescendant(root, 1);
        assertThat(node.value, is(1));
         //node = btd.getKthNodeDescendant(root, 3);
        //assertThat(node.value, is(3));*/

        Node node = btd.getKthNodeDescendant2(root, 1);
        assertThat(node.value, is(1));
        System.out.println("Second Test");
        node = btd.getKthNodeDescendant2(root, 2);
        assertThat(node.value, is(2));
        node = btd.getKthNodeDescendant2(root, 3);
        assertThat(node.value, is(3));
       // System.out.println("LAST Test");
        int nodeValue = btd.kthSmallest2(root, 3);
        assertThat(nodeValue, is(5));
        //nodeValue = btd.kthSmallest2(root, 1);
        //assertThat(nodeValue, is(1));
    }
}
