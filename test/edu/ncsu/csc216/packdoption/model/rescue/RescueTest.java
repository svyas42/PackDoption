package edu.ncsu.csc216.packdoption.model.rescue;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.ncsu.csc216.packdoption.model.animals.Dog;
import edu.ncsu.csc216.packdoption.model.animals.Cat;
import edu.ncsu.csc216.packdoption.model.animals.Animal;
import edu.ncsu.csc216.packdoption.model.animals.Animal.Size;
import edu.ncsu.csc216.packdoption.model.animals.Dog.Breed;
import edu.ncsu.csc216.packdoption.util.Date;
import edu.ncsu.csc216.packdoption.util.Note;
import edu.ncsu.csc216.packdoption.util.SortedLinkedList;

/**
 * Tests the Rescue.java class
 * @author Sachi Vyas
 *
 */
public class RescueTest {
	/** The sorted linked list for the notes */
	SortedLinkedList<Note> notes = new SortedLinkedList<Note>();

	/**
	 * Test method for {@link edu.ncsu.csc216.packdoption.model.rescue.Rescue#Rescue(java.lang.String)}.
	 */
	@Test
	void testRescue() {
		Rescue rescue = new Rescue("res");
		assertTrue(rescue.getName().equals("res"));
		try {
			new Rescue(null);
			fail();
		} catch (IllegalArgumentException e) {
			// no need just catch exception
		}
		
		try {
			new Rescue(" ");
			fail();
		} catch (IllegalArgumentException e) {
			// no need just catch exception
		}
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.packdoption.model.rescue.Rescue#addAnimal(edu.ncsu.csc216.packdoption.model.animals.Animal)}.
	 */
	@Test
	void testAddAnimal() {
		Rescue rescue = new Rescue("res");
		Date birthday = new Date(11, 2, 2019);
		Date dateEnterRescue = new Date(12, 2, 2019);
		boolean houseTrained = true;
		boolean goodWithKids = true;
		Dog dog = new Dog("robin", birthday, Size.SMALL, houseTrained, goodWithKids, notes, 
				dateEnterRescue, Breed.BEAGLE);
		Cat cat = new Cat("robin", birthday, Size.SMALL, houseTrained, goodWithKids, notes, 
				dateEnterRescue);
		assertTrue(rescue.addAnimal(dog));
		assertFalse(rescue.addAnimal(cat));
		assertFalse(rescue.addAnimal(dog));
		assertEquals(dog, rescue.getAnimal(0));
		Exception e = assertThrows(IllegalArgumentException.class, () -> rescue.addAnimal(null));
		assertEquals(e.getMessage(), "animal is null");
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.packdoption.model.rescue.Rescue#getAnimal(int)}.
	 */
	@Test
	void testGetAnimalInt() {
		Rescue rescue = new Rescue("res");
		Date birthday = new Date(11, 2, 2019);
		Date dateEnterRescue = new Date(12, 2, 2019);
		boolean houseTrained = true;
		boolean goodWithKids = true;
		Dog dog1 = new Dog("robin", birthday, Size.SMALL, houseTrained, goodWithKids, notes, 
				dateEnterRescue, Breed.BEAGLE);
		rescue.addAnimal(dog1);
		assertEquals(dog1, rescue.getAnimal(0));
		try {
			rescue.getAnimal(-1);
			fail();
		} catch (IndexOutOfBoundsException e) {
			//no need
		}
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.packdoption.model.rescue.Rescue#getAnimal(java.lang.String, edu.ncsu.csc216.packdoption.util.Date)}.
	 */
	@Test
	void testGetAnimalStringDate() {
		Rescue rescue = new Rescue("res");
		Date birthday = new Date(11, 2, 2019);
		Date dateEnterRescue = new Date(12, 2, 2019);
		boolean houseTrained = true;
		boolean goodWithKids = true;
		Dog dog1 = new Dog("robin", birthday, Size.SMALL, houseTrained, goodWithKids, notes, 
				dateEnterRescue, Breed.BEAGLE);
		rescue.addAnimal(dog1);
		assertEquals(dog1, rescue.getAnimal("robin", birthday));
		
		try {
			rescue.getAnimal(null, birthday);
				fail();
		} catch (IllegalArgumentException e) {
			//just catch it
		}
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.packdoption.model.rescue.Rescue#contains(edu.ncsu.csc216.packdoption.model.animals.Animal)}.
	 */
	@Test
	void testContains() {
		Rescue rescue = new Rescue("res");
		Date birthday = new Date(11, 2, 2019);
		Date dateEnterRescue = new Date(12, 2, 2019);
		boolean houseTrained = true;
		boolean goodWithKids = true;
		Dog dog1 = new Dog("robin", birthday, Size.SMALL, houseTrained, goodWithKids, notes, 
				dateEnterRescue, Breed.BEAGLE);
		rescue.addAnimal(dog1);
		assertTrue(rescue.contains(dog1));
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.packdoption.model.rescue.Rescue#addNote(edu.ncsu.csc216.packdoption.model.animals.Animal, edu.ncsu.csc216.packdoption.util.Note)}.
	 */
	@Test
	void testAddNote() {
		Rescue rescue = new Rescue("res");
		Date birthday = new Date(11, 2, 2019);
		Date dateEnterRescue = new Date(12, 2, 2019);
		boolean houseTrained = true;
		boolean goodWithKids = true;
		Dog dog1 = new Dog("robin", birthday, Size.SMALL, houseTrained, goodWithKids, notes, 
				dateEnterRescue, Breed.BEAGLE);
		
		rescue.addAnimal(dog1);
		Note dog1Note = new Note(dateEnterRescue, "Born in NC");
		rescue.addNote(dog1, dog1Note);
		assertTrue(dog1.getNotes().contains(dog1Note));
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.packdoption.model.rescue.Rescue#setAdoptionInfo(edu.ncsu.csc216.packdoption.model.animals.Animal, boolean, edu.ncsu.csc216.packdoption.util.Date, java.lang.String)}.
	 */
	@Test
	void testSetAdoptionInfo() {
		Rescue rescue = new Rescue("res");
		Date birthday = new Date(2, 2, 2019);
		Date dateEnterRescue = new Date(9, 2, 2019);
		boolean houseTrained = true;
		boolean goodWithKids = true;
		Cat cat1 = new Cat("robin", birthday, Size.SMALL, houseTrained, goodWithKids, notes, 
				dateEnterRescue, true, new Date(10, 2, 2019), "Sachi");
		
		rescue.addAnimal(cat1);
		Date dateAdopted = new Date(10, 10, 2019);
		
		rescue.setAdoptionInfo(cat1, true, dateAdopted, "Sachi");
		assertEquals("Sachi", cat1.getOwner());
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.packdoption.model.rescue.Rescue#numAnimals()}.
	 */
	@Test
	void testNumAnimals() {
		Rescue rescue = new Rescue("res");
		Date birthday = new Date(2, 2, 2019);
		Date dateEnterRescue = new Date(9, 2, 2019);
		boolean houseTrained = true;
		boolean goodWithKids = true;
		Cat cat1 = new Cat("robin", birthday, Size.SMALL, houseTrained, goodWithKids, notes, 
				dateEnterRescue);
		
		rescue.addAnimal(cat1);
		assertEquals(cat1, rescue.getAnimal(0));
		assertEquals(1, rescue.numAnimals());
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.packdoption.model.rescue.Rescue#numAnimalsAvailable()}.
	 */
	@Test
	void testNumAnimalsAvailable() {
		Rescue rescue = new Rescue("res");
		Date birthday = new Date(2, 2, 2019);
		Date dateEnterRescue = new Date(9, 2, 2019);
		boolean houseTrained = true;
		boolean goodWithKids = true;
		Cat cat1 = new Cat("robin", birthday, Size.SMALL, houseTrained, goodWithKids, notes, 
				dateEnterRescue);
		
		rescue.addAnimal(cat1);
		assertEquals(cat1, rescue.getAnimal(0));
		assertEquals(1, rescue.numAnimalsAvailable());
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.packdoption.model.rescue.Rescue#numAnimalsAdopted()}.
	 */
	@Test
	void testNumAnimalsAdopted() {
		Rescue rescue = new Rescue("res");
		Date birthday = new Date(9, 2, 2018);
		Date dateEnterRescue = new Date(9, 2, 2019);
		boolean houseTrained = true;
		boolean goodWithKids = true;
		Cat cat1 = new Cat("robin", birthday, Size.SMALL, houseTrained, goodWithKids, notes, 
				dateEnterRescue, true, new Date(10, 12, 2020), "Jason");
		
		rescue.addAnimal(cat1);
		Date dateAdopted = new Date(10, 12, 2020);
		rescue.setAdoptionInfo(cat1, true, dateAdopted, "Sachi");
		assertTrue(rescue.animalsAdopted().contains(cat1));
		assertEquals("Sachi", cat1.getOwner());
		assertEquals(rescue.numAnimalsAdopted(), 1);
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.packdoption.model.rescue.Rescue#animalsAvailable()}.
	 */
	@Test
	void testAnimalsAvailable() {
		Rescue rescue = new Rescue("res");
		Date birthday = new Date(2, 2, 2019);
		Date dateEnterRescue = new Date(9, 2, 2019);
		boolean houseTrained = true;
		boolean goodWithKids = true;
		Cat cat1 = new Cat("robin", birthday, Size.SMALL, houseTrained, goodWithKids, notes, 
				dateEnterRescue);
		
		rescue.addAnimal(cat1);
		assertTrue(rescue.animalsAvailable().contains(cat1));
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.packdoption.model.rescue.Rescue#availableCats()}.
	 */
	@Test
	void testAvailableCats() {
		Rescue rescue = new Rescue("res");
		Date birthday = new Date(2, 2, 2019);
		Date dateEnterRescue = new Date(9, 2, 2019);
		boolean houseTrained = true;
		boolean goodWithKids = true;
		Cat cat1 = new Cat("robin", birthday, Size.SMALL, houseTrained, goodWithKids, notes, 
				dateEnterRescue);
		
		rescue.addAnimal(cat1);
		assertTrue(rescue.availableCats().contains(cat1));
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.packdoption.model.rescue.Rescue#availableDogs()}.
	 */
	@Test
	void testAvailableDogs() {
		Rescue rescue = new Rescue("res");
		Date birthday = new Date(11, 2, 2019);
		Date dateEnterRescue = new Date(12, 2, 2019);
		boolean houseTrained = true;
		boolean goodWithKids = true;
		Dog dog1 = new Dog("robin", birthday, Size.SMALL, houseTrained, goodWithKids, notes, 
				dateEnterRescue, Breed.BEAGLE);
		
		rescue.addAnimal(dog1);
		assertTrue(rescue.availableDogs().contains(dog1));
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.packdoption.model.rescue.Rescue#animalsAdopted()}.
	 */
	@Test
	void testAnimalsAdopted() {
		Rescue rescue = new Rescue("res");
		Date birthday = new Date(2, 2, 2019);
		Date dateEnterRescue = new Date(9, 2, 2019);
		boolean houseTrained = true;
		boolean goodWithKids = true;
		Cat cat1 = new Cat("robin", birthday, Size.SMALL, houseTrained, goodWithKids, notes, 
				dateEnterRescue);
		rescue.addAnimal(cat1);
		Date dateAdopted = new Date(10, 12, 2020);
		rescue.setAdoptionInfo(cat1, true, dateAdopted, "Sachi");
		assertEquals(cat1, rescue.animalsAdopted().get(0));
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.packdoption.model.rescue.Rescue#availableAnimalsDayRange(edu.ncsu.csc216.packdoption.util.Date, int, int)}.
	 */
	@Test
	void testAvailableAnimalsDayRange() {
		Rescue rescue = new Rescue("res");
		Date birthday = new Date(2, 2, 2019);
		Date dateEnterRescue = new Date(9, 2, 2021);
		boolean houseTrained = true;
		boolean goodWithKids = true;
		Cat cat1 = new Cat("robin", birthday, Size.SMALL, houseTrained, goodWithKids, notes, 
				dateEnterRescue);
		Cat cat2 = new Cat("robinn", birthday, Size.MEDIUM, houseTrained, goodWithKids, notes, 
				dateEnterRescue);
		
		rescue.addAnimal(cat1);
		rescue.addAnimal(cat2);
		Date today = new Date(7, 18, 2023);
		assertEquals(dateEnterRescue, cat1.getDateEnterRescue());
		assertEquals(684, cat1.getDaysAvailableForAdoption(today));
		SortedLinkedList<Animal> a = new SortedLinkedList<Animal>();
		a.add(cat1);
		a.add(cat2);
		Date today1 = new Date(7, 18, 2023);
		assertEquals(a, rescue.availableAnimalsDayRange(today1, 0, 690));
		
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.packdoption.model.rescue.Rescue#availableAnimalsAge(edu.ncsu.csc216.packdoption.util.Date, int, int)}.
	 */
	@Test
	void testAvailableAnimalsAge() {
		Rescue rescue = new Rescue("res");
		Date birthday = new Date(2, 2, 2019);
		Date dateEnterRescue = new Date(9, 2, 2021);
		boolean houseTrained = true;
		boolean goodWithKids = true;
		Cat cat1 = new Cat("robin", birthday, Size.SMALL, houseTrained, goodWithKids, notes, 
				dateEnterRescue);
		Cat cat2 = new Cat("robinn", birthday, Size.MEDIUM, houseTrained, goodWithKids, notes, 
				dateEnterRescue);
		rescue.addAnimal(cat1);
		rescue.addAnimal(cat2);
		Date today = new Date(7, 18, 2023);
		assertEquals(dateEnterRescue, cat1.getDateEnterRescue());
		assertEquals(684, cat1.getDaysAvailableForAdoption(today));
		SortedLinkedList<Animal> list = new SortedLinkedList<Animal>();
		list.add(cat1);
		list.add(cat2);
		Date today1 = new Date(7, 19, 2023);
		SortedLinkedList<Animal> animalsByAgeRange = rescue.availableAnimalsAge(today1, 0, 690);
		assertEquals(list, animalsByAgeRange);
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.packdoption.model.rescue.Rescue#compareTo(edu.ncsu.csc216.packdoption.model.rescue.Rescue)}.
	 */
	@Test
	void testCompareTo() {
		Rescue rescue = new Rescue("nap");
		Rescue res = new Rescue("snap");
		Rescue res2 = new Rescue("app");
		
		assertEquals(-1, rescue.compareTo(res));
		assertEquals(1, rescue.compareTo(res2));
		assertEquals(0, rescue.compareTo(rescue));
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.packdoption.model.rescue.Rescue#equals(java.lang.Object)}.
	 */
	@Test
	void testEqualsObject() {
		Rescue res = new Rescue("rescueDog");
		Rescue rescues = new Rescue("rescueCat");
		assertFalse(res.equals(rescues));
		try {
			Rescue res2 = new Rescue(null);
			assertFalse(res2.equals(rescues));
		} catch (IllegalArgumentException e) {
			//fail();
		}
	}

	/** 
	 * Test method for {@link edu.ncsu.csc216.packdoption.model.rescue.Rescue#toString()}.
	 */
	@Test
	void testToString() {
		Rescue res = new Rescue("rescueDog");
		Rescue rescues = new Rescue("rescueCat");
		assertEquals("rescueDog", res.toString());
		assertEquals("rescueCat", rescues.toString());
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.packdoption.model.rescue.Rescue#getAnimalsAsArray(edu.ncsu.csc216.packdoption.util.Date)}.
	 */
	@Test
	void testGetAnimalsAsArray() {
		Rescue rescue = new Rescue("res");
		Date birthday = new Date(2, 2, 2019);
		Date dateEnterRescue = new Date(9, 2, 2021);
		boolean houseTrained = true;
		boolean goodWithKids = true;
		Cat cat1 = new Cat("robin", birthday, Size.SMALL, houseTrained, goodWithKids, notes, 
				dateEnterRescue);
		Cat cat2 = new Cat("robinn", birthday, Size.MEDIUM, houseTrained, goodWithKids, notes, 
				dateEnterRescue);
		
		rescue.addAnimal(cat1);
		rescue.addAnimal(cat2);
		Date today = new Date(7, 18, 2023);
		
		String[][] array1 = rescue.getAnimalsAsArray(today);
		assertEquals("robin", array1[0][0]);
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.packdoption.model.rescue.Rescue#getAppointmentsAsArray(edu.ncsu.csc216.packdoption.util.Date)}.
	 */
	@Test
	void testGetAppointmentsAsArray() {
		Rescue rescue = new Rescue("rescue");
		Date birthday = new Date(2, 2, 2019);
		Date dateEnterRescue = new Date(9, 2, 2021);
		Date birthday2 = new Date(7, 1, 2020);
		boolean houseTrained = true;
		boolean goodWithKids = true;
		Cat robin = new Cat("robin", birthday, Size.SMALL, houseTrained, goodWithKids, notes, 
				dateEnterRescue);
		Cat ruffles = new Cat("ruffles", birthday2, Size.MEDIUM, houseTrained, goodWithKids, notes, 
				dateEnterRescue);
		rescue.addAnimal(robin);
		rescue.addAnimal(ruffles);
		Date today = new Date(7, 18, 2023);
		rescue.addAppointment(robin);
		String[][] array1 = rescue.getAppointmentsAsArray(today);
		assertEquals("robin", array1[0][0]);
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.packdoption.model.rescue.Rescue#addAppointment(edu.ncsu.csc216.packdoption.model.animals.Animal)}.
	 */
	@Test
	void testAddAppointment() {
		Rescue rescue = new Rescue("rescue");
		Date birthday = new Date(2, 2, 2019);
		Date dateEnterRescue = new Date(9, 2, 2021);
		boolean houseTrained = true;
		boolean goodWithKids = true;
		Cat cat1 = new Cat("robin", birthday, Size.SMALL, houseTrained, goodWithKids, notes, 
				dateEnterRescue);
		Cat cat2 = new Cat("Wembley", birthday, Size.SMALL, houseTrained, goodWithKids, notes, 
				dateEnterRescue);
		rescue.addAnimal(cat1);
		rescue.addAnimal(cat2);
		rescue.addAppointment(cat1);
		rescue.addAppointment(cat2);
		assertEquals(rescue.getAppointments().size(), 2);
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.packdoption.model.rescue.Rescue#getAppointments()}.
	 */
	@Test
	void testGetAppointments() {
		Rescue rescue = new Rescue("rescue");
		Date birthday = new Date(2, 2, 2019);
		Date dateEnterRescue = new Date(9, 2, 2021);
		boolean houseTrained = true;
		boolean goodWithKids = true;
		Cat cat1 = new Cat("robin", birthday, Size.SMALL, houseTrained, goodWithKids, notes, 
				dateEnterRescue);
		Cat cat2 = new Cat("Wembley", birthday, Size.SMALL, houseTrained, goodWithKids, notes, 
				dateEnterRescue);
		rescue.addAnimal(cat1);
		rescue.addAnimal(cat2);
		rescue.addAppointment(cat1);
		rescue.addAppointment(cat2);
		assertEquals(rescue.getAppointments().size(), 2);
		
	}
	
	/**
	 * Test method for {@link edu.ncsu.csc216.packdoption.model.rescue.Rescue#hashCode()}.
	 */
	@Test
	void testHashCode() {
		Rescue rescue = new Rescue("rescue");
		Rescue same = new Rescue("rescue");
		assertEquals(rescue.hashCode(), same.hashCode());
	}

}