package edu.ncsu.csc216.packdoption.util;


/**
 * Maintains a sorted linked list of Animals and associated notes. Contains
 * Cursor, and Node inner classes.
 * 
 * @author Jason Maher
 * @author Sachi Vyas
 * @param <E> List element type
 */
public class SortedLinkedList<E extends Comparable<E>> implements SortedList<E> {
	/**
	 * Number of elements within the list
	 */
	private int size;
	/**
	 * Frontmost node in the SortedLinkedList.
	 */
	private Node<E> head;

//	/**
//	 * Cursor for iterating forward through the list without changing the list.
//	 */
//	private Cursor current;

	/**
	 * Constructor for the sorted linked list
	 */
	public SortedLinkedList() {
//		head = null;
		size = 0;
	}

	/**
	 * Returns the number of elements in this list. If this list contains more than
	 * Integer.MAX_VALUE elements, returns Integer.MAX_VALUE.
	 *
	 * @return the number of elements in this list
	 */
	public int size() {
		return size;
	}

	/**
	 * Checks if the linked list is empty
	 * 
	 * @return true if the list is empty, false otherwise
	 */
	public boolean isEmpty() {
		return size == 0;
	}

	/**
	 * Returns true if this list contains the specified element. More formally,
	 * returns true if and only if this list contains at least one element a such
	 * that (o==null ? a==null : o.equals(a)).
	 *
	 * @param e element whose presence in this list is to be tested
	 * @return true if this list contains the specified element
	 */
	@Override
	public boolean contains(E e) {
		Node<E> currentNode = head;
		while (currentNode != null) {
			if (currentNode.value.equals(e)) {
				return true;
			}
			currentNode = currentNode.next;
		}
		return false;
	}

	/**
	 * Adds the specified element to list in sorted order
	 *
	 * @param e element to be appended to this list
	 * @return true as specified by link Collection#add
	 * @throws NullPointerException     if e is null
	 * @throws IllegalArgumentException if list already contains e
	 */
	@Override
	public boolean add(E e) {
		if (e == null) {
			throw new NullPointerException("cannot add null elements");
		}
		if (contains(e)) {
			throw new IllegalArgumentException("List already contains element");
		}
		Node<E> node = new Node<>(e);
		if (head == null) {
			head = node;
			size++;
			return true;
		}	
		
		// 1st index
		else if (e.compareTo(head.value) < 0) {
			node.next = head;
			head = node;
		} else {
			Node<E> currentNode = head;
			while (currentNode.next != null) {
				//stop before a value that comes after
				if (e.compareTo(currentNode.next.value) < 0) {
					break;
				}
				//iterate
				currentNode = currentNode.next;
			}
			// add the element
			node.next = currentNode.next;
			currentNode.next = node;
		}
		size++;
		return true;
	}

