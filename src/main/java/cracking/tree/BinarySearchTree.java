package cracking.tree;

import java.util.*;

public class BinarySearchTree {
	Node root;

	public static class Node{
		int number;

		Node left;
		Node right;

		public Node(int number){
			this.number = number;
			left = right = null;
		}
	}

	public void arrayToTree(int[] sortedNumbers){
		for(int number : sortedNumbers){
			root = add(root, number);
		}

	}

	public Node add(Node node, int number){
		if(node == null){
			return new Node(number);
		}
		System.out.println("number: " + number);
		if(number < node.number){
			node.left = add(node.left, number);
		}else {
			node.right = add(node.right, number);
		}
		return node;
	}

	public void arrayToTree2(int[] sortedNumbers){
		for(int number : sortedNumbers){
			add2(root, number);
		}

	}

	public void add2(Node node, int number){
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

	public String levelOrderQueue(){
		StringBuilder stringBuilder = new StringBuilder();
 		Queue<Node> q = new LinkedList<>();
 		int levelNodes =0; 
		
		if(root == null){
			return null;
		}

 		q.add(root);

 		while(!q.isEmpty()){
 			levelNodes = q.size();
 			System.out.println("levelNodes: "+ levelNodes);
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

}

