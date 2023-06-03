package com.admin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.entity.Teacher;

public class TeacherDAO {
	private Connection conn;

	public TeacherDAO(Connection conn) {
		super();
		this.conn = conn;
	}

	public boolean addTeacher(Teacher t) {
		boolean f = false;
		try {
			String sql = "insert into teacher(name,gender,dob,qualification,email,password) values(?,?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, t.getName());
			ps.setString(2, t.getGender());
			ps.setString(3, t.getDob());
			ps.setString(4, t.getQualification());
			ps.setString(5, t.getEmail());
			ps.setString(6, t.getPassword());

			int i = ps.executeUpdate();
			if (i == 1) {
				f = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	public List<Teacher> getTeacher() {
		List<Teacher> list = new ArrayList<Teacher>();
		Teacher t = null;
		try {
			String sql = "select * from teacher";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				t = new Teacher();
				t.setId(rs.getInt(1));
				t.setName(rs.getString(2));
				t.setGender(rs.getString(3));
				t.setDob(rs.getString(4));
				t.setQualification(rs.getString(5));
				t.setEmail(rs.getString(6));
				t.setPassword(rs.getString(7));
				list.add(t);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public boolean updateTeacher(Teacher t) {
		boolean f = false;
		try {
			String sql = "update teacher set name=?,gender=?,dob=?,qualification=?,email=?,password=? where id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, t.getName());
			ps.setString(2, t.getGender());
			ps.setString(3, t.getDob());
			ps.setString(4, t.getQualification());
			ps.setString(5, t.getEmail());
			ps.setString(6, t.getPassword());
			ps.setInt(7, t.getId());

			int i = ps.executeUpdate();
			if (i == 1) {
				f = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	public boolean deleteTeacher(int id) {
		boolean f = false;
		try {

			String sql = "delete from teacher where id=?";
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

	public Teacher getTeacherByid(int id) {
		Teacher t = null;
		try {
			String sql = "select * from teacher where id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				t = new Teacher();
				t.setId(rs.getInt(1));
				t.setName(rs.getString(2));
				t.setGender(rs.getString(3));
				t.setDob(rs.getString(4));
				t.setQualification(rs.getString(5));
				t.setEmail(rs.getString(6));
				t.setPassword(rs.getString(7));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return t;
	}

	public Teacher tlogin(String email, String pa) {
		Teacher t = null;
		try {

			String sql = "select * from teacher where email=? and password=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, email);
			ps.setString(2, pa);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				t = new Teacher();
				t.setId(rs.getInt(1));
				t.setName(rs.getString(2));
				t.setGender(rs.getString(3));
				t.setDob(rs.getString(4));
				t.setQualification(rs.getString(5));
				t.setEmail(rs.getString(6));
				t.setPassword(rs.getString(7));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return t;
	}

	public int teacherCount() {
		int i = 0;
		try {
			String sql = "select count(*) from teacher";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			rs.next();
			i = rs.getInt(1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}

}
