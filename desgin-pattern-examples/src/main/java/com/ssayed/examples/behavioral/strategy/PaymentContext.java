package com.ssayed.examples.behavioral.strategy;

// context
public class PaymentContext {
	private PaymentStrategy paymentStrategy;

	public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
		this.paymentStrategy = paymentStrategy;
	}

	public boolean pay(double amount) {
		return paymentStrategy.pay(amount);
	}
}
