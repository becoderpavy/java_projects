package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import com.entity.cart;
import com.mysql.cj.Session;

public class CartDAOImpl implements CartDAO {

	private Connection conn;

	public CartDAOImpl(Connection conn) {
		super();
		this.conn = conn;
	}

	public boolean addCart(cart c) {
		boolean f = false;
		
		try {

			String sql = "insert into cart(bid,uid,book_name,author,price) values(?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, c.getBid());
			ps.setInt(2, c.getUid());
			ps.setString(3, c.getBookName());
			ps.setString(4, c.getAuthor());
			ps.setInt(5, c.getPrice());
			int i = ps.executeUpdate();
			if (i == 1)
				f = true;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	public List<cart> getCartDetails(int uid) {
		List<cart> list = new ArrayList<cart>();
		cart ob = null;
		try {
			String sql = "select * from cart where uid=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, uid);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ob = new cart();
				ob.setCid(rs.getInt(1));
				ob.setBid(rs.getInt(2));
				ob.setUid(rs.getInt(3));
				ob.setBookName(rs.getString(4));
				ob.setAuthor(rs.getString(5));
				ob.setPrice(rs.getInt(6));
				list.add(ob);
			}
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	public boolean removeCart(int bid, int uid) {
		boolean f = false;
		try {
			String sql = "delete from cart where bid=? and uid=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, bid);
			ps.setInt(2, uid);
			ps.execute();
			f = true;
		} catch (Exception e) {
			// TODO: handle exception
		}

		return f;
	}

	public boolean cartCheck(int id) {
		boolean f = false;
		try {
			String sql = "select * from cart where uid=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				f = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	

}
