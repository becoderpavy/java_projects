package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.entity.ApplyCheck;

public class CheckDAO {
	private Connection conn;

	public CheckDAO(Connection conn) {
		super();
		this.conn = conn;
	}

	public boolean ApplyCheck(ApplyCheck ch) {
		boolean f = false;

		try {
			String sql = "insert into apply_check(name,accountno,status) values(?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, ch.getName());
			ps.setString(2, ch.getAccountNo());
			ps.setString(3, ch.getStatus());

			int i = ps.executeUpdate();
			if (i == 1) {
				f = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return f;
	}

	public List<ApplyCheck> getAllCheck() {
		List<ApplyCheck> list = new ArrayList<ApplyCheck>();
		ApplyCheck ap = null;

		try {
			String sql = "select * from apply_check";
			PreparedStatement ps = conn.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ap = new ApplyCheck(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
				list.add(ap);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<ApplyCheck> getAllCheckById(String id) {
		List<ApplyCheck> list = new ArrayList<ApplyCheck>();
		ApplyCheck ap = null;

		try {
			String sql = "select * from apply_check where accountno=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ap = new ApplyCheck(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
				list.add(ap);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public boolean updateCheckStatus(int id, String status) {
		boolean f = false;

		try {
			String sql = "update apply_check set status=? where id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, status);
			ps.setInt(2, id);

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
