package edu.ncsu.csc216.packdoption.model.io;

import java.io.IOException;
import java.io.PrintStream;
import java.io.File;

import edu.ncsu.csc216.packdoption.model.animals.Animal;
import edu.ncsu.csc216.packdoption.model.animals.Cat;
import edu.ncsu.csc216.packdoption.model.animals.Dog;
import edu.ncsu.csc216.packdoption.model.rescue.Rescue;
import edu.ncsu.csc216.packdoption.model.rescue.RescueList;
import edu.ncsu.csc216.packdoption.util.ArrayListQueue;
import edu.ncsu.csc216.packdoption.util.Note;
import edu.ncsu.csc216.packdoption.util.SortedLinkedList;

/**
 * Writes the packDoption files
 * 
 * @author Jason Maher
 * @author Sachi Vyas
 *
 */
public class PackDoptionWriter {
	/**
	 * writer constructor
	 */
	public PackDoptionWriter() {
		// new instance
	}

	/**
	 * Returns a comma separated value String of rescue name.
	 * 
	 * @param rescue rescue to be formatted
	 * @return String representation of rescue name
	 */
	private static String formatRescue(Rescue rescue) {
		String toReturn = "";
		toReturn += "# " + rescue.toString() + "\n";
		for (int i = 0; i < rescue.numAnimals(); i++) {
			Animal current = rescue.getAnimal(i);
			toReturn += "* " + formatAnimal(current) + "\n";
		}
		ArrayListQueue<Animal> appts = rescue.getAppointments();
		int origSize = appts.size();
		ArrayListQueue<Animal> temp = new ArrayListQueue<>();
		for (int i = 0; i < origSize; i++) {
			Animal currentAnimal = appts.remove();
			temp.add(currentAnimal);
			toReturn += "- " + currentAnimal.getName() + "," + currentAnimal.getBirthday() + "\n";
		}
		toReturn = toReturn.substring(0, toReturn.length() - 1);
		for (int i = 0; i < origSize; i++) {
			rescue.addAppointment(temp.remove());
		}
		return toReturn;
	}

	/**
	 * Returns the string representation of the name and birthday
	 * 
	 * @param animal animal to be formatted
	 * @return animal string that meets txt file specifications
	 */
	private static String formatAnimal(Animal animal) {
		String toReturn = "";
		Boolean isDog = false;
		if (animal instanceof Dog) {
			toReturn += "Dog";
			isDog = true;
		} else if (animal instanceof Cat) {
			toReturn += "Cat";
		}
		toReturn += "," + animal.getName();
		toReturn += "," + animal.getBirthday().toString();
		toReturn += "," + animal.getSize().toString();
		toReturn += "," + animal.isHouseTrained();
		toReturn += "," + animal.isGoodWithKids();
		toReturn += "," + animal.getDateEnterRescue().toString();
		if (!animal.adopted() && isDog) {
			toReturn += "," + ((Dog) animal).getBreed();
		}
		if (animal.adopted()) {
			toReturn += "," + animal.adopted();
			toReturn += "," + animal.getDateAdopted().toString();
			toReturn += "," + animal.getOwner();
			if (isDog) {
				toReturn += "," + ((Dog) animal).getBreed();
			}
		}
		toReturn += ",NOTES";
		SortedLinkedList<Note> notes = animal.getNotes();
		for (int i = 0; i < notes.size(); i++) {
			toReturn += "," + notes.get(i).toString();
		}
		return toReturn;
	}

	/**
	 * Returns a list which has all the animal information
	 * 
	 * @param filename the file name to write to
	 * @param list     The list of rescues to write to the file
	 * @throws IllegalArgumentException if unable to save files
	 */
	public static void writeRescueFile(String filename, RescueList list) {
		try {
			PrintStream fileWriter = new PrintStream(new File(filename));
			for (int i = 0; i < list.size(); i++) {
				fileWriter.println(formatRescue(list.getRescue(i)));
				if (i != list.size() - 1) {
					fileWriter.println();
				}
			}
		} catch (IOException e) {
			throw new IllegalArgumentException("Unable to save file.");
		}

	}
}