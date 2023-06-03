package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.entity.Patient;

public class PatientDAOImpl implements PatientDAO {
	private Connection conn;

	public PatientDAOImpl(Connection conn) {
		super();
		this.conn = conn;
	}

	public boolean addPatient(Patient p) {
		boolean f = false;
		try {
			String sql = "insert into patient(oid,name,problem,address,image,document,need_money,raise_money,status,category) values(?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, p.getOid());
			ps.setString(2, p.getName());
			ps.setString(3, p.getProblem());
			ps.setString(4, p.getAddress());
			ps.setString(5, p.getImage());
			ps.setString(6, p.getDocument());
			ps.setDouble(7, p.getNeedMoney());
			ps.setDouble(8, p.getRaiseMoney());
			ps.setString(9, p.getStatus());
			ps.setString(10, p.getCategory());
			int i = ps.executeUpdate();
			if (i == 1) {
				f = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	public List<Patient> getAllPatient() {
		List<Patient> list = new ArrayList<Patient>();
		Patient p = null;
		try {
			String sql = "select * from patient order by id desc";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				p = new Patient();
				p.setId(rs.getInt(1));
				p.setOid(rs.getInt(2));
				p.setName(rs.getString(3));
				p.setProblem(rs.getString(4));
				p.setAddress(rs.getString(5));
				p.setImage(rs.getString(6));
				p.setDocument(rs.getString(7));
				p.setNeedMoney(rs.getDouble(8));
				p.setRaiseMoney(rs.getDouble(9));
				p.setStatus(rs.getString(10));
				p.setCategory(rs.getString(11));
				list.add(p);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<Patient> getAllPatientByOrg(int oid) {
		List<Patient> list = new ArrayList<Patient>();
		Patient p = null;
		try {
			String sql = "select * from patient where oid=? order by id desc";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, oid);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				p = new Patient();
				p.setId(rs.getInt(1));
				p.setOid(rs.getInt(2));
				p.setName(rs.getString(3));
				p.setProblem(rs.getString(4));
				p.setAddress(rs.getString(5));
				p.setImage(rs.getString(6));
				p.setDocument(rs.getString(7));
				p.setNeedMoney(rs.getDouble(8));
				p.setRaiseMoney(rs.getDouble(9));
				p.setStatus(rs.getString(10));
				p.setCategory(rs.getString(11));
				list.add(p);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<Patient> getAllPatientByStatus(String sql) {
		List<Patient> list = new ArrayList<Patient>();
		Patient p = null;
		try {
			//String sql = "select * from patient where status=? order by id desc";
			PreparedStatement ps = conn.prepareStatement(sql);
			//ps.setString(1, "Approved");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				p = new Patient();
				p.setId(rs.getInt(1));
				p.setOid(rs.getInt(2));
				p.setName(rs.getString(3));
				p.setProblem(rs.getString(4));
				p.setAddress(rs.getString(5));
				p.setImage(rs.getString(6));
				p.setDocument(rs.getString(7));
				p.setNeedMoney(rs.getDouble(8));
				p.setRaiseMoney(rs.getDouble(9));
				p.setStatus(rs.getString(10));
				p.setCategory(rs.getString(11));
				list.add(p);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public boolean updatePatient(String st, int id) {
		boolean f = false;
		try {
			String sql = "update patient set status=? where id=?";
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

	public Patient getPatientByOrgAndId(int pid, int oid) {

		Patient p = null;
		try {
			String sql = "select * from patient where id=? and oid=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, pid);
			ps.setInt(2, oid);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				p = new Patient();
				p.setId(rs.getInt(1));
				p.setOid(rs.getInt(2));
				p.setName(rs.getString(3));
				p.setProblem(rs.getString(4));
				p.setAddress(rs.getString(5));
				p.setImage(rs.getString(6));
				p.setDocument(rs.getString(7));
				p.setNeedMoney(rs.getDouble(8));
				p.setRaiseMoney(rs.getDouble(9));
				p.setStatus(rs.getString(10));
				p.setCategory(rs.getString(11));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return p;
	}

	public Patient getPatientById(int id) {
		Patient p = null;
		try {
			String sql = "select * from patient where id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				p = new Patient();
				p.setId(rs.getInt(1));
				p.setOid(rs.getInt(2));
				p.setName(rs.getString(3));
				p.setProblem(rs.getString(4));
				p.setAddress(rs.getString(5));
				p.setImage(rs.getString(6));
				p.setDocument(rs.getString(7));
				p.setNeedMoney(rs.getDouble(8));
				p.setRaiseMoney(rs.getDouble(9));
				p.setStatus(rs.getString(10));
				p.setCategory(rs.getString(11));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return p;
	}

	public boolean deletePatient(int id) {
		boolean f = false;
		try {
			String sql = "delete from patient where id=?";
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

	public boolean updateAmount(Double amt, int id) {
		boolean f = false;
		try {
			String sql = "update patient set raise_money=? where id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setDouble(1, amt);
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
