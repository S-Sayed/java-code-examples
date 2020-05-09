package com.ssayed.examples.structural.decorator.facebook;

// basic concrete implementation
public class PlainTextPostPublisher implements PostPublisherI {

	@Override
	public void publish(String text) {
		System.out.println("Publishing <p>" + text + "</p>");
	}
}
