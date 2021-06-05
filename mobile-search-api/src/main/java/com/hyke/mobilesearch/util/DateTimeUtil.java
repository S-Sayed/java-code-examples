package com.hyke.mobilesearch.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.hyke.mobilesearch.constant.DateTimeFormatEnum;

public class DateTimeUtil {
	public static String formatDateTime(LocalDateTime dateTime, DateTimeFormatEnum dateTimeFormatEnum) {
		if (dateTime == null || dateTimeFormatEnum == null)
			return "";

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(dateTimeFormatEnum.getFormat());
		return dateTime.format(formatter);
	}
}