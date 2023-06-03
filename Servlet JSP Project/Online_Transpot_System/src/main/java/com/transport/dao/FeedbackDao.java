package com.transport.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.transport.entites.Feedback;

public class FeedbackDao {
	private Connection conn;

	private PreparedStatement ps;

	private ResultSet rs;

	public FeedbackDao(Connection conn) {
		super();
		this.conn = conn;
	}

	public boolean createFeedback(Feedback fe) {
		boolean f = false;

		try {

			String sql = "insert into feedback(username,message,response) values(?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, fe.getUsername());
			ps.setString(2, fe.getMessage());
			ps.setString(3, fe.getResponse());

			int i = ps.executeUpdate();

			if (i == 1) {
				f = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return f;
	}

	public List<Feedback> getFeedbackByUserName(String userName) {
		List<Feedback> list = new ArrayList<Feedback>();

		Feedback fe = null;
		try {
			String sql = "select * from feedback where username=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, userName);

			rs = ps.executeQuery();

			while (rs.next()) {
				fe = new Feedback(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
				list.add(fe);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	public List<Feedback> getAllFeedback() {
		List<Feedback> list = new ArrayList<Feedback>();

		Feedback fe = null;
		try {
			String sql = "select * from feedback";
			ps = conn.prepareStatement(sql);

			rs = ps.executeQuery();

			while (rs.next()) {
				fe = new Feedback(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
				list.add(fe);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	public boolean updateFeedback(String res, int id) {
		boolean f = false;

		try {

			String sql = "update feedback set response=? where id=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, res);
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
