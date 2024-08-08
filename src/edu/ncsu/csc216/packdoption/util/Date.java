package edu.ncsu.csc216.packdoption.util;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Checks if the dates are valid in string and integer format
 * 
 * @author Sachi Vyas
 * @author Jason Maher
 *
 */
public class Date implements Comparable<Date> {
	/** Variable to store the month */
	private int month;
	/** Variable to store the day */
	private int day;
	/** Variable to store the year */
	private int year;

	/**
	 * Constructor for the date class
	 * 
	 * @param month the variable that represents the month in the date
	 * @param day   the variable that represents the day in the date
	 * @param year  the variable that represents the year in the date
	 * @throws IllegalArgumentException if the month in the date is invalid
	 * @throws IllegalArgumentException if the day in the date is invalid
	 */
	public Date(int month, int day, int year) {

		if (!isValidDate(month, day, year)) {
			throw new IllegalArgumentException("Invalid date");
		}
		this.month = month;
		this.day = day;
		this.year = year;
	}

	/**
	 * Constructor for the date class with string input
	 * 
	 * @param date the date in the string form
	 * @throws IllegalArgumentException if the month in the date is invalid
	 * @throws IllegalArgumentException if the day in the date is invalid
	 */
	public Date(String date) {
		if (date == null || date.isBlank()) {
			throw new IllegalArgumentException("Invalid date");
		}
		Scanner scan = new Scanner(date);
		String dateString = scan.nextLine();
		if (!dateString.contains("/") || dateString.length() < 8 || dateString.length() > 10) {
			scan.close();
			throw new IllegalArgumentException("Invalid date");
		}
		List<String> data = Arrays.asList(dateString.split("/"));
		int month1;
		int day1;
		int year1;
		try {
			month1 = Integer.parseInt(data.get(0));
			day1 = Integer.parseInt(data.get(1));
			year1 = Integer.parseInt(data.get(2));
		}
		catch (Exception e) {
			scan.close();
			throw new IllegalArgumentException("Invalid date");
		}
		scan.close();
		int[] monthDays = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		if ((year1 > 2000 || year1 < 2050) && year1 % 4 == 0) {
			monthDays[1] = monthDays[1] + 1;
		}
		if (month1 > 12 || month1 < 1) {
			throw new IllegalArgumentException("Invalid date");
		} else if (year1 < 2000 || year1 > 2050) {
			throw new IllegalArgumentException("Invalid date");
		} else if (day1 < 1 || day1 > monthDays[month1 - 1]) {
			throw new IllegalArgumentException("Invalid date");
		}
		this.month = month1;
		this.day = day1;
		this.year = year1;
	}

	/**
	 * Returns the month value from the date
	 * 
	 * @return month The integer that represents the date's month value.
	 */
	public int getMonth() {
		return month;
	}

	/**
	 * Returns the day from the date
	 * 
	 * @return day the number that represents the day in the date
	 */
	public int getDay() {
		return day;
	}

	/**
	 * Returns the year from the date
	 * 
	 * @return year the number that represents the year in the date
	 */
	public int getYear() {
		return year;
	}

	/**
	 * Checks if the String form a valid date
	 * 
	 * @param date the birthday, adoption date, or rescue date of the animal
	 * @return boolean true if the date is valid or invalid otherwise
	 */
	public static boolean isValidDate(String date) {
		try {
		Scanner scan = new Scanner(date);
		String dateString = scan.nextLine();
		if (!dateString.contains("/") || dateString.length() < 8 || dateString.length() > 10) {
			scan.close();
//			throw new IllegalArgumentException("Invalid date");
			return false;
		}
		List<String> data = Arrays.asList(dateString.split("/"));
		int month1 = Integer.parseInt(data.get(0));
		int day1 = Integer.parseInt(data.get(1));
		int year1 = Integer.parseInt(data.get(2));
		scan.close();
		int[] monthDays = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		if ((year1 > 2000 || year1 < 2050) && year1 % 4 == 0) {
			monthDays[1] = monthDays[1] + 1;
		}
		if (month1 > 12 || month1 < 1) {
			return false;
		} else if (year1 < 2000 || year1 > 2050) {
			return false;
		} else if (day1 < 1 || day1 > monthDays[month1 - 1]) {
			return false;
		}
		return true;
		} catch (NumberFormatException e) {
			return false;
		}
		
	}

