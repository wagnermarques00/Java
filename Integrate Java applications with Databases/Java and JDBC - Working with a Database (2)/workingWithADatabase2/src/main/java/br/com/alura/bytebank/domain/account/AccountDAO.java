package br.com.alura.bytebank.domain.account;

import br.com.alura.bytebank.domain.customer.Customer;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AccountDAO {

	private Connection connection;

	AccountDAO(Connection connection) {
		this.connection = connection;
	}

	public void save(AccountOpeningData accountData) {
		Customer customer = new Customer(accountData.customerData());
		Account account = new Account(accountData.number(), customer);
		String insertStatement = "INSERT INTO account (number, balance, customer_name, customer_cpf, customer_email)" + "VALUES (?, ?, ?, ?, ?)";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(insertStatement);

			preparedStatement.setInt(1, account.getNumber());
			preparedStatement.setBigDecimal(2, BigDecimal.ZERO);
			preparedStatement.setString(3, accountData.customerData().name());
			preparedStatement.setString(4, accountData.customerData().cpf());
			preparedStatement.setString(5, accountData.customerData().email());

			preparedStatement.execute();
			preparedStatement.close();
			connection.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
