package edu.ncsu.csc216.packdoption.util;
/**
 *  Defines the NoSuchElementException exception and contains two constructors parameterized 
 *  and void
 * @author Sachi Vyas
 */
public class NoSuchListElementException extends RuntimeException {
	/** ID used for serialization. */
	private static final long serialVersionUID = 1L;
		
	/**
	 * The default message to put in if the conflict exception is thrown
	 */
	public NoSuchListElementException() {
		this("No such element in list.");
	}
	
	/**
	 * NoSuchElementException object constructed with message passed as a string parameter in the parent class 
	 * using super()
	 * @param string the error message
	 */
	 public NoSuchListElementException(String string) {
		super(string);
	}

}



