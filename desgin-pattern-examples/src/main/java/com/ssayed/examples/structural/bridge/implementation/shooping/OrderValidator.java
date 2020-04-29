package com.ssayed.examples.structural.bridge.implementation.shooping;

import com.ssayed.examples.structural.bridge.model.OrderDto;

public class OrderValidator implements OrderAction {
	private static final int MAX_QUANTITY = 3;

	@Override
	public void process(OrderDto orderDto) {
		System.out.println("|-------- Order Validator --------|");
		System.out.println("|---------------------------------|");

		// validation logic
		if (orderDto.getProducts().isEmpty()) {
			throw new IllegalArgumentException("Please add at least one product");
		}

		for (OrderDto.Product product : orderDto.getProducts()) {
			if (product.getQuantity() > MAX_QUANTITY) {
				throw new IllegalArgumentException("maximum 3 quantities are eligible of the same product");
			}
		}

		for (OrderDto.Product product : orderDto.getProducts()) {
			System.out.println(product.getQuantity() + " pieces of " + product.getName());
		}

		// ...
		System.out.println("Order Validator done successfully");
	}
}
