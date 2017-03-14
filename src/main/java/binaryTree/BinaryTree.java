package binaryTree;

import java.util.*;

public class BinaryTree {

	//not balanced
	public static class Node{
		Node left;
		Node right;
		int value;
		public Node(int value){
			this.value = value;
			left = null;
			right = null;
		}

		public String toString() {
        	return toString(0);
        }
		public String toString(int depth){
			StringBuilder sb = new StringBuilder();
			for(int i = 0; i < depth; i++) {
				sb.append("  ");
			}
			sb.append("num: ").append(value).append("\n");
			sb.append(left.toString(depth+1));
			sb.append(right.toString(depth+1));

			return sb.toString();
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
				stringBuilder.append(" " + n.value);
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

	public boolean bfs(Node node, int target){
		LinkedList<Node> queue = new LinkedList<>();
		Set<Integer> visited = new HashSet<>();
		queue.addFirst(node);
		while(!queue.isEmpty()){
			Node current = queue.removeFirst();
			if(!visited.contains(current)){
				visited.add(node.value);
				if(current.value == target){
					return true;
				}
				if(current.left != null){
					queue.addFirst(current.left);	
				}
				if(current.right != null){
					queue.addFirst(current.right);
				}
			}
		}
		return false;

	}

	public boolean dfs(Node node, int target){
		if(node == null){
			return false;
		}else if(node.value == target){
			return true;
		}else{
			return dfs(node.left, target) || dfs(node.right, target);
		}
	}
	
}
