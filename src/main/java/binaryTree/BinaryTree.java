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

	public boolean isValidBST(Node root) {
    	return isValidBST(root, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);    
	}
	 
	public boolean isValidBST(Node p, double min, double max){
	    if(p == null) {
	        return true;
	    }
	 	System.out.println("p.value: " + p.value);
	 	System.out.println("min: " + min);
	 	System.out.println("max: " + max);
	    if(p.value <= min || p.value >= max){
	        return false;
	    }
	 
	    return isValidBST(p.left, min, p.value) && isValidBST(p.right, p.value, max);
	}
	
	public boolean validateBinarySearchTree2(Node node){
		if(node != null){
			printInOrder(node.left);
			System.out.println(" node.left.value " + node.left.value);
			System.out.println("< node.right.value " + node.right.value);
			if(node.left.value > node.right.value){
				return false;
			}
			System.out.println(" Traversed " + node.value);
			printInOrder(node.right);
		}
		return true;
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
	
	//Preorder
	/*Algorithm Preorder(tree)
   1. Visit the root.
   2. Traverse the left subtree, i.e., call Preorder(left-subtree)
   3. Traverse the right subtree, i.e., call Preorder(right-subtree) 
   */
	public void preOrder(Node node){
		if(node == null){
			return;
		}

		System.out.println("Value: " + node.value);
		preOrder(node.left);
		preOrder(node.right);
	}

	//PostOrder
	/*Algorithm PostOrder(tree)
   1. Traverse the left subtree, i.e., call Preorder(left-subtree)
   2. Traverse the right subtree, i.e., call Preorder(right-subtree) 
   3. Visit the root.
   */
   public void postOrder(Node node){
		if(node == null){
			return;
		}

		postOrder(node.left);
		postOrder(node.right);
		System.out.println("Value: " + node.value);
	}

	//InOrder
	/*Algorithm PostOrder(tree)
   1. Traverse the left subtree, i.e., call Preorder(left-subtree)
   3. Visit the root.
   2. Traverse the right subtree, i.e., call Preorder(right-subtree) 
   */
   public void inOrder(Node node){
		if(node == null){
			return;
		}

		inOrder(node.left);
		System.out.println("Value: " + node.value);
		inOrder(node.right);
	}
	/*
	Height is the number of nodes between the longest path from the root
	down to the farthest leaf node
	*/ 
    public int height(Node root){
    	if(root == null){
    		return 0;
    	}else{
    		int leftHeight = height(root.left);
    		int rightHeight = height(root.right);

	    	if(leftHeight > rightHeight){
	    		return (leftHeight + 1);
	    	}else{
	    		return (rightHeight + 1);
	    	}
	    }
    } 

    public void levelOrder(Node root){
    	int height = height(root);
    	for(int i=0; i <= height; i++){
    		printGivenLevel(root, i);
    	}
    } 

    public void printGivenLevel(Node root, int level){
    	if(root == null){
    		return;
    	}
    	if(level == 1){
    		System.out.print(root.value + " ");
    	}else if(level > 1){
    		printGivenLevel(root.left, level -1);
    		printGivenLevel(root.right, level -1);
    	}
    }


}
