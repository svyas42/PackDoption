package edu.ncsu.csc216.packdoption.util;

/**
 * Gets the notes from present along with the animals
 * @author Sachi Vyas
 */
public class Note implements Comparable<Note> {
	
	/** String that stores the message */
	private String message;
	/** Creating a private date object */
	private Date date;
	
	/**
	 * Constructor for the note class
	 * @param date the date given in the note
	 * @param message the message passed in by the user
	 * @throws IllegalArgumentException if the note is invalid
	 */
	public Note(Date date, String message) {
		String message1 = null;
		if (date == null || message == null || "".equals(message) || message.contains("\n") || 
				message.contains(",") || message.isBlank()) {
			throw new IllegalArgumentException("Invalid note");
		}
		message1 = message.trim();
		this.date = date;
		this.message = message1;
		
	}
	
	/**
	 * Gets the date
	 * @return date the date in the note
	 */
	public Date getDate() {
		return date;
	}
	
	/**
	 * Gets the message from the note
	 * @return message the message in the note
	 */
	public String getMessage() {
		return message;
	}
	
	/**
	 * Notes are compared based on their date and then message
 	 * @param o the note to compare to
	 * @return 0 or 1 or -1 based on if the note is already present in the system
	 */
	@Override
	public int compareTo(Note o) {
		
//		if (date.equals(o.getDate())) {
//			if (message.equals(o.getMessage())) {
//				return 1;
//			}
//			else if (!message.equals(o.getMessage())){
//				return -1;
//			}
//			else {
//				return 0;
//			}
//		}
		
		if (this.date.equals(o.date)) {
			if (this.message.compareTo(o.message) > 0) {
				return 1;
			}
			else if (this.message.compareTo(o.message) < 0) {
				return -1;
			}
			else {
				return 0;
			}
			
				
		}
		return this.date.compareTo(o.getDate());
		
	}
	
	/**
	 * The string to return for the note
	 * @return the string of the note
	 */
	@Override
	public String toString() {
		return date + " " + message;
	}
/**
	 * Generates a hashCode for Note using all fields.
	 * @return result the hashCode for Note
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((message == null) ? 0 : message.hashCode());
		return result;
	}
	
	/**
	 * Checks if the messages are equal
	 * @param obj the object to compare
	 * @return boolean if true if the object is the same or false otherwise
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Note other = (Note) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (message == null) {
			if (other.message != null)
				return false;
		} else if (!message.equals(other.message))
			return false;
		return true;
	}
	
	
	

}
