package com.ssayed.examples.creational.factoryPattern;

public class NotificationSenderFactoryApproach1 {

	public static NotificationSender getInstance(String type) {
		switch (type) {
		case "EMAIL":
			return new EmailSender();
		case "SMS":
			return new SMSSender();
		}
		return null;
	}
}

class NotificationSenderFactoryApproach2 {
	static NotificationSender getEmailSender() {
		return new EmailSender();
	}

	static NotificationSender getSMSSender() {
		return new SMSSender();
	}
}