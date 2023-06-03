package com.main;

import com.Dao.EmpDAO;
import com.conn.DBConnect;

public class deleteMain {
	public static void main(String[] args) {
		EmpDAO dao = new EmpDAO(DBConnect.getConn());
		boolean f = dao.deleteData(101);
		if (f) {
			System.out.println("Data Delete Sucessfully..");
		} else {
			System.out.println("Something wrong on server..");
		}
	}

}
