package accelerator;

import java.io.*;
import java.util.*;


// DO NOT EDIT
// ListNode class for a linked list node
class ListNode {
  public int value;
  public ListNode next;

  public ListNode(int value){
    this.value = value;
  }
}

public class ListTraverse {

  // DO NOT EDIT
  // Generate a linked list from an array
  public static ListNode generateList(int[] arr) {
    if(arr.length == 0){
      return null;
    }
    ListNode head = new ListNode(arr[0]);
    ListNode current = head;
    for(int i = 1; i < arr.length; i++){
      current.next = new ListNode(arr[i]);
      current = current.next;
    }
    return head;
  }


/**
 * 1a. Create a method which prints the value of each node 
 until the tail
 *
 * Input: node {ListNode}
 * Output: void
 *
 * Example: (1) --> (5) --> (7) --> (10)
 *          Head                    Tail
 *          1
 *          5
 *          7
 *          10
 */

  // Time Complexity:O(n)
  // Auxiliary Space Complexity: O(1)
  public static void printForward(ListNode node) {
    // YOUR WORK HERE
    ListNode runner = node;
    while(runner != null){
      System.out.println("node: " + runner.value);
      runner = runner.next;
    }
  }


/**
 * 1b. Given a node, print the value of each node backwards 
 from the tail to the
 * input node using recursion.
 *
 * Input: node {ListNode}
 * Output: void
 *
 * Example: (1) --> (5) --> (7) --> (10)
 *          Head                    Tail
 *          10
 *          7
 *          5
 *          1
 */

  // Time Complexity:O(N)
  // Auxiliary Space Complexity:O(N)
  public static void printBackward(ListNode node) {
    // YOUR WORK HERE
    Stack<ListNode> stack = new Stack<>();
    ListNode runner = node;
    while(runner != null){
      stack.push(runner);
      runner = runner.next;
    }

    while(!stack.isEmpty()){
      ListNode curr = stack.pop();
      System.out.println("node: " + curr.value);
    }
  }


/**
 * 1c. Create a public method on the singly LinkedList class that reverses the
 *     order of the nodes in the linked list
 *
 * Input: node {ListNode}
 * Output: {ListNode}
 *
 * Example: (1) --> (5) --> (7) --> (10) .reverse()
 *          Head                    Tail
 *
 *          (10) --> (7) --> (5) --> (1)
 *          Head                    Tail
 *
 * What is the time and auxiliary space complexity of your solution?
 */

  // Time Complexity: O(n)
  // Auxiliary Space Complexity: O(1)
  public static ListNode reverse(ListNode node) {
    ListNode curr = node;
    ListNode prev = null;
    ListNode ref;

    while(curr != null){
      ref = curr.next;
      curr.next = prev;
      prev = curr;
      curr = ref;
    }
    return prev;
  }


/**
 * 1d. Create a method which swaps the first occurance 
 of the locations of two
 *     nodes in the linked list.
 *
 * Input: head {ListNode},
 * Input: a {Integer}
 * Input: b {Integer}
 * Output: {ListNode}
 *
 * Example:
 * ListNode head = Problems.generateList({1, 5, 7, 10});
 * head = swap(head, 5, 10);
 *
 *          (1) --> (5) --> (7) --> (10)
 *          Head
 *
 *          (1) --> (10) --> (7) --> (5)
 *          Head
 */

  // Time Complexity: O(n)
  // Auxiliary Space Complexity: O(1)
  public static ListNode swap(ListNode head, int a, int b) {
    // YOUR WORK HERE
    ListNode dummy = new ListNode(-1);
    dummy.next = head;
    //looking for a
    ListNode beforeA = null;
    ListNode currentA = dummy;
    while(currentA != null){
      if(currentA.value == a){
        break;
      }
      beforeA = currentA;
      currentA = currentA.next;
    }
    if(currentA == null){
      return dummy.next;
    }
    ListNode afterA = currentA.next;
    //System.out.println("befA: " + beforeA.value);
    //System.out.println("currentA: " + currentA.value);

    //looking for b
    ListNode beforeB = null;
    ListNode currentB = dummy;
    while(currentB != null){
      if(currentB.value == b){
        break;
      }
      beforeB = currentB;
      currentB = currentB.next;
    }
    if(currentB == null){
      return dummy.next;
    }
    //System.out.println("befB: " + beforeB.value);
    //System.out.println("currentB: " + currentB.value);
    ListNode afterB = currentB.next;

    beforeA.next = currentB;
    currentB.next = afterA;
    currentA.next = afterB;
    beforeB.next = currentA;    

    return dummy.next;
  }


 /**
  *  Extra Credit 1:
  *
  *  Given an input of a ListNode, return true if the ListNode 
  is in a circular
  *  linked list, and false if the linked list that terminates.
 */
  public static boolean isCircular(ListNode node){
    // YOUR WORK HERE
    ListNode slow = node.next;
    ListNode faster = node.next.next;

    while(faster != null && faster.next != null && faster.next.next != null){
        if(slow == faster){
          return true;
        }
        slow = slow.next;
        faster = faster.next.next;
    }
    return false;
  }

}