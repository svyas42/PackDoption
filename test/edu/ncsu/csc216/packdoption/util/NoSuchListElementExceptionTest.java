/**
 * 
 */
package edu.ncsu.csc216.packdoption.util;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Tests the NoSuchElementException class
 * @author Sachi Vyas
 */
public class NoSuchListElementExceptionTest {

	/**
	 * Test method for {@link edu.ncsu.csc216.packdoption.util.NoSuchListElementException#NoSuchListElementException()}.
	 */
	@Test
	void testNoSuchListElementException() {
		NoSuchListElementException no = new NoSuchListElementException();
		assertEquals("No such element in list.", no.getMessage());
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.packdoption.util.NoSuchListElementException#NoSuchListElementException(java.lang.String)}.
	 */
	@Test
	void testNoSuchListElementExceptionString() {
		NoSuchListElementException no = new NoSuchListElementException("my message");
		assertEquals("my message", no.getMessage());
	}

}
