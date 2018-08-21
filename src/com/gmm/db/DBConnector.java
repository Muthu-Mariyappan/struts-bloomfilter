package com.gmm.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnector {
	private final String USER = "root";
	private final String PASS = "darkvoid";
	private final String URL = "jdbc:mysql://localhost:3306/jpadb?useSSL=false";
	private Connection conn;
	
	public DBConnector() throws SQLException, ClassNotFoundException {
	    Class.forName("com.mysql.jdbc.Driver");
	    Connection conn = DriverManager.getConnection(URL,USER,PASS);
	    this.conn = conn;
	}
	
	public boolean isPresent(String name) throws SQLException {
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("select price from games where name = \'"+name+"\' limit 1");
		if(rs.next())
			return true;
		else 
			return false;
	}
	
	public Integer getPrice(String name) throws SQLException {
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("select price from games where name = \'"+name+"\' limit 1");
		if(rs.next())
			return rs.getInt(1);
		else
			return null;
	}
	
	@Override
	public void finalize() {
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}