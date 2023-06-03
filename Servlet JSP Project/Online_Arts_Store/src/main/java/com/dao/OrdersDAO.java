package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.entity.Orders;

public class OrdersDAO {
	private Connection conn;

	public OrdersDAO(Connection conn) {
		super();
		this.conn = conn;
	}

	public boolean addOrder(List<Orders> list) {
		boolean f = false;
		try {
			String sql = "insert into orders(order_id,paint_id,user_id,quantity,total_amt,payment_type,art_id) values(?,?,?,?,?,?,?)";
			conn.setAutoCommit(false);
			PreparedStatement ps = conn.prepareStatement(sql);

			for (Orders o : list) {
				ps.setString(1, o.getOrderId());
				ps.setInt(2, o.getPaintId());
				ps.setInt(3, o.getUserId());
				ps.setInt(4, o.getQuantity());
				ps.setString(5, o.getTotalAmount());
				ps.setString(6, o.getPaymentType());
				ps.setInt(7, o.getArt_id());

				ps.addBatch();
			}

			ps.executeBatch();
			conn.commit();
			f = true;
			conn.setAutoCommit(true);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return f;
	}

	public List<Orders> getOrdersByUser(int uid) {
		List<Orders> list = new ArrayList<Orders>();
		Orders order = null;
		try {
			String sql = "select * from orders where user_id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, uid);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				order = new Orders();
				order.setId(rs.getInt(1));
				order.setOrderId(rs.getString(2));
				order.setPaintId(rs.getInt(3));
				order.setUserId(rs.getInt(4));
				order.setQuantity(rs.getInt(5));
				order.setTotalAmount(rs.getString(6));
				order.setPaymentType(rs.getString(7));
				list.add(order);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	
	public List<Orders> getOrdersByArtist(int artId) {
		List<Orders> list = new ArrayList<Orders>();
		Orders order = null;
		try {
			String sql = "select * from orders where art_id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, artId);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				order = new Orders();
				order.setId(rs.getInt(1));
				order.setOrderId(rs.getString(2));
				order.setPaintId(rs.getInt(3));
				order.setUserId(rs.getInt(4));
				order.setQuantity(rs.getInt(5));
				order.setTotalAmount(rs.getString(6));
				order.setPaymentType(rs.getString(7));
				list.add(order);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	

}
