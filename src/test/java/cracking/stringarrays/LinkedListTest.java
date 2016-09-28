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
	public void secondMiddleElementOnePass(){
		//even list
		linkedList.add(1);
    	linkedList.add(2);
    	linkedList.add(3);
    	linkedList.add(4);
    	linkedList.add(5);
    	linkedList.add(6);
		assertThat(linkedList.middleElementOnePass(), is(3));
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
		assertThat(linkedList.middleElementOnePass(), is(6));
	}

	@Test
	public void middleElementOnePass(){
		//odd list
		linkedList.add(1);
    	linkedList.add(2);
    	linkedList.add(3);
    	linkedList.add(4);
    	linkedList.add(5);
		assertThat(linkedList.middleElementOnePass(), is(3));
	}
}
