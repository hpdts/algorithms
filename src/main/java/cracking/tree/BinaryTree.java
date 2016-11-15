package cracking.tree;

import java.util.*;

public class BinaryTree {
	private Map<Node, Integer> memory = new HashMap<>();

	public static class Node{
		int number;

		Node left;
		Node right;

		public Node(int number){
			this.number = number;
			left = right = null;
		}
	}


	public void add(Node node, int number){
		//instance root on test
		if(number < node.number){
			if(node.left != null){
				add(node.left, number);
			}else{
				node.left = new Node(number);
			}
		}else if(node.right != null){
				add(node.right, number);
			}else {
				node.right = new Node(number);
			}
	}

	public void printInOrder(Node node){
		if(node != null){
			printInOrder(node.left);
			System.out.println("Traversed " + node.number);
			printInOrder(node.right);
		}
	}

	public String levelOrderQueue(Node root){
		StringBuilder stringBuilder = new StringBuilder();
 		Queue<Node> q = new LinkedList<>();
 		int levelNodes =0; 
		
		if(root == null){
			return null;
		}

 		q.add(root);

 		while(!q.isEmpty()){
 			levelNodes = q.size();

 			while(levelNodes > 0){
				Node n = q.remove();
				stringBuilder.append(" " + n.number);
				if(n.left != null){
					q.add(n.left);	
				} 
				if(n.right != null){
					q.add(n.right);	
				} 
				levelNodes--;
			}

			stringBuilder.append(System.getProperty("line.separator"));
		}
		return stringBuilder.toString();
	}
	
	//The height of a tree is the length of the path from the root to the deepest node in the tree. 
	//A (rooted) tree with only a node (the root) has a height of zero

	public int findHeight(Node aNode) {
	    if (aNode == null) {
	        return -1;
	    }

	    int lefth = findHeight(aNode.left);
	    int righth = findHeight(aNode.right);

	    if (lefth > righth) {
	        return lefth + 1;
	    } else {
	        return righth + 1;
	    }
	}


	public int height(Node root) {
		// if the node is null then it returns the height as -1
		int heightOfNode;
		if (root == null) {
			return -1;
		}
		if (memory.containsKey(root)) {
			return memory.get(root);
		}

		int leftHeight, rightHeight;
		leftHeight = height(root.left);
		rightHeight = height(root.right);
		// finds the height of left subtree and right subtree and returns
		// the max of both + 1
		heightOfNode = Math.max(leftHeight, rightHeight) + 1;
		memory.put(root, heightOfNode);
		return heightOfNode;
	}

	public boolean isBalanced(Node root) {
		if (root == null) {
			return true;
		}
		int leftHeight, rightHeight;
		leftHeight = height(root.left);
		rightHeight = height(root.right);
		// if left child and right child are balanced and the difference in
		// their heights is  <  2
		// then it is balanced
		if (isBalanced(root.left) && isBalanced(root.right) &&  Math.abs(leftHeight - rightHeight)  <  2) {
			return true;
		}
		return false;
	}
	//Height balance tree: 
	//For all nodes of the tree, absolute difference between heights of left sub-tree and right sub-tree 
	//is not greater than 1

	public int getHeight(Node root) {
		if (root == null){
			return 0; // Base case
		} 	
		return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
	}

	public  boolean checkBalanced(Node root) {
		if (root == null){
			return true; // Base case
			
		} 
		 int heightDiff = getHeight(root.left) - getHeight(root.right);
		 if (Math.abs(heightDiff) > 1) {
		 	return false;
		 } else { // Recurse
		 	return isBalanced(root.left) && isBalanced(root.right);
		 }
	}

	public static int checkHeight(Node root) {
 		if (root == null) {
 			return 0; // Height of 0
 		}

		 /* Check if left is balanced. */
		int leftHeight = checkHeight(root.left);
		if (leftHeight == -1) {
			return -1; // Not balanced
 		}

 		/* Check if right is balanced. */
 		int rightHeight = checkHeight(root.right);
 		if (rightHeight == -1) {
 			return -1; // Not balanced
 		}

 		/* Check if current node is balanced. */
 		int heightDiff = leftHeight - rightHeight;
 		if (Math.abs(heightDiff) > 1) {
 			return -1; // Not balanced
 		} else {
 			/* Return height */
 			return Math.max(leftHeight, rightHeight) + 1;
 		}
 	}

 	public static boolean isBalancedBook(Node root) {
 		if (checkHeight(root) == -1) {
 			return false;
 		} else {
 			return true;
 		}
 	}

}

