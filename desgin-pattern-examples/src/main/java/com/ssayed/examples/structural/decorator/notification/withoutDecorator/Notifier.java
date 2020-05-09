package com.ssayed.examples.structural.decorator.notification.withoutDecorator;

import java.util.List;

// existing basic notifier with email implementation
public class Notifier {

	protected List<String> receivers;

	public Notifier(List<String> receivers) {
		this.receivers = receivers;
	}

	public void send(String message) {
		receivers.stream()
				.forEach(e -> System.out.println("Email has been sent to <" + e + "> with body <" + message + ">"));

	}
}
