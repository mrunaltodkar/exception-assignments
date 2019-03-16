package com.capgemini.exception.main;

import com.capgemini.exception.exception.FactorialException;
import com.capgemini.exception.exception.InvalidInputException;

public class Factorial {

	public long getFactorial(int number) throws FactorialException, InvalidInputException {

		long result = 1;

		if (number < 2)
			throw new InvalidInputException("Number is less than 2!!");
		else {
			for (int input = number; input >= 1; input--) {
				result = result * input;

				if (result > Integer.MAX_VALUE) {
					throw new FactorialException("Integer limit exceeded!!");
				}

			}

		}
		return result;
	}

}
