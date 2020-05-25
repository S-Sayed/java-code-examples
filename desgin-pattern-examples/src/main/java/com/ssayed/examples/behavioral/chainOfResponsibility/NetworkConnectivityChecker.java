package com.ssayed.examples.behavioral.chainOfResponsibility;

//concrete handler
public class NetworkConnectivityChecker extends NetworkProblemChecker {

	// you can create constructor to take a parameters from the client and work on
	// it while checking/ processing the request

	// checkNext can be at the begin/ middle/ end based on you business

	@Override
	public void check() {
		System.out.println("\n-----------------------");
		System.out.println("Check if there is a netowrk connected to the device");

		boolean isNetworkConnected = true; // just mocked value
		if (!(isNetworkConnected)) {
			System.out.println("No network connected, please connect to the network using cable/ WIFI");
			return;
		}

		System.out.println("Network has been connected successfully");
		checkNext();
	}
}
