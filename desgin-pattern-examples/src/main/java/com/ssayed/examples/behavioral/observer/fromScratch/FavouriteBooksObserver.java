package com.ssayed.examples.behavioral.observer.fromScratch;

import java.util.ArrayList;

// concrete observer
public class FavouriteBooksObserver implements Observer {

	@Override
	public <T> void update(T observable) {
		User user = (User) observable;

		if (user.isLoggedIn()) {
			user.setFavouriteBooks(new ArrayList<>());
			user.getFavouriteBooks().add("Head First Design Patterns");
		} else {
			user.setFavouriteBooks(null);
		}

		System.out.println("FavouriteBooksObserver: " + user);
	}
}
