package com.ssayed.examples.behavioral.chainOfResponsibility;

public class ChainOfResponsibilityExample {

	public static void main(String[] args) {
		// chain of handlers will be executed to process the network issue request
		// NetworkDriverChecker -> NetworkConnectivityChecker -> InternetAccessChecker
		NetworkProblemChecker networkDriverCheker = new NetworkDriverChecker();
		networkDriverCheker.linkToNextChecker(new NetworkConnectivityChecker())
				.linkToNextChecker(new InternetAccessChecker());

		networkDriverCheker.check();

		// another client can call the same chain but in different sequence
		// NetworkConnectivityChecker -> NetworkDriverChecker -> InternetAccessChecker
		NetworkProblemChecker networkConnectivityChecker = new NetworkConnectivityChecker();
		networkConnectivityChecker.linkToNextChecker(new NetworkDriverChecker())
				.linkToNextChecker(new InternetAccessChecker());

		networkConnectivityChecker.check();
	}
}