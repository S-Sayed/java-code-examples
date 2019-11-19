package com.ssayed.junit;

public class Calculator {

	public int add(int number1, int number2) {
		return number1 + number2;
	}

	public int divide(int number1, int number2) {
		if (number2 == 0) {
			throw new IllegalArgumentException("number 2 should be > 0");
		}

		return number1 / number2;
	}
}
