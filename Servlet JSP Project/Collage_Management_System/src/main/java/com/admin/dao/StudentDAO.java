package com.admin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.entity.Student;
import com.entity.Teacher;

public class StudentDAO {
	private Connection conn;

	public StudentDAO(Connection conn) {
		super();
		this.conn = conn;
	}

	public boolean addStudent(Student s) {
		boolean f = false;
		try {
			String sql = "insert into student(roll,name,gender,dob,address,course,semestar,email,password) values(?,?,?,?,?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, s.getRoll());
			ps.setString(2, s.getName());
			ps.setString(3, s.getGender());
			ps.setString(4, s.getDob());
			ps.setString(5, s.getAddress());
			ps.setString(6, s.getCourse());
			ps.setString(7, s.getSemestar());
			ps.setString(8, s.getEmail());
			ps.setString(9, s.getPassword());

			int i = ps.executeUpdate();
			if (i == 1) {
				f = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	public List<Student> getData(String course, String sem) {
		List<Student> list = new ArrayList<Student>();
		Student s = null;
		try {

			String sql = "select * from student where course=? and semestar=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, course);
			ps.setString(2, sem);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				s = new Student();
				s.setId(rs.getInt(1));
				s.setRoll(rs.getString(2));
				s.setName(rs.getString(3));
				s.setGender(rs.getString(4));
				s.setDob(rs.getString(5));
				s.setAddress(rs.getString(6));
				s.setCourse(rs.getString(7));
				s.setSemestar(rs.getString(8));
				s.setEmail(rs.getString(9));
				s.setPassword(rs.getString(10));
				list.add(s);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public Student getStudentById(int id) {
		Student s = null;
		try {
			String sql = "select * from student where id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				s = new Student();
				s.setId(rs.getInt(1));
				s.setRoll(rs.getString(2));
				s.setName(rs.getString(3));
				s.setGender(rs.getString(4));
				s.setDob(rs.getString(5));
				s.setAddress(rs.getString(6));
				s.setCourse(rs.getString(7));
				s.setSemestar(rs.getString(8));
				s.setEmail(rs.getString(9));
				s.setPassword(rs.getString(10));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return s;
	}

	public boolean updateStudent(Student s) {
		boolean f = false;
		try {
			String sql = "update student set roll=?,name=?,gender=?,dob=?,address=?,course=?,semestar=?,email=?,password=? where id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, s.getRoll());
			ps.setString(2, s.getName());
			ps.setString(3, s.getGender());
			ps.setString(4, s.getDob());
			ps.setString(5, s.getAddress());
			ps.setString(6, s.getCourse());
			ps.setString(7, s.getSemestar());
			ps.setString(8, s.getEmail());
			ps.setString(9, s.getPassword());
			ps.setInt(10, s.getId());
			int i = ps.executeUpdate();
			if (i == 1) {
				f = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	public boolean deleteStudent(int id) {
		boolean f = false;
		try {
			String sql = "delete from student where id=?";
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

	public Student slogin(String email, String pa) {
		Student s = null;
		try {

			String sql = "select * from student where email=? and password=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, email);
			ps.setString(2, pa);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				s = new Student();
				s.setId(rs.getInt(1));
				s.setRoll(rs.getString(2));
				s.setName(rs.getString(3));
				s.setGender(rs.getString(4));
				s.setDob(rs.getString(5));
				s.setAddress(rs.getString(6));
				s.setCourse(rs.getString(7));
				s.setSemestar(rs.getString(8));
				s.setEmail(rs.getString(9));
				s.setPassword(rs.getString(10));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return s;
	}

	public int studentCount() {
		int i = 0;
		try {
			String sql = "select count(*) from student";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			rs.next();
			i = rs.getInt(1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}

	public Student getStubySem(int id,String sem) {
		Student s = null;
		try {
			String sql = "select * from student where id=? and semestar=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.setString(2, sem);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				s = new Student();
				s.setId(rs.getInt(1));
				s.setRoll(rs.getString(2));
				s.setName(rs.getString(3));
				s.setGender(rs.getString(4));
				s.setDob(rs.getString(5));
				s.setAddress(rs.getString(6));
				s.setCourse(rs.getString(7));
				s.setSemestar(rs.getString(8));
				s.setEmail(rs.getString(9));
				s.setPassword(rs.getString(10));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return s;
	}
	
	
	
}
