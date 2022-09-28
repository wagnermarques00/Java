package br.com.alura.java.io.test;

import java.io.File;
import java.util.Locale;
import java.util.Scanner;

public class ReadingCSVTest {

	public static void main(String[] args) throws Exception {
		File file = new File("accounts.csv"); // The file is in the root directory or the project
		Scanner scanner = new Scanner(file); // Read the line

		while(scanner.hasNextLine()) {
			String lineRead = scanner.nextLine();

			Scanner lineScanner = new Scanner(lineRead); // Read the content of the line
			lineScanner.useLocale(Locale.US); // Using this, the vm will interpret the values according to the region
			lineScanner.useDelimiter(",");

			String accountType = lineScanner.next();
			Integer agency = lineScanner.nextInt();
			Integer number = lineScanner.nextInt();
			String name = lineScanner.next();
			Double balance = lineScanner.nextDouble();

			Locale usLocale = new Locale("us", "US"); // This change the output to the default values of the region, or you can just type Locale.US
			String format = "%s - %04d, %06d, %s: %01.2f"; // How the output will be formatted
			String formattedValue = String.format(usLocale, format, accountType, agency, number, name, balance); // Formatted output
			System.out.println(formattedValue);

			lineScanner.close();
		}

		scanner.close();
	}

}

/*
 * Two scanners were used:
 * one to read the lines
 * other to read a line, with their respective delimiters
 *
 * The output after format will be:
 * CA - 0022, 000033, Izuku Midoriya: 210.10
 * SA - 0011, 000055, Katsuki Bakugo: 1300.98
 * CA - 0022, 000044, Ochaco Uraraka: 350.40
 */
