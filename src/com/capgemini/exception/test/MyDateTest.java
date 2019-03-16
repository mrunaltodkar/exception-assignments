package com.capgemini.exception.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.capgemini.exception.exception.InValidDayException;
import com.capgemini.exception.exception.InValidMonthException;
import com.capgemini.exception.main.MyDate;

public class MyDateTest {

	MyDate date;
	
	@Test
	public void testForValidDayInputs() throws InValidDayException, InValidMonthException {
		MyDate date = new MyDate(29, 2, 2016);
		assertEquals(29, date.getDay());
	}

	@Test(expected = InValidDayException.class)
	public void testForInvalidDayInputs() throws InValidDayException, InValidMonthException {
		new MyDate(35, 12, 2018);
	}
	
	@Test
	public void testForValidMonthInputs() throws InValidDayException, InValidMonthException {
		MyDate date = new MyDate(12, 1, 2016);
		assertEquals(1, date.getMonth());
	}

	@Test(expected = InValidMonthException.class)
	public void testForInValidMonthInputs() throws InValidDayException, InValidMonthException {
		new MyDate(2, 20, 2019);
	}
}
