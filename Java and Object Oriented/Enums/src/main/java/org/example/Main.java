package org.example;

import java.sql.SQLOutput;

public class Main {
	public static void main(String[] args) {

		Priority minPriority = Priority.MIN;
		Priority normalPriority = Priority.NORMAL;
		Priority maxPriority = Priority.MAX;

		System.out.println(minPriority.name());     // MIN
		System.out.println(minPriority.ordinal());  // 0 -> The position of the Enum
		System.out.println(minPriority.getValue()); // 1  -> The value inserted in the Enum

		System.out.println(normalPriority.name());     // NORMAL
		System.out.println(normalPriority.ordinal());  // 1 -> The position of the Enum
		System.out.println(normalPriority.getValue()); // 5  -> The value inserted in the Enum

		System.out.println(maxPriority.name());     // MAX
		System.out.println(maxPriority.ordinal());  // 2 -> The position of the Enum
		System.out.println(maxPriority.getValue()); // 10 -> The value inserted in the Enum
	}

}
/*
 * https://docs.oracle.com/javase/tutorial/java/javaOO/enum.html
 *
 * Any slightly more sophisticated application needs to use some constants.
 * Classic examples are the days of the week or the months of the year, the button state (on/off) or some colors.
 * Enums are an object-oriented way of dealing with constants that the Java language introduced starting with version 5.
 */