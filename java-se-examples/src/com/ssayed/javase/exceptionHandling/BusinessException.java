package com.ssayed.javase.exceptionHandling;

public class BusinessException extends RuntimeException {
	private ErrorCode errorCode;

	public BusinessException(ErrorCode errorCode) {
		super();
		this.errorCode = errorCode;
	}

	public BusinessException(String message) {
		super(message);
	}

	public ErrorCode getErrorCode() {
		return this.errorCode;
	}
}

enum ErrorCode {
	USER_ID_EXIST, EMAIL_INVALID, EMAIL_EXIST, AGE_NOT_ALLOWED, GENEAL_ERROR;
}