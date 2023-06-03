package com.banking.service;

import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import com.banking.entity.AccountTransaction;
import com.banking.entity.UserDtls;
import com.banking.model.TransactionResponse;

public interface AccountService {

	public List<UserDtls> getAllAccount(String status);

	public String accountStatusUpdate(int id, String st);

	public String doTransactionByAdmin(AccountTransaction trans);

	public UserDtls getDetailsByAccountNo(String accountNo);

	public List<TransactionResponse> getTransactionByAccount(UserDtls user);

	public String sendMoneyUser(UserDtls recevier, Double sendAmount, HttpServletRequest request);

	public UserDtls getAccountById(int id);

	public UserDtls updateAccount(UserDtls user);

}
