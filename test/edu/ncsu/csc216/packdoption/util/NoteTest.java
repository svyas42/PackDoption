package edu.ncsu.csc216.packdoption.util;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


/**
 * Testing Note.java class
 * @author Sachi Vyas
 *
 */
public class NoteTest {
	/** Creating a date1 object */
	Date date1 = new Date("12/05/2022");
	/** Creating a new note1 object */
	Note note1 = new Note(date1, "note");
	/** Creating a date2 object */
	Date date2 = new Date("12/05/2022");
	/** Creating a new note3 object */
	Note note2 = new Note(date2, "note");
	/** Creating a date3 object */
	Date date3 = new Date("10/06/2022");
	/** Creating a new note3 object */
	Note note3 = new Note(date3, "note11");
	/** Creating a date4 object */
	Date date4 = new Date("10/06/2022");
	/** Creating a new note4 object */
	Note note4 = new Note(date3, "note123");
	
	/**
	 * Tests the Hash code 
	 */
	@Test
	void testHashCode() {
		assertEquals(4535029, note1.hashCode());
	}
	
	/**
	 * Tests the note constructor
	 */
	@Test
	void testNote() {
		assertEquals("note", note1.getMessage());
		assertEquals(date1, note1.getDate());
		try {
			Note note5 = new Note(date1, null);
			assertEquals("note", note5.getMessage());
		} catch (IllegalArgumentException e) {
			//fail();
		}
		
		try {
			Note note6 = new Note(date4, "");
			assertEquals("note", note6.getMessage());
		} catch (IllegalArgumentException e) {
			//fail();
		}

	}
	
	/**
	 * Tests the get date method
	 */
	@Test
	void testGetDate() {
		assertEquals(date1, note1.getDate());
	}
	
	/**
	 * Tests the get message method
	 */
	@Test
	void testGetMessage() {
		assertEquals("note", note1.getMessage());
	}
	
	/**
	 * Tests the compare to method
	 */
	@Test
	void testCompareTo() {
		assertEquals(0, note1.compareTo(note2));
		assertEquals(1, note1.compareTo(note3));
		assertEquals(1, note2.getDate().compareTo(note3.getDate()));
		assertEquals(-1, note3.getMessage().compareTo(note4.getMessage()), note3.getDate().compareTo(note4.getDate()));
		
	}
	
	/**
	 * Tests the toString()
	 */
	@Test
	void testToString() {
		assertEquals("12/5/2022 note", note1.toString());
	}
	
	/**
	 * Tests the equals method
	 */
	@Test
	void testEqualsObject() {		
		assertTrue(note2.equals(note1));
		assertFalse(note1.equals(note3));
		//assertFalse(note4.equals(null));
		assertTrue(note4.equals(note4));
		try {
			Note note5 = new Note(date1, null);
			assertFalse(note1.equals(note5));
		} catch (IllegalArgumentException e) {
			//fail();
		}
		
		
		
	}

}
