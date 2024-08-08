/**
 * 
 */
package edu.ncsu.csc216.packdoption.util;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;

import edu.ncsu.csc216.packdoption.util.SortedLinkedList.Cursor;

import org.junit.jupiter.api.Test;

/**
 * Tests the SortedLinkedList class
 * @author Sachi Vyas
 * @author Jason Maher
 */
public class SortedLinkedListTest {
	
	/** creating an instance of node class as the inner class of sortedlinkedlist*/
	@SuppressWarnings("unused")
	private SortedLinkedList<String>.Node<String> node;
	/**
	 * Test method for {@link edu.ncsu.csc216.packdoption.util.SortedLinkedList#hashCode()}.
	 */
	@Test
	void testHashCode() {
		SortedLinkedList<String> linkedList = new SortedLinkedList<String>();
		linkedList.add("c");
		linkedList.add("l");
		linkedList.add("t");
		int hashCode = linkedList.hashCode();
		SortedLinkedList<String> linkedList2 = new SortedLinkedList<String>();
		linkedList2.add("c");
		linkedList2.add("l");
		linkedList2.add("t");
		int hashCode2 = linkedList.hashCode();
		assertEquals(hashCode, hashCode2);
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.packdoption.util.SortedLinkedList#SortedLinkedList()}.
	 */
	@Test
	void testSortedLinkedList() {
		SortedLinkedList<String> linkedList = new SortedLinkedList<String>();
		assertNotNull(linkedList);
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.packdoption.util.SortedLinkedList#size()}.
	 */
	@Test
	void testSize() {
		SortedLinkedList<String> linkedList = new SortedLinkedList<String>();
		linkedList.add("mango");
		linkedList.add("cherry");
		linkedList.add("peach");
		linkedList.add("pear");
		assertEquals(linkedList.size(), 4);
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.packdoption.util.SortedLinkedList#isEmpty()}.
	 */
	@Test
	void testIsEmpty() {
		SortedLinkedList<String> linkedList = new SortedLinkedList<String>();
		assertTrue(linkedList.isEmpty());
		linkedList.add("mangoes");
		assertFalse(linkedList.isEmpty());
		SortedLinkedList<String> list = new SortedLinkedList<>();
		list.add("a");
		list.add("b");
		list.add("c");
		
		@SuppressWarnings("rawtypes")
		Cursor cursor = (Cursor) list.iterator();
		assertTrue(cursor.hasNext());
		assertEquals("a", cursor.next());
		assertEquals("b", cursor.next());
		assertEquals("c", cursor.next());
		assertFalse(cursor.hasNext());
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.packdoption.util.SortedLinkedList#contains(java.lang.Comparable)}.
	 */
	@Test
	void testContains() {
		SortedLinkedList<String> linkedList = new SortedLinkedList<String>();
		linkedList.add("carrot");
		linkedList.contains("carrot");
		assertTrue(linkedList.contains("carrot"));
		assertFalse(linkedList.contains("carrots"));
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.packdoption.util.SortedLinkedList#add(java.lang.Comparable)}.
	 */
	@Test
	void testAdd() {
		SortedLinkedList<String> linkedList = new SortedLinkedList<String>();
		linkedList.add("carrot");
		linkedList.add("lettuce");
		linkedList.add("tomato");
		assertEquals("carrot", linkedList.get(0));
		assertEquals("lettuce", linkedList.get(1));
		assertEquals("tomato", linkedList.get(2));
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.packdoption.util.SortedLinkedList#remove(int)}.
	 */
	@Test
	void testRemove() {
		SortedLinkedList<String> linkedList = new SortedLinkedList<String>();
		linkedList.add("carrot");
		linkedList.add("lettuce");
		linkedList.add("tomato");
		assertEquals("carrot", linkedList.get(0));
		assertEquals("lettuce", linkedList.get(1));
		assertEquals("tomato", linkedList.get(2));
		linkedList.remove(0);
		linkedList.remove(1);
		assertEquals(1, linkedList.size());
		Exception e = assertThrows(IndexOutOfBoundsException.class, () -> linkedList.remove(-1));
		assertEquals(e.getMessage(), "Index does not exist");
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.packdoption.util.SortedLinkedList#indexOf(java.lang.Comparable)}.
	 */
	@Test
	void testIndexOf() {
		SortedLinkedList<String> linkedList = new SortedLinkedList<String>();
		linkedList.add("carrot");
		linkedList.add("lettuce");
		linkedList.add("tomato");
		assertEquals(0, linkedList.indexOf("carrot"));
		assertEquals(1, linkedList.indexOf("lettuce"));
		assertEquals(2, linkedList.indexOf("tomato"));
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.packdoption.util.SortedLinkedList#toString()}.
	 */
	@Test
	void testToString() {
		SortedLinkedList<String> linkedList = new SortedLinkedList<String>();
		linkedList.add("c");
		linkedList.add("l");
		linkedList.add("t");
		String veggies = linkedList.toString();
		assertEquals(veggies.charAt(0), '-');
		assertEquals(veggies.charAt(1), 'c');
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.packdoption.util.SortedLinkedList#equals(java.lang.Object)}.
	 */
	@Test
	void testEqualsObject() {
		SortedLinkedList<String> linkedList = new SortedLinkedList<String>();
		linkedList.add("c");
		linkedList.add("l");
//		linkedList.add("t");
		
		SortedLinkedList<String> linkedList2 = new SortedLinkedList<String>();
		linkedList2.add("c");
		linkedList2.add("l");
//		linkedList2.add("t");
		
		assertTrue(linkedList.equals(linkedList2));
		
//		SortedLinkedList<String> linkedList3 = new SortedLinkedList<String>();
//		linkedList3.add("x");
//		linkedList3.add("y");
//		linkedList3.add("zebra");
//		
//		
//		assertFalse(linkedList.equals(linkedList3));
	}
	
	/**
	 * Tests the next method in inner class of SortedLinkedList (Node)
	 */
	@Test
	void testNext() {
		SortedLinkedList<String> list2 = new SortedLinkedList<>();
		list2.add("apple");
		list2.add("banana");
		list2.add("pear");
		
		@SuppressWarnings("rawtypes")
		Cursor cursor1 = (Cursor) list2.iterator();
		assertEquals("apple", cursor1.next());
		assertEquals("banana", cursor1.next());
		assertEquals("pear", cursor1.next());
	}
	
	/**
	 * Set up before starting the testing for the equal method in node class
	 */
	@Before
	void setUp() {
		SortedLinkedList<String> list = new SortedLinkedList<>();
		node = list.new Node<>("check");
	}
	
	/**
	 * Testing the equals method in the node class (inner class of sorted linked list)
	 */
	@SuppressWarnings("rawtypes")
	@Test
	void testEquals() {
		SortedLinkedList<Integer> list = new SortedLinkedList<>();
		SortedLinkedList.Node node1 = list.new Node<>(1);
		SortedLinkedList.Node node2 = list.new Node<>(1);
		assertTrue(node1.equals(node2));
		//SortedLinkedList.Node node3 = list.new Node<>(1);
		assertTrue(node2.equals(node2));
//		assertFaLSE(null == node3);
		
		
	}



}
