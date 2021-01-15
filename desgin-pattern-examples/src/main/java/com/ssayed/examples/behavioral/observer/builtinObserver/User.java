package com.ssayed.examples.behavioral.observer.builtinObserver;

import java.util.List;
import java.util.Observable;

// publisher or subject or observable
public class User extends Observable {
	private boolean isLoggedIn;
	private List<String> matchedAds;
	private List<String> favouriteBooks;

	public boolean isLoggedIn() {
		return isLoggedIn;
	}

	public void setLoggedIn(boolean isLoggedIn) {
		this.isLoggedIn = isLoggedIn;
		setChanged();
		notifyObservers(this);
	}

	public List<String> getMatchedAds() {
		return matchedAds;
	}

	public void setMatchedAds(List<String> matchedAds) {
		this.matchedAds = matchedAds;
	}

	public List<String> getFavouriteBooks() {
		return favouriteBooks;
	}

	public void setFavouriteBooks(List<String> favouriteBooks) {
		this.favouriteBooks = favouriteBooks;
	}

	@Override
	public String toString() {
		return "User [isLoggedIn=" + isLoggedIn + ", matchedAds=" + matchedAds + ", favouriteBooks=" + favouriteBooks
				+ "]";
	}
}
