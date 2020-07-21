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


}