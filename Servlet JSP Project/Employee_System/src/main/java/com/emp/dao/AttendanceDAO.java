package com.emp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.emp.entity.Attendance;

public class AttendanceDAO {
	private Connection conn;

	public AttendanceDAO(Connection conn) {
		super();
		this.conn = conn;
	}

	public boolean attendance(Attendance a) {
		boolean f = false;

		try {
			String sql = "insert into attendance(account_name,a_date,a_hours,milestone,remark,narration,userid,status) values(?,?,?,?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, a.getAccountName());
			ps.setString(2, a.getDate());
			ps.setString(3, a.getHours());
			ps.setString(4, a.getMilestone());
			ps.setString(5, a.getRemark());
			ps.setString(6, a.getNarration());
			ps.setInt(7, a.getUserid());
			ps.setString(8, a.getStatus());

			int i = ps.executeUpdate();
			if (i == 1) {
				f = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	public List<Attendance> getAllAttend() {
		List<Attendance> list = new ArrayList<Attendance>();
		Attendance a = new Attendance();

		try {
			String sql = "select * from attendance order by id desc ";
			PreparedStatement ps = conn.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				a = new Attendance();
				a.setId(rs.getInt(1));
				a.setAccountName(rs.getString(2));
				a.setDate(rs.getString(3));
				a.setHours(rs.getString(4));
				a.setMilestone(rs.getString(5));
				a.setRemark(rs.getString(6));
				a.setNarration(rs.getString(7));
				a.setUserid(rs.getInt(8));
				a.setStatus(rs.getString(9));
				list.add(a);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	public List<Attendance> getAllAttendById(int id) {
		List<Attendance> list = new ArrayList<Attendance>();
		Attendance a = new Attendance();

		try {
			String sql = "select * from attendance where userid=? order by id desc ";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				a = new Attendance();
				a.setId(rs.getInt(1));
				a.setAccountName(rs.getString(2));
				a.setDate(rs.getString(3));
				a.setHours(rs.getString(4));
				a.setMilestone(rs.getString(5));
				a.setRemark(rs.getString(6));
				a.setNarration(rs.getString(7));
				a.setUserid(rs.getInt(8));
				a.setStatus(rs.getString(9));
				list.add(a);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	public boolean updateStatus(int id, int uid, String st) {
		boolean f = false;

		try {
			String sql = "update attendance set status=? where id=? and userid=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, st);
			ps.setInt(2, id);
			ps.setInt(3, uid);
			int i = ps.executeUpdate();
			if (i == 1) {
				f = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	public void deleteData(int uid) {
		try {
			String sql = "delete from attendance where userid=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, uid);
			int i = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
