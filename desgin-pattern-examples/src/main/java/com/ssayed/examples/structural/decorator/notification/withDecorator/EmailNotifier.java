package com.ssayed.examples.structural.decorator.notification.withDecorator;

import java.util.List;

// basic concrete implementation
public class EmailNotifier implements NotifierI {
	private List<String> receivers;

	public EmailNotifier(List<String> receivers) {
		this.receivers = receivers;
	}

	@Override
	public void send(String message) {
		receivers.stream()
				.forEach(e -> System.out.println("Email has been sent to <" + e + "> with body <" + message + ">"));
	}
}
