package br.univille.trabmvc.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	private static ConnectionFactory instance;

	private static String db = "taskservice";
	private static String user = "root";
	private static String password = "root1234";

	private ConnectionFactory() {
	}

	public static ConnectionFactory getInstance() {
		if (instance == null) {
			instance = new ConnectionFactory();
		}
		return instance;
	}

	public Connection getConnection() {
		try {
			return DriverManager.getConnection("jdbc:mysql://localhost:3306/" + db, user, password);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}