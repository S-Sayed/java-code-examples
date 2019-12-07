package com.ssayed.javase.java8features;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;

public class DateTimeFeaturesExample {

	public static void main(String[] args) {
		DateTimeFeaturesExample e = new DateTimeFeaturesExample();
		e.testLocalDate();
		e.testLocalTime();
		e.testLocalDateTime();
		e.testInstant();
		e.testUtilityMethods();
		e.testDateTimeFomrat();
		e.testDateTimeParsing();
		e.convertOldDateTimeToNewDateTime();
	}

	private void convertOldDateTimeToNewDateTime() {
		LocalDateTime newDateTime = LocalDateTime.ofInstant(new Date().toInstant(), ZoneId.of("Egypt"));
		System.out.println("newDateTime: " + newDateTime);
		// newDateTime: 2019-12-07T18:00:57.159
	}

	private void testDateTimeParsing() {
		System.out.println("Parse String to LocalDateTime Object: "
				+ LocalDateTime.parse("21::07::2019 13:30:20", DateTimeFormatter.ofPattern("d::MM::yyyy HH:mm:ss")));

		// Parse String to LocalDateTime Object: 2019-07-21T13:30:20
	}

	private void testDateTimeFomrat() {
		System.out.println(
				"Specific format - Local Date: " + LocalDate.now().format(DateTimeFormatter.ofPattern("d//MMM//uuuu")));

		System.out.println("Specific format - LocalDateTime: "
				+ LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd::MMM::yyyy HH::mm::ss")));

		// Specific format - Local Date7//Dec//2019
		// Specific format - LocalDateTime07::Dec::2019 19::49::29
	}

	private void testUtilityMethods() {
		LocalDate today = LocalDate.now();
		System.out.println("This year: " + today.getYear() + ", Month: " + today.getMonth() + ", Day of Month: "
				+ today.getDayOfMonth());

		// isBefore, isAfter
		System.out.println("is today after 1990/JAN/07: " + today.isAfter(LocalDate.of(2017, Month.JANUARY, 7)));

		LocalDateTime dt = today.atTime(LocalTime.now());
		System.out.println("Create LocalDateTime to LocalDate : " + dt);

		System.out.println("today + 3 days: " + today.plusDays(3));
		System.out.println("today + 3 months: " + today.plusMonths(3));
		System.out.println("today + 3 weeks: " + today.plusWeeks(3));

		System.out.println("today - 3 days: " + today.minusDays(3));
		System.out.println("today - 3 months: " + today.minusMonths(3));
		System.out.println("today - 3 weeks: " + today.minusWeeks(3));

		System.out.println("First day of the current month: " + today.with(TemporalAdjusters.firstDayOfMonth()));
		System.out.println(
				"Period Format from now till 6 March 2020 : " + today.until(LocalDate.of(2020, Month.MARCH, 6)));

		System.out.println("minus 1Y 1M 1D from today: " + today.minus(Period.of(1, 1, 1)));

		// This year: 2019, Month: DECEMBER, Day of Month: 7
		// is today after 1990/JAN/07: true
		// Create LocalDateTime to LocalDate : 2019-12-07T19:35:55.938
		// today + 3 days: 2019-12-10
		// today + 3 months: 2020-03-07
		// today + 3 weeks: 2019-12-28
		// today - 3 days: 2019-12-04
		// today - 3 months: 2019-09-07
		// today - 3 weeks: 2019-11-16
		// First day of the current month: 2019-12-01
		// Period Format from now till 6 March 2020 : P2M28D
		// minus 1Y 1M 1D from today: 2018-11-06
	}

	private void testInstant() {
		System.out.println("Current Timestamp: " + Instant.now());
		// Current Timestamp: 2019-12-07T15:14:38.544Z
	}

	private void testLocalDateTime() {
		System.out.println("Current DateTime: " + LocalDateTime.now());
		System.out.println("Current DateTime: " + LocalDateTime.of(LocalDate.now(), LocalTime.now()));
		System.out.println("Specifi DateTime: " + LocalDateTime.of(2019, Month.JULY, 21, 13, 30, 20));
		System.out.println("Current DateTime: " + LocalDateTime.now(ZoneId.of("Africa/Cairo")));

		// Current DateTime: 2019-12-07T18:39:30.149
		// Current DateTime: 2019-12-07T18:39:30.149
		// Specifi DateTime: 2019-07-21T13:30:20
		// Current DateTime: 2019-12-07T16:39:30.149
	}

	private void testLocalTime() {
		System.out.println("Current Time: " + LocalTime.now());
		System.out.println("Specific Time: " + LocalTime.of(13, 30, 01));
		System.out.println("Specific Time - with nano-seconds: " + LocalTime.of(13, 30, 01, 40));
		System.out.println("Current Time - Cairo Zone: " + LocalTime.now(ZoneId.of("Africa/Cairo")));

		// Current Time: 18:33:41.691
		// Specific Time: 13:30:01
		// Specific Time - with nano-seconds: 13:30:01.000000040
		// Current Time - Cairo Zone: 16:33:41.691
	}

	private void testLocalDate() {
		System.out.println("Current Date: " + LocalDate.now());
		System.out.println("Specific Date - Month value: " + LocalDate.of(2019, 07, 21));
		System.out.println("Specific Date - Month Enum: " + LocalDate.of(2019, Month.JULY, 21));
		System.out.println("Current Date - Cairo Zone: " + LocalDate.now(ZoneId.of("Africa/Cairo")));

		// Current Date: 2019-12-07
		// Specific Date - Month value: 2019-07-21
		// Specific Date - Month Enum: 2019-07-21
		// Current Date - Cairo Zone: 2019-12-07
	}
}
