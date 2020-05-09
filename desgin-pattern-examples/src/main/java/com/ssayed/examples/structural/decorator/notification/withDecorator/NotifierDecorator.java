package com.ssayed.examples.structural.decorator.notification.withDecorator;

// the decorator that will attach extra behaviors to the basic email implementation
public class NotifierDecorator implements NotifierI {

	// wrappee/ wrapped object
	private NotifierI notifier;

	public NotifierDecorator(NotifierI notifier) {
		this.notifier = notifier;
	}

	@Override
	public void send(String message) {
		// decorator can add something before/ after delegating the request to the
		// target object
		notifier.send(message);
	}
}
