package com.ssayed.examples.structural.bridge.implementation.notification;

public class EtisalatNotificationProvider implements NotificationProvider {

	@Override
	public void sendEmail(String sendTo) {
		System.out.println("|----- Etisalat EMail Provider -------|");
		System.out.println("|-------------------------------------|");

		System.out.println("email has been sent successfully to " + sendTo);
	}

	@Override
	public void sendSMS(String sendTo) {
		System.out.println("|----- Etisalat SMS Provider -------|");
		System.out.println("|-----------------------------------|");

		System.out.println("SMS has been sent successfully to " + sendTo);
	}

}
