package edu.ncsu.csc216.packdoption.util;

/**
 * Implements the Queue interface with an array data structure.
 * 
 * @author Jason Maher
 *
 * @param <E> List element type
 */
public class ArrayListQueue<E> implements Queue<E> {
	/**
	 * Private queue of arraylists
	 */
	private E[] list;
	/**
	 * Maintains the size of the list
	 */
	private int size;

	/**
	 * Constructs an arrayList from a Queue of veterinarian appointments
	 */
	@SuppressWarnings("unchecked")
	public ArrayListQueue() {
		size = 0;
		list = (E[]) new Object[1];
	}

	/**
	 * Inserts the specified element into this queue if it is possible to do so
	 * immediately without violating capacity restrictions, returning true upon
	 * success.
	 * 
	 * @param e element to be appended to this list
	 * @return true if add is successful
	 * @throws NullPointerException if the specified element is null and this queue
	 *                              does not permit null elements
	 */
	@Override
	public boolean add(E e) {
		if (e == null) {
			throw new NullPointerException("Queue does not permit null elements");
		}
		if (list.length > size) {
			list[size] = e;
			size++;
			return true;
		}
		if (size == list.length) {
			int doubleLength = size * 2;
			@SuppressWarnings("unchecked")
			E[] growingList = (E[]) new Object[doubleLength];
			for (int i = 0; i < list.length; i++) {
				growingList[i] = list[i];
			}
			list = growingList;
		}
		list[size] = e;
		size++;
		return true;
	}

	/**
	 * Retrieves and removes the head of this queue. This method differs from poll
	 * only in that it throws an exception if this queue is empty.
	 * 
	 * @return the head of this queue
	 * @throws NoSuchListElementException if this queue is empty
	 */
	@Override
	public E remove() {
		if (isEmpty()) {
			throw new NoSuchListElementException("Queue is empty");
		}
		E toReturn = list[0];
		for (int i = 0; i < list.length - 1; i++) {
			list[i] = list[i + 1];
		}
//		list[size - 1] = null;
		size--;
		return toReturn;
	}

	/**
	 * Retrieves, but does not remove, the head of this queue. Throws an exception
	 * if this queue is empty.
	 * 
	 * @return the head of this queue
	 * @throws NoSuchListElementException if this queue is empty
	 */
	@Override
	public E element() {
		if (isEmpty()) {
			throw new NoSuchListElementException("Queue is empty");
		}
		return list[0];
	}

	/**
	 * Returns the number of elements in this collection.
	 * 
	 * @return the number of elements in this collection
	 */
	@Override
	public int size() {
		return size;
	}

	/**
	 * Returns true if this collection contains no elements.
	 * 
	 * @return true if this collection contains no elements
	 */
	@Override
	public boolean isEmpty() {
		return size == 0;
	}
}
