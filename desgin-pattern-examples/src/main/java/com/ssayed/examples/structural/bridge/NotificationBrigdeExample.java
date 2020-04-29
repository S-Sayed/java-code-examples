package com.ssayed.examples.structural.bridge;

import com.ssayed.examples.structural.bridge.abstraction.notification.EmailNotification;
import com.ssayed.examples.structural.bridge.abstraction.notification.Notification;
import com.ssayed.examples.structural.bridge.abstraction.notification.SMSNotification;
import com.ssayed.examples.structural.bridge.implementation.notification.EtisalatNotificationProvider;
import com.ssayed.examples.structural.bridge.implementation.notification.GoogleNotificationProvider;

public class NotificationBrigdeExample {

	public static void main(String[] args) {
		Notification notifiation = new EmailNotification(new GoogleNotificationProvider());
		notifiation.send("ssayed7190@gmail.com");

		notifiation = new SMSNotification(new GoogleNotificationProvider());
		notifiation.send("0506630580");

		notifiation = new EmailNotification(new EtisalatNotificationProvider());
		notifiation.send("ssayed7190@gmail.com");

		notifiation = new SMSNotification(new EtisalatNotificationProvider());
		notifiation.send("0506630580");
	}
}
