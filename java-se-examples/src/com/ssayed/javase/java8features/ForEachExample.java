package com.ssayed.javase.java8features;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

public class ForEachExample {

	public static void main(String[] args) {
		ForEachExample t = new ForEachExample();
		t.testForEach();
	}

	private void testForEach() {
		// Before Java 8
		List<String> l = new ArrayList<>();
		l.add("Sila");
		l.add("Adam");
		l.add("Sameh");

		System.out.println("Using Iterator Before Java8");
		Iterator<String> i = l.iterator();
		while (i.hasNext()) {
			System.out.println(i.next());
		}

		System.out.println("Using ForEach with anonymous class In Java8");
		// using forEach with anonymous class
		l.forEach(new Consumer<String>() {
			@Override
			public void accept(String name) {
				System.out.println(name);
			}

		});

		System.out.println("Using ForEach with consumer implementation In Java8");
		// using forEach with consumer implementation
		l.forEach(new Student());
	}

}

// consumer implementation that can be reused
class Student implements Consumer<String> {
	@Override
	public void accept(String name) {
		System.out.println(name);
	}
}