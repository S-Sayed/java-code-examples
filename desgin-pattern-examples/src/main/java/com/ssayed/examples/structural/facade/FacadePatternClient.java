package com.ssayed.examples.structural.facade;

import java.io.File;

import com.ssayed.examples.structural.facade.complexSubSystem.FileCompression;
import com.ssayed.examples.structural.facade.complexSubSystem.FileEncryption;
import com.ssayed.examples.structural.facade.complexSubSystem.FileUploader;

public class FacadePatternClient {
	private static final String FILE_PATH = ".\\src\\main\\java\\com\\ssayed\\examples\\structural\\facade\\resources\\server-security.txt";

	public static void main(String[] args) {
		FacadePatternClient client = new FacadePatternClient();
		client.testWithoutFacadePattern();
		client.testWithFacadePattern();
	}

	// what if the below same objects initialization & logic have been done from
	// multiple clients and if the sub-system did some change, and the clients
	// want to use the new change, so the code will be hard to maintain as it is
	// tightly coupled with the complex sub-system.
	private void testWithoutFacadePattern() {
		System.out.println("|--------- testWithoutFacadePattern ------------|");

		FileEncryption fileEncryption = new FileEncryption();
		FileCompression fileCompression = new FileCompression();
		FileUploader fileUploader = new FileUploader();

		System.out.println("Current DIR: " + System.getProperty("user.dir"));

		try {
			File file = new File(FILE_PATH);
			file = fileEncryption.encrypt(file);
			file = fileCompression.compress(file);
			fileUploader.upload(file);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// with facade pattern, we moved the objects initialization & logic to another
	// layer and if the sub-system did some change, and the clients
	// want to use the new change, so the change will be only in the facade layer
	// and clients will not be impacted as they are loosely coupled with the
	// sub-system.
	private void testWithFacadePattern() {
		System.out.println("|--------- testWithFacadePattern ------------|");
		File file = new File(FILE_PATH);
		new FileUploaderFacade().upload(file);
	}
}
