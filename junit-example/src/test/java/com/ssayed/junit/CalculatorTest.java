package com.ssayed.junit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.ssayed.junit.Calculator;

public class CalculatorTest {

	static Calculator calculator;

	@BeforeClass
	public static void setup() {
		System.out.println("Handle expensive setup once before executing the first test case in the class");
	}

	@Before
	public void beforeEachTestCase() {
		System.out.println("Before each test case");
		calculator = new Calculator();
	}

	@After
	public void afterEachTestCase() {
		System.out.println("After each test case");
		calculator = null;
	}

	@Test // mark this method as test case
	public void testAdd() {
		assertEquals(3, calculator.add(1, 2));
		assertEquals(16, calculator.add(11, 5));
		assertEquals(-7, calculator.add(-5, -2));
		assertEquals(-5, calculator.add(1, -6));
		assertEquals(5, calculator.add(-1, 6));
	}

	@Test
	public void testDivide() {
		assertEquals(1 / 2, calculator.divide(1, 2));
		assertEquals(1, calculator.divide(2, 2));
		assertEquals(3, calculator.divide(9, 3));
	}

	@Test(expected = IllegalArgumentException.class) 
	// if no expected exception is mentioned, the test case will fail
	public void testDivideIfSecondNumberIsZero() {
		assertEquals(3, calculator.divide(9, 0));
	}

	
	@Test
	@Ignore 
	// ignore this test case, you can use it with class level to ignore, all the test cases in that class
	public void testSubtract() {
		boolean expected = true;
		assertTrue(expected);
	}
	
}
