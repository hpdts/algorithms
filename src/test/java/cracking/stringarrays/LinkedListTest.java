package cracking.stringarrays;

import org.junit.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;


public class LinkedListTest {

	private LinkedList linkedList = new LinkedList();
	
	@Before
    public void setUp() {
    	
    }

	@Test
	public void removeDuplicates(){
		linkedList.add(1);
    	linkedList.add(2);
    	linkedList.add(2);
    	linkedList.add(3);
		linkedList.removeDuplicates();
		assertThat(linkedList.toString(), is("3,2,1"));
	}

	@Test
	public void removeDuplicatesAtTheEnd(){
		linkedList.add(10);
    	linkedList.add(4);
    	linkedList.add(20);
    	linkedList.add(4);
		linkedList.removeDuplicates();
		assertThat(linkedList.toString(), is("4,20,10"));
	}

	@Test
	public void removeDuplicatesWithoutSet(){
		linkedList.add(1);
    	linkedList.add(2);
    	linkedList.add(2);
    	linkedList.add(3);
		linkedList.removeDuplicatesWithoutSet();
		assertThat(linkedList.toString(), is("3,2,1"));
	}


	@Test
	public void removeDuplicatesWithoutSetAtTheEnd(){
		linkedList.add(10);
    	linkedList.add(4);
    	linkedList.add(20);
    	linkedList.add(4);
		linkedList.removeDuplicatesWithoutSet();
		assertThat(linkedList.toString(), is("4,20,10"));
	}

	@Test
	public void deleteDuplicates(){
		linkedList.add(10);
    	linkedList.add(4);
    	linkedList.add(20);
    	linkedList.add(4);
		linkedList.deleteDuplicates();
		assertThat(linkedList.toString(), is("4,20,10"));
	}

	@Test
	public void secondMiddleElementOnePass(){
		//even list
		linkedList.add(1);
    	linkedList.add(2);
    	linkedList.add(3);
    	linkedList.add(4);
    	linkedList.add(5);
    	linkedList.add(6);
		assertThat(linkedList.middleElementOnePass().number, is(3));
	}

	@Test
	public void secondMiddleElementOnePassBig(){
		//even list
		linkedList.add(1);
    	linkedList.add(2);
    	linkedList.add(3);
    	linkedList.add(4);
    	linkedList.add(5);
    	linkedList.add(6);
    	linkedList.add(10);
    	linkedList.add(20);
    	linkedList.add(30);
    	linkedList.add(54);
    	linkedList.add(15);
    	linkedList.add(23);
		assertThat(linkedList.middleElementOnePass().number, is(6));
	}

	@Test
	public void middleElementOnePass(){
		//odd list
		linkedList.add(1);
    	linkedList.add(2);
    	linkedList.add(3);
    	linkedList.add(4);
    	linkedList.add(5);
		assertThat(linkedList.middleElementOnePass().number, is(3));
	}

	@Test
	public void findElements(){
		linkedList.add(1);
    	linkedList.add(2);
    	linkedList.add(3);
    	linkedList.add(4);
    	linkedList.add(5);
		assertThat(linkedList.findElements(3), is("3;2;1"));
	}

	@Test
	public void findElementsFromSecond(){
		linkedList.add(1);
    	linkedList.add(2);
    	linkedList.add(3);
    	linkedList.add(4);
    	linkedList.add(5);
    	linkedList.add(6);
		assertThat(linkedList.findElements(2), is("5;4;3;2;1"));
	}

	@Test
	public void findElementsRecursive(){
		linkedList.add(1);
    	linkedList.add(2);
    	linkedList.add(3);
    	linkedList.add(4);
    	linkedList.add(5);
    	linkedList.add(6);
    	linkedList.nthToLast(linkedList.root, 2);
		//assertThat(linkedList.nthToLast(2), is("5;4;3;2;1"));
	}

	@Test
	public void removeMiddleOdd(){
		linkedList.add(10);
    	linkedList.add(30);
    	linkedList.add(20);
    	linkedList.add(40);
    	linkedList.add(50);
		linkedList.removeMiddle();
		assertThat(linkedList.toString(), is("50,40,30,10"));
	}


	@Test
	public void removeMiddleEven(){
		linkedList.add(10);
    	linkedList.add(30);
    	linkedList.add(40);
    	linkedList.add(50);
		linkedList.removeMiddle();
		assertThat(linkedList.toString(), is("50,40,10"));
	}

	@Test
	public void middleElementRemove(){
		linkedList.add(1);
    	linkedList.add(2);
    	linkedList.add(3);
    	linkedList.add(4);
    	linkedList.add(5);
    	LinkedList.Node middle = linkedList.middleElementOnePass();
    	assertTrue(linkedList.deleteNode(middle));

		assertThat(linkedList.toString(), is("5,4,2,1"));
	}

	@Test
	public void partition2(){
		linkedList.add(10);
    	linkedList.add(30);
    	linkedList.add(40);
    	linkedList.add(50);
    	linkedList.add(52);
    	linkedList.add(34);
    	linkedList.add(5);
    	linkedList.root = linkedList.partition2(linkedList.root, 50);
		assertThat(linkedList.toString(), is("10,30,40,34,5,50,52"));
	}

