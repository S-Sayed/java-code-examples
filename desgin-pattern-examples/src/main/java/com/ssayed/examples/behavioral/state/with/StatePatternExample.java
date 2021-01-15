package com.ssayed.examples.behavioral.state.with;

// client
public class StatePatternExample {

	public static void main(String[] args) {
		Notification notification = new Notification();
		notification.send("Hello SILA");
		notification.setNotifier(new EmailNotifier(notification));
		notification.send("Hello ADAM");
	}
}
