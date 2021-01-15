package com.ssayed.examples.behavioral.strategy;

import java.io.IOException;
import java.util.Scanner;

public class WithoutStrategyPatternExample {

	public static void main(String[] args) {
		double amount = 100.0;
		new WithoutStrategyPatternExample().pay(amount);
	}

	private void pay(double amount) {
		Scanner scanner = null;
		try {
			scanner = new Scanner(System.in);
			System.out.println("Enter Payment Method\n 1: Credit Card \n 2: PayPal");
			int paymentMethod = scanner.nextInt();

			if (paymentMethod == 1) {
				payByCreditCard(amount);
			} else if (paymentMethod == 2) {
				payByPayPal(amount);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (scanner != null)
				scanner.close();
		}
	}

	private void payByPayPal(double amount) throws IOException {
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
	}

	private void payByCreditCard(double amount) throws IOException {
		Scanner scanner = null;
		try {
			scanner = new Scanner(System.in);
			System.out.println("Enter CC Number");
			String ccNumber = scanner.nextLine();
			System.out.println("Enter Expiry Date in MM/YY");
			String expirydate = scanner.nextLine();
			System.out.println("Enter Holder Name");
			String holderName = scanner.nextLine();
			System.out.println("Enter CVV");
			int cvv = scanner.nextInt();

			System.out.println("Connecting to Bank ...");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (scanner != null)
				scanner.close();
		}
	}

}
