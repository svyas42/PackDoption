package edu.ncsu.csc216.packdoption.model.rescue;

//import org.junit.jupiter.params.converter.ArgumentConverter;

import edu.ncsu.csc216.packdoption.model.animals.Animal;
import edu.ncsu.csc216.packdoption.model.animals.Cat;
import edu.ncsu.csc216.packdoption.model.animals.Dog;
import edu.ncsu.csc216.packdoption.util.ArrayListQueue;
import edu.ncsu.csc216.packdoption.util.Date;
import edu.ncsu.csc216.packdoption.util.Note;
import edu.ncsu.csc216.packdoption.util.SortedLinkedList;
//import edu.ncsu.csc216.packdoption.util.SortedLinkedList.Node;

/**
 * Constructs a rescue, adds, removes, filters rescues by certain
 * characteristics (age and day range for example)
 * 
 * @author Jason Maher
 * @author Sachi Vyas
 */
public class Rescue implements Comparable<Rescue> {
	/** Sorted linked list for animals */
	private SortedLinkedList<Animal> animals;
	/** The rescue name */
	private String name;
	/** Array list that stores the vet appointments for the animals */
	private ArrayListQueue<Animal> vetAppointments;

	/**
	 * Constructs rescue with given name, empty SortedLinkedList, and empty
	 * ArrayListQueue
	 * 
	 * @param name the name of the rescue
	 * @throws IllegalArgumentException if the name is null, contains only
	 *                                  whitespace, or contains a newline character
	 */
	public Rescue(String name) {
		if (name == null || name.isBlank() || name.contains("\n")) {
			throw new IllegalArgumentException("invalid name");
		}
		this.name = name.trim();
		animals = new SortedLinkedList<Animal>();
		vetAppointments = new ArrayListQueue<Animal>();
	}

	/**
	 * Gets the name of the rescue
	 * 
	 * @return name the name of the rescue
	 */
	public String getName() {
		return name;
	}

	/**
	 * Adds animal to animals
	 * 
	 * @param animal the animal to add in animals
	 * @return boolean true if an animal is added and false if we try to add a
	 *         duplicate animal
	 * @throws IllegalArgumentException if animal parameter is null
	 */
	public boolean addAnimal(Animal animal) {
		if (animal == null) {
			throw new IllegalArgumentException("animal is null");
		}	
		for (int i = 0; i < animals.size(); i++) {
			if (animals.get(i).getName() == animal.getName() && animals.get(i).getBirthday() == animal.getBirthday()) {
				return false;
			}
		}
		if (animals.contains(animal)) {
			return false;
		}

		animals.add(animal);
		return true;
	}

	/**
	 * Returns animal at i index of animals.
	 * 
	 * @param i the index at which to return the animal from
	 * @return the animal at the given index
	 * @throws IndexOutOfBoundsException if i is less than 0 or greater than size
	 */
	public Animal getAnimal(int i) {
		if (i < 0 || i >= animals.size()) {
			throw new IndexOutOfBoundsException("Invalid index for length " + animals.size());
		}
		return animals.get(i);
	}

	/**
	 * Gets the given animal with the given name and date
	 * 
	 * @param name     the name of the rescue
	 * @param birthday Date of Animal's birthday
	 * @return animal the animal with the given name and date
	 * @throws IllegalArgumentException if name is null or birthday is null.
	 */
	public Animal getAnimal(String name, Date birthday) {
		if (name == null || birthday == null) {
			throw new IllegalArgumentException("name or birthday cannot be null");
		}
		for (int i = 0; i < animals.size(); i++) {
			Animal animal = animals.get(i);
			String nameToCompare = animal.getName();
			Date birthdayToCompare = animal.getBirthday();
			if (name.equals(nameToCompare) && birthday.equals(birthdayToCompare)) {
				return animal;
			}
		}
		return null;
	}

	/**
	 * Returns whether animals contains a
	 * 
	 * @param a the animal to check for
	 * @return true if Rescue contains animal, false otherwise
	 */
	public boolean contains(Animal a) {
		return animals.contains(a);
	}

