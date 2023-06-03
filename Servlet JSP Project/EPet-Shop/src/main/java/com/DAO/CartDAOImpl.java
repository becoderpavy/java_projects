package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.entity.CartDtls;

public class CartDAOImpl implements CartDAO {

	private Connection conn;

	public CartDAOImpl(Connection conn) {
		this.conn = conn;
	}

	public boolean addCart(CartDtls c) {
		boolean f = false;
		try {
			String sql = "insert into cart(uid,pid,name,price,categories,sid) values(?,?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, c.getUserId());
			ps.setInt(2, c.getPetsId());
			ps.setString(3, c.getPetsName());
			ps.setDouble(4, c.getPrice());
			ps.setString(5, c.getCategorie());
			ps.setInt(6, c.getShopId());
			int i = ps.executeUpdate();
			if (i == 1) {
				f = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	public List<CartDtls> getCartPetsByUser(int userId) {
		List<CartDtls> list = new ArrayList<CartDtls>();
		CartDtls c = null;
		double totalPrice = 0;
		try {
			String sql = "select * from cart where uid=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, userId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				c = new CartDtls();
				c.setId(rs.getInt(1));
				c.setUserId(rs.getInt(2));
				c.setPetsId(rs.getInt(3));
				c.setPetsName(rs.getString(4));
				c.setPrice(rs.getDouble(5));
				c.setCategorie(rs.getString(6));
				c.setShopId(rs.getInt(7));
				totalPrice = totalPrice + rs.getDouble(5);
				c.setTotalPrice(totalPrice);

				list.add(c);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public boolean deleteCart(int id, int uid) {

		boolean f = false;
		try {
			String sql = "delete from cart where id=? and uid=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.setInt(2, uid);

			int i = ps.executeUpdate();
			if (i == 1) {
				f = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return f;
	}
	
	
	public boolean deleteuser(int uid) {
		boolean f = false;
		try {
			String sql = "delete from cart where uid=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, uid);
			
			int i = ps.executeUpdate();
			if (i == 1) {
				f = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return f;
	}

}
