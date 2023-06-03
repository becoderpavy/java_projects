package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.entity.Department;

public class DepartmentDAO {
	private Connection conn;

	public DepartmentDAO(Connection conn) {
		super();
		this.conn = conn;
	}

	public boolean addDepart(int pid, String de) {
		boolean f = false;
		try {
			String sql = "insert into department(pid,depart_name) values(?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, pid);
			ps.setString(2, de);

			int i = ps.executeUpdate();
			if (i == 1)
				f = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	public boolean checkDepart(int pid, String de) {
		boolean f = true;
		try {
			String sql = "select * from department where pid=? and depart_name=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, pid);
			ps.setString(2, de);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				f = false;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	public boolean checkDepartBy(int pid, String de) {
		boolean f = false;
		try {
			String sql = "select * from department where pid=? and depart_name=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, pid);
			ps.setString(2, de);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				f = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	public List<Department> getDepartment(int id) {
		List<Department> list = new ArrayList<Department>();
		Department d = null;
		try {
			String sql = "select * from department where pid=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				d = new Department();
				d.setDeprtName(rs.getString(3));
				list.add(d);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

}
