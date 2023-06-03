package com.admin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.entity.Subject;

public class SubjectDAO {

	private Connection conn;

	public SubjectDAO(Connection conn) {
		super();
		this.conn = conn;
	}

	public boolean addSubject(String c, String sem, String s) {
		boolean f = false;
		try {
			String sql = "insert into subject(course_name,semestar,subject) values(?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, c);
			ps.setString(2, sem);
			ps.setString(3, s);
			int i = ps.executeUpdate();
			if (i == 1) {
				f = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	public List<Subject> getSubject(String co, String se) {
		List<Subject> list = new ArrayList<Subject>();
		Subject s = null;
		try {
			String sql = "select * from subject where course_name=? and semestar=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, co);
			ps.setString(2, se);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				s = new Subject(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
				list.add(s);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

}