	/**
	 * Adds note to animal and returns true if animal is in the rescue
	 * 
	 * @param animal the animal to add the note to
	 * @param note   the note to add
	 * @return boolean true if the note is added and the animal is in the rescue and
	 *         false otherwise
	 * @throws IllegalArgumentException if animal is null, note is null, the
	 *                                  animal’s notes already contains note.
	 */
	public boolean addNote(Animal animal, Note note) {
		if (animal == null || note == null) {
			throw new IllegalArgumentException("Animal or note cannot be null");
		}
//		if (animals.contains(animal)) {
//			int idx = animals.indexOf(animal);
//			Animal foundAnimal = animals.get(idx);
//			if (foundAnimal.getNotes() != null) {
//				throw new IllegalArgumentException("Animal already contains note");
//			}
//			foundAnimal.addNote(note);
		// }

		for (int i = 0; i < animals.size(); i++) {
			if (animals.get(i).equals(animal)) {
				animals.get(i).addNote(note);
				return true;
			}
		}
		return false;
	}

	/**
	 * Sets the adoption information for the animal if the animal is in the rescue
	 * 
	 * @param animal      the animal to set the adoption information for
	 * @param adopted     checks if the animal is adopted
	 * @param dateAdopted the date on which the animal was adopted
	 * @param owner       the owner of the animal
	 * @throws IllegalArgumentException if animal is null, or owner is null
	 * 
	 * 
	 */
	public void setAdoptionInfo(Animal animal, boolean adopted, Date dateAdopted, String owner) {
//		if (animal == null || owner == null) {
//			throw new IllegalArgumentException("Animal cannot be null, and must have owner");
//		}
//		if (owner.isBlank() || owner.contains("\n") || owner.contains(",")) {
//			throw new IllegalArgumentException("Invalid owner");
//		}
//		if (animal == null || owner == null || owner.isBlank() || owner.contains("\n") || owner.contains(",")) {
//			throw new IllegalArgumentException("Animal cannot be null, and must have owner");
//		}
//		if (!adopted && (dateAdopted != null || owner != null)) {
//			throw new IllegalArgumentException("Animal has not been adopted but contains adoption date or owner");
//		}
//		if (adopted && (dateAdopted == null || owner == null)) {
//			throw new IllegalArgumentException("Animal has been adopted but does not contain adoption date or owner");
//		}
//		if (dateAdopted.compareTo(animal.getDateEnterRescue()) < 0) {
//			throw new IllegalArgumentException("Invalid adoption date");
//		}

		if (animal == null) {
			throw new IllegalArgumentException();
		}
		if (animal.adopted() && (animal.getOwner() == null || animal.getDateAdopted() == null)) {
			throw new IllegalArgumentException();
		}
		if (!animal.adopted() && (animal.getOwner() != null || animal.getDateAdopted() != null)) {
			throw new IllegalArgumentException();
		}

//		if (animal == null) {
//			throw new IllegalArgumentException(); 
//		}
		if (this.animals.contains(animal)) {
			animal.setAdoptionInfo(adopted, dateAdopted, owner);
		}
	}

	/**
	 * Returns the number of animals in the rescue
	 * 
	 * @return number of animals in the rescue
	 */
	public int numAnimals() {
		return animals.size();
	}

	/**
	 * Returns number of animals in rescue that are available for adoption (have not
	 * been adopted)
	 * 
	 * @return number of animals in rescue that are available for adoption
	 */
	public int numAnimalsAvailable() {// TODO try using cursor if time
		int numAvailable = 0;
		for (int i = 0; i < animals.size(); i++) {
			if (!animals.get(i).adopted()) {
				numAvailable++;
			}
		}
		return numAvailable;
	}

	/**
	 * Returns number of animals in rescue that have been adopted
	 * 
	 * @return number of animals in rescue that are adopted
	 */
	public int numAnimalsAdopted() {
		int numAdopted = 0;
		for (int i = 0; i < animals.size(); i++) {
			if (animals.get(i).adopted()) {
				numAdopted++;
			}
		}
		return numAdopted;
	}

