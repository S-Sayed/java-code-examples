package com.ssayed.examples.behavioral.chainOfResponsibility;

// common interface for all handlers
public abstract class NetworkProblemChecker {
	private NetworkProblemChecker next;

	public NetworkProblemChecker linkToNextChecker(NetworkProblemChecker nextChecker) {
		this.next = nextChecker;
		return next;
	}

	abstract void check();

	public void checkNext() {
		if (next == null)
			return;

		next.check();
	}
}
