package cracking.stringarrays;

import java.util.*;

public class LinkedList {

	class Node{
		int number;
		Node next;
		Node(int number){
			this.number = number;
			next = null;
		}
	}

	Node root;

	public void add(int number){
		Node node = new Node(number);
		if(root == null){
			root = node;
		}else{
			node.next = root;
			root = node;
		}
	}

	public void removeDuplicates(){
		Set<Integer> duplicates = new HashSet<Integer>();
		Node temp = root;
		Node tempBehind = root;
		while(temp != null){
			if(!duplicates.add(temp.number)){
				tempBehind.next = tempBehind.next.next;
			}
			tempBehind = temp;
			temp = temp.next;		
		}
	}

	public void removeDuplicatesWithoutSet(){
		Node temp = root;
		while(temp != null){
			Node tempToEnd = temp.next;
			Node tempBehind = temp;
			while(tempToEnd != null){
				if(temp.number == tempToEnd.number){
					tempBehind.next = tempBehind.next.next;
				}
				tempBehind = tempToEnd;
				tempToEnd = tempToEnd.next;
			}
			temp = temp.next;	
		}
	}

	public int middleElementOnePass(){
		Node temp = root;
		int size = 0;
		while(temp != null){
			size++;
			temp = temp.next;	
		}
		//even
		if(size % 2 == 0){
			temp = root;
			Node tempFast = root;
			while(tempFast != null && tempFast.next != null){
				tempFast = tempFast.next.next;
				temp = temp.next;	
			}
			return temp.number;
		}else{
			int cont = 0;
			temp = root;
			while(temp != null && cont < (size / 2)){
				cont++;
				temp = temp.next;	
			}
			return temp.number;
		}
	}

	@Override
	public String toString(){
		StringBuilder stringBuilder = new StringBuilder();
		Node temp = root;
		while(temp != null){
			if(temp.next == null){
				stringBuilder.append(temp.number);
			}else{
				stringBuilder.append(temp.number).append(",");
			}
			temp = temp.next;	
		}
		return stringBuilder.toString();
	}
	
}
