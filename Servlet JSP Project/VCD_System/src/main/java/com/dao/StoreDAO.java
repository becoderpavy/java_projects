package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.entites.Store;

public class StoreDAO {
	private Connection conn;

	public StoreDAO(Connection conn) {
		super();
		this.conn = conn;
	}

	public boolean addStore(Store s) {
		boolean f = false;
		try {
			String sql = "insert into stores(store_name,mob_no,address,img) values(?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, s.getStoreName());
			ps.setString(2, s.getMobNo());
			ps.setString(3, s.getAddress());
			ps.setString(4, s.getStoreImg());
			int i = ps.executeUpdate();
			if (i == 1) {
				f = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	public boolean updateStore(Store s) {
		boolean f = false;
		try {
			String sql = "update stores set store_name=?,mob_no=?,address=?,img=? where id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, s.getStoreName());
			ps.setString(2, s.getMobNo());
			ps.setString(3, s.getAddress());
			ps.setString(4, s.getStoreImg());
			ps.setInt(5, s.getId());
			int i = ps.executeUpdate();
			if (i == 1) {
				f = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	public List<Store> getAllStores() {
		List<Store> list = new ArrayList<Store>();
		Store s = null;
		try {
			String sql = "select * from stores";
			PreparedStatement ps = conn.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				s = new Store(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
				list.add(s);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<Store> getAllStoresBySearch(String ch) {
		List<Store> list = new ArrayList<Store>();
		Store s = null;
		try {
			String sql = "select * from stores where store_name like ? or address like ? order by id desc";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, "%" + ch + "%");
			ps.setString(2, "%" + ch + "%");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				s = new Store(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
				list.add(s);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public Store getStoreById(int id) {
		Store s = null;
		try {
			String sql = "select * from stores where id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				s = new Store(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return s;
	}

	public boolean deleteStore(int id) {
		boolean f = false;
		try {
			String sql = "delete from stores where id=?";
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
