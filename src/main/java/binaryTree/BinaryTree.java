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
        	//return "value : " + value + ", left: " + left + ", right: " + right;
        }
		public String toString(int depth){
			StringBuilder sb = new StringBuilder();
			for(int i = 0; i < depth; i++) {
				sb.append("  ");
			}
			sb.append("num: ").append(value).append("\n");
			if(left != null){
				sb.append(left.toString(depth+1));
			}
			if(right != null){
				sb.append(right.toString(depth+1));
			}

			return sb.toString();
		}

	}
	
	public static class ListNode {
		int val;
		ListNode next;
	 
		ListNode(int x) {
			val = x;
			next = null;
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

	public boolean isValidBST2(Node root) {
        if(root == null){
            return true;
 		}

        LinkedList<Node> queue = new LinkedList<Node>();
        queue.offer(root);
        while(!queue.isEmpty()){
            Node temp = queue.poll();
            System.out.println("temp: " + temp.value);
            if(temp.left != null){
            	if(temp.value < temp.left.value){
                	return false;
        		}
            }
            if(temp.right != null){
            	if(temp.value > temp.right.value){
                	return false;
        		}
            }
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
	/*Algorithm inOrder(tree)
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


    public Node invertTree(Node root) {
	    if (root == null) {
	        return null;
	    }
	    Node right = invertTree(root.right);
	    Node left = invertTree(root.left);
	    root.left = right;
	    root.right = left;
    	return root;
	}

	//traverse always with queue
	public Node invertTreeIterative(Node root) {
	    if (root == null){
	    	return null;	
	    } 
	    Queue<Node> queue = new LinkedList<Node>();
	    queue.add(root);
	    while (!queue.isEmpty()) {
	        Node current = queue.poll();
	        Node temp = current.left;
	        current.left = current.right;
	        current.right = temp;
	        if (current.left != null){
	        	queue.add(current.left);
	        } 
	        if (current.right != null){
	        	queue.add(current.right);
	        } 
	    }
	    return root;
	}

	public Integer findKthSmallestElement(Node root, int k){
		List<Integer> inOrderNodes = new ArrayList<>();
	    getInorderList(root, inOrderNodes);
	    // ordered collection list
	    //System.out.println("List: " + inOrderNodes);
	    return inOrderNodes.get(k-1);
	}

	public void getInorderList(Node root, List<Integer> inOrderNodes){
		if(root == null){
			return;
		}
		getInorderList(root.left, inOrderNodes);
		inOrderNodes.add(root.value);
		//System.out.println("Node : " + root.value);
		getInorderList(root.right, inOrderNodes);
	}

	public int kthSmallest(Node root, int k) {
	    Stack<Node> stack = new Stack<Node>();
	 
	    Node p = root;
	    int result = 0;
	 
	    while(!stack.isEmpty() || p!=null){
	        if(p != null){
	            stack.push(p);
	            p = p.left;
	        }else{
	            Node t = stack.pop();
	            System.out.println("Node : " + t.value);
	            k--;
	            if(k==0){
	            	result = t.value;
	            }
	            p = t.right;
	        }
	    }
	 
	    return result;
	}

	public int kthSmallest2(Node root, int k) {
	    Stack<Node> stack = new Stack<Node>();
	    Node p = root;
	    while(p!=null){
	        stack.push(p);
	        p=p.left;
	    }
	    int i=0;
	    while(!stack.isEmpty()){
	        Node t = stack.pop();
	        i++;
	 
	        if(i == k){
	            return t.value;
	 		}

	        Node r = t.right;
	        while(r != null){
	            stack.push(r);
	            r = r.left;
	        }
	    }
	    return -1;
	}

	
	int max = 1;

	public int longestConsecutive(Node root) {
		helper(root, 1);
		return max;
	}
	
	private void helper(Node root, int count) {
		
		if(root == null) return;
		
		max = Math.max(count, max);
		
		if(root.left != null){
			//System.out.println("left: " + root.left.value + ", count: " + count);	
			helper(root.left, (root.value + 1 == root.left.value) ? count + 1 : 1);
		}

		if(root.right != null){
			helper(root.right, (root.value + 1 == root.right.value) ? count + 1 : 1);
		}
	}

	public int longestConsecutiveIterative(Node root) {
	    if(root==null)
	        return 0;
	 
	    LinkedList<Node> nodeQueue = new LinkedList<Node>();
	    LinkedList<Integer> sizeQueue = new LinkedList<Integer>();
	 
	    nodeQueue.offer(root);
	    sizeQueue.offer(1);
	    int max=1;
	 
	    while(!nodeQueue.isEmpty()){
	        Node head = nodeQueue.poll();
	        int size = sizeQueue.poll();
	 		System.out.println("head: " + head + ", size: " + size);

	        if(head.left != null){
	            int leftSize = size;
	            if(head.value == head.left.value-1){
	                leftSize++;
	                max = Math.max(max, leftSize);
	            }else{
	                leftSize = 1;
	            }
	 
	            nodeQueue.offer(head.left);
	            sizeQueue.offer(leftSize);
	        }
	 
	        if(head.right != null){
	            int rightSize = size;
	            if(head.value == head.right.value-1){
	                rightSize++;
	                max = Math.max(max, rightSize);
	            }else{
	                rightSize=1;
	            }
	 
	            nodeQueue.offer(head.right);
	            sizeQueue.offer(rightSize);
	        }
	 
	 
	    }
	 
	    return max;
	}

	public List<Integer> flattenBinaryIterative(Node root){
		List<Integer> numbers = new ArrayList<>();
		Stack<Node> stackNodes = new Stack<>();
		stackNodes.push(root);

		while(!stackNodes.isEmpty()){
			Node temp = stackNodes.pop();
			
			if(temp.right != null){
				stackNodes.add(temp.right);
			}

			if(temp.left != null){
				stackNodes.add(temp.left);
			}
			numbers.add(temp.value);
			System.out.println("temp: " + temp.value);
		}
		System.out.println("numbers: " + numbers);

		return numbers;
	}

	public List<Integer> flattenBinary(Node root){
		List<Integer> numbers = new ArrayList<>();
		flattenBinary(root, numbers);
		System.out.println("Recursive numbers: " + numbers);
		return numbers;
	}

	public void flattenBinary(Node root, List<Integer> numbers){
		if(root == null){
			return;
		}
		numbers.add(root.value);
		if(root.right != null){
			flattenBinary(root.right, numbers);
		}
		if(root.left != null){
			flattenBinary(root.left, numbers);
		}
	}

	public void flatten(Node root) {
        Stack<Node> stack = new Stack<Node>();
        Node p = root;
 
        while(p != null || !stack.empty()){
 			System.out.println("p: " + p.value);
            if(p.right != null){
                stack.push(p.right);
            }
 
            if(p.left != null){
                p.right = p.left;
                p.left = null;
            }else if(!stack.empty()){
                Node temp = stack.pop();
                p.right = temp;
                System.out.println("p empty: " + p);
            }
 
            p = p.right;
        }

    }

    public boolean hasPathSum(Node root, int sum) {
        if(root == null) return false;
 
        LinkedList<Node> nodes = new LinkedList<Node>();
        LinkedList<Integer> values = new LinkedList<Integer>();
 
        nodes.add(root);
        values.add(root.value);
 
        while(!nodes.isEmpty()){
            Node curr = nodes.poll();
            int sumValue = values.poll();
 			System.out.println("curr: " + curr + ", sumValue: " + sumValue);

	       
            if(curr.left == null && curr.right == null && sumValue==sum){
                return true;
            }
 
            if(curr.left != null){
                nodes.add(curr.left);
                values.add(sumValue + curr.left.value);
            }
 
            if(curr.right != null){
                nodes.add(curr.right);
                values.add(sumValue + curr.right.value);
            }
        }
 
        return false;
    }

    public boolean hasPathSum2(Node root, int sum) {
		if (root == null)
			return false;
		if (root.value == sum && (root.left == null && root.right == null))
			return true;
	 
		return hasPathSum(root.left, sum - root.value)
				|| hasPathSum(root.right, sum - root.value);
	}

	public List<ArrayList<Integer>> pathSums(Node root, int sum) {
	    ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
	    if(root == null) {
	        return result;
	    }
	 
	    ArrayList<Integer> l = new ArrayList<Integer>();
	    l.add(root.value);
	    dfsSum(root, sum-root.value, result, l);
	    return result;
	}
	 
	public void dfsSum(Node t, int sum, ArrayList<ArrayList<Integer>> result, ArrayList<Integer> l){
	    //System.out.println("t.value: " + t.value + ", sum: " + sum);
	   
	    if(t.left == null && t.right == null && sum == 0){
	        ArrayList<Integer> temp = new ArrayList<Integer>();
	        //System.out.println("list : " + l);
	        temp.addAll(l);
	        result.add(temp);
	    }
	 
	    //search path of left node
	    if(t.left != null){
	        l.add(t.left.value);
	        dfsSum(t.left, sum-t.left.value, result, l);
	        System.out.println("left list end1: " + l);
	        l.remove(l.size()-1);
	        System.out.println("left list end2: " + l);
	    }
	 
	    //search path of right node
	    if(t.right!=null){
	    	//System.out.println("right list : " + l);
	        l.add(t.right.value);
	        dfsSum(t.right, sum-t.right.value, result, l);
	        l.remove(l.size()-1);
	    }
	}

	public int getHeight(Node node) {
		if (node == null){ 
			return -1;
		}

		return 1 + Math.max(getHeight(node.left), getHeight(node.right));
	}

	public Node buildTree(int[] inorder, int[] postorder) {
		int inStart = 0;
		int inEnd = inorder.length - 1;
		int postStart = 0;
		int postEnd = postorder.length - 1;
	 
		return buildTree(inorder, inStart, inEnd, postorder, postStart, postEnd);
	}
	 
	public Node buildTree(int[] inorder, int inStart, int inEnd,
			int[] postorder, int postStart, int postEnd) {
		if (inStart > inEnd || postStart > postEnd)
			return null;
	 
		int rootValue = postorder[postEnd];
		Node root = new Node(rootValue);
	 
		int k = 0;
		for (int i = 0; i < inorder.length; i++) {
			if (inorder[i] == rootValue) {
				k = i;
				break;
			}
		}
	 
		root.left = buildTree(inorder, inStart, k - 1, postorder, postStart,
				postStart + k - (inStart + 1));
		// Becuase k is not the length, it it need to -(inStart+1) to get the length
		root.right = buildTree(inorder, k + 1, inEnd, postorder, postStart + k- inStart, postEnd - 1);
		// postStart+k-inStart = postStart+k-(inStart+1) +1
	 
		return root;
	}

	public Node buildTree2(int[] preorder, int[] inorder) {
		int preStart = 0;
		int preEnd = preorder.length - 1;
		int inStart = 0;
		int inEnd = inorder.length - 1;
	 
		return construct(preorder, preStart, preEnd, inorder, inStart, inEnd);
	}
    
    public Node construct(int[] preorder, int preStart, int preEnd,
			int[] inorder, int inStart, int inEnd) {
    	
		if (preStart > preEnd || inStart > inEnd){
			return null;
		}
		
		System.out.println("preStart: " + preStart);
		int val = preorder[preStart];
		Node p = new Node(val);
	 
		int k = 0;
		for (int i = 0; i < inorder.length; i++) {
			if (inorder[i] == val) {
				k = i;
				break;
			}
		}
	 
		p.left = construct(preorder, preStart + 1, preStart + (k - inStart), inorder, inStart, k - 1);
		p.right = construct(preorder, preStart + (k - inStart) + 1, preEnd, inorder, k + 1, inEnd);
		return p;
	}

	public Node buildTreeFromSortedArray(int[] sortedArray){
		Node root = buildTreeFromSortedArray(sortedArray, 0, sortedArray.length -1);
		return root;
	}

	public Node buildTreeFromSortedArray(int[] sortedArray, int start, int end){
		if(start > end){
			return null;
		}

		int middle = (start + end) / 2;
		Node root = new Node(sortedArray[middle]);

		root.left = buildTreeFromSortedArray(sortedArray, start, middle -1);
		root. right = buildTreeFromSortedArray(sortedArray, middle + 1, end);
		return root; 
	}	

	ListNode h;

    public Node sortedListToBST(ListNode head) {
		if (head == null)
			return null;
 
		h = head;
		int len = getLength(head);
		System.out.println("length: " + len);
		return sortedListToBST(0, len - 1);
	}
 
	// get list length
	public int getLength(ListNode head) {
		int len = 0;
		ListNode p = head;
 
		while (p != null) {
			len++;
			p = p.next;
		}
		return len;
	}
 
	// build tree bottom-up
	public Node sortedListToBST(int start, int end) {
		System.out.println("start: " + start + ", end: " + end);
		if (start > end){
			return null;
		}
 
		// mid
		int mid = (start + end) / 2;
		System.out.println("mid: " + mid);
 
		Node left = sortedListToBST(start, mid - 1);
		System.out.println("left: " + left);
		Node root = new Node(h.val);
		h = h.next;
		Node right = sortedListToBST(mid + 1, end);
 
		root.left = left;
		root.right = right;
 
		return root;
	}

	public int minDepth(Node root) {
        if(root == null){
            return 0;
        }
 
        LinkedList<Node> nodes = new LinkedList<Node>();
        LinkedList<Integer> counts = new LinkedList<Integer>();
 
        nodes.add(root);
        counts.add(1);
 
        while(!nodes.isEmpty()){
            Node curr = nodes.remove();
            int count = counts.remove();
 
            if(curr.left == null && curr.right == null){
                return count;
            }
 
            if(curr.left != null){
                nodes.add(curr.left);
                counts.add(count+1);
            }
 
            if(curr.right != null){
                nodes.add(curr.right);
                counts.add(count+1);
            }
        }
 
        return 0;
    }

    public int maxPathSum(Node root) {
		int max[] = new int[1];
		max[0] = Integer.MIN_VALUE;
		calculateSum(root, max);
		return max[0];
	}

	public int calculateSum(Node root, int[] max) {
		if (root == null){
			return 0;
		}
		//System.out.println("root value: " + root.value);
		int left = calculateSum(root.left, max);
		int right = calculateSum(root.right, max);
		//System.out.println("left sum: " + left);
		//System.out.println("right sum: " + right);
		int current = Math.max(root.value, Math.max(root.value + left, root.value + right));
		//System.out.println("current: " + current);
		max[0] = Math.max(max[0], Math.max(current, left + root.value + right));
		//System.out.println("max[0]: " + max[0]);
		//System.out.println("sums: " + left + root.value + right);
		return current;
	}

	public boolean isBalanced(Node root) {
        if (root == null){
            return true;
        }
 
        if (getHeightBalanced(root) == -1){
            return false;
        }
        return true;
    }
 
    public int getHeightBalanced(Node root) {
        if (root == null){
            return 0;
        }
 		//System.out.println("1 root: " + root.value);
        int left = getHeightBalanced(root.left);
        int right = getHeightBalanced(root.right);
        //System.out.println("2 root: " + root.value);
 		//System.out.println("left: " + left);
 		//System.out.println("right: " + right);
        if (left == -1 || right == -1){
            return -1;
        }
 
        if (Math.abs(left - right) > 1) {
            return -1;
        }
 
        return Math.max(left, right) + 1;
    }

}

