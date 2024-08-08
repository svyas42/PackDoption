package edu.ncsu.csc216.packdoption.model.io;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.ncsu.csc216.packdoption.model.rescue.Rescue;
import edu.ncsu.csc216.packdoption.model.rescue.RescueList;

/**
 * Tests the pack doption reader
 * @author Sachi Vyas
 * @author Jason Maher
 *
 */
class PackDoptionReaderTest {
	
	/**
	 * Tests the reader method
	 */
	@Test
	void testReader() {
		RescueList rescues = PackDoptionReader.readRescueListFile("test-files/rescues1.md");
		assertEquals(2, rescues.size());
		Rescue rescue1 = rescues.getRescue(0);
		Rescue rescue2 = rescues.getRescue(1);
		assertEquals(rescue1.numAnimals(), 3);
		assertEquals(rescue1.getAppointments().size(), 1);
		assertEquals(rescue2.numAnimals(), 4);
		assertEquals(rescue2.getAppointments().size(), 3);
		try {
			PackDoptionReader.readRescueListFile("nonexistent.txt");
			fail();
		} catch (IllegalArgumentException e) {
			assertEquals("Unable to load file.", e.getMessage());
		}
	}

}
