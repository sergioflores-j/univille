package br.univille.taskservice.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	private static ConnectionFactory instance;

	private static String banco = "teste";
	private static String usuario = "root";
	private static String senha = "root1234";

	private ConnectionFactory() {}

	public static ConnectionFactory getInstance() {
		if (instance == null) {
			instance = new ConnectionFactory();
		}
		return instance;
	}

	public Connection getConnection() {
		try {
			return DriverManager.getConnection("jdbc:mysql://localhost:3306/" + banco, usuario, senha);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
