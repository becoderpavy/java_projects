package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.entites.Booking;

public class BookingDao {

	private Connection conn;

	private PreparedStatement ps;

	private ResultSet rs;

	public BookingDao(Connection conn) {
		super();
		this.conn = conn;
	}

	public boolean createBook(Booking b) {
		boolean f = false;

		try {

			String sql = "insert into booking(userId,vehicleId,fromDate,toDate,day,totalPrice,idCard,orderId,status,bookingDate) values(?,?,?,?,?,?,?,?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, b.getUserId());
			ps.setInt(2, b.getVehicleId());
			ps.setString(3, b.getFromDate());
			ps.setString(4, b.getToDate());
			ps.setString(5, b.getDay());
			ps.setDouble(6, b.getTotalPrice());
			ps.setString(7, b.getIdCard());
			ps.setString(8, b.getOrderId());
			ps.setString(9, b.getStatus());
			ps.setString(10, b.getBookingDate());
			int i = ps.executeUpdate();

			if (i == 1) {
				f = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return f;
	}

	public List<Booking> getAllBooking() {
		List<Booking> list = new ArrayList<Booking>();
		Booking b;
		try {

			String sql = "select * from booking";

			ps = conn.prepareStatement(sql);

			rs = ps.executeQuery();
			while (rs.next()) {
				b = new Booking(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getDouble(7), rs.getString(8), rs.getString(9), rs.getString(10),
						rs.getString(11));
				list.add(b);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	public List<Booking> getAllBookingByUser(int userid) {
		List<Booking> list = new ArrayList<Booking>();
		Booking b;
		try {

			String sql = "select * from booking where userId=?";

			ps = conn.prepareStatement(sql);
			ps.setInt(1, userid);

			rs = ps.executeQuery();
			while (rs.next()) {
				b = new Booking(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getDouble(7), rs.getString(8), rs.getString(9), rs.getString(10),
						rs.getString(11));
				list.add(b);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

}
