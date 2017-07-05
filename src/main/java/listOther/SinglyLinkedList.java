package listOther;

import java.util.*;

public class SinglyLinkedList {

	public static class Node{
		int val;
		Node next;
		Node(int val){
			this.val = val;
			next = null;
		}

		public String toString(){
			return "val: " + val + ", next: " + next;
		}
	}

	public static class NodeRandom{
		int val;
		NodeRandom next;
		NodeRandom random;

		NodeRandom(int val){
			this.val = val;
			next = null;
			random = null;
		}

		/*public String toString(){
			return "val: " + val + ", next: " + next + ", random: " + random;
		}*/
	}

	public void deDuplication(Node head){
		Set<Integer> uniqueNumbers = new HashSet<>();
		Node lastUnique = head;
		Node runner = head;

		while(runner != null){
			int value = runner.val;
			if(uniqueNumbers.contains(value)){
				lastUnique.next = lastUnique.next.next;
			}else{
				uniqueNumbers.add(value);
				lastUnique = runner;
			}

			runner = runner.next;
		}
	}

	public void deDuplicationOnePointer(Node head){
		Set<Integer> uniqueNumbers = new HashSet<>();
		uniqueNumbers.add(head.val);
		Node runner = head;

		while(runner.next != null){
			int nextValue = runner.next.val;
			if(!uniqueNumbers.add(nextValue)){
				runner.next = runner.next.next;
			}else{
				runner = runner.next;
			}
		}
	}

	public void deDuplicationRecursive(Node prev, Node next, Set<Integer> uniques){
		if(prev == null || next == null){
			return;
		}else if(uniques.contains(next.val)){
			prev.next = prev.next.next;
		}else{
			prev = prev.next;
			uniques.add(prev.val);
		}
		deDuplicationRecursive(prev, prev.next, uniques);
	}

	public void reorder(Node start){
		//get the middle, reverse and merge both lists
		System.out.println("here ");
		Node middle = getMiddle(start);
		System.out.println("middle: " + middle.val);


		Node secondList = middle.next;
		middle.next = null;

		secondList = reverseOrder(secondList);

		System.out.println("First List: " + start);
		System.out.println("Reverse List: " + secondList);
		Node p1 = start;
		Node p2 = secondList;

		//merge two lists here
		while (p2 != null) {
			Node temp1 = p1.next;
			Node temp2 = p2.next;

			p1.next = p2;
			p2.next = temp1;		

			p1 = temp1;
			p2 = temp2;
		}

	}

	public  Node reverseOrder(Node head) {
		if (head == null || head.next == null) {
			return head;
		}
 
		Node previous = head;
		Node current = head.next;
 
		while (current != null) {
			Node temp = current.next;
			current.next = previous;
			previous = current;
			current = temp;
		}
 
		// set head node's next
		head.next = null;
 
		return previous;
	}

	public Node getMiddle(Node start){
		Node runnerSlow = start;
		Node runnerFast = start;

		while(runnerFast != null && runnerFast.next != null && runnerFast.next.next!= null){
			runnerSlow = runnerSlow.next;
			runnerFast = runnerFast.next.next;
		}

		return runnerSlow;
	}

	public Node getEnd(Node start){
		Node runner = start;
		while(runner.next != null){
			runner = runner.next;
		}
		return runner;
	}

	public Node getPrevious(Node start, Node after){
		Node runner = start;
		while(runner.next != after){
			runner = runner.next;
		}
		return runner;
	}

	public void swap(Node origin, Node node1, Node node2){
		//Node tempNode2 = node2;
		//Node previousNode2 = getPrevious(origin, node2);


		node2.next = node1.next;
		node1.next = null;
		//origin = node2
		//previousNode2.next = node1;
		//node1.next = tempNode2.next;
	}

	public boolean hasCycle(Node head) {
        Node fast = head;
        Node slow = head;
 
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
 
            if(slow == fast)
                return true;
        }
 
