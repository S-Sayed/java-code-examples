package com.ssayed.examples.structural.bridge;

import com.ssayed.examples.structural.bridge.abstraction.shopping.ElectronicOrder;
import com.ssayed.examples.structural.bridge.abstraction.shopping.OrderCheckout;
import com.ssayed.examples.structural.bridge.implementation.shooping.OrderPayment;
import com.ssayed.examples.structural.bridge.implementation.shooping.OrderValidator;
import com.ssayed.examples.structural.bridge.model.CreditCardInfo;
import com.ssayed.examples.structural.bridge.model.OrderDto;

public class ShoppingBridgeExample {

	public static void main(String[] args) {

		OrderCheckout orderCheckout = new ElectronicOrder(new OrderValidator(), new OrderPayment());
		OrderDto orderDto = new OrderDto();
		System.out.println("****** Invalid Order Test ********");
		try {
			orderCheckout.checkout(orderDto);
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("****** Invalid Max Quantity Test ********");
		orderDto.getProducts().add(new OrderDto.Product(1, "Samsung Smart TV", 5));
		try {
			orderCheckout.checkout(orderDto);
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("****** Invalid Credit Card Info Test ********");
		orderDto.getProducts().clear();
		orderDto.getProducts().add(new OrderDto.Product(1, "Samsung Smart TV", 1));
		try {
			orderCheckout.checkout(orderDto);
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("****** Invalid Credit Card no Test ********");
		orderDto.getProducts().clear();
		orderDto.getProducts().add(new OrderDto.Product(1, "Samsung Smart TV", 1));
		orderDto.setCreditCardInfo(new CreditCardInfo("123456123456", "Sameh", 123, "0420"));

		try {
			orderCheckout.checkout(orderDto);
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("****** valid Test Case ********");
		orderDto.getProducts().clear();
		orderDto.getProducts().add(new OrderDto.Product(1, "Samsung Smart TV", 1));
		orderDto.getProducts().add(new OrderDto.Product(2, "Iphone 6s Plus", 2));
		orderDto.getProducts().add(new OrderDto.Product(3, "Dell Laptop", 1));
		orderDto.setCreditCardInfo(new CreditCardInfo("987654321", "Sameh", 123, "0420"));

		try {
			orderCheckout.checkout(orderDto);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
