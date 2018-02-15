package binaryTree;

import java.util.*;
import static binaryTree.BinaryTree.*;

public class BSTInorderIterator implements Iterator<Node>{

	Stack<Node> stack = new Stack<>();
	Node node;

	public BSTInorderIterator(Node root){
		node = root;
   		while(node != null){
   			//System.out.println("PUSH constructor: " + node.value);
   			stack.push(node);
   			node = node.left;
   		}
	}

	@Override
	public Node next(){
		node = stack.pop();
		//System.out.println("POP data return: " + node.value);
		if(node.right != null){
			Node nodeTemp = node.right;
			while(nodeTemp != null){
				//System.out.println("PUSH next(): " + node.value);
				stack.push(nodeTemp);
				nodeTemp = nodeTemp.left;
			}
		}
		return node;
	}

	@Override
	public boolean hasNext(){
		return stack.size() > 0;
	}	
}