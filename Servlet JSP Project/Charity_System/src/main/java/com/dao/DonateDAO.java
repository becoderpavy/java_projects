package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.entity.Donate;

public class DonateDAO {
	private Connection conn;

	public DonateDAO(Connection conn) {
		super();
		this.conn = conn;
	}

	public boolean addPayment(Donate d) {
		boolean f = false;
		try {
			String sql = "insert into donate(donar_id,pat_id,name,amt,status) values(?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, d.getDid());
			ps.setInt(2, d.getPid());
			ps.setString(3, d.getName());
			ps.setDouble(4, d.getAmount());
			ps.setString(5, d.getStatus());

			int i = ps.executeUpdate();
			if (i == 1) {
				f = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	public List<Donate> getAllDonates() {
		List<Donate> list = new ArrayList<Donate>();
		Donate d = null;
		try {
			String sql = "select * from donate order by id desc";
			PreparedStatement ps = conn.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				d = new Donate();
				d.setId(rs.getInt(1));
				d.setDid(rs.getInt(2));
				d.setPid(rs.getInt(3));
				d.setName(rs.getString(4));
				d.setAmount(rs.getDouble(5));
				d.setStatus(rs.getString(6));
				list.add(d);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<Donate> getDonate(int did) {
		List<Donate> list = new ArrayList<Donate>();
		Donate d = null;
		try {
			String sql = "select * from donate where donar_id=? order by id desc";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, did);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				d = new Donate();
				d.setId(rs.getInt(1));
				d.setDid(rs.getInt(2));
				d.setPid(rs.getInt(3));
				d.setName(rs.getString(4));
				d.setAmount(rs.getDouble(5));
				d.setStatus(rs.getString(6));
				list.add(d);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public Donate getDonateById(int id) {

		Donate d = null;
		try {
			String sql = "select * from donate where id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				d = new Donate();
				d.setId(rs.getInt(1));
				d.setDid(rs.getInt(2));
				d.setPid(rs.getInt(3));
				d.setName(rs.getString(4));
				d.setAmount(rs.getDouble(5));
				d.setStatus(rs.getString(6));

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return d;
	}

	public boolean updatePayment(String st, int id) {
		boolean f = false;
		try {
			String sql = "update donate set status=? where id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, st);
			ps.setInt(2, id);

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
