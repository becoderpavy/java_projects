package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.entity.AccountTransaction;
import com.entity.User;

public class AdminDAOImpl implements AdminDAO {

	private Connection conn;

	public AdminDAOImpl(Connection conn) {
		super();
		this.conn = conn;
	}

	public List<User> findByStatus() {
		List<User> list = new ArrayList<User>();
		User us = null;
		try {
			String sql = "select * from user where status=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, "inactive");

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				us = new User();
				us.setAccountNo(rs.getString("account_no"));
				us.setFirstName(rs.getString("first_name"));
				us.setLastName(rs.getString("last_name"));
				us.setEmail(rs.getString("email"));
				us.setNumber(rs.getString("phno"));
				list.add(us);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public boolean updateStatus(String accno) {
		boolean f = false;
		try {
			String sql = "update user set status=? where account_no=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, "active");
			ps.setString(2, accno);
			int i = ps.executeUpdate();
			if (i == 1) {
				f = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	public boolean setBalance(String accno, Double bal) {
		boolean f = false;
		try {
			String sql = "insert into acc_balance(accno,total_balance) values(?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, accno);
			ps.setDouble(2, bal);
			int i = ps.executeUpdate();
			if (i == 1) {
				f = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return f;
	}

	public boolean createAccnt(User us) {
		boolean f = false;
		Random rand = new Random();
		int acnum = rand.nextInt(10000);
		try {
			String qu = "insert into user(account_no,status,first_name,last_name,email,phno,dob,adhar_no,address,city,state,zip) values(?,?,?,?,?,?,?,?,?,?,?,?)";

			PreparedStatement ps = conn.prepareStatement(qu);
			ps.setString(1, "33196" + acnum);
			ps.setString(2, "active");
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

			int i = ps.executeUpdate();

			if (i == 1)
				f = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	public List<User> allAccount() {
		List<User> list = new ArrayList<User>();
		User us = null;
		try {
			String sql = "select * from user";
			PreparedStatement ps = conn.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				us = new User();
				us.setAccountNo(rs.getString("account_no"));
				us.setStatus(rs.getString("status"));
				us.setFirstName(rs.getString("first_name"));
				us.setLastName(rs.getString("last_name"));
				us.setEmail(rs.getString("email"));
				us.setNumber(rs.getString("phno"));
				list.add(us);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public User findByAccount(String accno) {

		User us = null;
		try {
			String sql = "select * from user where account_no=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, accno);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				us = new User();
				us.setAccountNo(rs.getString("account_no"));
				us.setStatus(rs.getString("status"));
				us.setFirstName(rs.getString("first_name"));
				us.setLastName(rs.getString("last_name"));
				us.setEmail(rs.getString("email"));
				us.setNumber(rs.getString("phno"));

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return us;
	}

	public boolean addTransaction(AccountTransaction trans) {
		boolean f = false;
		try {
			String sql = "insert into acc_transaction(acc_no,trans_type,trans_dtls,balance,trans_date,trans_time) values(?,?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, trans.getAccno());
			ps.setString(2, trans.getTransType());
			ps.setString(3, trans.getTransDtls());
			ps.setDouble(4, trans.getBalance());
			ps.setString(5, trans.getTransDate());
			ps.setString(6, trans.getTransTime());

			int i = ps.executeUpdate();
			if (i == 1) {
				f = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	public boolean updateBalance(String acc, Double totalbal) {
		boolean f = false;
		try {
			String sql = "update acc_balance set total_balance=? where accno=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setDouble(1, totalbal);
			ps.setString(2, acc);
			int i = ps.executeUpdate();
			if (i == 1) {
				f = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	public List<AccountTransaction> getAllTrans() {
		List<AccountTransaction> list = new ArrayList<AccountTransaction>();
		AccountTransaction trans = null;
		try {
			String sql = "select * from acc_transaction order by id DESC  ";
			PreparedStatement ps = conn.prepareStatement(sql);
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

	public boolean findSenderAccount(String accno) {
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

	public List<AccountTransaction> getTransByAccnt(String accno) {
		List<AccountTransaction> list = new ArrayList<AccountTransaction>();
		AccountTransaction trans = null;
		try {
			String sql = "select * from acc_transaction where acc_no=? order by id DESC";
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

	public User getUserByAccont(String accno) {
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

	public boolean editUserAccount(User us) {
		boolean f = false;
		try {
			String qu = "update user set status=?,first_name=?,last_name=?,email=?,phno=?,dob=?,adhar_no=?,address=?,city=?,state=?,username=? where account_no=?";

			PreparedStatement ps = conn.prepareStatement(qu);

			ps.setString(1, us.getStatus());
			ps.setString(2, us.getFirstName());
			ps.setString(3, us.getLastName());
			ps.setString(4, us.getEmail());
			ps.setString(5, us.getNumber());
			ps.setString(6, us.getDob());
			ps.setString(7, us.getAdhar());
			ps.setString(8, us.getAddress());
			ps.setString(9, us.getCity());
			ps.setString(10, us.getState());
			ps.setString(11, us.getUserid());
			ps.setString(12, us.getAccountNo());

			int i = ps.executeUpdate();

			if (i == 1)
				f = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	public boolean deleteAcc(String acc) {
		boolean f = false;

		try {
			String sql="delete from user where account_no=?";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1,acc);
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

}
