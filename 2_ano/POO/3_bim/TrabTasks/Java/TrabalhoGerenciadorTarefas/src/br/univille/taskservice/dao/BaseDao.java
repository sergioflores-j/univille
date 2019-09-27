package br.univille.taskservice.dao;

import java.sql.Connection;

import br.univille.taskservice.services.ConnectionFactory;

public class BaseDao {

	public Connection getConnection() {
		return ConnectionFactory.getInstance().getConnection();
	}

}
