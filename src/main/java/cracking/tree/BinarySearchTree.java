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

 	public boolean checkBSTBook(Node n) {
 		return checkBSTBook(n, Integer.MIN_VALUE, Integer.MAX_VALUE);
 	}

 	public boolean checkBSTBook(Node n, int min, int max) {
 		if (n == null) {
			return true;
		}
		if (n.number <= min || n.number > max) {
 			return false;
 		}

 		return checkBSTBook(n.left, min, n.number) && checkBSTBook(n.right, n.number, max);
 	}

	public void displayInOrder(Node root){
		if(root != null){
			displayInOrder(root.left);
			System.out.println(" " + root.number);
			displayInOrder(root.right);
		}
	}

	public void displayPostOrder(Node root){
		if(root != null){
			displayPostOrder(root.left);
			displayPostOrder(root.right);
			System.out.println(" " + root.number);
		}
	}

	public Node inOrderSuccessor(Node root, Node node){
		// step 1 of the above algorithm
	    if( node.right != null ){
	        return minValue(node.right);
	    }
	 
	 	Node succ = null;
	    // Start from root and search for successor down the tree
	    while (root != null)
	    {
	        if (node.number < root.number)
	        {
	            succ = root;
	            root = root.left;
	        }else if (node.number > root.number){
	            root = root.right;
	        }else {
	           break;
	        }
	    }
	 
	    return succ;
	}

	/* Given a non-empty binary search tree, return the minimum data  
     value found in that tree. Note that the entire tree does not need
     to be searched. */
    public Node minValue(Node node) {
        Node current = node;
 
        /* loop down to find the leftmost leaf */
        while (current.left != null) {
            current = current.left;
        }
        return current;
    }

    public Node firstCommonAncestor(Node node1, Node node2){
    	List<Node> path1 = pathToNodeBFS(node1);
    	List<Node> path2 = pathToNodeBFS(node2);
   	
    	path1.retainAll(path2);
    	return path1.get(0);
    }

    public List<Node> pathToNodeBFS(Node node){
    	List<Node> path = new ArrayList<>();
    	Queue<Node> queue = new LinkedList<>();
    	if(root != null){
    		queue.add(root);
    	}

    	while(queue.size() > 0){
    		Node current = queue.remove();

    		if(current.number == node.number){
    			break;
    		}else{
    			path.add(current);
    		}

    		if(current.left != null){
    			queue.add(current.left);
    		}

    		if(current.right != null){
    			queue.add(current.right);
    		}
    	}
    	return path;
    }
 

 	public Node findLCA(int n1, int n2){
        return findLCA(root, n1, n2);
    }
 
    // This function returns pointer to LCA of two given
    // values n1 and n2. This function assumes that n1 and
    // n2 are present in Binary Tree
    public Node findLCA(Node node, int n1, int n2){
        // Base case
        if (node == null){
            return null;
        }
 
        // If either n1 or n2 matches with root's key, report
        // the presence by returning root (Note that if a key is
        // ancestor of other, then the ancestor key becomes LCA
       
        if (node.number == n1 || node.number == n2){
            return node;
        }
 
        // Look for keys in left and right subtrees
        Node left_lca = findLCA(node.left, n1, n2);
        Node right_lca = findLCA(node.right, n1, n2);
 
        // If both of the above calls return Non-NULL, then one key
        // is present in once subtree and other is present in other,
        // So this node is the LCA
        if (left_lca!=null && right_lca!=null){
            return node;
        }
 
        // Otherwise check if left subtree or right subtree is LCA
        return (left_lca != null) ? left_lca : right_lca;
    }


    /* Returns true if p is a descendent of root */
	public boolean covers(Node root, Node p) {
		if (root == null){
			return false;	
		} 
		if (root.number == p.number){
			return true;	
		} 		
		return covers(root.left, p) || covers(root.right, p);

	}
	
	public Node commonAncestorHelper(Node root, Node p, Node q) {
	 	if (root == null) {
			return null;
		}
	 	if (root.number == p.number || root.number == q.number){
	 		return root;	
	 	} 
		
	 	boolean is_p_on_left = covers(root.left, p);
	 	boolean is_q_on_left = covers(root.left, q);

	 	/* If p and q are on different sides, return root. */
	 	if (is_p_on_left != is_q_on_left){
	 		return root;	
	 	} 
		
	 	/* Else, they are on the same side. Traverse this side. */
	 	Node child_side = is_p_on_left ? root.left : root.right;
	 	return commonAncestorHelper(child_side, p, q);
	 }
	
	 public Node commonAncestor(Node root, Node p, Node q) {
		if (!covers(root, p) || !covers(root, q)) { // Error check
		 	return null;
		}

	 	return commonAncestorHelper(root, p, q);
	 }

	public boolean areIdentical(Node root1, Node root2) 
    {
  
        /* base cases */
        if (root1 == null && root2 == null){
        	System.out.println("root1 == null && root2 == null");
            return true;
        }

        System.out.println("root1: " + root1.number + " root2: " + root2.number);
  
        if (root1 == null || root2 == null){
        	System.out.println("root1 == null || root2 == null");
            return false;
        }
  
        /* Check if the data of both roots is same and data of left and right
           subtrees are also same */
        return (root1.number == root2.number
                && areIdentical(root1.left, root2.left)
                && areIdentical(root1.right, root2.right));
    }
  
    /* This function returns true if S is a subtree of T, otherwise false */
    public boolean isSubtree(Node T, Node S) 
    {
        /* base cases */
        if (S == null) {
            return true;
        }
  
        if (T == null){
            return false;
        }
  
        /* Check the tree with root as current node */
        if (areIdentical(T, S)) {
            return true;
        }
  
        /* If the tree with root as current node doesn't match then
           try left and right subtrees one by one */
        return isSubtree(T.left, S)
                || isSubtree(T.right, S);
    }


    public boolean containsTree(Node t1, Node t2) {
		if (t2 == null) { // The empty tree is always a subtree
 			return true;
 		}
		return subTree(t1, t2);
	}

	public boolean subTree(Node r1, Node r2) {
		if (r1 == null) {
 			return false; 
 		}
 		if (r1.number == r2.number) {
			if (matchTree(r1, r2)){
				return true;
			} 
		}
		return subTree(r1.left, r2) || subTree(r1.right, r2);
	}

	public boolean matchTree(Node r1, Node r2) {
		if (r2 == null && r1 == null){
			return true; // nothing left in the subtree
		} // if both are empty
		

		// if one, but not both, are empty
		if (r1 == null || r2 == null) {
			return false;
		}

		if (r1.number != r2.number){
			return false; // data doesn't match
		}
		
		return matchTree(r1.left, r2.left) && matchTree(r1.right, r2.right);
	}

	public boolean hasPathSum(Node root, int sum) {
		if (root == null){
			System.out.println("here");
			return false;
		}
		System.out.println("root.number: " + root.number  + ", sum: " + sum);

		if (root.number == sum && (root.left == null && root.right == null)){
			return true;
		}
 	
		return hasPathSum(root.left, sum - root.number) || hasPathSum(root.right, sum - root.number);
	}


	public void findSum(Node node, int sum, int[] path, int level) {
		if (node == null) {
 			return;
 		}

		 /* Insert current node into path. */
		path[level] = node.number;
		
		/* Look for paths with a sum that ends at this node. */
		 int t = 0;
		for (int i = level; i >= 0; i--){
		 	t += path[i];
		 	if (t == sum) {
		 		print(path, i, level);
		 	}
		}
		
		 /* Search nodes beneath this one. */
		 findSum(node.left, sum, path, level + 1);
		 findSum(node.right, sum, path, level + 1);
		
		 /* Remove current node from path. Not strictly necessary, since
		 * we would ignore this value, but it's good practice. */
		 path[level] = Integer.MIN_VALUE;
	}
		
	public void findSum(Node node, int sum) {
		 int depth = depth(node);
		 int[] path = new int[depth];
		 findSum(node, sum, path, 0);
	}
		
	public static void print(int[] path, int start, int end) {
		 for (int i = start; i <= end; i++) {
		 	System.out.print("Sum path:" + path[i] + " ");
		 }
		 	System.out.println();
	}
		
	public int depth(Node node) {
		 if (node == null) {
		 	return 0;
		 } else {
		 	return 1 + Math.max(depth(node.left), depth(node.right));
		 }
	}

	//max on inorder
	public int maxInorder(Node root){
		if(root == null){
			return Integer.MIN_VALUE;
		}

		int result = root.number;
		int resultLeft = maxInorder(root.left);
		int resultRight = maxInorder(root.right);
		if(resultLeft > result){
			result = resultLeft;
		}
		if(resultRight > result){
			result = resultRight;
		}
		return result;
	}

}

