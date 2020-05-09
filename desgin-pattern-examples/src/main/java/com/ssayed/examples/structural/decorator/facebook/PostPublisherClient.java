package com.ssayed.examples.structural.decorator.facebook;

import com.ssayed.examples.structural.decorator.facebook.BackgroundColorPostPublisherDecorator.Color;
import com.ssayed.examples.structural.decorator.facebook.IconPostPublisherDecorator.Icon;

public class PostPublisherClient {

	public static void main(String[] args) {
		PostPublisherClient client = new PostPublisherClient();
		client.publishPostWithPlainText();
		client.publishPostWithPlainTextAndBackground();
		client.publishPostWithPlainTextAndIcon();
		client.publishPostWithPlainTextAndBackgroundAndIcon();

	}

	private void publishPostWithPlainText() {
		System.out.println("|------- publishPostWithPlainText --------|");
		PostPublisherI postPublisherI = new PlainTextPostPublisher();
		postPublisherI.publish("Welcome to Decorator pattern");
	}

	private void publishPostWithPlainTextAndBackground() {
		System.out.println("|------- publishPostWithPlainTextAndBackground --------|");
		PostPublisherI postPublisherI = new BackgroundColorPostPublisherDecorator(new PlainTextPostPublisher(),
				Color.BLUE);
		postPublisherI.publish("Welcome to Decorator pattern");
	}

	private void publishPostWithPlainTextAndIcon() {
		System.out.println("|------- publishPostWithPlainTextAndIcon --------|");
		PostPublisherI postPublisherI = new IconPostPublisherDecorator(new PlainTextPostPublisher(), Icon.CONGRATS);
		postPublisherI.publish("Welcome to Decorator pattern");

	}

	private void publishPostWithPlainTextAndBackgroundAndIcon() {
		System.out.println("|------- publishPostWithPlainTextAndBackgroundAndIcon --------|");
		PostPublisherI postPublisherI = new BackgroundColorPostPublisherDecorator(
				new IconPostPublisherDecorator(new PlainTextPostPublisher(), Icon.CONGRATS), Color.BLUE);
		postPublisherI.publish("Welcome to Decorator pattern");
	}
}
