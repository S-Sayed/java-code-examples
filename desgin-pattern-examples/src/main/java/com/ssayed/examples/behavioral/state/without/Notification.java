package com.ssayed.examples.behavioral.state.without;

public class Notification {

	enum Type {
		SMS, EMAIL, FACEBOOK, TWITTER;
	}

	private Type type;

	public Notification() {
		type = Type.SMS;
	}

	public void send(String text) {
		if (type == Type.SMS) {
			System.out.println("Logic to send SMS: " + text);
		} else if (type == Type.EMAIL) {
			System.out.println("Logic to send Email : " + text);
		} else if (type == Type.FACEBOOK) {
			System.out.println("Logic to send a message to Facebook account: " + text);
		} else if (type == Type.TWITTER) {
			System.out.println("Logic to send a message to Twitter account: " + text);
		}
	}

	public void setType(Type type) {
		this.type = type;
	}
}
