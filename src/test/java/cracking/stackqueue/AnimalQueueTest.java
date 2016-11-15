package cracking.stackqueue;

import org.junit.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;


public class AnimalQueueTest {

	private AnimalQueue animalQueue = new AnimalQueue();
	

	@Test
	public void enqueue(){
		Dog dog1 = new Dog("dog1");
		animalQueue.enqueue(dog1);

		Dog dog2 = new Dog("dog2");
		animalQueue.enqueue(dog2);

		Cat cat1 = new Cat("cat1");
		animalQueue.enqueue(cat1);

		Cat cat2 = new Cat("cat2");
		animalQueue.enqueue(cat2);

		assertThat(animalQueue.dequeueAny().name, is("dog1"));
		assertThat(animalQueue.dequeueCats().name, is("cat1"));
		assertThat(animalQueue.dequeueCats().name, is("cat2"));
		assertThat(animalQueue.dequeueDogs().name, is("dog2"));
	}
}