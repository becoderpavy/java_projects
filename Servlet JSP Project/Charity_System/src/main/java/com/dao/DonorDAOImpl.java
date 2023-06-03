package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.entity.Donor;
import com.entity.Organization;

public class DonorDAOImpl implements DonorDAO {
	private Connection conn;

	public DonorDAOImpl(Connection conn) {
		super();
		this.conn = conn;
	}

	public boolean addDonor(Donor d) {
		boolean f = false;
		try {
			String sql = "insert into donar(name,email,password,phno) values(?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, d.getName());
			ps.setString(2, d.getEmail());
			ps.setString(3, d.getPassword());
			ps.setString(4, d.getPhno());

			int i = ps.executeUpdate();
			if (i == 1) {
				f = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	public Donor login(String em, String psw) {
		Donor d = null;
		try {
			String sql = "select * from donar where email=? and password=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, em);
			ps.setString(2, psw);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				d = new Donor();
				d.setId(rs.getInt(1));
				d.setName(rs.getString(2));
				d.setEmail(rs.getString(3));
				d.setPassword(rs.getString(4));
				d.setPhno(rs.getString(5));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return d;
	}

	public boolean checkUser(String em) {
		boolean f = true;
		try {
			String sql = "select * from donar where email=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, em);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				f = false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}
	
	public boolean checkPasswordAuthen(String email, String phno) {
		boolean f = false;
		try {

			String sql = "select * from donar where email=? and phno=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, email);
			ps.setString(2, phno);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				f = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	public boolean forgotPassword(String email, String phno, String password) {

		boolean f = false;
		try {
			String sql = "update donar set password=? where email=? and phno=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, password);
			ps.setString(2, email);
			ps.setString(3, phno);

			int i = ps.executeUpdate();
			if (i == 1) {
				f = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

}
