package br.com.alura.java8.test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;

public class DateTests {

	public static void main(String[] args) {
		LocalDate today = LocalDate.now(); // 2022-10-13
		System.out.println(today);

		LocalDate footbalWorldCup = LocalDate.of(2022, Month.NOVEMBER, 20);
		Integer years = footbalWorldCup.getYear() - today.getYear();
		System.out.println(years); // 0 (2022 - 2022)

		Period period = Period.between(today, footbalWorldCup);
		System.out.println(period); // P1M7D
		System.out.println(period.getDays()); // 7 (20 - 13)
		System.out.println(period.getMonths()); // 1 (11 - 10)
		System.out.println(period.getYears()); // 0 (2022 - 2022)
		System.out.println(period); // P1M7D

		System.out.println(footbalWorldCup.minusDays(300)); // 2022-01-24
		System.out.println(footbalWorldCup.minusMonths(3)); // 2022-08-20
		System.out.println(footbalWorldCup.minusYears(2)); // 2020-11-20

		System.out.println(footbalWorldCup.plusDays(300)); // 2023-09-16
		System.out.println(footbalWorldCup.plusMonths(3)); // 2023-02-20
		System.out.println(footbalWorldCup.plusYears(2)); // 2024-11-20

		System.out.println(footbalWorldCup); // 2022-11-20 (immutable value)

		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		System.out.println(footbalWorldCup.format(dateTimeFormatter)); // 20/11/2022

		DateTimeFormatter anotherDateTimeFormatter = DateTimeFormatter.ISO_LOCAL_DATE;
		System.out.println(footbalWorldCup.format(anotherDateTimeFormatter)); // 2022-11-20

		LocalDateTime now = LocalDateTime.now();
		System.out.println(now); // 2022-10-13T14:27:33.544514800
		System.out.println(now.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME)); // 2022-10-13T14:27:33.5445148

		DateTimeFormatter yetAnotherDateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm");
		System.out.println(now.format(yetAnotherDateTimeFormatter)); // 13/10/2022 02:34

		YearMonth thisMonth = YearMonth.now();
		System.out.println(thisMonth); // 2022-10

		LocalTime breakTime = LocalTime.of(15, 30);
		System.out.println(breakTime); // 15:30
		System.out.println(breakTime.getMinute()); // 30
	}

}
