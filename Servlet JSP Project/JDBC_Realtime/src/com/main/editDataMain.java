package com.main;

import com.Dao.EmpDAO;
import com.conn.DBConnect;
import com.entity.Emp;

public class editDataMain {

	public static void main(String[] args) {

		Emp em = new Emp();
		em.setId(101);
		em.setName("Jageswar");
		em.setAddress("Jharkhand");

		EmpDAO dao = new EmpDAO(DBConnect.getConn());
		boolean f = dao.editData(em);

		if (f) {
			System.out.println("Data Edit Sucessfully..");
		} else {
			System.out.println("Something wrong on server..");
		}

	}

}
