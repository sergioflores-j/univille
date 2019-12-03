package br.univille.trabmvc.dao;

import java.sql.Connection;

import br.univille.trabmvc.utils.ConnectionFactory;

public class BaseDao {

	public Connection getConnection() {
		return ConnectionFactory.getInstance().getConnection();
	}

}
