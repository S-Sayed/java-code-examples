package com.ssayed.examples.structural.bridge.abstraction.shopping;

import com.ssayed.examples.structural.bridge.implementation.shooping.OrderAction;
import com.ssayed.examples.structural.bridge.model.OrderDto;

public class ElectronicOrder implements OrderCheckout {
	private OrderAction step1;
	private OrderAction step2;

	public ElectronicOrder(OrderAction step1, OrderAction step2) {
		this.step1 = step1;
		this.step2 = step2;
	}

	@Override
	public boolean checkout(OrderDto orderDto) {
		this.step1.process(orderDto);
		this.step2.process(orderDto);
		return false;
	}
}
