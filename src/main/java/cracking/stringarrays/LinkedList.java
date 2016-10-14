package cracking.stringarrays;

import java.util.*;

public class LinkedList {

	class Node{
		int number;
		Node next;
		Node(int number){
			this.number = number;
			next = null;
		}
	}

	Node root;

	public void add(int number){
		Node node = new Node(number);
		if(root == null){
			root = node;
		}else{
			node.next = root;
			root = node;
		}
	}

	public void addLoop(int number){
		//root to next and loop
		Node node = new Node(number);
		Node runner = root;
		Node last = root;

		while(runner.next != null){
			runner = runner.next;
		}
		last = runner;
		runner = root;
		while(runner != null){
			if(runner.number == number){
				break;
			}
			runner = runner.next;
		}
		last.next = runner;

	}
	public void removeDuplicates(){
		Set<Integer> duplicates = new HashSet<Integer>();
		Node temp = root;
		Node tempBehind = root;
		while(temp != null){
			if(!duplicates.add(temp.number)){
				tempBehind.next = tempBehind.next.next;
			}
			tempBehind = temp;
			temp = temp.next;		
		}
	}

	//it could be only one pointer checking next.number
	public void removeDuplicatesWithoutSet(){
		Node temp = root;
		while(temp != null){
			Node tempToEnd = temp.next;
			Node tempBehind = temp;
			while(tempToEnd != null){
				if(temp.number == tempToEnd.number){
					tempBehind.next = tempBehind.next.next;
				}
				tempBehind = tempToEnd;
				tempToEnd = tempToEnd.next;
			}
			temp = temp.next;	
		}
	}

	public void deleteDuplicates() {
		if (root == null){
			return;	
		} 
		
		Node current = root;
		while (current != null) {
			/* Remove all future nodes that have the same value */
			Node runner = current;
			while (runner.next != null) {
				if (runner.next.number == current.number) {
					runner.next = runner.next.next;
				} else {
					runner = runner.next;
				}
			}
			current = current.next;
		 }
	 }

	public Node middleElementOnePass(){
		Node temp = root;
		int size = 0;
		while(temp != null){
			size++;
			temp = temp.next;	
		}
		//even
		if(size % 2 == 0){
			temp = root;
			Node tempFast = root;
			while(tempFast != null && tempFast.next != null){
				tempFast = tempFast.next.next;
				temp = temp.next;	
			}
			return temp;
		}else{
			int cont = 0;
			temp = root;
			while(temp != null && cont < (size / 2)){
				cont++;
				temp = temp.next;	
			}
			return temp;
		}
	}

	public String findElements(int position){
		Node runner = root;
		int count = 1;
		StringBuilder nodes = new StringBuilder();

		while(runner != null){
			if(count == position){
				while(runner != null){
					nodes.append(runner.number);
					if(runner.next != null){
						nodes.append(";");
					}
					runner = runner.next;
				}
			}else{
				runner = runner.next;
				count++;
			}
		}
		return nodes.toString();
	}

	public static int nthToLast(Node head, int k) {
		if (head == null) {
			return 0;
		}
		int i = nthToLast(head.next, k) + 1;
		if (i == k) {
			System.out.println(head.number);
		}
		return i;
	 }

	public void removeMiddle(){
		Node runner = root;
		int count = 0;
		if(root == null){
			throw new RuntimeException("root null");
		}
		while(runner != null){
			count++;
			runner = runner.next;
		}
		runner = root;
		Node backRunner = root;
		if(count % 2 == 0){
			Node fastRunner = root;
			while(fastRunner != null && fastRunner.next != null){
				backRunner = runner;
				runner = runner.next;
				fastRunner = fastRunner.next.next;
			}
		}else{
			int middle = count / 2; //check round
			int countEven = 0;
			while(runner != null && countEven < middle){
				countEven++;
				backRunner = runner;
				runner = runner.next;	
			}
		}
		backRunner.next = backRunner.next.next;
	} 

