package com.admin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.entity.Attendance;

public class AttendanceDAO {
	private Connection conn;

	public AttendanceDAO(Connection conn) {
		super();
		this.conn = conn;
	}

	public boolean addAttend(Attendance a) {
		boolean f = false;
		try {
			String sql = "insert into attendance(sid,name,course,semestar,year,month,days) values(?,?,?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, a.getStuId());
			ps.setString(2, a.getName());
			ps.setString(3, a.getCourse());
			ps.setString(4, a.getSemestar());
			ps.setString(5, a.getYear());
			ps.setString(6, a.getMonth());
			ps.setString(7, a.getDays());
			int i = ps.executeUpdate();
			if (i == 1) {
				f = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	public List<Attendance> getAttance(int sid) {
		List<Attendance> list = new ArrayList<Attendance>();
		Attendance a = null;
		try {
			String sql = "select * from attendance where sid=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, sid);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				a = new Attendance();
				a.setId(rs.getInt(1));
				a.setStuId(rs.getInt(2));
				a.setName(rs.getString(3));
				a.setCourse(rs.getString(4));
				a.setSemestar(rs.getString(5));
				a.setYear(rs.getString(6));
				a.setMonth(rs.getString(7));
				a.setDays(rs.getString(8));
				list.add(a);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public Attendance getAttanceById(int sid) {

		Attendance a = null;
		try {
			String sql = "select * from attendance where id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, sid);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				a = new Attendance();
				a.setId(rs.getInt(1));
				a.setStuId(rs.getInt(2));
				a.setName(rs.getString(3));
				a.setCourse(rs.getString(4));
				a.setSemestar(rs.getString(5));
				a.setYear(rs.getString(6));
				a.setMonth(rs.getString(7));
				a.setDays(rs.getString(8));

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return a;
	}

	public boolean updateAttadence(Attendance a) {
		boolean f = false;
		try {
			String sql = "update attendance set name=?,course=?,semestar=?,year=?,month=?,days=? where id=?";
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, a.getName());
			ps.setString(2, a.getCourse());
			ps.setString(3, a.getSemestar());
			ps.setString(4, a.getYear());
			ps.setString(5, a.getMonth());
			ps.setString(6, a.getDays());
			ps.setInt(7, a.getId());
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
