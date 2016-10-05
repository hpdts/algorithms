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

	/*@Test
	public void partition(){
		linkedList.add(10);
    	linkedList.add(30);
    	linkedList.add(40);
    	linkedList.add(50);
    	linkedList.add(52);
    	linkedList.add(34);
    	linkedList.add(5);
    	linkedList.root = linkedList.partition(linkedList.root, 50);
		assertThat(linkedList.toString(), is("5,10,30,34,40,50,52"));
	}*/

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
}
