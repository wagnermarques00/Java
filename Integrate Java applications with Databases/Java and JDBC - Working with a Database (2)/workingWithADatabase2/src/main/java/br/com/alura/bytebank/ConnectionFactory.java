package br.com.alura.bytebank;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionFactory {

	public Connection recoverConnection() {
		try {
			return createDataSource().getConnection();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}

	private HikariDataSource createDataSource() {
		HikariConfig hikariConfig = new HikariConfig();
		hikariConfig.setJdbcUrl("jdbc:mysql://localhost:3306/byte_bank");
		hikariConfig.setUsername("root");
		hikariConfig.setPassword("123456");
		hikariConfig.setMaximumPoolSize(10);

		return new HikariDataSource(hikariConfig);
	}
}


