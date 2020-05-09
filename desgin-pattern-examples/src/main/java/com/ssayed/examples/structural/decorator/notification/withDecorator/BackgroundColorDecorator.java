package com.ssayed.examples.structural.decorator.notification.withDecorator;

//Background color concrete decorator that will add background color functionality
public class BackgroundColorDecorator extends NotifierDecorator {

	private Color color;

	public enum Color {
		GRAY, WHITE, CYAN
	}

	public BackgroundColorDecorator(NotifierI notifier, Color color) {
		super(notifier);
		this.color = color;
	}

	@Override
	public void send(String message) {
		super.send("<span style='background-color: " + color.name() + ";'>" + message + "</span>");
	}
}
