package com.ssayed.examples.structural.decorator.facebook;

public class IconPostPublisherDecorator extends PostPublisherDecorator {
	private Icon icon;

	public enum Icon {
		BIRTH_DAY, CONGRATS
	}

	public IconPostPublisherDecorator(PostPublisherI postPublisherI, Icon icon) {
		super(postPublisherI);
		this.icon = icon;
	}

	@Override
	public void publish(String text) {
		String iconStyle = " <img src='ICON_" + icon.name() + "' />";
		super.publish(text + iconStyle);
	}
}
