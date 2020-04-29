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
		// e.testStackOverflowException();
		// e.testOutOfMemoryException();
		e.testThrowWithCatch();
		e.testFinallyIfExceptionThrownInTryAndCatch();
		e.testFinallyWithSystemExit();
		e.testFinallyWithReturnInTry();
		e.testWithoutCustomException();
		e.testCustomUncheckedException();
		e.testSpecificCustomUncheckedException();
		e.testCustomCheckedException();
	}

	// you have to propagate/ handle it
	private void testCustomCheckedException() {
		System.out.println("testCustomCheckedException - START");

		try {
			validateFileExtension("abc.ssayed");
		} catch (InvalidFileExtensionException e) {
			System.err.println(e.getMessage());
		}

		System.out.println("testCustomCheckedException - END");
	}

	// you have to propagate/ handle it
	private void validateFileExtension(String fileExtension) throws InvalidFileExtensionException {
		if (!(fileExtension.endsWith("pdf")))
			throw new InvalidFileExtensionException("Invalid extension, allowed one is pdf");
	}

	private void testSpecificCustomUncheckedException() {
		System.out.println("testSpecificCustomUncheckedException - START");

		try {
			validateAgeForVoting(2);
		} catch (NotAllowedAgeException e) {
			System.err.println("Age not allowed");
		} catch (BusinessException e) {
			System.err.println(e.getErrorCode());
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}

		System.out.println("testSpecificCustomUncheckedException - END");
	}

	private void validateAgeForVoting(int age) {
		if (age < 16) {
			throw new NotAllowedAgeException();
		}
	}

	private void testCustomUncheckedException() {
		System.out.println("testCustomUncheckedException - START");

		try {
			// validateUserId("ssayed");
			// validateEmail("ssayed7190@gmail.com");
			callMethodFromThirdPartyAPI();
		} catch (BusinessException e) {
			// looks nice as you are depending on some error code instead of error messages
			// you can get the localized message from properties file by the error_code
			// instead of if-else conditions as follow
			// System.err.println(getMessage(e.getErrorCode()));
			if (e.getErrorCode() == ErrorCode.USER_ID_EXIST) {
				System.err.println("Please enter different user ID");
			} else if (e.getErrorCode() == ErrorCode.EMAIL_INVALID) {
				System.err.println("Please enter valid E-mail");
			} else if (e.getErrorCode() == ErrorCode.GENEAL_ERROR) {
				System.err.println("Something went wrong");
			}
		}

		System.out.println("testCustomUncheckedException - END");
	}

	private void callMethodFromThirdPartyAPI() {
		try {
			// just for testing purpose, consider the below some code in the third part
			// method
			Integer.parseInt(null);
		} catch (RuntimeException e) {
			throw new BusinessException(ErrorCode.GENEAL_ERROR);
		}
	}

	private void validateEmail(String email) {
		// assume it is not valid
		boolean emailInvalid = true;

		if (emailInvalid)
			throw new BusinessException(ErrorCode.EMAIL_INVALID);

	}

	private void validateUserId(String userId) {
		// assume it is already used
		boolean userIdExist = true;

		if (userIdExist)
			throw new BusinessException(ErrorCode.USER_ID_EXIST);
	}

	private void testWithoutCustomException() {
		System.out.println("testWithoutCustomException - START");

		try {
			checkIfUserIdAlreadyExist("ssayed");
			checkIfEmailAlreadyExist("ssayed7190@gmail.com");
		} catch (RuntimeException e) {
			// bad exception handling as you are dealing with the exceptions by their
			// messages
			if (e.getMessage().equals("User ID already Exist")) {
				System.err.println("Please enter different user ID");
			} else if (e.getMessage().equals("Email already Exist")) {
				System.err.println("Please enter different E-mail");
			} else {
				System.err.println("Something went wrong: " + e.getMessage());
			}
		}

		System.out.println("testWithoutCustomException - END");
	}

	private void checkIfEmailAlreadyExist(String email) {
		// assume it is exist
		throw new IllegalArgumentException("Email already Exist");
	}

	private void checkIfUserIdAlreadyExist(String userId) {
		// assume it is exist
		throw new IllegalArgumentException("User ID already Exist");
	}

	private void testFinallyWithSystemExit() {
		System.out.println("testFinallyWithSystemExit - START");

		try {
			System.out.println("Try Block");

			if (isInvalidEmail("ssayed@gmail.com")) {
				// terminate the current running JVM that call Runtime.exit method with status
				// code if status code != 0 means abnormal termination
				// so no more code will be executed as JVM gets terminated
				// so finally block will never be called if email is invalid
				System.exit(0);
			}

			System.out.println("Execute the rest of Try block");
		} finally {
			// will not be executed if the email is invalid
			System.out.println("Finally Block");
		}

		// will not be executed if the email is invalid
		System.out.println("testFinallyWithSystemExit - END");

	}

	private void testFinallyWithReturnInTry() {
		System.out.println("testFinallyWithReturnInTry - START");

		try {
			System.out.println("Try Block");

			if (isInvalidEmail("ssayed")) {
				return;
			}

			System.out.println("Execute the rest of Try block");
		} finally {
			// to be executed before return (if the email is invalid)
			System.out.println("Finally Block");
		}

		// will not be executed if the email is invalid
		System.out.println("testFinallyWithReturnInTry - END");
	}

	// finally block is going to be executed after try|catch execution even
	// if an exception occurred in try|catch, and the output will be as follow
	// Catch Block 1
	// Catch Block 2
	// java.lang.NullPointerException
	// Finally Block

	// but if there is no matched catch block (for example 'Catch Block 2'), JVM
	// will execute finally block before thrown
	// the exception by the default exception handler then terminate the program
	// and the result will be as follow
	// Catch Block 1
	// Finally Block
	// java.lang.NullPointerException
	@SuppressWarnings("null")
	private void testFinallyIfExceptionThrownInTryAndCatch() {
		System.out.println("testFinallyIfExceptionThrownInTryAndCatch - START");

		try {
			String configuredWSUrlFromDB = null; // assume no value in DB
			configuredWSUrlFromDB = configuredWSUrlFromDB.concat("?wsdl");
		} catch (NullPointerException e) {
			System.err.println("Catch Block 1");

			try {
				String configuredWSUrlFromFS = null; // assume no value in file system
				configuredWSUrlFromFS = configuredWSUrlFromFS.concat("?wsdl");
			} catch (NullPointerException ex) {
				System.err.println("Catch Block 2");
				System.err.println(ex);
			}
		} finally {
			System.out.println("Finally Block");
		}

		System.out.println("testFinallyIfExceptionThrownInTryAndCatch - END");

	}

	// the below for both checked and unchecked exception
	private void testThrowWithCatch() {
		System.out.println("testThrowWithCatch - START");

		try {
			if (isInvalidEmail("ssayed")) {
				// if thrown, the JVM will go to the corresponding catch block/ exception
				// handler in the call stack starting from the current method, if there is no
				// corresponding exception handler, the JVM will propagate to the default JVM
				// exception handler
				throw new IllegalArgumentException("Invalid Email");
			}
		} catch (IllegalArgumentException e) {
			System.err.println(e.getClass());
			System.err.println("Something went wrong:" + e.getMessage());
		}

		System.out.println("testThrowWithCatch - END");
	}

	private boolean isInvalidEmail(String email) {
		// just simple condition for testing purpose
		return email == null || !(email.contains("@"));
	}

	// set java argument -Xmx1m
	private void testOutOfMemoryException() {
		System.out.println("testOutOfMemoryException - START");
		System.out.println("Free memory:" + Runtime.getRuntime().freeMemory());

		// Method-Local Inner class for testing purpose
		class Student {
			private long id;
			private String name;

			Student(long id, String name) {
				this.id = id;
				this.name = name;
			}
		}

		try {
			// you will get the below exception in the array declaration before going to the
			// loop
			// java.lang.OutOfMemoryError: Requested array size exceeds VM limit
			// Student[] students = new Student[Integer.MAX_VALUE];

			Student[] students = new Student[100000];
			// with the below big loop, you will get the below error
			// java.lang.OutOfMemoryError: GC overhead limit exceeded
			for (int i = 0; i < Integer.MAX_VALUE; i++) {
				// System.out.println("Iteration# " + i + ", Free memory:" +
				// Runtime.getRuntime().freeMemory());
				students[i] = new Student(i, "Studend-" + i);
			}
		} catch (Error e) {
			e.printStackTrace();
			System.gc(); // call the garbage collection
		}

		System.out.println("testOutOfMemoryException - END");
	}

	private void testStackOverflowException() {
		System.out.println("testStackOverflowException - START");

		// testStackOverflowException(); // infinite recursion

		// lets test with small stack size
		// set java argument -Xss1m
		decreaseTillZero(8000);

		System.out.println("testStackOverflowException - END");
	}

	private void decreaseTillZero(long number) {
		try {
			if (number > 0) {
				decreaseTillZero(number - 1);
			} else {
				System.out.println("Reached Zero - EXIT");
			}
		} catch (Throwable e) {
			e.printStackTrace();
		}
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

		System.out.println("testTryWithResource - END");
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
			System.out.println("allow watching youtube");
		} catch (NumberFormatException e) {
			System.err.println(e.getClass() + ": Please enter valid age number");
		}

		System.out.println("testUncheckedExceptionPropagation - END");
	}

	// throws here is optional as it is unchecked exception
	private void validateAge(String ageAsString) /* [throws NumberFormatException] */ {
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
			fillExceptionHandlingObjectUsingReflection();
			System.out.println("serializing the object");
		} catch (ClassNotFoundException e) {
			System.err.println(e.getClass());
		}

		System.out.println("testCheckedExceptionPropagation - END");
	}

	// the below method/ any caller of the below method should handle the exception
	// or either propagate it till the main method then if main method didn't handle
	// it using try-catch, JVM will call the default exception handler
	private void fillExceptionHandlingObjectUsingReflection() throws ClassNotFoundException {
		Class<ExceptionHandling> obj = (Class<ExceptionHandling>) Class
				.forName("com.ssayed.javase.exceptionHandling.ExceptionHandling");
		// fill the object states
	}

	private void testUnrecoverableUncheckedException() {
		System.out.println("testUnrecoverableUncheckedException - START");
		String ageAsString = "abc"; // input from user

		try {
			Integer.parseInt(ageAsString);
			// can't continue executing the following code as long as the exception
			// unrecoverable
			System.out.println("validating the user age to vote");
		} catch (NumberFormatException e) {
			System.err.println(e.getClass() + ": please enter valid age number");
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
			System.err.println(e.getClass() + ": timeout value is not configured in DB");
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

	private void loadSystemConfiguration() /* throws FileNotFoundException */ {
		FileInputStream fis = null;

		try {
			File file = new File("C:\\Users\\Etisalat\\Desktop\\Study\\server1\\configuration.properties");

			// in the below line, the compiler will check if you handled the exception or
			// not, if not, will give you compilation error as the file may not there
			// you can specify/ declare it using throws declaration or handle ir try-catch
			// or try-with-resources
			fis = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			// you can get the file from other server (may be someone deleted it by mistake)
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
