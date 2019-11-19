package com.mockito.example.model;

import java.io.Serializable;

public class Customer implements Serializable {
	private static final long serialVersionUID = 1L;
	int id;
	String name;

	public Customer() {
	}

	public Customer(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	@Override
	public boolean equals(Object obj) {
		Customer customerObj = (Customer) obj;
		return this.name.equals(customerObj.name) && this.id == customerObj.id;
	}

}
