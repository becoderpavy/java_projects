package com.conn;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionProvider {

	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecom","root","password");
			return conn;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

}
