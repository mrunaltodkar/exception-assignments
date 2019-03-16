package com.capgemini.exception.main;

import com.capgemini.exception.exception.InValidDayException;
import com.capgemini.exception.exception.InValidMonthException;

public class MyDate {

	private int day;
	private int month;
	private int year;
	public static final int[] array = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

	public MyDate() {
		super();
	}

	public MyDate(int day, int month, int year) throws InValidDayException, InValidMonthException {
		super();

		setYear(year);

		if (month >= 1 && month <= 12) {
			this.month = month;
		} else
			throw new InValidMonthException("Your entered month is not valid!!");

		if (day <= array[month - 1] && day >= 1) {
			this.day = day;
		} else
			throw new InValidDayException("Your entered day value is not valid!!");

	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) throws InValidMonthException {
		this.month = month;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		boolean flag = false;

		if (year % 400 == 0)
			flag = true;

		if (year % 100 == 0)
			flag = false;

		if (year % 4 == 0)
			flag = true;

		if (flag == true)
			array[1] = 29;

		this.year = year;
	}

}
