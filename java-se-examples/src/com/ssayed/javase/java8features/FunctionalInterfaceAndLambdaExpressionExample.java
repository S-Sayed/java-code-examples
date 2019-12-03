package com.ssayed.javase.java8features;

public class FunctionalInterfaceAndLambdaExpressionExample {

	public static void main(String[] args) {
		testFunctionalInterfaceUsingAnonymousClass();
		testFunctionalInterfaceUsingLambdaExpression();
	}

	private static void testFunctionalInterfaceUsingLambdaExpression() {
		InterfaceImpl i = (msg) -> System.out.println("Using Lambda Expression: " + msg);
		i.print("Hello");
	}

	private static void testFunctionalInterfaceUsingAnonymousClass() {
		InterfaceImpl i = new InterfaceImpl() {
			@Override
			public void print(String msg) {
				System.out.println("Using anonymous class: " + msg);
			}
		};

		i.print("Hello");

	}
}

// no need to add the below annotation if the interface has only one abstract
// method
@FunctionalInterface
interface InterfaceImpl {
	void print(String msg);
}