	/**
	 * Returns SortedLinkedList of all animals in rescue that are available for
	 * adoption (have not been adopted)
	 * 
	 * @return list of animals available for adoption at the rescue
	 */
	public SortedLinkedList<Animal> animalsAvailable() {
		SortedLinkedList<Animal> animalsAvailable = new SortedLinkedList<Animal>();
		for (int i = 0; i < animals.size(); i++) {
			Animal animal = animals.get(i);
			if (!animal.adopted()) {
				animalsAvailable.add(animal);
			}
		}
		return animalsAvailable;
	}

	/**
	 * Returns SortedLinkedList of all cats in rescue that are available for
	 * adoption (have not been adopted).
	 * 
	 * @return list of cats available at the adoption at the rescue
	 */
	public SortedLinkedList<Animal> availableCats() {
		SortedLinkedList<Animal> catsAvailable = new SortedLinkedList<Animal>();
		for (int i = 0; i < animals.size(); i++) {
			Animal animal = animals.get(i);
			if (!animal.adopted() && animal instanceof Cat) {
				catsAvailable.add(animal);
			}
		}
		return catsAvailable;
	}

	/**
	 * Returns SortedLinkedList of all dogs in rescue that are available for
	 * adoption (have not been adopted).
	 * 
	 * @return list of dogs available at the adoption at the rescue
	 */
	public SortedLinkedList<Animal> availableDogs() {
		SortedLinkedList<Animal> dogsAvailable = new SortedLinkedList<Animal>();
		for (int i = 0; i < animals.size(); i++) {
			Animal animal = animals.get(i);
			if (!animal.adopted() && animal instanceof Dog) {
				dogsAvailable.add(animal);
			}
		}
		return dogsAvailable;
	}

	/**
	 * Returns SortedLinkedList have been adopted.
	 * 
	 * @return list of animals adopted at the rescue
	 */
	public SortedLinkedList<Animal> animalsAdopted() {
		SortedLinkedList<Animal> animalsAdopted = new SortedLinkedList<Animal>();
//		for (int i = 0; i < animals.size(); i++) {
//			Animal animal = animals.get(i);
//			if (animal.adopted()) {
//				animalsAdopted.add(animal);
//			}
//		}

		for (int i = 0; i < numAnimals(); i++) {
			if (animals.get(i).adopted()) {
				animalsAdopted.add(animals.get(i));
			}
		}
		return animalsAdopted;
	}

	/**
	 * Returns SortedLinkedList of all animals in rescue that are available for
	 * adoption (have not been adopted) and have been available between min and max
	 * days (inclusive)
	 * 
	 * @param today the current date
	 * @param min   the minimum number of days available for adoption
	 * @param max   the maximum number of days available for adoption
	 * @return list of animals in rescue that are available for adoption (have not
	 *         been adopted) and have been available between min and max days
	 *         (inclusive)
	 * @throws IllegalArgumentException if today is null, if today is before one of
	 *                                  the animal’s dateEnterRescue, if max is less
	 *                                  than min, or if min is less than zero.
	 */
	public SortedLinkedList<Animal> availableAnimalsDayRange(Date today, int min, int max) {
		SortedLinkedList<Animal> animalsAvailableDayRange = new SortedLinkedList<Animal>();
		if (today == null) {
			throw new IllegalArgumentException("invalid date for today");
		}
		if (min < 0 || max < min) {
			throw new IllegalArgumentException("invalid day range");
		}
		for (int i = 0; i < animals.size(); i++) {
			Animal animal = animals.get(i);
			if (today.compareTo(animal.getDateEnterRescue()) < 0) {
				throw new IllegalArgumentException("Today cannot come before the date an animal entered a rescue.");
			}
			Boolean withinValidDayRange = animal.getDaysAvailableForAdoption(today) > min
					&& animal.getDaysAvailableForAdoption(today) < max;
			if (withinValidDayRange && !animal.adopted()) {
				animalsAvailableDayRange.add(animal);
			}
		}
		return animalsAvailableDayRange;
	}

