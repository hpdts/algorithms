package cracking.reboot.linkedList;

import java.util.*;

public class LinkedList {

	public static class Node{
		int label;
		Node next;
		public Node(int label){
			this.label = label;
			this.next = null;
		}
	}
	//1->1->3-
	//isWrong you need to mantain the last pointer
	//only when is different you move it
	public void removeDuplicates(Node head){
		Set<Integer> uniques = new HashSet<>();
		Node temp = head;
		//uniques.add(temp.label);
		while(temp != null){
			if(!uniques.add(temp.label)){
				temp.next = temp.next.next;					
			}	
			temp = temp.next;	
		}
	}

	public void deleteDups(Node head){
		Set<Integer> uniques = new HashSet<>();
		Node previous = null;
		while(head != null){
			if(uniques.contains(head.label)){
				previous.next = head.next;
			}else{
				uniques.add(head.label);
				previous = head;
			}
			head = head.next;
		}
	}

	public void deleteDups2(Node head){
		Node current = head;
		while(current != null){
			Node runner = current;
			while(runner.next != null){
				if(runner.next.label == current.label){
					runner.next = runner.next.next;
				}else{
					runner = runner.next;
				}
			}
			current = current.next;
		}
	}

	public void display(Node head){
		Node temp = head;
		while(temp != null){
			System.out.println("label: " + temp.label);	
			temp = temp.next;
		}
		
	}
	//1-2-3-4 k = 2
	public Node returnKthToLast(int k, Node head){
		Node faster = head;
		for(int i =0; i < k; i++){
			faster = faster.next;
		}
		Node slower = head;
		while(faster != null){
			faster = faster.next;
			slower = slower.next;
		}
		return slower;
	}

	public int printKthToLast(Node head, int k){
		if(head == null){
			return 0;
		}
		System.out.println("head: " + head.label);
		int index = printKthToLast(head.next, k) + 1;
		System.out.println("index: " + index);
		if(index == k){
			System.out.println(k + "th to Last Node is " + head.label);
		}
		return index;
	}

	class Index{
		public int value = 0;
	}

	public Node kthToLast(Node head, int k){
		Index idx = new Index();
		return kthToLast(head, k, idx);
	}

	public Node kthToLast(Node head, int k, Index idx){
		if(head == null){
			return null;
		}
		Node node = kthToLast(head.next, k, idx);
		idx.value = idx.value + 1;
		if(idx.value == k){
			return head;
		}
		return node;
	}

	public boolean deleteMiddleNode(Node n){
		if(n == null || n.next == null){
			return false;
		}
		Node next = n.next;
		n.label = next.label;
		n.next = next.next;
		return true;
	}

	public Node partition(Node head, int x){
		Node beforeStart = null;
		Node beforeEnd = null;
		Node afterStart = null;
		Node afterEnd = null;

		while(head != null){
			Node nodeNext = head.next;
			head.next = null;
			System.out.println("Label: " + head.label);
			if(head.label < x){
				if(beforeStart == null){
					beforeStart = head;
					beforeEnd = beforeStart;
				}else{
					beforeEnd.next = head;
					beforeEnd = head;
				}
			//System.out.println("beforeStart: " + beforeStart.label);
			//System.out.println("beforeEnd: " + beforeEnd.label);
			}else{
				if(afterStart == null){
					afterStart = head;
					afterEnd = afterStart;		
				}else{
					afterEnd.next = head;
					afterEnd = head;
				}
			//System.out.println("afterStart: " + afterStart.label);
			//System.out.println("afterEnd: " + afterEnd.label);
			}
			head = nodeNext;
		}
		if(beforeStart == null){
			return afterStart;
		}
		System.out.println("beforeStart");
		display(beforeStart);
		System.out.println("afterStart");
		display(afterStart);
		beforeEnd.next = afterStart;
		return beforeStart;
	}

	public Node partition2(Node node, int x){
		Node head = node;
		Node tail = node;

		while(node != null){
			Node nodeNext = node.next;
			if(node.label < x){
				node.next = head;
				head = node;
			}else{
				tail.next = node;
				tail = node;
			} 

			node = nodeNext;
		}
		tail.next = null;
		return head;
	}

	public Node reverse(Node node){
		Node head = node; 
		Node tail = node; 

		while(node != null){
			Node next = node.next;
			node.next = head;
			head = node;
			node = next;
		}
		tail.next = null;
		return head;
	}

	public Node addLists(Node list1, Node list2, int carry){
		if(list1 == null && list2 == null && carry == 0){
			return null;
		}
		Node result = new Node(0);
		int value = carry;
		if(list1 != null){
			value += list1.label;
		}
		if(list2 != null){
			value += list2.label;
		}
		result.label = value % 10;

		if(list1 != null || list2 != null){
			Node more = addLists(list1 == null? null : list1.next,
								 list2 == null? null : list2.next,	
								 value >= 10 ? 1 : 0);
			result.next = more;
		}
		return result;
	}

	class PartialSum{
		public Node sum = null;
		public int carry;
	}

	public Node addListForward(Node list1, Node list2){
		int len1 = length(list1, 0);
		int len2 = length(list2, 0);

		if(len1 < len2){
			list1 = padList(list1, len2 - len1);
		}else{
			list2 = padList(list2, len1 - len2);
		}

		PartialSum sum = addListsHelper(list1, list2);
		if(sum.carry == 0){
			return sum.sum;
		}else{
			Node result = insertBefore(sum.sum, sum.carry);
			return result;
		}
	}