	public boolean deleteNode(Node node) {
 		if (node == null || node.next == null) {
 			return false; // Failure
 		}
 		node.number = node.next.number;
		node.next = node.next.next;
		return true;
 	}

	/* Pass in the head of the linked list and the value to partition
	 * around */
	public Node partition(Node node, int x) {
		Node beforeStart = null;
		Node beforeEnd  = null;
		Node afterStart = null;
		Node afterEnd   = null;

		while (node != null) {
			Node next = node.next;
		 	node.next = null;
		 	if (node.number < x) {
				 /* Insert node into end of before list */
				 if (beforeStart == null) {
				 	beforeStart = node;
				 	beforeEnd = beforeStart;
				 } else {
				 	beforeEnd.next = node;
				 	beforeEnd = node;
				 }
		 	} else {
				 /* Insert node into end of after list */
				 if (afterStart == null) {
				 	afterStart = node;
				 	afterEnd = afterStart;
				 } else {
				 	afterEnd.next = node;
				 	afterEnd = node;
				 }
			 }
			 node = next;
		 }

		 if (beforeStart == null) {
		 	return afterStart;
		 }

		/* Merge before list and after list */
		beforeEnd.next = afterStart;
		return beforeStart;
 	}
 

 		//method to show tostring from Node x
	 public Node partition2(Node node, int x) {
		Node beforeStart = null;
		Node afterStart = null;
		
		while (node != null) {
			Node next = node.next;
			if (node.number < x) {
				/* Insert node into start of before list */
				 node.next = beforeStart;
				 beforeStart = node;
			 } else {
				 /* Insert node into front of after list */
				 node.next = afterStart;
				 afterStart = node;
			}
			 node = next;
		}
		
		 /* Merge before list and after list */
		if (beforeStart == null) {
			return afterStart;
		 }
		
		/* Find end of before list, and merge the lists */
		Node head = beforeStart;
		while (beforeStart.next != null) {
		 	beforeStart = beforeStart.next;
		}
		beforeStart.next = afterStart;

		return head;
	 }

	public int convertToNumber(LinkedList list){
		Node runner = list.root;
		Stack<Integer> numbers = new Stack<>();
		while(runner != null){
			numbers.push(runner.number);
			runner = runner.next;
		}

		String output = "";
	    while (!numbers.isEmpty()) {
	        int number = numbers.pop(); 
	        output = output + number; 
	    }

	    return Integer.valueOf(output);
	}

	public int convertToNumberForward(LinkedList list){
		Node runner = list.root;

		String output = "";
		while(runner != null){
	        output = output + runner.number; 
			runner = runner.next;
	    }

	    return Integer.valueOf(output);
	}

	public void numberToList(int number, LinkedList list){
		String numberString = String.valueOf(number);
		char[] digits = numberString.toCharArray();
		for(char digit : digits){
			list.add(Character.getNumericValue(digit));
		}
	}

	public void numberToListForward(int number, LinkedList list){
		String numberString = String.valueOf(number);
		char[] digits = numberString.toCharArray();
		for(int i = digits.length - 1 ; i >= 0 ; i--){
			list.add(Character.getNumericValue(digits[i]));
		}
	}

	public LinkedList sumList(LinkedList operand1, LinkedList operand2){
		int number1 = convertToNumber(operand1);
		int number2 = convertToNumber(operand2);

		int total = number1 + number2;

		LinkedList newList = new LinkedList();
		numberToList(total, newList);
		return newList;
	}

	public LinkedList sumListForward(LinkedList operand1, LinkedList operand2){
		int number1 = convertToNumberForward(operand1);
		int number2 = convertToNumberForward(operand2);

		int total = number1 + number2;

		LinkedList newList = new LinkedList();
		numberToListForward(total, newList);
		return newList;
	}

