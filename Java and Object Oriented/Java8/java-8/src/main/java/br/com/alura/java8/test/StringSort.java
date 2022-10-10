package br.com.alura.java8.test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

public class StringSort {

	public static void main(String[] args) {
		List<String> words = new ArrayList<String>();
		words.add("one word"); // length() = 8
		words.add("another word"); // length() = 12
		words.add("other words"); // length() = 11

		Comparator<String> comparator = new ComparingBySize();
		words.sort(comparator);
		System.out.println(words); // [one word, other words, another word]
		System.out.println("other words".length());

		Consumer<String> consumer = new PrintOnLine();
		words.forEach(consumer);
		/*
		 * one word
		 * other words
		 * another word
		 */
	}

}

class PrintOnLine implements Consumer<String> {

	@Override
	public void accept(String string) {
		System.out.println(string);
	}
}

class ComparingBySize implements Comparator<String> {

	@Override
	public int compare(String string, String anotherString) {
		return Integer.compare(string.length(), anotherString.length());
	}
}
