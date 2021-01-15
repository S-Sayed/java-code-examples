package com.ssayed.examples.behavioral.observer.builtinObserver;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

// concrete observer
public class AdsObserver implements Observer {

	@Override
	public void update(Observable o, Object arg) {
		User user = (User) o;
		if (user.isLoggedIn()) {
			user.setMatchedAds(new ArrayList<>());
			user.getMatchedAds().add("IPHONE 11");
		} else {
			user.setMatchedAds(null);
		}

		System.out.println("AdsObserver: " + user);
	}
}
