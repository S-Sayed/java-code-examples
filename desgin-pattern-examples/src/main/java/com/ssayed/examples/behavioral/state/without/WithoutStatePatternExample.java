package com.ssayed.examples.behavioral.state.without;

public class WithoutStatePatternExample {

	public static void main(String[] args) {
		Notification notification = new Notification();
		notification.send("Hello SILA");
		notification.setType(Notification.Type.EMAIL);
		notification.send("Hello ADAM");
		notification.setType(Notification.Type.FACEBOOK);
		notification.send("Hello SAMEH");
		notification.setType(Notification.Type.SMS);
		notification.send("Hello MINA");
	}
}
