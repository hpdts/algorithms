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

}