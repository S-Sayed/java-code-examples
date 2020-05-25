package com.ssayed.examples.structural.proxy.withProxy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WhatsAppProxy implements WhatsApp {
	// private static WhatsAppProxy whatsAppProxy;
	private WhatsApp whatsApp;
	private static Map<Long, List<byte[]>> cachedPhotos = new HashMap<Long, List<byte[]>>();

	// public static WhatsAppProxy getInstance() {
	// if (whatsAppProxy == null)
	// whatsAppProxy = new WhatsAppProxy();
	// return whatsAppProxy;
	// }

	@Override
	public List<byte[]> getPhotosByCustomerId(long customerId) {
		System.out.println("PROXY - getPhotosByCustomerId - START");

		List<byte[]> photos = null;

		if (cachedPhotos.get(customerId) == null) {
			System.out.println("Calling the real whatsapp service with id " + customerId);

			if (whatsApp == null)
				whatsApp = new WhatsAppPhotoImpl();

			photos = whatsApp.getPhotosByCustomerId(customerId);
			cachedPhotos.put(customerId, photos);
		} else {
			System.out.println("The result returned from the proxy's cache");
			photos = cachedPhotos.get(customerId);
		}

		System.out.println("PROXY - getPhotosByCustomerId - END");
		return photos;
	}
}