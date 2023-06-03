package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.entity.ShopDtls;

public class ShopDAOImpl implements ShopDAO {
	private Connection conn;

	public ShopDAOImpl(Connection conn) {
		super();
		this.conn = conn;
	}

	public boolean shopRegister(ShopDtls s) {
		boolean f = false;
		try {
			String sql = "insert into shop(owner_name,shop_name,phno,address,city,state,email,password,image,role,status) values(?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, s.getOwnerName());
			ps.setString(2, s.getShopName());
			ps.setString(3, s.getPhno());
			ps.setString(4, s.getAddress());
			ps.setString(5, s.getCity());
			ps.setString(6, s.getState());
			ps.setString(7, s.getEmail());
			ps.setString(8, s.getPassword());
			ps.setString(9, s.getImage());
			ps.setString(10, s.getRole());
			ps.setString(11, s.getStatus());
			int i = ps.executeUpdate();
			if (i == 1) {
				f = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	public ShopDtls login(String em, String psw) {
		ShopDtls s = null;

		try {
			String sql = "select * from shop where email=? and password=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, em);
			ps.setString(2, psw);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				s = new ShopDtls();
				s.setId(rs.getInt(1));
				s.setOwnerName(rs.getString(2));
				s.setShopName(rs.getString(3));
				s.setPhno(rs.getString(4));
				s.setAddress(rs.getString(5));
				s.setCity(rs.getString(6));
				s.setState(rs.getString(7));
				s.setEmail(rs.getString(8));
				s.setPassword(rs.getString(9));
				s.setImage(rs.getString(10));
				s.setRole(rs.getString(11));
				s.setStatus(rs.getString(12));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return s;
	}

	public boolean checkUser(String em) {
		boolean f = true;
		try {
			String sql = "select * from shop where email=?";
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

	public List<ShopDtls> getShop() {
		List<ShopDtls> list = new ArrayList<ShopDtls>();
		ShopDtls s = null;
		try {
			String sql = "select * from shop order by id desc";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				s = new ShopDtls();
				s.setId(rs.getInt(1));
				s.setOwnerName(rs.getString(2));
				s.setShopName(rs.getString(3));
				s.setPhno(rs.getString(4));
				s.setAddress(rs.getString(5));
				s.setCity(rs.getString(6));
				s.setState(rs.getString(7));
				s.setEmail(rs.getString(8));
				s.setPassword(rs.getString(9));
				s.setImage(rs.getString(10));
				s.setRole(rs.getString(11));
				s.setStatus(rs.getString(12));
				list.add(s);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public boolean update(ShopDtls s) {
		boolean f = false;
		try {
			String sql = "update shop set owner_name=?,shop_name=?,phno=?,address=?,city=?,state=?,email=?,password=? where id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, s.getOwnerName());
			ps.setString(2, s.getShopName());
			ps.setString(3, s.getPhno());
			ps.setString(4, s.getAddress());
			ps.setString(5, s.getCity());
			ps.setString(6, s.getState());
			ps.setString(7, s.getEmail());
			ps.setString(8, s.getPassword());

			ps.setInt(9, s.getId());

			int i = ps.executeUpdate();
			if (i == 1) {
				f = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	public boolean checkPassword(int id, String ps) {
		boolean f = false;
		try {
			String sql = "select * from shop where id=? and password=?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, id);
			pst.setString(2, ps);

			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				f = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	public ShopDtls getShopById(int id) {
		ShopDtls s = null;

		try {
			String sql = "select * from shop where id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				s = new ShopDtls();
				s.setId(rs.getInt(1));
				s.setOwnerName(rs.getString(2));
				s.setShopName(rs.getString(3));
				s.setPhno(rs.getString(4));
				s.setAddress(rs.getString(5));
				s.setCity(rs.getString(6));
				s.setState(rs.getString(7));
				s.setEmail(rs.getString(8));
				s.setPassword(rs.getString(9));
				s.setImage(rs.getString(10));
				s.setRole(rs.getString(11));
				s.setStatus(rs.getString(12));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return s;
	}

	public boolean deleteShop(int id) {
		boolean f = false;
		try {
			String sql = "delete from shop where id=?";
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

	public boolean checkPasswordAuthen(String email, String phno) {
		boolean f = false;
		try {

			String sql = "select * from shop where email=? and phno=?";
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
			String sql = "update shop set password=? where email=? and phno=?";
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
