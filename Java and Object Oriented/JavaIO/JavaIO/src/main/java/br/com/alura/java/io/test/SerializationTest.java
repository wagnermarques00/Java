package br.com.alura.java.io.test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializationTest {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		String name = "Izuku Midoriya";

		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("object.bin"));
		oos.writeObject(name); // will create the object.bin (file in the project directory in this repository)
		oos.close();

		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("object.bin"));
		String recoveredName = (String) ois.readObject(); // will read the byte stream and bring it in the form of characters
		ois.close();
		System.out.println(recoveredName);
	}

}
