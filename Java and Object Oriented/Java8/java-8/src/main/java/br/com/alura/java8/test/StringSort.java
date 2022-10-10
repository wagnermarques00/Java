package br.com.alura.java8.test;

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
	}

}
