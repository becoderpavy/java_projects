package com.banking.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.banking.entity.AccountTransaction;
import com.banking.entity.UserDtls;
import com.banking.model.ChangePasswordRequest;

public interface UserService {

	public UserDtls createUser(UserDtls user);

	public UserDtls createEmp(UserDtls user);

	public boolean checkEmail(String email);

	UserDtls signInWithUserReturnJwt(UserDtls userDto);

	UserDtls checkEmailAndMob(String email, String mob);

	UserDtls resetPassword(UserDtls user);

	UserDtls createNetbanking(UserDtls user);

	boolean existUsername(String username);

	public List<UserDtls> getAllEmp();

	public List<AccountTransaction> getAllTransactionByUser(HttpServletRequest request);

	public boolean changePassword(ChangePasswordRequest passwordRequest,HttpServletRequest request);
	
	
	
}
