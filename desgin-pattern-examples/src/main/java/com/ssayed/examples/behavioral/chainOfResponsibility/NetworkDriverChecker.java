package com.ssayed.examples.behavioral.chainOfResponsibility;

// concrete handler
public class NetworkDriverChecker extends NetworkProblemChecker {

	// you can create constructor to take a parameters from the client and work on
	// it while checking/ processing the request

	// checkNext can be at the begin/ middle/ end based on you business

	@Override
	public void check() {
		System.out.println("\n-----------------------");
		System.out.println("Check if the network driver is installed properly");

		boolean isNetworkDriverInstalled = true; // just mocked value
		if (!(isNetworkDriverInstalled)) {
			System.out.println("Network driver is not installed properly, please install it");
			Thread.currentThread().stop();
			return;
		}

		System.out.println("Network driver has been installed properly");
		checkNext();
	}
}
