package org.example.factory;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionFactory {
	public DataSource dataSource;

	public ConnectionFactory() {
		String url = "jdbc:mysql://localhost/virtual_store?useTimezone=true&serverTimezone=UTC";
		String user = "root";
		String password = "123456";

		ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
		comboPooledDataSource.setJdbcUrl(url);
		comboPooledDataSource.setUser(user);
		comboPooledDataSource.setPassword(password);

		comboPooledDataSource.setMaxPoolSize(15);

		this.dataSource = comboPooledDataSource;
	}

	public Connection recoverConnection() throws SQLException {
		return this.dataSource.getConnection();
	}
}
