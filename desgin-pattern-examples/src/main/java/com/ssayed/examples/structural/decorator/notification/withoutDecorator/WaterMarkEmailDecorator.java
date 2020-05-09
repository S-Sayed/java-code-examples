package com.ssayed.examples.structural.decorator.notification.withoutDecorator;

import java.util.List;

// WaterMark concrete decorator that will add water mark functionality
public class WaterMarkEmailDecorator extends Notifier {

	public WaterMarkEmailDecorator(List<String> receivers) {
		super(receivers);
	}

	@Override
	public void send(String message) {
		String waterMark = " | Copyright (C) 2020 SAMEH";
		super.send(message + waterMark);
	}
}
