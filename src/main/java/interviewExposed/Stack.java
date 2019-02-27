package interviewExposed;

import java.util.*;

public class Stack<Integer>{

	SinglyList singlyList = new SinglyList();

	public void enqueue(int data){
		singlyList.insert(data);
	} 

	public void dequeue(){
		singlyList.deleteNode(3);
	}

	public void traverse(){
		singlyList.traverse();
	}

	public void deleteAll(){
		singlyList.deleteAll();
	}
}