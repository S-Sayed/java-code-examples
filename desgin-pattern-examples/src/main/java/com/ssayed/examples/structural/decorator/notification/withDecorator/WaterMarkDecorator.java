package com.ssayed.examples.structural.decorator.notification.withDecorator;

// WaterMark concrete decorator that will add water mark functionality
public class WaterMarkDecorator extends NotifierDecorator {

	public WaterMarkDecorator(NotifierI notifier) {
		super(notifier);
	}

	@Override
	public void send(String message) {
		String waterMark = " | Copyright (C) 2020 SAMEH";
		super.send(message + waterMark);
	}
}
