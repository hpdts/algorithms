package cracking.stackqueue;

import java.util.*;

public class StackMinimun{

	class Node{
		int number;
		Node next;
		public Node(int number){
			this.number = number;
			this.next = null;
		}
	}

	Node top;
	int minimun = 0;

	public void push(int number){
		if(top == null){
			minimun = number;
		}else if(number < minimun){
			minimun = number;
		}
		Node node = new Node(number);
		node.next = top;
		top = node;
	}

	//the minimun could change and you need to traverse the stack to get the new minimun
	public int pop(){
		if(top != null){
			Node out = top;
			top = top.next;
			out.next = null;
			return out.number;			
		}else{
			return 0;
		}
	}

	public int min(){
		return minimun;
	}


}