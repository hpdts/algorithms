package interviewExposed;

import java.util.*;

public class SinglyList {

	private Node<Integer> head;

	SinglyList(){
		head = null;
	}

	private Node<Integer> insertInFront(Node<Integer> head, Integer data){
		Node<Integer> newNode = new Node<Integer>(data);
		newNode.setNext(head);
		return newNode; 
	}

	public void insert(int data){
		if(head == null){
			head = new Node<Integer>(data);
		}else{
			head = insertInFront(head, data);
		}
	}

	public void traverse(){
		Node<Integer> temp = head;
		while(temp != null){
			System.out.println("Data: " + temp.data());
			temp = temp.next();
		}
	}

	public boolean search(int data){
		Node<Integer> temp = head;
		while(temp != null && temp.data() != data){
			temp = temp.next();
		}
		if(temp == null){
			return false;
		}else{
			return true;
		}
	}

	public void deleteNode( int data){
		Node<Integer> temp = head;
		if(head.data() == data){
			head = head.next();
			temp = null;
			return;
		}

		while(temp.next() != null && temp.next().data() != data){
			temp = temp.next();
		}

		if(temp.next() != null){
			temp.setNext(temp.next().next());
		}
	}

	public void deleteAll(){
		Node<Integer> temp = head;
		while(head == null && head.next() != null){
			head.setNext(head.next().next());
		}
		head = null;
	} 
}