package edu.ncsu.csc216.packdoption.model.manager;

import edu.ncsu.csc216.packdoption.model.io.PackDoptionReader;
import edu.ncsu.csc216.packdoption.model.io.PackDoptionWriter;
import edu.ncsu.csc216.packdoption.model.rescue.RescueList;

/**
 * Manager the information in the table, loads, and saves file
 * @author Sachi Vyas
 *
 */
public class PackDoptionManager {
	/** Name of the file to read from */
	private String filename;
	/** Checking if anything has changed in the pet information */
	private boolean changed;
	/** Getting the rescue list */
	private RescueList rescues;
	/** Creating a singleton instance of PackDoptionManager */
	private static PackDoptionManager singleton;
	
	/**
	 * Getting an instance of the packDoption manager class
	 * @return singleton a single instance of PackDoptionManager
	 */
	public static PackDoptionManager getInstance() {
		if (singleton == null) {
			singleton = new PackDoptionManager();
		}
		
		return singleton;
	}
	
	/**
	 * Constructs a new rescue list
	 */
	public void newList() {
		rescues = new RescueList();
		
	}
	
	/**
	 * Checks if the rescue has been changed from the last save
	 * @return boolean true if it has been changed and false otherwise
	 */
	public boolean isChanged() {
		return changed;
	}
	
	/**
	 * Gets the filename to read from
	 * @return filename the filename to read in
	 */
	public String getFilename() {
		return filename;
	}
	
	/**
	 * Sets the change made to the information
	 * @param changed a boolean which is true if there are changes made or false otherwise
	 */
	public void setChanged(boolean changed) {
		this.changed = changed;
	}
	
	/**
	 * Checks if the filename has any leading and/or trailing whitespace and removes them
	 * @param filename the filename to read in from
	 * @throws IllegalArgumentExpcetion if the filename is null or is a whitespace
	 */
	public void setFilename(String filename) {
		String filename1 = null;
		if (filename == null && " ".equals(filename)) {
			throw new IllegalArgumentException();
		}
		else if (!(filename == null)){
			filename1 = filename.trim();
			this.filename = filename1;
		}
		
		
	}
	
	/**
	 * Loading the rescues from a file and uploading them to the system
	 * @param filename the name of the file from which the rescue records are supposed to be loaded from
	 */
	public void loadFile(String filename) {
		newList();
		this.setFilename(filename);
		rescues = PackDoptionReader.readRescueListFile(filename);
		this.changed = false;
	}
	
	/**
	 * Writes the rescuelist to the file and sets changed to false
	 * @param filename the name of the file to write
	 */
	public void saveFile(String filename) {
		PackDoptionWriter.writeRescueFile(filename, rescues);
		this.changed = false;
	}
	
	/**
	 * Returns a list containing all the rescues
	 * @return rescues the rescue list
	 */
	public RescueList getRescueList() {
		return rescues;
	}
	
	
}
