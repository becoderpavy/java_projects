package com.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.entity.UserDetails;

public class UserDAO {
	private Connection conn;

	public UserDAO(Connection conn) {
		super();
		this.conn = conn;
	}
	
	public boolean addUser(UserDetails us)
	{
		boolean f=false;
		
		try {
			String query="insert into user(name,email,password) values(?,?,?)";
			
			PreparedStatement ps=conn.prepareStatement(query);
			ps.setString(1, us.getName());
			ps.setString(2, us.getEmail());
			ps.setString(3, us.getPassword());
			int i=ps.executeUpdate();
			if(i==1)
			{
				f=true;
			}
						
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return f;
	}

	public UserDetails loginUser(UserDetails us)
	{
		UserDetails user=null;
		try {
			String query="select * from user where email=? and password=?";
			
			PreparedStatement ps=conn.prepareStatement(query);
			ps.setString(1, us.getEmail());
			ps.setString(2,us.getPassword());
			ResultSet rs=ps.executeQuery();
			
			while(rs.next())
			{
				user=new UserDetails();
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setEmail(rs.getString("email"));
				user.setPassword("password");			
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}
	
	public boolean findEmail(String em)
	{
		boolean f=true;
		try {
			String query="select * from user where email=?";
			
			PreparedStatement ps=conn.prepareStatement(query);
			ps.setString(1,em);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				f=false;		
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}
	
	
}
