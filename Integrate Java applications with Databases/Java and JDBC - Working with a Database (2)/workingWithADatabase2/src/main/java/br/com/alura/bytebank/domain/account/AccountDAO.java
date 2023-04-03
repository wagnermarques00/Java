package br.com.alura.bytebank.domain.account;

import br.com.alura.bytebank.domain.customer.Customer;
import br.com.alura.bytebank.domain.customer.CustomerData;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

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

	public Set<Account> listAll() {
		String SELECT_STATEMENT = "SELECT * FROM account";
		Set<Account> accounts = new HashSet<>();
		PreparedStatement preparedStatement;
		ResultSet resultSet;

		try {
			preparedStatement = connection.prepareStatement(SELECT_STATEMENT);
			resultSet = preparedStatement.executeQuery();

			while(resultSet.next()) {
				Integer number = resultSet.getInt(1);
				BigDecimal balance = resultSet.getBigDecimal(2);
				String name = resultSet.getString(3);
				String cpf = resultSet.getString(4);
				String email = resultSet.getString(5);

				CustomerData customerData = new CustomerData(name, cpf, email);
				Customer customer = new Customer(customerData);

				accounts.add(new Account(number, customer));
			}
			resultSet.close();
			preparedStatement.close();
			connection.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return accounts;
	}

	public Account listByNumber(Integer number) {
		String SELECT_STATEMENT = "SELECT * FROM account WHERE number = ?";

		PreparedStatement preparedStatement;
		ResultSet resultSet;
		Account account = null;

		try {
			preparedStatement = connection.prepareStatement(SELECT_STATEMENT);
			preparedStatement.setInt(1, number);
			resultSet = preparedStatement.executeQuery();

			while(resultSet.next()) {
				Integer accountNumber = resultSet.getInt(1);
				BigDecimal balance = resultSet.getBigDecimal(2);
				String name = resultSet.getString(3);
				String cpf = resultSet.getString(4);
				String email = resultSet.getString(5);

				CustomerData customerData = new CustomerData(name, cpf, email);
				Customer customer = new Customer(customerData);
				account = new Account(accountNumber, customer);
			}
			resultSet.close();
			preparedStatement.close();
			connection.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return account;
	}
}
