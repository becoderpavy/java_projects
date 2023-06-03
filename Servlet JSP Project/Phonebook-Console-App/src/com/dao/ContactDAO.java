package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.entity.contact;

public class ContactDAO {

	private Connection conn;

	public ContactDAO(Connection conn) {
		super();
		this.conn = conn;
	}

	public boolean saveContact(contact c) {
		boolean f = false;

		try {
			PreparedStatement ps = conn.prepareStatement("insert into contact(name,phno) values(?,?)");
			ps.setString(1, c.getName());
			ps.setString(2, c.getPhno());

			int i = ps.executeUpdate();
			if (i == 1) {
				f = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return f;
	}

	public boolean editContact(contact c) {
		boolean f = false;

		try {
			PreparedStatement ps = conn.prepareStatement("update contact set phno=? where id=?");
			ps.setString(1, c.getPhno());
			ps.setInt(2, c.getId());

			int i = ps.executeUpdate();
			if (i == 1) {
				f = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return f;
	}

	public boolean deleteContact(int id) {
		boolean f = false;

		try {
			PreparedStatement ps = conn.prepareStatement("delete from contact where id=?");
			ps.setInt(1, id);

			int i = ps.executeUpdate();
			if (i == 1) {
				f = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return f;
	}

	public List<contact> getAllContact() {
		List<contact> list = new ArrayList<contact>();
		contact obj = null;
		try {
			PreparedStatement ps = conn.prepareStatement("select * from contact");
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				obj=new contact();
				obj.setId(rs.getInt(1));
				obj.setName(rs.getString(2));
				obj.setPhno(rs.getString(3));
				list.add(obj);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

}
