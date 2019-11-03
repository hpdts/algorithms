package designAlgorithms;

import org.junit.*;
import static org.junit.Assert.*;
import static designAlgorithms.LinkedList.*;

public class LinkedListNodeTest {
	public LinkedList linkedList = new LinkedList();

	@Test
	public void noCycle(){
		LinkedListNode head = new LinkedListNode(1);
		LinkedListNode two = new LinkedListNode(2);
		LinkedListNode three = new LinkedListNode(3);
		LinkedListNode four = new LinkedListNode(4);

		head.next = two;
		two.next = three;
		three.next = four;

		assertFalse(linkedList.hasACycle(head));
	}

	@Test
	public void noCycle1Node(){
		LinkedListNode head = new LinkedListNode(1);
		assertFalse(linkedList.hasACycle(head));
	}

	@Test
	public void noCycle2Nodes(){
		LinkedListNode head = new LinkedListNode(1);
		LinkedListNode two = new LinkedListNode(2);
		head.next = two;

		assertFalse(linkedList.hasACycle(head));
	}

	@Test
	public void noCycle3Nodes(){
		LinkedListNode head = new LinkedListNode(1);
		LinkedListNode two = new LinkedListNode(2);
		LinkedListNode three = new LinkedListNode(3);
		head.next = two;
		two.next = three;
		
		assertFalse(linkedList.hasACycle(head));
	}

	@Test
	public void noCycleNoNodes(){
		assertFalse(linkedList.hasACycle(null));
	}

	@Test
	public void cycle(){
		LinkedListNode head = new LinkedListNode(1);
		LinkedListNode two = new LinkedListNode(2);
		LinkedListNode three = new LinkedListNode(3);
		LinkedListNode four = new LinkedListNode(4);
		LinkedListNode five = new LinkedListNode(5);
		LinkedListNode six = new LinkedListNode(6);

		head.next = two;
		two.next = three;
		three.next = four;
		four.next = five;
		five.next = six;
		six.next = head;

		assertTrue(linkedList.hasACycle(head));
	}

}