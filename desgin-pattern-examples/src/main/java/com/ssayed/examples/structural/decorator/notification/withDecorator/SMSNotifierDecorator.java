package com.ssayed.examples.structural.decorator.notification.withDecorator;

import java.util.List;

// SMS concrete decorator that will add SMS functionality to the existing basic email implementation
public class SMSNotifierDecorator extends NotifierDecorator {
	private List<String> receivers;

	public SMSNotifierDecorator(List<String> receivers, NotifierI notifier) {
		super(notifier);
		this.receivers = receivers;
	}

	@Override
	public void send(String message) {
		super.send(message);
		receivers.stream()
				.forEach(e -> System.out.println("SMS has been sent to <" + e + "> with body <" + message + ">"));
	}
}
