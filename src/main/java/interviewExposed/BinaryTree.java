package interviewExposed;

import java.util.*;
import java.util.Arrays;
import java.util.stream.Collectors;



public class BinaryTree{
	// Root of the Binary Tree 
    Node root; 

	public static class Node{
		int data;
		Node left,right;

		public Node(int data){
			this.data = data;
			left = right = null;
		}
	}

	class Res{
		public int val;
	}
  
    // This function returns overall maximum path sum in 'res' 
    // And returns max path sum going through root. 
    private int findMaxUtil(Node node, Res res) 
    { 
        // Base Case 
        if (node == null) {
            return 0; 
        }
    	System.out.println("Node: " + node.data);
  		
        // l and r store maximum path sum going through left and 
        // right child of root respectively 
        int leftMax = findMaxUtil(node.left, res); 
  		System.out.println("leftMax: " + leftMax);
        int rightMax = findMaxUtil(node.right, res); 
  		System.out.println("rightMax: " + rightMax);
        // Max path for parent call of root. This path must 
        // include at-most one child of root 
        int max_single = Math.max(Math.max(leftMax, rightMax) + node.data, 
                                  node.data); 
  
  		System.out.println("max_single: " + max_single);
        // Max Top represents the sum when the Node under 
        // consideration is the root of the maxsum path and no 
        // ancestors of root are there in max sum path 
        int max_top = Math.max(max_single, leftMax + rightMax + node.data); 
  		System.out.println("max_top: " + max_top);
        // Store the Maximum Result. 
        res.val = Math.max(res.val, max_top); 
  
        return max_single; 
    } 

    public int findMaxSum() { 
        return findMaxSum(root); 
    } 
  
    // Returns maximum path sum in tree with given root 
    private int findMaxSum(Node node) { 
  
        // Initialize result 
        // int res2 = Integer.MIN_VALUE; 
        Res res = new Res(); 
        res.val = Integer.MIN_VALUE; 
  
        // Compute and return result 
        findMaxUtil(node, res); 
        return res.val; 
    } 
}