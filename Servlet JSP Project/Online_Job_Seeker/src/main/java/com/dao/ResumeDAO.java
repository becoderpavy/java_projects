package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.entites.Resume;

public class ResumeDAO {
	private Connection conn;

	public ResumeDAO(Connection conn) {
		super();
		this.conn = conn;
	}

	public boolean addResume(Resume r) {
		boolean f = false;

		try {

			String sql = "insert into resume (firstName,middleName,lastName,address,dob,gender,maritalStatus,phoneNumber,email,qualification,institute,yearOfGraduation,previousEmployer,previousDesignation,currentEmployer,currentDesignation,totalExperience,skill,userId,resumeFileName) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, r.getFirstName());
			ps.setString(2, r.getMiddleName());
			ps.setString(3, r.getLastName());
			ps.setString(4, r.getAddress());
			ps.setString(5, r.getDob());
			ps.setString(6, r.getGender());
			ps.setString(7, r.getMaritalStatus());
			ps.setString(8, r.getPhoneNumber());
			ps.setString(9, r.getEmail());
			ps.setString(10, r.getQualification());
			ps.setString(11, r.getInstitute());
			ps.setString(12, r.getYearOfGraduation());
			ps.setString(13, r.getPreviousEmployer());
			ps.setString(14, r.getPreviousDesignation());
			ps.setString(15, r.getCurrentEmployer());
			ps.setString(16, r.getCurrentDesignation());
			ps.setString(17, r.getTotalExperience());
			ps.setString(18, r.getSkill());
			ps.setInt(19, r.getUserId());
			ps.setString(20, r.getResumeFileName());

			int i = ps.executeUpdate();
			if (i == 1) {
				f = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	public Resume getResumeByUserId(int uid) {
		Resume r = null;
		try {

			String sql = "select * from resume where userId=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, uid);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				r = new Resume(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10),
						rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14), rs.getString(15),
						rs.getString(16), rs.getString(17), rs.getString(18), rs.getString(19), rs.getInt(20),
						rs.getString(21));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return r;
	}

	public Resume getResumeById(int id) {
		Resume r = null;
		try {

			String sql = "select * from resume where id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				r = new Resume(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10),
						rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14), rs.getString(15),
						rs.getString(16), rs.getString(17), rs.getString(18), rs.getString(19), rs.getInt(20),
						rs.getString(21));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return r;
	}

	public boolean updateResume(Resume r) {
		boolean f = false;
		try {
			String sql = "update resume set firstName=?,middleName=?,lastName=?,address=?,dob=?,gender=?,maritalStatus=?,phoneNumber=?,email=?,qualification=?,institute=?,yearOfGraduation=?,previousEmployer=?,previousDesignation=?,currentEmployer=?,currentDesignation=?,totalExperience=?,skill=? where id=?";

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, r.getFirstName());
			ps.setString(2, r.getMiddleName());
			ps.setString(3, r.getLastName());
			ps.setString(4, r.getAddress());
			ps.setString(5, r.getDob());
			ps.setString(6, r.getGender());
			ps.setString(7, r.getMaritalStatus());
			ps.setString(8, r.getPhoneNumber());
			ps.setString(9, r.getEmail());
			ps.setString(10, r.getQualification());
			ps.setString(11, r.getInstitute());
			ps.setString(12, r.getYearOfGraduation());
			ps.setString(13, r.getPreviousEmployer());
			ps.setString(14, r.getPreviousDesignation());
			ps.setString(15, r.getCurrentEmployer());
			ps.setString(16, r.getCurrentDesignation());
			ps.setString(17, r.getTotalExperience());
			ps.setString(18, r.getSkill());
			// ps.setString(19, r.getResumeFileName());
			ps.setInt(19, r.getId());
			int i = ps.executeUpdate();
			if (i == 1) {
				f = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	public boolean checkResume(int userId) {
		boolean f = false;

		try {
			String sql = "select * from resume where userId=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, userId);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				f = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return f;
	}

	public boolean deleteResume(int id) {
		boolean f = false;

		try {
			String sql = "delete from resume where id=?";
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

	public List<Resume> getResumeBySearch(String ch) {
		List<Resume> list = new ArrayList<Resume>();
		Resume r = null;
		try {

			String sql = "select * from resume where firstName like ? or totalExperience like ? or skill like ? or address like ? order by id desc";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1,ch+"%" );
			ps.setString(2,"%"+ch+"%");
			ps.setString(3,"%"+ch+"%");
			ps.setString(4,"%"+ch+"%");

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				r = new Resume(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10),
						rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14), rs.getString(15),
						rs.getString(16), rs.getString(17), rs.getString(18), rs.getString(19), rs.getInt(20),
						rs.getString(21));
				list.add(r);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}
	
	public List<Resume> getAllResume() {
		List<Resume> list = new ArrayList<Resume>();
		Resume r = null;
		try {

			String sql = "select * from resume order by id desc";
			PreparedStatement ps = conn.prepareStatement(sql);
			

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				r = new Resume(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10),
						rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14), rs.getString(15),
						rs.getString(16), rs.getString(17), rs.getString(18), rs.getString(19), rs.getInt(20),
						rs.getString(21));
				list.add(r);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

}
