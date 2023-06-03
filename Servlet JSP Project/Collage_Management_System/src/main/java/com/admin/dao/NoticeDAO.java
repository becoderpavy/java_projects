package com.admin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.entity.Notice;

public class NoticeDAO {
	private Connection conn;

	public NoticeDAO(Connection conn) {
		super();
		this.conn = conn;
	}

	public boolean addNotice(String n, String m) {
		boolean f = false;

		try {
			String sql = "insert into notice(name,message) values(?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, n);
			ps.setString(2, m);

			int i = ps.executeUpdate();
			if (i == 1) {
				f = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	public List<Notice> getNotice() {
		List<Notice> list = new ArrayList<Notice>();
		Notice n = null;
		try {
			String sql = "select * from notice order by id DESC";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				n = new Notice();
				n.setId(rs.getInt(1));
				n.setName(rs.getString(2));
				n.setMessage(rs.getString(3));
				n.setDate(rs.getString(4));
				list.add(n);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;

	}

}
