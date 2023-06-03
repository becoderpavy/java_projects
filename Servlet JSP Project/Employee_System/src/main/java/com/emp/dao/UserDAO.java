package com.emp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.emp.entity.UserDtls;

public class UserDAO {

	private Connection conn;

	public UserDAO(Connection conn) {
		super();
		this.conn = conn;
	}

	public boolean addEmp(UserDtls u) {
		boolean f = false;

		try {
			String sql = "insert into user(first_name,last_name,username,password,email,contact_no,address,salary,qualification,status) values(?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, u.getFirstName());
			ps.setString(2, u.getLastName());
			ps.setString(3, u.getUserName());
			ps.setString(4, u.getPassword());
			ps.setString(5, u.getEmail());
			ps.setString(6, u.getContactNo());
			ps.setString(7, u.getAdress());
			ps.setDouble(8, u.getSalary());
			ps.setString(9, u.getQualification());
			ps.setString(10, u.getStatus());

			int i = ps.executeUpdate();
			if (i == 1) {
				f = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	public boolean checkUser(String em, String un) {
		boolean f = true;

		try {

			String sql = "select * from user where email=? or username=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, em);
			ps.setString(2, un);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				f = false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	public List<UserDtls> getAllEmp() {
		List<UserDtls> list = new ArrayList<UserDtls>();
		UserDtls u = null;

		try {
			String sql = "select * from user order by id desc";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				u = new UserDtls();
				u.setId(rs.getInt(1));
				u.setFirstName(rs.getString(2));
				u.setLastName(rs.getString(3));
				u.setUserName(rs.getString(4));
				u.setPassword(rs.getString(5));
				u.setEmail(rs.getString(6));
				u.setContactNo(rs.getString(7));
				u.setAdress(rs.getString(8));
				u.setSalary(rs.getDouble(9));
				u.setQualification(rs.getString(10));
				u.setStatus(rs.getString(11));
				list.add(u);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public UserDtls login(String un, String psw) {
		UserDtls u = null;
		try {
			String sql = "select * from user where username=? and password=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, un);
			ps.setString(2, psw);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				u = new UserDtls();
				u.setId(rs.getInt(1));
				u.setFirstName(rs.getString(2));
				u.setLastName(rs.getString(3));
				u.setUserName(rs.getString(4));
				u.setPassword(rs.getString(5));
				u.setEmail(rs.getString(6));
				u.setContactNo(rs.getString(7));
				u.setAdress(rs.getString(8));
				u.setSalary(rs.getDouble(9));
				u.setQualification(rs.getString(10));
				u.setStatus(rs.getString(11));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return u;
	}

	public UserDtls getUser(int id) {
		UserDtls u = null;
		try {
			String sql = "select * from user where id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				u = new UserDtls();
				u.setId(rs.getInt(1));
				u.setFirstName(rs.getString(2));
				u.setLastName(rs.getString(3));
				u.setUserName(rs.getString(4));
				u.setPassword(rs.getString(5));
				u.setEmail(rs.getString(6));
				u.setContactNo(rs.getString(7));
				u.setAdress(rs.getString(8));
				u.setSalary(rs.getDouble(9));
				u.setQualification(rs.getString(10));
				u.setStatus(rs.getString(11));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return u;
	}

	public boolean updateEmp(UserDtls u) {
		boolean f = false;

		try {

			String sql = "update user set first_name=?,last_name=?,username=?,password=?,email=?,contact_no=?,address=?,salary=?,qualification=?,status=? where id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, u.getFirstName());
			ps.setString(2, u.getLastName());
			ps.setString(3, u.getUserName());
			ps.setString(4, u.getPassword());
			ps.setString(5, u.getEmail());
			ps.setString(6, u.getContactNo());
			ps.setString(7, u.getAdress());
			ps.setDouble(8, u.getSalary());
			ps.setString(9, u.getQualification());
			ps.setString(10, u.getStatus());
			ps.setInt(11, u.getId());
			int i = ps.executeUpdate();
			if (i == 1) {
				f = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	public boolean deleteEmp(int id) {
		boolean f = false;
		try {

			String sql = "delete from user where id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
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

	public boolean changePassword(int uid, String nps) {
		boolean f = false;
		try {

			String sql = "update user set password=? where id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, nps);
			ps.setInt(2, uid);
			int i = ps.executeUpdate();
			if (i == 1) {
				f = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	public boolean changeOldPassword(int uid, String ops) {
		boolean f = false;
		try {

			String sql = "select * from user where id=? and password=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, uid);
			ps.setString(2, ops);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				f = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	public String forgotPassword(String un, String em) {
		String psw = "";
		try {

			String sql = "select * from user where username=? and email=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, un);
			ps.setString(2, em);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				psw = rs.getString(5);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return psw;
	}

	public boolean checkStatus(String un) {
		boolean f = false;
		try {

			String sql = "select * from user where username=? and status=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, un);
			ps.setString(2, "Active");

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				f = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	public int getEmpNo() {
		int i = 0;
		try {

			String sql = "select * from user";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				i++;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}

}
