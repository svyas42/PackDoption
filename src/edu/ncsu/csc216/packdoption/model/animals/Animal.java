package edu.ncsu.csc216.packdoption.model.animals;

import edu.ncsu.csc216.packdoption.util.Date;
import edu.ncsu.csc216.packdoption.util.Note;
import edu.ncsu.csc216.packdoption.util.SortedLinkedList;

/**
 * Abstract class that checks and gets the needed valid information about the
 * animals
 * 
 * @author Sachi Vyas
 */
public abstract class Animal implements Comparable<Animal> {

	/** The name of the animal */
	private String name;
	/** Boolean value to check if the animal is house trained */
	private boolean houseTrained;
	/** Boolean value to check if the animal is good with kids */
	private boolean goodWithKids;
	/** Boolean value to check if the animal is adopted */
	private boolean adopted;
	/** String to store the name of the owner */
	private String owner;
	/** String to store the date on which the animal entered the rescue */
	private Date dateEnterRescue;
	/** String to store the birthday of the animal */
	private Date birthday;
	/** String to store the adoption date of the animal */
	private Date dateAdopted;
	/** Variable to store the size of the animal */
	private Size size;
	/** The list of notes along with other animal information */
	private SortedLinkedList<Note> notes;

	/** The possible Enum values for age category */
	public enum AgeCategory {
		/** Young category */
		YOUNG,
		/** Adult category */
		ADULT,
		/** Senior category */
		SENIOR
	}

	/** The possible Enum values for size of the animal */
	public enum Size {
		/** Small size */
		SMALL,
		/** Medium size */
		MEDIUM,
		/** Large size */
		LARGE
	}

	/**
	 * Constructor of the Animal class
	 * @param name            the name of the animal
	 * @param birthday        the birthday of the animal
	 * @param size            the size of the animal
	 * @param houseTrained    checks if animal is house trained (true if yes, false
	 *                        otherwise)
	 * @param goodWithKids    houseTrained checks if animal is good with kids (true
	 *                        if yes, false otherwise)
	 * @param notes           the notes that were put along with the adoption animal
	 * @param dateEnterRescue the data at which the animal entered the rescue
	 * @param adopted         checks if an animal was adopted from the rescue (true
	 *                        if adopted, false otherwise)
	 * @param dateAdopted     date at which the animal was adopted
	 * @param owner           the owner of the animal
	 * @throws IllegalArgumentException if the name is invalid
	 * @throws IllegalArgumentException if the birthday, size, or dateEnterRescue
	 *                                  are null
	 * @throws IllegalArgumentException if the dateEnterRescue comes before birthday
	 * @throws IllegalArgumentException if the animal is adopted and dateAdopted and
	 *                                  owner are null
	 * @throws IllegalArgumentException if the animal is not adopted and dateAdopted
	 *                                  and owner are not null
	 */
	public Animal(String name, Date birthday, Size size, boolean houseTrained, boolean goodWithKids,
			SortedLinkedList<Note> notes, Date dateEnterRescue, boolean adopted, Date dateAdopted, String owner) {
		String name1 = null;
		if (name == null || "".equals(name) || name.contains("\n") || name.contains(",") || name.isBlank()) {
			throw new IllegalArgumentException("Invalid name.");
		}

		name1 = name.trim();
		
		if (birthday == null || size == null || dateEnterRescue == null) {
			throw new IllegalArgumentException();
		}
		
		if (notes == null) {
			throw new IllegalArgumentException("Invalid notes");
		}

		if (birthday.compareTo(dateEnterRescue) == 1) {
			throw new IllegalArgumentException();
		}
		
		if (!adopted && (dateAdopted != null || owner != null)) {
			throw new IllegalArgumentException();
		}
		
		if (adopted && (dateAdopted == null || owner == null)) {
			throw new IllegalArgumentException();
		}
		if (adopted) {
			if (dateAdopted.compareTo(dateEnterRescue) < 0) {
				throw new IllegalArgumentException();
			}
			if (owner.isBlank() || owner.contains("\n") || owner.contains(",")) {
				throw new IllegalArgumentException();
			}
			this.adopted = adopted;
			this.dateAdopted = dateAdopted;
			this.owner = owner.trim();
		}
		
		this.name = name1;
		this.birthday = birthday;
		this.size = size;
		this.houseTrained = houseTrained;
		this.goodWithKids = goodWithKids;
		this.notes = notes;
		this.dateEnterRescue = dateEnterRescue;
	}

