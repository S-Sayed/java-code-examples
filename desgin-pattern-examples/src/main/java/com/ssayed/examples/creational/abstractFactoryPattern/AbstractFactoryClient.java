package com.ssayed.examples.creational.abstractFactoryPattern;

public class AbstractFactoryClient {

	public static void main(String[] args) {
		SearchAbstractFactoryProducer.getSearchFactory("ACCOUNT")
				.getAccountSearchFactory("ACCOUNT_ID").search("123");

		SearchAbstractFactoryProducer.getSearchFactory("ACCOUNT")
				.getAccountSearchFactory("ACCOUNT_NO").search("1234");

		SearchAbstractFactoryProducer.getSearchFactory("ORDER").getOrderSearchFactory("REQUEST_ID")
				.search("12345");

		SearchAbstractFactoryProducer.getSearchFactory("ORDER")
				.getOrderSearchFactory("SUBREQUEST_NO").search("123456");
	}
}
