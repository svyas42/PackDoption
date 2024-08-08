package edu.ncsu.csc216.packdoption.util;

import static org.junit.jupiter.api.Assertions.*;

//import java.util.NoSuchElementException;

import org.junit.jupiter.api.Test;

/**
 * Tests the ArrayListQueue class
 * 
 * @author Sachi Vyas
 * @author Jason Maher
 *
 */
public class ArrayListQueueTest {
	
	/**
	 * Tests the ArrayListQueue constructor()
	 */
	@Test
	void testArrayListQueue() {
		try {
			ArrayListQueue<String> queue = new ArrayListQueue<String>();
			assertEquals(0, queue.size());
		} catch (Exception e) {
			fail();
		}
	}
	
	/**
	 * Tests the add method()
	 */
	@Test
	void testAdd() {
		ArrayListQueue<String> queue1 = new ArrayListQueue<String>();
		assertTrue(queue1.add("apples"));
		assertTrue(queue1.add("peaches"));
		assertTrue(queue1.add("bananas"));
		assertTrue(queue1.add("oranges"));
		assertEquals(4, queue1.size());
//		queue1.remove();
		Exception e = assertThrows(NullPointerException.class, () -> queue1.add(null));
		assertEquals(e.getMessage(), "Queue does not permit null elements");
	}
	
	/**
	 * Tests the remove method
	 */
	@Test
	void testRemove() {
		ArrayListQueue<String> queue1 = new ArrayListQueue<String>();
		assertTrue(queue1.add("apples"));
		assertTrue(queue1.add("peaches"));
		assertEquals(2, queue1.size());
		queue1.remove();
		assertEquals(1, queue1.size());
		queue1.remove();
		Exception e = assertThrows(NoSuchListElementException.class, () -> queue1.remove());
		assertEquals(e.getMessage(), "Queue is empty");
	}
	
	/**
	 * Test the element method()
	 */
	@Test
	void testElement() {
		ArrayListQueue<String> queue1 = new ArrayListQueue<String>();
		assertTrue(queue1.add("mango"));
		assertEquals(1, queue1.size());
		queue1.remove();
		assertEquals(0, queue1.size());
		Exception e = assertThrows(NoSuchListElementException.class, () -> queue1.element());
		assertEquals(e.getMessage(), "Queue is empty");
	}
	
	/**
	 * Tests the size() method
	 */
	@Test
	void testSize() {
		ArrayListQueue<String> queue1 = new ArrayListQueue<String>();
		assertTrue(queue1.add("mango"));
		assertTrue(queue1.add("rosemary"));
		assertEquals(2, queue1.size());
		queue1.remove();
		assertEquals(1, queue1.size());
	}
	
	/**
	 * Tests the isEmpty method()
	 */
	@Test
	void testIsEmpty() {
		ArrayListQueue<String> queue1 = new ArrayListQueue<String>();
		assertTrue(queue1.isEmpty());
	}

}
