package com.ssayed.examples.structural.bridge.implementation.shooping;

import com.ssayed.examples.structural.bridge.model.OrderDto;

public class OrderPayment implements OrderAction {

	@Override
	public void process(OrderDto orderDto) {

		System.out.println("|-------- Order Payment --------|");
		System.out.println("|-------------------------------|");
		// payment logic

		if (orderDto.getCreditCardInfo() == null) {
			throw new IllegalArgumentException("Please add payment credit card info");
		}

		if (orderDto.getCreditCardInfo().getCardNo().endsWith("123456")) {
			throw new IllegalArgumentException("Please add valid credit card number");
		}

		// ...
		System.out.println("Order Payment done successfully, shop with us again");
	}
}
