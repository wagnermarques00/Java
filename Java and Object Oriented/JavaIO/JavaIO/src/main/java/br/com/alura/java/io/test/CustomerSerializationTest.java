package br.com.alura.java.io.test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class CustomerSerializationTest {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		Customer customer = new Customer();
		customer.setName("Izuku Midoriya");
		customer.setProfession("Student");
		customer.setClientId("71");

		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("hero.bin"));
		oos.writeObject(customer); // will create the hero.bin (file in the project directory in this repository)
		oos.close();

		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("hero.bin"));
		Customer recoveredHero = (Customer) ois.readObject(); // will read the byte stream and bring it in the form of characters
		ois.close();
		System.out.println(recoveredHero);
	}

}
