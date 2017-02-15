package binaryTree;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinarySearchTreeDistance {

	public static class Node{
		int number;
		Node left;
		Node right;

		public Node(int number){
			this.number = number;
			left = null;
			right = null;
		}

		public String toString(){
			return "number : " + number + ", left: " + left + ", right: " + right;
		}

		public boolean equals(Node node) {
        	return (this.number == node.number);
    	}
	}

	public void insert(Node node, int number){

		if(number < node.number){
			if(node.left == null){
				node.left = new Node(number);
			}else{
				insert(node.left, number);
			}
		}else if(number > node.number){
			if(node.right == null){
				node.right = new Node(number);
			}else{
				insert(node.right, number);
			}
		}

	}

	public void postOrder(Node root){
		if(root != null){
			postOrder(root.left);
			postOrder(root.right);
		}
	}

	public Node lowestCommonAncestor(Node root, Node nodeFrom, Node nodeTo){
		if(root == null){
			return null;
		}
		if(root.number > nodeFrom.number && root.number > nodeTo.number){
			return lowestCommonAncestor(root.left, nodeFrom, nodeTo);
		}

		if(root.number < nodeFrom.number && root.number < nodeTo.number){
			return lowestCommonAncestor(root.right, nodeFrom, nodeTo);
		}

		return root;
	}


	public int distance(Node root, Node nodeFrom, Node nodeTo){
		LinkedList<Node> path = new LinkedList<>();
		Node commonAncestor = lowestCommonAncestor(root, nodeFrom, nodeTo);
		Node current = commonAncestor;
		while(current != null && !current.equals(nodeFrom)){
			if(current.number > nodeFrom.number){
				current = current.left;
			}else{
				current = current.right;
			}
			path.addFirst(current);
		}
		current = commonAncestor;
		while(current != null && !current.equals(nodeTo)){
			if(current.number > nodeTo.number){
				current = current.left;
			}else{
				current = current.right;
			}
			path.addLast(current);
		}
		return path.size();
	}


}