package accelerator;

import java.util.*;

/**

 *
 *
 *  Problem 2: LinkedList class
 *
 *  Prompt:    Create a LinkedList class
 *
 *             The LinkedList class should contain the following public
 *             properties:
 *
 *                length:   {Integer}
 *                  head:   {ListNode}
 *                  tail:   {ListNode}
 *
 *              The LinkedList class should also contain the following public
 *              methods:
 *
 *                append:   A method that appends a value to the end of the
 *                          LinkedList.
 *
 *                          Input:     {Integer}
 *                          Output:    {Void}
 *
 *                insert:   A method that inserts an integer value at a set
 *                          index in the LinkedList (assume head index is 0).
 *
 *                          Input:     value {Integer}
 *                          Input:     index {Integer}
 *                          Output:    {Void}
 *
 *                delete:   A method that removes a node at a specified index.
 *
 *                          Input:     index {Integer}
 *                          Output:    {Void}
 *
 *              contains:   A method that checks to see if a value is contained
 *                          in the list.
 *
 *                          Input:     value {Integer}
 *                          Output:    {Boolean}
 */

import java.util.*;

public class LinkedList {
/*  Homework 09 - Linked List
 *
 *  Problem 1: ListNode class
 *
 *  Prompt:    Create a ListNode class
 *
 *             The ListNode class should contain the following public properties:
 *
 *                 value:   {Integer}
 *                  next:   {ListNode} (initially null)
 *
 *               Example:   ListNode sample = new ListNode(1)
 *                          sample.value     // 1
 *                          sample.next      // null*/
  class ListNode {
    public int value;
    public ListNode next;

    public ListNode(int value){
      // YOUR WORK HERE
      this.value = value;
      next = null;
    } 
  }

  public int length = 0;
  public ListNode head;
  public ListNode tail;

  // Time Complexity:O(1)
  // Auxiliary Space Complexity:O(1)
  public void append(int value){
    // YOUR WORK HERE
    //1->2->3->
    //A method that appends a value to the end of the
 //*                          LinkedList.
    ListNode temp = new ListNode(value);
    if(length == 0){
        head = temp;
        tail = head;
    }else{
        tail.next = temp;
        tail = temp;
    }

    length++;
  }

  public void display(){
    ListNode temp = head;
    while(temp != null){
      System.out.println("Node: " + temp.value);
      temp = temp.next;
    }
  }


  // Time Complexity: O(n)
  // Auxiliary Space Complexity: O(1)
  public void insert(int value, int index){
    // YOUR WORK HERE
    if(index > length){
      return;
    }
    ListNode temp = new ListNode(value);
    //h
    //1->2->3
    if(index == 0){
      temp.next = head.next;
      head.next = temp;
    }else{
      //h  r 
      //1->2->4->3
      //      t
      //   t 
      ListNode runner = head;
      while(index != 0){
        runner = runner.next;
        index--;
      }
      temp.next = runner.next;
      runner.next = temp;
      int tempValue = temp.value;
      temp.value = runner.value;
      runner.value = tempValue;
    }
    length++;
  }


  // Time Complexity: O(n)
  // Auxiliary Space Complexity: O(1)
  public void delete(int index){
    // YOUR WORK HERE
    //0  1  2
    //h     t 
    //1->2->3 //index 1 , 0
              //index 2, 1
    if(index == 0){//remove head
      head = head.next;
    }else{
      index--;
      ListNode runner = head;
      while(index != 0){
        runner = runner.next;
        index--;
      }
      System.out.println("runner: " + runner.value);
      runner.next = runner.next.next;
    }
    length--;
  }


  // Time Complexity:O(n)
  // Auxiliary Space Complexity: O(1)
  public boolean contains(int value){
    // YOUR WORK HERE
    ListNode temp = head;
    while(temp != null){
      if(temp.value == value){
        return true;
      }
      temp = temp.next;
    }
    return false;
  }
}