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
		if(number < node.number){
			node.left = add(node.left, number);
		}else {
			node.right = add(node.right, number);
		}
		return node;
	}

	public Node createMinimalBST(int arr[], int start, int end) {
		if (end < start) {
			return null;
		}

		int mid = (start + end) / 2;
		Node n = new Node(arr[mid]);
		n.left = createMinimalBST(arr, start, mid - 1);
		n.right = createMinimalBST(arr, mid + 1, end);
		return n;
	 }
	
	 public void createMinimalBST(int array[]) {
	 	root = createMinimalBST(array, 0, array.length - 1);
	 }

	 public void printInOrder(Node node){
		if(node != null){
			printInOrder(node.left);
			System.out.println(" Traversed " + node.number);
			printInOrder(node.right);
		}
		
	}

	public List<List<Integer>> treeByLevel(){
 		List<List<Integer>> levels = new ArrayList<List<Integer>>();
  		Queue<Node> queue = new LinkedList<>();
 		queue.add(root);

 		List<Integer> level = new ArrayList<>();
 		int levelNodes = 0;
 		while(queue.size() > 0){
 			levelNodes = queue.size();
 			level = new ArrayList<>();
 			while(levelNodes > 0){
	 			Node current = queue.remove();
	 			level.add(current.number);
	 			if(current.left != null){
	 				queue.add(current.left);
	 			}

	 			if(current.right != null){
	 				queue.add(current.right);
	 			}
	 			levelNodes--;
	 		}
	 		levels.add(level);
 		}

 		return levels;

 	}

 	public void createLevelLinkedList(Node root, ArrayList<LinkedList<Node>> lists, int level) {
		if (root == null) {
			return; // base case
		}

		LinkedList<Node> list = null;

 		if (lists.size() == level) { // Level not contained in list
			list = new LinkedList<Node>();
			/* Levels are always traversed in order. So., if this is the
			* first time we've visited level i, we must have seen levels
			* 0 through i - 1. We can therefore safely add the level at
			* the end. */
		 	lists.add(list);
		 } else {
		 	list = lists.get(level);
		 }

		 list.add(root);
		 createLevelLinkedList(root.left, lists, level + 1);
		 createLevelLinkedList(root.right, lists, level + 1);
	}
		
	public ArrayList<LinkedList<Node>> createLevelLinkedList() {
		ArrayList<LinkedList<Node>> lists = new ArrayList<LinkedList<Node>>();
		createLevelLinkedList(root, lists, 0);
		return lists;
	}

	public ArrayList<LinkedList<Node>> createLevellinkedListBFS(Node root) {
 		ArrayList<LinkedList<Node>> result = new ArrayList<LinkedList<Node>>();
 		/* "Visit" the root */
 		LinkedList<Node> current = new LinkedList<Node>();
		if (root != null) {
			current.add(root);
		}

 		while (current.size() > 0) {
 			result.add(current); // Add previous level
 			LinkedList<Node> parents = current; // Go to next level
 			current = new LinkedList<Node>();
 			for (Node parent : parents) {
 				/* Visit the children */
 				if (parent.left != null) {
 					current.add(parent.left);
 				}
 				if (parent.right != null) {
 					current.add(parent.right);
 				}
 			}
 		}
 		return result;
 	}

 	public boolean isBST(){
        return isBSTUtil(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
 
    /* Returns true if the given tree is a BST and its
      values are >= min and <= max. */
    boolean isBSTUtil(Node node, int min, int max)
    {
        /* an empty tree is BST */
        if (node == null){
            return true;
        }
 
        /* false if this node violates the min/max constraints */
        if (node.number < min || node.number > max){
            return false;
        }
 
        /* otherwise check the subtrees recursively
        tightening the min/max constraints */
        // Allow only distinct values
        return (isBSTUtil(node.left, min, node.number) && isBSTUtil(node.right, node.number, max));
    }

    public static int index = 0;

    public static void copyBST(Node root, int[] array) {
    	if (root == null){
    		return;	
    	} 
     	copyBST(root.left, array);
		array[index] = root.number;
 		index++;
		copyBST(root.right, array);
 	}

 	public static boolean checkBST(Node root) {
 		int[] array = new int[7];
 		copyBST(root, array);
 		for (int i = 1; i < array.length; i++) {
 			if (array[i] <= array[i - 1]){
 				return false;	
 			} 
 		}
 		return true;
 	}

	public static int last_printed = Integer.MIN_VALUE;
 	public static boolean checkBST2(Node n) {
		if (n == null){
			return true;
		} 

		if (!checkBST2(n.left)){
			return false;	
		} 

		// Check current
		if (n.number <= last_printed){
			return false;
		} 

		last_printed = n.number;

 		// Check / recurse right
 		if (!checkBST2(n.right)){
 			return false;	
 		} 

 		return true; // All good!
 	}

 	boolean checkBSTBook(Node n) {
 		return checkBSTBook(n, Integer.MIN_VALUE, Integer.MAX_VALUE);
 	}

 	boolean checkBSTBook(Node n, int min, int max) {
 		if (n == null) {
			return true;
		}
		if (n.number <= min || n.number > max) {
 			return false;
 		}

 		return checkBSTBook(n.left, min, n.number) && checkBSTBook(n.right, n.number, max);
 	}

}

