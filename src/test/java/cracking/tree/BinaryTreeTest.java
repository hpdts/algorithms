package cracking.tree;

import org.junit.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import java.util.*;


public class BinaryTreeTest {

    private BinaryTree binaryTree = new BinaryTree();


    @Test
    public void add(){
        BinaryTree.Node root = new BinaryTree.Node(5);
        binaryTree.add(root, 34);
        binaryTree.add(root, 3);
        binaryTree.add(root, 31);
        binaryTree.add(root, 100);
        binaryTree.add(root, 1);
    	binaryTree.printInOrder(root);
        System.out.println(binaryTree.levelOrderQueue(root));
        System.out.println("height: " + binaryTree.findHeight(root));
        System.out.println("height left: " + binaryTree.findHeight(root.left));
        System.out.println("height right: " + binaryTree.findHeight(root.right));

        assertTrue(binaryTree.isBalanced(root));
    }

     @Test
    public void add2(){
        BinaryTree.Node root = new BinaryTree.Node(5);
        BinaryTree.Node left1 = new BinaryTree.Node(50);
        BinaryTree.Node left2 = new BinaryTree.Node(100);
        left1.left = left2;
        root.left = left1;

        binaryTree.printInOrder(root);

        assertFalse(binaryTree.checkBalanced(root));
    }

    @Test
    public void isBalancedBook(){
        BinaryTree.Node root = new BinaryTree.Node(5);
        binaryTree.add(root, 34);
        binaryTree.add(root, 3);
        binaryTree.add(root, 31);
        binaryTree.add(root, 100);
        binaryTree.add(root, 1);
        binaryTree.printInOrder(root);
        assertTrue(binaryTree.isBalancedBook(root));
    }
}