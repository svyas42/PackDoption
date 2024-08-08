package edu.ncsu.csc216.packdoption.util;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Tests the Data.java class
 * @author Sachi Vyas
 *
 */
class DateTest {

	/**
	 * Test method for {@link edu.ncsu.csc216.packdoption.util.Date#Date(int, int, int)}.
	 */
	@Test
	void testDateIntIntInt() {
		Date date = new Date(12, 02, 2003);
		assertEquals(12, date.getMonth());
		assertEquals(02, date.getDay());
		assertEquals(2003, date.getYear());
		Exception e = assertThrows(IllegalArgumentException.class, () -> new Date(13, 3, 2003));
		assertEquals("Invalid date", e.getMessage());
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.packdoption.util.Date#Date(java.lang.String)}.
	 */
	@Test
	void testDateString() {
		Date date = new Date("12/02/2003");
		assertEquals(12, date.getMonth());
		assertEquals(02, date.getDay());
		assertEquals(2003, date.getYear());	
		Exception e = assertThrows(IllegalArgumentException.class, () -> new Date("13/3/2003"));
		assertEquals("Invalid date", e.getMessage());
		Exception e1 = assertThrows(IllegalArgumentException.class, () -> new Date("2/29/2003"));
		assertEquals("Invalid date", e1.getMessage());	
	}
	
	/**
	 * Test method for {@link edu.ncsu.csc216.packdoption.util.Date#isValidDate(java.lang.String)}.
	 */
	@Test
	void testIsValidDateString() {
		Date date = new Date("12/02/2003");
		assertEquals(12, date.getMonth());
		assertEquals(02, date.getDay());
		assertEquals(2003, date.getYear());
		
		try {
			Date date1 = new Date("12/0/2003");
			assertEquals(0, date1.getDay());
		} catch (IllegalArgumentException e) {
			//fail();
		}
		
		
		assertFalse(Date.isValidDate("12/0/2003"));
		assertTrue(Date.isValidDate("12/10/2000"));
		assertFalse(Date.isValidDate("32/10/2022"));
		assertFalse(Date.isValidDate("0/10/2022"));
		assertFalse(Date.isValidDate("13/3/2019"));
		
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.packdoption.util.Date#isValidDate(int, int, int)}.
	 */
	@Test
	void testIsValidDateIntIntInt() {
		assertTrue(Date.isValidDate(12, 02, 2003));
		assertFalse(Date.isValidDate(2, 29, 2003));
		
		
		try {
			assertFalse(Date.isValidDate(13, 02, 2003));
			assertFalse(Date.isValidDate(12, -1, 2003));
			
		} catch (IllegalArgumentException e) {
			//fail();
		}
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.packdoption.util.Date#compareTo(edu.ncsu.csc216.packdoption.util.Date)}.
	 */
	@Test
	void testCompareTo() {
		Date date = new Date(12, 02, 2003);
		Date date1 = new Date(12, 02, 2005);
		assertEquals(1, date1.compareTo(date));
		
		Date date2 = new Date(11, 02, 2006);
		Date date3 = new Date(12, 02, 2010);
		assertEquals(-1, date2.compareTo(date3));
		
		Date date4 = new Date(12, 02, 2006);
		Date date5 = new Date(12, 02, 2006);
		assertEquals(0, date4.compareTo(date5));
		
		Date date6 = new Date(12, 02, 2006);
		Date date7 = new Date(12, 01, 2006);
		assertEquals(1, date6.compareTo(date7));
		
		Date date8 = new Date(12, 02, 2006);
		Date date9 = new Date(12, 06, 2006);
		assertEquals(-1, date8.compareTo(date9));
		
		Date date10 = new Date(12, 02, 2006);
		Date date11 = new Date(11, 06, 2006);
		assertEquals(1, date10.compareTo(date11));
		assertEquals(-1, date11.compareTo(date10));
		
		
		
	}

//	/**
//	 * Test method for {@link edu.ncsu.csc216.packdoption.util.Date#toString()}.
//	 */
//	@Test
//	void testToString() {
//		fail("Not yet implemented"); // TODO
//	}

	/**
	 * Test method for {@link edu.ncsu.csc216.packdoption.util.Date#equals(java.lang.Object)}.
	 */
	@Test
	void testEqualsObject() {
		// TODO
		Date date = new Date(12, 02, 2003);
		Date date1 = new Date(12, 02, 2005);
		assertFalse(date.equals(date1));
		
		Date date2 = new Date(12, 02, 2002);
		Date date3 = new Date(12, 02, 2002);
		assertTrue(date2.equals(date3));
		
		Date date4 = new Date(11, 02, 2002);
		Date date5 = new Date(12, 02, 2002);
		assertFalse(date4.equals(date5));
		
		Date date6 = new Date(12, 02, 2002);
		Date date7 = new Date(12, 10, 2002);
		assertFalse(date6.equals(date7));
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.packdoption.util.Date#daysTo(edu.ncsu.csc216.packdoption.util.Date)}.
	 */
	@Test
	void testDaysTo() {
		//Shouldn't this be a leap year, 365+365+1 = 731
		Date date = new Date(12, 02, 2003);
		Date date1 = new Date(12, 02, 2005);
		assertEquals(731, date.daysTo(date1));
		
		Date date2 = new Date(12, 02, 2003); //other
		Date date3 = new Date(10, 06, 2004); //this
		assertEquals(-309, date3.daysTo(date2));		
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.packdoption.util.Date#yearsTo(edu.ncsu.csc216.packdoption.util.Date)}.
	 */
	@Test
	void testYearsTo() {
		Date date = new Date(11, 8, 2018); //this
		Date date1 = new Date(11, 7, 2019); //other
		assertEquals(0, date.yearsTo(date1));
		
		Date date2 = new Date(11, 8, 2018);
		Date date3 = new Date(11, 8, 2019);
		assertEquals(1, date2.yearsTo(date3));
	}

}
