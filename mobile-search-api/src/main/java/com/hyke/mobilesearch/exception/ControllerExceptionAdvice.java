package com.hyke.mobilesearch.exception;

import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.hyke.mobilesearch.constant.DateTimeFormatEnum;
import com.hyke.mobilesearch.util.DateTimeUtil;

@ControllerAdvice
public class ControllerExceptionAdvice {
	private final static Logger LOGGER = LoggerFactory.getLogger(ControllerExceptionAdvice.class);

	@ExceptionHandler(value = { NoHandsetsFoundException.class })
	public ResponseEntity<ErrorMessage> handleNoHandsetFoundException(NoHandsetsFoundException ex) {
		LOGGER.error("handleNoHandsetFoundException - exception: ", ex);

		ErrorMessage errorMeg = new ErrorMessage(HttpStatus.NOT_FOUND.value(),
				DateTimeUtil.formatDateTime(LocalDateTime.now(), DateTimeFormatEnum.YYYY_MM_DD_HH_MM_SS),
				ex.getMessage());

		return new ResponseEntity<ErrorMessage>(errorMeg, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(value = { Exception.class })
	public ResponseEntity<ErrorMessage> handleGeneralException(Exception ex) {
		LOGGER.error("handleGeneralException - exception: ", ex);

		ErrorMessage errorMeg = new ErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR.value(),
				DateTimeUtil.formatDateTime(LocalDateTime.now(), DateTimeFormatEnum.YYYY_MM_DD_HH_MM_SS),
				"Something went wrong");

		return new ResponseEntity<ErrorMessage>(errorMeg, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}