package com.ssayed.examples.structural.decorator.notification;

import java.util.Arrays;
import java.util.List;

import com.ssayed.examples.structural.decorator.notification.withoutDecorator.EmailAndSMSNotifier;
import com.ssayed.examples.structural.decorator.notification.withoutDecorator.EmailAndSMSNotifierGenericHandler;
import com.ssayed.examples.structural.decorator.notification.withoutDecorator.Notifier;
import com.ssayed.examples.structural.decorator.notification.withoutDecorator.SMSNotifier;
import com.ssayed.examples.structural.decorator.notification.withoutDecorator.WaterMarkEmailDecorator;

public class WithoutDecoratorExample {
	private static List<String> mobileNumbers = Arrays.asList("0123456", "0123457", "0123458");
	private static List<String> emails = Arrays.asList("sila@ssayed.com", "adam@ssayed.com", "sameh@ssayed.com");

	public static void main(String[] args) {
		WithoutDecoratorExample example = new WithoutDecoratorExample();
		example.sendOnlyEmail();
		example.sendOnlySMS();
		example.sendEmailAndSMS();
		example.sendEmailAndSMSWithGenericHandler();
		example.sendEmailWithWaterMark();
		// what if the business asked for new notifier like FB, Twitter
		// so you will create the below, and become complicated or use the generic one
		// - FBNotifier
		// - TwitterNotifier
		// - SMSAndFBNotifier
		// - SMSAndTwitterNotifier
		// - EmailAndFBNotifier
		// - EmailAndTwitterNotifier
		// - SMSAndEmailAndFBNotifer
		// - SMSAndEmailAndTwitterNotifier
		// - SMSAndEmailAndFBAndTwitterNotifier
	}

	private void sendOnlyEmail() {
		System.out.println("|-------- sendOnlyEmail --------|");
		Notifier emailNotifier = new Notifier(emails);
		emailNotifier.send("Welcome to our new challenge");
	}

	private void sendOnlySMS() {
		System.out.println("|-------- sendOnlySMS --------|");
		Notifier smsNotifier = new SMSNotifier(mobileNumbers);
		smsNotifier.send("Welcome to our new challenge");
	}

	private void sendEmailAndSMS() {
		System.out.println("|-------- sendEmailAndSMS --------|");
		Notifier emailNotifier = new Notifier(emails);
		Notifier smsNotifier = new SMSNotifier(mobileNumbers);
		new EmailAndSMSNotifier(emailNotifier, smsNotifier).send("Welcome to our new challenge");
		// what if you want to send notification to for example 5 channels, then u will
		// create class with constructor that takes 4 parameters of the parent
		// notification interface
	}

	// ME: I can see that the below solution can replace the decorator pattern
	// but decorator is following the hierarchy object delegation
	// obj1 > obj2 > obj3 > ... > basic object
	// but the below solution is just one delegation layer
	private void sendEmailAndSMSWithGenericHandler() {
		System.out.println("|-------- sendEmailAndSMSWithGenericHandler --------|");
		Notifier emailNotifier = new Notifier(emails);
		Notifier smsNotifier = new SMSNotifier(mobileNumbers);
		new EmailAndSMSNotifierGenericHandler(Arrays.asList(emailNotifier, smsNotifier))
				.send("Welcome to our new challenge");
	}

	// if you want to add water mark for SMS, you have to create a new subclass
	// extends from SMSNotifier, so the structure is going to be complicated because
	// of many subclasses will be created to support multiple behaviors, that is why
	// decorator pattern came to the picture
	private void sendEmailWithWaterMark() {
		System.out.println("|-------- sendEmailWithWaterMark --------|");
		Notifier emailNotifier = new WaterMarkEmailDecorator(emails);
		emailNotifier.send("Welcome to our new challenge");
	}
}
