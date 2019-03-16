package com.capgemini.exception.main;

import com.capgemini.exception.exception.AgeNotWithinRangeException;
import com.capgemini.exception.exception.NameNotValidException;

public class Student {
	
	private int rollNo;
	private String studentName;
	private int studentAge;
	private String course;
	
	public Student() {
		super();
	
	}
	public Student(int rollNo, String studentName, int studentAge, String course) throws AgeNotWithinRangeException, NameNotValidException {
		super();
		this.rollNo = rollNo;
		if(studentName.matches("^[a-zA-Z\\s]*$")) {
			this.studentName = studentName;		
		}
		else
			throw new NameNotValidException("Enter correct inputs!!");
		
		if(studentAge<15 | studentAge>21)
			throw new AgeNotWithinRangeException("Your age is not within range!!!");
		else
			this.studentAge = studentAge;
		this.course = course;
	}
	public int getRollNo() {
		return rollNo;
	}
	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public int getStudentAge() {
		return studentAge;
	}
	public void setStudentAge(int studentAge) {
		this.studentAge = studentAge;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	
}
