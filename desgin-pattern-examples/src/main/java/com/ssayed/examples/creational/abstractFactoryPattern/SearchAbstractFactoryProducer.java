package com.ssayed.examples.creational.abstractFactoryPattern;

public class SearchAbstractFactoryProducer {
	static SearchAbstractFactory getSearchFactory(String type) {
		switch (type) {
		case "ACCOUNT":
			return new AccountSearchFactory();
		case "ORDER":
			return new OrderSearchFactory();
		}
		return null;
	}
}

interface SearchAbstractFactory {
	AccountSearch getAccountSearchFactory(String type);

	OrderSearch getOrderSearchFactory(String type);
}

class AccountSearchFactory implements SearchAbstractFactory {

	public AccountSearch getAccountSearchFactory(String type) {
		switch (type) {
		case "ACCOUNT_ID":
			return new SearchByAccountId();
		case "ACCOUNT_NO":
			return new SearchByAccountNo();
		}
		return null;
	}

	// the below break ISP (Interface Segregation Principle)
	@Override
	public OrderSearch getOrderSearchFactory(String type) {
		return null;
	}

}

class OrderSearchFactory implements SearchAbstractFactory {

	public OrderSearch getOrderSearchFactory(String type) {
		switch (type) {
		case "REQUEST_ID":
			return new SearchByRequestId();
		case "SUBREQUEST_NO":
			return new SearchBySubRequestNo();
		}
		return null;
	}

	// the below break ISP (Interface Segregation Principle)
	@Override
	public AccountSearch getAccountSearchFactory(String type) {
		return null;
	}
}