	private PartialSum addListsHelper(Node list1, Node list2){
		if(list1 == null && list2 == null){
			PartialSum sum = new PartialSum();
			return sum;
		}

		PartialSum sum = addListsHelper(list1.next, list2.next);

		int val = sum.carry + list1.label + list2.label;

		Node fullResult = insertBefore(sum.sum, val % 10);

		sum.sum = fullResult;
		sum.carry = val / 10;
		return sum;
	}

	private Node padList(Node list, int padding){
		Node head = list;
		for(int i = 0; i < padding; i++){
			head = insertBefore(head, 0);
		}
		return head;
	}

	private Node insertBefore(Node list, int data){
		Node node = new Node(data);
		if(list != null){
			node.next = list;
		}
		return node;
	}

	public int length(Node list, int length){
		if(list == null){
			return length;
		}
		return length(list.next, length + 1);
	}

	public boolean isPalindrome(Node head){
		Node reversed = reverseAndClone(head);
		return isEqual(head, reversed);
	}

	private Node reverseAndClone(Node node){
		Node head = null;
		while(node != null){
			Node n = new Node(node.label); //Clone
			n.next = head;
			head = n;
			node = node.next;
		}
		return head;
	}

	private boolean isEqual(Node one, Node two){
		while(one != null && two != null){
			if(one.label != two.label){
				return false;
			}
			one = one.next;
			two = two.next;
		}
		return one == null && two == null;
	}

	public boolean isPalindrome2(Node head){
		Node fast = head;
		Node slow = head;
		Stack<Integer> stack = new Stack<>();

		while(fast != null && fast.next != null){
			stack.push(slow.label);
			fast = fast.next.next;
			slow = slow.next;
		}

		if(fast != null){
			slow = slow.next;
		}

		while(slow != null){
			int top = stack.pop().intValue();

			if(top != slow.label){
				return false;
			}
			slow = slow.next;
		}
		return true;
	}

	public boolean isPalindrome3(Node head){
		Map<Integer,Integer> counts = new HashMap<>();
		Node node = head;
		while(node != null){
			int label = node.label;
			if(counts.containsKey(label)){
				counts.put(label, counts.get(label) + 1);
			}else{
				counts.put(label, 1);
			}
			node = node.next;
		}
		int count = 0;
		for(Map.Entry<Integer,Integer> element : counts.entrySet()){
			int key = element.getKey();
			int value = element.getValue();
			count += value % 2;
		}
		return count <= 1;
	}

	class Result{
		public Node node;
		public boolean result;
		public Result(Node node, boolean result){
			this.node = node;
			this.result = result;
		}
	}

	public boolean isPalindrome4(Node head){
		int length = lengthOfList(head, 0);
		System.out.println("length: " + length);
		Result p = isPalindromeRecurse(head, length);
		return p.result;
	}

	public Result isPalindromeRecurse(Node head, int length){
		System.out.println("before recursion: " + head.label);
		if(head == null || length <= 0){
			return new Result(head, true);
		}else if(length == 1){
			return new Result(head.next, true);
		}

		Result res = isPalindromeRecurse(head.next, length - 2);
		System.out.println("Result res: " + res.node.label);
		System.out.println("head: " + head.label);
		if(!res.result || res.node == null){
			return res;
		}

		res.result = (head.label == res.node.label);
		res.node = res.node.next;
		return res;
	}


	public int lengthOfList(Node node, int size){
		if(node == null){
			return size;
		}
		return lengthOfList(node.next, size + 1);
	}

	public Node findIntersection(Node list1, Node list2){
		if(list1 == null || list2 == null){
			return null;
		}

		ResultTail result1 = getTailAndSize(list1);
		ResultTail result2 = getTailAndSize(list2);
		System.out.println("result1.tail: " + result1.tail.label);
		System.out.println("result2.tail: " + result2.tail.label);

		// No intersection
		if(result1.tail != result2.tail){
			return null;
		}

		Node shorter = result1.size < result2.size ? list1 : list2;
		Node longer = result1.size < result2.size ? list2 : list1;

		longer = getKthNode(longer, Math.abs(result1.size - result2.size));
		System.out.println("longer: " + longer.label);

		while(shorter != longer){
			shorter = shorter.next;
			longer = longer.next;
		}
		return longer;
	}

	class ResultTail{
		public Node tail;
		public int size;
		public ResultTail(Node tail, int size){
			this.tail = tail;
			this.size = size;
		}
	}

	private ResultTail getTailAndSize(Node list){
		if(list == null){
			return null;
		}

		int size = 1;
		Node current = list;
		while(current.next != null){
			size++;
			current = current.next;
		}
		return new ResultTail(current, size);
	}

	private Node getKthNode(Node head, int k){
		Node current = head;
		while(k > 0 && current != null){
			current = current.next;
			k--;
		}
		return current;
	}	

	public Node findBeggining(Node head){
		System.out.println("here");
		Node slow = head;
		Node fast = head;

		while(fast != null && fast.next != null){
			slow = slow.next;
			fast = fast.next.next;
			if(slow == fast){
				break;
			}
		}
		System.out.println("fast: " + fast.label);

		if(fast == null || fast.next == null){
			return null;
		}

		slow = head;
		System.out.println("head slow: " + slow.label);
		while(slow != fast){
			System.out.println("loop slow: " + slow.label);
			slow = slow.next;
			fast = fast.next;
		}

		System.out.println("collision slow: " + slow.label);
		return fast;
	}

}