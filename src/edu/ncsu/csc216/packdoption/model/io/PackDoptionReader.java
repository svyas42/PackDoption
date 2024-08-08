package edu.ncsu.csc216.packdoption.model.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import edu.ncsu.csc216.packdoption.model.animals.Animal;
import edu.ncsu.csc216.packdoption.model.animals.Cat;
import edu.ncsu.csc216.packdoption.model.animals.Dog;
import edu.ncsu.csc216.packdoption.model.animals.Animal.Size;
import edu.ncsu.csc216.packdoption.model.animals.Dog.Breed;
import edu.ncsu.csc216.packdoption.model.rescue.Rescue;
import edu.ncsu.csc216.packdoption.model.rescue.RescueList;
import edu.ncsu.csc216.packdoption.util.SortedLinkedList;
import edu.ncsu.csc216.packdoption.util.Date;
import edu.ncsu.csc216.packdoption.util.Note;

/**
 * Reads in the packDoption files
 * 
 * 
 * @author Jason Maher
 *
 */
public class PackDoptionReader {

	/**
	 * Constructor for the packDoption reader
	 */
	public PackDoptionReader() {
		// make new instance
	}

	/**
	 * Creates a RescueList of Rescues read from a txt file.
	 * 
	 * @param fileName Name of the txt file being read.
	 * @return RescueList of rescues read from file
	 * @throws IllegalArgumentException if file cannot be located or contains
	 *                                  invalid formatting to construct Rescues.
	 */
	public static RescueList readRescueListFile(String fileName) {
		Scanner fileReader;
		try {
			fileReader = new Scanner(new FileInputStream(fileName));
		} catch (FileNotFoundException e) {
			throw new IllegalArgumentException("Unable to load file.");
		} // Create a file scanner to read the file
		fileReader.useDelimiter("#|\r\n");
		RescueList rescues = new RescueList();
		Rescue rescue = null;
		String rescueName = "";
		String type = "";
		String name = "";
		Date birthday;
		Size size;
		boolean houseTrained = false;
		boolean goodWithKids = false;
		Date dateEnterRescue;
		boolean adopted = false;
		Date dateAdopted = null;
		String owner = "";
		Breed breed;
		String previousLine = "";
		SortedLinkedList<Note> notes = new SortedLinkedList<Note>();
		while (fileReader.hasNextLine()) {
			try {
				String line = fileReader.nextLine();
				if (line.isEmpty()) {
					previousLine = line;
					continue;
				}
				char startsWith = line.charAt(0);
				switch (startsWith) {
				case '#': {
					if (!previousLine.isEmpty()) {
						throw new IllegalArgumentException("Unable to load file.");
					}
					rescueName = line.substring(1);
					// errors handled in rescue constructor
					rescue = new Rescue(rescueName);
					rescues.addRescue(rescue);
					previousLine = line;
					break;
				}
				case '*': {
					List<String> data = Arrays.asList(line.substring(2).split(","));
					type = data.get(0);
					if (!("Dog".equals(type)) && !("Cat".equals(type))) {
						throw new IllegalArgumentException("Unable to load file.");
					}
					name = data.get(1);
					birthday = new Date(data.get(2));
					size = parseSize(data.get(3));
					houseTrained = data.get(4).equals("true");
					goodWithKids = data.get(5).equals("true");
					dateEnterRescue = new Date(data.get(6));
					if ("NOTES".equals(data.get(7))) {
						notes = parseNotes(8, data);
					}
					if ("true".equals(data.get(7))) {
						adopted = true;
						dateAdopted = new Date(data.get(8));
						owner = data.get(9);
					} else {
						adopted = false;
						dateAdopted = null;
						owner = null;
					}
					if ("Cat".equals(type)) {
						if (adopted && data.size() > 11) {
							notes = parseNotes(11, data);
						}
						Cat cat = new Cat(name, birthday, size, houseTrained, goodWithKids, notes, dateEnterRescue,
								adopted, dateAdopted, owner);
						rescue.addAnimal(cat);
					} else if ("Dog".equals(type)) {
						if (adopted && data.size() > 12) {
							notes = parseNotes(12, data);
							breed = parseBreed(data.get(10));
						} else {
							breed = parseBreed(data.get(7));
						}
						Dog dog = new Dog(name, birthday, size, houseTrained, goodWithKids, notes, dateEnterRescue,
								adopted, dateAdopted, owner, breed);
						rescue.addAnimal(dog);
					}
					previousLine = line;
					break;
				}
				case '-': {
					String[] queueData = line.substring(2).split(",");
					String possibleName = queueData[0];
					Date possibleBirthday = new Date(queueData[1]);
					Animal match = rescue.getAnimal(possibleName, possibleBirthday);
					if (match != null) {
						rescue.addAppointment(match);
					} else {
						throw new IllegalArgumentException("Unable to load file.");
					}
					previousLine = line;
					break;
				}
				default:
					throw new IllegalArgumentException("Unable to load file.");
				}
			} catch (Exception e) {
				throw new IllegalArgumentException("Unable to load file.");
			}
		}
		return rescues;
	}

