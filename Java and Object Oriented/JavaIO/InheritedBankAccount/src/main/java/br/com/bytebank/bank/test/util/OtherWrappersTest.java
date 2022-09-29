package br.com.bytebank.bank.test.util;

import java.util.ArrayList;
import java.util.List;

public class OtherWrappersTest {

	public static void main(String[] args) {
		Integer ageRef = Integer.valueOf(29); // Autoboxing
		System.out.println("ageRef converted to double: " + ageRef.doubleValue()); // 29.0 -> Unboxing

		Number number = Integer.valueOf(29);
		Number anotherNumber = Double.valueOf(42); // Implicit conversion of Integer to Double
		System.out.println("number: " + number); // 29
		System.out.println("anotherNumber: " + anotherNumber); // 42.0

		List<Number> list = new ArrayList<>();
		list.add(number); // Integer
		list.add(anotherNumber); // Double
	}

}
