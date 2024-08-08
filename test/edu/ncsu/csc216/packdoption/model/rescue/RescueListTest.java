/**
 * 
 */
package edu.ncsu.csc216.packdoption.model.rescue;

import static org.junit.jupiter.api.Assertions.*;

import edu.ncsu.csc216.packdoption.model.animals.Animal.Size;
import edu.ncsu.csc216.packdoption.model.animals.Dog.Breed;
import edu.ncsu.csc216.packdoption.util.Date;
import edu.ncsu.csc216.packdoption.util.Note;
import edu.ncsu.csc216.packdoption.util.SortedLinkedList;
import edu.ncsu.csc216.packdoption.model.animals.Dog;
import org.junit.jupiter.api.Test;

/**
 * Tests the Rescuelist class()
 * @author Sachi Vyas
 *
 */
public class RescueListTest {
	
	/** The sorted linked list for the notes */
	SortedLinkedList<Note> notes = new SortedLinkedList<Note>();
	
	/**
	 * Test method for {@link edu.ncsu.csc216.packdoption.model.rescue.RescueList#RescueList()}.
	 */
	@Test
	void testRescueList() {
		RescueList rescues = new RescueList();
		assertEquals(0, rescues.size());
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.packdoption.model.rescue.RescueList#addRescue(edu.ncsu.csc216.packdoption.model.rescue.Rescue)}.
	 */
	@Test
	void testAddRescueRescue() {
		Rescue newRescue = new Rescue("newRes");
		Date birthday = new Date(11, 2, 2019);
		Date dateEnterRescue = new Date(12, 2, 2019);
		boolean houseTrained = true;
		boolean goodWithKids = true;
		Dog dog1 = new Dog("robin", birthday, Size.SMALL, houseTrained, goodWithKids, notes, 
				dateEnterRescue, Breed.BEAGLE);
		newRescue.addAnimal(dog1);
		RescueList rescue = new RescueList();
		rescue.addRescue(newRescue);
		assertEquals(1, rescue.size());
		
		try {
			rescue.addRescue(newRescue);
			fail();
		} catch (IllegalArgumentException e) {
			//no need, just catch it
		}
		
		try {
			rescue.addRescue("");
		} catch (IllegalArgumentException e ) {
			//just catch the exception
		}
		
		try {
			Rescue r = new Rescue(null);
			rescue.addRescue(r);
		} catch (IllegalArgumentException e ) {
			//just catch the exception
		}		
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.packdoption.model.rescue.RescueList#addRescue(java.lang.String)}.
	 */
	@Test
	void testAddRescueString() {
		RescueList rescue = new RescueList();
		rescue.addRescue("rescue1");
		assertEquals(1, rescue.size());
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.packdoption.model.rescue.RescueList#getRescue(int)}.
	 */
	@Test
	void testGetRescue() {
		Rescue newRescue = new Rescue("newRes");
		Date birthday = new Date(11, 2, 2019);
		Date dateEnterRescue = new Date(12, 2, 2019);
		boolean houseTrained = true;
		boolean goodWithKids = true;
		Dog dog1 = new Dog("robin", birthday, Size.SMALL, houseTrained, goodWithKids, notes, 
				dateEnterRescue, Breed.BEAGLE);
		newRescue.addAnimal(dog1);
		RescueList rescue = new RescueList();
		rescue.addRescue(newRescue);
		assertEquals(newRescue, rescue.getRescue(0));
		
		try {
			assertEquals(newRescue, rescue.getRescue(-1));
		} catch (IndexOutOfBoundsException e) {
			//just need to catch it
		}
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.packdoption.model.rescue.RescueList#size()}.
	 */
	@Test
	void testSize() {
		Rescue newRescue = new Rescue("newRes");
		Date birthday = new Date(11, 2, 2019);
		Date dateEnterRescue = new Date(12, 2, 2019);
		boolean houseTrained = true;
		boolean goodWithKids = true;
		Dog dog1 = new Dog("robin", birthday, Size.SMALL, houseTrained, goodWithKids, notes, 
				dateEnterRescue, Breed.BEAGLE);
		newRescue.addAnimal(dog1);
		RescueList rescue = new RescueList();
		rescue.addRescue(newRescue);
		assertEquals(1, rescue.size());
	}

}
