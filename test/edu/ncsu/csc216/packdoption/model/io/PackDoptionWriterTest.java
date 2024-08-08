package edu.ncsu.csc216.packdoption.model.io;

import static org.junit.jupiter.api.Assertions.*;
//import java.io.File;
//import java.io.IOException;
//import java.util.Scanner;

import org.junit.jupiter.api.Test;

import edu.ncsu.csc216.packdoption.model.rescue.RescueList;

/**
 * Tests the PackDoptionWriter class
 * 
 * @author Sachi Vyas
 *
 */
class PackDoptionWriterTest {

//	/**
//	 * Test the check files method
//	 */
//	@Test
//	void test() {
//		RescueList rescues = PackDoptionReader.readRescueListFile("test-files/rescues1.md");
//		PackDoptionWriter.writeRescueFile("test-files/writerTest.md", rescues);
//		 assertTrue(checkFiles("test-files/writerTest.md", rescues));
//	}

//	/**
//	 * Helper method to compare two files for the same contents
//	 * 
//	 * @param expFile expected output
//	 * @param actFile actual output
//	 * @return true if files match
//	 */
//	private Boolean checkFiles(String expFile, String actFile) {
//		try (Scanner expScanner = new Scanner(new File(expFile));
//				Scanner actScanner = new Scanner(new File(actFile));) {
//
//			while (expScanner.hasNextLine()) {
//				assertEquals(expScanner.nextLine(), actScanner.nextLine());
//			}
//			expScanner.close();
//			actScanner.close();
//
//		} catch (IOException e) {
//			fail("Error reading files.");
//		}
//		return true;
//	}

	/**
	 * Testing the write rescue file method
	 */
	@Test
	void testWriteRescueFile() {
		RescueList rescues = PackDoptionReader.readRescueListFile("test-files/rescues1.md");
		assertEquals(2, rescues.size());

		try {
			PackDoptionWriter.writeRescueFile("test-files/save.md", rescues);
		} catch (IllegalArgumentException e) {
			fail();
		}

		try {
			PackDoptionWriter.writeRescueFile("", rescues);
			fail();
		} catch (IllegalArgumentException e) {
			// fail();
		}

	}
}