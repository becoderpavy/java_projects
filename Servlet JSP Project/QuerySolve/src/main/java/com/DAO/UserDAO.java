package com.DAO;

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

	public boolean addUser(User us) {
		boolean f = false;

		try {
			String query = "insert into user(fullName,email,gender,collageId,category,password) values(?,?,?,?,?,?)";

			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, us.getFullName());
			ps.setString(2, us.getEmail());
			ps.setString(3, us.getGender());
			ps.setString(4, us.getCollageId());
			ps.setString(5, us.getCategory());
			ps.setString(6, us.getPassword());
			int i = ps.executeUpdate();
			if (i == 1) {
				f = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return f;
	}

	public User loginUser(String email, String password) {
		User user = null;
		try {
			String query = "select * from user where email=? and password=?";

			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, email);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				user = new User();
				user.setId(rs.getInt("id"));
				user.setFullName(rs.getString("fullName"));
				user.setEmail(rs.getString("email"));
				user.setGender(rs.getString("gender"));
				user.setCollageId(rs.getString("collageId"));
				user.setCategory(rs.getString("category"));
				user.setPassword(rs.getString("password"));

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;

	}

	public User getUserById(int id) {
		User user = null;
		try {
			PreparedStatement ps = conn.prepareStatement("select * from user where id=?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				user = new User();
				user.setId(rs.getInt("id"));
				user.setFullName(rs.getString("fullName"));
				user.setEmail(rs.getString("email"));
				user.setGender(rs.getString("gender"));
				user.setCollageId(rs.getString("collageId"));
				user.setCategory(rs.getString("category"));
				user.setPassword(rs.getString("password"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}

	public boolean UpdateProfile(User us) {
		boolean f = false;

		try {
			String sql = "update user set fullName=?,email=?,gender=?,collageId=?,category=? where id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, us.getFullName());
			ps.setString(2, us.getEmail());
			ps.setString(3, us.getGender());
			ps.setString(4, us.getCollageId());
			ps.setString(5, us.getCategory());
			ps.setInt(6, us.getId());

			int i = ps.executeUpdate();
			if (i == 1) {
				f = true;
			}

		} catch (Exception e) {
			// TODO: handle exception
		}

		return f;
	}

}
