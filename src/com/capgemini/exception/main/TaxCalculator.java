package com.capgemini.exception.main;

import java.util.regex.Pattern;

import com.capgemini.exception.exception.CountryNotValidException;
import com.capgemini.exception.exception.TaxNotEligibleException;

public class TaxCalculator {

	private String employeeName;
	private boolean isIndian;
	private double employeeSalary;

	public TaxCalculator() {
		super();
		
	}

	public TaxCalculator(String employeeName, boolean isIndian, double employeeSalary)
			throws CountryNotValidException, EmployeeNameInvalidException, TaxNotEligibleException {
		super();
		if (Pattern.matches("[a-zA-Z]+", employeeName))
			this.employeeName = employeeName;
		else
			throw new EmployeeNameInvalidException("invalid name");
		if (isIndian)
			this.isIndian = isIndian;
		else
			throw new CountryNotValidException("invalid country");
		this.employeeSalary = employeeSalary;
	}

	public double taxCalculator(double sal) throws TaxNotEligibleException,CountryNotValidException, EmployeeNameInvalidException{
		if (sal > 100000 && isIndian == true) {
			return ((sal * 8) / 100);
		} else if (sal > 50000 && sal < 100000 && isIndian == true) {
			return ((sal * 6) / 100);
		} else if (sal > 30000 && sal < 50000 && isIndian == true) {
			return ((sal * 5) / 100);
		} else if (sal > 10001 && sal < 30000 && isIndian == true) {
			return ((sal * 4) / 100);
		} else
			System.out.println("error");
			throw new TaxNotEligibleException("Not applicable for tax");
	}

	public boolean isIndian() {
		return isIndian;
	}

	public void setIndian(boolean isIndian) {
		this.isIndian = isIndian;
	}

	public double getEmployeeSalary() {
		return employeeSalary;
	}

	public void setEmployeeSalary(double employeeSalary) {
		this.employeeSalary = employeeSalary;
	}

}
