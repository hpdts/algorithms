package binaryTree;

import java.util.*;
import static binaryTree.BinaryTree.*;
import org.junit.Test;

public class BSTInorderIteratorTest {

	@Test
	public void iterator(){
		 /*    8
		   /	   \    
		  3	       10
		 / \       / \
		1  6      13  14
	      / \       /   \
		  4  7	    5    1
		  */  

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

		BSTInorderIterator bSTInorderIterator = new BSTInorderIterator(root);

        while(bSTInorderIterator.hasNext()){
            Node node = bSTInorderIterator.next();
            if(node != null){
                System.out.println("bSTInorderIterator: " + node.value);
            }
        }
	}


}