package leetcode;

import java.util.*;

public class StackArray {
	int[] stack;
	int header = -1;
	int size = 0;


	StackArray(int capacity){
		stack = new int[capacity];
	}

	public int peek(){
		System.out.println(Arrays.toString(stack));
		return stack[header+1];
	}

	public void push(int value){
		size++;
		stack[header++] = value;
	}

	public int pop(){
		size--;
		return stack[header--];
	}

	public boolean isEmpty(){
		return ( size == 0 ) ? true : false;
	}
}