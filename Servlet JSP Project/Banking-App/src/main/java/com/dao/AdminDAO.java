package com.dao;

import java.util.List;

import com.entity.AccountTransaction;
import com.entity.User;

public interface AdminDAO {
	public List<User> findByStatus();

	public boolean updateStatus(String accno);

	public boolean setBalance(String accno, Double bal);

	public boolean createAccnt(User us);

	public List<User> allAccount();

	public User findByAccount(String accno);

	public boolean addTransaction(AccountTransaction trans);

	public boolean updateBalance(String acc, Double totalbal);

	public List<AccountTransaction> getAllTrans();

	public boolean findSenderAccount(String accno);

	public List<AccountTransaction> getTransByAccnt(String accno);

	public User getUserByAccont(String accno);

	public boolean editUserAccount(User us);
	
	public boolean  deleteAcc(String acc);

}
