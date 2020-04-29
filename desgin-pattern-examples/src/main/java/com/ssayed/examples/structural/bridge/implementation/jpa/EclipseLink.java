package com.ssayed.examples.structural.bridge.implementation.jpa;

public class EclipseLink implements JPAImplementor {
	@Override
	public String find(String key) {
		System.out.println("|----- Find By EclipseLink -----|");
		System.out.println("|-------------------------------|");
		return GlobalDBConfiguration.getInstance().getGlobalDBConfigurationMap().get(key);
	}
}