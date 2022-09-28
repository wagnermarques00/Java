package br.com.alura.java.io.test;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriterTest {

	public static void main(String[] args) throws IOException {
		FileWriter fileWriter = new FileWriter("AnotherStarWarsIpsum.txt"); // -> File that will be used as an example
		BufferedWriter bw = new BufferedWriter(fileWriter);

		bw.write("Lucas ipsum dolor sit amet mon moff wampa ventress solo fett yavin wedge darth naboo.");
		bw.newLine(); // Jump to the next line
		bw.newLine(); // Jump to the next line, creating an empty line
		bw.write("Yoda anakin dagobah hoth jinn hutt ponda yavin.");

		bw.close();
	}

}

/*
 * After running this test, the file AnotherStarWarsIpsum.txt will be created as the file in the repository.
 * The output will be as shown below:
 * Lucas ipsum dolor sit amet mon moff wampa ventress solo fett yavin wedge darth naboo.
 *
 * Yoda anakin dagobah hoth jinn hutt ponda yavin.
 */
