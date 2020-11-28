package accelerator;

import java.util.*;
import java.util.LinkedList;
import java.util.Queue;

class Node {
  public int value;
  public int countDescendants;
  public Node left;
  public Node right;

  public Node(int value, int countDescendants) {
    // YOUR WORK HERE
    this.value = value;
    this.countDescendants = countDescendants;
    left = right = null;
  }

  public String toString(){
    return " value: " + value + "- countDescendants: " + countDescendants;
  }
}

public class BinaryTreeDescendants {
	List<Node> inOrder = null;

	public Node inorderNode(Node root, int index){
	    //0 based
	    inOrder = new ArrayList<>();
		helperInOrder(root);
		System.out.println("inOrder: " + inOrder);
		return index > inOrder.size() ? null : inOrder.get(index);
	}

	//2 1 3
	public void helperInOrder(Node root){
	   if(root == null){
	   		return;
	   }

		helperInOrder(root.left);
		inOrder.add(root);
		helperInOrder(root.right);
	}

	Integer count = new Integer(0);
	Node nodeIndex = new Node(-1, -1);
	public void helperInOrderNoMemory(Node root, int index){
	   	if(root == null){
	    	return;
		}
		System.out.println("root; "+ root);
		helperInOrderNoMemory(root.left, index);//2 null null 1 3 null null
		System.out.println("count "+ count);
		if(count == index){
			System.out.println("in root; "+ root);
	   		nodeIndex = root;
	   		return;
		}	
	 	count++;
	 	helperInOrderNoMemory(root.right, index);
	}

	public Node getNodeIndex(){
		return nodeIndex;
	}

	public Node kthSmallest(Node root, int k) 
    { 
        // base case 
        if (root == null) {
            return null; 
        }
       System.out.println("root; "+ root);
        // search in left subtree 
        Node left = kthSmallest(root.left, k); 
       
        // if k'th smallest is found in left subtree, return it 
        if (left != null) {
            return left; 
        }
       
        // if current element is k'th smallest, return it 
        if (count == k) {
            return root; 
        }
        count++; 
       
        // else search in right subtree 
        return kthSmallest(root.right, k); 
    } 

    public Node getNode(Node root, int k) {
		if(root == null){
			return null; // This case means k > tree size
		} 
		int left = root.left == null ? 0 : root.left.countDescendants;

		if(left >= k){
			return getNode(root.left, k);
		} 
		else if(left + 1 == k){
			return root;
		} 
		else{
			return getNode(root.right, k-left-1);
		} 
	}

	public void inOrderIterative(Node root){
		Stack<Node> stack = new Stack();
		Node curr = root;

		while(curr != null || !stack.isEmpty()){
			while(curr != null){
				stack.push(curr);
				curr = curr.left;
			}

			curr = stack.pop();
			System.out.print(curr.value + " "); 
			curr = curr.right;
			
		}
		System.out.print("end"); 
	}

	//Kth Smallest Node on a BST
	public Node getKthNodeDescendant(Node root, int k){
		System.out.println("getKthNodeDescendant k: " + k); 
		if(root == null){
			return null;
		}
		System.out.println("getKthNodeDescendant root: " + root.value); 

		int descendantsLeft =  root.left == null ? 0 : root.left.countDescendants;
	System.out.println("getKthNodeDescendant descendantsLeft: " + descendantsLeft); 

		if(descendantsLeft >= k){
			System.out.println("descendantsLeft >= k"); 
			return getKthNodeDescendant(root.left, k);
		}else if((descendantsLeft+1) == k){
			System.out.println("(descendantsLeft+1) == k"); 
			return root;
		}else{
			System.out.println("else"); 
			return getKthNodeDescendant(root.right, k - descendantsLeft - 1);
		}
	}
	//https://leetcode.com/discuss/interview-question/479911/GoogleorPhoneorFind-nth-node-in-inorder-traversal
	public Node getKthNodeDescendant2(Node root, int k){
		//if(root == )
		int descendantsLeft =  root.left == null ? 0 : root.left.countDescendants;
		System.out.println("getKthNodeDescendant k: " + k); 
		System.out.println("getKthNodeDescendant root: " + root); 
		System.out.println("descendantsLeft: " + descendantsLeft); 

		if (k == descendantsLeft + 1){
		 //if k == left subtree's count + 1 (current node), we know we have found our k.
		System.out.println("k == descendantsLeft + 1"); 
			return root.left == null ? root : root.left;
		}else if(k > descendantsLeft + 1){
			System.out.println("k > descendantsLeft + 1"); 
		//: # by pass the left
			return getKthNodeDescendant2(root.right, k - root.left.countDescendants - 1);
		//	 # minus left tree count and current root
		}else{
			System.out.println("else");
			return getKthNodeDescendant2(root.left, k);
			// # by pass the right
		}
	}
	//https://leetcode.com/problems/kth-smallest-element-in-a-bst/discuss/63659/what-if-you-could-modify-the-bst-nodes-structure/65222
  	public int kthSmallest2(Node root, int k) {
        if (k <= 0 || k > root.countDescendants){
        	return -1;
        }
        if (root.left != null) {
            if (root.left.countDescendants >= k){
            	return kthSmallest2(root.left, k);
            } 
            if (root.left.countDescendants == k-1){
            	return root.value;
            } 
            return kthSmallest2(root.right, k-1-root.left.countDescendants);
        } else {
            if (k == 1){
            	return root.value;
            } 
            return kthSmallest2(root.right, k-1);
        }
    }
}