	/**
	 * Returns SortedLinkedList of all animals in rescue that are available for
	 * adoption (have not been adopted) and are between min and max years old
	 * (inclusive) based on their age
	 * 
	 * @param today the current date
	 * @param min   the minimum number of days available for adoption
	 * @param max   the maximum number of days available for adoption
	 * @return list of all animals in rescue that are available for adoption (have
	 *         not been adopted) and are between min and max years old (inclusive)
	 *         based on their age
	 * @throws IllegalArgumentException if today is null, today is before one of the
	 *                                  animal’s birthday, max is less than min, or
	 *                                  min is less than zero.
	 */
	public SortedLinkedList<Animal> availableAnimalsAge(Date today, int min, int max) {
		SortedLinkedList<Animal> animalsAvailableAgeRange = new SortedLinkedList<Animal>();
		if (today == null) {
			throw new IllegalArgumentException("invalid date for today");
		}
		if (min < 0 || max < min) {
			throw new IllegalArgumentException("invalid day range");
		}
		for (int i = 0; i < animals.size(); i++) {
			Animal animal = animals.get(i);
			// Boolean withinValidAgeRange = animal.getAge(today) > min &&
			// animal.getAge(today) < max;
			boolean withinValidAgeRange = animal.getAge(today) >= min && animal.getAge(today) <= max;
			if (withinValidAgeRange && !animal.adopted()) {
				animalsAvailableAgeRange.add(animal);
			}
		}
		return animalsAvailableAgeRange;
	}

	/**
	 * Rescues are compared based on name.
	 * 
	 * @param o the object to compare
	 * @return 0 if same, or less than 1 if name comes before parameter name,
	 *         greater than 1 if name comes after parameter name
	 */
	public int compareTo(Rescue o) { // TODO very vague description
//		String nameToCompare = o.getName();
//		name = this.getName();
//		return name.compareTo(nameToCompare);
		if (this.equals(o)) {
			return 0;
		}
		int compare = this.name.compareTo(o.name);
		if (compare < 0) {
			return -1;
		} else if (compare > 0) {
			return 1;
		}
		return 0;
	}

	/**
	 * Generated hashcode for animals using the name
	 * 
	 * @return hashCode for name
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	/**
	 * Compares a given object to this object for equality on all fields.
	 * 
	 * @param obj the Object to compare
	 * @return true if the objects are the same on all fields.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Rescue other = (Rescue) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	/**
	 * Returns the name of the rescue
	 * 
	 * @return name the name of the rescue
	 */
	public String toString() {
		return this.name;
	}

	/**
	 * Returns a 2D array of string representing all animals in rescue First
	 * dimension is the animal (in sorted order). Second dimension are the different
	 * elements: Name, Type (Dog or Cat), Birthday, Age, Age Category, Adopted (Yes
	 * or No), Days in Rescue (if adopted then empty string)
	 * 
	 * @param today current date
	 * @return array of string which has all the animals in the rescue
	 */
	public String[][] getAnimalsAsArray(Date today) {
		String[][] animalArray = new String[animals.size()][7];
		for (int i = 0; i < animals.size(); i++) {
			Animal animal = animals.get(i);
			animalArray[i][0] = animal.getName();
			// its a bit dumb animal does not have a type field
			if (animal instanceof Cat) {
				animalArray[i][1] = "Cat";
			} else if (animal instanceof Dog) {
				animalArray[i][1] = "Dog";
			}
			animalArray[i][2] = animal.getBirthday().toString();
			animalArray[i][3] = Integer.toString(animal.getAge(today));
			animalArray[i][4] = animal.getAgeCategory(today).toString();
			if (animal.adopted()) {
				animalArray[i][5] = "Yes";
				animalArray[i][6] = "";
			} else if (!animal.adopted()) {
				animalArray[i][5] = "No";
				animalArray[i][6] = Integer.toString(animal.getDaysAvailableForAdoption(today));
			}
		}
		return animalArray;
	}

