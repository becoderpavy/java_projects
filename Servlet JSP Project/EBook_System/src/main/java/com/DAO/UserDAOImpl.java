package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.entity.userDtls;

public class UserDAOImpl implements UserDAO {
	private Connection conn;

	public UserDAOImpl(Connection conn) {
		super();
		this.conn = conn;
	}

	public boolean createAccount(userDtls user) {
		boolean f=false;
		try {
			String sql="insert into user(name,email,phno,password,adress,landmark,city,state,zip) values(?,?,?,?,?,?,?,?,?)";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1,user.getName());
			ps.setString(2,user.getEmail());
			ps.setString(3,user.getPhno());
			ps.setString(4,user.getPassword());
			ps.setString(5,"Enter Address");
			ps.setString(6,"Locality ");
			ps.setString(7,"City");
			ps.setString(8,"State");
			ps.setString(9,"Pin Code");
			int i=ps.executeUpdate();
			if(i==1)
				f=true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	public userDtls loginUser(String email, String password) {	
		userDtls user=null;
		try {
			String sql="select * from user where email=? and password=?";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, email);
			ps.setString(2,password);
			ResultSet rs=ps.executeQuery();
			
			if(rs.next())
			{
				user=new userDtls();
				user.setId(rs.getInt(1));
				user.setName(rs.getString(2));
				user.setEmail(rs.getString(3));
				user.setPhno(rs.getString(4));
				user.setPassword(rs.getString(5));
				user.setAdress(rs.getString(6));
				user.setLandmark(rs.getString(7));
				user.setCity(rs.getString(8));
				user.setState(rs.getString(9));
				user.setZip(rs.getString(10));
			}		
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return user;
	}

	public boolean addAdress(String ad, String la, String city, String st, String pin,int id) {
		boolean f=false;
		try {
			String sql="update user set adress=?,landmark=?,city=?,state=?,zip=? where id=?";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1,ad);
			ps.setString(2,la);
			ps.setString(3,city);
			ps.setString(4,st);
			ps.setString(5,pin);
			ps.setInt(6,id);
			int i=ps.executeUpdate();
			if(i==1)
				f=true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	public boolean editProfile(userDtls us) {
		boolean f=false;
		try {
			String sql="update user set name=?,email=?,phno=? where id=? and password=?";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1,us.getName());
			ps.setString(2,us.getEmail());
			ps.setString(3,us.getPhno());
			ps.setInt(4,us.getId());
			ps.setString(5,us.getPassword());
			int i=ps.executeUpdate();
			if(i==1)
				f=true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}
	
	
	
	

}