	/**
	 * Returns the element at the specified position in this list.
	 *
	 * @param index index of the element to return
	 * @return the element at the specified position in this list
	 * @throws IndexOutOfBoundsException if the index is out of range if index is less than 0 or
	 * greater than or equal to size
	 */
	@Override
	public E get(int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("Index does not exist");
		}
		Node<E> node = head;
		for (int i = 0; i < index; i++) {
			node = node.next;
		}
		return node.value;
	}

	/**
	 * Removes the element at the specified position in this list. Shifts any
	 * subsequent elements to the left (subtracts one from their indices). Returns
	 * the element that was removed from the list.
	 *
	 * @param index the index of the element to be removed
	 * @return the element previously at the specified position
	 * @throws IndexOutOfBoundsException if the index is out of range (index less than 0 or
	 *                                   index greater than or equal to size())
	 */
	@Override
	public E remove(int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("Index does not exist");
		}
		E nodeRemoved;
		if (index == 0) {
			nodeRemoved = head.value;
			head = head.next;
		} else {
			Node<E> node = head;
			for (int i = 0; i < index - 1; i++) {
				node = node.next;
			}
			nodeRemoved = node.next.value;
			node.next = node.next.next;
		}
		size--;
		return nodeRemoved;
	}

	/**
	 * Returns the index of the first occurrence of the specified element in this
	 * list, or -1 if this list does not contain the element. More formally, returns
	 * the lowest index i such that (o==null ? get(i)==null : o.equals(get(i))), or
	 * -1 if there is no such index.
	 *
	 * @param e element to search for
	 * @return the index of the first occurrence of the specified element in this
	 *         list, or -1 if this list does not contain the element
	 */
	@Override
	public int indexOf(E e) {
		int idx = 0;
		Node<E> node = head;
		while (node != null) {
			if(node.value.equals(e)) {
				return idx;
			}
			node = node.next;
			idx++;
		}
		return -1;
	}

	/**
	 * Iterator for the SortedLinkedList which returns an instance of the cursor
	 * 
	 * @return current instance of cursor
	 */
	public SimpleListIterator<E> iterator() {
		Cursor cursor = new Cursor();
		return cursor;
	}
	/**
	 * Generates a list of elements stored within the sortedLinkedList
	 * @return listString list of nodes stored in the sortedLinkedList
	 */
	public String toString() {
//		String listString = "";
//		Node<E> node = head;
//		while (node != null) {
//			listString += "-" + node.value.toString() + "\n";
//			node = node.next;
//		}
//		return listString;
		
		String listString = "";
		if (isEmpty()) {
			return "";
		}
		Cursor c = (SortedLinkedList<E>.Cursor) this.iterator();
		for (int i = 0; i < size - 1; i++) {
			listString = listString + "-" + c.current.value + "\n";
			c.next();
		}
		listString = listString + "-" + c.current.value;
		return listString;
		
	}
	
	/**
	 * Compares two Node objects to check if equivalent
	 * @return result the hashcode
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((head == null) ? 0 : head.hashCode());
		return result;
	}
	
	/**
	 * Compares two Node objects to check if equivalent
	 * @param obj Object compared to the current node
	 * @return true if the two objects are equal and false otherwise
	 */
	@SuppressWarnings("unchecked")
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SortedLinkedList<E> other = (SortedLinkedList<E>) obj;
		if (head == null) {
			if (other.head != null)
				return false;
		} else if (!head.equals(other.head))
			return false;
		return size == other.size;
			
	}


	/**
	 * Provides a cursor for iterating forward through the list one item at a time
	 * without changing the list.
	 * 
	 * @author Jason Maher
	 *
	 */
	public class Cursor implements SimpleListIterator<E> {
		/**
		 * Current node the cursor is pointing to
		 */
		private Node<E> current;

		/**
		 * Constructs a cursor to iterate through the list
		 */
		public Cursor() {
			current = head;
		}

		/**
		 * Are there elements in the collection that have not been visited?
		 *
		 * @return true if yes, false if all elements have been visited
		 */
		public boolean hasNext() {
			return current != null;
		}

		/**
		 * Answers the question: "What is the next element in the collection to be
		 * visited?" This method also advances the iterator to the following element, or
		 * throws NoSuchListElementException if the list has already been traversed.
		 * Exception message: "No element available with call to next."
		 *
		 * @return the next element in the collection to be visited
		 */
		@Override
		public E next() {
			if (!hasNext()) {
				throw new NoSuchListElementException("No element available with call to next.");
			}
			E index = current.value;
			// advance the cursor
			current = current.next;
			// return value of the next node to be checked
			return index;
		}
	}

	/**
	 * Node class within SortedLinkList. Creates nodes to be stored and used by the
	 * SortedLinkList.
	 * 
	 * @author Jason Maher
	 *
	 * @param <T> List element type
	 */
	public class Node<T> {
		/**
		 * value of current node
		 */
		E value;
		/**
		 * next node in the linked list
		 */
		Node<E> next;

		/**
		 * Single parameter Node constructor
		 * 
		 * @param data data of the node
		 */
		public Node(E data) {
			this.value = data;
		}

		/**
		 * Constructs a ListNode
		 * 
		 * @param data data of the node
		 * @param next reference to next node
		 */
		public Node(E data, Node<E> next) {
			this.value = data;
			this.next = next;
		}

		/**
		 * Compares two Nodes for equivalent hashcode
		 * @return result the resulting hashcodes
		 */
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((value == null) ? 0 : value.hashCode());
			return result;
		}

		/**
		 * Compares two Node objects to check if equivalent
		 * 
		 * @param obj Object compared to the current node
		 * @return true of two objects are equal and false otherwise
		 */
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			@SuppressWarnings("unchecked")
			Node<E> other = (Node<E>) obj;
			
			if (next == null) {
				if (other.next != null)
					return false;
			} else if (!next.equals(other.next))
				return false;
			
			
			if (value == null) {
				if (other.value != null)
					return false;
			} else if (!value.equals(other.value))
				return false;
			return true;
		}
		
	}
}
