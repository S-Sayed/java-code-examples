package com.ssayed.examples.structural.decorator.notification.withoutDecorator;

public class EmailAndSMSNotifier {

	private Notifier notifier1;
	private Notifier notifier2;

	public EmailAndSMSNotifier(Notifier notifier1, Notifier notifier2) {
		this.notifier1 = notifier1;
		this.notifier2 = notifier2;
	}

	public void send(String message) {
		notifier1.send(message);
		notifier2.send(message);
	}
}
