package com.capgemini.exception.main;

import com.capgemini.exception.exception.CountryNotValidException;

public class TaxCalculator {
	private String employeeName;
	private double employeeSalary;
	private boolean employeeIsIndian;
	
	public TaxCalculator() {
		super();
		
	}

	public TaxCalculator(String employeeName, double employeeSalary, boolean employeeIsIndian) {
		super();
		this.employeeName = employeeName;
		this.employeeSalary = employeeSalary;
		this.employeeIsIndian = employeeIsIndian;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public double getEmployeeSalary() {
		return employeeSalary;
	}

	public void setEmployeeSalary(double employeeSalary) {
		this.employeeSalary = employeeSalary;
	}

	public boolean isEmployeeIsIndian() {
		return employeeIsIndian;
	}

	public void setEmployeeIsIndian(boolean employeeIsIndian) {
		this.employeeIsIndian = employeeIsIndian;
	}
	
	public double calculateTax() throws CountryNotValidException {
		
		double taxAmount = 0;
		
		if(!employeeIsIndian) {
			throw new CountryNotValidException("Entered Country is not valid!!!");
		}
		
		return taxAmount;
	}
	
	
}
