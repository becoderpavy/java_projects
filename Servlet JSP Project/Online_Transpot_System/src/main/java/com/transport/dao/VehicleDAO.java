package com.transport.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.transport.entites.BookVehicle;
import com.transport.entites.Vehicle;

public class VehicleDAO {
	private Connection conn;

	private PreparedStatement ps;

	private ResultSet rs;
	int i = 0;

	public VehicleDAO(Connection conn) {
		super();
		this.conn = conn;
	}

	public boolean createVehicle(Vehicle v) {
		boolean f = false;
		try {
			String sql = "insert into vehicle(vechicleNumber,vehicleType,location,availability,insuranceStatus,description,ownerName,contactNo) values(?,?,?,?,?,?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, v.getVechicleNumber());
			ps.setString(2, v.getVehicleType());
			ps.setString(3, v.getLocation());
			ps.setString(4, v.getAvailability());
			ps.setString(5, v.getInsuranceStatus());
			ps.setString(6, v.getDescription());
			ps.setString(7, v.getOwnerName());
			ps.setString(8, v.getContactNo());

			i = ps.executeUpdate();

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
			String sql = "update vehicle set vechicleNumber=?,vehicleType=?,location=?,availability=?,insuranceStatus=?,description=?,ownerName=?,contactNo=? where id=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, v.getVechicleNumber());
			ps.setString(2, v.getVehicleType());
			ps.setString(3, v.getLocation());
			ps.setString(4, v.getAvailability());
			ps.setString(5, v.getInsuranceStatus());
			ps.setString(6, v.getDescription());
			ps.setString(7, v.getOwnerName());
			ps.setString(8, v.getContactNo());
			ps.setInt(9, v.getId());

			i = ps.executeUpdate();

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

			i = ps.executeUpdate();

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
				v = new Vehicle(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9));

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return v;
	}

	public List<Vehicle> getAllVehchicleByLocation(String location) {
		Vehicle v = null;
		List<Vehicle> list = new ArrayList<Vehicle>();
		try {
			String sql = "select * from vehicle where location=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, location);

			rs = ps.executeQuery();

			while (rs.next()) {
				v = new Vehicle(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9));
				list.add(v);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	public List<Vehicle> getAllVehchicle() {
		Vehicle v = null;
		List<Vehicle> list = new ArrayList<Vehicle>();
		try {
			String sql = "select * from vehicle";
			ps = conn.prepareStatement(sql);

			rs = ps.executeQuery();

			while (rs.next()) {
				v = new Vehicle(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9));
				list.add(v);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	public List<Vehicle> getAllVehchicleByLocationAndAvaible(String location, String av) {
		Vehicle v = null;
		List<Vehicle> list = new ArrayList<Vehicle>();
		try {
			String sql = "select * from vehicle where location=? and availability=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, location);
			ps.setString(2, av);

			rs = ps.executeQuery();

			while (rs.next()) {
				v = new Vehicle(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9));
				list.add(v);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	public boolean bookVehicle(BookVehicle bv) {
		boolean f = false;

		try {

			String sql = "insert into book_vehicle(kms,amount,date,bikeNumber,userName,location) values(?,?,?,?,?,?) ";

			ps = conn.prepareStatement(sql);

			ps.setString(1, bv.getKms());
			ps.setString(2, bv.getAmount());
			ps.setString(3, bv.getDate());
			ps.setString(4, bv.getVehicleNumber());
			ps.setString(5, bv.getUserName());
			ps.setString(6, bv.getLocation());

			int i = ps.executeUpdate();
			if (i == 1) {
				f = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	public List<BookVehicle> getBookingByUserName(String userName) {
		List<BookVehicle> list = new ArrayList<BookVehicle>();
		BookVehicle bv = null;

		try {
			String sql = "select * from book_vehicle where userName=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, userName);

			rs = ps.executeQuery();
			while (rs.next()) {
				bv = new BookVehicle(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getString(7));
				list.add(bv);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	public List<BookVehicle> getBookingByLocation(String loc) {
		List<BookVehicle> list = new ArrayList<BookVehicle>();
		BookVehicle bv = null;

		try {
			String sql = "select * from book_vehicle where location=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, loc);

			rs = ps.executeQuery();
			while (rs.next()) {
				bv = new BookVehicle(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getString(7));
				list.add(bv);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

}
