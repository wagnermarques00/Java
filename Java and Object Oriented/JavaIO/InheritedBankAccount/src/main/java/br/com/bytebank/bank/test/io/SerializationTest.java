package br.com.bytebank.bank.test.io;

import br.com.bytebank.bank.model.CheckingAccount;
import br.com.bytebank.bank.model.Customer;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SerializationTest {

	public static void main(String[] args) throws IOException {
		Customer hero = new Customer();
		hero.setName("Izuku Midoriya");
		hero.setProfession("Student");
		hero.setClientId("71");

		CheckingAccount cc = new CheckingAccount(222, 333);
		cc.setCustomer(hero);
		cc.deposit(16);

		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("cc.bin"));
		oos.writeObject(cc); // will create the cc.bin (file in the project directory in this repository)
		oos.close();
	}

}
