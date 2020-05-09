package com.ssayed.examples.structural.decorator.facebook;

//  wrapper that wrap the target object
public class PostPublisherDecorator implements PostPublisherI {

	private PostPublisherI postPublisherI;

	public PostPublisherDecorator(PostPublisherI postPublisherI) {
		this.postPublisherI = postPublisherI;
	}

	@Override
	public void publish(String text) {
		postPublisherI.publish(text);
	}
}
