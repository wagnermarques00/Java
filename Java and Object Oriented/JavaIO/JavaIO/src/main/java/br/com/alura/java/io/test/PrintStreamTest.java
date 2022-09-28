package br.com.alura.java.io.test;

import java.io.IOException;
import java.io.PrintStream;

public class PrintStreamTest {

	public static void main(String[] args) throws IOException {
		PrintStream ps = new PrintStream("BaconIpsum.txt"); // -> File that will be used as an example

		ps.println("Bacon ipsum dolor amet tri-tip sausage ham hock, pastrami ground round burgdoggen chicken buffalo.");
		ps.println();
		ps.print("Sausage tri-tip tongue, sirloin ham hock pastrami short loin.");

		ps.close();
	}

}

/*
 * After running this test, the file BaconIpsum.txt will be created as the file in the repository.
 * The output will be as shown below:
 * Bacon ipsum dolor amet tri-tip sausage ham hock, pastrami ground round burgdoggen chicken buffalo.
 *
 * Sausage tri-tip tongue, sirloin ham hock pastrami short loin.
 */
