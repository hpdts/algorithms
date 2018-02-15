package binaryTree;

import java.util.*;
import static binaryTree.BinaryTree.*;

public class BSTInorderIterator implements Iterator<Node>{

	Stack<Node> stack = new Stack<>();
	Node node;

	public BSTInorderIterator(Node root){
		node = root;
   		while(node != null){
   			stack.push(node);
   			node = node.left;
   		}
	}

	@Override
	public Node next(){
		node = stack.pop();
		System.out.println("data: " + node.value);
		if(node.right != null){
			node = node.right;
			while(node != null){
				stack.push(node);
				node = node.left;
			}
		}
		return node;
	}

	@Override
	public boolean hasNext(){
		return stack.size() > 0;
	}	
}