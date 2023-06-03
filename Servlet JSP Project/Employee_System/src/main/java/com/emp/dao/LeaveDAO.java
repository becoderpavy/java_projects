package com.emp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.emp.entity.Attendance;
import com.emp.entity.Leave;

public class LeaveDAO {
	private Connection conn;

	public LeaveDAO(Connection conn) {
		super();
		this.conn = conn;
	}

	public boolean Addleave(Leave l) {
		boolean f = false;

		try {
			String sql = "insert into leaves(leave_type,date_from,date_to,no_days,contact_no,reasons,user_id,status) values(?,?,?,?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, l.getLeaveType());
			ps.setString(2, l.getDate_from());
			ps.setString(3, l.getDate_to());
			ps.setString(4, l.getDays());
			ps.setString(5, l.getContact_no());
			ps.setString(6, l.getReason());
			ps.setInt(7, l.getUserId());
			ps.setString(8, l.getStatus());

			int i = ps.executeUpdate();
			if (i == 1) {
				f = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}
	
	public List<Leave> getAllLeave() {
		List<Leave> list = new ArrayList<Leave>();
		Leave a = new Leave();

		try {
			String sql = "select * from leaves order by id desc ";
			PreparedStatement ps = conn.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				a = new Leave();
				a.setId(rs.getInt(1));
				a.setLeaveType(rs.getString(2));
				a.setDate_from(rs.getString(3));
				a.setDate_to(rs.getString(4));
				a.setDays(rs.getString(5));
				a.setContact_no(rs.getString(6));
				a.setReason(rs.getString(7));
				a.setUserId(rs.getInt(8));
				a.setStatus(rs.getString(9));
				list.add(a);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public List<Leave> getAllLeaveById(int id) {
		List<Leave> list = new ArrayList<Leave>();
		Leave a = new Leave();

		try {
			String sql = "select * from leaves where user_id=? order by id desc ";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1,id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				a = new Leave();
				a.setId(rs.getInt(1));
				a.setLeaveType(rs.getString(2));
				a.setDate_from(rs.getString(3));
				a.setDate_to(rs.getString(4));
				a.setDays(rs.getString(5));
				a.setContact_no(rs.getString(6));
				a.setReason(rs.getString(7));
				a.setUserId(rs.getInt(8));
				a.setStatus(rs.getString(9));
				list.add(a);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public boolean updateStatus(int id, int uid,String st) {
		boolean f = false;

		try {
			String sql = "update leaves set status=? where id=? and user_id=?";
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
			String sql = "delete from leaves where user_id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, uid);
			int i = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