        return false;
    }

    public NodeRandom copyRandomList(NodeRandom head) {
 
		if (head == null)
			return null;
	 
		NodeRandom p = head;
	 
		// copy every node and insert to list
		//1 - 1 - 2 - 2 adding duplicates in a new list
		while (p != null) {
			NodeRandom copy = new NodeRandom(p.val);
			copy.next = p.next;
			p.next = copy;
			p = copy.next;
		}
	 
	 	System.out.println("after duplication : " + head);
		// copy random pointer for each new node
		p = head;
		while (p != null) {
			if (p.random != null){
				p.next.random = p.random.next;
			}
			p = p.next.next;
		}
	 
	 	System.out.println("after random : " + head);
		// break list to two
		p = head;
		NodeRandom newHead = head.next;
		while (p != null) {
			NodeRandom temp = p.next;
			p.next = temp.next;
			if (temp.next != null){
				temp.next = temp.next.next;
			}
			p = p.next;
		}
	 	System.out.println("newHead: " + newHead);
		return newHead;
	}

	public NodeRandom copyRandomListMap(NodeRandom head) {
		if (head == null){
			return null;
		}

		Map<NodeRandom, NodeRandom> map = new HashMap<NodeRandom, NodeRandom>();
		NodeRandom newHead = new NodeRandom(head.val);
	 
		NodeRandom p = head;
		NodeRandom q = newHead;
		map.put(head, newHead);
	 
		p = p.next;
		while (p != null) {
			NodeRandom temp = new NodeRandom(p.val);
			map.put(p, temp);
			q.next = temp;
			q = temp;
			p = p.next;
		}
	 
		p = head;
		q = newHead;
		while (p != null) {
			if (p.random != null)
				q.random = map.get(p.random);
			else
				q.random = null;
	 
			p = p.next;
			q = q.next;
		}
	 
		return newHead;
	}

	public Node mergeTwoLists(Node l1, Node l2) {
	    Node head = new Node(0);
	    Node p = head;
	 
	    while(l1 != null || l2 != null){
	        if(l1 != null && l2 != null){
	            if(l1.val < l2.val){
	                p.next = l1;
	                l1 = l1.next;
	            }else{
	                p.next = l2;
	                l2 = l2.next;
	            }
	            p = p.next;
	        }else if(l1 == null){
	            p.next = l2;
	            break;
	        }else if(l2 == null){
	            p.next = l1;
	            break;
	        }
	    }
	 
	    return head.next;
	}

	public Node mergeTwoLists2(Node l1, Node l2) {
	    Node head = new Node(0);
	    Node p=head;
	 
	    Node p1=l1;
	    Node p2=l2;
	    while(p1!=null && p2!=null){
	        if(p1.val < p2.val){
	            p.next = p1;
	            p1 = p1.next;
	        }else{
	            p.next = p2;
	            p2 = p2.next;
	        }
	        p=p.next;
	    }
	 
	    if(p1!=null){
	        p.next = p1;
	    }
	 
	    if(p2!=null){
	        p.next = p2;
	    }
	 
	    return head.next;
	}

	public Node oddEvenList(Node head) {
	    if(head == null) 
	        return head;
	 
	    Node result = head;
	    Node p1 = head;
	    Node p2 = head.next;
	    Node connectNode = head.next;
	 
	    while(p1 != null && p2 != null){
	            Node t = p2.next;
	            if(t == null)
	                break;
	 
	            p1.next = p2.next;
	            p1 = p1.next;
	 
	            p2.next = p1.next;
	            p2 = p2.next;
	    }
	 
	    p1.next = connectNode;
	 
	    return result;
	}

	public Node deleteDuplicates(Node head) {
        if(head == null || head.next == null){
            return head;
        }
 
        Node p = head;
 
        while( p!= null && p.next != null){
            if(p.val == p.next.val){
                p.next = p.next.next;
            }else{
                p = p.next; 
            }
        }
 
        return head;
    }

    public Node deleteDuplicates2(Node head) {
        if(head == null || head.next == null)
            return head;
 
        Node prev = head;    
        Node p = head.next;
 
        while(p != null){
            if(p.val == prev.val){
                prev.next = p.next;
                p = p.next;
                //no change prev
            }else{
                prev = p;
                p = p.next; 
            }
        }
 
        return head;
    }

    public Node rearrange(Node head){
    	// splitting lists
		Node middle = getMiddle(head);
		Node head2 = middle.next;
		middle.next = null;
		System.out.println("First half: " + head);
		System.out.println("Second half: " + head2);

		Node reverseHead2 = reverseOrder(head2);
		System.out.println("reverseHead2: " + reverseHead2);

		return head2;
    }

	public Node removeOddNumbers(Node head){
		//first check header
		Node temp = null;
		while(head != null && head.val % 2 ==0 ){
			temp = head.next;
			head.next = null;
			head = temp;
		}

		System.out.println("head: " + head.val);
		Node lastOdd = head;
		temp = lastOdd.next;

		while(lastOdd.next != null){
			System.out.println("lastOdd: " + lastOdd.val);
			if(temp.val % 2 == 0){
				lastOdd.next = lastOdd.next.next;
				temp.next = null;
			}else{
				lastOdd = temp;
			}
			temp = lastOdd.next;
		}

		return head;

	}
    
}