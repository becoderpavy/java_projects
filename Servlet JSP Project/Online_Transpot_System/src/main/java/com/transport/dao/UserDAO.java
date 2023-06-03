package com.transport.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.transport.conn.DbConnect;
import com.transport.entites.User;

public class UserDAO {

	private Connection conn;

	private PreparedStatement ps;

	private ResultSet rs;

	public UserDAO(Connection conn) {
		super();
		this.conn = conn;
	}

	public boolean createUser(User user) {
		boolean f = false;

		try {
			String sql = "insert into user(fullName,userName,email,password,location,role) values(?,?,?,?,?,?)";
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, user.getFullName());
			ps.setString(2, user.getUserName());
			ps.setString(3, user.getEmail());
			ps.setString(4, user.getPassword());
			ps.setString(5, user.getLocation());
			ps.setString(6, user.getRole());

			int i = ps.executeUpdate();

			if (i == 1) {
				f = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return f;
	}

	public List<User> getAllManager() {
		List<User> list = new ArrayList<User>();

		User u = null;
		try {
			String sql = "select * from user where role='Manager'";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				u = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getString(7));
				list.add(u);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public boolean updateUser(User user) {
		boolean f = false;

		try {
			String sql = "update user set fullName=?,userName=?,email=?,location=? where id=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, user.getFullName());
			ps.setString(2, user.getUserName());
			ps.setString(3, user.getEmail());

			ps.setString(4, user.getLocation());
			ps.setInt(5, user.getId());

			int i = ps.executeUpdate();

			if (i == 1) {
				f = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return f;
	}

	public boolean deleteUser(int id) {
		try {
			String sql = "delete from user where id=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);

			int i = ps.executeUpdate();

			if (i == 1) {
				return true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	public User login(String un, String psw) {

		User u = null;

		try {

			String sql = "select * from user where userName=? and password=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, un);
			ps.setString(2, psw);

			rs = ps.executeQuery();

			while (rs.next()) {
				u = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getString(7));

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
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);

			rs = ps.executeQuery();

			while (rs.next()) {
				u = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getString(7));

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return u;
	}

	public boolean checkUsername(String un) {

		try {

			String sql = "select * from user where userName=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, un);

			rs = ps.executeQuery();

			while (rs.next()) {
				return true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean checkEmail(String email) {

		try {

			String sql = "select * from user where email=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, email);

			rs = ps.executeQuery();

			while (rs.next()) {
				return true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
