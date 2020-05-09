package com.ssayed.examples.structural.decorator.facebook;

public class BackgroundColorPostPublisherDecorator extends PostPublisherDecorator {
	private Color color;

	public enum Color {
		GREEN, CYAN, BLUE
	}

	public BackgroundColorPostPublisherDecorator(PostPublisherI postPublisherI, Color color) {
		super(postPublisherI);
		this.color = color;
	}

	@Override
	public void publish(String text) {
		String backgroundColorClassName = "backgroundColor_" + color.name();
		StringBuilder sb = new StringBuilder(text);

		sb.insert(0, "<span class='" + backgroundColorClassName + "'> ");
		sb.append("</span>");

		super.publish(sb.toString());
	}
}
