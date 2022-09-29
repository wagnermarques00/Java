package br.com.bytebank.bank.test.util;

import java.util.ArrayList;
import java.util.List;

public class IntegerWrapperTest {

	public static void main(String[] args) {
		Integer ageRef = 29;
		List<Integer> numbers = new ArrayList<>();
		numbers.add(ageRef); // Autoboxing

		String s = "10"; // Yes, this is a string
		Integer number = Integer.valueOf(s); // Convert to Integer -> Autoboxing
		int parsed = Integer.parseInt(s);    // Convert to int     -> Unboxing
		Integer sum = number + parsed;
		System.out.println("number + parsed: " + sum); // 20
		System.out.println("sum converted to double: " + sum.doubleValue()); // 20.0

		// Just for knowledge
		System.out.println("Integer max value: " + Integer.MAX_VALUE); 	//  2147483647
		System.out.println("Integer min value: " + Integer.MIN_VALUE); 	// -2147483648
		System.out.println("Integer size(bits): " + Integer.SIZE); 		// 32
		System.out.println("Integer size(bytes): " + Integer.BYTES);	// 4
	}

}