	/**
	 * Second constructor for the Animal class without the adoption information
	 * 
	 * @param name            the name of the animal
	 * @param birthday        the birthday of the animal
	 * @param size            the size of the animal
	 * @param houseTrained    checks if animal is house trained (true if yes, false
	 *                        otherwise)
	 * @param goodWithKids    houseTrained checks if animal is good with kids (true
	 *                        if yes, false otherwise)
	 * @param notes           the notes that were put along with the adoption animal
	 * @param dateEnterRescue the data at which the animal entered the rescue
	 */
	public Animal(String name, Date birthday, Size size, boolean houseTrained, boolean goodWithKids,
			SortedLinkedList<Note> notes, Date dateEnterRescue) {
		this(name, birthday, size, houseTrained, goodWithKids, notes, dateEnterRescue, false, null, null);
	}

	/**
	 * Sets the adoption information of the animal
	 * 
	 * @param adopted     checks if an animal was adopted from the rescue (true if
	 *                    adopted, false otherwise)
	 * @param dateAdopted date at which the animal was adopted
	 * @param owner       the owner of the animal
	 * @throws IllegalArgumentException when the animal is adopted but owner or dateAdopted is null
	 * @throws IllegalArgumentException when animal is not adopted but has a owner and adoption date
	 */
	public void setAdoptionInfo(boolean adopted, Date dateAdopted, String owner) {
		String owner1 = null;
		if (adopted) {
//			this.adopted = true;
//			owner1 = owner.trim();
//			this.dateAdopted = dateAdopted;
//			this.owner = owner1;
			if (dateAdopted == null || owner == null || owner.isBlank() || owner.contains("\n") || owner.contains(",")) {
				throw new IllegalArgumentException();
			}
			if (dateAdopted.compareTo(dateEnterRescue) < 0) {
				throw new IllegalArgumentException();
			}
			this.adopted = true;
			owner1 = owner.trim();
			this.dateAdopted = dateAdopted;
			this.owner = owner1;
		}
		else if (!adopted && (dateAdopted != null || owner != null)) {
			throw new IllegalArgumentException();
		}
	}

	/**
	 * Sets the size of the animal
	 * 
	 * @param size the size of the animal
	 * @throws IllegalArgumentException when the size is null
	 */
	public void setSize(Size size) {
		if (size == null) {
			throw new IllegalArgumentException();
		}
		this.size = size;
	}

	/**
	 * Gets the name of the animal
	 * 
	 * @return name the name of the animal
	 */
	public String getName() {
		return name;
	}

	/**
	 * Gets the birthday of the animal
	 * 
	 * @return name the name of the animal
	 */
	public Date getBirthday() {
		return birthday;
	}

	/**
	 * Gets the size of the animal
	 * 
	 * @return size the size of the animal
	 */
	public Size getSize() {
		return size;
	}

	/**
	 * Returns true if the animal is house trained or false otherwise
	 * 
	 * @return boolean true if the animal is house trained or false otherwise
	 */
	public boolean isHouseTrained() {
		return houseTrained;
	}

	/**
	 * Returns true if the animal is the good with kids or false otherwise
	 * 
	 * @return boolean true if the animal is the good with kids or false otherwise
	 */
	public boolean isGoodWithKids() {
		return goodWithKids;
	}

	/**
	 * Getting the notes along with the animals in the system
	 * 
	 * @return notes the list of notes
	 */
	public SortedLinkedList<Note> getNotes() {
		return notes;
	}

	/**
	 * Returns the date on which the animal came to the rescue
	 * 
	 * @return dateEnterRescue the date on which the animal came to the rescue
	 */
	public Date getDateEnterRescue() {
		return dateEnterRescue;
	}

	/**
	 * Returns the date on which the animal was adopted
	 * 
	 * @return dateAdopted the date on which the animal was adopted
	 */
	public Date getDateAdopted() {
		return dateAdopted;
	}

	/**
	 * Returns the owner of the animal if there exists one
	 * 
	 * @return owner the owner of the animal
	 */
	public String getOwner() {
		return owner;
	}

	/**
	 * Returns true if the animal was adopted, false otherwise
	 * 
	 * @return adopted which is a boolean and returns true if the animal was
	 *         adopted, false otherwise
	 */
	public boolean adopted() {
		return adopted;
	}

	/**
	 * Returns true if a note is added to notes or false otherwise
	 * 
	 * @param note the note to add to the sorted array list notes
	 * @return boolean i.e. returns true if a note is added to notes or false
	 *         otherwise
	 * @throws IllegalArgumentException if the note is null or if the notes already
	 *                                  contain a note
	 */
	public boolean addNote(Note note) {
		if (note == null || notes.contains(note)) {
			throw new IllegalArgumentException();
		} else if (notes.add(note)) {
			return true;
		}
		return false;
	}

