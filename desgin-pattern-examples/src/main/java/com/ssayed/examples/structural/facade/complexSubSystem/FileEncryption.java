package com.ssayed.examples.structural.facade.complexSubSystem;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Base64;

public class FileEncryption {
	public File encrypt(File file) throws Exception {
		System.out.println("\nencrypt file - START");

		String fileContents = readFile(file);
		System.out.println("encrypt file - fileContents: " + fileContents);

		String filePath = file.getParent() + "\\" + file.getName().substring(0, file.getName().lastIndexOf("."));
		File outputFile = writeFile(filePath, fileContents.getBytes());

		System.out.println("encrypt file - END");

		return outputFile;
	}

	private File writeFile(String filePath, byte[] bytes) throws Exception {
		File outputFile = new File(filePath + ".encrypted");
		System.out.println(outputFile.getAbsolutePath());

		try (OutputStream os = new FileOutputStream(outputFile);) {
			String encodedContens = Base64.getEncoder().encodeToString(bytes);
			os.write(encodedContens.getBytes());
			System.out.println("encrypt file - encodedContens: " + encodedContens);
		}

		return outputFile;
	}

	private String readFile(File file) throws Exception {
		int index = 0;
		String fileContents = "";

		try (FileInputStream fis = new FileInputStream(file)) {
			while ((index = fis.read()) != -1) {
				fileContents += (char) index;
			}
		}
		return fileContents;
	}
}
