package com.acme.utils;

public class HolidayOrdersNotAllowedException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -720588633216405066L;

	public HolidayOrdersNotAllowedException(MyDate date) {
		super("Orders are not allowed to be created on: " + date);
	}
}
