package com.main;

import java.util.List;

import com.Dao.EmpDAO;
import com.conn.DBConnect;
import com.entity.Emp;

public class retriveData {
	public static void main(String[] args) {
		EmpDAO dao = new EmpDAO(DBConnect.getConn());
		/*
		 * Emp em = dao.getInfo(4);
		 * 
		 * if (em==null) { System.out.println("User Not Available.."); } else {
		 * System.out.println("Name=" + em.getName()); System.out.println("Address=" +
		 * em.getAddress()); System.out.println("Salary=" + em.getSalary()); }
		 */

		List<Emp> list = dao.getAllData();

		for (Emp e : list) 
		{
			System.out.println("Name=" + e.getName());
			System.out.println("Address=" + e.getAddress());
			System.out.println("Salary=" + e.getSalary());
			System.out.println("------------------------------");
		}

	}

}
