package com.ssayed.examples.structural.bridge.abstraction.jpa;

import com.ssayed.examples.structural.bridge.implementation.jpa.JPAImplementor;

public class JPA {
	JPAImplementor jpaImplementor;

	public JPA(JPAImplementor jpaImplementor) {
		this.jpaImplementor = jpaImplementor;
	}

	public String findConfiguredValue(String key) {
		return jpaImplementor.find(key);
	}
}