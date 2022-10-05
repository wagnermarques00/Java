package br.com.alura.collections.test.performance;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ComparingArrayListLinkedList {

	public static void main(String[] args) {
		System.out.println("**** ArrayList vs LinkedList ***");

		List<Integer> arrayListNumbers = new ArrayList<>();
		List<Integer> linkedListNumbers = new LinkedList<>();
		int numberOfElements = 1000000;

		long timeArrayList = insertElementsInto(arrayListNumbers, numberOfElements);
		long timeLinkedList = insertElementsInto(linkedListNumbers, numberOfElements);

		System.out.println("Insertion into ArrayList took  " + timeArrayList);
		System.out.println("Insertion into LinkedList took " + timeLinkedList);

		timeArrayList = removeFirstElements(arrayListNumbers);
		timeLinkedList = removeFirstElements(linkedListNumbers);

		System.out.println("Removing ArrayList took  " + timeArrayList);
		System.out.println("Removing LinkedList took " + timeLinkedList);
	}

	private static long insertElementsInto(List<Integer> numbers, int quantity) {
		long start = System.currentTimeMillis();
		for(int i = 0; i < quantity; i++) {
			numbers.add(i);
		}
		long end = System.currentTimeMillis();
		return end - start;
	}

	/*
	 * removing 100 elements always in the first position
	 */
	private static long removeFirstElements(List<Integer> numbers) {
		long start = System.currentTimeMillis();

		for(int i = 0; i < 100; i++) {
			numbers.remove(0); // always removing the first element
		}
		long end = System.currentTimeMillis();
		return end - start;
	}

}

/*
 * **** ArrayList vs LinkedList ***
 * Insertion into ArrayList took  22
 * Insertion into LinkedList took 105
 * Removing ArrayList took  61
 * Removing LinkedList took 0
 */
