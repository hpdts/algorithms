package binaryTree;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.Queue;

public class ExpressionTree {

	//not balanced
	public static class Node{
		Node left;
		Node right;
		char value;
		public Node(char value){
			this.value = value;
			left = null;
			right = null;
		}
	}
	
	boolean isOperator(char operator){
		if( operator == '=' || operator == '-' || operator == '*' || operator == '/' || operator == '^'){
			return true;
		}
		return false;
	}


	void inOrder(Node node){
		if(node != null){
			inOrder(node.left);
			System.out.println(node.value + " ");
			inOrder(node.right);
		}
	}


	Node constructTree(char postFix[]){
		Stack<Node> stack = new Stack<>();
		Node node, nodeTemporary1, nodeTemporary2;

		for(int i = 0; i < postFix.length ; i++){
			if(!isOperator(postFix[i])){
				node = new Node(postFix[i]);
				stack.push(node);
			}else{
				node = new Node(postFix[i]);
				nodeTemporary1 = stack.pop();
				nodeTemporary2 = stack.pop();
				node.right = nodeTemporary1;
				node.left = nodeTemporary2;
				stack.push(node);
			}
		}
		node = stack.peek();
		stack.pop();

		return node;
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

	
	
}