	/**
	 * Returns a 2D array of string representing animals in veterinary queue. First
	 * dimension is the animal (in same order as queue). Second dimension are the
	 * different elements: Name, Type (Dog or Cat), Birthday, Age, Age Category,
	 * Adopted (Yes or No), Days in Rescue (if adopted then empty string)
	 * 
	 * @param today the current date
	 * @return array of string that has the appointments for the animals
	 */
	public String[][] getAppointmentsAsArray(Date today) {
		String[][] vetAppointmentsArray = new String[vetAppointments.size()][7];

//		ArrayListQueue<Animal> temp = vetAppointments;
//		for (int i = 0; i < vetAppointments.size(); i++) {
//			Animal animal = temp.remove();
//			vetAppointmentsArray[i][0] = animal.getName();
//			if (animal instanceof Cat) {
//				vetAppointmentsArray[i][1] = "Cat";
//			} else if (animal instanceof Dog) {
//				vetAppointmentsArray[i][1] = "Dog";
//			}
//			vetAppointmentsArray[i][2] = animal.getBirthday().toString();
//			vetAppointmentsArray[i][3] = Integer.toString(animal.getAge(today));
//			vetAppointmentsArray[i][4] = animal.getAgeCategory(today).toString();
//			if (animal.adopted()) {
//				vetAppointmentsArray[i][5] = "Yes";
//				vetAppointmentsArray[i][6] = "";
//			} else if (!animal.adopted()) {
//				vetAppointmentsArray[i][5] = "No";
//				vetAppointmentsArray[i][6] = Integer.toString(animal.getDaysAvailableForAdoption(today));
//			}
//		}

		for (int i = 0; i < vetAppointments.size(); i++) {
			vetAppointmentsArray[i][0] = this.vetAppointments.element().getName();
			if (this.vetAppointments.element() instanceof Cat) {
				vetAppointmentsArray[i][1] = "Cat";
			} else if (this.vetAppointments.element() instanceof Dog) {
				vetAppointmentsArray[i][1] = "Dog";
			}
			vetAppointmentsArray[i][2] = this.vetAppointments.element().getBirthday().toString();
			vetAppointmentsArray[i][3] = Integer.toString(this.vetAppointments.element().getAge(today));
			vetAppointmentsArray[i][4] = this.vetAppointments.element().getAgeCategory(today).toString();
			if (this.vetAppointments.element().adopted()) {
				vetAppointmentsArray[i][5] = "Yes";
				vetAppointmentsArray[i][6] = "";
			} else {
				vetAppointmentsArray[i][5] = "No";
				vetAppointmentsArray[i][6] = Integer
						.toString(this.vetAppointments.element().getDaysAvailableForAdoption(today));
			}
			this.vetAppointments.add(this.vetAppointments.remove());
		}
		return vetAppointmentsArray;
	}

	/**
	 * Adds animal to vetAppointments
	 * 
	 * @param animal the animal to add to the appointment
	 * @return boolean true if animal is in rescue else returns false
	 * @throws NullPointerException if animal is null.
	 */
	public boolean addAppointment(Animal animal) {// TODO will let same animal be added twice
		if (animal == null) {
			throw new NullPointerException("Animal cannot be null.");
		}
		if (animals.contains(animal)) {
			vetAppointments.add(animal);
			return true;
		}
		return false;
	}

	/**
	 * Gets the appointments of the animal
	 * 
	 * @return ArrayListQueue of vet appointments for animals within the rescue
	 */
	public ArrayListQueue<Animal> getAppointments() {
		return vetAppointments;
	}

//	/**
//	 * Returns a comma separated value String of rescue name.
//	 * 
//	 * @return String representation of rescue name
//	 */
//	public String writerToString() {
//		String toReturn = "";
//		toReturn += "# " + name + "\n";
//		for (int i = 0; i < animals.size(); i++) {
//			toReturn += "* " + animals.get(i).writerToString() + "\n";
//		}
//		int origSize = vetAppointments.size();
//		for (int i = 0; i < vetAppointments.size(); i++) {
//			ArrayListQueue<Animal> tempArrayListQueue = vetAppointments;
//			Animal currentAnimal = tempArrayListQueue.remove();
//			toReturn += "- " + currentAnimal.getName() + "," + currentAnimal.getBirthday();
//			if (i != origSize - 1) {
//				toReturn += "\n";
//			}
//		}
//		return toReturn;
//	}
}