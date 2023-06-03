package com.admin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.entity.Course;

public class CourseDAO {

	private Connection conn;

	public CourseDAO(Connection conn) {
		super();
		this.conn = conn;
	}

	public boolean addCourse(String c) {
		boolean f = false;
		try {
			String sql = "insert into course(course_name) values(?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, c);

			int i = ps.executeUpdate();
			if (i == 1) {
				f = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	public List<Course> getCourse() {
		List<Course> list = new ArrayList<Course>();
		Course c = null;
		try {
			String sql = "select * from course";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				c = new Course(rs.getInt(1), rs.getString(2));
				list.add(c);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

}
