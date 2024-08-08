package edu.ncsu.csc216.packdoption.model.manager;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;
//import edu.ncsu.csc216.packdoption.model.animals.Cat;
//import edu.ncsu.csc216.packdoption.model.rescue.Rescue;
import org.junit.jupiter.api.Test;

/**
 * Tests the packDoption manager class
 * @author Sachi Vyas
 *
 */
public class PackDoptionManagerTest {
	/** Creating an instance of the PackDoptionManager class */
	PackDoptionManager adoption;

//	/**
//	 * Test method for {@link edu.ncsu.csc216.packdoption.model.manager.PackDoptionManager#getInstance()}.
//	 */
//	@Test
//	void testGetInstance() {
//		fail("Not yet implemented"); // TODO
//	}
	
	/**
	 * Tests getInstance() method
	 */
	public void before() {
		adoption = PackDoptionManager.getInstance();
		adoption.newList();		
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.packdoption.model.manager.PackDoptionManager#newList()}.
	 */
	@Test
	void testNewList() {
		adoption = PackDoptionManager.getInstance();
		adoption.newList();
		assertEquals(0, adoption.getRescueList().size());
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.packdoption.model.manager.PackDoptionManager#isChanged()}.
	 */
	@Test
	void testIsAndSetChanged() {
		adoption = PackDoptionManager.getInstance();
		adoption.setChanged(true);
		assertTrue(adoption.isChanged());
	}

//	/**
//	 * Test method for {@link edu.ncsu.csc216.packdoption.model.manager.PackDoptionManager#getFilename()}.
//	 */
//	@Test
//	void testGetFilename() {
//		fail("Not yet implemented"); // TODO
//	}

//	/**
//	 * Test method for {@link edu.ncsu.csc216.packdoption.model.manager.PackDoptionManager#setChanged(boolean)}.
//	 */
//	@Test
//	void testSetChanged() {
//		fail("Not yet implemented"); // TODO
//	}

	/**
	 * Test method for {@link edu.ncsu.csc216.packdoption.model.manager.PackDoptionManager#setFilename(java.lang.String)}.
	 */
	@Test
	void testSetAndGetFilename() {
		adoption = PackDoptionManager.getInstance();
		adoption.setFilename("rescues.txt");
		assertEquals("rescues.txt", adoption.getFilename());
		
		try {
			//adoption = PackDoptionManager.getInstance();
			adoption.setFilename(null);
//			assertEquals(null, adoption.getFilename());
			//fail();
		} catch (IllegalArgumentException e) {
			//fail();
		}
		
		
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.packdoption.model.manager.PackDoptionManager#loadFile(java.lang.String)}.
	 */
	@Test
	void testLoadFile() {
		adoption = PackDoptionManager.getInstance();
		adoption.newList();
		adoption.setFilename("test-files/rescues.txt");
		adoption.loadFile("test-files/rescues1.md");
		assertEquals(2, adoption.getRescueList().size());
		
	}

//	/**
//	 * Test method for {@link edu.ncsu.csc216.packdoption.model.manager.PackDoptionManager#saveFile(java.lang.String)}.
//	 */
//	@Test
//	void testSaveFile() {
//		adoption = PackDoptionManager.getInstance();
//		
//		adoption.setFilename("test-files/rescues.txt");
//		adoption.saveFile("test-files/savedRescues.txt");
//		assertEquals("Rescue [name=Ms. Wuf's Rescue]", adoption.getRescueList().getRescue(0).toString());
//	}

//	/**
//	 * Test method for {@link edu.ncsu.csc216.packdoption.model.manager.PackDoptionManager#getRescueList()}.
//	 */
//	@Test
//	void testGetRescueList() {
//		adoption = PackDoptionManager.getInstance();
//		adoption.setFilename("test-files/rescues.txt");
//		adoption.loadFile("test-files/rescues.txt");
//		assertEquals("Rescue [name=Ms. Wuf's Rescue]", adoption.getRescueList().getRescue(0).toString());
//	}

}