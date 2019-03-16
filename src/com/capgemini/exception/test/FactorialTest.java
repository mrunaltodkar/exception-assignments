package com.capgemini.exception.test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.capgemini.exception.exception.FactorialException;
import com.capgemini.exception.exception.InvalidInputException;
import com.capgemini.exception.main.Factorial;

public class FactorialTest {

	Factorial factorial;

	@Before
	public void setUp() {
		factorial = new Factorial();
	}

	@Test(expected = InvalidInputException.class)
	public void testFactorialNumberLessThanIntegerTwo() throws InvalidInputException, FactorialException {
		factorial.getFactorial(1);
	}

	@Test(expected = FactorialException.class)
	public void testForFactorialIntegerLimitExceeds() throws InvalidInputException, FactorialException {
		factorial.getFactorial(999999999);
	}

	@Test
	public void testForFactorialOfNumberWithValidAnswer() throws InvalidInputException, FactorialException {
		assertEquals(120, factorial.getFactorial(5));
	}
}
