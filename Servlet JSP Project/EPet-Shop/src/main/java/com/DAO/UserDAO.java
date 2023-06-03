package com.DAO;

import java.util.List;

import com.entity.UserDtls;

public interface UserDAO {

	public boolean userRegister(UserDtls us);

	public UserDtls login(String email, String password);

	public List<UserDtls> getAllUser();

	public boolean checkPassword(int id, String ps);

	public boolean updateProfile(UserDtls us);

	public boolean checkUser(String em);
	
	public boolean passwordChange(int id,String ps);

}
