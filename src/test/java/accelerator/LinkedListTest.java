package accelerator;

import org.junit.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import java.util.*;

public class LinkedListTest {
	LinkedList linkedList = new LinkedList();

	@Test
    public void list(){
    	linkedList.append(1);
    	linkedList.append(3);
    	linkedList.append(4);
    	linkedList.display();
    	linkedList.insert(2, 1);
    	linkedList.display();
    	linkedList.insert(5, 0);
    	System.out.println("------");
    	linkedList.display();
    	assertTrue(linkedList.contains(4));  
    	assertFalse(linkedList.contains(40));  
    	System.out.println("Remove ------");
    	linkedList.delete(0);
    	linkedList.display();
    	System.out.println("Remove2 ------");
    	linkedList.delete(2);
    	linkedList.display();
    	System.out.println("Remove2 ------");
    	linkedList.delete(1);
    	linkedList.display();
    }
    



}