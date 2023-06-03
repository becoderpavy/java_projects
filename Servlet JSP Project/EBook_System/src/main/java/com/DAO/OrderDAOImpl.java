package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.entity.orderDtls;

public class OrderDAOImpl implements OrderDAO {

	private Connection conn;

	public OrderDAOImpl(Connection conn) {
		super();
		this.conn = conn;
	}

	public boolean orderSave(List<orderDtls> ord) {
		boolean f = false;
		try {
			String sql = "insert into book_order(order_id,user_name,email,address,phone,book_name,author,price,payment) values(?,?,?,?,?,?,?,?,?)";

//			System.out.println(order.getOrderId()+" "+order.getUserName()+" "+order.getEmail()+" "+
//					order.getAddress()+" "+order.getPhoneNo()+" "+order.getBookName()+" "+
//					order.getBookAuthor()+" "+order.getPrice()+" "+order.getPaymentType()
//					);

			conn.setAutoCommit(false);
			PreparedStatement ps = conn.prepareStatement(sql);

			for (orderDtls order : ord) {
				ps.setString(1, order.getOrderId());
				ps.setString(2, order.getUserName());
				ps.setString(3, order.getEmail());
				ps.setString(4, order.getAddress());
				ps.setString(5, order.getPhoneNo());
				ps.setString(6, order.getBookName());
				ps.setString(7, order.getBookAuthor());
				ps.setInt(8, order.getPrice());
				ps.setString(9, order.getPaymentType());

				// add batch
				ps.addBatch();
			}

			// execute batch
			int[] updateCounts = ps.executeBatch();
			conn.commit();
			f=true;
			conn.setAutoCommit(true);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return f;
	}

	public List<orderDtls> getOrder(String email) {
		List<orderDtls> list = new ArrayList<orderDtls>();
		orderDtls order = null;
		try {
			String sql = "select * from book_order where email=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1,email);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				order = new orderDtls();
				order.setId(rs.getInt(1));
				order.setOrderId(rs.getString(2));
				order.setUserName(rs.getString(3));
				order.setEmail(rs.getString(4));
				order.setAddress(rs.getString(5));
				order.setPhoneNo(rs.getString(6));
				order.setBookName(rs.getString(7));
				order.setBookAuthor(rs.getString(8));
				order.setPrice(rs.getInt(9));
				order.setPaymentType(rs.getString(10));

				list.add(order);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<orderDtls> getAllOrder() {
		List<orderDtls> list = new ArrayList<orderDtls>();
		orderDtls order = null;
		try {
			String sql = "select * from book_order";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				order = new orderDtls();
				order.setId(rs.getInt(1));
				order.setOrderId(rs.getString(2));
				order.setUserName(rs.getString(3));
				order.setEmail(rs.getString(4));
				order.setAddress(rs.getString(5));
				order.setPhoneNo(rs.getString(6));
				order.setBookName(rs.getString(7));
				order.setBookAuthor(rs.getString(8));
				order.setPrice(rs.getInt(9));
				order.setPaymentType(rs.getString(10));

				list.add(order);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public int getTotalOrderNo() {
		int i = 0;
		try {
			String sql = "select * from book_order";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				i++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return i;
	}
	
}
