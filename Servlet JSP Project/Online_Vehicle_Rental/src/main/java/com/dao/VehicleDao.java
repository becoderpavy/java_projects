package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.entites.Vehicle;

public class VehicleDao {
	private Connection conn;

	private PreparedStatement ps;

	private ResultSet rs;

	public VehicleDao(Connection conn) {
		super();
		this.conn = conn;
	}

	public boolean createVehicle(Vehicle v) {
		boolean f = false;
		try {
			String sql = "insert into vehicle(title,vehicleNumber,categoryId,availability,perDay,insuranceStatus,description,ownerName,contactNo,image) values(?,?,?,?,?,?,?,?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, v.getTitle());
			ps.setString(2, v.getVehicleNumber());
			ps.setInt(3, v.getCategoryId());
			ps.setString(4, v.getAvailability());
			ps.setDouble(5, v.getPerDay());
			ps.setString(6, v.getInsuranceStatus());
			ps.setString(7, v.getDescription());
			ps.setString(8, v.getOwnerName());
			ps.setString(9, v.getContactNo());
			ps.setString(10, v.getImage());

			int i = ps.executeUpdate();

			if (i == 1) {
				f = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	public boolean updateVehicle(Vehicle v) {
		boolean f = false;
		try {
			String sql = "update vehicle set title=? ,vehicleNumber=?, categoryId=? ,availability=? ,perDay=?,insuranceStatus=?,description=?,ownerName=?,contactNo=?,image=? where id=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, v.getTitle());
			ps.setString(2, v.getVehicleNumber());
			ps.setInt(3, v.getCategoryId());
			ps.setString(4, v.getAvailability());
			ps.setDouble(5, v.getPerDay());
			ps.setString(6, v.getInsuranceStatus());
			ps.setString(7, v.getDescription());
			ps.setString(8, v.getOwnerName());
			ps.setString(9, v.getContactNo());
			ps.setString(10, v.getImage());
			ps.setInt(11, v.getId());

			int i = ps.executeUpdate();

			if (i == 1) {
				f = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	public boolean updateVehicleStatus(int vid, String st) {
		boolean f = false;
		try {
			String sql = "update vehicle set availability=? where id=?";
			ps = conn.prepareStatement(sql);

			ps.setString(1, st);
			ps.setInt(2, vid);

			int i = ps.executeUpdate();

			if (i == 1) {
				f = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	public boolean deleteVehicle(int id) {
		boolean f = false;
		try {
			String sql = "delete from vehicle where id=?";
			ps = conn.prepareStatement(sql);
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

	public Vehicle getVehicleById(int id) {
		Vehicle v = null;
		try {
			String sql = "select * from vehicle where id=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();

			while (rs.next()) {
				v = new Vehicle(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5),
						rs.getDouble(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10),
						rs.getString(11));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return v;
	}

	public boolean checkVehicleNumber(String vnum) {
		boolean f = false;
		try {
			String sql = "select * from vehicle where id=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, vnum);
			rs = ps.executeQuery();

			while (rs.next()) {
				f = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	public List<Vehicle> getAllVehicle() {
		List<Vehicle> list = new ArrayList<Vehicle>();
		Vehicle v = null;
		try {
			String sql = "select * from vehicle";
			ps = conn.prepareStatement(sql);

			rs = ps.executeQuery();

			while (rs.next()) {
				v = new Vehicle(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5),
						rs.getDouble(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10),
						rs.getString(11));
				list.add(v);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<Vehicle> getAllVehicleByCategory(int id) {
		List<Vehicle> list = new ArrayList<Vehicle>();
		Vehicle v = null;
		try {
			String sql = "select * from vehicle where categoryId=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);

			rs = ps.executeQuery();

			while (rs.next()) {
				v = new Vehicle(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5),
						rs.getDouble(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10),
						rs.getString(11));
				list.add(v);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public int countVehicle() {
		int i = 0;
		try {
			String sql = "select * from vehicle";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				i++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}
	
	public int countCategory() {
		int i = 0;
		try {
			String sql = "select * from category";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				i++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}
	
	public int countBooking() {
		int i = 0;
		try {
			String sql = "select * from booking";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				i++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}

}
