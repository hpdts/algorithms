package cracking.stackqueue;

import java.util.*;


public class StackWithMin extends Stack<NodeWithMin> {
	public void push(int value) {
		int newMin = Math.min(value, min());
		System.out.println("value: " + value + ", newMin: " + newMin);
		super.push(new NodeWithMin(value, newMin));
	}

	public int min() {
		if (this.isEmpty()) {
			return Integer.MAX_VALUE; // Error value
		} else {
		 	return peek().min;
		}
	}
}

class NodeWithMin {
	 public int value;
	 public int min;
	 public NodeWithMin(int v, int min){
	 	value = v;
	 	this.min = min;
 	}

 	public String toString(){
 		 return "Value: '" + this.value + "', Min: '" + this.min + "'";
 	}
 }