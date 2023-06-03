package com.emp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.emp.entity.Helpline;

public class HelplineDAO {
	private Connection conn;

	public HelplineDAO(Connection conn) {
		super();
		this.conn = conn;
	}

	public boolean addHelpline(Helpline h) {
		boolean f = false;
		try {
			String sql = "insert into helpline(title,reason,userid,status) values(?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, h.getTitle());
			ps.setString(2, h.getReason());
			ps.setInt(3, h.getUserid());
			ps.setString(4, h.getStatus());

			int i = ps.executeUpdate();
			if (i == 1) {
				f = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	public List<Helpline> gethelpById(int id) {
		List<Helpline> list = new ArrayList<Helpline>();
		Helpline h = null;

		try {
			String sql = "select * from helpline where userid=? order by id desc";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				h = new Helpline();
				h.setId(rs.getInt(1));
				h.setTitle(rs.getString(2));
				h.setReason(rs.getString(3));
				h.setUserid(rs.getInt(4));
				h.setStatus(rs.getString(5));
				list.add(h);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<Helpline> gethelp() {
		List<Helpline> list = new ArrayList<Helpline>();
		Helpline h = null;
		try {
			String sql = "select * from helpline order by id desc";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				h = new Helpline();
				h.setId(rs.getInt(1));
				h.setTitle(rs.getString(2));
				h.setReason(rs.getString(3));
				h.setUserid(rs.getInt(4));
				h.setStatus(rs.getString(5));
				list.add(h);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public boolean updateStatus(int tid, int uid, String st) {
		boolean f = false;
		try {
			String sql = "update helpline set status=? where id=? and userid=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, st);
			ps.setInt(2, tid);
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

	public Helpline gethelpByTid(int tid, int uid) {
		Helpline h = null;
		try {
			String sql = "select * from helpline where id=? and userid=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, tid);
			ps.setInt(2, uid);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				h = new Helpline();
				h.setId(rs.getInt(1));
				h.setTitle(rs.getString(2));
				h.setReason(rs.getString(3));
				h.setUserid(rs.getInt(4));
				h.setStatus(rs.getString(5));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return h;
	}
	
	public void deleteData(int uid) {
		try {
			String sql = "delete from helpline where userid=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, uid);
			int i = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
