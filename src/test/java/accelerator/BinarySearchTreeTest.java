package accelerator;

import org.junit.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import java.util.*;

public class BinarySearchTreeTest {
	BinarySearchTree bst = new BinarySearchTree();

	@Test
    public void insert(){
    	bst.insert(5);
    	bst.insert(4);
    	bst.insert(2);
    	bst.insert(3);
    	bst.insert(1);
    	bst.insert(7);
    	bst.insert(8);
    	bst.insert(6);
    	bst.insert(9);
    	bst.insert(10);
    	bst.displayInOrder(bst.root);
    	bst.printTree(bst.root);
    	assertTrue(bst.search(10));
    	assertFalse(bst.search(-8));
    }

    @Test
    public void distance2Nodes(){
        System.out.println("LCA");
        bst.insert(5);
        bst.insert(4);
        bst.insert(2);
        bst.insert(3);
        bst.insert(1);
        bst.insert(7);
        bst.insert(8);
        bst.insert(6);
        bst.insert(9);
        bst.insert(10);
        bst.printTree(bst.root);
        int dist = bst.distance2Nodes(bst.root, 2, 7);
        assertThat(dist, is(4));
        dist = bst.distance2Nodes(bst.root, 2, 6);
        assertThat(dist, is(5));  
        dist = bst.distance2Nodes(bst.root, 6, 8);
        assertThat(dist, is(3));  
        //Inorder iteratively
        int k = bst.inOrderIteratively(bst.root, 2);
        assertThat(k, is(2));  
        k = bst.inOrderIteratively(bst.root, 6);
        assertThat(k, is(6));  
    }

    @Test
    public void average(){
        //check if in a binary tree each node’s value is equal to 
        //the average of its children
        /*   4.5
           /    \
           3    6
         /   \
         2   4
          \       
           2 */

        NodeDouble nodeDouble = new NodeDouble(4.5);
        NodeDouble nodeDoubleThree = new NodeDouble(3);
        NodeDouble nodeDoubleSix = new NodeDouble(6);
        NodeDouble nodeDoubleTwo = new NodeDouble(2);
        NodeDouble nodeDoubleFour = new NodeDouble(4);
        NodeDouble nodeDoubleTwoTwo = new NodeDouble(2);
            
        nodeDouble.left = nodeDoubleThree;
        nodeDouble.right = nodeDoubleSix;

        nodeDoubleThree.left = nodeDoubleTwo;
        nodeDoubleThree.right = nodeDoubleFour;

        nodeDoubleTwo.left = nodeDoubleTwoTwo;

        assertTrue(bst.checkAverage(nodeDouble));
    }

    //Average by level
    @Test
    public void levelAverage(){

         /*   4
           /    \
           7    9
         /   \    \
         10   2    6
               \       
                6
                /
                2 */
//nodesByLevel: {0=[4], 1=[7, 9], 2=[10, 2, 6], 3=[6], 4=[2]}
                // [4, 8, 6, 6, 2]
        TreeNode node4 = new TreeNode(4);
        TreeNode node7 = new TreeNode(7);
        TreeNode node9 = new TreeNode(9);
        TreeNode node10 = new TreeNode(10);
        TreeNode node2 = new TreeNode(2);
        TreeNode node61 = new TreeNode(6);
        TreeNode node21 = new TreeNode(2);
        TreeNode node62 = new TreeNode(6);

        node4.left = node7;
        node4.right = node9;

        node9.right = node61;

        node7.left = node10;
        node7.right = node2;

        node2.right = node62;
        node62.left = node21;

        int[] result = bst.checkAverageByLevel(node4);
        assertThat(result[1], is(8)); 
        assertThat(result[2], is(6)); 

        int[] result2 = bst.checkAverageByLevelBFS(node4);
        assertThat(result2[1], is(8)); 
        assertThat(result2[2], is(6)); 
        
    }

}