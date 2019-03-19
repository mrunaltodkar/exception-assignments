package com.capgemini.exception.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.capgemini.exception.exception.CountryNotValidException;
import com.capgemini.exception.exception.TaxNotEligibleException;
import com.capgemini.exception.main.EmployeeNameInvalidException;
import com.capgemini.exception.main.TaxCalculator;

public class TaxCalculatorTest {

	TaxCalculator employee;

	@Test
	public void testEmployeeIsIndian() {
		try {
			employee = new TaxCalculator("Mrunal", true, 50_000);
		} catch (Exception e) {
			System.out.println("as");
		}
	}

	@Test(expected = CountryNotValidException.class)
	public void testEmployeeNotIndian()
			throws CountryNotValidException, EmployeeNameInvalidException, TaxNotEligibleException {
		employee = new TaxCalculator("Mrunal", false, 50_000);
	}

	@Test
	public void testEmployeeValidName() {
		try {
			employee = new TaxCalculator("Mrunal", true, 50_000);
		} catch (Exception e) {
			System.out.println("as");
		}
	}

	@Test(expected = EmployeeNameInvalidException.class)
	public void testEmployeeInvalidName()
			throws CountryNotValidException, EmployeeNameInvalidException, TaxNotEligibleException {
		employee = new TaxCalculator("Mrun235", true, 50_000);
	}

	@Test
	public void testForTaxCalculationAboveOneLakh()
			throws CountryNotValidException, EmployeeNameInvalidException, TaxNotEligibleException {
		TaxCalculator employee1 = new TaxCalculator("Mrunal", true, 190_000);
		assertEquals(15200, employee1.taxCalculator(employee1.getEmployeeSalary()), 0.1);
	}

	@Test
	public void testForTaxCalculationBelowOneLakhAbove50k()
			throws CountryNotValidException, EmployeeNameInvalidException, TaxNotEligibleException {
		TaxCalculator employee1 = new TaxCalculator("Mrunal", true, 90_000);
		assertEquals(5400, employee1.taxCalculator(employee1.getEmployeeSalary()), 0.1);
	}

	@Test
	public void testForTaxCalculation30kTo50k()
			throws CountryNotValidException, EmployeeNameInvalidException, TaxNotEligibleException {
		TaxCalculator employee1 = new TaxCalculator("Mrunal", true, 40_000);
		assertEquals(2000, employee1.taxCalculator(employee1.getEmployeeSalary()), 0.1);
	}

	@Test
	public void testForTaxCalculation10kTo30k()
			throws CountryNotValidException, EmployeeNameInvalidException, TaxNotEligibleException {
		TaxCalculator employee1 = new TaxCalculator("Mrunal", true, 20_000);
		assertEquals(800, employee1.taxCalculator(employee1.getEmployeeSalary()), 0.1);
	}

	@Test(expected = CountryNotValidException.class)
	public void testForTaxCalculationNotIndian()
			throws CountryNotValidException, EmployeeNameInvalidException, TaxNotEligibleException {
		employee = new TaxCalculator("Alex", false, 34_000);
	}

	@Test(expected = TaxNotEligibleException.class)
	public void testForTaxCalculationBelow10k()
			throws CountryNotValidException, EmployeeNameInvalidException, TaxNotEligibleException {
		TaxCalculator employee1 = new TaxCalculator("Taylor", true, 10_000);
		employee1.taxCalculator(employee1.getEmployeeSalary());
	}

}