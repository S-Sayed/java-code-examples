package com.ssayed.examples.structural.bridge.model;

import java.util.ArrayList;
import java.util.List;

public class OrderDto {

	private List<Product> products = null;
	private CreditCardInfo creditCardInfo;

	public List<Product> getProducts() {
		if (products == null)
			products = new ArrayList<>();
		return products;
	}

	public CreditCardInfo getCreditCardInfo() {
		return creditCardInfo;
	}

	public void setCreditCardInfo(CreditCardInfo creditCardInfo) {
		this.creditCardInfo = creditCardInfo;
	}

	public static class Product {
		private long id;
		private String name;
		private int quantity;

		public Product(long id, String name, int quantity) {
			this.id = id;
			this.name = name;
			this.quantity = quantity;
		}

		public String getName() {
			return name;
		}

		public int getQuantity() {
			return quantity;
		}
	}
}
