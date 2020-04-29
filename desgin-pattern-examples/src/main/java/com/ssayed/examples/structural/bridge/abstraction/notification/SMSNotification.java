package com.ssayed.examples.structural.bridge.abstraction.notification;

import com.ssayed.examples.structural.bridge.implementation.notification.NotificationProvider;

public class SMSNotification implements Notification {

	private NotificationProvider notificationProvider;

	public SMSNotification(NotificationProvider notificationProvider) {
		this.notificationProvider = notificationProvider;
	}

	@Override
	public void send(String sendTo) {
		notificationProvider.sendSMS(sendTo);
	}
}