package br.com.alura.java8.test;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class StringSort {

	public static void main(String[] args) {
		List<String> words = new ArrayList<String>();
		words.add("one word"); // length() = 8
		words.add("another word"); // length() = 12
		words.add("other words"); // length() = 11

		words.sort((string, anotherString) -> Integer.compare(string.length(), anotherString.length()));
		System.out.println(words); // [one word, other words, another word]

		words.forEach(string -> System.out.println(string));
		/*
		 * one word
		 * other words
		 * another word
		 */

//		Simplifications and method references
		words.sort(Comparator.comparing(string -> string.length())); // same as line 15
		words.sort(Comparator.comparing(String::length)); // same as line 25

		words.forEach(System.out::println); // same as line 18
		/*
		 * one word
		 * other words
		 * another word
		 */

//		Changing the order
		System.out.println("-> Changing to CASE_INSENSITIVE_ORDER");
		words.sort(String.CASE_INSENSITIVE_ORDER);
		words.forEach(System.out::println);
		/*
		 * another word
		 * one word
		 * other words
		 */
	}

}
