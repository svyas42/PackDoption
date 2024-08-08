package edu.ncsu.csc216.packdoption.model.rescue;

import edu.ncsu.csc216.packdoption.util.SortedLinkedList;

/**
 * Adds rescues to the list
 * 
 * @author Jason Maher
 * @author Sachi Vyas
 */
public class RescueList {

	/** SortedLinkedList of Rescue s */
	private SortedLinkedList<Rescue> rescues;

	/**
	 * Constructor for the RescueList() class
	 */
	public RescueList() {
		rescues = new SortedLinkedList<Rescue>();
	}

	/**
	 * Adds the given rescue to the rescues list
	 * 
	 * @param r the rescue to add to the list
	 * @throws IllegalArgumentException if r is null or if r is already in the list.
	 * @throws IllegalArgumentException if the same rescue is added twice
	 */
	public void addRescue(Rescue r) {
		if (r == null) {
			throw new IllegalArgumentException("Rescue cannot be null");
		}
		if (rescues.contains(r)) {
			throw new IllegalArgumentException("Cannot add same rescue twice.");
		}
		rescues.add(r);
	}

	/**
	 * Add a rescue to the rescue list from a name parameter as a string.
	 * 
	 * @param name the name of the rescue
	 * @throws IllegalArgumentException if name is null, if name is whitespace only, if name contains
	 * @throws IllegalArgumentException if a rescue with name is already in the list.
	 */
	public void addRescue(String name) {
		if (name == null || name.isBlank() || name.contains("\n")) {
			throw new IllegalArgumentException("invalid Rescue name.");
		}
		for (int i = 0; i < rescues.size(); i++) {
			if (rescues.get(i).getName().equals(name)) {
				throw new IllegalArgumentException("RescueList already contains Rescue.");
			}
		}
		Rescue rescueToAdd = new Rescue(name);
		rescues.add(rescueToAdd);
	}

	/**
	 * Returns the rescue at the given index
	 * 
	 * @param idx the index from which to get the rescue
	 * @return rescue on the given index
	 * @throws IndexOutOfBoundsException if idx is negative or greater than size - 1.
	 */
	public Rescue getRescue(int idx) {
		if (idx < 0 || idx > size() - 1) {
			throw new IndexOutOfBoundsException("Index out of bounds for size " + size());
		}
		return rescues.get(idx);
	}

	/**
	 * Returns the number of rescues in the list
	 * 
	 * @return number the number of rescues in the list
	 */
	public int size() {
		return rescues.size();
	}
}
