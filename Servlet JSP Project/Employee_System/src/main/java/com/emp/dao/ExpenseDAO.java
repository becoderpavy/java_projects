package com.emp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.emp.entity.Attendance;
import com.emp.entity.Expenses;

public class ExpenseDAO {
	private Connection conn;

	public ExpenseDAO(Connection conn) {
		super();
		this.conn = conn;
	}

	public boolean addExpense(Expenses e) {
		boolean f = false;

		try {
			String sql = "insert into expense(account_name,expense_type,description,milestone,exp_date,amount,docu_name,userid,status) values(?,?,?,?,?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, e.getAccountName());
			ps.setString(2, e.getExpenseType());
			ps.setString(3, e.getDescription());
			ps.setString(4, e.getMilestone());
			ps.setString(5, e.getExpenseDate());
			ps.setDouble(6, e.getAmount());
			ps.setString(7, e.getDocumentName());
			ps.setInt(8, e.getUserid());
			ps.setString(9, e.getStatus());

			int i = ps.executeUpdate();
			if (i == 1) {
				f = true;
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return f;
	}

	public List<Expenses> getAllExpense() {
		List<Expenses> list = new ArrayList<Expenses>();
		Expenses a = new Expenses();

		try {
			String sql = "select * from expense order by id desc ";
			PreparedStatement ps = conn.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				a = new Expenses();
				a.setId(rs.getInt(1));
				a.setAccountName(rs.getString(2));
				a.setExpenseType(rs.getString(3));
				a.setDescription(rs.getString(4));
				a.setMilestone(rs.getString(5));
				a.setExpenseDate(rs.getString(6));
				a.setAmount(rs.getDouble(7));
				a.setDocumentName(rs.getString(8));
				a.setUserid(rs.getInt(9));
				a.setStatus(rs.getString(10));
				list.add(a);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}
	
	
	public List<Expenses> getAllExpenseById(int uid) {
		List<Expenses> list = new ArrayList<Expenses>();
		Expenses a = new Expenses();

		try {
			String sql = "select * from expense where userid=? order by id desc ";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, uid);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				a = new Expenses();
				a.setId(rs.getInt(1));
				a.setAccountName(rs.getString(2));
				a.setExpenseType(rs.getString(3));
				a.setDescription(rs.getString(4));
				a.setMilestone(rs.getString(5));
				a.setExpenseDate(rs.getString(6));
				a.setAmount(rs.getDouble(7));
				a.setDocumentName(rs.getString(8));
				a.setUserid(rs.getInt(9));
				a.setStatus(rs.getString(10));
				list.add(a);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}
	
	public boolean updateStatus(int id, int uid,String st) {
		boolean f = false;

		try {
			String sql = "update expense set status=? where id=? and userid=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, st);
			ps.setInt(2, id);
			ps.setInt(3, uid);
			int i = ps.executeUpdate();
			if (i == 1) {
				f = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}
	
	public void deleteData(int uid) {
		try {
			String sql = "delete from expense where userid=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, uid);
			int i = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
