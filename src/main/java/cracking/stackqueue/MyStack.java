package cracking.stackqueue;

import java.util.*;

//LIFO (last-in first-out)
public class MyStack {

	class Node{
		int number;
		Node next;
		Node(int number){
			this.number = number;
			next = null;
		}
	}

	Node top;

	public void push(int number){
		Node node = new Node(number);
		node.next = top;
		top = node;
	}

	public int pop(){
		if(top != null){
			Node out = top;
			top = top.next;
			return out.number;
		}
		return 0;
	}

	public int peek(){
		return top.number;
	}

}