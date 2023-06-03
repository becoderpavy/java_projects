package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.entity.User;

public class UserDAO {
	private Connection conn;

	public UserDAO(Connection conn) {
		super();
		this.conn = conn;
	}

	public boolean addUser(User user) {
		boolean f = false;
		try {
			String sql = "insert into user(full_name,email,mobno,password,address,city,state,pincode) values(?,?,?,?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, user.getFullName());
			ps.setString(2, user.getEmail());
			ps.setString(3, user.getMobNo());
			ps.setString(4, user.getPassword());
			ps.setString(5, user.getAddress());
			ps.setString(6, user.getCity());
			ps.setString(7, user.getState());
			ps.setString(8, user.getPin());

			int id = ps.executeUpdate();
			if (id == 1) {
				f = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	public boolean updateUser(User user) {
		boolean f = false;
		try {
			String sql = "update user set full_name=?,email=?,mobno=?,address=?,city=?,state=?,pincode=? where id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, user.getFullName());
			ps.setString(2, user.getEmail());
			ps.setString(3, user.getMobNo());
			ps.setString(4, user.getAddress());
			ps.setString(5, user.getCity());
			ps.setString(6, user.getState());
			ps.setString(7, user.getPin());
			ps.setInt(8, user.getId());

			int id = ps.executeUpdate();
			if (id == 1) {
				f = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	public User login(String email, String password) {
		User user = null;
		try {
			String sql = "select * from user where email=? and password=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, email);
			ps.setString(2, password);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				user = new User();
				user.setId(rs.getInt(1));
				user.setFullName(rs.getString(2));
				user.setEmail(rs.getString(3));
				user.setMobNo(rs.getString(4));
				user.setPassword(rs.getString(5));
				user.setAddress(rs.getString(6));
				user.setCity(rs.getString(7));
				user.setState(rs.getString(8));
				user.setPin(rs.getString(9));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}

	public User getUser(int userId) {
		User user = null;
		try {
			String sql = "select * from user where id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, userId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				user = new User();
				user.setId(rs.getInt(1));
				user.setFullName(rs.getString(2));
				user.setEmail(rs.getString(3));
				user.setMobNo(rs.getString(4));
				user.setPassword(rs.getString(5));
				user.setAddress(rs.getString(6));
				user.setCity(rs.getString(7));
				user.setState(rs.getString(8));
				user.setPin(rs.getString(9));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
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
