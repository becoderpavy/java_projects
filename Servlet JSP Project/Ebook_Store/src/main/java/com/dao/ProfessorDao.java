package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.entity.Professor;

public class ProfessorDao {
	private Connection conn;

	public ProfessorDao(Connection conn) {
		super();
		this.conn = conn;
	}

	public boolean addProfessor(Professor p) {
		boolean f = false;
		try {
			String sql = "insert into professor(name,email,password) values(?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, p.getName());
			ps.setString(2, p.getEmail());
			ps.setString(3, p.getPassword());

			int i = ps.executeUpdate();
			if (i == 1)
				f = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	public List<Professor> getAllProfessor() {
		List<Professor> list = new ArrayList<Professor>();
		Professor p = null;
		try {

			String sql = "select * from professor order by id desc";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				p = new Professor();
				p.setId(rs.getInt(1));
				p.setName(rs.getString(2));
				p.setEmail(rs.getString(3));
				p.setPassword(rs.getString(4));
				list.add(p);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public Professor getProfessorById(int id) {
		Professor p = null;
		try {

			String sql = "select * from professor where id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				p = new Professor();
				p.setId(rs.getInt(1));
				p.setName(rs.getString(2));
				p.setEmail(rs.getString(3));
				p.setPassword(rs.getString(4));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return p;
	}
	
	public Professor login(String em,String psw) {
		Professor p = null;
		try {
			String sql = "select * from professor where email=? and password=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, em);
			ps.setString(2, psw);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				p = new Professor();
				p.setId(rs.getInt(1));
				p.setName(rs.getString(2));
				p.setEmail(rs.getString(3));
				p.setPassword(rs.getString(4));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return p;
	}
	

	public boolean updateProfessor(Professor p) {
		boolean f = false;
		try {
			String sql = "update professor set name=?,email=?,password=? where id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, p.getName());
			ps.setString(2, p.getEmail());
			ps.setString(3, p.getPassword());
			ps.setInt(4, p.getId());

			int i = ps.executeUpdate();
			if (i == 1)
				f = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	public boolean checkEmail(String em) {
		boolean f = true;
		try {

			String sql = "select * from professor where email=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, em);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				f = false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	public boolean changePassword(int id, String psw) {
		boolean f = false;
		try {
			String sql = "update professor set password=? where id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, psw);
			ps.setInt(2, id);
			int i = ps.executeUpdate();
			if (i == 1)
				f = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}
	
	public boolean checkPassword(int id, String psw) {
		boolean f = false;
		try {
			String sql = "select * from professor where password=? and id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, psw);
			ps.setInt(2, id);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				f=true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	public boolean delteProf(int id) {
		boolean f = false;
		try {
			String sql = "delete from professor where id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			int i = ps.executeUpdate();
			if (i == 1)
				f = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

}
