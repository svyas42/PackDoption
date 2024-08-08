package edu.ncsu.csc216.packdoption.model.animals;

import edu.ncsu.csc216.packdoption.util.Date;
import edu.ncsu.csc216.packdoption.util.Note;
import edu.ncsu.csc216.packdoption.util.SortedLinkedList;

/**
 * Gets all the information if the animal is a cat
 * @author Sachi Vyas
 */
public class Cat extends Animal {
	/**
	 * Gets the needed information from the parent class about the cat
	 * @param name the name of the animal
	 * @param birthday the birthday of the animal
	 * @param size the size of the animal
	 * @param houseTrained checks if animal is house trained (true if yes, false otherwise)
	 * @param goodWithKids houseTrained checks if animal is good with kids (true if yes, false otherwise)
	 * @param notes the notes that were put along with the adoption animal
	 * @param dateEnterRescue the data at which the animal entered the rescue
	 */
	public Cat(String name, Date birthday, Size size, boolean houseTrained, boolean goodWithKids,
			SortedLinkedList<Note> notes, Date dateEnterRescue) {
		super(name, birthday, size, goodWithKids, goodWithKids, notes, dateEnterRescue);
		
		
		
	}
	
	/**
	 * Second constructor of the Cat class with adoption information
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
	 */
	public Cat(String name, Date birthday, Size size, boolean houseTrained, boolean goodWithKids,
			SortedLinkedList<Note> notes, Date dateEnterRescue, boolean adopted, Date dateAdopted, String owner) {
		
		super(name, birthday, size, houseTrained, goodWithKids, notes, dateEnterRescue, adopted, dateAdopted, owner);
	}

	/**
	 * Returns an array with the animal (cat) information
	 * @return array with the animal(cat) information
	 */
	@Override
	public String[] getAnimalAsArray(Date today) {
		
		String[] shortArray = new String[7];
		shortArray[0] = this.getName();
		shortArray[1] = "Cat";
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
	
	/**
	 * Returns the category of the cat based on their age
	 * @param today the current date to calculate the age category of the cat
	 * @return the ageCategory of the cat
	 */
	@Override
	public AgeCategory getAgeCategory(Date today) {
		
		
//			if (getAge(today) < 4 && getAge(today) > 0){
//				return AgeCategory.YOUNG;
//			}
//			if (getAge(today) >= 4 && getAge(today) < 9) {
//				return AgeCategory.ADULT;
//			}
//			else if (getAge(today) >= 9) {
//				return AgeCategory.SENIOR;
//			}
//		
//		return null;		
		
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
}
