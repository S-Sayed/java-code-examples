package com.ssayed.examples.behavioral.observer.fromScratch;

// client
public class ObserverPatternExample {

	public static void main(String[] args) {

		User user = new User();
		Observer adsObserver = new AdsObserver();
		user.getEventManager().subscribe(user, adsObserver);
		Observer favouriteBooksObserver = new FavouriteBooksObserver();
		user.getEventManager().subscribe(user, favouriteBooksObserver);

		System.out.println("|------- LoggedIn=true ---------|");
		user.setLoggedIn(true);

		System.out.println("\n|------- LoggedIn=false ---------|");
		user.setLoggedIn(false);

		user.getEventManager().unsubscribe(user, favouriteBooksObserver);
		System.out.println("\n|------- LoggedIn=true ---------|");
		user.setLoggedIn(true);
	}
}
