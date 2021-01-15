package com.ssayed.examples.behavioral.observer.fromScratch;

import java.util.List;

// publisher or subject or observable
public class User {
	private boolean isLoggedIn;
	private List<String> matchedAds;
	private List<String> favouriteBooks;

	private EventManager<User> eventManager = new EventManager<User>(this);

	public boolean isLoggedIn() {
		return isLoggedIn;
	}

	public void setLoggedIn(boolean isLoggedIn) {
		this.isLoggedIn = isLoggedIn;
		eventManager.notify(this);
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

	public EventManager<User> getEventManager() {
		return eventManager;
	}

	@Override
	public String toString() {
		return "User [isLoggedIn=" + isLoggedIn + ", matchedAds=" + matchedAds + ", favouriteBooks=" + favouriteBooks
				+ "]";
	}
}
