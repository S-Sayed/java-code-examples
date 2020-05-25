package com.ssayed.examples.structural.proxy.withProxy;

public class ProxyPatternExample {

	public static void main(String[] args) {
		System.out.println("Call 1");
		// WhatsApp whatsApp = WhatsAppProxy.getInstance();
		WhatsApp whatsApp = new WhatsAppProxy();
		whatsApp.getPhotosByCustomerId(1);

		System.out.println("\nCall 2");
		whatsApp = new WhatsAppProxy();
		whatsApp.getPhotosByCustomerId(1);

		System.out.println("\nCall 3");
		whatsApp = new WhatsAppProxy();
		whatsApp.getPhotosByCustomerId(1);

		System.out.println("\nCall 4");
		whatsApp = new WhatsAppProxy();
		whatsApp.getPhotosByCustomerId(2);

		System.out.println("\nCall 5");
		whatsApp = new WhatsAppProxy();
		whatsApp.getPhotosByCustomerId(2);
	}
}