	@Test
	public void convertToNumber(){
    	linkedList.add(6);
    	linkedList.add(1);
		linkedList.add(7);
		assertThat(linkedList.convertToNumber(linkedList), is(617));
		LinkedList numberList = new LinkedList();
		linkedList.numberToList(617, numberList);
		assertThat(linkedList.toString(), is("7,1,6"));
	}

	@Test
	public void sumList(){
    	linkedList.add(6);
    	linkedList.add(1);
		linkedList.add(7);
		assertThat(linkedList.convertToNumber(linkedList), is(617));

		LinkedList operand2 = new LinkedList();
		operand2.add(2);
    	operand2.add(9);
		operand2.add(5);
		assertThat(operand2.convertToNumber(operand2), is(295));
		LinkedList result = new LinkedList();
		result = operand2.sumList(linkedList, operand2);
		assertThat(result.toString(), is("2,1,9"));
	}


	@Test
	public void sumListForward(){
		linkedList.add(7);
    	linkedList.add(1);
    	linkedList.add(6);
		assertThat(linkedList.convertToNumberForward(linkedList), is(617));

		LinkedList operand2 = new LinkedList();
		operand2.add(5);
    	operand2.add(9);
		operand2.add(2);
		assertThat(operand2.convertToNumberForward(operand2), is(295));
		LinkedList result = new LinkedList();
		result = operand2.sumListForward(linkedList, operand2);
		assertThat(result.toString(), is("9,1,2"));
	}

	@Test
	public void addListFromBook(){
    	linkedList.add(6);
    	linkedList.add(1);
		linkedList.add(7);

		LinkedList operand2 = new LinkedList();
		operand2.add(2);
    	operand2.add(9);
		operand2.add(5);

		LinkedList result = new LinkedList();
		result.root = operand2.addLists(linkedList.root, operand2.root, 0);
		assertThat(result.toString(), is("2,1,9"));
	}

	@Test
	public void padList(){
    	linkedList.add(6);
    	linkedList.add(1);

		LinkedList result = new LinkedList();
		result.root = linkedList.padList(linkedList.root, 3);
		assertThat(result.toString(), is("1,6,0,0,0"));
	}


	@Test
	public void insertBefore(){
    	linkedList.add(6);
    	linkedList.add(1);

		LinkedList result = new LinkedList();
		result.root = linkedList.insertBefore(linkedList.root, 3);
		assertThat(result.toString(), is("3,1,6"));
	}

	@Test
	public void circularList(){
    	linkedList.add(6);
    	linkedList.add(1);
    	linkedList.add(7);
    	linkedList.add(9);
    	linkedList.addLoop(7);
		LinkedList.Node result;
		result = linkedList.isCircular();
		assertThat(result.number, is(7));
	}

	@Test
	public void circularListBook(){
    	linkedList.add(6);
    	linkedList.add(1);
    	linkedList.add(7);
    	linkedList.add(9);
    	linkedList.addLoop(7);
		LinkedList.Node result;
		result = linkedList.findBeginning(linkedList.root);
		assertThat(result.number, is(7));
	}

	@Test
	public void sumListForwardfromBook(){
		linkedList.add(7);
    	linkedList.add(1);
    	linkedList.add(6);
		assertThat(linkedList.convertToNumberForward(linkedList), is(617));

		LinkedList operand2 = new LinkedList();
		operand2.add(5);
    	operand2.add(9);
		operand2.add(2);
		assertThat(operand2.convertToNumberForward(operand2), is(295));
		LinkedList result = new LinkedList();

		result.root = operand2.addLists(linkedList.root, operand2.root);
		assertThat(result.toString(), is("9,1,2"));
	}

	@Test
	public void isPalindrome(){
    	linkedList.add(1);
    	linkedList.add(0);
    	linkedList.add(1);
		assertTrue(linkedList.isPalindrome());
	}

	@Test
	public void isPalindromeBook(){
    	linkedList.add(1);
    	linkedList.add(0);
    	linkedList.add(1);
		assertTrue(linkedList.isPalindromeBook(linkedList.root));
		linkedList = new LinkedList();
		linkedList.add(0);
    	linkedList.add(1);
    	linkedList.add(2);
    	linkedList.add(1);
    	linkedList.add(0);
		assertTrue(linkedList.isPalindromeBook(linkedList.root));
		linkedList = new LinkedList();
		linkedList.add(9);
    	linkedList.add(10);
		assertFalse(linkedList.isPalindromeBook(linkedList.root));
		linkedList = new LinkedList();
		linkedList.add(9);
    	linkedList.add(9);
		assertTrue(linkedList.isPalindromeBook(linkedList.root));
	}

	@Test
	public void isPalindromeBookRecurse(){
    	linkedList.add(1);
    	linkedList.add(0);
    	linkedList.add(1);
		assertTrue(linkedList.isPalindromeRecursion(linkedList.root));
		linkedList = new LinkedList();
		linkedList.add(0);
    	linkedList.add(1);
    	linkedList.add(2);
    	linkedList.add(1);
    	linkedList.add(0);
		assertTrue(linkedList.isPalindromeRecursion(linkedList.root));
		linkedList = new LinkedList();
		linkedList.add(9);
    	linkedList.add(10);
		assertFalse(linkedList.isPalindromeRecursion(linkedList.root));
		linkedList = new LinkedList();
		linkedList.add(9);
    	linkedList.add(9);
		assertTrue(linkedList.isPalindromeRecursion(linkedList.root));
	}
}
