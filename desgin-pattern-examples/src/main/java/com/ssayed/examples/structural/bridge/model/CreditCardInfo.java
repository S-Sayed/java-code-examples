package com.ssayed.examples.structural.bridge.model;

public class CreditCardInfo {

	private String cardNo;
	private String holderName;
	private int code;
	private String expiryDateMMYY;

	public CreditCardInfo(String cardNo, String holderName, int code, String expiryDateMMYY) {
		this.cardNo = cardNo;
		this.holderName = holderName;
		this.code = code;
		this.expiryDateMMYY = expiryDateMMYY;
	}

	public String getCardNo() {
		return cardNo;
	}
}
