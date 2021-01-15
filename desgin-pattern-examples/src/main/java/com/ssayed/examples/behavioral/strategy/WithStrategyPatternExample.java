package com.ssayed.examples.behavioral.strategy;

import java.util.Scanner;

public class WithStrategyPatternExample {

	public static void main(String[] args) {
		double amount = 100.0;
		new WithStrategyPatternExample().pay(amount);
	}

	private void pay(double amount) {
		Scanner scanner = null;
		try {
			scanner = new Scanner(System.in);
			System.out.println("Enter Payment Method\n 1: Credit Card \n 2: PayPal");
			int paymentMethod = scanner.nextInt();

			PaymentContext paymentContext = new PaymentContext();

			if (paymentMethod == 1) {
				paymentContext.setPaymentStrategy(new PayByCreditCard());
			} else if (paymentMethod == 2) {
				paymentContext.setPaymentStrategy(new PayByPayPal());
			}

			paymentContext.pay(amount);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (scanner != null)
				scanner.close();
		}
	}
}
