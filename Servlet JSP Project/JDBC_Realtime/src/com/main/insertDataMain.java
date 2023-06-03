package com.main;

import java.sql.Connection;
import java.util.Scanner;

import com.Dao.EmpDAO;
import com.conn.DBConnect;
import com.entity.Emp;

public class insertDataMain {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter EMp id");
		int id = sc.nextInt();
		System.out.println("Enter Name");
		String name = sc.next();
		System.out.println("Enter Address");
		String add = sc.next();

		System.out.println("Enter Salary");
		int sal = sc.nextInt();

		Emp em = new Emp();
		em.setId(id);
		em.setName(name);
		em.setAddress(add);
		em.setSalary(sal);

		EmpDAO dao = new EmpDAO(DBConnect.getConn());
		boolean f = dao.dataInsert(em);

		if (f) {
			System.out.println("Data Insert Sucessfully..");
		} else {
			System.out.println("Something went wrong on server..");
		}

	}

}
