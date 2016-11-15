package cracking.stackqueue;

import java.util.*;

public class MyQueueStack {

	private Stack<Integer> inbox = new Stack<>();
	private Stack<Integer> outbox = new Stack<>();
	


	public void enqueue(int item) {
		inbox.push(item);	
	}
	
	public int dequeue() {
		if(outbox.isEmpty()){
			while(!inbox.isEmpty()){
				outbox.push(inbox.pop());
			}
		}
		return outbox.pop();
	}

}