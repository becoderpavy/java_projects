package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.entity.Category;
import com.entity.Organization;

public class OrganizationDAOImpl implements OrganizationDAO {

	private Connection conn;

	public OrganizationDAOImpl(Connection conn) {
		super();
		this.conn = conn;
	}

	public boolean addOrg(Organization o) {
		boolean f = false;
		try {
			String sql = "insert into organization(org_name,address,email,phno,password,status) values(?,?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, o.getOrgName());
			ps.setString(2, o.getAddress());
			ps.setString(3, o.getEmail());
			ps.setString(4, o.getPhno());
			ps.setString(5, o.getPassword());
			ps.setString(6, o.getStatus());
			int i = ps.executeUpdate();
			if (i == 1) {
				f = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	public Organization login(String em, String psw) {
		Organization org = null;
		try {
			String sql = "select * from organization where email=? and password=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, em);
			ps.setString(2, psw);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				org = new Organization();
				org.setId(rs.getInt(1));
				org.setOrgName(rs.getString(2));
				org.setAddress(rs.getString(3));
				org.setEmail(rs.getString(4));
				org.setPhno(rs.getString(5));
				org.setPassword(rs.getString(6));
				org.setStatus(rs.getString(7));

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return org;
	}

	public List<Organization> getAllOrg() {
		List<Organization> list = new ArrayList<Organization>();
		Organization org = null;
		try {
			String sql = "select * from organization where email=? and password=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				org = new Organization();
				org.setId(rs.getInt(1));
				org.setOrgName(rs.getString(2));
				org.setAddress(rs.getString(3));
				org.setEmail(rs.getString(4));
				org.setPhno(rs.getString(5));
				org.setPassword(rs.getString(6));
				org.setStatus(rs.getString(7));
				list.add(org);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public boolean checkUser(String em) {
		boolean f = true;
		try {
			String sql = "select * from organization where email=?";
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

	public Organization getOrgById(int id) {
		Organization org = null;
		try {
			String sql = "select * from organization where id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				org = new Organization();
				org.setId(rs.getInt(1));
				org.setOrgName(rs.getString(2));
				org.setAddress(rs.getString(3));
				org.setEmail(rs.getString(4));
				org.setPhno(rs.getString(5));
				org.setPassword(rs.getString(6));
				org.setStatus(rs.getString(7));

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return org;
	}

	public boolean addCategory(String categoryName) {
		boolean f = false;
		try {
			String sql = "insert into category(name) values(?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, categoryName);
			int i = ps.executeUpdate();
			if (i == 1) {
				f = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	public boolean updateCategory(String categoryName, int id) {
		boolean f = false;
		try {
			String sql = "update category set name=? where id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, categoryName);
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

	public boolean deleteCategory(int id) {
		boolean f = false;
		try {
			String sql = "delete from category where id=?";
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

	public List<Category> getAllCategory() {
		List<Category> list = new ArrayList<Category>();
		Category ca = null;
		try {
			String sql = "select * from category";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ca = new Category(rs.getInt(1), rs.getString(2));
				list.add(ca);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public Category getCategoryById(int id) {

		Category ca = null;
		try {
			String sql = "select * from category where id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ca = new Category(rs.getInt(1), rs.getString(2));

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ca;
	}

	public boolean checkPasswordAuthen(String email, String phno) {
		boolean f = false;
		try {

			String sql = "select * from organization where email=? and phno=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, email);
			ps.setString(2, phno);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				f = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	public boolean forgotPassword(String email, String phno, String password) {

		boolean f = false;
		try {
			String sql = "update organization set password=? where email=? and phno=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, password);
			ps.setString(2, email);
			ps.setString(3, phno);

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
