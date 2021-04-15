package com.acme.utils;

public class InvalidDateException extends Exception {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8214182325276377566L;

	public InvalidDateException(int day, int month, int year){
		super("Month " + month + " Day " + day + " and year " + year + " doesn't create a valid date");
	}
}
