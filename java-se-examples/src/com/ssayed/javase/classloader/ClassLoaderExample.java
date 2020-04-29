package com.ssayed.javase.classloader;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ClassLoaderExample {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws ClassNotFoundException {
		// null means bootstrap
		System.out.println("Class loader of String, null means Bootstrap: " + String.class.getClassLoader());

		// the below memory reference id is same, as the JVM create one object per
		// class loader
		// sun.misc.Launcher$ExtClassLoader@75b84c92
		System.out.println("Without passing Extension class loader: "
				+ Class.forName("sun.net.spi.nameservice.dns.DNSNameService").getClassLoader());

		// sun.misc.Launcher$ExtClassLoader@75b84c92
		System.out.println(
				"With passing Extension class loader: " + Class.forName("sun.net.spi.nameservice.dns.DNSNameService",
						true, ClassLoaderExample.class.getClassLoader().getParent()).getClassLoader());

		// sun.misc.Launcher$AppClassLoader@6d06d69c
		// where 6d06d69c is the memory reference id of AppClassLoader
		System.out.println("Class loader of ClassLoaderExample: " + ClassLoaderExample.class.getClassLoader());

		Class<OrderItem> item = (Class<OrderItem>) new CustomCLassLoader()
				.findClass("com.ssayed.javase.classloader.OrderItem");

		try {
			Object o = item.newInstance();
			Method setNameMethod = o.getClass().getDeclaredMethod("setName", String.class);
			setNameMethod.invoke(o, "Iphone");
			System.out.println(o.getClass().getDeclaredMethod("getName").invoke(o));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

// ClassLoader is abstract class
class CustomCLassLoader extends ClassLoader {
	@Override
	protected Class<?> findClass(String name) throws ClassNotFoundException {
		// load class from the file system for example
		byte[] byteArray = loadClassFromFile(name);
		// defineClass converts the array of bytes to instance of the class
		return defineClass(name, byteArray, 0, byteArray.length);
	}

	public byte[] loadClassFromFile(String fileName) {
		System.out.println("Class Loader of CustomCLassLoader: " + getClass().getClassLoader());

		InputStream inputStream = getClass().getClassLoader()
				.getResourceAsStream(fileName.replace('.', File.separatorChar) + ".class");

		byte[] buffer;
		ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
		int nextValue = 0;

		try {
			while ((nextValue = inputStream.read()) != -1) {
				byteStream.write(nextValue);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		buffer = byteStream.toByteArray();
		return buffer;
	}
}