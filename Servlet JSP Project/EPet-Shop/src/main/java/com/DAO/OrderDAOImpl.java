package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.entity.OrderDtls;

public class OrderDAOImpl implements OrderDAO {

	private Connection conn;

	public OrderDAOImpl(Connection conn) {
		super();
		this.conn = conn;
	}

	public boolean addOrder(List<OrderDtls> orderList) {
		boolean f = false;

		try {
			String sql = "insert into pet_order(uid,sid,order_id,user_name,email,address,phno,category,petname,price,payment_type,status,date) values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
			conn.setAutoCommit(false);

			PreparedStatement ps = conn.prepareStatement(sql);

			for (OrderDtls o : orderList) {
				ps.setInt(1, o.getUserId());
				ps.setInt(2, o.getShopId());
				ps.setString(3, o.getOrderId());
				ps.setString(4, o.getUserName());
				ps.setString(5, o.getEmail());
				ps.setString(6, o.getAddress());
				ps.setString(7, o.getPhno());
				ps.setString(8, o.getCategorie());
				ps.setString(9, o.getPetName());
				ps.setDouble(10, o.getPrice());
				ps.setString(11, o.getPaymentType());
				ps.setString(12, o.getStatus());
				ps.setString(13, o.getDate());
				ps.addBatch();
			}
			int[] count = ps.executeBatch();
			conn.commit();
			f = true;
			conn.setAutoCommit(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	public List<OrderDtls> getOrderForShop(int sid) {
		List<OrderDtls> list = new ArrayList<OrderDtls>();
		OrderDtls ord = null;
		try {
			String sql = "select * from pet_order where sid=? order by id desc";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, sid);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ord = new OrderDtls();
				ord.setId(rs.getInt(1));
				ord.setUserId(rs.getInt(2));
				ord.setShopId(rs.getInt(3));
				ord.setOrderId(rs.getString(4));
				ord.setUserName(rs.getString(5));
				ord.setEmail(rs.getString(6));
				ord.setAddress(rs.getString(7));
				ord.setPhno(rs.getString(8));
				ord.setCategorie(rs.getString(9));
				ord.setPetName(rs.getString(10));
				ord.setPrice(rs.getDouble(11));
				ord.setPaymentType(rs.getString(12));
				ord.setStatus(rs.getString(13));
				ord.setDate(rs.getString(14));
				list.add(ord);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<OrderDtls> getOrderForUser(int uid) {

		List<OrderDtls> list = new ArrayList<OrderDtls>();
		OrderDtls ord = null;
		try {
			String sql = "select * from pet_order where uid=? order by id desc";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, uid);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ord = new OrderDtls();
				ord.setId(rs.getInt(1));
				ord.setUserId(rs.getInt(2));
				ord.setShopId(rs.getInt(3));
				ord.setOrderId(rs.getString(4));
				ord.setUserName(rs.getString(5));
				ord.setEmail(rs.getString(6));
				ord.setAddress(rs.getString(7));
				ord.setPhno(rs.getString(8));
				ord.setCategorie(rs.getString(9));
				ord.setPetName(rs.getString(10));
				ord.setPrice(rs.getDouble(11));
				ord.setPaymentType(rs.getString(12));
				ord.setStatus(rs.getString(13));
				ord.setDate(rs.getString(14));
				list.add(ord);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public OrderDtls getOrderById(int id) {
		OrderDtls ord = null;
		try {
			String sql = "select * from pet_order where id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ord = new OrderDtls();
				ord.setId(rs.getInt(1));
				ord.setUserId(rs.getInt(2));
				ord.setShopId(rs.getInt(3));
				ord.setOrderId(rs.getString(4));
				ord.setUserName(rs.getString(5));
				ord.setEmail(rs.getString(6));
				ord.setAddress(rs.getString(7));
				ord.setPhno(rs.getString(8));
				ord.setCategorie(rs.getString(9));
				ord.setPetName(rs.getString(10));
				ord.setPrice(rs.getDouble(11));
				ord.setPaymentType(rs.getString(12));
				ord.setStatus(rs.getString(13));
				ord.setDate(rs.getString(14));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ord;
	}

	public boolean deleteuser(int uid) {
		boolean f = false;
		try {
			String sql = "delete from pet_order where uid=?";
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

	public boolean updateStatus(String st, int id) {
		boolean f = false;
		try {

			String sql = "update pet_order set status=? where id=?";
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
