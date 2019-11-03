package cracking.reboot.stringarrays;

import org.junit.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;


public class MyArrayListTest {

	private MyArrayList myArrayList = new MyArrayList();

	@Test
	public void add(){
		myArrayList.add(1);
		myArrayList.add(2);
		myArrayList.add(3);
		myArrayList.add(4);
		myArrayList.add(5);
		myArrayList.add(6);
		myArrayList.add(7);
		myArrayList.add(8);
		myArrayList.add(9);
		myArrayList.add(10);
		myArrayList.add(11);
		System.out.println("MyArrayList: " + myArrayList.toString());

		for(int number : myArrayList){
			System.out.println("number: " + number);
		}
	}

}