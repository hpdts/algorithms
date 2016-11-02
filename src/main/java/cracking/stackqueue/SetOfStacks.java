package cracking.stackqueue;

import java.util.*;

class SetOfStacks {
 	List<StackBook> stacks = new ArrayList<StackBook>();
 	public int capacity;
	public SetOfStacks(int capacity) {
		this.capacity = capacity;
 	}

 public void push(int v) {
	StackBook last = getLastStack();
	if (last != null && !last.isFull()) { // add to last stack
		last.push(v);
	} else { // must create new stack
		StackBook stack = new StackBook(capacity);
		stack.push(v);
		stacks.add(stack);
	}
 }

	public int pop() {
	 	StackBook last = getLastStack();
	 	int v = last.pop();
	 	if (last.size == 0){
	 		stacks.remove(stacks.size() - 1);
	 	} 
	 	return v;
	 }

	 public StackBook getLastStack() {
		if (stacks.size() == 0) return null;
		return stacks.get(stacks.size() - 1);
	}

 	public boolean isEmpty() {
 		StackBook last = getLastStack();
 		return last == null || last.isEmpty();
 	}

 	public int popAt(int index) {
 		return leftShift(index, true);
 	}

 	public int leftShift(int index, boolean removeTop) {
		StackBook stack = stacks.get(index);
 		int removed_item;
		if (removeTop) {
			removed_item = stack.pop();
		}else{
			removed_item = stack.removeBottom();
		} 
		if (stack.isEmpty()) {
		 	stacks.remove(index);
		 } else if (stacks.size() > index + 1) {
			int v = leftShift(index, false);
		 	stack.push(v);
		 }
		return removed_item;
	}
	
}