package com.ssayed.examples.creational.abstractFactoryPattern;

public interface OrderSearch {
	Object search(String value);
}

class SearchByRequestId implements OrderSearch {

	public Object search(String value) {
		System.out.println("Search by [Order] type - [Request Id] sub-type where value = " + value);
		return "";
	}
}

class SearchBySubRequestNo implements OrderSearch {

	public Object search(String value) {
		System.out.println("Search by [Order] type - [Sub-Request No.] sub-type where value = " + value);
		return "";
	}
}
