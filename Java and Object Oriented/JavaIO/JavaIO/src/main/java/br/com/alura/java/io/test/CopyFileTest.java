package br.com.alura.java.io.test;

import java.io.*;

public class CopyFileTest {

	public static void main(String[] args) throws IOException { // Input stream with file
		FileInputStream fis = new FileInputStream("LoremIpsum.txt"); // -> File that will be used as an example
		Reader isr = new InputStreamReader(fis);
		BufferedReader br = new BufferedReader(isr);

		OutputStream fos = new FileOutputStream("AnotherIpsum.txt"); // -> File that will be used as an example
		Writer osw = new OutputStreamWriter(fos);
		BufferedWriter bw = new BufferedWriter(osw);

		String lineRead = br.readLine(); // Will write only the first line
		System.out.println(lineRead);

		System.out.println("--------------------------------------------------------"); // Just a separator

		while(lineRead != null && !lineRead.isEmpty()) {
			bw.write(lineRead);
			bw.newLine();
			lineRead = br.readLine(); // Now reads all content (as long as there is no empty line)
		}

		br.close();
		bw.close();
	}

}
