package br.com.alura.java.io.test;

import java.io.File;
import java.util.Scanner;

public class SimpleScannerTest {

	public static void main(String[] args) throws Exception {
		File file = new File("accounts.csv"); // The file is in the root directory or the project
		Scanner scanner = new Scanner(file);

		while(scanner.hasNextLine()) {
			String lineRead = scanner.nextLine();
			System.out.println(lineRead);
		}

		scanner.close();
	}

}
