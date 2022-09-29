package br.com.bytebank.bank.test;

import br.com.bytebank.bank.model.Connection;

public class ConnectionTest {

	public static void main(String[] args) {

		try(Connection connection = new Connection()) {
			connection.readData();
		} catch(IllegalStateException e) {
			System.out.println("br.com.bytebank.bank.model.Connection error");
		}
	}
}