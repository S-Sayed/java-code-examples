package com.ssayed.examples.behavioral.strategy;

import java.util.Scanner;

//concrete strategy implementation
public class PayByCreditCard implements PaymentStrategy {

	@Override
	public boolean pay(double amount) {
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

		return true;
	}
}
