package com.ssayed.examples.behavioral.observer.fromScratch;

import java.util.ArrayList;

// concrete observer
public class AdsObserver implements Observer {

	@Override
	public <T> void update(T observable) {
		User user = (User) observable;

		if (user.isLoggedIn()) {
			user.setMatchedAds(new ArrayList<>());
			user.getMatchedAds().add("IPHONE 11");
		} else {
			user.setMatchedAds(null);
		}

		System.out.println("AdsObserver: " + user);
	}
}
