package cracking.stackqueue;

import java.util.*;

public class StackArray {

	int size = 9;
	int[] stacks = new int[size];
	int sizeStack = size / 3;
	int stack1Limit = 0 + sizeStack - 1;
	int stack1Top = 0;
	int stack2Limit = stack1Limit + sizeStack;
	int stack2Top = stack1Limit;
	int stack3Limit = stack2Limit + sizeStack;
	int stack3Top = stack2Limit;


	public void push1(int number){
		if(stack1Top <= stack1Limit){
			stacks[++stack1Top] = number;
		}else{
			throw new RuntimeException("OverFlown Stack 1");
		}
	}

	public int pop1(){
		return stacks[stack1Top--];
	}

	public int peek1(){
		return stacks[stack1Top];
	}


	public void push2(int number){
		if(stack2Top <= stack2Limit){
			stacks[++stack2Top] = number;
		}else{
			throw new RuntimeException("OverFlown Stack 2");
		}
	}

	public int pop2(){
		return stacks[stack2Top--];
	}

	public int peek2(){
		return stacks[stack2Top];
	}


	public void push3(int number){
		if(stack3Top <= stack3Limit){
			stacks[++stack3Top] = number;
		}else{
			throw new RuntimeException("OverFlown Stack 3");
		}
	}

	public int pop3(){
		return stacks[stack3Top--];
	}

	public int peek3(){
		return stacks[stack3Top];
	}

}