package br.com.alura.java.io.test;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

public class WritingTest {

	public static void main(String[] args) throws IOException { // Output stream with file
		OutputStream fos = new FileOutputStream("StarWarsIpsum.txt"); // -> File that will be used as an example
		Writer osw = new OutputStreamWriter(fos);
		BufferedWriter bw = new BufferedWriter(osw);

		bw.write("Lucas ipsum dolor sit amet mon moff wampa ventress solo fett yavin wedge darth naboo.");
		bw.newLine(); // Jump to the next line
		bw.newLine(); // Created an empty line
		bw.write("Yoda anakin dagobah hoth jinn hutt ponda yavin.");

		bw.close();
	}

}

/*
 * After running this test, the file StarWarsIpsum.txt will be created as the file in the repository.
 * The output will be as shown below:
 * Lucas ipsum dolor sit amet mon moff wampa ventress solo fett yavin wedge darth naboo.
 *
 * Yoda anakin dagobah hoth jinn hutt ponda yavin.
 */
