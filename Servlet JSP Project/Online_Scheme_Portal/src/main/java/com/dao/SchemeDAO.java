package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.entites.Scheme;

public class SchemeDAO {

	private Connection conn;

	public SchemeDAO(Connection conn) {
		super();
		this.conn = conn;
	}

	public boolean addScheme(Scheme sc) {
		boolean f = false;
		try {
			String sql = "insert into scheme(scheme_name,description,site_link,publish_date,file_name,category) values(?,?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, sc.getSchemeName());
			ps.setString(2, sc.getDescription());
			ps.setString(3, sc.getSiteLink());
			ps.setString(4, sc.getPublishDate());
			ps.setString(5, sc.getFileName());
			ps.setString(6, sc.getCategory());
			int i = ps.executeUpdate();
			if (i == 1) {
				f = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	public boolean updateScheme(Scheme sc) {
		boolean f = false;
		try {
			String sql = "update scheme set scheme_name=?,description=?,site_link=?,publish_date=?,file_name=?,category=? where id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, sc.getSchemeName());
			ps.setString(2, sc.getDescription());
			ps.setString(3, sc.getSiteLink());
			ps.setString(4, sc.getPublishDate());
			ps.setString(5, sc.getFileName());
			ps.setString(6, sc.getCategory());
			ps.setInt(7, sc.getId());

			int i = ps.executeUpdate();
			if (i == 1) {
				f = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	public List<Scheme> getAllScheme() {
		List<Scheme> list = new ArrayList<Scheme>();
		Scheme sc = null;
		try {

			String sql = "select * from scheme order by id desc";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				sc = new Scheme(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getString(7));
				list.add(sc);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public List<Scheme> getAllSchemeByCategory(String cat) {
		List<Scheme> list = new ArrayList<Scheme>();
		Scheme sc = null;
		try {

			String sql = "select * from scheme where category=? order by id desc";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1,cat);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				sc = new Scheme(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getString(7));
				list.add(sc);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public Scheme getSchemeById(int id) {

		Scheme sc = null;
		try {
			String sql = "select * from scheme where id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			ps.setInt(1, id);
			while (rs.next()) {
				sc = new Scheme(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getString(7));

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return sc;
	}

	public boolean deleteScheme(int id) {
		boolean f = false;
		try {
			String sql = "delete from scheme where id=?";
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

}
