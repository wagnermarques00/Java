package br.com.alura.collections.test.performance;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

public class ComparingArrayListHashSet {

	public static void main(String[] args) {
//		Testing performance of ArrayList
		Collection<Integer> arrayNumbers = new ArrayList<Integer>();
		long arrayStart = System.currentTimeMillis();

		for(int i = 0; i <= 50000; i++) {
			arrayNumbers.add(i);
		}

		for(Integer number: arrayNumbers) {
			arrayNumbers.contains(number);
		}

		long arrayEnd = System.currentTimeMillis();
		long arrayRuntime = arrayEnd - arrayStart;

		System.out.println("Time spent in Arraylist: " + arrayRuntime + " ms");

//		Testing performance of HashSet
		Collection<Integer> hashsetNumbers = new HashSet<>();
		long hashsetStart = System.currentTimeMillis();

		for(int i = 0; i <= 50000; i++) {
			hashsetNumbers.add(i);
		}

		for(Integer number: hashsetNumbers) {
			hashsetNumbers.contains(number);
		}

		long hashsetEnd = System.currentTimeMillis();
		long hashsetRuntime = hashsetEnd - hashsetStart;

		System.out.println("Time spent in HashSet: " + hashsetRuntime + " ms");
	}

}

/*
 * Time spent in Arraylist: 774 ms
 * Time spent in HashSet: 7 ms
 */
