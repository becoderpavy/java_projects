package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.entity.Student;

public class RegisterDAO {

	private Connection conn;

	public RegisterDAO(Connection conn) {
		super();
		this.conn = conn;
	}

	public boolean StudentRegister(Student st) {
		boolean f = false;
		try {
			String sql = "insert into student(name,email,dob,address,phno,gender,password) values(?,?,?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, st.getName());
			ps.setString(2, st.getEmail());
			ps.setString(3, st.getDob());
			ps.setString(4, st.getAdress());
			ps.setString(5, st.getPhno());
			ps.setString(6, st.getGender());
			ps.setString(7, st.getPassword());

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