	/*
	 * Helper function to process all notes
	 */
	private static SortedLinkedList<Note> parseNotes(int startIdx, List<String> data) {
		SortedLinkedList<Note> toReturn = new SortedLinkedList<Note>();
		for (int i = startIdx; i <= data.size() - 1; i++) {
			String tempInfo = data.get(i);
			String[] noteData = tempInfo.split(" ", 2);
			Date date = new Date(noteData[0]);
			Note newNote = new Note(date, noteData[1]);
			toReturn.add(newNote);
		}
		return toReturn;
	}

	/**
	 * Returns size enum from a string of animal size.
	 * 
	 * @param sizeString string of animal size to be checked.
	 * @return size if string matches enum values.
	 * @throws IllegalArgumentException if no match is found.
	 */
	private static Size parseSize(String sizeString) {
		switch (sizeString) {
		case "SMALL": {
			return Size.SMALL;
		}
		case "MEDIUM": {
			return Size.MEDIUM;
		}
		case "LARGE": {
			return Size.LARGE;
		}
		default:
			throw new IllegalArgumentException("Unable to load file.");
		}
	}

	/**
	 * Returns Breed enum if string matches an enum type.
	 * 
	 * @param breedString String of breed to be compared to enum.
	 * @return breed if a match to Breed enum is found.
	 * @throws IllegalArgumentException if no match is found
	 */
	private static Breed parseBreed(String breedString) {
		switch (breedString) {
		case "BEAGLE": {
			return Breed.BEAGLE;
		}
		case "BULLDOG": {
			return Breed.BULLDOG;
		}
		case "FRENCH_BULLDOG": {
			return Breed.FRENCH_BULLDOG;
		}
		case "GERMAN_SHEPHERD": {
			return Breed.GERMAN_SHEPHERD;
		}
		case "POINTER_GERMAN_SHORTHAIRED": {
			return Breed.POINTER_GERMAN_SHORTHAIRED;
		}
		case "POODLE": {
			return Breed.POODLE;
		}
		case "RETRIEVER_GOLDEN": {
			return Breed.RETRIEVER_GOLDEN;
		}
		case "RETRIEVER_LABRADOR": {
			return Breed.RETRIEVER_LABRADOR;
		}
		case "ROTTWEILER": {
			return Breed.ROTTWEILER;
		}
		case "YORKSHIRE_TERRIER": {
			return Breed.YORKSHIRE_TERRIER;
		}
		case "MIXED": {
			return Breed.MIXED;
		}
		case "OTHER": {
			return Breed.OTHER;
		}
		default:
			throw new IllegalArgumentException("Unable to load file.");
		}
	}
}