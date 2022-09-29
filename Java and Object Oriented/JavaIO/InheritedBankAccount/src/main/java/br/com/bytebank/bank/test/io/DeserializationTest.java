package br.com.bytebank.bank.test.io;

import br.com.bytebank.bank.model.CheckingAccount;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class DeserializationTest {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("cc.bin"));
		CheckingAccount cc = (CheckingAccount) ois.readObject(); // will read the byte stream and bring it in the form of characters
		ois.close();

		System.out.println(cc.getCustomer()); // Customer - name: Izuku Midoriya, clientId: 71, profession: Student
		System.out.println(cc.getBalance());  // 16.0
	}

}
