package com.ssayed.examples.creational.abstractFactoryPattern;

public interface AccountSearch {
	Object search(String value);
}

class SearchByAccountId implements AccountSearch {

	public Object search(String value) {
		System.out.println("Search by [Account] type - [Account Id] sub-type  where value = " + value);
		return "";
	}
}

class SearchByAccountNo implements AccountSearch {

	public Object search(String value) {
		System.out.println("Search by [Account] type - [Account No.] sub-type  where value = " + value);
		return "";
	}
}
