package com.ssayed.examples.creational.factoryPattern;

public interface NotificationSender {
	boolean send(String sendTo, String messageTxt);
}

class EmailSender implements NotificationSender {

	public boolean send(String sendTo, String messageTxt) {
		System.out.println("Email-Message <" + messageTxt + "> has been sent successfully to " + sendTo);
		return true;
	}
}

class SMSSender implements NotificationSender {

	public boolean send(String sendTo, String messageTxt) {
		System.out.println("SMS-Message <" + messageTxt + "> has been sent successfully to " + sendTo);
		return true;
	}
}
