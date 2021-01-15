package com.ssayed.examples.behavioral.observer.fromScratch;

// observer interface
public interface Observer {
	<T> void update(T observable);
}
