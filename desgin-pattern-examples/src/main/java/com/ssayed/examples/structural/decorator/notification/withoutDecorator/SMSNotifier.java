package com.ssayed.examples.structural.decorator.notification.withoutDecorator;

import java.util.List;

public class SMSNotifier extends Notifier {

	public SMSNotifier(List<String> receivers) {
		super(receivers);
	}

	@Override
	public void send(String message) {
		super.receivers.stream().forEach(e -> System.out.println("SMS has been sent to <" + e + "> with body <" + message + ">"));
	}
}
