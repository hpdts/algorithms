package listOther;


import org.junit.Test;
import java.util.*;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
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


	@Test
	public void reorder(){
		Node head = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(4);
		Node node5 = new Node(5);
		Node node6 = new Node(6);

		head.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;

		System.out.println("before reorder: " + head);
		singlyList.reorder(head); 
		System.out.println("after reorder: " + head);
	}

	@Test
	public void hasCycle(){
		Node head = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(4);
		Node node5 = new Node(5);
		Node node6 = new Node(6);

		head.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node2;

		assertTrue(singlyList.hasCycle(head));
	}

	@Test
	public void randomPointer(){
		NodeRandom head = new NodeRandom(1);
		NodeRandom node2 = new NodeRandom(2);
		NodeRandom node3 = new NodeRandom(3);
		NodeRandom node4 = new NodeRandom(4);
		NodeRandom node5 = new NodeRandom(5);
		NodeRandom node6 = new NodeRandom(6);

		head.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node4.random = node3;
		node5.next = node6;

		//NodeRandom head2 = singlyList.copyRandomList(head);
		//System.out.println("head new: " + head2);
		NodeRandom head3 = singlyList.copyRandomListMap(head);
		System.out.println("head new2: " + head3);

		//assertTrue(singlyList.hasCycle(head));
	}

	@Test
	public void mergeTwoLists(){
		Node headList1 = new Node(1);
		Node node4 = new Node(4);
		Node node6 = new Node(6);
		Node node8 = new Node(8);
		Node node10 = new Node(10);

		headList1.next = node4;
		node4.next = node6;
		node6.next = node8;
		node8.next = node10;

		Node headList2 = new Node(2);
		Node node3 = new Node(3);
		Node node5 = new Node(5);
		Node node7 = new Node(7);

		headList2.next = node3;
		node3.next = node5;
		node5.next = node7;

		Node head3 = singlyList.mergeTwoLists(headList1, headList2);
		System.out.println("Merge List: " + head3);
	}

	@Test
	public void merge2TwoLists(){
		Node headList1 = new Node(1);
		Node node4 = new Node(4);
		Node node6 = new Node(6);
		Node node8 = new Node(8);
		Node node10 = new Node(10);

		headList1.next = node4;
		node4.next = node6;
		node6.next = node8;
		node8.next = node10;

		Node headList2 = new Node(2);
		Node node3 = new Node(3);
		Node node5 = new Node(5);
		Node node7 = new Node(7);

		headList2.next = node3;
		node3.next = node5;
		node5.next = node7;

		Node head3 = singlyList.mergeTwoLists2(headList1, headList2);
		System.out.println("Merge2 List: " + head3);

	}

	@Test
	public void oddEvenList(){
		Node headList1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(4);
		Node node5 = new Node(5);

		headList1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;

		Node head3 = singlyList.oddEvenList(headList1);
		System.out.println("odd: " + head3);

	}

	@Test
	public void deleteDuplicates(){
		Node headList1 = new Node(1);
		Node head11 = new Node(1);
		Node head111 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node33 = new Node(3);
		Node node4 = new Node(4);

		headList1.next = head11;
		head11.next = head111;
		head111.next = node2;
		node2.next = node3;
		node3.next = node33;
		node33.next = node4;

		Node head3 = singlyList.deleteDuplicates(headList1);
		System.out.println("Uniques: " + head3);

	}

	@Test
	public void deleteDuplicates2(){
		Node headList1 = new Node(1);
		Node head11 = new Node(1);
		Node head111 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node33 = new Node(3);
		Node node4 = new Node(4);

		headList1.next = head11;
		head11.next = head111;
		head111.next = node2;
		node2.next = node3;
		node3.next = node33;
		node33.next = node4;

		Node head3 = singlyList.deleteDuplicates2(headList1);
		System.out.println("Uniques2: " + head3);

	}

	@Test
	public void rearrange(){
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(4);
		Node node5 = new Node(5);
		Node node6 = new Node(6);

		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;

		Node headNew = singlyList.rearrange(node1);
		System.out.println("New List: " + headNew);
	}

	@Test
	public void removeOddNumbers(){
		Node node2 = new Node(2);
		Node node22 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(4);

		node2.next = node22;
		node22.next = node3;
		node3.next = node4;

		Node headNew = singlyList.removeOddNumbers(node2);
		assertThat(headNew.val, is(3));
	}

	@Test
	public void removeOddNumbers2(){
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node5 = new Node(5);
		Node node4 = new Node(4);
		Node node6 = new Node(6);
		Node node8 = new Node(8);

		node2.next = node3;
		node3.next = node5;
		node5.next = node4;
		node4.next = node6;
		node6.next = node8;

		Node headNew = singlyList.removeOddNumbers(node2);
		assertThat(headNew.val, is(3));
	}

	@Test
	public void partition(){
		//1->4->3->2->5->2
		Node node1 = new Node(1);
		Node node4 = new Node(4);
		Node node3 = new Node(3);
		Node node2 = new Node(2);
		Node node5 = new Node(5);
		Node node22 = new Node(2);

		node1.next = node4;
		node4.next = node3;
		node3.next = node2;
		node2.next = node5;
		node5.next = node22;

		Node headNew = singlyList.partition(node1, 3);
		System.out.println("partition: " + headNew);
	}

	@Test
	public void getIntersectionNode(){
		Node nodea1 = new Node(1);
		Node nodea2 = new Node(2);

		Node nodec1 = new Node(3);
		Node nodec2 = new Node(4);
		Node nodec3 = new Node(5);


		Node nodeb1 = new Node(6);
		Node nodeb2 = new Node(7);
		Node nodeb3 = new Node(8);

		nodea1.next = nodea2;
		nodea2.next = nodec1;

		nodec1.next = nodec2;
		nodec2.next = nodec3;

		nodeb1.next = nodeb2;
		nodeb2.next = nodeb3;
		nodeb3.next = nodec1;

		
		Node intersection = singlyList.getIntersectionNode(nodea1, nodeb1);
		assertThat(intersection.val, is(3));

	}

	@Test
	public void swapNodes(){
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(4);

		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		Node swap = singlyList.swapPairs(node1);
		System.out.println("swap: " + swap);

	}

	@Test
	public void reverseList(){
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(4);

		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		Node inverted = singlyList.reverseList(node1);
		System.out.println("inverted: " + inverted);

	}

	@Test
	public void reverseListRecursive(){
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(4);

		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		Node inverted = singlyList.reverseListRecursive(node1);
		System.out.println("inverted recursion: " + inverted);

	}

	@Test
	public void reverseListIndex(){
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(4);
		Node node5 = new Node(5);

		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;

		Node invertedBetween = singlyList.reverseBetween(node1, 2, 4);
		System.out.println("inverted between : " + invertedBetween);
	}

}