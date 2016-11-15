package cracking.stackqueue;

import java.util.*;

	class Animal{
		Type type;
	}

	enum Type {DOG, CAT};

public class AnimalShelter {
	private Queue<Animal> animals = new LinkedList<>();

	public void enqueue(Animal animal){
		animals.add(animal);
	}

	public Animal dequeue(){
		return animals.remove();
	}

	public Animal dequeueAnimal(Type type){
		List<Animal> animalTmp = new ArrayList<>();
		Animal ani = animals.peek();

		while(animals.peek() != null &&  animals.peek().type != type){
			animalTmp.add(animals.remove());
		}
		Animal animal = animals.remove();
		if(animalTmp.size() > 0){
			animals.addAll(animalTmp);
		}
		return animal;
	}

	public Animal dequeueDog(){
		return dequeueAnimal(Type.DOG);
	}

	public Animal dequeueCat(){
		return dequeueAnimal(Type.CAT);
	}
}