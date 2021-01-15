package com.ssayed.examples.behavioral.observer.fromScratch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// event manager
public class EventManager<T> {
	private Map<T, List<Observer>> observers = new HashMap<>();

	public EventManager(T observable) {
		observers.put(observable, new ArrayList<>());
	}

	public void subscribe(T observable, Observer observer) {
		observers.get(observable).add(observer);
	}

	public void unsubscribe(T observable, Observer observer) {
		observers.get(observable).remove(observer);
	}

	public void notify(T observable) {

		for (Observer observer : observers.get(observable)) {
			observer.update(observable);
		}
	}
}
