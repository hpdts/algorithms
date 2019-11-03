package interviewExposed;

import java.util.*;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.Stack;


public class ReverseList{

	/*public static class Node{
		int num;
		Node next;

		Node(int num){
			this.num = num;
			next = null;
		}
	} */

	public static class Node{
		int num;
		Node next;
		Node(int num){
			this.num = num;
			next = null;
		}

		public String toString(){
			return "num: " + num + ", next: " + next;
		}
	}

	//1->2->3-> 4->5
	//k 3
	//4->5->1->2->3
	//1->2 k=3
	public Node reverse(Node head, int k){
		Node kthNode = head;
		int indexK = 1;

		while(kthNode != null && kthNode.next != null && indexK < k){
			kthNode = kthNode.next;
			indexK++;
		}

		System.out.println("kthNode: " + kthNode.num);
		if(kthNode.next == null){
			return head;
		}

		Node tempToLast = kthNode;

		while(tempToLast != null && tempToLast.next != null){
			tempToLast = tempToLast.next;
		}
		System.out.println("tempToLast: " + tempToLast.num);
		tempToLast.next = head;
		head = kthNode.next;

		kthNode.next = null; 

		return head;
	}

	public Node rearrange(Node head){
		System.out.println("head initial: " + head.toString());
		//get middle
		Node slow = head;
		Node fast = head;

		while(fast != null && fast.next != null){
			slow = slow.next;	
			fast = fast.next.next;
		}

		Node middle = slow.next;
		slow.next = null;
		
		System.out.println("head: " + head.toString());
		System.out.println("middle: " + middle.toString());

		//reverse
		Node temp = middle;
		Stack<Node> stack = new Stack<>();

		while(temp != null){
			System.out.println("temp: " + temp.num);
			stack.push(temp);
			temp = temp.next;
		}

		Node secondReverse = stack.pop();
		System.out.println("secondReverse: " + secondReverse.toString());
		while(!stack.isEmpty()){
			temp = stack.pop();
			temp.next = null;
			secondReverse.next = temp;
		}
		System.out.println("reverse: " + secondReverse.toString());

		//merge both list
		//head: num: 1, next: num: 2, next: num: 3, next: null
		//secondReverse: num: 5, next: num: 4, next: null
		Node p_current = head;
		Node q_current = secondReverse; //1-5-2 
		Node p_next;
		Node q_next;
		//System.out.println("p_current: " + p_current.toString());
		//System.out.println("q_current: " + q_current.toString());
		while(p_current != null && q_current != null){
			p_next = p_current.next;
			q_next = q_current.next;

			q_current.next = p_next;
			p_current.next = q_current;

			p_current = p_next;
			q_current = q_next;
		}
		System.out.println("head: " + head.toString());
		return head;

	}
}