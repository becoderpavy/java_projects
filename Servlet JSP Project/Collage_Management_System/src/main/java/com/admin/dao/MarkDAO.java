package com.admin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.entity.Mark;

public class MarkDAO {

	private Connection conn;

	public MarkDAO(Connection conn) {
		super();
		this.conn = conn;
	}

	public boolean addMark(Mark m) {
		boolean f = false;
		try {
			String sql = "insert into mark(stuid,roll,name,course,semestar,subject,smark) values(?,?,?,?,?,?,?)";

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, m.getStuid());
			ps.setString(2, m.getRoll());
			ps.setString(3, m.getName());
			ps.setString(4, m.getCourse());
			ps.setString(5, m.getSemestar());
			ps.setString(6, m.getSubject());
			ps.setInt(7, m.getMark());
			int i = ps.executeUpdate();
			if (i == 1) {
				f = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	public boolean markAddCheck(int stid, String s) {
		boolean f = true;
		try {
			String sql = "select * from mark where stuid=? and subject=?";

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, stid);
			ps.setString(2, s);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				f = false;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	public List<Mark> getMark(int stuid, String sem) {
		List<Mark> list = new ArrayList<Mark>();
		Mark m = null;
		boolean f = true;
		try {
			String sql = "select * from mark where stuid=? and semestar=?";

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, stuid);
			ps.setString(2, sem);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				m = new Mark();
				m.setId(rs.getInt(1));
				m.setStuid(rs.getInt(2));
				m.setRoll(rs.getString(3));
				m.setName(rs.getString(4));
				m.setCourse(rs.getString(5));
				m.setSemestar(rs.getString(6));
				m.setSubject(rs.getString(7));
				m.setMark(rs.getInt(8));
				list.add(m);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public Mark getMarkByID(String stuid, String sem) {

		Mark m = null;
		try {
			String sql = "select * from mark where stuid=? and semestar=?";

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, Integer.parseInt(stuid));
			ps.setString(2, sem);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				m = new Mark();
				m.setId(rs.getInt(1));
				m.setStuid(rs.getInt(2));
				m.setRoll(rs.getString(3));
				m.setName(rs.getString(4));
				m.setCourse(rs.getString(5));
				m.setSemestar(rs.getString(6));
				m.setSubject(rs.getString(7));
				m.setMark(rs.getInt(8));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return m;
	}

}
