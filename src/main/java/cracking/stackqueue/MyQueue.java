package cracking.stackqueue;

import java.util.*;

//FIFO (first-ln first-out)
public class MyQueue {

	class Node{
		int number;
		Node next;
		Node(int number){
			this.number = number;
			next = null;
		}
	}

	Node first,last;

	public void enqueue(int item) {
		if (first == null) {
			last = new Node(item);
			first = last;
		} else {
			last.next = new Node(item);
		 	last = last.next;
		}
	 }
	
	 public int dequeue() {
		 if (first != null) {
			 int item = first.number;
			 first = first.next;
			 return item;
		 }
		 return 0;
	 }

}