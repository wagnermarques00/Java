package br.com.alura.java.io.test;

import java.io.*;

public class ReadingInConsoleCreatingFileTest {

	public static void main(String[] args) throws IOException { // Input stream with file
		InputStream inputStream = System.in;
		Reader inputStreamReader = new InputStreamReader(inputStream);
		BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

		OutputStream fileOutputStream = new FileOutputStream("WrittenIpsum.txt"); // -> File that will be used as an example
		Writer outputStreamWriter = new OutputStreamWriter(fileOutputStream);
		BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);

		String lineRead = bufferedReader.readLine(); // Will write only the first line
		System.out.println(lineRead);

		System.out.println("--------------------------------------------------------"); // Just a separator

		while(lineRead != null && !lineRead.isEmpty()) {
			bufferedWriter.write(lineRead);
			bufferedWriter.newLine();
			bufferedWriter.flush();
			lineRead = bufferedReader.readLine(); // Now reads all content (as long as there is no empty line)
		}

		bufferedReader.close();
		bufferedWriter.close();
	}

}
