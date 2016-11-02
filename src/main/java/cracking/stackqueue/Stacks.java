package cracking.stackqueue;

import java.util.*;

public class Stacks {

	private static final int STACK_TOTAL = 2;
	private int stackSize = 1;
	public int currentStackIndex = 0;
	Stack[] stacks = new Stack[STACK_TOTAL];


	public void push(int number){
		if(stacks[currentStackIndex].size() > stackSize){
			currentStackIndex++;
		}
		if(currentStackIndex > STACK_TOTAL){
			throw new RuntimeException("Stack threshold overflown");
		}

		stacks[currentStackIndex].push(number);
	}

	public int pop(){
		return (int)stacks[currentStackIndex].pop();
	}

}

