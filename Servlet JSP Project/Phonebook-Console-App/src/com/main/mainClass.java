package com.main;

import java.util.List;
import java.util.Scanner;

import com.conn.DBConnect;
import com.dao.ContactDAO;
import com.entity.contact;

public class mainClass {

	public static void main(String[] args) {

		boolean f = true;

		while (f) {
			System.out.println("----------------------");
			System.out.println("1. Create Contact");
			System.out.println("2. Edit Contact");
			System.out.println("3. Delete Contact");
			System.out.println("4. View Contact");
			System.out.println("5. Exit");
			System.out.println("----------------------");
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter No");
			int no = sc.nextInt();

			ContactDAO dao = new ContactDAO(DBConnect.getConn());

			switch (no) {
			case 1:
				System.out.println("Enter Name");
				String name = sc.next();
				System.out.println("Enter Ph No");
				String phno = sc.next();

				contact c = new contact();
				c.setName(name);
				c.setPhno(phno);

				boolean s1 = dao.saveContact(c);

				if (s1) {
					System.out.println("Ph No Saved..");
				} else {
					System.out.println("Something wrong on server..");
				}
				break;

			case 2:
				System.out.println("Enter Id");
				int id = sc.nextInt();
				System.out.println("Enter Name");
				String name2 = sc.next();
				System.out.println("Enter Ph no");
				String phno2 = sc.next();

				contact c2 = new contact();
				c2.setId(id);
				c2.setName(name2);
				c2.setPhno(phno2);

				boolean s2 = dao.editContact(c2);

				if (s2) {
					System.out.println("Phno Edit Sucessfully..");
				} else {
					System.out.println("User Is not Available");
				}

				break;
			case 3:

				System.out.println("Enter Id");
				int id3 = sc.nextInt();

				boolean s3 = dao.deleteContact(id3);

				if (s3) {
					System.out.println("Phno Delete Sucessfully..");
				} else {
					System.out.println("User Is not Available");
				}

				break;
			case 4:

				List<contact> list = dao.getAllContact();

				if (list.isEmpty()) {
					System.out.println("Phno is Not Available");
				} else {

					for (contact con : list) {
						System.out.println("Id=" + con.getId());
						System.out.println("Name=" + con.getName());
						System.out.println("Phno=" + con.getPhno());
						System.out.println("---------------------");
					}
				}
				break;
			case 5:
				f = false;
				System.out.println("Thank u..Visit Again..");
				break;

			default:
				System.out.println("Please Enter Correct No..");
				break;
			}

		}

	}

}
