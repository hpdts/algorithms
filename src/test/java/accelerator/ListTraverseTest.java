package accelerator;

import org.junit.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import java.util.*;
//import static cracking.reboot.linkedList.LinkedList.Node;

public class ListTraverseTest {
	ListTraverse list = new ListTraverse();

	@Test
    public void operations(){
    	ListNode head = list.generateList(new int[]{ 1, 2, 3, 4, 5});
    	list.printForward(head);
    	list.printBackward(head);
    	ListNode newHead = list.reverse(head);
    	list.printForward(newHead);
    }

    @Test
    public void swap(){
    	ListNode head = list.generateList(new int[]{ 1, 2, 3, 4, 5, 6});
    	list.printForward(head);
    	ListNode newHead = list.swap(head, 2, 4);
    	System.out.println("swap 2,4");
    	list.printForward(newHead);
    	ListNode newHead2 = list.swap(head, 1, 6);
    	System.out.println("swap 1,6");
    	list.printForward(newHead2);
    	ListNode newHead3 = list.swap(head, 90, 4);
    	assertThat(newHead3.value, is(1));
    }

    @Test
    public void circular(){
    	ListNode head = list.generateList(new int[]{ 1, 2, 3, 4, 5, 6});
    	assertFalse(list.isCircular(head));
    	//cycle
    	ListNode runner = head;
	    while(runner.next != null){
	      runner = runner.next;
	    }
	    runner.next = head;
    	assertTrue(list.isCircular(head));
   	}
}