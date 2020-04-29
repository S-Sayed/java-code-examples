package com.ssayed.examples.structural.bridge.abstraction.notification;

import com.ssayed.examples.structural.bridge.implementation.notification.NotificationProvider;

public class EmailNotification implements Notification {

	private NotificationProvider notificationProvider;

	public EmailNotification(NotificationProvider notificationProvider) {
		this.notificationProvider = notificationProvider;
	}

	@Override
	public void send(String sendTo) {
		notificationProvider.sendEmail(sendTo);
	}
}
