package com.ssayed.examples.structural.bridge.implementation.jpa;

public class Hibernate implements JPAImplementor {

	@Override
	public String find(String key) {
		System.out.println("|----- Find By Hibernate -----|");
		System.out.println("|-----------------------------|");
		return GlobalDBConfiguration.getInstance().getGlobalDBConfigurationMap().get(key);
	}
}