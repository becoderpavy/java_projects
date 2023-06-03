package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.entity.City;
import com.entity.Country;
import com.entity.State;

public class CountyDAO {
	private Connection con;
	PreparedStatement pst;
	String query;
	ResultSet rs;

	public CountyDAO(Connection conn) {
		super();
		this.con = conn;
	}

	public List<Country> getAllCountry() {
		List<Country> list = new ArrayList();
		try {
			query = "select * from country";
			pst = con.prepareStatement(query);
			rs = pst.executeQuery();
			while (rs.next()) {
				Country country = new Country();
				country.setId(rs.getInt(1));
				country.setName(rs.getString(2));
				list.add(country);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<State> getStateByCountryId(int countryId) {
		List<State> list = new ArrayList();
		try {
			query = "select * from state where countryId=?";
			pst = this.con.prepareStatement(query);
			pst.setInt(1, countryId);
			rs = pst.executeQuery();
			while (rs.next()) {
				State state = new State();
				state.setId(rs.getInt(1));
				state.setCountryId(rs.getInt(2));
				state.setName(rs.getString(3));
				list.add(state);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<City> getCityByStateId(int stateId) {
		List<City> list = new ArrayList();
		try {
			query = "select * from city where stateId=?";
			pst = this.con.prepareStatement(query);
			pst.setInt(1, stateId);
			rs = pst.executeQuery();
			while (rs.next()) {
				City city = new City();
				city.setId(rs.getInt(1));
				city.setCountryId(rs.getInt(2));
				city.setStateId(rs.getInt(3));
				city.setName(rs.getString(4));
				list.add(city);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
}
