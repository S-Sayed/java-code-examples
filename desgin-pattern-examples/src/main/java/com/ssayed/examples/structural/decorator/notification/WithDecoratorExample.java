package com.ssayed.examples.structural.decorator.notification;

import java.util.Arrays;
import java.util.List;

import com.ssayed.examples.structural.decorator.notification.withDecorator.BackgroundColorDecorator;
import com.ssayed.examples.structural.decorator.notification.withDecorator.BackgroundColorDecorator.Color;
import com.ssayed.examples.structural.decorator.notification.withDecorator.EmailNotifier;
import com.ssayed.examples.structural.decorator.notification.withDecorator.NotifierI;
import com.ssayed.examples.structural.decorator.notification.withDecorator.SMSNotifierDecorator;
import com.ssayed.examples.structural.decorator.notification.withDecorator.WaterMarkDecorator;

public class WithDecoratorExample {
	private static List<String> mobileNumbers = Arrays.asList("0123456", "0123457", "0123458");
	private static List<String> emails = Arrays.asList("sila@ssayed.com", "adam@ssayed.com", "sameh@ssayed.com");

	public static void main(String[] args) {
		WithDecoratorExample example = new WithDecoratorExample();

		// our basic email implementation
		example.sendOnlyEmail();
		// SMS decorator in addition to our basic email implementation
		example.sendEmailAndSMS();
		// Water mark decorator to be attached to our basic email implementation
		example.sendEmailWithWaterMark();
		// Water mark & background color decorators to be attached to our basic email
		// implementation
		example.sendEmailWithWaterMarkAndBackgroundColor();
	}

	private void sendOnlyEmail() {
		System.out.println("|-------- sendOnlyEmail --------|");
		NotifierI notifier = new EmailNotifier(emails);
		notifier.send("Welcome to Decorator Design Pattern");
	}

	private void sendEmailAndSMS() {
		System.out.println("|-------- sendEmailAndSMS --------|");
		NotifierI notifier = new SMSNotifierDecorator(mobileNumbers, new EmailNotifier(emails));
		notifier.send("Welcome to Decorator Design Pattern");
	}

	private void sendEmailWithWaterMark() {
		System.out.println("|-------- sendEmailWithWaterMark --------|");
		NotifierI notifier = new WaterMarkDecorator(new EmailNotifier(mobileNumbers));
		notifier.send("Welcome to Decorator Design Pattern");
	}

	// Notice that client program can create different kinds of Object at runtime
	// and they can specify the order of execution too.
	private void sendEmailWithWaterMarkAndBackgroundColor() {
		System.out.println("|-------- sendEmailWithWaterMarkAndBackgroundColor --------|");
		NotifierI notifier = new BackgroundColorDecorator(new WaterMarkDecorator(new EmailNotifier(mobileNumbers)),
				Color.GRAY);
		notifier.send("Welcome to Decorator Design Pattern");
	}
}
