package cracking.stackqueue;

import org.junit.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;


public class AnimalShelterTest {

	private AnimalShelter animalShelter = new AnimalShelter();
	

	@Test
	public void enqueue(){
		Animal dog1 = new Animal();
		dog1.type = Type.DOG;
		animalShelter.enqueue(dog1);

		Animal dog2 = new Animal();
		dog2.type = Type.DOG;
		animalShelter.enqueue(dog2);

		Animal cat1 = new Animal();
		cat1.type = Type.CAT;
		animalShelter.enqueue(cat1);

		Animal cat2 = new Animal();
		cat2.type = Type.CAT;
		animalShelter.enqueue(cat2);

		assertThat(animalShelter.dequeue(), is(dog1));
		assertThat(animalShelter.dequeueCat(), is(cat1));
		assertThat(animalShelter.dequeueCat(), is(cat2));
		assertThat(animalShelter.dequeueDog(), is(dog2));
	}
}