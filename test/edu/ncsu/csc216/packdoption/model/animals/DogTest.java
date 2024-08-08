/**
 * 
 */
package edu.ncsu.csc216.packdoption.model.animals;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.ncsu.csc216.packdoption.model.animals.Animal.AgeCategory;
import edu.ncsu.csc216.packdoption.model.animals.Animal.Size;
import edu.ncsu.csc216.packdoption.model.animals.Dog.Breed;
import edu.ncsu.csc216.packdoption.util.Date;
import edu.ncsu.csc216.packdoption.util.Note;
import edu.ncsu.csc216.packdoption.util.SortedLinkedList;

/**
 * Tests the dog class
 * @author Sachi Vyas
 *
 */
public class DogTest {
	
	/** Creating a date object for birthday */
	Date birthday = new Date(10, 12, 2017);
	/** Creating a date object for date enter rescue */
	Date dateEnterRescue = new Date(12, 20, 2018);
	/** Creating a date object for date adopted */
	Date dateAdopted = new Date(10, 10, 2019);
	/** Creating a date object for date today */
	Date today = new Date(7, 13, 2023);
	/** Creating a sorted linked list object for notes */
	SortedLinkedList<Note> list1 = new SortedLinkedList<Note>();

	/**
	 * Test method for {@link edu.ncsu.csc216.packdoption.model.animals.Dog#getAnimalAsArray(edu.ncsu.csc216.packdoption.util.Date)}.
	 */
	@Test
	void testGetAnimalAsArray() {
		Note note = new Note(birthday, "note");
		list1.add(note);
		Animal a = new Dog("NCSU", birthday, Size.LARGE, true, true, list1, dateEnterRescue, true, dateAdopted, 
				"Wynns", Breed.GERMAN_SHEPHERD);
		String age = a.getAge(new Date(7, 13, 2023)) + "";
//		String adopted = a.adopted() + "";
		String[] shortArray = a.getAnimalAsArray(new Date(7, 13, 2023));
		assertEquals("NCSU", shortArray[0]);
		assertEquals("Dog", shortArray[1]);
		assertEquals(birthday.toString(), shortArray[2]);
		assertEquals(age.toString(), shortArray[3]);
		assertEquals(a.getAgeCategory(today).toString(), shortArray[4]);
		assertEquals("Yes", shortArray[5]);
		assertEquals("", shortArray[6]);
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.packdoption.model.animals.Dog#getAgeCategory(edu.ncsu.csc216.packdoption.util.Date)}.
	 */
	@Test
	void testGetAgeCategory() {
		Note note = new Note(birthday, "note");
		list1.add(note);
		Animal a = new Dog("NCSU", birthday, Size.LARGE, true, true, list1, dateEnterRescue, true, dateAdopted, 
				"Wynns", Breed.FRENCH_BULLDOG);
		a.getAge(new Date(7, 13, 2023));
		assertEquals(AgeCategory.ADULT, a.getAgeCategory(today));
		
		Animal a2 = new Dog("NCSU", birthday, Size.MEDIUM, true, true, list1, dateEnterRescue, true, dateAdopted, 
				"Wynns", Breed.FRENCH_BULLDOG);
		a2.getAge(new Date(7, 13, 2023));
		assertEquals(AgeCategory.ADULT, a2.getAgeCategory(today));
		
		Animal a3 = new Dog("NCSU", birthday, Size.SMALL, true, true, list1, dateEnterRescue, true, dateAdopted, 
				"Wynns",  Breed.FRENCH_BULLDOG);
		a3.getAge(new Date(7, 13, 2023));
		assertEquals(AgeCategory.ADULT, a3.getAgeCategory(today));
		
		Date birthday2 = new Date(10, 12, 2012);
		Animal a4 = new Dog("NCSU", birthday2, Size.LARGE, true, true, list1, dateEnterRescue, true, dateAdopted, 
				"Wynns",  Breed.FRENCH_BULLDOG);
		a4.getAge(new Date(7, 13, 2023));
		assertEquals(AgeCategory.SENIOR, a4.getAgeCategory(today));
		
		Date birthday3 = new Date(1, 1, 2022);
		Date dateEnterRescue2 = new Date(2, 2, 2022);
		Animal a5 = new Dog("NCSU", birthday3, Size.LARGE, true, true, list1, dateEnterRescue2,  Breed.FRENCH_BULLDOG);
		a5.getAge(new Date(7, 13, 2023));
		assertEquals(AgeCategory.YOUNG, a5.getAgeCategory(today));
		
		a5.getAge(new Date(7, 13, 2023));
		assertEquals(AgeCategory.YOUNG, a5.getAgeCategory(today));
		
		Date birthday4 = new Date(6, 11, 2013);
		Animal a6 = new Dog("NCSU", birthday4, Size.SMALL, true, true, list1, dateEnterRescue2,  Breed.FRENCH_BULLDOG);
		a5.getAge(new Date(7, 13, 2023));
		
		assertEquals(AgeCategory.SENIOR, a6.getAgeCategory(today));
		
		Animal a7 = new Dog("NCSU", new Date(1, 1, 2001), Size.MEDIUM, true, true, list1, dateEnterRescue, true, dateAdopted, 
				"Wynns", Breed.FRENCH_BULLDOG);
		a7.getAge(new Date(2, 2, 2010));
		assertEquals(AgeCategory.SENIOR, a7.getAgeCategory(today));
		
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.packdoption.model.animals.Dog#Dog(java.lang.String, edu.ncsu.csc216.packdoption.util.Date, edu.ncsu.csc216.packdoption.model.animals.Animal.Size, boolean, boolean, edu.ncsu.csc216.packdoption.util.SortedLinkedList, edu.ncsu.csc216.packdoption.util.Date, boolean, edu.ncsu.csc216.packdoption.util.Date, java.lang.String, edu.ncsu.csc216.packdoption.model.animals.Dog.Breed)}.
	 */
	@Test
	void testDogStringDateSizeBooleanBooleanSortedLinkedListOfNoteDateBooleanDateStringBreed() {
		Note note = new Note(birthday, "note");
		list1.add(note);
		Dog a = new Dog("NCSU", birthday, Size.LARGE, true, true, list1, dateEnterRescue, true, dateAdopted, 
				"Wynns", Breed.MIXED);
		assertEquals("NCSU", a.getName());
		assertEquals(birthday, a.getBirthday());
		assertEquals(Size.LARGE, a.getSize());
		assertEquals(Breed.MIXED, a.getBreed());
		assertEquals("Wynns", a.getOwner());
		
		try {
			Dog a2 = new Dog("NCSU", birthday, Size.LARGE, true, true, list1, dateEnterRescue, true, dateAdopted, 
					"Wynns", null);
			assertEquals(null, a2.getOwner());
		} catch (IllegalArgumentException e) {
			assertEquals("Invalid breed", e.getMessage());
		}
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.packdoption.model.animals.Dog#Dog(java.lang.String, edu.ncsu.csc216.packdoption.util.Date, edu.ncsu.csc216.packdoption.model.animals.Animal.Size, boolean, boolean, edu.ncsu.csc216.packdoption.util.SortedLinkedList, edu.ncsu.csc216.packdoption.util.Date, edu.ncsu.csc216.packdoption.model.animals.Dog.Breed)}.
	 */
	@Test
	void testDogStringDateSizeBooleanBooleanSortedLinkedListOfNoteDateBreed() {
		Note note = new Note(birthday, "note");
		list1.add(note);
		Dog a = new Dog("NCSU", birthday, Size.LARGE, true, true, list1, dateEnterRescue, Breed.MIXED);
		assertEquals("NCSU", a.getName());
		assertEquals(birthday, a.getBirthday());
		assertEquals(Size.LARGE, a.getSize());
		assertEquals(Breed.MIXED, a.getBreed());
	}

//	/**
//	 * Test method for {@link edu.ncsu.csc216.packdoption.model.animals.Dog#getBreed()}.
//	 */
//	@Test
//	void testGetBreed() {
//		fail("Not yet implemented"); // TODO
//	}

}
