package edu.ncsu.csc216.packdoption.model.animals;

import static org.junit.jupiter.api.Assertions.*;

import edu.ncsu.csc216.packdoption.model.animals.Animal.AgeCategory;
import edu.ncsu.csc216.packdoption.model.animals.Animal.Size;
import edu.ncsu.csc216.packdoption.util.Date;
import edu.ncsu.csc216.packdoption.util.Note;
import edu.ncsu.csc216.packdoption.util.SortedLinkedList;

import org.junit.jupiter.api.Test;

/**
 * Testing the Cat class
 * @author Sachi Vyas
 *
 */
public class CatTest {
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
	 * Tests the getAnimalsAsArray() method
	 */
	@Test
	void testGetAnimalAsArray() {
		Note note = new Note(birthday, "note");
		list1.add(note);
		Animal a = new Cat("NCSU", birthday, Size.LARGE, true, true, list1, dateEnterRescue, true, dateAdopted, 
				"Wynns");
		String age = a.getAge(new Date(7, 13, 2023)) + "";
//		String adopted = a.adopted() + "";
		String[] shortArray = a.getAnimalAsArray(new Date(7, 13, 2023));
		assertEquals("NCSU", shortArray[0]);
		assertEquals("Cat", shortArray[1]);
		assertEquals(birthday.toString(), shortArray[2]);
		assertEquals(age.toString(), shortArray[3]);
		assertEquals(a.getAgeCategory(today).toString(), shortArray[4]);
		assertEquals("Yes", shortArray[5]);
		assertEquals("", shortArray[6]);
	}
	
	/**
	 * Tests the getAgeCategory() method
	 */
	@Test
	void testGetAgeCategory() {
		Note note = new Note(birthday, "note");
		list1.add(note);
		Animal a = new Cat("NCSU", birthday, Size.LARGE, true, true, list1, dateEnterRescue, true, dateAdopted, 
				"Wynns");
		a.getAge(new Date(7, 13, 2023));
		assertEquals(AgeCategory.ADULT, a.getAgeCategory(today));
		
		
		Animal a2 = new Cat("NCSU", birthday, Size.MEDIUM, true, true, list1, dateEnterRescue, true, dateAdopted, 
				"Wynns");
		a2.getAge(new Date(7, 13, 2023));
		assertEquals(AgeCategory.ADULT, a2.getAgeCategory(today));
		
		Animal a3 = new Cat("NCSU", birthday, Size.SMALL, true, true, list1, dateEnterRescue, true, dateAdopted, 
				"Wynns");
		a3.getAge(new Date(7, 13, 2023));
		assertEquals(AgeCategory.ADULT, a3.getAgeCategory(today));
		
		Date birthday2 = new Date(10, 12, 2012);
		Animal a4 = new Cat("NCSU", birthday2, Size.LARGE, true, true, list1, dateEnterRescue, true, dateAdopted, 
				"Wynns");
		a4.getAge(new Date(7, 13, 2023));
		assertEquals(AgeCategory.SENIOR, a4.getAgeCategory(today));
		
		Date birthday3 = new Date(1, 1, 2022);
		Date dateEnterRescue2 = new Date(2, 2, 2022);
		Animal a5 = new Cat("NCSU", birthday3, Size.LARGE, true, true, list1, dateEnterRescue2);
		a5.getAge(new Date(7, 13, 2023));
		assertEquals(AgeCategory.YOUNG, a5.getAgeCategory(today));
		
		a5.getAge(new Date(7, 13, 2023));
		assertEquals(AgeCategory.YOUNG, a5.getAgeCategory(today));
		
		try {
			Animal a8 = new Cat("NCSU", birthday2, Size.LARGE, true, true, list1, dateEnterRescue, false, null, 
					null);
			a8.setAdoptionInfo(true, dateAdopted, null);
			assertEquals(null, a8.getOwner());
		} catch (IllegalArgumentException e) {
			//fail();
		}
		
	}
	
	/**
	 * Testing the constructor of the cat class
	 */
	@Test
	void testCatStringDateSizeBooleanBooleanSortedLinkedListOfNoteDate() {
		Note note = new Note(birthday, "note");
		list1.add(note);
		Cat a = new Cat("NCSU", birthday, Size.LARGE, true, true, list1, dateEnterRescue);
		assertEquals("NCSU", a.getName());
		assertEquals(birthday, a.getBirthday());
		assertEquals(Size.LARGE, a.getSize());
		assertEquals(dateEnterRescue, a.getDateEnterRescue());
	}
	
	/**
	 * Testing the second constructor with the adoption information
	 */
	@Test
	void testCatStringDateSizeBooleanBooleanSortedLinkedListOfNoteDateBooleanDateString() {
		Note note = new Note(birthday, "note");
		list1.add(note);
		Cat a = new Cat("NCSU", birthday, Size.LARGE, true, true, list1, dateEnterRescue, true, dateAdopted, 
				"Wynns");
		assertEquals("NCSU", a.getName());
		assertEquals(birthday, a.getBirthday());
		assertEquals(Size.LARGE, a.getSize());
		assertEquals("Wynns", a.getOwner());
	}

}
