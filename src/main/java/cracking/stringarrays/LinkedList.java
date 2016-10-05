package cracking.stringarrays;

import java.util.*;

public class LinkedList {

	class Node{
		int number;
		Node next;
		Node(int number){
			this.number = number;
			next = null;
		}
	}

	Node root;

	public void add(int number){
		Node node = new Node(number);
		if(root == null){
			root = node;
		}else{
			node.next = root;
			root = node;
		}
	}

	public void removeDuplicates(){
		Set<Integer> duplicates = new HashSet<Integer>();
		Node temp = root;
		Node tempBehind = root;
		while(temp != null){
			if(!duplicates.add(temp.number)){
				tempBehind.next = tempBehind.next.next;
			}
			tempBehind = temp;
			temp = temp.next;		
		}
	}

	//it could be only one pointer checking next.number
	public void removeDuplicatesWithoutSet(){
		Node temp = root;
		while(temp != null){
			Node tempToEnd = temp.next;
			Node tempBehind = temp;
			while(tempToEnd != null){
				if(temp.number == tempToEnd.number){
					tempBehind.next = tempBehind.next.next;
				}
				tempBehind = tempToEnd;
				tempToEnd = tempToEnd.next;
			}
			temp = temp.next;	
		}
	}

	public void deleteDuplicates() {
		if (root == null){
			return;	
		} 
		
		Node current = root;
		while (current != null) {
			/* Remove all future nodes that have the same value */
			Node runner = current;
			while (runner.next != null) {
				if (runner.next.number == current.number) {
					runner.next = runner.next.next;
				} else {
					runner = runner.next;
				}
			}
			current = current.next;
		 }
	 }

	public Node middleElementOnePass(){
		Node temp = root;
		int size = 0;
		while(temp != null){
			size++;
			temp = temp.next;	
		}
		//even
		if(size % 2 == 0){
			temp = root;
			Node tempFast = root;
			while(tempFast != null && tempFast.next != null){
				tempFast = tempFast.next.next;
				temp = temp.next;	
			}
			return temp;
		}else{
			int cont = 0;
			temp = root;
			while(temp != null && cont < (size / 2)){
				cont++;
				temp = temp.next;	
			}
			return temp;
		}
	}

	public String findElements(int position){
		Node runner = root;
		int count = 1;
		StringBuilder nodes = new StringBuilder();

		while(runner != null){
			if(count == position){
				while(runner != null){
					nodes.append(runner.number);
					if(runner.next != null){
						nodes.append(";");
					}
					runner = runner.next;
				}
			}else{
				runner = runner.next;
				count++;
			}
		}
		return nodes.toString();
	}

	public static int nthToLast(Node head, int k) {
		if (head == null) {
			return 0;
		}
		int i = nthToLast(head.next, k) + 1;
		if (i == k) {
			System.out.println(head.number);
		}
		return i;
	 }

	public void removeMiddle(){
		Node runner = root;
		int count = 0;
		if(root == null){
			throw new RuntimeException("root null");
		}
		while(runner != null){
			count++;
			runner = runner.next;
		}
		runner = root;
		Node backRunner = root;
		if(count % 2 == 0){
			Node fastRunner = root;
			while(fastRunner != null && fastRunner.next != null){
				backRunner = runner;
				runner = runner.next;
				fastRunner = fastRunner.next.next;
			}
		}else{
			int middle = count / 2; //check round
			int countEven = 0;
			while(runner != null && countEven < middle){
				countEven++;
				backRunner = runner;
				runner = runner.next;	
			}
		}
		backRunner.next = backRunner.next.next;
	} 

	public boolean deleteNode(Node node) {
 		if (node == null || node.next == null) {
 			return false; // Failure
 		}
 		node.number = node.next.number;
		node.next = node.next.next;
		return true;
 	}

	/* Pass in the head of the linked list and the value to partition
	 * around */
	public Node partition(Node node, int x) {
		Node beforeStart = null;
		Node beforeEnd  = null;
		Node afterStart = null;
		Node afterEnd   = null;

		while (node != null) {
			Node next = node.next;
		 	node.next = null;
		 	if (node.number < x) {
				 /* Insert node into end of before list */
				 if (beforeStart == null) {
				 	beforeStart = node;
				 	beforeEnd = beforeStart;
				 } else {
				 	beforeEnd.next = node;
				 	beforeEnd = node;
				 }
		 	} else {
				 /* Insert node into end of after list */
				 if (afterStart == null) {
				 	afterStart = node;
				 	afterEnd = afterStart;
				 } else {
				 	afterEnd.next = node;
				 	afterEnd = node;
				 }
			 }
			 node = next;
		 }

		 if (beforeStart == null) {
		 	return afterStart;
		 }

		/* Merge before list and after list */
		beforeEnd.next = afterStart;
		return beforeStart;
 	}
 

 		//method to show tostring from Node x
	 public Node partition2(Node node, int x) {
		Node beforeStart = null;
		Node afterStart = null;
		
		while (node != null) {
			Node next = node.next;
			if (node.number < x) {
				/* Insert node into start of before list */
				 node.next = beforeStart;
				 beforeStart = node;
			 } else {
				 /* Insert node into front of after list */
				 node.next = afterStart;
				 afterStart = node;
			}
			 node = next;
		}
		
		 /* Merge before list and after list */
		if (beforeStart == null) {
			return afterStart;
		 }
		
		/* Find end of before list, and merge the lists */
		Node head = beforeStart;
		while (beforeStart.next != null) {
		 	beforeStart = beforeStart.next;
		}
		beforeStart.next = afterStart;

		return head;
	 }

	@Override
	public String toString(){
		StringBuilder stringBuilder = new StringBuilder();
		Node temp = root;
		while(temp != null){
			if(temp.next == null){
				stringBuilder.append(temp.number);
			}else{
				stringBuilder.append(temp.number).append(",");
			}
			temp = temp.next;	
		}
		return stringBuilder.toString();
	}
	
}
