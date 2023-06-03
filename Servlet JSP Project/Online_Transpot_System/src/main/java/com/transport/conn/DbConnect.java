package com.transport.conn;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnect {
	public static Connection conn = null;
	

	public static Connection getConnection() {
		try {

			if (conn == null) {
				Class.forName("com.mysql.cj.jdbc.Driver");
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/transport_db", "root", "password");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

	

	
}
