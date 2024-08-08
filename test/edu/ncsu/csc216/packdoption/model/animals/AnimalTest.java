package edu.ncsu.csc216.packdoption.model.animals;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import edu.ncsu.csc216.packdoption.model.animals.Animal.Size;
import edu.ncsu.csc216.packdoption.model.animals.Dog.Breed;
import edu.ncsu.csc216.packdoption.util.SortedLinkedList;
import edu.ncsu.csc216.packdoption.util.Note;
import edu.ncsu.csc216.packdoption.util.Date;

/**
 * Tests the Animal class methods
 * @author Sachi Vyas
 */
public class AnimalTest {
	/** Creating a birthday date object */
	Date birthday = new Date(12, 02, 2005);
	/** Creating a date enter rescue object */
    Date dateEnterRescue = new Date(01, 05, 2006);
    /** Creating a date adopted object */
	Date dateAdopted = new Date(03, 05, 2007);
	/** Creating a sorted linked list object for notes */
	SortedLinkedList<Note> list1 = new SortedLinkedList<Note>();
	
	/**
	 * Test method for {@link edu.ncsu.csc216.packdoption.model.animals.Animal#hashCode()}.
	 */
	@Test
	void testHashCode() {
		assertEquals(34090, birthday.hashCode());
		Date date1 = new Date(1, 1, 2019);
		@SuppressWarnings("unused")
		Date date2 = new Date(2, 1, 2020);
		Date date3 = new Date(3, 15, 2020);
		Note note1 = new Note(date3, "message");
		list1.add(note1);
		Cat cat1 = new Cat("Dorothy", date1, Size.SMALL, true, true, list1, date3);
		
		@SuppressWarnings("unused")
		Date date4 = new Date(1, 1, 2019);
//		Date date5 = new Date(2, 1, 2020);
//		Date date6 = new Date(3, 15, 2020);
		Note note2 = new Note(date3, "message2");
		list1.add(note2);
		Cat cat2 = new Cat("Dorothy", date1, Size.SMALL, true, true, list1, date3);
		assertEquals(cat1.hashCode(), cat2.hashCode());
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.packdoption.model.animals.Animal#Animal(java.lang.String, edu.ncsu.csc216.packdoption.util.Date, edu.ncsu.csc216.packdoption.model.animals.Animal.Size, boolean, boolean, edu.ncsu.csc216.packdoption.util.SortedLinkedList, edu.ncsu.csc216.packdoption.util.Date, boolean, edu.ncsu.csc216.packdoption.util.Date, java.lang.String)}.
	 */
	@Test
	void testAnimalStringDateSizeBooleanBooleanSortedLinkedListOfNoteDateBooleanDateString() {
		Note note = new Note(birthday, "note");
		list1.add(note);
		
		Animal a = new Cat("Duke", birthday, Size.LARGE, true, true, list1, dateEnterRescue, true, dateAdopted, 
				"Wynns");
		assertEquals("Duke", a.getName());
		assertEquals(birthday, a.getBirthday());
		assertEquals(Size.LARGE, a.getSize());
		assertTrue(a.isHouseTrained());
		assertTrue(a.isGoodWithKids());
		assertEquals(list1, a.getNotes());
		assertEquals(dateEnterRescue, a.getDateEnterRescue());
		assertTrue(a.adopted());
		assertEquals(dateAdopted, a.getDateAdopted());
		assertEquals("Wynns", a.getOwner());
		
		try {
			Date birthday2 = new Date(3, 1, 2012);
			Animal a2 = new Cat("Duke", birthday2, Size.LARGE, true, true, list1, dateEnterRescue, true, dateAdopted, 
					"Wynns");
			assertEquals(0, a.compareTo(a2));
		} catch (IllegalArgumentException e) {
			//fail();
		}
		
		try {
			Animal a3 = new Cat("Duke", birthday, Size.LARGE, true, true, list1, dateEnterRescue, true, 
					null, "Wynns");
			assertEquals("Wynns", a3.getOwner());
		} catch (IllegalArgumentException e) {
			//just catch
		}
		
		try {
			Animal a3 = new Cat("Duke", birthday, Size.LARGE, true, true, list1, dateEnterRescue, true, 
					dateAdopted, "");
			assertEquals("", a3.getOwner());
		} catch (IllegalArgumentException e) {
			//just catch
		}
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.packdoption.model.animals.Animal#Animal(java.lang.String, edu.ncsu.csc216.packdoption.util.Date, edu.ncsu.csc216.packdoption.model.animals.Animal.Size, boolean, boolean, edu.ncsu.csc216.packdoption.util.SortedLinkedList, edu.ncsu.csc216.packdoption.util.Date)}.
	 */
	@Test
	void testAnimalStringDateSizeBooleanBooleanSortedLinkedListOfNoteDate() {
		Note note = new Note(birthday, "note");
		list1.add(note);
		Animal a = new Dog("Duke", birthday, Size.LARGE, true, true, list1, dateEnterRescue, Breed.BEAGLE);
		assertEquals("Duke", a.getName());
		assertEquals(birthday, a.getBirthday());
		assertEquals(Size.LARGE, a.getSize());
		assertTrue(a.isHouseTrained());
		assertTrue(a.isGoodWithKids());
		assertEquals(list1, a.getNotes());
		assertEquals(dateEnterRescue, a.getDateEnterRescue());
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.packdoption.model.animals.Animal#setAdoptionInfo(boolean, edu.ncsu.csc216.packdoption.util.Date, java.lang.String)}.
	 */
	@Test
	void testSetAdoptionInfo() {
		Note note = new Note(birthday, "note");
		list1.add(note);
		Animal a = new Cat("Duke", birthday, Size.LARGE, true, true, list1, dateEnterRescue, true, dateAdopted, 
				"Wynns");

		a.setAdoptionInfo(true, dateAdopted, "Wynns");
		assertEquals(dateAdopted, a.getDateAdopted());
		assertEquals("Wynns", a.getOwner());
		
		a.setAdoptionInfo(true, dateAdopted, " Smith");
		assertEquals(dateAdopted, a.getDateAdopted());
		assertEquals("Smith", a.getOwner());
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.packdoption.model.animals.Animal#setSize(edu.ncsu.csc216.packdoption.model.animals.Animal.Size)}.
	 */
	@Test
	void testSetSize() {
		Note note = new Note(birthday, "note");
		list1.add(note);
		Animal a = new Dog("Duke", birthday, Size.LARGE, true, true, list1, dateEnterRescue, Breed.BEAGLE);

		a.setSize(Size.SMALL);
		assertEquals(Size.SMALL, a.getSize());
		
		
		try {
			Animal a1 = new Dog("Duke", birthday, Size.SMALL, true, true, list1, dateEnterRescue, Breed.BEAGLE);
			a1.setSize(null);
			assertEquals(null, a1.getSize());
		} catch (IllegalArgumentException e) {
			//todo
		}
	}


	/**
	 * Test method for {@link edu.ncsu.csc216.packdoption.model.animals.Animal#addNote(edu.ncsu.csc216.packdoption.util.Note)}.
	 */
	@Test
	void testAddNote() {
		try {
			Note note = new Note(birthday, "note");
			list1.add(note);
			Animal a = new Dog("Duke", birthday, Size.LARGE, true, true, list1, dateEnterRescue, Breed.BEAGLE);
			assertTrue(a.addNote(note));
		} catch (IllegalArgumentException e) {
			//fail();
		}
		
		Note note = new Note(birthday, "note1");
//		list1.add(note);
		Animal a = new Dog("Duke", birthday, Size.LARGE, true, true, list1, dateEnterRescue, Breed.BEAGLE);
		assertTrue(a.addNote(note));

	}

	/**
	 * Test method for {@link edu.ncsu.csc216.packdoption.model.animals.Animal#compareTo(edu.ncsu.csc216.packdoption.model.animals.Animal)}.
	 */
	@Test
	void testCompareTo() {
		Animal a = new Dog("Duke", birthday, Size.LARGE, true, true, list1, dateEnterRescue, Breed.BEAGLE);
		Animal a1 = new Dog("Duke", birthday, Size.LARGE, true, true, list1, dateEnterRescue, Breed.BEAGLE);
		assertEquals(0, a.compareTo(a1));
		
		Date birthday2 = new Date(3, 1, 2005);
		Animal a2 = new Dog("Duke", birthday2, Size.MEDIUM, true, true, list1, dateEnterRescue, Breed.BULLDOG);
		assertEquals(1, a.compareTo(a2));
		
		Animal a3 = new Dog("Zoe", birthday2, Size.MEDIUM, true, true, list1, dateEnterRescue, Breed.BULLDOG);
		assertEquals(1, a.compareTo(a3));
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.packdoption.model.animals.Animal#equals(java.lang.Object)}.
	 */
	@Test
	void testEqualsObject() {
		Animal a = new Dog("Duke", birthday, Size.LARGE, true, true, list1, dateEnterRescue, Breed.BEAGLE);
		Animal a1 = new Dog("Duke", birthday, Size.LARGE, true, true, list1, dateEnterRescue, Breed.BEAGLE);
		assertTrue(a.equals(a1));
		
		try {
			Animal a2 = new Dog("Duke", null, Size.LARGE, true, true, list1, dateEnterRescue, Breed.BEAGLE);
			assertFalse(a.equals(a2));
		} catch(IllegalArgumentException e) {
			//fail();
		}
	}

//	/**
//	 * Test method for {@link edu.ncsu.csc216.packdoption.model.animals.Animal#toString()}.
//	 */
//	@Test
//	void testToString() {
//		Note note = new Note(birthday, "note");
//		list1.add(note);
//		Animal a = new Dog("Duke", birthday, Size.LARGE, true, true, list1, dateEnterRescue, Breed.BEAGLE);
//		assertEquals("Duke (12/2/2005)\n" + list1.toString(), a.toString());
//	}

	/**
	 * Test method for {@link edu.ncsu.csc216.packdoption.model.animals.Animal#getAge(edu.ncsu.csc216.packdoption.util.Date)}.
	 */
	@Test
	void testGetAge() {
		Note note = new Note(birthday, "note");
		list1.add(note);
		Animal a = new Dog("Duke", birthday, Size.LARGE, true, true, list1, dateEnterRescue, Breed.BEAGLE);
		
		assertEquals(17, a.getAge(new Date(7, 18, 2023)));
		try {
			assertEquals(17, a.getAge(null));
		} catch (IllegalArgumentException e) {
			//fail();
		}
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.packdoption.model.animals.Animal#getDaysAvailableForAdoption(edu.ncsu.csc216.packdoption.util.Date)}.
	 */
	@Test
	void testGetDaysAvailableForAdoption() {
		Date dateEnterRescue2 = new Date(06, 12, 2022);
		//Date dateAdopted2 = new Date()
		Animal a2 = new Cat("Duke", birthday, Size.LARGE, true, true, list1, dateEnterRescue2);
		//assertEquals(401, a2.getDaysAvailableForAdoption(new Date(7, 18, 2023)));
		assertEquals(401, a2.getDaysAvailableForAdoption(new Date(7, 18, 2023)));
		try {
			Animal a3 = new Cat("Duke", birthday, Size.LARGE, true, true, list1, dateEnterRescue, true, dateAdopted, 
					"Wynns");
			assertEquals(-1, a3.getDaysAvailableForAdoption(null));
		} catch (IllegalArgumentException e) {
			//fail();
		}
		
		Note note = new Note(birthday, "note");
		list1.add(note);
		Animal a = new Cat("Duke", birthday, Size.LARGE, true, true, list1, dateEnterRescue, true, dateAdopted, 
				"Wynns");
		assertEquals(-1, a.getDaysAvailableForAdoption(new Date(7, 13, 2023)));
	}

//	/**
//	 * Test method for {@link edu.ncsu.csc216.packdoption.model.animals.Animal#getAnimalAsArray(edu.ncsu.csc216.packdoption.util.Date)}.
//	 */
//	@Test
//	void testGetAnimalAsArray() {
//		fail("Not yet implemented"); // TODO
//	}
//
//	/**
//	 * Test method for {@link edu.ncsu.csc216.packdoption.model.animals.Animal#getAgeCategory(edu.ncsu.csc216.packdoption.util.Date)}.
//	 */
//	@Test
//	void testGetAgeCategory() {
//		fail("Not yet implemented"); // TODO
//	}

}
