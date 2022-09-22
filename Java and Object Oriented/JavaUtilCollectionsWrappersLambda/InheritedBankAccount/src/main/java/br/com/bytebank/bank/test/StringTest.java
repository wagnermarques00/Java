package br.com.bytebank.bank.test;

public class StringTest {

	public static void main(String[] args) {
		String name = "Izuku Midoriya"; // object literal
		System.out.println(name); // Izuku Midoriya

		//---- some tests ---- \\
		name = name.toLowerCase();
		System.out.println("toLowerCase: " + name); // izuku midoriya

		name = name.replace("izuku midoriya", "Katsuki Bakugo");
		System.out.println("replace: " + name); // Katsuki Bakugo

		name = name.toUpperCase();
		System.out.println("toUpperCase: " + name); // KATSUKI BAKUGO

		char nameChar = name.charAt(0);
		System.out.println("charAt(0): " + nameChar); // K

		int namePositions = name.indexOf("BAK");
		System.out.println("indexOf(BAK): " + namePositions); // 8

		name = name.substring(5);
		System.out.println("substring(5): " + name); // KI BAKUGO

		System.out.println("contains(KUGO): " + name.contains("KUGO")); // true
		System.out.println("contains(Izuku)" + name.contains("Izuku")); // false

		System.out.println("lenght: " + name.length()); // 9
		for(int i = 0; i < name.length(); i++) {
			System.out.println(name.charAt(i));
			/*
			 *K
			 *I
			 *
			 *B
			 *A
			 *K
			 *U
			 *G
			 *O
			 */
		}

		String emptyString = " ";
		System.out.println("empty: " + emptyString.isEmpty()); // false
		System.out.println("blank: " + emptyString.isBlank()); // true

		String anotherEmptyString = emptyString.trim();
		System.out.println("empty after trim: " + anotherEmptyString.isEmpty()); // true
		System.out.println("blank after trim: " + anotherEmptyString.isBlank()); // true
	}
}
