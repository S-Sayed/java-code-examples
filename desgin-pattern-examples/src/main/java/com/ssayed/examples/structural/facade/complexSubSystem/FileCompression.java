package com.ssayed.examples.structural.facade.complexSubSystem;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.Deflater;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.InflaterInputStream;

public class FileCompression {

	public File compress(File file) throws Exception {
		System.out.println("\ncompress file - START");

		String fileContents = readFile(file);
		System.out.println("compress file - fileContents: " + fileContents);

		File outputFile = null;

		try {
			ByteArrayOutputStream baos = new ByteArrayOutputStream(512);
			DeflaterOutputStream dos = new DeflaterOutputStream(baos, new Deflater(6));

			dos.write(fileContents.getBytes());
			baos.close();
			dos.close();

			String filePath = file.getParent() + "\\" + file.getName().substring(0, file.getName().lastIndexOf("."));
			outputFile = writeFile(filePath, baos.toByteArray());

			// just testing the decompression for me to see the de-compressed data
			// decompress(outputFile);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

		System.out.println("compress file - END");

		return outputFile;
	}

	private File writeFile(String filePath, byte[] byteArray) throws Exception {
		File outputFile = new File(filePath + ".compressed");

		try (OutputStream os = new FileOutputStream(outputFile);) {
			os.write(byteArray);
		}

		System.out.println("compressed File Contents: " + new String(byteArray));
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

	private void decompress(File outputFile) throws Exception {

		String fileContents = readFile(outputFile);
		System.out.println("decompress - fileContents: " + fileContents);
		String result = "";
		
		try {
			InputStream is = new ByteArrayInputStream(fileContents.getBytes());
			InflaterInputStream iis = new InflaterInputStream(is);
			ByteArrayOutputStream bout = new ByteArrayOutputStream(512);

			int b;
			while ((b = iis.read()) != -1) {
				bout.write(b);
			}

			is.close();
			iis.close();
			bout.close();

			result = new String(bout.toByteArray());
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

		System.out.println("result" + result);

	}
}
