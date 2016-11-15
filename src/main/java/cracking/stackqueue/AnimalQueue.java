package cracking.stackqueue;

import java.util.*;


 public class AnimalQueue {
	LinkedList<Dog> dogs = new LinkedList<Dog>();
	LinkedList<Cat> cats = new LinkedList<Cat>();
	private int order = 0; // acts as timestamp

	public void enqueue(AnimalBook a) {

		/* Order is used as a sort of timestamp, so that we can
		* compare the insertion order of a dog to a cat. */
		 a.setOrder(order);
		 order++;	
	
		 if (a instanceof Dog){
		 	dogs.addLast((Dog) a);
		 } 
		 else if (a instanceof Cat){
		 	 cats.addLast((Cat)a);
		 }
 	}

	 public AnimalBook dequeueAny() {
		/* Look at tops of dog and cat queues, and pop the stack
		 * with the oldest value. */
		if (dogs.size() == 0) {
		 	return dequeueCats();
		 } else if (cats.size() == 0) {
		 	return dequeueDogs();
		 }
		
		 Dog dog = dogs.peek();
		 Cat cat = cats.peek();
		 if (dog.isOlderThan(cat)) {
		 	return dequeueDogs();
		 } else {
		 	return dequeueCats();
	 }
	}

 	public Dog dequeueDogs() {
 		return dogs.poll();
 	}

	public Cat dequeueCats() {
 		return cats.poll();
 	}
 }

 abstract class AnimalBook {
	private int order;
	protected String name;

	public AnimalBook(String n) {
		name = n;
	}
	
	public void setOrder(int ord) {
		order = ord;
	}
	
	 public int getOrder() {
	 	return order;
	 }
	
	 public boolean isOlderThan(AnimalBook a) {
	 	return this.order < a.getOrder();
	 }
}
  class Dog extends AnimalBook {
 	public Dog(String n) {
 		super(n);
 	}
 }

 class Cat extends AnimalBook {
 		public Cat(String n) {
 			super(n);
 	}
 }