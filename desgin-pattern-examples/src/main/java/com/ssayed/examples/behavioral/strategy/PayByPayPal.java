package com.ssayed.examples.behavioral.strategy;

import java.util.Scanner;

// concrete strategy implementation
public class PayByPayPal implements PaymentStrategy {
	@Override
	public boolean pay(double amount) {
		Scanner scanner = null;
		try {
			scanner = new Scanner(System.in);
			System.out.println("Enter your PayPal email");
			String email = scanner.nextLine();
			System.out.println("Enter your PayPal password");
			String password = scanner.nextLine();

			System.out.println("Paying With PayPal ...");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (scanner != null)
				scanner.close();
		}

		return true;
	}
}
