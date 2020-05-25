package com.ssayed.examples.behavioral.chainOfResponsibility;

import java.io.IOException;
import java.io.InputStream;

//concrete handler
public class InternetAccessChecker extends NetworkProblemChecker {

	// you can create constructor to take a parameters from the client and work on
	// it while checking/ processing the request

	// checkNext can be at the begin/ middle/ end based on you business

	@Override
	public void check() {
		System.out.println("\n-----------------------");
		System.out.println("Check internet access by running a command 'PING www.google.com'");
		Process process = null;
		InputStream is = null;

		try {
			process = Runtime.getRuntime().exec("ping www.google.com");
			is = process.getInputStream();
			String result = "";
			int index = 0;
			boolean isInternetWorking = false;

			while ((index = is.read()) != -1) {
				result += (char) index;

				// System.out.println("result= " + result);
				if (result.contains("Reply from")) {
					isInternetWorking = true;
					break;
				}
			}

			// System.out.println("Result= " + result);

			if (!(isInternetWorking)) {
				System.out.println("Please contact the OS support team");
				return;
			}

			System.out.println("The Internet is working fine, please try now");
			checkNext();

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (process != null)
				process.destroy();

			if (is != null)
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
	}
}
