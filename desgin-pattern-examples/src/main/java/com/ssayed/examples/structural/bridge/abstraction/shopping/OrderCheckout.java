package com.ssayed.examples.structural.bridge.abstraction.shopping;

import com.ssayed.examples.structural.bridge.model.OrderDto;

public interface OrderCheckout {
	boolean checkout(OrderDto orderDto);
}