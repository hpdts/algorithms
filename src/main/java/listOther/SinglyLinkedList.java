package listOther;

import java.util.*;

public class SinglyLinkedList {

	public static class Node{
		int val;
		Node next;
		Node(int val){
			this.val = val;
			next = null;
		}

		public String toString(){
			return "val: " + val + ", next: " + next;
		}


	}

	public void deDuplication(Node head){
		Set<Integer> uniqueNumbers = new HashSet<>();
		Node lastUnique = head;
		Node runner = head;

		while(runner != null){
			int value = runner.val;
			if(uniqueNumbers.contains(value)){
				lastUnique.next = lastUnique.next.next;
			}else{
				uniqueNumbers.add(value);
				lastUnique = runner;
			}

			runner = runner.next;
		}
	}

	public void deDuplicationOnePointer(Node head){
		Set<Integer> uniqueNumbers = new HashSet<>();
		uniqueNumbers.add(head.val);
		Node runner = head;

		while(runner.next != null){
			int nextValue = runner.next.val;
			if(!uniqueNumbers.add(nextValue)){
				runner.next = runner.next.next;
			}else{
				runner = runner.next;
			}
		}
	}

	public void deDuplicationRecursive(Node prev, Node next, Set<Integer> uniques){
		if(prev == null || next == null){
			return;
		}else if(uniques.contains(next.val)){
			prev.next = prev.next.next;
		}else{
			prev = prev.next;
			uniques.add(prev.val);
		}
		deDuplicationRecursive(prev, prev.next, uniques);
	}

	public void reorder(Node start){
		//get the middle, reverse and merge both lists
		System.out.println("here ");
		Node middle = getMiddle(start);
		System.out.println("middle: " + middle.val);


		Node secondList = middle.next;
		middle.next = null;

		secondList = reverseOrder(secondList);

		System.out.println("First List: " + start);
		System.out.println("Reverse List: " + secondList);
		Node p1 = start;
		Node p2 = secondList;

		//merge two lists here
		while (p2 != null) {
			Node temp1 = p1.next;
			Node temp2 = p2.next;

			p1.next = p2;
			p2.next = temp1;		

			p1 = temp1;
			p2 = temp2;
		}

	}

	public  Node reverseOrder(Node head) {
		if (head == null || head.next == null) {
			return head;
		}
 
		Node previous = head;
		Node current = head.next;
 
		while (current != null) {
			Node temp = current.next;
			current.next = previous;
			previous = current;
			current = temp;
		}
 
		// set head node's next
		head.next = null;
 
		return previous;
	}

	public Node getMiddle(Node start){
		Node runnerSlow = start;
		Node runnerFast = start;

		while(runnerFast != null && runnerFast.next != null && runnerFast.next.next!= null){
			runnerSlow = runnerSlow.next;
			runnerFast = runnerFast.next.next;
		}

		return runnerSlow;
	}

	public Node getEnd(Node start){
		Node runner = start;
		while(runner.next != null){
			runner = runner.next;
		}
		return runner;
	}

	public Node getPrevious(Node start, Node after){
		Node runner = start;
		while(runner.next != after){
			runner = runner.next;
		}
		return runner;
	}

	public void swap(Node origin, Node node1, Node node2){
		//Node tempNode2 = node2;
		//Node previousNode2 = getPrevious(origin, node2);


		node2.next = node1.next;
		node1.next = null;
		//origin = node2
		//previousNode2.next = node1;
		//node1.next = tempNode2.next;
	}
}