package cracking.stackqueue;

import java.util.*;

//FIFO (first-ln first-out)
public class Queue3OnArrayBook {

	int stackSize = 100;
 	int[] buffer = new int [stackSize * 3];
 	int[] stackPointer = {-1, -1, -1}; // pointers to track top element

 	void push(int stackNum, int value) {
 		/* Check if we have space */
		if (stackPointer[stackNum] + 1 >= stackSize) { // Last element
			throw new RuntimeException("0ut of space.");
		}

 		/* Increment stack pointer and then update top value */
 		stackPointer[stackNum]++;
 		buffer[absTopOfStack(stackNum)] = value;
 	}

 	int pop(int stackNum) {
 		if (stackPointer[stackNum] == -1) {
 			throw new RuntimeException("Trying to pop an empty stack.");
 		}
 		int value = buffer[absTopOfStack(stackNum)]; // Get top
 		buffer[absTopOfStack(stackNum)] = 0; // Clear index
 		stackPointer[stackNum]--; // Decrement pointer
 		return value;
 	}

 	int peek(int stackNum) {
 		int index = absTopOfStack(stackNum);
 		return buffer[index];
 	}

 	boolean isEmpty(int stackNum) {
 		return stackPointer[stackNum] == -1;
 	}

 	/* returns index of top of stack "stackNurrr"J in absolute terms */
 	int absTopOfStack(int stackNum) {
 		return stackNum * stackSize + stackPointer[stackNum];
 	}

}