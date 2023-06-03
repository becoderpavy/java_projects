package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.entity.Candidates;

public class CandidateDAO {
	private Connection conn;

	public CandidateDAO(Connection conn) {
		super();
		this.conn = conn;
	}

	public boolean saveCandidates(Candidates c) {
		boolean f = false;
		try {
			String sql = "insert into candidates(name, email, user_id, job_id, interview_date, resume) values(?,?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, c.getName());
			ps.setString(2, c.getEmail());
			ps.setInt(3, c.getUserId());
			ps.setInt(4, c.getJobId());
			ps.setString(5, c.getInterviewDate());
			ps.setString(6, c.getResume());

			int i = ps.executeUpdate();
			if (i == 1) {
				f = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return f;
	}

	public List<Candidates> getAllCandidates() {
		List<Candidates> list = new ArrayList<Candidates>();
		Candidates c = null;
		try {
			String sql = "select * from candidates";
			PreparedStatement ps = conn.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				c = new Candidates();
				c.setId(rs.getInt(1));
				c.setName(rs.getString(2));
				c.setEmail(rs.getString(3));
				c.setUserId(rs.getInt(4));
				c.setJobId(rs.getInt(5));
				c.setInterviewDate(rs.getString(6));
				c.setResume(rs.getString(7));
				list.add(c);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	public List<Candidates> getCandidatesByUser(int id) {
		List<Candidates> list = new ArrayList<Candidates>();
		Candidates c = null;
		try {
			String sql = "select * from candidates where user_id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				c = new Candidates();
				c.setId(rs.getInt(1));
				c.setName(rs.getString(2));
				c.setEmail(rs.getString(3));
				c.setUserId(rs.getInt(4));
				c.setJobId(rs.getInt(5));
				c.setInterviewDate(rs.getString(6));
				c.setResume(rs.getString(7));
				list.add(c);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	public Candidates getCandidatesById(int id) {

		Candidates c = null;
		try {
			String sql = "select * from candidates where id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				c = new Candidates();
				c.setId(rs.getInt(1));
				c.setName(rs.getString(2));
				c.setEmail(rs.getString(3));
				c.setUserId(rs.getInt(4));
				c.setJobId(rs.getInt(5));
				c.setInterviewDate(rs.getString(6));
				c.setResume(rs.getString(7));

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return c;
	}

	public boolean scheduleInterview(int cid, String date) {
		boolean f = false;

		try {
			String sql = "update candidates set interview_date=? where id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, date);
			ps.setInt(2, cid);

			int i = ps.executeUpdate();
			if (i == 1) {
				f = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return f;
	}

	public boolean checkJobApplyStatus(int userId, int jobId) {
		boolean f = false;

		try {
			String sql = "select * from candidates where user_id=? and job_id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, userId);
			ps.setInt(2, jobId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				f = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

}
