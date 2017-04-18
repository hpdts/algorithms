package leetcode;

import java.util.*;

public class StackArray {
	int[] stack;
	int top = -1;
	int size = 0;


	StackArray(int capacity){
		stack = new int[capacity];
	}

	public int peek(){
		if(isEmpty()){
			throw new RuntimeException("Empty stack");
		}
		System.out.println(Arrays.toString(stack));
		return stack[top];
	}

	public void push(int value){
		size++;
		System.out.println("push: " + Arrays.toString(stack));
		stack[++top] = value;
	}

	public int pop(){
		if(isEmpty()){
			throw new RuntimeException("Empty stack");
		}
		size--;
		return stack[top--];
	}

	public boolean isEmpty(){
		return ( size == 0 ) ? true : false;
	}
}