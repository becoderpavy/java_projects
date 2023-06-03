package com.conn;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {
	public static Connection conn = null;

	public static Connection getConnection() {
		try {

			if (conn == null) {
				Class.forName("com.mysql.cj.jdbc.Driver");
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/my_db", "root", "password");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
}
