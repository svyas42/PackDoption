package edu.ncsu.csc216.packdoption.model.animals;

import edu.ncsu.csc216.packdoption.util.Date;
import edu.ncsu.csc216.packdoption.util.Note;
import edu.ncsu.csc216.packdoption.util.SortedLinkedList;

/**
 * Gets all the information if the animal is a dog
 * @author Sachi Vyas
 */
public class Dog extends Animal {
	
	/**
	 * Gets the needed information from the parent class about the dog
	 * @param name the name of the animal
	 * @param birthday the birthday of the animal
	 * @param size the size of the animal
	 * @param houseTrained checks if animal is house trained (true if yes, false otherwise)
	 * @param goodWithKids houseTrained checks if animal is good with kids (true if yes, false otherwise)
	 * @param notes the notes that were put along with the adoption animal
	 * @param dateEnterRescue the data at which the animal entered the rescue
	 * @param adopted checks if an animal was adopted from the rescue (true if adopted, false otherwise)
	 * @param dateAdopted date at which the animal was adopted
	 * @param owner the owner of the animal
	 * @param breed the breed of the dog
	 * @throws IllegalArgumentException when the breed is null
	 */
	public Dog(String name, Date birthday, Size size, boolean houseTrained, boolean goodWithKids,
			SortedLinkedList<Note> notes, Date dateEnterRescue, boolean adopted, Date dateAdopted, String owner, Breed breed) {
		super(name, birthday, size, houseTrained, goodWithKids, notes, dateEnterRescue, adopted, dateAdopted, owner);
		if (breed == null) {
			throw new IllegalArgumentException("Invalid breed");
		}
		this.breed = breed;
		
	}
	
	/**
	 * Gets the needed information from the parent class about the dog without adoption information
	 * @param name the name of the animal
	 * @param birthday the birthday of the animal
	 * @param size the size of the animal
	 * @param houseTrained checks if animal is house trained (true if yes, false otherwise)
	 * @param goodWithKids houseTrained checks if animal is good with kids (true if yes, false otherwise)
	 * @param notes the notes that were put along with the adoption animal
	 * @param dateEnterRescue the data at which the animal entered the rescue
	 * @param breed the breed of the dog
	 * @throws IllegalArgumentException when the breed is null
	 */
	public Dog(String name, Date birthday, Size size, boolean houseTrained, boolean goodWithKids,
			SortedLinkedList<Note> notes, Date dateEnterRescue, Breed breed) {
		super(name, birthday, size, houseTrained, goodWithKids, notes, dateEnterRescue);
		
		if (breed == null) {
			throw new IllegalArgumentException("Invalid breed");
		}
		this.breed = breed;
	}
	/** Instance of the breed enum */
	private Breed breed;
	
	/** The possible Enum values for dog breed */
	public enum Breed {

		/** Breed beagle */
		BEAGLE,
		/** Breed bull dog */
		BULLDOG,
		/** Breed french bull dog */
		FRENCH_BULLDOG, 
		/** Breed german shepherd */
		GERMAN_SHEPHERD, 
		/** Breed pointer german shorthaired */
		POINTER_GERMAN_SHORTHAIRED,
		/** Breed poodle */
		POODLE, 
		/** Breed golden retriever */
		RETRIEVER_GOLDEN, 
		/** Breed Retriever labrador */
		RETRIEVER_LABRADOR,
		/** Breed rottweiler */
		ROTTWEILER, 
		/** Breed yorkshire terrier */
		YORKSHIRE_TERRIER, 
		/** Breed mixed */
		MIXED,
		/** Breed other */
		OTHER
	}
	
	/**
	 * Gets the breed of the dog
	 * @return breed the breed of the dog
	 */
	public Breed getBreed() {
		return breed;
	}
	
	/**
	 * Returns the category of the dog based on their age
	 * @param today the given date to calculate the age category of the dog
	 * @return the ageCategory of the dog
	 */
	@Override
	public AgeCategory getAgeCategory(Date today) {
		if (getSize() == Size.SMALL) {
			
			if (getAge(today) < 4 && getAge(today) >= 0){
				return AgeCategory.YOUNG;
			}
			else if (getAge(today) >= 4 && getAge(today) < 9) {
				return AgeCategory.ADULT;
			}
			else if (getAge(today) >= 9) {
				return AgeCategory.SENIOR;
			}
			else {
				return null;
			}
		}
		
		else if (getSize() == Size.MEDIUM) {
			if (getAge(today) < 3 && getAge(today) >= 0){
				return AgeCategory.YOUNG;
			}
			else if (getAge(today) >= 3 && getAge(today) < 9) {
				return AgeCategory.ADULT;
			}
			else if (getAge(today) >= 9) {
				return AgeCategory.SENIOR;
			}
			else {
				return null;
			}
			
		}
		
		else if (getSize() == Size.LARGE) {
			if (getAge(today) < 3 && getAge(today) >= 0){
				return AgeCategory.YOUNG;
			}
			else if (getAge(today) >= 3 && getAge(today) < 6) {
				return AgeCategory.ADULT;
			}
			else if (getAge(today) >= 6) {
				return AgeCategory.SENIOR;
			}
		}
//		else {
//			return null;
//		}
		return null;
		
	}
	
	/**
	 * Returns an array with the animal (dog) information
	 * @param today the current date
	 * @return shortArray with the animal(dog) information
	 */
	@Override
	public String[] getAnimalAsArray(Date today) {
		String[] shortArray = new String[7];
		shortArray[0] = this.getName();
		shortArray[1] = "Dog";
    	shortArray[2] = this.getBirthday().toString();
		shortArray[3] = "" + this.getAge(today);
//    	shortArray[4] = this.getAgeCategory(today).toString();
		shortArray[4] = this.getAgeCategory(today) + "";
		if (this.adopted()) {
			shortArray[5] = "Yes";
			shortArray[6] = "";
		}
		else {
			shortArray[5] = "No";
			shortArray[6] = this.getDaysAvailableForAdoption(today) + "";
		}
		
		
		
		return shortArray;
	}

}
