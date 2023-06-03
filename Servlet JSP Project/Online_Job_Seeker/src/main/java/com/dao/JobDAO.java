package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.entites.Job;

public class JobDAO {
	private Connection conn;

	public JobDAO(Connection conn) {
		super();
		this.conn = conn;
	}

	public boolean addJobs(Job j) {
		boolean f = false;
		try {
			String sql = "insert into jobs(job_name,description,experience,skill,qualification,location,salary,vacancies,emp_name,contact_number,email,address,publish_date) values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, j.getJobName());
			ps.setString(2, j.getDescription());
			ps.setString(3, j.getExperience());
			ps.setString(4, j.getSkill());
			ps.setString(5, j.getQualification());
			ps.setString(6, j.getLocation());
			ps.setString(7, j.getSalary());
			ps.setString(8, j.getVacancies());
			ps.setString(9, j.getEmpName());
			ps.setString(10, j.getContactNumber());
			ps.setString(11, j.getEmail());
			ps.setString(12, j.getAddress());
			ps.setString(13, j.getPublishDate());

			int i = ps.executeUpdate();
			if (i == 1) {
				f = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	public List<Job> getAllJobs() {
		List<Job> list = new ArrayList<Job>();
		Job j = null;

		try {
			String sql = "select * from jobs order by id Desc";
			PreparedStatement ps = conn.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				j = new Job(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10),
						rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14));
				list.add(j);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public Job getJobById(int id) {

		Job j = null;

		try {
			String sql = "select * from jobs where id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				j = new Job(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10),
						rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return j;
	}

	public boolean updateJob(Job j) {
		boolean f = false;
		try {
			String sql = "update jobs set job_name=?,description=?,experience=?,skill=?,qualification=?,location=?,salary=?,vacancies=?,emp_name=?,contact_number=?,email=?,address=? where id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, j.getJobName());
			ps.setString(2, j.getDescription());
			ps.setString(3, j.getExperience());
			ps.setString(4, j.getSkill());
			ps.setString(5, j.getQualification());
			ps.setString(6, j.getLocation());
			ps.setString(7, j.getSalary());
			ps.setString(8, j.getVacancies());
			ps.setString(9, j.getEmpName());
			ps.setString(10, j.getContactNumber());
			ps.setString(11, j.getEmail());
			ps.setString(12, j.getAddress());
			ps.setLong(13, j.getId());
			int i = ps.executeUpdate();
			if (i == 1) {
				f = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	public boolean deleteJob(int id) {
		boolean f = false;
		try {
			String sql = "delete from jobs where id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			int i = ps.executeUpdate();
			if (i == 1) {
				f = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	public List<Job> getJobsBySearch(String ch) {
		List<Job> list = new ArrayList<Job>();
		Job j = null;

		try {
			String sql = "select * from jobs where skill like ? or location like ? or job_name like ? order by id desc";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, "%" + ch + "%");
			ps.setString(2, "%" + ch + "%");
			ps.setString(3, "%" + ch + "%");
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				j = new Job(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10),
						rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14));
				list.add(j);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

}
