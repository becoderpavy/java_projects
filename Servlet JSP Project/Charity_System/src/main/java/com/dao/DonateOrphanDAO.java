package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.entity.Donate;
import com.entity.DonateOrphan;

public class DonateOrphanDAO {
	private Connection conn;

	public DonateOrphanDAO(Connection conn) {
		super();
		this.conn = conn;
	}

	public boolean addPayment(DonateOrphan d) {
		boolean f = false;
		try {
			String sql = "insert into orphans_donate(donar_id,pat_id,name,amt,status) values(?,?,?,?,?)";
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

	public List<DonateOrphan> getAllDonates() {
		List<DonateOrphan> list = new ArrayList<DonateOrphan>();
		DonateOrphan d = null;
		try {
			String sql = "select * from orphans_donate order by id desc";
			PreparedStatement ps = conn.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				d = new DonateOrphan();
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

	public List<DonateOrphan> getDonate(int did) {
		List<DonateOrphan> list = new ArrayList<DonateOrphan>();
		DonateOrphan d = null;
		try {
			String sql = "select * from orphans_donate where donar_id=? order by id desc";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, did);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				d = new DonateOrphan();
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

	public DonateOrphan getDonateById(int id) {

		DonateOrphan d = null;
		try {
			String sql = "select * from orphans_donate where id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				d = new DonateOrphan();
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
			String sql = "update orphans_donate set status=? where id=?";
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
