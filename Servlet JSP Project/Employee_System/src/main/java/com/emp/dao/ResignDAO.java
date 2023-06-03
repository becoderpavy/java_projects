package com.emp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.emp.entity.Attendance;
import com.emp.entity.Resign;

public class ResignDAO {

	private Connection conn;

	public ResignDAO(Connection conn) {
		super();
		this.conn = conn;
	}

	public boolean AddResign(Resign r) {
		boolean f = false;
		try {
			String sql = "insert into resign(resign_type,resign_date,last_working_date,notice_sufered,contact_no,remark,userid,status) values(?,?,?,?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, r.getResignType());
			ps.setString(2, r.getResignDate());
			ps.setString(3, r.getLastWorkingDate());
			ps.setString(4, r.getNoticeSuferd());
			ps.setString(5, r.getContactNo());
			ps.setString(6, r.getRemark());
			ps.setInt(7, r.getUserId());
			ps.setString(8, r.getStatus());

			int i = ps.executeUpdate();
			if (i == 1) {
				f = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	public List<Resign> getAllResign() {
		List<Resign> list = new ArrayList<Resign>();
		Resign a = new Resign();

		try {
			String sql = "select * from resign order by id desc ";
			PreparedStatement ps = conn.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				a = new Resign();
				a.setId(rs.getInt(1));
				a.setResignType(rs.getString(2));
				a.setResignDate(rs.getString(3));
				a.setLastWorkingDate(rs.getString(4));
				a.setNoticeSuferd(rs.getString(5));
				a.setContactNo(rs.getString(6));
				a.setRemark(rs.getString(7));
				a.setUserId(rs.getInt(8));
				a.setStatus(rs.getString(9));
				list.add(a);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<Resign> getAllResignById(int id) {
		List<Resign> list = new ArrayList<Resign>();
		Resign a = new Resign();

		try {
			String sql = "select * from resign where userid=? order by id desc ";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				a = new Resign();
				a.setId(rs.getInt(1));
				a.setResignType(rs.getString(2));
				a.setResignDate(rs.getString(3));
				a.setLastWorkingDate(rs.getString(4));
				a.setNoticeSuferd(rs.getString(5));
				a.setContactNo(rs.getString(6));
				a.setRemark(rs.getString(7));
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
			String sql = "update resign set status=? where id=? and userid=?";
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
			String sql = "delete from resign where userid=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, uid);
			int i = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
