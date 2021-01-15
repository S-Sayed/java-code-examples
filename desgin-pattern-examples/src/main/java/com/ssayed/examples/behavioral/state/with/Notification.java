package com.ssayed.examples.behavioral.state.with;

// context/ original object
public class Notification {

	// state that make the object changes its behavior if its value has been changed
	private Notifier notifier;

	public Notification() {
		notifier = new SmsNotifier(this);
	}

	public void send(String text) {
		notifier.send(text);
	}

	public void setNotifier(Notifier notifier) {
		this.notifier = notifier;
	}
}
