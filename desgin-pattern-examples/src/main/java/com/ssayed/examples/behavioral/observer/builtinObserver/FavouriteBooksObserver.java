package com.ssayed.examples.behavioral.observer.builtinObserver;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

// concrete observer
public class FavouriteBooksObserver implements Observer {

	@Override
	public void update(Observable o, Object arg) {
		User user = (User) o;

		if (user.isLoggedIn()) {
			user.setFavouriteBooks(new ArrayList<>());
			user.getFavouriteBooks().add("Head First Design Patterns");
		} else {
			user.setFavouriteBooks(null);
		}

		System.out.println("FavouriteBooksObserver: " + user);
	}
}
