package com.hyke.mobilesearch.exception;

import java.util.Map;

public class NoHandsetsFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public NoHandsetsFoundException(Map<String, String> criteria) {
		super("No handsets found for the following passed criteria " + criteria);
	}
}
