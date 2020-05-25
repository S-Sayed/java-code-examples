package com.ssayed.examples.structural.proxy.withProxy;

import java.util.ArrayList;
import java.util.List;

public class WhatsAppPhotoImpl implements WhatsApp {

	@Override
	public List<byte[]> getPhotosByCustomerId(long customerId) {
		simulateNetwork();

		// mock the photos
		List<byte[]> photos = new ArrayList<byte[]>();
		photos.add(new byte[10]);
		photos.add(new byte[11]);
		photos.add(new byte[12]);

		return photos;
	}

	private void simulateNetwork() {
		for (int i = 1; i < 5; i++) {
			System.out.print(".");

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		System.out.println();
	}

}
