package br.com.alura.java.io.test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

public class ReadingTest {

	public static void main(String[] args) throws IOException { // Input stream with file
		FileInputStream fis = new FileInputStream("LoremIpsum.txt"); // -> File that will be used as an example
		Reader isr = new InputStreamReader(fis);
		BufferedReader br = new BufferedReader(isr);

		String lineRead = br.readLine(); // Will write only the first line
		System.out.println(lineRead);

		System.out.println("--------------------------------------------------------"); // Just a separator

		while(lineRead != null) {
			System.out.println(lineRead);
			lineRead = br.readLine(); // Now reads all content (as long as there is no empty line)
		}

		br.close();
	}

}
