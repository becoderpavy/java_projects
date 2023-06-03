package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.entity.AccountTransaction;
import com.entity.User;

public class UserDAOImpl implements UserDAO {
	private Connection conn;

	public UserDAOImpl(Connection conn) {
		super();
		this.conn = conn;
	}

	public boolean createAccount(User us) {
		boolean f = false;
		Random rand = new Random();
		int acnum = rand.nextInt(10000);
		try {
			String qu = "insert into user(account_no,status,first_name,last_name,email,phno,dob,adhar_no,address,city,state,zip) values(?,?,?,?,?,?,?,?,?,?,?,?)";

			PreparedStatement ps = conn.prepareStatement(qu);
			ps.setString(1, "33196" + acnum);
			ps.setString(2, "inactive");
			ps.setString(3, us.getFirstName());
			ps.setString(4, us.getLastName());
			ps.setString(5, us.getEmail());
			ps.setString(6, us.getNumber());
			ps.setString(7, us.getDob());
			ps.setString(8, us.getAdhar());
			ps.setString(9, us.getAddress());
			ps.setString(10, us.getCity());
			ps.setString(11, us.getState());
			ps.setString(12, us.getPincode());
			/*
			 * ps.setString(13, us.getUserid()); ps.setString(14, us.getPassword());
			 */
			int i = ps.executeUpdate();

			if (i == 1)
				f = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	public boolean createNetbanking(String un, String psw, String acno) {
		boolean f = false;
		try {
			String sql = "update user set username=?,password=? where account_no=? and status=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, un);
			ps.setString(2, psw);
			ps.setString(3, acno);
			ps.setString(4, "active");
			int i = ps.executeUpdate();
			if (i == 1) {
				f = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	public boolean findAccount(String accno) {
		boolean f = false;
		try {
			String sql = "select * from user where account_no=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, accno);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				f = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	public boolean findUsername(String uname) {
		boolean f = true;
		try {
			String sql = "select * from user where username=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, uname);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				f = false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	public boolean checkStatus(String uname) {
		boolean f = true;
		try {
			String sql = "select * from user where username=? and status=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, uname);
			ps.setString(2, "inactive");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				f = false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	public User login(String un, String pw) {
		User us = null;
		try {
			String sql = "select * from user where username=? and password=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, un);
			ps.setString(2, pw);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				us = new User();
				us.setId(rs.getInt(1));
				us.setAccountNo(rs.getString(2));
				us.setStatus(rs.getString(3));
				us.setFirstName(rs.getString(4));
				us.setLastName(rs.getString(5));
				us.setEmail(rs.getString(6));
				us.setNumber(rs.getString(7));
				us.setDob(rs.getString(8));
				us.setAdhar(rs.getString(9));
				us.setAddress(rs.getString(10));
				us.setCity(rs.getString(11));
				us.setState(rs.getString(12));
				us.setPincode(rs.getString(13));
				us.setUserid(rs.getString(14));
				us.setPassword(rs.getString(15));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return us;
	}

	public boolean updatePassword(String accno, String oldPswd, String newPswd) {
		boolean f = false;
		try {
			String sql = "update user set password=? where account_no=? and password=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, newPswd);
			ps.setString(2, accno);
			ps.setString(3, oldPswd);
			int i = ps.executeUpdate();
			if (i == 1) {
				f = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	public Double checkBalance(String accno) {
		Double tbal = 0.00;
		try {
			String sql = "select total_balance from acc_balance where accno=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, accno);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				tbal = rs.getDouble("total_balance");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tbal;
	}

	public List<AccountTransaction> getAllTrans(String accno) {
		List<AccountTransaction> list = new ArrayList<AccountTransaction>();
		AccountTransaction trans = null;
		try {
			String sql = "select * from acc_transaction where acc_no=? order by id DESC  ";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, accno);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				trans = new AccountTransaction();
				trans.setId(rs.getInt(1));
				trans.setAccno(rs.getString(2));
				trans.setTransType(rs.getString(3));
				trans.setTransDtls(rs.getString(4));
				trans.setBalance(rs.getDouble(5));
				trans.setTransDate(rs.getString(6));
				trans.setTransTime(rs.getString(7));
				list.add(trans);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public User findUser(String accno) {
		User us = null;
		try {
			String sql = "select * from user where account_no=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, accno);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				us = new User();
				us.setId(rs.getInt(1));
				us.setAccountNo(rs.getString(2));
				us.setStatus(rs.getString(3));
				us.setFirstName(rs.getString(4));
				us.setLastName(rs.getString(5));
				us.setEmail(rs.getString(6));
				us.setNumber(rs.getString(7));
				us.setDob(rs.getString(8));
				us.setAdhar(rs.getString(9));
				us.setAddress(rs.getString(10));
				us.setCity(rs.getString(11));
				us.setState(rs.getString(12));
				us.setPincode(rs.getString(13));
				us.setUserid(rs.getString(14));
				us.setPassword(rs.getString(15));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return us;
	}

	public List<AccountTransaction> getAllTransByCredit(String accno) {
		List<AccountTransaction> list = new ArrayList<AccountTransaction>();
		AccountTransaction trans = null;
		try {
			String sql = "select * from acc_transaction where acc_no=? and trans_type=? order by id DESC  ";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, accno);
			ps.setString(2, "credit");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				trans = new AccountTransaction();
				trans.setId(rs.getInt(1));
				trans.setAccno(rs.getString(2));
				trans.setTransType(rs.getString(3));
				trans.setTransDtls(rs.getString(4));
				trans.setBalance(rs.getDouble(5));
				trans.setTransDate(rs.getString(6));
				trans.setTransTime(rs.getString(7));
				list.add(trans);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<AccountTransaction> getAllTransByDebit(String accno) {
		List<AccountTransaction> list = new ArrayList<AccountTransaction>();
		AccountTransaction trans = null;
		try {
			String sql = "select * from acc_transaction where acc_no=? and trans_type=? order by id DESC  ";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, accno);
			ps.setString(2, "debit");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				trans = new AccountTransaction();
				trans.setId(rs.getInt(1));
				trans.setAccno(rs.getString(2));
				trans.setTransType(rs.getString(3));
				trans.setTransDtls(rs.getString(4));
				trans.setBalance(rs.getDouble(5));
				trans.setTransDate(rs.getString(6));
				trans.setTransTime(rs.getString(7));
				list.add(trans);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public User checkUsernameAndAccno(String accno, String uname) {
		User us = null;
		try {
			String sql = "select * from user where account_no=? and username=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, accno);
			ps.setString(2, uname);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				us = new User();
				us.setFirstName(rs.getString("first_name"));
				us.setLastName(rs.getString("last_name"));
				us.setPassword(rs.getString("password"));
				us.setEmail(rs.getString("email"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return us;
	}

}