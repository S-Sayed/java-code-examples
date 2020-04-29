package com.ssayed.examples.creational.factoryPattern;

public class FactoryPatternClient {

	public static void main(String[] args) {
		NotificationSenderFactoryApproach1.getInstance("EMAIL").send("ssayed7190@gmail.com",
				"Welcome to Design Patterns");
		NotificationSenderFactoryApproach1.getInstance("SMS").send("00971506630580", "Welcome to Design Patterns");
		System.out.println("---------------Without Sending the type from the client side ------------");
		NotificationSenderFactoryApproach2.getEmailSender().send("ssayed7190@gmail.com", "Welcome to Design Patterns");
		NotificationSenderFactoryApproach2.getSMSSender().send("00971506630580", "Welcome to Design Patterns");
	}
}
