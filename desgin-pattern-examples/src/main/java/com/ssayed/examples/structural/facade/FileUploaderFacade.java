package com.ssayed.examples.structural.facade;

import java.io.File;

import com.ssayed.examples.structural.facade.complexSubSystem.FileCompression;
import com.ssayed.examples.structural.facade.complexSubSystem.FileEncryption;
import com.ssayed.examples.structural.facade.complexSubSystem.FileUploader;

public class FileUploaderFacade {

	public void upload(File file) {
		FileEncryption fileEncryption = new FileEncryption();
		FileCompression fileCompression = new FileCompression();
		FileUploader fileUploader = new FileUploader();

		try {
			file = fileEncryption.encrypt(file);
			file = fileCompression.compress(file);
			fileUploader.upload(file);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
