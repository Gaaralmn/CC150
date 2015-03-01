/**
 * CC150 3.7 Implement an animal shelter with " first-in, first out " function.
 * @author Qing Wang
 * Tag: Object-Oriented Design
 *   
 */
import java.util.*;
/**
 * Not good at using inheritance yet!!!!
 */
class Dog extends Animal {
	public Dog(String n) {
		super(n);
	}
}

class Cat extends Animal {
	public Cat(String n) {
		super(n);
	}
}

public class petsShelter {
	private LinkedList<Dog> dogList = new LinkedList<Dog>();
	private LinkedList<Cat> catList = new LinkedList<Cat>();
	private int order = 0;  // Seems like a global variable.
/**
 * Test 
 */
	public static void main(String[] args) {
		petsShelter pS = new petsShelter();
		/*
		pS.enqueue(new Dog("d1"));
		pS.enqueue(new Dog("d2"));
		pS.enqueue(new Dog("d3"));
		pS.enqueue(new Cat("c1"));
		pS.enqueue(new Cat("c2"));
		pS.enqueue(new Cat("d4"));
		
		
		System.out.println(pS.dequeueAny().getName());
		System.out.println(pS.dequeueAny().getName());*/
	}

	public void enqueue(Animal animal) {
		animal.setOrder(order);
		order++;
		if(animal instanceof Cat) {
			catList.addLast((Cat)animal);  //That's the real polymorphism
			// Also forget to transform the Object types!
			System.out.println("The animal added is a cat!");
		} else if(animal instanceof Dog) {
			dogList.addLast((Dog)animal);  //That's the real polymorphism
			// Also forget to transform the Object types!
			System.out.println("The animal added is a dog!");
		}
				}

	public Cat dequeueCat() {
		return catList.removeFirst();
	}

	public Dog dequeueDog() {
		return dogList.removeFirst();
	}

	public Animal dequeueAny() {
		if(dogList.size() == 0) {
			return dequeueCat();
		} else if(catList.size() == 0) {
			return dequeueDog();
		}

		Dog dog = dogList.peek();
		Cat cat = catList.peek();
		if(dog.isOlderThan(cat)) {
			return dequeueDog();
		} else {
			return dequeueCat();
		}
	}

	/*
	public void enqueueAny(Animal a) {
		if(a instanceof Dog) {
			addTo(dogList, (Dog)a);
		} else {
			addTo(catList, (Cat)a);
		}
	}

	
	//Bad attemption to use polymorphism!!!!!
	public void addTo(LinkedList<Animal> animallist, Animal animal) {
		if(animallist.size() == 0) {
			animal.setOrder(1);
		} else {
			animal.setOrder(animallist.getLast().getOrder() + 1);
		}
		animallist.add(animal);
	}
	*/
	
}