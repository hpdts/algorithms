package cracking.reboot.linkedList;

import org.junit.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import java.util.Arrays; 
import static cracking.reboot.linkedList.LinkedList.Node;

public class LinkedListTest {
	private LinkedList linkedList = new LinkedList();

	@Test
	public void duplicates(){
		Node head = new Node(1);
		Node one = new Node(1);
		Node two = new Node(2);
		Node three = new Node(3);
		Node twoTwo = new Node(2);
		head.next = one;
		one.next = two;
		two.next = three;
		three.next = twoTwo;

		linkedList.removeDuplicates(head);
		//linkedList.display(head);
	}

	@Test
	public void dups1(){
		Node head = new Node(1);
		Node one = new Node(1);
		Node two = new Node(2);
		Node three = new Node(3);
		Node twoTwo = new Node(2);
		head.next = one;
		one.next = two;
		two.next = three;
		three.next = twoTwo;

		linkedList.deleteDups(head);
		linkedList.display(head);
	}

	@Test
	public void dups2(){
		Node head = new Node(1);
		Node one = new Node(1);
		Node two = new Node(1);
		Node three = new Node(3);
		Node twoTwo = new Node(3);
		head.next = one;
		one.next = two;
		two.next = three;
		three.next = twoTwo;

		linkedList.deleteDups2(head);
		System.out.println("Second:");
		linkedList.display(head);
	}

	@Test
	public void kthToLast(){
		Node head = new Node(1);
		Node two = new Node(2);
		Node three = new Node(3);
		Node four = new Node(4);
		head.next = two;
		two.next = three;
		three.next = four;

		Node k = linkedList.returnKthToLast(2, head);
		System.out.println("returnKthToLast:" + k.label);
		k = linkedList.returnKthToLast(1, head);
		System.out.println("returnKthToLast:" + k.label);
		//linkedList.display(head);
	}

	@Test
	public void kthToLastRecursive(){
		Node head = new Node(1);
		Node two = new Node(2);
		Node three = new Node(3);
		Node four = new Node(4);
		head.next = two;
		two.next = three;
		three.next = four;

		linkedList.printKthToLast(head, 2);
		Node k = linkedList.kthToLast(head, 3);
		System.out.println("recursive:" + k.label);
	}

	@Test
	public void removeMiddle(){
		Node head = new Node(1);
		Node two = new Node(2);
		Node three = new Node(3);
		Node four = new Node(4);
		Node five = new Node(5);
		Node sixs = new Node(6);
		head.next = two;
		two.next = three;
		three.next = four;
		four.next = five;
		five.next = sixs;

		linkedList.deleteMiddleNode(three);
		System.out.println("middle:");
		linkedList.display(head);
	}

	@Test
	public void partition(){
		Node head = new Node(3);
		Node five = new Node(5);
		Node eight = new Node(8);
		Node five2 = new Node(5);
		Node ten = new Node(10);
		Node two = new Node(2);
		Node one = new Node(1);

		head.next = five;
		five.next = eight;
		eight.next = five2;
		five2.next = ten;
		ten.next = two;
		two.next = one;
		System.out.println("before partition:");
		linkedList.display(head);

		Node newHead = linkedList.partition(head, 5);
		System.out.println("after partition:");
		linkedList.display(newHead);
	}

	@Test
	public void partition2(){
		Node head = new Node(3);
		Node five = new Node(5);
		Node eight = new Node(8);
		Node five2 = new Node(5);
		Node ten = new Node(10);
		Node two = new Node(2);
		Node one = new Node(1);

		head.next = five;
		five.next = eight;
		eight.next = five2;
		five2.next = ten;
		ten.next = two;
		two.next = one;
		System.out.println("before partition2:");
		linkedList.display(head);

		Node newHead = linkedList.partition2(head, 5);
		System.out.println("after partition2:");
		linkedList.display(newHead);
		System.out.println("end partition2:");
	}


	@Test
	public void reverseList(){
		Node head = new Node(1);
		Node two = new Node(2);
		Node three = new Node(3);
		Node four = new Node(4);
		Node five = new Node(5);
		Node sixs = new Node(6);
		head.next = two;
		two.next = three;
		three.next = four;
		four.next = five;
		five.next = sixs;

		Node newHead = linkedList.reverse(head);
		System.out.println("after reverse:");
		linkedList.display(newHead);

	}

	@Test
	public void sum(){
		Node addend1 = new Node(7);
		Node one = new Node(1);
		Node sixs = new Node(6);
		addend1.next = one;
		one.next = sixs;

		Node addend2 = new Node(5);
		Node nine = new Node(9);
		Node two = new Node(2);
		addend2.next = nine;
		nine.next = two;

		Node result = linkedList.addLists(addend1, addend2, 0);
		System.out.println("Sum:");
		linkedList.display(result);
	}

	@Test
	public void sum2(){
		Node addend1 = new Node(6);
		Node one = new Node(1);
		Node seven = new Node(7);
		addend1.next = one;
		one.next = seven;

		System.out.println("Length: " + linkedList.length(addend1, 0));

		Node addend2 = new Node(2);
		Node nine = new Node(9);
		Node five = new Node(5);
		addend2.next = nine;
		nine.next = five;

		Node result = linkedList.addListForward(addend1, addend2);
		System.out.println("Sum:");
		linkedList.display(result);
	}

	@Test
	public void palindrome(){
		Node head = new Node(1);
		Node zero = new Node(0);
		Node one = new Node(1);
		head.next = zero;
		zero.next = one;
		assertTrue(linkedList.isPalindrome(head));
		assertTrue(linkedList.isPalindrome4(head));

		Node date1 = new Node(0);
		Node date2 = new Node(2);
		Node date3 = new Node(0);
		Node date4 = new Node(2);
		Node date5 = new Node(2);
		Node date6 = new Node(0);
		Node date7 = new Node(2);
		Node date8 = new Node(0);
		date1.next = date2;
		date2.next = date3;
		date3.next = date4;
		date4.next = date5;
		date5.next = date6;
		date6.next = date7;
		date7.next = date8;
		System.out.println("Palindrome:");
		linkedList.display(date1);
		assertTrue(linkedList.isPalindrome(date1));
		assertTrue(linkedList.isPalindrome4(date1));

		assertTrue(linkedList.isPalindrome2(date1));
		assertTrue(linkedList.isPalindrome2(date1));
		assertTrue(linkedList.isPalindrome3(date1));
		assertTrue(linkedList.isPalindrome3(head));

		Node num = new Node(0);
		Node num2 = new Node(2);
		num.next = num2;
		assertFalse(linkedList.isPalindrome2(num));
		assertFalse(linkedList.isPalindrome3(num));
	}

}