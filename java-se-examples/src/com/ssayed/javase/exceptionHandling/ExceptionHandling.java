package com.ssayed.javase.exceptionHandling;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;

public class ExceptionHandling {

	public static void main(String[] args) {
		ExceptionHandling e = new ExceptionHandling();
		e.testRecoverableCheckedException();
		e.testRecoverableUncheckedException();
		e.testUnrecoverableUncheckedException();
		e.testCheckedExceptionPropagation();
		e.testUncheckedExceptionPropagation();
		e.testMultipleCatch();
		e.testUnionCatch();
		e.testTryWithResource();
	}

	private void testTryWithResource() {
		System.out.println("testTryWithResource - START");

		String filePath = "C:\\Users\\Etisalat\\Desktop\\Study\\server2\\configuration.properties";
		try (FileInputStream fis = new FileInputStream(new File(filePath))) {
			int content;
			while ((content = fis.read()) != -1) {
				System.out.print((char) content);
			}
			System.out.println();
		} catch (IOException e) {
			System.err.println(e.getClass());
			System.err.println("Something went wrong");
		}

		System.out.println("testTryWithResource - START");
	}

	// use it when the exceptions are related and will be handled in the same way
	private void testUnionCatch() {
		System.out.println("testUnionCatch - START");

		try {
			int number1 = Integer.parseInt("abc");
			int number2 = Integer.parseInt("0");
			System.out.println("divison result: " + number1 / number2);
		} catch (NumberFormatException | ArithmeticException e) {
			System.err.println(e.getClass());
			System.err.println("please enter a valid number, ZERO not allowed");
		}

		System.out.println("testUnionCatch - END");

	}

	private void testMultipleCatch() {
		System.out.println("testMultipleCatch - START");

		try {
			int age = Integer.parseInt("abc");
			String nextElement = "a,b,c".split(",")[5];
			System.out.println("age: " + age + ", nextElement: " + nextElement);
		} catch (NumberFormatException e) {
			System.err.println(e.getClass());
			System.err.println("please enter a valid age number");
		} catch (ArrayIndexOutOfBoundsException e) {
			System.err.println(e.getClass());
			System.err.println("existing elements started from index 0 to 2");
		}

		System.out.println("testMultipleCatch - END");
	}

	// handling the unchecked exception here doesn't mean that we recover from the
	// exception, but we handled it to give user an error message
	private void testUncheckedExceptionPropagation() {
		System.out.println("testUncheckedExceptionPropagation - START");

		try {
			validateAge("abc");
			System.out.println("allow watching");
		} catch (NumberFormatException e) {
			System.err.println(e.getClass());
			System.err.println("Please enter valid age number");
		}

		System.out.println("testUncheckedExceptionPropagation - END");
	}

	// throw here is optional as it is unchecked exception
	private void validateAge(String ageAsString) throws NumberFormatException {
		int ageAsInt = Integer.parseInt(ageAsString);

		if (ageAsInt < 7) {
			System.out.println("Approval needed, plz ask your father to check his email");
		}
	}

	// if you didn't handle the exception here, propagate it to the main method then
	// the main method either handle it or hand-over the exception to the default
	// exception handler in JVM
	private void testCheckedExceptionPropagation() {
		System.out.println("testCheckedExceptionPropagation - START");

		try {
			fillExceptionHandlingObject();
			System.out.println("serializing the object");
		} catch (ClassNotFoundException e) {
			System.err.println(e.getClass());
		}

		System.out.println("testCheckedExceptionPropagation - END");
	}

	private void fillExceptionHandlingObject() throws ClassNotFoundException {
		loadExceptionHandlingClassObject();
		// fill the object states
	}

	// any caller of the below method should either propagate the exception till the
	// main method then if main method didn't handle it using try-catch, JVM will
	// call the default exception handler
	@SuppressWarnings("unchecked")
	private Class<ExceptionHandling> loadExceptionHandlingClassObject() throws ClassNotFoundException {
		return (Class<ExceptionHandling>) Class.forName("com.ssayed.javase.exceptionHandling.ExceptionHandling");
	}

	private void testUnrecoverableUncheckedException() {
		System.out.println("testUnrecoverableUncheckedException - START");
		String ageAsString = "abc"; // input from user

		try {
			Integer.parseInt(ageAsString);
			// can't continue executing the following code as long as the exception
			// unrecoverable
			System.out.println("validating the user age");
		} catch (NumberFormatException e) {
			System.err.println(e.getClass());
			System.err.println("please enter valid age number");
		}

		System.out.println("testUnrecoverableUncheckedException - END");
	}

	// you can recover the unchecked exception based on the business case
	// the below case can be recovered
	private void testRecoverableUncheckedException() {
		System.out.println("testRecoverableUncheckedException - START");

		String timeoutValueAsString = null; // consider that value is not configured in DB
		int timeoutValueAsInt = 0;

		try {
			// the below line will throw NumberFormatException, it is unchecked but we can
			// recover from it by providing default value
			timeoutValueAsInt = Integer.parseInt(timeoutValueAsString);
		} catch (NumberFormatException e) {
			System.err.println(e.getClass());
			System.err.println("timeout value is not configured in DB");
			// recover from the exception by providing default value, means resolve the
			// exception and process the rest of the code
			timeoutValueAsInt = 30000; // Milliseconds
		}

		System.out.println("call the API with timeout = " + timeoutValueAsInt);
		System.out.println("testRecoverableUncheckedException - END");

	}

	private void testRecoverableCheckedException() /* throws FileNotFoundException */ {
		System.out.println("testRecoverableCheckedException - START");

		// checked exception like file not found, SQL, remote connection, class not
		// found exceptions

		// file not found:
		// new FileInputStream(file);

		// class not found:
		// Class.forName("com.ssayed.javase.exceptionHandling.ExceptionHandling");

		loadSystemConfiguration();

		System.out.println("testRecoverableCheckedException - END");
	}

	private void loadSystemConfiguration() {
		FileInputStream fis = null;

		try {
			File file = new File("C:\\Users\\Etisalat\\Desktop\\Study\\server1\\configuration.properties");

			// in the below line, the compiler will check if you handled the exception or
			// not, if not, will give you compilation error as the file may not there
			// you can handle it using throws declaration or try-catch or try-with-resources
			fis = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			// you can get the file (may be someone deleted it by mistake) from other server
			// and process the rest of the code, means recover from the exception, and
			// maintain the normal flow of your application
			System.err.println(e.getClass() + " will try to get configuration from other server");
			copyConfigurationFileFromDifferentServer();
		} finally {
			if (fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					System.err.println(e.getClass());
				}
			}
		}
	}

	private void copyConfigurationFileFromDifferentServer() {
		String sourceFilePath = "C:\\Users\\Etisalat\\Desktop\\Study\\server2\\configuration.properties";
		String destinationFilePath = "C:\\Users\\Etisalat\\Desktop\\Study\\server1\\configuration.properties";

		try {
			Files.copy(new File(sourceFilePath).toPath(), new File(destinationFilePath).toPath());
		} catch (IOException e) {
			System.err.println(e.getClass());
			throw new RuntimeException("Something went wrong: " + e.getMessage());
		}

	}
}
