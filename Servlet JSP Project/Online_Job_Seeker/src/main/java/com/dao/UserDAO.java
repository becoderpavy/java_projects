package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.entites.User;

public class UserDAO {
	private Connection conn;

	public UserDAO(Connection conn) {
		super();
		this.conn = conn;
	}

	public boolean registerUser(User user) {
		boolean f = false;
		try {

			String sql = "insert into user(first_name,	last_name,age,gender,mob_no,email,password,address) values(?,?,?,?,?,?,?,?)";

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, user.getFirstName());
			ps.setString(2, user.getLastName());
			ps.setString(3, user.getAge());
			ps.setString(4, user.getGender());
			ps.setString(5, user.getMobileNumber());
			ps.setString(6, user.getEmail());
			ps.setString(7, user.getPassword());
			ps.setString(8, user.getAddress());

			int i = ps.executeUpdate();
			if (i == 1) {
				f = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return f;
	}

	public boolean updateUSer(User user) {
		boolean f = false;
		try {

			String sql = "update user set first_name=?,last_name=?,age=?,gender=?,mob_no=?,address=? where id=?";

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, user.getFirstName());
			ps.setString(2, user.getLastName());
			ps.setString(3, user.getAge());
			ps.setString(4, user.getGender());
			ps.setString(5, user.getMobileNumber());
			ps.setString(6, user.getAddress());
			ps.setInt(7, user.getId());

			int i = ps.executeUpdate();
			if (i == 1) {
				f = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return f;
	}

	public User login(String email, String password) {
		User u = null;
		try {
			String sql = "select * from user where email=? and password=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, email);
			ps.setString(2, password);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				u = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9));

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return u;
	}

	public User getUserById(int id) {
		User u = null;
		try {
			String sql = "select * from user where id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				u = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9));

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return u;
	}

	public boolean checkEmail(String email) {
		boolean f = true;
		try {
			String sql = "select * from user where email=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, email);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				f = false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	public boolean checkOldPasssword(int id, String oldpass) {
		boolean f = false;
		try {
			String sql = "select * from user where id=? and password=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.setString(2, oldpass);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				f = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	public boolean updateNewPasssword(int id, String newpass) {
		boolean f = false;
		try {
			String sql = "update user set password=? where id=?";
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, newpass);
			ps.setInt(2, id);
			int a = ps.executeUpdate();
			if (a == 1) {
				f = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	public boolean checkEmailAndMobForForgot(String email, String mobNo) {
		boolean f = false;
		try {
			String sql = "select * from user where email=? and mobno=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, email);
			ps.setString(2, mobNo);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				f = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	public boolean resetPasssword(String newpass, String email) {
		boolean f = false;
		try {
			String sql = "update user set password=? where email=?";
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, newpass);
			ps.setString(2, email);

			int a = ps.executeUpdate();

			if (a == 1) {
				f = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

}
