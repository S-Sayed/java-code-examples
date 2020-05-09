package com.ssayed.examples.structural.facade.complexSubSystem;

import java.io.File;

public class FileUploader {
	public void upload(File file) {
		System.out.println("\nuploading file - START");

		System.out.println("uploading file <" + file.getName() + "> to AWS S3");

		simulateUploading();

		System.out.println("\nuploading file - END");
	}

	private void simulateUploading() {
		for (int i = 0; i < 5; i++) {
			try {
				System.out.print(".");
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
