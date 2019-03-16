package com.capgemini.exception.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.capgemini.exception.exception.AgeNotWithinRangeException;
import com.capgemini.exception.exception.NameNotValidException;
import com.capgemini.exception.main.Student;

public class StudentTest {

	Student student;
	
	@Test
	public void testForAgeIsWithinRange() throws AgeNotWithinRangeException, NameNotValidException {
		student = new Student(101, "Mrunal Todkar", 16, "Comuter Engineering");
		assertEquals(16, student.getStudentAge());
	}
	
	@Test(expected=AgeNotWithinRangeException.class)
	public void testForAgeIsNotWithinRange() throws AgeNotWithinRangeException, NameNotValidException {
		student = new Student(101, "Mrunal", 10, "cse");
	}
	
	@Test
	public void testForValidInputsForName() throws AgeNotWithinRangeException, NameNotValidException{
		student = new Student (101, "Mrunal Todkar", 20, "Computer Science");
		assertEquals("Mrunal Todkar", student.getStudentName());
	}
	
	
	@Test(expected=NameNotValidException.class)
	public void testForDigitalAndSpecialSymbolNameInputs() throws AgeNotWithinRangeException, NameNotValidException {
		student = new Student(101, "Mrunal123", 20, "cse");
	}
}