	/**
	 * Comparing animals based on their name and birthday
	 * 
	 * @param animal the animal to compare
	 * @return integer based on if the animal are same or not
	 */
	public int compareTo(Animal animal) {		
		//check if the entireity of the object is equal = 0
		//birthday != birthday return burthday compare to value
		//name != name
		//return names compare to value
//		if (name.equals(animal.getName())) {
//			if (birthday == animal.getBirthday()) {
//				return 1;
//			} else {
//				return 0;
//			}
//		} else {
//			return 0;
//		}
		if (this.birthday.compareTo(animal.birthday) != 0) {
			return this.birthday.compareTo(animal.birthday);
		}
		else {
			return this.name.compareTo(animal.name);
		}

	}

	/**
	 * Generates a hashCode for Animal using the name and birthday fields.
	 * 
	 * @return hashCode for Animal
	 */

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((birthday == null) ? 0 : birthday.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	/**
	 * Compares a given object to this object for equality on name and birthday
	 * fields.
	 * 
	 * @param obj the Object to compare
	 * @return true if the objects are the same on name and birthday fields.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Animal other = (Animal) obj;
		if (birthday == null) {
			if (other.birthday != null)
				return false;
		} else if (!birthday.equals(other.birthday))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	/**
	 * Returns the string representation of the name and birthday
	 */
	@Override
	public String toString() {
		return name + " (" + birthday.toString() + ")\n" + notes.toString();
	}

	/**
	 * Returns the age of the animal
	 * 
	 * @param today the current date
	 * @return age the age of the animal
	 * @throws IllegalArgumentException if today is null and if today is before
	 *                                  birthday
	 */
	public int getAge(Date today) {

		if (today == null || today.compareTo(birthday) < 0) {
			throw new IllegalArgumentException();
		}
		else {
			int total = birthday.daysTo(today);
			int age365DaysInterval = total / 365;
			return age365DaysInterval;
		}
//		int total = birthday.daysTo(today);
//		System.out.println(total);
//		int age365DaysInterval = total / 365;
//		return age365DaysInterval;
	}

	/**
	 * Returns the number of days that the animal has been available for adoption
	 * 
	 * @param today the current date
	 * @return days the number of days that the animal has been available for
	 *         adoption
	 * @throws IllegalArgumentException if today is null or if today comes before
	 *                                  dateEnterRescue
	 */
	public int getDaysAvailableForAdoption(Date today) {
		if (today == null || today.compareTo(dateEnterRescue) < 0) {
			throw new IllegalArgumentException();
		}
		if (adopted) {
			return -1;
		}
		return dateEnterRescue.daysTo(today);
	}
	

//	/**
//	 * Returns the string representation of the name and birthday
//	 * @return animal string that meets txt file specifications
//	 */
//	public String writerToString() {
//		String toReturn = "";
//		Boolean isDog = false;
//		if (this instanceof Dog) {
//			toReturn += "Dog";
//			isDog = true;
//		} else if (this instanceof Cat) {
//			toReturn += "Cat";
//		}
//		toReturn += "," + name;
//		toReturn += "," + birthday.toString();
//		toReturn += "," + size.toString();
//		toReturn += "," + size.toString();
//		toReturn += "," + isHouseTrained();
//		toReturn += "," + isGoodWithKids();
//		toReturn += "," + dateEnterRescue.toString();
//		if (!adopted && isDog) {
//			toReturn += "," + ((Dog) this).getBreed();
//		}
//		if (adopted) {
//			toReturn += "," + adopted;
//			toReturn += "," + getDateAdopted().toString();
//			toReturn += "," + getOwner();
//			if (isDog) {
//				toReturn += "," + ((Dog) this).getBreed();
//			}
//		}
//		toReturn += ",NOTES";
//		for (int i = 0; i < notes.size(); i++) {
//			toReturn += "," + notes.get(i).toString();
//		}
//		return toReturn;
//	}


	/**
	 * Returns a String array with seven elements based on today: Name, Type (Dog or
	 * Cat), Birthday, Age, Age Category, Adopted (Yes or No), Days in Rescue (if
	 * adopted then empty string)
	 * 
	 * @param today the current date
	 * @return array containing the variables described above
	 */
	public abstract String[] getAnimalAsArray(Date today);

	/**
	 * Returns the age category of the animal
	 * 
	 * @param today the current date
	 * @return ageCategory based on the current date
	 */
	public abstract AgeCategory getAgeCategory(Date today);
	
}
