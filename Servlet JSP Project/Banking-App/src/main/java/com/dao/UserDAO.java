package com.dao;

import java.util.List;

import com.entity.AccountTransaction;
import com.entity.User;

public interface UserDAO {
	public boolean createAccount(User us);

	public boolean createNetbanking(String un, String psw, String acno);

	public boolean findAccount(String accno);

	public boolean findUsername(String un);

	public boolean checkStatus(String uname);

	public User login(String un, String pw);

	public boolean updatePassword(String accno, String oldPswd, String newPswd);

	public Double checkBalance(String accno);

	public List<AccountTransaction> getAllTrans(String accno);

	public List<AccountTransaction> getAllTransByCredit(String accno);

	public List<AccountTransaction> getAllTransByDebit(String accno);

	public User findUser(String accno);

	public User checkUsernameAndAccno(String accno,String email);

}
