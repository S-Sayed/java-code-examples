package com.ssayed.examples.behavioral.state.with;

// state concrete implementation
public class EmailNotifier implements Notifier {

	// reference to the context/ original object
	private Notification notification;

	public EmailNotifier(Notification notification) {
		this.notification = notification;
	}

	@Override
	public void send(String text) {
		System.out.println("Logic to send Email: " + text);
	}
}
