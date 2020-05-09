package com.ssayed.examples.structural.decorator.notification.withoutDecorator;

import java.util.List;

// ME: I can see this class can replace the decorator pattern
// but decorator is following the hierarchy object delegation
// obj1 > obj2 > obj3 > ... > basic object
// but the below solution is just one delegation layer
public class EmailAndSMSNotifierGenericHandler {

	private List<Notifier> notifiers;

	public EmailAndSMSNotifierGenericHandler(List<Notifier> notifiers) {
		this.notifiers = notifiers;
	}

	public void send(String message) {
		notifiers.stream().forEach(n -> n.send(message));
	}
}