package listOther;


import org.junit.Test;
import java.util.*;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static listOther.SinglyLinkedList.*;


public class SinglyLinkedListTest {

	SinglyLinkedList singlyList = new SinglyLinkedList();

	@Test
	public void deduplication(){
		Node head = new Node(1);
		Node node2 = new Node(2);
		Node node22 = new Node(2);
		Node node222 = new Node(2);
		Node node11 = new Node(1);
		Node node3 = new Node(3);

		head.next = node2;
		node2.next = node22;
		node22.next = node222;
		node222.next = node11;
		node3.next = null;
		node11.next = node3;
		// 1 -> 2 -> 2 -> 2 -> 1 -> 3 -> null

		System.out.println("before list: " + head);
		singlyList.deDuplication(head); 
		System.out.println("after list: " + head);
	}

	@Test
	public void deduplicationOnePointer(){
		Node head = new Node(1);
		Node node2 = new Node(2);
		Node node22 = new Node(2);
		Node node222 = new Node(2);
		Node node11 = new Node(1);
		Node node3 = new Node(3);

		head.next = node2;
		node2.next = node22;
		node22.next = node222;
		node222.next = node11;
		node3.next = null;
		node11.next = node3;
		// 1 -> 2 -> 2 -> 2 -> 1 -> 3 -> null

		System.out.println("before list: " + head);
		singlyList.deDuplicationOnePointer(head); 
		System.out.println("after list: " + head);
	}

	@Test
	public void deduplicationRecursive(){
		Node head = new Node(1);
		Node node2 = new Node(2);
		Node node22 = new Node(2);
		Node node222 = new Node(2);
		Node node11 = new Node(1);
		Node node3 = new Node(3);

		head.next = node2;
		node2.next = node22;
		node22.next = node222;
		node222.next = node11;
		node3.next = null;
		node11.next = node3;
		// 1 -> 2 -> 2 -> 2 -> 1 -> 3 -> null

		Set<Integer> uniqueNumbers = new HashSet<>();
		System.out.println("Recursive before list: " + head);
		singlyList.deDuplicationRecursive(head, head.next, uniqueNumbers); 
		System.out.println("Recursive after list: " + head);

	}

}