	Node addLists(Node list1, Node list2, int carry) {
		/* We're done if both lists are null AND the carry value is 0 */
		if (list1 == null && list2 == null && carry == 0) {
			return null;
		}
		
		Node result = new Node(carry);
		
		 /* Add value, and the data from 11 and 12 */
		 int value = carry;
		 if (list1 != null) {
		 	value += list1.number;
		 }
		 if (list2 != null) {
		 	value += list2.number;
		 }
		
		 result.number = value % 10; /* Second digit of number */
		
		 /* Recurse */
		if (list1 != null || list2 != null) {
			Node more = addLists(list1 == null ? null : list1.next, list2 == null ? null : list2.next, value >= 10 ? 1 : 0);
			result.next = more;
		}
		return result;
	 }

	public class PartialSum {
		public Node sum = null;
		public int carry = 0;
	}
		
	int length(Node list){
		int size = 0;
		Node runner = list;
		while(runner != null){
			size++;
			runner = runner.next;
		}
		return size;
	}	

	Node addLists(Node list1, Node list2) {
		int length1 = length(list1);
		int length2 = length(list2);
		
		 /* Pad the shorter list with zeros - see note (1) */
		 if (length1 < length2) {
		 	list1 = padList(list1, length2 - length1);
		 } else {
		 	list2 = padList(list2, length1 - length2);
		 }
		
		/* Add lists */
		PartialSum sum = addListsHelper(list1, list2);
		/* If there was a carry value left over, insert this at the
		* front of the list. Otherwise, just return the linked list. */
		if (sum.carry == 0) {
			return sum.sum;
		} else {
			Node result = insertBefore(sum.sum, sum.carry);
			return result;
		}
	}
		
	PartialSum addListsHelper(Node list1, Node list2) {
		if (list1 == null && list2 == null) {
			PartialSum sum = new PartialSum();
		 	return sum;
		}
		/* Add smaller digits recursively */
		PartialSum sum = addListsHelper(list1.next, list2.next);
		
		int val = sum.carry + list1.number + list2.number;
		
		/* Insert sum of current digits */
		Node full_result = insertBefore(sum.sum, val % 10);
		/* Return sum so far, and the carry value */
		sum.sum = full_result;
		sum.carry = val / 10;
		return sum;
	}
		
	/* Pad the list with zeros */
	Node padList(Node list, int padding) {
		Node runner = list;
		while(runner.next != null){
			runner = runner.next;
		}

		for (int i = 0; i < padding; i++) {
			Node newNode = new Node(0);
			runner.next = newNode;
			runner = newNode;
		}
		return list;
	}

	/* Helper function to insert node in the front of a linked list */
	Node insertBefore(Node list, int data) {
		Node node = new Node(data);
		if (list != null) {
			node.next = list;
			list = node;
		}
		return node;
	}

	public Node isCircular() {
		Node runner = root;
		Set<Node> elements = new HashSet<>();
		while (runner != null) {
			if(!elements.add(runner)){
				return runner;
			}
			runner = runner.next;
		}
		return null;
	}
   
    Node findBeginning(Node head) {
		Node slow = head;
		Node fast = head;

		/* Find meeting point. This will be LOOP_SIZE - k steps into the
		 * linked list. */
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		 	if (slow == fast) { // Collision
		 		break;
		 	}
		 }
		 /* Error check - no meeting point, and therefore no loop */
		 if (fast == null || fast.next == null) {
		 	return null;
		 }

		 /* Move slow to Head. Keep fast at Meeting Point. Each are k
		 * steps from the Loop Start. If they move at the same pace,
		 * they must meet at Loop Start. */
		 slow = head;
		 while (slow != fast) {
			slow = slow.next;
		 	fast = fast.next;
		 }

		 /* Both now point to the start of the loop. */
		 return fast;
 	}

	public boolean isPalindrome() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(this.toString());
		return stringBuilder.toString().equals(stringBuilder.reverse().toString());
	}

	@Override
	public String toString(){
		StringBuilder stringBuilder = new StringBuilder();
		Node temp = root;
		while(temp != null){
			if(temp.next == null){
				stringBuilder.append(temp.number);
			}else{
				stringBuilder.append(temp.number).append(",");
			}
			temp = temp.next;	
		}
		return stringBuilder.toString();
	}
	
}
