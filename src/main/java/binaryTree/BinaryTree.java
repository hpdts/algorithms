package binaryTree;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class BinaryTree {

	public static class Node{
		Node left;
		Node right;
		int value;
		public Node(int value){
			this.value = value;
			left = null;
			right = null;
		}
	}
	
	public void insert (Node node, int value){
		if(value < node.value){
			if (node.left != null){
				insert(node.left, value);
			}else {
				System.out.println("Inserted " + value + " to left of" + node.value);
				node.left = new Node(value);
			}
		} else if (value > node.value){
			if(node.right != null){
				insert(node.right, value);
			}else {
				System.out.println("Inserted " + value + " to right of" + node.value);
				node.right = new Node(value);
			}
		}
	}
	
	public void printInOrder(Node node){
		if(node != null){
			printInOrder(node.left);
			System.out.println(" Traversed " + node.value);
			printInOrder(node.right);
		}
		
	}
	
	public String DFS(Node root) {
		StringBuilder stringBuilder = new StringBuilder();
		Stack<Node> s = new Stack<Node>();
		s.add(root);
		while (s.isEmpty() == false) {
			Node node = s.pop();
			if(node.right != null){
				s.add(node.right);
			}
			if(node.left != null){
				s.add(node.left);			
			}
			stringBuilder.append(" " + node.value);
		}
		
		return stringBuilder.toString();
	}
	
	public List<String> DFSOnList(Node root) {
		List<String> nodes = new LinkedList<>();
		Stack<Node> s = new Stack<Node>();
		s.add(root);
		while (s.isEmpty() == false) {
			Node node = s.pop();
			if(node.right != null){
				s.add(node.right);
			}
			if(node.left != null){
				s.add(node.left);			
			}
			nodes.add(" " + node.value);
		}
		
		return nodes;
	}
	
}
