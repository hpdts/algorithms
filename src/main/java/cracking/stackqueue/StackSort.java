package cracking.stackqueue;

import java.util.*;

public class StackSort {

	public Stack<Integer> sortStack(Stack<Integer> input){
		
		Stack<Integer> tmpStack = new Stack<Integer>();
		System.out.println("=============== debug logs ================");
		while(!input.isEmpty()) {
	        int tmp = input.pop();
	        System.out.println("Element taken out: " + tmp);
	        while(!tmpStack.isEmpty() && tmpStack.peek() > tmp) {
	        	System.out.println("tmpStack.peek() > tmp: " + tmpStack.peek() + "," + tmp);
	        	input.push(tmpStack.pop());
	        }
	        tmpStack.push(tmp);
	        System.out.println("input: " + input);
	        System.out.println("tmpStack: " + tmpStack);
	    }
		System.out.println("=============== debug logs ended ================");
		return tmpStack;
	}

	public static Stack<Integer> sort(Stack<Integer> s) {
		Stack<Integer> r = new Stack<Integer>();
		while (!s.isEmpty()) {
			int tmp = s.pop(); // Step 1
			System.out.println("Element taken out: " + tmp);
			while (!r.isEmpty() && r.peek() > tmp) { // Step 2
				System.out.println("tmpStack.peek() > tmp: " + r.peek() + "," + tmp);
				s.push(r.pop());
			}
			r.push(tmp); // Step 3
			System.out.println("input: " + s);
	        System.out.println("tmpStack: " + r);
		}
		return r;	
	}

}