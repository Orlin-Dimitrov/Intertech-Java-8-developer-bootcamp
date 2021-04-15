package com.acme.utils;

public class MyDate {

	private byte day;
	private byte month;
	private short year;
	private static MyDate[] holidays;

	{
		day = 1;
		month = 1;
		year = 2000;
	}

	static {
		holidays = new MyDate[6];
		holidays[0] = new MyDate(1, 1, 2016);
		holidays[1] = new MyDate(5, 30, 2016);
		holidays[2] = new MyDate(7, 4, 2016);
		holidays[3] = new MyDate(9, 5, 2016);
		holidays[4] = new MyDate(11, 24, 2016);
		holidays[5] = new MyDate(12, 25, 2016);
	}

	public MyDate() {
		this(1, 1, 1900);
	}

	public MyDate(int m, int d, int y) {
		setDate(m, d, y);
	}

	public String toString() {

		return month + "/" + day + "/" + year;
	}

	public void setDate(int m, int d, int y) {
//		if (valid(d, m, y)) {
//			month = (byte) m;
//			day = (byte) d;
//			year = (short) y;
//		}
		try{
			valid(d, m, y);
		} catch (InvalidDateException e){
			System.out.println(e.getMessage());
			System.exit(0);
		}
		month = (byte) m;
		day = (byte) d;
		year = (short) y;
	}

	// calculate leap years
	// Of those years, if it can be divided by 100, it is NOT a leap year,
	// unless the year is divisible by 400. Then it is a leap year
	public static void leapYears() {
		for (int i = 1752; i <= 2020; i = i + 4) {
			if ((i % 100 != 0) || (i % 400 == 0)) {
				System.out.println("The year " + i + " is a leap year");
			}
		}
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		
		try{
			valid(day, month, year);
		} catch (InvalidDateException e){
			System.out.println(e.getMessage());
			System.exit(0);
		}
		this.day = (byte) day;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		
		try{
			valid(day, month, year);
		} catch (InvalidDateException e){
			System.out.println(e.getMessage());
			System.exit(0);
		}
		this.month = (byte) month;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
//		if (valid(day, month, year)) {
//			this.year = (short) year;
//		}
		try{
			valid(day, month, year);
		} catch (InvalidDateException e){
			System.out.println(e.getMessage());
			System.exit(0);
		}
		this.year = (short) year;
	}

//	private boolean valid(int day, int month, int year) {
//		if (day > 31 || day < 1 || month > 12 || month < 1) {
//			System.out.println("Attempting to create a non-valid date " + month + "/" + day + "/" + year);
//			return false;
//		}
//		switch (month) {
//		case 4:
//		case 6:
//		case 9:
//		case 11:
//			return (day <= 30);
//		case 2:
//			return day <= 28 || (day == 29 && year % 4 == 0);
//		}
//		return true;
//	}

	private void valid(int day, int month, int year) throws InvalidDateException{
		
		boolean valid = true;
		
		if (day > 31 || day < 1 || month > 12 || month < 1) {
			System.out.println("Attempting to create a non-valid date " + month + "/" + day + "/" + year);
			valid = false;
		}
		switch (month) {
		case 4:
		case 6:
		case 9:
		case 11:
			if (day <= 30){valid=true;};
		case 2:
			if (day <= 28 || (day == 29 && year % 4 == 0)){valid=true;};
		}
		
		if(!valid) throw new InvalidDateException(day, month, year);
	}
	
	public boolean equals(Object o) {
		if (o instanceof MyDate) {
			MyDate d = (MyDate) o;
			if ((d.day == day) && (d.month == month) && (d.year == year)) {
				return true;
			}
		}
		return false;
	}

	public static MyDate[] getHolidays() {
		return holidays;
	}

	public static void listHolidays() {
		System.out.println("the holidays are:");
		for (int x = 0; x < holidays.length; x++) {
			System.out.println(holidays[x]);
		}
	}
}
