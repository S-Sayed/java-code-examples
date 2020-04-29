package com.ssayed.examples.structural.bridge.implementation.notification;

public interface NotificationProvider {
	void sendEmail(String sendTo);

	void sendSMS(String sendTo);
}