	/**
	 * Checks if the 3 input numbers (month, day, year) form a valid date
	 * 
	 * @param month the number that represents the month in the date
	 * @param day   the number that represents the day in the date
	 * @param year  the number that represents the year in the date
	 * @return boolean true if the date is valid or invalid otherwise
	 */
	public static boolean isValidDate(int month, int day, int year) {
		int[] monthDays = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		if ((year > 2000 || year < 2050) && year % 4 == 0) {
			monthDays[1] = monthDays[1] + 1;
		}
		if (month > 12 || month <= 0) {
			return false;
		} else if (year < 2000 || year > 2050) {
			return false;
		} else if (day <= 0 || day > monthDays[month - 1]) {
			return false;
		}
		return true;
	}

	/**
	 * Compares dates based on year, month, and day
	 * 
	 * @param other the object to compare to
	 * @return date if the date is valid is not repeated and can be ordered
	 */
	public int compareTo(Date other) {

		if (this.year < other.getYear()) {
			return -1;
		} else if (this.year > other.getYear()) {
			return 1;
		}
		// same year
		if (this.month < other.getMonth()) {
			return -1;
		} else if (this.month > other.getMonth()) {
			return 1;
		}
		// same month
		if (this.day < other.getDay()) {
			return -1;
		} else if (this.day > other.getDay()) {
			return 1;
		}
		// everything equivalent
		return 0;

	}

	/**
	 * Generates the date in the string form
	 */
	@Override
	public String toString() {
		return month + "/" + day + "/" + year;
	}

	/**
	 * Generates a hashCode for date using the day, month, and year.
	 * 
	 * @return hashCode for date
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + day;
		result = prime * result + month;
		result = prime * result + year;
		return result;
	}

	/**
	 * Compares a given object to this object for equality on day, month, and year
	 * fields.
	 * 
	 * @param obj the Object to compare
	 * @return true if the objects are the same on day, month, and year fields.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Date other = (Date) obj;
		if (day != other.day)
			return false;
		if (month != other.month)
			return false;
//		if (year != other.year)
//			return false;
		return year == other.year;
	}

	/**
	 * Returns the number of days between this date and other date (Date o in the
	 * compare to method)
	 * 
	 * @param other the date object passed in as a integer
	 * @return count the number of days between this date and other date
	 */	
	public int daysTo(Date other) {	
		
		int count = 0;

		if (other.getYear() < this.year || other.getYear() == this.year && other.getMonth() < this.month
				|| other.getMonth() == this.month && other.getYear() == this.year && other.getDay() < this.day) {
			// other date before this date
		
			return -other.daysTo(this);
		}
		Date newDate = new Date(month, day, year);
		while (!newDate.equals(other)) {
			newDate.nextDay();
			count++;

		}
		return count;
	}

	/**
	 * Private helper method to help the daysTo() method to get the days between 2
	 * dates
	 */
	private void nextDay() {
		int[] monthDays = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		if (year % 4 == 0) {
			monthDays[1] = monthDays[1] + 1;
		}
		day++;
		if (day > monthDays[month - 1]) {
			day = 1;
			month++;
		}
		if (month > 12) {
			year++;
			month = 1;
		}		

	}

	/**
	 * Returns the number of years between the current date and the other year (Date
	 * o in the compare to method)
	 * 
	 * @param other the date object passed in as a integer
	 * @return diff the number of years between this date and other date
	 */
	public int yearsTo(Date other) {
		
//		 july 13 2023-> jul 13 2013, july 13 2013 -> Aug 13 2023, july 13 2013->june13
//		 2023

		if (this.year > other.getYear() || month == other.getMonth() && year == other.getYear() && other.getDay() < day
				|| year == other.getYear() && month > other.getMonth()) {

			return -other.yearsTo(this);
		}

		// other=2019, this=2018
		else {
			int diff = other.getYear() - this.year;
			if (month == other.getMonth() && day == other.getDay()) {
				return diff;
			}
			if (month == other.getMonth() && day > other.getDay()) {
				return --diff;
			}
			 //july 7 2023 -> aug 3 2024
			else if (month > other.getMonth()) {
				return --diff;
			}
			return diff;
		}
	}

		
}