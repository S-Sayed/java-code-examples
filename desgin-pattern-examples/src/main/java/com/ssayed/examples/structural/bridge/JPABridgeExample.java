package com.ssayed.examples.structural.bridge;

import com.ssayed.examples.structural.bridge.abstraction.jpa.JPA;
import com.ssayed.examples.structural.bridge.implementation.jpa.EclipseLink;
import com.ssayed.examples.structural.bridge.implementation.jpa.Hibernate;

public class JPABridgeExample {

	public static void main(String[] args) {
		JPA jpa = new JPA(new Hibernate());
		String url = jpa.findConfiguredValue("MY_EC2_URL");
		System.out.println("MY_EC2_URL: " + url);
		System.out.println();

		jpa = new JPA(new EclipseLink());
		String token = jpa.findConfiguredValue("MY_EC2_TOKEN");
		System.out.println("MY_EC2_TOKEN: " + token);
	}
}
