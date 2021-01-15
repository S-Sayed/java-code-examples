package com.ssayed.examples.behavioral.observer.builtinObserver;

import java.util.Observer;

public class ObserverPatternExample {

	public static void main(String[] args) {
		User user = new User();

		Observer adsObserver = new AdsObserver();
		user.addObserver(adsObserver);

		Observer favouriteBooksObserver = new FavouriteBooksObserver();
		user.addObserver(favouriteBooksObserver);

		System.out.println("No of observers = " + user.countObservers());

		System.out.println("\n|------- LoggedIn=true ---------|");
		user.setLoggedIn(true);

		System.out.println("\n|------- LoggedIn=false ---------|");
		user.setLoggedIn(false);

		user.deleteObserver(favouriteBooksObserver);
		System.out.println("\n|------- LoggedIn=true ---------|");
		System.out.println("No of observers = " + user.countObservers());
		user.setLoggedIn(true);
	}
}
