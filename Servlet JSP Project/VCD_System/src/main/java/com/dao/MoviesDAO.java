package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.entites.Movies;

public class MoviesDAO {
	private Connection conn;

	public MoviesDAO(Connection conn) {
		super();
		this.conn = conn;
	}

	public boolean addMovies(Movies m) {
		boolean f = false;
		try {

			String sql = "insert into movies(movies_name,language,category,ratings,quantity,cost,description,storeId,img) values(?,?,?,?,?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, m.getMoviesName());
			ps.setString(2, m.getLanguage());
			ps.setString(3, m.getCategory());
			ps.setString(4, m.getRatings());
			ps.setString(5, m.getQuantity());
			ps.setString(6, m.getCost());
			ps.setString(7, m.getDescription());
			ps.setInt(8, m.getStoreId());
			ps.setString(9, m.getImg());

			int i = ps.executeUpdate();

			if (i == 1) {
				f = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	public List<Movies> getAllMovies() {
		List<Movies> list = new ArrayList<Movies>();
		Movies m = null;

		try {
			String sql = "select * from movies order by id desc";
			PreparedStatement ps = conn.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				m = new Movies(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getString(7), rs.getString(8), rs.getInt(9), rs.getString(10));
				list.add(m);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<Movies> getAllMoviesBySeach(String ch) {
		List<Movies> list = new ArrayList<Movies>();
		Movies m = null;

		try {
			String sql = "select * from movies where movies_name like ? or language like ? or category like ? or ratings like ? order by id desc";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, "%" + ch + "%");
			ps.setString(2, "%" + ch + "%");
			ps.setString(3, "%" + ch + "%");
			ps.setString(4, "%" + ch + "%");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				m = new Movies(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getString(7), rs.getString(8), rs.getInt(9), rs.getString(10));
				list.add(m);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<Movies> getAllMoviesByStoreId(int storeId) {
		List<Movies> list = new ArrayList<Movies>();
		Movies m = null;

		try {
			String sql = "select * from movies where storeId=? order by id desc";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, storeId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				m = new Movies(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getString(7), rs.getString(8), rs.getInt(9), rs.getString(10));
				list.add(m);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public Movies getMoviesById(int id) {

		Movies m = null;

		try {
			String sql = "select * from movies where id=? ";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				m = new Movies(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getString(7), rs.getString(8), rs.getInt(9), rs.getString(10));

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return m;
	}

	public boolean updateMovies(Movies m) {
		boolean f = false;
		try {

			String sql = "update movies set movies_name=?,language=?,category=?,ratings=?,quantity=?,cost=?,description=?,storeId=?,img=? where id=? ";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, m.getMoviesName());
			ps.setString(2, m.getLanguage());
			ps.setString(3, m.getCategory());
			ps.setString(4, m.getRatings());
			ps.setString(5, m.getQuantity());
			ps.setString(6, m.getCost());
			ps.setString(7, m.getDescription());
			ps.setInt(8, m.getStoreId());
			ps.setString(9, m.getImg());
			ps.setInt(10, m.getId());
			int i = ps.executeUpdate();

			if (i == 1) {
				f = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	public boolean deleteMovies(int id) {
		boolean f = false;
		try {

			String sql = "delete from movies where id=? ";
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
