package designAlgorithms;

import java.util.*;
import java.util.Arrays;
import java.util.stream.Collectors; 

 public class LinkedList {

 	static class LinkedListNode{
	    int value;
	    LinkedListNode next;

	    LinkedListNode(int value) {
	        this.value = value;
	    }
	}


    public boolean hasACycle(LinkedListNode head){
    	LinkedListNode slow = head;
    	LinkedListNode fast = head;

    	while(fast != null && fast.next != null && fast.next.next != null){
    		slow = slow.next;
    		fast = fast.next.next;
    		if(slow == fast){
    			return true;
    		}
    	}

    	return false;	

    }
}