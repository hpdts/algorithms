package interviewExposed;

import org.junit.Test;
import java.util.*;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static interviewExposed.ReverseList.Node;

public class ReverseListTest {

	ReverseList reverseList = new ReverseList();

	@Test
	public void reverseList(){
		//1->2->3-> 4->5
		ReverseList.Node head = new ReverseList.Node(1);
		Node one = new Node(2);
		Node two = new Node(3);
		Node three = new Node(4);
		Node four = new Node(5);

		head.next = one;
		one.next = two;
		two.next = three;
		three.next = four;

		Node newHead = reverseList.reverse(head, 3);
		Node temp = newHead;

		while(temp != null){
			System.out.println("Value: " + temp.num);
			temp = temp.next;
		}

	}

	@Test
	public void rearrange(){
		//1->2->3->4->5
		ReverseList.Node head = new ReverseList.Node(1);
		Node one = new Node(2);
		Node two = new Node(3);
		Node three = new Node(4);
		Node four = new Node(5);

		head.next = one;
		one.next = two;
		two.next = three;
		three.next = four;

		Node newHead = reverseList.rearrange(head);
		//1->5->2->4->3
		assertThat(newHead.next.num, is(5));
		assertThat(newHead.next.next.num, is(2));
	}

/*	@Test
	public void rearrange2(){
		//1->2->3->4
		ReverseList.Node head = new ReverseList.Node(1);
		Node one = new Node(2);
		Node two = new Node(3);
		Node three = new Node(4);

		head.next = one;
		one.next = two;
		two.next = three;

		Node newHead = reverseList.rearrange(head);
	}*/

}