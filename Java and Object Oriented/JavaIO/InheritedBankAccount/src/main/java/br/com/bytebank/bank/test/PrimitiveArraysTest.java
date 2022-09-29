package br.com.bytebank.bank.test;

public class PrimitiveArraysTest {
	// Array []
	public static void main(String[] args) {
		int[] ages = new int[5];
		ages[0] = 29;
		ages[1] = 30;
		ages[2] = 41;
		ages[3] = 52;
		ages[4] = 63;

		System.out.println(ages[0]); // 29
		System.out.println(ages.length); // 5

		for(int i = 0; i < ages.length; i++) {
			ages[i] = i * i;
			System.out.println(ages[i]); // 0 -> 1 -> 4 -> 9 -> 16
		}
	}
}
