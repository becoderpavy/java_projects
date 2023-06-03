package com.DAO;

import com.entity.userDtls;

public interface UserDAO {
	public boolean createAccount(userDtls user);
	
	public userDtls loginUser(String email,String password);
	
	public boolean addAdress(String ad,String la,String city,String st,String pin,int id);
	
	public boolean editProfile(userDtls us);

}
